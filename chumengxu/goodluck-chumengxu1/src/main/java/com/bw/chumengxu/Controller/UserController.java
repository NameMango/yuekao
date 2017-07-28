package com.bw.chumengxu.Controller;

import com.bw.chumengxu.dao.UserDao;
import com.bw.chumengxu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Sliyan on 2017/7/28.
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("u")
    public String u(){
        return"useradd";
    }

    //用户注册
    @RequestMapping("userRegister")
    public String UserRegister(User user,Model model){
        User u = userDao.save(user);
        model.addAttribute("u",u);
        return "register";
    }


    //用户登录
    @RequestMapping("login")
    public String UserLogin(HttpSession session,User user){


        return "forward:uslist";

    }


    //用户查询
    @RequestMapping("uslist")
    public String UserListAll(Map<String,Object> param){
        List<User> ulist = userDao.findAll();
        System.out.println(ulist);
        param.put("ulist",ulist);

        return "userlist";
    }




    //查询用户名
    @RequestMapping("username")
    public String UserListName(String username){
        User uname = userDao.findByUsername(username);
        return"uslist";

    }


    //删除
    @RequestMapping("userdel")
    public String userdel(Integer id){
      userDao.delete(id);
        return"redirect:uslist";
    }


    //获取id
    @ResponseBody
    @RequestMapping("findByUid")
    public User  userByid(User user){
        return  userDao.findById(user.getId());

    }

}
