package org.typograf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.typograf.DAO.*;
import org.typograf.entity.*;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    EmployeeDAO employeeDAO;
    @Autowired
    TypeMachineDAO typeMachineDAO;
    @Autowired
    QualificationDAO qualificationDAO;
    @Autowired
    ClientOrderDAO clientOrderDAO;

    @RequestMapping("/")
    String NavigateMethod(){
        return "navigate";
    }
    @RequestMapping("/emp")
    String ShowAllEmps(Model model){
        List<Employee> allEmps=employeeDAO.getAllEmp();
        model.addAttribute("allEmps",allEmps);
        return "showAllEmpsPlease";
    }

    @RequestMapping("/typemachine")
    String ShowAllMachine(Model model){
        List<TypeMachine> allTM= typeMachineDAO.showAllTypeMachines();
        model.addAttribute("allType",allTM);
        return "ShowAllMachinePlease";
    }

    @RequestMapping("/quality")
    String ShowQuery(Model model){
        List<Qualification> qualificationList=qualificationDAO.getQuality();
        model.addAttribute("qualEmps",qualificationList);
        return "qualityEmp";
    }

    @RequestMapping("/order")
    String ShowOrder(Model model){
        List<String> bufferSetTypeMachine=clientOrderDAO.spisokTypeMachines();
        List<String> bufferSetModel=clientOrderDAO.spisokModel();
        ClientRequest cr=new ClientRequest();
        model.addAttribute("objTypeMachine",cr);
        model.addAttribute("typeMachine",bufferSetTypeMachine);
        model.addAttribute("modelMachine",bufferSetModel);
        return "client-order";
    }

}
