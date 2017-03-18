package com.giit.www.entity.custom;

import com.giit.www.entity.Section;
import com.giit.www.entity.Timetable;

import java.util.List;


public class SectionCustom extends Section {
    String teacher;
    List<Timetable> timetableList;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Timetable> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Timetable> timetableList) {
        this.timetableList = timetableList;
    }
}
