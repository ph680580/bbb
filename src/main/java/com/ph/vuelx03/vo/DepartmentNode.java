package com.ph.vuelx03.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DepartmentNode {

    @JsonProperty("value")
    private Integer departmentId;

    @JsonProperty("label")
    private String name;

    @JsonProperty("children")
    private List<DepartmentNode> subDepartmentNodes;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DepartmentNode> getSubDepartmentNodes() {
        return subDepartmentNodes;
    }

    public void setSubDepartmentNodes(List<DepartmentNode> subDepartmentNodes) {
        this.subDepartmentNodes = subDepartmentNodes;
    }
}
