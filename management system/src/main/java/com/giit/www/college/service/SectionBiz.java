package com.giit.www.college.service;

import com.giit.www.entity.Section;
import com.giit.www.entity.Staff;
import com.giit.www.entity.Timetable;
import com.giit.www.entity.custom.SectionCustom;

import java.util.List;

public interface SectionBiz {
    public void delete(int sectionId);

    public void add(Section section);

    public List<SectionCustom> findAllCustom();

    public List<String> findAllCourseTitle();

    public List<Staff> findAllStaff();

    public void addTimetable(Timetable timetable);
}
