package org.typograf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.typograf.DAO.*;
import org.typograf.TestPack.Fighter;
import org.typograf.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    @Autowired
    WorkDAO workDAO;

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
        model.addAttribute("new_type_machine",new TypeMachine());
        return "ShowAllMachineType";
    }

    @RequestMapping("/save_new_type_machine")
    String SaveNewTypeMachine(@ModelAttribute("new_type_machine")
                                      TypeMachine typeMachine){
        typeMachineDAO.saveTypeMachine(typeMachine);
        return "redirect:/typemachine";
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
        ClientRequestId crId=new ClientRequestId();
        model.addAttribute("ClientRequestId",crId);
        model.addAttribute("typeMachine",mapTypeMachine);
        model.addAttribute("modelMachine",mapMachine);
        model.addAttribute("SerialNumberMachine",listSerial);
        return "client-order";
    }

    @RequestMapping("/saveorder")
    String SaveOrder(@ModelAttribute("ClientRequestId") ClientRequestId clientRequestId){

        TypeMachine typeMachine= clientOrderDAO.getTypeMachine(clientRequestId.getIdTypeMachine());
        Machine machine=clientOrderDAO.getMachine(clientRequestId.getIdMachine());
        SerialNumber serialNumber=clientOrderDAO.getSerialNumber(clientRequestId.getIdSerialNumber());

        ClientRequest cr=new ClientRequest(
                clientRequestId.getFirm(),
                clientRequestId.getInnFirm(),
                typeMachine,
                machine,
                serialNumber,
                clientRequestId.getNameClient(),
                clientRequestId.getPhoneClient(),
                clientRequestId.getDescProblem(),
                clientRequestId.getDataWish());

        clientOrderDAO.saveOrder(cr);

        return "redirect:/order";
    }

    @RequestMapping("/adminorder")
    String openListOrder(Model model){
        List<ClientRequest> list = clientOrderDAO.getAllClientRequest();
        model.addAttribute("admin_object",list);
        return "adminOrder";
    }


    @RequestMapping("/updateinfo")
    String openListEmpForWork(@ModelAttribute("ClientOrderPerem") Integer i, Model model){
        ClientRequest clientRequest=clientOrderDAO.getOneClientRequest(i);
        model.addAttribute("ClientOrderUpdate",clientRequest);

        return "updateOrder";
    }

    @RequestMapping("/updateOrder")
    String updateClientResult(@ModelAttribute("ClientOrderUpdate") ClientRequest clientRequest, Model model){
        clientOrderDAO.updateOrder(clientRequest);
        Integer i = clientRequest.getDifficilty();
        Integer j = clientRequest.getIdTypeMachine().getId();
        List<Employee> listEmps= workDAO.GetListEmployee(i,j);
//        List<Employee> newList = null;
//        for (Employee e:listEmps) {
//            newList.add(e);
//        }
//
//        System.out.println(newList);

        System.out.println(listEmps.toString());
        model.addAttribute("ClientOrderUpdate",clientRequest);
        model.addAttribute("Employee",listEmps);


        return "updateOrderWork";
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
