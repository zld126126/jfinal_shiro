package com.demo.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	
	private static final long serialVersionUID = 1L;
	public static final User dao = new User();
	
	public User getByName(String name) {
		return User.dao.findFirst("select * from sec_users where username=?", name);
	}
	
	/**
	 * 根据用户ID查询该用户所拥有的权限列表
	 * @param userId
	 */
	public List<String> getAuthoritiesName(Integer userId) {
		String sql = "select distinct a.authname from sec_users u left outer join sec_roles_users ru on u.id=ru.userid left outer join sec_roles r on ru.roleid=r.id left outer join sec_roles_auths ra on r.id = ra.roleid left outer join sec_auths a on ra.authid = a.id where u.id=?";
		return Db.query(sql, userId);
	}
	
	/**
	 * 根据用户ID查询该用户所拥有的角色列表
	 * @param userId
	 */
	public List<String> getRolesName(Integer userId) {
		String sql = "select r.rolename from sec_users u left outer join sec_roles_users ru on u.id=ru.userid left outer join sec_roles r on ru.roleid=r.id where u.id=?";
		return Db.query(sql, userId);
	}
	
}
