package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Auth;

public interface AuthDao {
	
	public void save(Auth auth);
	
	public Auth findByUsername(@Param("username") String username);
	
	public List<Auth> search(
			@Param("search") String search,
			@Param("start") int start,
			@Param("size") int size);
	public int searchCount(@Param("search") String search);
}
