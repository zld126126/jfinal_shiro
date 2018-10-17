package com.demo.shiro;

import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.model.Authority;
import com.jfinal.plugin.IPlugin;

public class ShiroPlugin implements IPlugin {
	
	private static Logger log = LoggerFactory.getLogger(ShiroPlugin.class);
	public static final String PREMISSION_FORMAT = "perms[{0}]";
	private static FilterChainManager manager = null;
	
	@Override
	public boolean start() {
		if(manager == null) return false;
		List<Authority> auths = Authority.dao.getWithAuthAll();
		for(Authority auth : auths) {
			String url = auth.getStr("authurl");
			String authority = auth.getStr("authname");
			if(StringUtils.isEmpty(url)) {
				continue;
			}
			createChain(manager, url, authority);
		}
		return true;
	}

	@Override
	public boolean stop() {
		return true;
	}
	
	private void createChain(FilterChainManager manager, String key, String value) {
	    log.info("add authority url[url=" + key + " - value=" + value + "]");
	    manager.createChain(key, MessageFormat.format(PREMISSION_FORMAT, value));
	}

	public static void setFilterChainManager(FilterChainManager manager) {
		ShiroPlugin.manager = manager;
	}
}
