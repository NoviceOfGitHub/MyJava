package com.whm.First_SpringBoot_M3.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//返回结果json，视图解释器不起作用
@RestController
@RequestMapping("/MyTest")
public class EController {
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello Word");
		return "Hello Word +1+2+3+3+4+4";
	}
	
}
