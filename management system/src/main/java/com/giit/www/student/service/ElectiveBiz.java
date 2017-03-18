package com.giit.www.student.service;

import com.giit.www.entity.Section;
import com.giit.www.entity.custom.SectionCustom;

import java.util.List;


public interface ElectiveBiz {
    public void add(String secId, String stdId);

    public List<SectionCustom> findAllSection();

    public void delete(int secId, String stdId);
}
