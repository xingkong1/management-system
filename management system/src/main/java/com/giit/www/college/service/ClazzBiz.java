package com.giit.www.college.service;

import com.giit.www.entity.Clazz;
import com.giit.www.entity.custom.DeptAndSpec;

import java.util.List;


public interface ClazzBiz {
    public void add(String deptName, String specName, String year);

    public void delete(int clazzId);

    public List<Clazz> findAll();

    public List<DeptAndSpec> findDeptAndSpec();

    public String findDeptAndSpecJson();

    public List<String> findDeptNameList();
}
