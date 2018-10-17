package com.demo.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Authority extends Model<Authority> {
	
	private static final long serialVersionUID = 1L;
	public static final Authority dao = new Authority();
	
	public List<Authority> getWithAuthAll() {
		return Authority.dao.find("select authname,authurl from sec_auths");
	}
}
