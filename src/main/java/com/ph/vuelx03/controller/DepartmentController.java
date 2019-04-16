package com.ph.vuelx03.controller;
import com.ph.vuelx03.dao.DepartmentMapper;
import com.ph.vuelx03.vo.DepartmentNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/getDepartmentTreeById")
    public List<DepartmentNode> getDepartmentTreeById(Integer departmentId){
        List<DepartmentNode> departmentNodes = departmentMapper.selectChildren(departmentId);
        return departmentNodes;
    }












}
