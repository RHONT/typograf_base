package org.typograf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.typograf.DAO.*;
import org.typograf.Services.DataBaseTypographService;
import org.typograf.Services.MapsFromDBService;
import org.typograf.Services.SaveOrUpdateService;
import org.typograf.TestPack.Fighter;
import org.typograf.entity.*;
import org.typograf.functionPack.EmployeeLinkedHashMap;

import java.time.LocalDate;
import java.util.*;

@Controller
public class MyController {
    @Autowired
    private DataBaseTypographService dataBaseTypographService;

    @Autowired
    private SaveOrUpdateService saveOrUpdateService;

    @Autowired
    private MapsFromDBService mapsFromDBService;



    @Autowired
    TypeMachineDAO typeMachineDAO;
    @Autowired
    QualificationDAO qualificationDAO;
    @Autowired
    ClientOrderDAO clientOrderDAO;


    @RequestMapping("/")
    String NavigateMethod(){
        return "navigatePage";
    }

    @RequestMapping("/emp")
    String ShowAllEmps(Model model){
        List<Employee> allEmps=dataBaseTypographService.getAllEmp();
        model.addAttribute("allEmps",allEmps);
        return "showAllEmpsPage";
    }

    @RequestMapping("/typemachine")
    String ShowAllMachine(Model model){
        List<TypeMachine> allTM= typeMachineDAO.showAllTypeMachines();
        model.addAttribute("allType",allTM);
        model.addAttribute("new_type_machine",new TypeMachine());
        return "ShowAllMachineTypePage";
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
        return "qualityEmployeesPage";
    }

    @RequestMapping("/order")
    String ShowOrder(Model model){
        Map<Integer,String> mapTypeMachine=mapsFromDBService.getListTypeMachines();
        Map<Integer,String> mapMachine=mapsFromDBService.getListMachines();
        List<String> listSerial=mapsFromDBService.getSerialNumber();
        System.out.println(mapTypeMachine);
        System.out.println(mapMachine);
        System.out.println(listSerial);
        ClientRequestId crId=new ClientRequestId();
        model.addAttribute("ClientRequestId",crId);
        model.addAttribute("typeMachine",mapTypeMachine);
        model.addAttribute("modelMachine",mapMachine);
        model.addAttribute("SerialNumberMachine",listSerial);
        return "clientOrderPage";
    }

    @RequestMapping("/saveorder")
    String SaveOrder(@ModelAttribute("ClientRequestId") ClientRequestId clientRequestId){

        TypeMachine typeMachine= clientOrderDAO.getSingleTypeMachine(clientRequestId.getIdTypeMachine());
        Machine machine=clientOrderDAO.getSingleMachine(clientRequestId.getIdMachine());
        SerialNumber serialNumber=clientOrderDAO.getSingleSerialNumber(clientRequestId.getIdSerialNumber());

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

        saveOrUpdateService.saveClientRequest(cr);

        return "redirect:/order";
    }

    @RequestMapping("/adminorder")
    String openListOrder(Model model){
        List<ClientRequest> allClientRequest = clientOrderDAO.getAllClientRequest();
        model.addAttribute("admin_object",allClientRequest);
        return "adminOrderPage";
    }


    @RequestMapping("/updateinfo")
    String openListEmpForWork(@RequestParam("ClientOrderID") Integer idClientRequest, Model model){
        ClientRequest singleClientRequest=clientOrderDAO.getSingleClientRequest(idClientRequest);
        model.addAttribute("ClientOrderUpdate",singleClientRequest);

        return "updateOrderPage";
    }

    @RequestMapping("/updateOrder")
    String updateClientResult(@ModelAttribute("ClientOrderUpdate") ClientRequest singleClientRequest, Model model){
        saveOrUpdateService.updateClientRequest(singleClientRequest);

        Integer levelDifficulty = singleClientRequest.getDifficilty();
        Integer idTypeMachine = singleClientRequest.getIdTypeMachine().getId();

        List<Employee> SuitableEmployees= dataBaseTypographService.getListEmployeeForReportWork(levelDifficulty,idTypeMachine);
        List<EmployeeLinkedHashMap> workingCoverageOfDates=
                dataBaseTypographService.fillWorkingCoverageOfDates(SuitableEmployees,singleClientRequest.getDataWish());

        model.addAttribute("ClientOrderUpdate",singleClientRequest);
        model.addAttribute("Employee",SuitableEmployees);
        model.addAttribute("linked_list",workingCoverageOfDates.iterator());

        return "updateOrderWorkPage";
    }
    @RequestMapping("/tableinfo")
    String ShowOneDayTabelEmpl(@ModelAttribute("id_empl") Integer id_emp,
                               @ModelAttribute("data_work") String dataWorkStr,
                               Model model){
        LocalDate dataWork= LocalDate.parse(dataWorkStr);
        List<Work> workList=dataBaseTypographService.getOneReportDay(id_emp,dataWork);
        model.addAttribute("listWork",workList);

        return "SelectedTabelDayPage";
    }



    @RequestMapping("/testPage")
    String ShowTestPage(@ModelAttribute("objTypeMachine")
                                ClientRequest clientRequest){
        return "testPageForClientOrder";
    }


    // контролллеры для тестового класса Fight
    @RequestMapping("/test")
    String ShowTestPage(Model model){
        List<Work> workList=dataBaseTypographService.getAllReportEmployees();
        model.addAttribute("listWork",workList);
//        Fighter f=new Fighter();
//        List<String> listSerial=mapsForClientDAO.GetSerialNumber();
//
////        Map<String,String> mapForClientOrderView=mapsForClientDAO.GetSerialNumber();
////        System.out.println(mapForClientOrderView);
//        model.addAttribute("typeMachine",listSerial);
//        model.addAttribute("fighter_attr",f);
        return "SelectedTabelDayPage";
    }

    @RequestMapping("/testnow")
    String ShowTestPa(@ModelAttribute("fighter_attr") Fighter fighter){
        return "test";
    }


}
