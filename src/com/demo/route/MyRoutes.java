package com.demo.route;
import com.demo.controller.CommonController;
import com.demo.controller.IndexController;
import com.demo.controller.TestController;
import com.demo.controller.UserController;
import com.jfinal.config.Routes;

public class MyRoutes extends Routes {
	/**
	 * 刘磊移动端专用
	 */
	@Override
	public void config() {
		super.add("/", CommonController.class, "/index");	// 第三个参数为该Controller的视图存放路径
		super.add("/index",IndexController.class);
		super.add("/test",TestController.class);
		super.add("/user",UserController.class);
	}

}
