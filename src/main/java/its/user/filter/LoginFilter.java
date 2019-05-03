package its.user.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;
  
public class LoginFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.err.println(request.getRequestURL());
        // 如果session中不存在登录者实体，则弹出框提示重新登录  
        // 设置request和response的字符集，防止乱码 
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8"); 
        response.setContentType("text/html;charset=utf-8");
		Properties prop=new Properties();
		prop.load(LoginFilter.class.getClassLoader().getResourceAsStream("login-filter.properties"));
		String loginFilter=prop.getProperty("notFilter");
		prop=null;//释放资源
		// 不过滤的uri  
        String[] notFilter = loginFilter.split(",");          
        // 请求的uri  
        String requestURI = request.getRequestURI();
        String uri=requestURI.substring(requestURI.lastIndexOf("/")+1);
        System.out.println("Request："+uri);
        if(uri.indexOf(".do")>0) {
        	boolean doFilter = true;  
            for (String s : notFilter) {  
                if (uri.indexOf(s) != -1) {  
                    // 如果uri中包含不过滤的uri，则不进行过滤  
                    doFilter = false;  
                    break;  
                }  
            } 
            // 从session中获取登录者实体
            HttpSession session=request.getSession();
            Object obj = session.getAttribute("its_user");
            if (doFilter) {  
                // 执行过滤       
                if (null == obj) {     
                	
                	 PrintWriter out = response.getWriter();  
                     String loginPage = "indexUI.do";  
                     StringBuilder builder = new StringBuilder();  
                     builder.append("<script type=\"text/javascript\">");  
                     builder.append("alert('当前未登录或网页过期，请重新登录！');");  
                     builder.append("window.location.href='");  
                     builder.append(loginPage);  
                     builder.append("';");  
                     builder.append("</script>");  
                     out.print(builder.toString());  
                } else {  
                    // 如果session中存在登录者实体，则继续 
                    filterChain.doFilter(request, response);  
                }  
            } else {  
                // 如果不执行过滤，则继续  
                filterChain.doFilter(request, response);  
            }  
        }else {
        	 filterChain.doFilter(request, response); 
        }
    	
    }	
}  