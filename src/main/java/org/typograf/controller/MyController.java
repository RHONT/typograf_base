package org.typograf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.typograf.DAO.*;
import org.typograf.TestPack.Fighter;
import org.typograf.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    MapsForClientDAO mapsForClientDAO;

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
        Map<Integer,String> mapTypeMachine=mapsForClientDAO.GetListTypeMachines();
        Map<Integer,String> mapMachine=mapsForClientDAO.GetListMachines();
        List<String> listSerial=mapsForClientDAO.GetSerialNumber();
        System.out.println(mapTypeMachine);
        System.out.println(mapMachine);
        System.out.println(listSerial);
        ClientRequest cr=new ClientRequest();
        model.addAttribute("objClientOrder",cr);
        model.addAttribute("typeMachine",mapTypeMachine);
        model.addAttribute("modelMachine",mapMachine);
        model.addAttribute("SerialNamberMachine",listSerial);
        return "client-order";
    }

    @RequestMapping("/saveorder")
    String SaveOrder(@ModelAttribute("objClientOrder") ClientRequest clientRequest){
        clientOrderDAO.saveOrder(clientRequest);

        return "redirect:/";
    }




    @RequestMapping("/testPage")
    String ShowTestPage(@ModelAttribute("objTypeMachine")
                                ClientRequest clientRequest){
        return "testPageForClientOrder";
    }


    // контролллеры для тестового класса Fight
    @RequestMapping("/test")
    String ShowTestPage(Model model){
        Fighter f=new Fighter();
        List<String> listSerial=mapsForClientDAO.GetSerialNumber();

//        Map<String,String> mapForClientOrderView=mapsForClientDAO.GetSerialNumber();
//        System.out.println(mapForClientOrderView);
        model.addAttribute("typeMachine",listSerial);
        model.addAttribute("fighter_attr",f);
        return "TestView";
    }

    @RequestMapping("/testnow")
    String ShowTestPa(@ModelAttribute("fighter_attr") Fighter fighter){
        return "test";
    }


}
