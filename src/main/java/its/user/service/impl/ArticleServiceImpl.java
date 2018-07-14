package its.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.ArticleDao;
import its.user.dao.AuthDao;
import its.user.dao.CommentDao;
import its.user.dao.MessageDao;
import its.user.dao.UserDao;
import its.user.entity.Article;
import its.user.entity.Auth;
import its.user.entity.Comment;
import its.user.entity.Message;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.ArticleService;
import its.user.tools.BBSCheckUtil;
import its.user.tools.ItsConstants;
import its.user.web.PageObject;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleDao articleDao;
	@Resource
	private CommentDao commentDao;
	@Resource
	private UserDao userDao;
	@Resource
	private MessageDao messageDao;
	@Resource
	private AuthDao authDao;
	@Override
	public void save(Article article,User user) throws Exception {
		if(article.getTitle().length()<10) {
			throw new ServiceException("提示：标题应为10-50字！");
		}
		int length=article.getContent().getBytes().length;
		if(length<255 || length>10240) {
			throw new ServiceException("提示：内容应在255-10240字节之间,本文长度["+length+"],请检查后重试！");
		}
		//恶意发帖，扣除积分，消息通知。
		Article a=articleDao.findNewByUserId(user.getId());
		if(a !=null) {
			if(BBSCheckUtil.checkPostInterval(a.getCreatedTime())) {		
				Message message=new Message();
				message.setCreatedUser("admin");
				message.setUser(user.getUsername());
				message.setType(0);
				message.setTitle(user.getUsername()+ItsConstants.MSG_T_CHECKPOST);
				message.setContent(user.getUsername()+ItsConstants.MSG_C_CHECKPOST);
				if(user.getIntegral()!=0) {
					if(user.getIntegral()<10) {
						userDao.updateIntegral(user.getUsername(), -user.getIntegral());
					}else{
						userDao.updateIntegral(user.getUsername(), -10);
					}	
					messageDao.insertMsg(message);
					throw new ServiceException("警告：5分钟内重复发帖，被视为恶意发帖！积分-10");
				}		
			}		
		}	
		article.setCreatedUser(user.getUsername());
		article.setModifiedUser(user.getUsername());
		int count=articleDao.save(article);
		if(count==0) throw new ServiceException("系统繁忙，请稍后重试！");
		userDao.updateIntegral(user.getUsername(), 5);//发表话题积分+5
	}
	@Override
	public Map<String, Object> doGetPage(int type,int pageNo,String key) throws Exception {		
		int count = type==0 ? articleDao.findHotWeekCount()//周热门总数
				: type==1 ?articleDao.findNewestCount()//全部话题
				: articleDao.findSearchCount(key);//标题名称模糊查询总数
		Map<String,Object> map=new HashMap<String,Object>();
		PageObject page=new PageObject();		
		page.setRowCount(count);
		//分页计算起始位置  页大小*（页码-1）+1    
		page.setStartIndex(page.getPageSize()*(pageNo-1));
		page.setPageCurrent(pageNo);
		List<Article> content=type==0 ?
				articleDao.findHotWeek(page.getStartIndex(), page.getPageSize())
			    :type==1 ? articleDao.findNewest(page.getStartIndex(), page.getPageSize())		
			    :articleDao.findSearch(page.getStartIndex(), page.getPageSize(), key);
		
		List<String> replyCount=new ArrayList<String>();
		List<String> valid=new ArrayList<String>();
		for(Article a:content) {
			replyCount.add(commentDao.findMainCount(a.getId())+"");
			valid.add(userDao.findByUsername(a.getCreatedUser()).get(0).getValid()+"");
		}
		map.put("pageCount", page.getPageCount());
		map.put("page", page);
		map.put("content",content);
		map.put("replyCount",replyCount);
		map.put("valid", valid);
		return map;
	}
	@Override
	public Map<String, Object> doTDetail(int id) throws Exception {		
		Map<String,Object> map=new HashMap<String,Object>();
		Article a=articleDao.findById(id);
		if(null ==a) throw new ServiceException("话题不存在！");
		String valid=userDao.findByUsername(a.getCreatedUser()).get(0).getValid()+"";
		int count=commentDao.findMainCount(id);
		List<Comment> c=commentDao.findMainById(id);
		
		List<Integer> subCount=new ArrayList<Integer>();
		List<List<Comment>> subreplys=new ArrayList<List<Comment>>();
		List<String> parentValid=new ArrayList<String>();
		List<List<String>> subValids=new ArrayList<List<String>>();		
		for(Comment c1:c) {
			subCount.add(commentDao.findSubCount(c1.getId()));
			subreplys.add(commentDao.findSubById(c1.getId()));
			parentValid.add(userDao.findByUsername(c1.getCreatedUser()).get(0).getValid()+"");
			List<String> subValid=new ArrayList<String>();
			for(Comment c2:commentDao.findSubById(c1.getId())) {
				subValid.add(userDao.findByUsername(c2.getCreatedUser()).get(0).getValid()+"");
			}
			subValids.add(subValid);
		}
		map.put("content", a);
		map.put("valid", valid);
		map.put("replyCount",count);
		map.put("reply", c);
		map.put("subCount", subCount);
		map.put("subreply", subreplys);
		map.put("parentValid", parentValid);
		map.put("subValids", subValids);
		articleDao.updateTotalVisits(id);
		return map;
	}
	@Override
	public Map<String, Object> getOwnTopicPage(int id, int pageNo) {
		PageObject page=new PageObject();
		page.setStartIndex(page.getPageSize()*(pageNo-1));
		page.setPageCurrent(pageNo);
		page.setRowCount(articleDao.findByUserIdCount(id));
		List<Article> list=articleDao.findByUserId(page.getStartIndex(), page.getPageSize(), id);	
		List<String> count=new ArrayList<String>();
		for (Article a:list) {
			count.add(commentDao.findMainCount(a.getId())+"");
		}
		User user=userDao.findById(id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageCount", page.getPageCount());
		map.put("content", list);
		map.put("replyCount", count);
		map.put("user", user);
		map.put("page", page);
		if(user.getValid()==2) {
			Auth auth=authDao.findByUsername(user.getUsername());
			map.put("auth", auth);
		}else {
			map.put("auth", "");
		}
		return map;
	}
	@Override
	public void delete(int id) {
		articleDao.delete(id);	
	}
	@Override
	public Article getEditPage(int id) {		
		return articleDao.findById(id);
	}
	@Override
	public void update(Article article,User user)throws Exception {
		if(article.getTitle().length()<10) {
			throw new ServiceException("提示：标题应为10-50字！");
		}
		int length=article.getContent().getBytes().length;
		if(length<255 || length>10240) {
			throw new ServiceException("提示：内容应在255-10240字节之间,本文长度["+length+"],请检查后重试！");
		}
		article.setModifiedUser(user.getUsername());
		articleDao.update(article);
	}
}
