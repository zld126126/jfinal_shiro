package com.demo.controller;

import com.jfinal.core.Controller;

public class CommonController extends Controller {
	
	public void index() {
		redirect("/login");
	}

}
