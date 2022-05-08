package org.typograf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.typograf.DAO.*;
import org.typograf.TestPack.Fighter;
import org.typograf.entity.*;
import org.typograf.functionPack.EmployeeLinkedHashMap;

import java.time.LocalDate;
import java.util.*;

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
        List<ClientRequest> allClientRequest = clientOrderDAO.getAllClientRequest();
        model.addAttribute("admin_object",allClientRequest);
        return "adminOrder";
    }


    @RequestMapping("/updateinfo")
    String openListEmpForWork(@RequestParam("ClientOrderID") Integer idClientRequest, Model model){
        ClientRequest singleClientRequest=clientOrderDAO.getOneClientRequest(idClientRequest);
        model.addAttribute("ClientOrderUpdate",singleClientRequest);

        return "updateOrderPage";
    }

    @RequestMapping("/updateOrder")
    String updateClientResult(@ModelAttribute("ClientOrderUpdate") ClientRequest singleClientRequest, Model model){
        clientOrderDAO.updateOrder(singleClientRequest);

        Integer levelDifficulty = singleClientRequest.getDifficilty();
        Integer idTypeMachine = singleClientRequest.getIdTypeMachine().getId();

        List<Employee> SuitableEmployees= workDAO.GetListEmployee(levelDifficulty,idTypeMachine);
        List<EmployeeLinkedHashMap> workingCoverageOfDates=
                workDAO.fillWorkingCoverageofDates(SuitableEmployees,singleClientRequest.getDataWish());

        model.addAttribute("ClientOrderUpdate",singleClientRequest);
        model.addAttribute("Employee",SuitableEmployees);
        model.addAttribute("linked_list",workingCoverageOfDates.iterator());

        return "updateOrderWork";
    }
    @RequestMapping("/tableinfo")
    String ShowOneDayTabelEmpl(@ModelAttribute("id_empl") Integer id_emp,
                               @ModelAttribute("data_work") String dataWorkStr,
                               Model model){
        LocalDate dataWork= LocalDate.parse(dataWorkStr);
        List<Work> workList=workDAO.getOneTabelDay(id_emp,dataWork);
        model.addAttribute("listWork",workList);

        return "SelectedTabelDay";
    }



    @RequestMapping("/testPage")
    String ShowTestPage(@ModelAttribute("objTypeMachine")
                                ClientRequest clientRequest){
        return "testPageForClientOrder";
    }


    // контролллеры для тестового класса Fight
    @RequestMapping("/test")
    String ShowTestPage(Model model){
        List<Work> workList=workDAO.getAllTabel();
        model.addAttribute("listWork",workList);
//        Fighter f=new Fighter();
//        List<String> listSerial=mapsForClientDAO.GetSerialNumber();
//
////        Map<String,String> mapForClientOrderView=mapsForClientDAO.GetSerialNumber();
////        System.out.println(mapForClientOrderView);
//        model.addAttribute("typeMachine",listSerial);
//        model.addAttribute("fighter_attr",f);
        return "SelectedTabelDay";
    }

    @RequestMapping("/testnow")
    String ShowTestPa(@ModelAttribute("fighter_attr") Fighter fighter){
        return "test";
    }


}
