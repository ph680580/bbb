package com.ph.vuelx03.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ph.vuelx03.entity.User;
import com.ph.vuelx03.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin
@EnableAutoConfiguration
@Lazy
public class UserController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Reference
    private UserService userService;

    @GetMapping("/list")
    public PageInfo<User> list(@RequestParam(required = false,defaultValue = "1") Integer pageNum,@RequestParam(required = false,defaultValue = "")String username){
        PageHelper.startPage(pageNum,2);
        Page<User> users = userService.list(username);
        PageInfo<User> userPageInfo = users.toPageInfo();
        return userPageInfo;
    }


//    @GetMapping("/list")
//    public PageInfo<User> list(@RequestParam(required = false,defaultValue = "1")Integer pageNum, @RequestParam(required = false,defaultValue ="")String username){
//        PageHelper.startPage(pageNum,2);
//        Page<User> users =userService.list(username);
//        PageInfo<User> userPageInfo = users.toPageInfo();
//        return userPageInfo;
//    }

    @PostMapping("/add")
    public Integer add(@RequestBody User user){
        //加盐
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        String str = user.getEncryptedPassword() + salt;
        String str2 = DigestUtils.md5DigestAsHex(str.getBytes());
        user.setEncryptedPassword(str2);

        userService.add(user);
//        logger.info("user"+user);
//        rabbitTemplate.convertSendAndReceive("jhj","key",user);
        Integer userId = user.getUserId();
        return userId;

    }

    @GetMapping("/getById")
    public  User getById(@RequestParam Integer userId){
        User user =userService.selectByPrimaryKey(userId);
        return user;
    }

    @PostMapping("/upd")
    public void  update(@RequestBody User user){
        userService.updateByPrimaryKey(user);
    }

    @PostMapping("/del")
    public Object del(@RequestBody User user){
        Integer userid = user.getUserId();
        userService.deleteByPrimaryKey(userid);
        return true;
    }

    @PostMapping("/delAll")
    public Integer delAll(@RequestBody Integer[] Userids){
        userService.delAll(Userids);
        return null;
    }




















}
