package org.typograf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.typograf.entity.EmpImpl;
import org.typograf.entity.Employee;
import org.typograf.entity.EmployeeDAO;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    EmployeeDAO employeeDAO;

    @RequestMapping("/")
    String ShowAllEmps(Model model){
        List<Employee> allEmps=employeeDAO.getAllEmp();
        model.addAttribute("allEmps",allEmps);
        return "showAllEmpsPlease";
    }
}
