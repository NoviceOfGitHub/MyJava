package com.whm.First_SpringBoot_M3.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whm.First_SpringBoot_M3.Service.UserService;
import com.whm.First_SpringBoot_M3.entity.Users;


//返回结果json，视图解释器不起作用
@Controller
@RequestMapping("/Users")
public class UserController {
	@Autowired
	private UserService userservice;
	
    //页面跳转
	@RequestMapping("/info")
    public String info(){         
        return "info";     
    }
	@RequestMapping("/index")
	public String index(){
		return "index";
	}


	
	//展示所有的user
	@RequestMapping("/showallusers")
	@ResponseBody
	public List<Users> showallusers() {
		System.out.println("showallusers");
		List<Users> list=userservice.FindAll();
		return list;
	}
	//返现使用	@ResponseBody。可以做测试数据，看浏览器是否有相应的json数据
	@RequestMapping("/getalluser")
	@ResponseBody
	public Map getalluser(HttpServletRequest request){
    	int page =Integer.parseInt(request.getParameter("page"));
		int pagesize=Integer.parseInt(request.getParameter("rows"));
		System.out.println("1"+page);
		System.out.println("2"+pagesize);
		int startRecord=(page-1)*pagesize+1;
		int total =userservice.getstunumber();
		List<Users> userList=userservice.stuinfo(startRecord,pagesize);
		 Map resultMap=new HashMap();
		 resultMap.put("total", total-1);
		 resultMap.put("rows",userList);
	     return resultMap;
	}
	@RequestMapping("/adduser")
	@ResponseBody
	public Map adduser(HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入");
		String username = request.getParameter("username");
		System.out.println("username"+username);
		String realname = request.getParameter("realname"); 
		String password = request.getParameter("password"); 
		String usalary = request.getParameter("usalary"); 
		System.out.println("12"+usalary);
		String  udate = request.getParameter("udate");
	    int sal = Integer.parseInt(usalary);
		Map resultMap=new HashMap();
		//System.out.println("sal"+sal);
	//批处理这里传给前段list。size();
		Users users=new Users(0, username, realname, password,sal, udate);
        if(users!=null){
		userservice.saveuser(users);
		 resultMap.put("data", "true");
	}
	else{
		 resultMap.put("data", "false");
	}
	     return resultMap;
	}
	
	@RequestMapping("updateuser")
	@ResponseBody
	public Map updateuser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入");
		String uid = request.getParameter("uid");
		 int uuid = Integer.parseInt(uid);
		String username = request.getParameter("username");
		System.out.println("username"+username);
		String realname = request.getParameter("realname"); 
		String password = request.getParameter("password"); 
		String usalary = request.getParameter("usalary"); 
		System.out.println("12"+usalary);
		String  udate = request.getParameter("udate");
	    int sal = Integer.parseInt(usalary);
		Map resultMap=new HashMap();
		//System.out.println("sal"+sal);
	//批处理这里传给前段list。size();
		Users users=new Users(uuid, username, realname, password,sal, udate);
		
		 if(users!=null){
				userservice.updateuser(users);
				 resultMap.put("data", "true");
			}
			else{
				 resultMap.put("data", "false");
			}
			     return resultMap;
	}
	@RequestMapping("deleteuser")
	@ResponseBody
	public Map deleteuser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ids = request.getParameter("ids");
		Map resultMap=new HashMap();
		System.out.println(ids);
		  List<Integer>list=new ArrayList<>();
	     String params[] = ids.split(",");//参数jie()
	for (int i = 0; i < params.length; i++) {
	             list.add(Integer.valueOf(params[i]));
	}
	            if(list.size()>0){
	            userservice.deleteByMPrimaryKey(list);
	       	          resultMap.put("data", "true");
				}
	
				else{
					 resultMap.put("data", "false");
				}
				     return resultMap;
	        }

}
