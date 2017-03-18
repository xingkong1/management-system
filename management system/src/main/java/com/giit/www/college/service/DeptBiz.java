package com.giit.www.college.service;

import com.giit.www.entity.custom.DeptAndSpec;
import com.giit.www.entity.Dept;

import java.util.List;


public interface DeptBiz {
    public List<Dept> findAll();

    public void add(String deptName);

    public void update(Dept dept);

    public void delete(int deptId);

}
