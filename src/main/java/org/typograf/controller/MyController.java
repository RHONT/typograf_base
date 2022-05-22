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
import org.typograf.entity.*;
import org.typograf.functionPack.*;

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
    private MyData myDataBean;

    @Autowired
    private ClientOrder clientOrder;

    @Autowired
    private KeyStorage keyStorage;

    @RequestMapping("/admin")
    String NavigateMethod(){
        return "AdminPage";
    }

    @RequestMapping("/engineer")
    String engineerOption(){
        return "enPage";
    }

    @RequestMapping("/engineer/updateWork")
    String engineerUpdateWork(@RequestParam ("numb_work") Integer id_work, Model model){

        Work works=dataBaseTypographService.getSingleReportDay(id_work);
        ClientRequest clientRequest=dataBaseTypographService.getSingleClientRequest(works.getIdClientRequest().getId());
        Employee employee=dataBaseTypographService.getSingleEmployee(works.getIdEmployee().getId());
        Machine machine=dataBaseTypographService.getSingleMachine(clientRequest.getIdMachine().getId());
        TypeMachine typeMachine=dataBaseTypographService.getSingleTypeMachine(clientRequest.getIdTypeMachine().getId());
        SerialNumber serialNumber=dataBaseTypographService.getSingleSerialNumber(clientRequest.getIdSerialNumber().getId());

        CompletedOrder completedOrder=new CompletedOrder();

        completedOrder.setDescProblem(clientRequest.getDescProblem());
        completedOrder.setDifficilty(clientRequest.getDifficilty());
        completedOrder.setIdClientRequest(clientRequest);
        completedOrder.setIdEmployee(works.getIdEmployee());
        completedOrder.setFirm(clientRequest.getFirm());
        completedOrder.setIdMachine(clientRequest.getIdMachine());
        completedOrder.setIdSerialNumber(clientRequest.getIdSerialNumber());
        completedOrder.setIdTypeMachine(clientRequest.getIdTypeMachine());
        completedOrder.setInnFirm(clientRequest.getInnFirm());
        completedOrder.setNameClient(clientRequest.getNameClient());
        completedOrder.setPhoneClient(clientRequest.getPhoneClient());

        saveOrUpdateService.saveOrUpdateCompletedOrder(completedOrder);

        model.addAttribute("id_completedOrder",completedOrder.getId());
        model.addAttribute("employee",employee);
        model.addAttribute("machine",machine);
        model.addAttribute("typeMachine",typeMachine);
        model.addAttribute("serialNumber",serialNumber);
        model.addAttribute("clientRequest",clientRequest);

        return "enUpPage";
    }

    @RequestMapping("/engineer/updateWork/update")
    String UpdateReportWork(@RequestParam("id_Complete") Integer id_complete ,
                            @RequestParam("jadgmentCompany") String  jadgmentCompany ,
                            @RequestParam("ratingFirm") Integer ratingFirm,
                            @RequestParam("expertOpinion") String expertOpinion,
                            @RequestParam("factDifficilty") Integer factDifficilty ){

        CompletedOrder completedOrder=dataBaseTypographService.getSingleCompletedOrder(id_complete);
        completedOrder.setJadgmentCompany(jadgmentCompany);
        completedOrder.setRatingFirm(ratingFirm);
        completedOrder.setExpertOpinion(expertOpinion);
        completedOrder.setFactDifficilty(factDifficilty);

        saveOrUpdateService.saveOrUpdateCompletedOrder(completedOrder);

        return "redirect:/";
    }

    @RequestMapping("/admin/emp")
    String ShowAllEmps(Model model){
        List<Employee> allEmployees=dataBaseTypographService.getAllEmp();
        model.addAttribute("allEmps",allEmployees);
        return "showAllEmpsPage";
    }

    @RequestMapping("/admin/typemachine")
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

    @RequestMapping("/admin/quality")
    String ShowQuery(Model model){
        List<Qualification> allQualities=dataBaseTypographService.getAllQualities();
        model.addAttribute("qualEmps",allQualities);
        return "qualityEmployeesPage";
    }

    @RequestMapping("/")
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

        return "redirect:/";
    }

    @RequestMapping("/admin/adminorder")
    String openListOrder(Model model){
        List<ClientRequest> allClientRequest = dataBaseTypographService.getAllClientRequest();
        model.addAttribute("allClientRequests",allClientRequest);
        return "adminOrderPage";
    }


    @RequestMapping("/interlayerlink")
    String openListEmpForWork(@RequestParam("ClientOrderID") Integer idClientRequest){
        clientOrder.setId(idClientRequest);
        return "redirect:/admin/adminorder/updateinfo";
    }

    @RequestMapping("/admin/adminorder/updateinfo")
    String updateClientResult(@ModelAttribute ClientRequest singleClientRequest, Model model){
        //Если бин заходит сюда впревый раз, то он передает id, если повторно(а значит ModelAttribute уже не пустая)
        //то обновляет значение поля
        if (clientOrder.isLock()==true){
            singleClientRequest=dataBaseTypographService.getSingleClientRequest(clientOrder.getId());
            clientOrder.setLock(false);
        }
        else {
            saveOrUpdateService.updateClientRequest(singleClientRequest);
        }

        Integer levelDifficulty = singleClientRequest.getDifficilty();
        Integer idTypeMachine = singleClientRequest.getIdTypeMachine().getId();
        List<Employee> SuitableEmployees= dataBaseTypographService.
                getListEmployeeForReportWork(levelDifficulty,idTypeMachine);

        List<EmployeeLinkedHashMap> workingCoverageOfDates=
                dataBaseTypographService.fillWorkingCoverageOfDates(SuitableEmployees,singleClientRequest.getDataWish());

        model.addAttribute("сlientOrderUpdate",singleClientRequest);
        model.addAttribute("Employee",SuitableEmployees);
        model.addAttribute("WorkingCoverage",workingCoverageOfDates.iterator());

        return "updateOrderWorkPage";
    }


    @RequestMapping("/admin/adminorder/updateinfo/tableinfo")
    String ShowOneDayTabelEmpl(@ModelAttribute("clientOrderUpdate") ClientRequest clientRequest,
                               @RequestParam("id_empl") Integer id_emp,
                               @RequestParam("data_work") String selectedDate,
                               @RequestParam("arrayHours") String arrayHours,
                               @RequestParam("id_clientOrder") Integer id_clientOrderUpdate,
                               @RequestParam("time_forecast") Integer timeForecast,
                               Model model){
        // создаю пустой экземпляр рабочего дня
         WorkDay workDay1=new WorkDay(LocalDate.parse(selectedDate).getDayOfMonth());

        // вношу в него изменения соответствующие выбранному дню, вынужден гонять числа в строки,
        // так как RequestParam не может передавать массивы чисел.
         workDay1.returnArrayInteger(arrayHours);

         //создаю мапу для хранения доступных часов для начала работы
         WorkHours workHours=new WorkHours();

         myDataBean.setId_employee(id_emp);
         myDataBean.setId_clientRequest(id_clientOrderUpdate);
         myDataBean.setDataTemp(LocalDate.parse(selectedDate));
         myDataBean.setTimeForecast(timeForecast);

        Work newWork=new Work();

        List<Work> reportDay=dataBaseTypographService.getOneReportDay(id_emp,LocalDate.parse(selectedDate));

        model.addAttribute("listWork",reportDay);
        model.addAttribute("newWorkDay",newWork);
        // заполняю пустую мапу на основании рабочего дня
        model.addAttribute("hours",workHours.fillHours(workDay1));

        return "selectedTabelDayPage";
    }

    @RequestMapping("/admin/adminorder/updateinfo/tableinfo/updateWorkDay")
    String updateNewWorkDay(@ModelAttribute("newWorkDay") Work work){
        saveOrUpdateService.saveWork(
                                    work,
                                    myDataBean.getId_employee(),
                                    myDataBean.getId_clientRequest(),
                                    myDataBean.getDataTemp(),
                                    myDataBean.getTimeForecast()
                            );

        return "redirect:/admin/adminorder";
    }


}
