package com.giit.www.college.service.impl;

import com.giit.www.college.dao.StudentDao;
import com.giit.www.college.service.StudentBiz;
import com.giit.www.entity.Student;
import com.giit.www.entity.User;
import com.giit.www.system.dao.RoleDao;
import com.giit.www.system.service.UserBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.beans.Transient;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class StudentBizImpl implements StudentBiz {
    @Resource
    private StudentDao studentDao;

    @Resource
    private RoleDao roleDao;

    @Resource(name = "userBizImpl")
    private UserBiz userBiz;

    public List<Student> studentView() {
        return studentDao.findAll();
    }

    @Transactional
    public void add(Student student, MultipartFile pic) throws IOException {

        if (pic.getSize() != 0) {
            String originalFilename = pic.getOriginalFilename();

            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFilename = UUID.randomUUID() + fileType;

            String path = "/home/c0de8ug/software/apache-tomcat-8.0.28/pic/";

            File dest = new File(path + newFilename);
            pic.transferTo(dest);

            student.setPicPath(newFilename);
        }

        studentDao.add(student);

        User user = new User();
        user.setUserId(student.getStudentId());
        Long roleId = roleDao.findByDescription("学生").getId();
        List tempList = new ArrayList<>();
        tempList.add(roleId);
        user.setRoleIds(tempList);
        user.setLocked(false);
        user.setPassword(student.getPassword());
        userBiz.add(user);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Transactional
    @Override
    public void delete(int studentId) {
        studentDao.delete(studentId);
    }

}
