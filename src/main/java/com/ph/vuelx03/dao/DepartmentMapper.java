package com.ph.vuelx03.dao;

import com.ph.vuelx03.entity.Department;
import com.ph.vuelx03.vo.DepartmentNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<DepartmentNode> selectChildren(Integer departmentId);

}