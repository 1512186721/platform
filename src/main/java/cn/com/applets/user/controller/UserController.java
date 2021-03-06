package cn.com.applets.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.applets.user.model.UserInfo;
import cn.com.applets.user.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
  
    @Autowired  
    private UserService userService;  
      
    @RequestMapping("/showInfo/{userId}")  
    public String showUserInfo(ModelMap modelMap, @PathVariable long userId){  
        UserInfo userInfo = userService.getUserById(userId);  
        modelMap.addAttribute("userInfo", userInfo);  
        return "/user/showInfo";  
    }  
      
    @RequestMapping("/showInfos") 
    @ResponseBody
    public  Object showUserInfos(){  
    	UserInfo userInfo = new UserInfo();
    	List<UserInfo> userInfos = new ArrayList<UserInfo>();
    	try {
    		userInfos = userService.getUsers(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return userInfos;  
    }  
}  