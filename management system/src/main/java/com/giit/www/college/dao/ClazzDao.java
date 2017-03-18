package com.giit.www.college.dao;

import com.giit.www.entity.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazzDao {
    public void add(Clazz clazz);

    public void delete(int clazzId);

    public List<Clazz> findAll();

    public int getClassCount(@Param("specName") String specName, @Param("year") String year);
}
