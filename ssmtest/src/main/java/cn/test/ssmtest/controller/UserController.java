package cn.test.ssmtest.controller;

import cn.test.ssmtest.model.User;
import cn.test.ssmtest.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user/select")
    public ModelAndView selectUser() throws Exception{
        ModelAndView mv = new ModelAndView();
        User user = userService.selectUser(1);
        mv.addObject("user",user);
        mv.setViewName("user");
        return  mv;
    }
}
