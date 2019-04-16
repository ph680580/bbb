package com.ph.vuelx03.controller;

import com.ph.vuelx03.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping("/getAll")
    public List<Role> getAll(){
        List<Role> roles =roleMapper.selectAll();
        return roles;
    }
}
