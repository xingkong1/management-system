package com.giit.www.college.controller;

import com.giit.www.college.service.DeptBiz;
import com.giit.www.college.service.SpecBiz;
import com.giit.www.entity.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("spec.do")
public class SpecController {

    @Resource(name = "specBizImpl")
    SpecBiz specBiz;

    @RequiresRoles("admin")
    @RequestMapping("spec_add.view")
    public String specAddView(Model m) {
        m.addAttribute("deptNameList", specBiz.findDpet());
        return "/admin/college/spec_add";
    }

    
    @RequiresRoles("admin")
    @RequestMapping("spec.view")
    public String specView(Model m) {
        m.addAttribute("deptAndSpec", specBiz.findDeptAndSpec());
        return "/admin/college/spec";
    }
    @RequiresRoles("admin")
    @RequestMapping("spec_update.view")
    public String specUpdateView(Model m) {
        return "/admin/college/spec_update";
    }
    @RequiresRoles("admin")
    @RequestMapping("update")
    public String update(@Param("specName") String newSpecName, @Param("newSpecName") String specName) {
        specBiz.update(specName, newSpecName);
        return "redirect:/spec.do/spec.view";
    }
    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(Spec spec) {
        specBiz.add(spec);
        return "redirect:/spec.do/spec.view";
    }
    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(String specName) {
        specBiz.delete(specName);
        return "redirect:/spec.do/spec.view";
    }

}

