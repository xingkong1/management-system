package com.giit.www.util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@Component
public class TermContainer {
   
    static List<Term> termList;
    static LocalDate beginTime;
    static HashMap<String, String> map = new HashMap<>();
    final static String lastTermStr = "上学期";
    final static String nextTermStr = "下学期";

    String lastSemester = "2,3,4,5,6,7,8";
    String nextSemester = "1,9,10,11,12";

    TermContainer() {


        for (String temp : lastSemester.split(",")) {
            map.put(temp, lastTermStr);
        }
        for (String temp : nextSemester.split(",")) {
            map.put(temp, nextTermStr);
        }
        beginTime = LocalDate.of(2014, 1, 1);
        update();
    }

    public static void update() {
        termList = new ArrayList<>();

        LocalDate today = LocalDate.now();


        int beginYear = beginTime.getYear();
        int todayYear = today.getYear();
        int count = todayYear - beginYear;

        if (map.get(String.valueOf(today.getMonthValue())).equals(nextTermStr)) {
            Term term = new Term();
            term.setVal(todayYear + "2");
            term.setText(todayYear + nextTermStr);
            termList.add(term);
        }
        Term term = new Term();
        term.setVal(todayYear + "1");
        term.setText(todayYear + lastTermStr);
        termList.add(term);


        for (int i = 0; i < count; i++) {
            todayYear--;
            term = new Term();
            term.setVal(todayYear + "2");
            term.setText(todayYear + nextTermStr);
            termList.add(term);
            term = new Term();
            term.setVal(todayYear + "1");
            term.setText(todayYear + lastTermStr);
            termList.add(term);

        }

    }


    public static String now() {
        return termList.get(0).getVal();
    }

    public static List<Term> getTermList() {
        return termList;
    }
}
