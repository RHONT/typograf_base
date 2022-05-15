package org.typograf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.typograf.Services.DataBaseTypographService;
import org.typograf.Services.MapsFromDBService;
import org.typograf.Services.SaveOrUpdateService;
import org.typograf.TestPack.Fighter;
import org.typograf.entity.*;
import org.typograf.functionPack.EmployeeLinkedHashMap;
import org.typograf.functionPack.WorkDay;
import org.typograf.functionPack.WorkHours;

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

    @RequestMapping("/")
    String NavigateMethod(){
        return "navigatePage";
    }

    @RequestMapping("/emp")
    String ShowAllEmps(Model model){
        List<Employee> allEmployees=dataBaseTypographService.getAllEmp();
        model.addAttribute("allEmps",allEmployees);
        return "showAllEmpsPage";
    }

    @RequestMapping("/typemachine")
    String ShowAllMachine(Model model){
        List<TypeMachine> allTypeMachines= dataBaseTypographService.getAllTypeMachines();
        model.addAttribute("allType",allTypeMachines);
        model.addAttribute("new_type_machine",new TypeMachine());
        return "ShowAllMachineTypePage";
    }

    @RequestMapping("/save_new_type_machine")
    String SaveNewTypeMachine(@ModelAttribute("new_type_machine")
                                      TypeMachine typeMachine){
        saveOrUpdateService.saveTypeMachine(typeMachine);
        return "redirect:/typemachine";
    }

    @RequestMapping("/quality")
    String ShowQuery(Model model){
        List<Qualification> allQualities=dataBaseTypographService.getAllQualities();
        model.addAttribute("qualEmps",allQualities);
        return "qualityEmployeesPage";
    }

    @RequestMapping("/order")
    String ShowOrder(Model model){
        Map<Integer,String> mapTypeMachine=mapsFromDBService.getListTypeMachines();
        Map<Integer,String> mapMachine=mapsFromDBService.getListMachines();
        List<String> listSerial=mapsFromDBService.getSerialNumber();

        ClientRequestId crId=new ClientRequestId();
        model.addAttribute("ClientRequestId",crId);
        model.addAttribute("typeMachine",mapTypeMachine);
        model.addAttribute("modelMachine",mapMachine);
        model.addAttribute("SerialNumberMachine",listSerial);
        return "clientOrderPage";
    }

    @RequestMapping("/saveorder")
    String SaveOrder(@ModelAttribute("ClientRequestId") ClientRequestId clientRequestId){

        TypeMachine typeMachine= dataBaseTypographService.getSingleTypeMachine(clientRequestId.getIdTypeMachine());
        Machine machine=dataBaseTypographService.getSingleMachine(clientRequestId.getIdMachine());
        SerialNumber serialNumber=dataBaseTypographService.getSingleSerialNumber(clientRequestId.getIdSerialNumber());

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
        List<ClientRequest> allClientRequest = dataBaseTypographService.getAllClientRequest();
        model.addAttribute("allClientRequests",allClientRequest);
        return "adminOrderPage";
    }


    @RequestMapping("/updateinfo")
    String openListEmpForWork(@RequestParam("ClientOrderID") Integer idClientRequest, Model model){
        ClientRequest singleClientRequest=dataBaseTypographService.getSingleClientRequest(idClientRequest);
        model.addAttribute("ClientOrderUpdate",singleClientRequest);

        return "updateOrderPage";
    }

    @RequestMapping("/updateOrder")
    String updateClientResult(@ModelAttribute("clientOrderUpdate") ClientRequest singleClientRequest, Model model){
        saveOrUpdateService.updateClientRequest(singleClientRequest);

        Integer levelDifficulty = singleClientRequest.getDifficilty();
        Integer idTypeMachine = singleClientRequest.getIdTypeMachine().getId();

        List<Employee> SuitableEmployees= dataBaseTypographService.getListEmployeeForReportWork(levelDifficulty,idTypeMachine);
        List<EmployeeLinkedHashMap> workingCoverageOfDates=
                dataBaseTypographService.fillWorkingCoverageOfDates(SuitableEmployees,singleClientRequest.getDataWish());

        model.addAttribute("ClientOrderUpdate",singleClientRequest);
        model.addAttribute("Employee",SuitableEmployees);
        model.addAttribute("WorkingCoverage",workingCoverageOfDates.iterator());

        return "updateOrderWorkPage";
    }


    @RequestMapping("/tableinfo")
    String ShowOneDayTabelEmpl(@ModelAttribute("clientOrderUpdate") ClientRequest clientRequest,
                               @RequestParam("id_empl") Integer id_emp,
                               @RequestParam("data_work") String selectedDate,
                               @RequestParam("workDay") int[] workDay,
                               Model model){
        WorkDay workDay1=new WorkDay(LocalDate.parse(selectedDate).getDayOfMonth());
        workDay1.setWork(workDay);
        WorkHours hours=new WorkHours();
//        LocalDate selectedSingleDate=LocalDate.parse(selectedDate);

        Work newWork=new Work();
        Employee singleEmployee=dataBaseTypographService.getSingleEmployee(id_emp);
        newWork.setIdClientRequest(clientRequest);
        newWork.setIdEmployee(singleEmployee);
        newWork.setLaidDownTime(clientRequest.getTimeForecast());
        newWork.setDateVisit(clientRequest.getDataWish());


        List<Work> reportDay=dataBaseTypographService.getOneReportDay(id_emp,LocalDate.parse(selectedDate));
        model.addAttribute("listWork",reportDay);
        model.addAttribute("newWorkDay",newWork);
        model.addAttribute("hours",hours.fillHours(workDay1));


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

        return "SelectedTabelDayPage";
    }

    @RequestMapping("/testnow")
    String ShowTestPa(@ModelAttribute("fighter_attr") Fighter fighter){
        return "test";
    }


}
