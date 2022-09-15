package org.typograf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.typograf.DTO.ClientRequestDTO;
import org.typograf.DTO.CompletedOrderForExpertDTO;
import org.typograf.DTO.OrderDTO;
import org.typograf.Services.DataBaseTypographService;
import org.typograf.Services.MapsFromDBService;
import org.typograf.Services.SaveOrUpdateService;
import org.typograf.entity.*;
import org.typograf.functionPack.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@Controller
public class MyController {
    private static final Logger log= LoggerFactory.getLogger(MyController.class);

    @Autowired
    private DataBaseTypographService dataBaseTypographService;

    @Autowired
    private SaveOrUpdateService saveOrUpdateService;

    @Autowired
    private MapsFromDBService mapsFromDBService;

    @Autowired
    private MyData myDataBean;

    @Autowired
    private ClientOrderID clientOrderID;

    @Autowired
    private ClientRequestDTO clientRequestDTO;

    @RequestMapping("/admin")
    String NavigateMethod(){
        return "AdminPage";
    }

    @RequestMapping("/engineer")
    String engineerOption(){

        return "engineerPage";
    }

    //таблица ClientReques - промежуточная. Из нее мы дергаем значения для формирования новой таблицы CompletedOrder
    @RequestMapping("/engineer/updateWork")
    String engineerUpdateWork(@RequestParam ("numb_work") Integer id_work, Model model){

        // Проверяем существует ли введенная заявка, если нет совершаем откат назад
        Work singleWork=dataBaseTypographService.getSingleReportDay(id_work);

        if (singleWork==null){
            log.error("Ошибка с вводом номера отчета:{}",id_work);
            System.err.println("Отчет не найден");
            return "redirect:/engineer";
        }
        CompletedOrder singleCompletedOrder=dataBaseTypographService.getSingleCompletedOrder
                (singleWork.getIdClientRequest().getId(),
                        singleWork.getIdEmployee().getId());

        // Создаем сущности, для отображения информации во View
        ClientRequest clientRequest=dataBaseTypographService.getSingleClientRequest(singleWork.getIdClientRequest().getId());
        Employee employee=dataBaseTypographService.getSingleEmployee(singleWork.getIdEmployee().getId());
        Machine machine=dataBaseTypographService.getSingleMachine(clientRequest.getIdMachine().getId());
        TypeMachine typeMachine=dataBaseTypographService.getSingleTypeMachine(clientRequest.getIdTypeMachine().getId());
        SerialNumber serialNumber=dataBaseTypographService.getSingleSerialNumber(clientRequest.getIdSerialNumber().getId());

        //Создаем DTO для формы. Валидация полей и дальнейший перенос в поля обекта сущности CompletedOrder
        CompletedOrderForExpertDTO completedOrderForExpertDTO = null;

        if (singleCompletedOrder.getId()==null){
            singleCompletedOrder.setDescProblem(clientRequest.getDescProblem());
            singleCompletedOrder.setDifficilty(clientRequest.getDifficilty());
            singleCompletedOrder.setIdClientRequest(clientRequest);
            singleCompletedOrder.setIdEmployee(singleWork.getIdEmployee());
            singleCompletedOrder.setFirm(clientRequest.getFirm());
            singleCompletedOrder.setIdMachine(clientRequest.getIdMachine());
            singleCompletedOrder.setIdSerialNumber(clientRequest.getIdSerialNumber());
            singleCompletedOrder.setIdTypeMachine(clientRequest.getIdTypeMachine());
            singleCompletedOrder.setInnFirm(clientRequest.getInnFirm());
            singleCompletedOrder.setNameClient(clientRequest.getNameClient());
            singleCompletedOrder.setPhoneClient(clientRequest.getPhoneClient());
            saveOrUpdateService.saveOrUpdateCompletedOrder(singleCompletedOrder);
            completedOrderForExpertDTO=new CompletedOrderForExpertDTO();
            completedOrderForExpertDTO.setIdCompletedOrder(singleCompletedOrder.getId());
        }
        else{
            completedOrderForExpertDTO=new CompletedOrderForExpertDTO();
            completedOrderForExpertDTO.setIdCompletedOrder(singleCompletedOrder.getId());
            completedOrderForExpertDTO.setExpertOpinion(singleCompletedOrder.getExpertOpinion());
            completedOrderForExpertDTO.setFactDifficilty(singleCompletedOrder.getFactDifficilty());
            completedOrderForExpertDTO.setJadgmentCompany(singleCompletedOrder.getJadgmentCompany());
            completedOrderForExpertDTO.setRatingFirm(singleCompletedOrder.getRatingFirm());
        }

        //Если мы имеет дело с существующим объектом, то заполняем DTO


//        model.addAttribute("id_completedOrder",singleCompletedOrder.getId());
        model.addAttribute("completedOrderForExpertDTO",completedOrderForExpertDTO);
        model.addAttribute("employee",employee);
        model.addAttribute("machine",machine);
        model.addAttribute("typeMachine",typeMachine);
        model.addAttribute("serialNumber",serialNumber);
        model.addAttribute("clientRequest",clientRequest);

        return "engineerUpPage";
    }

    @RequestMapping("/engineer/updateWork/update")
    String UpdateReportWork(@ Valid @ModelAttribute("completedOrderForExpertDTO") CompletedOrderForExpertDTO completedOrderForExpertDTO,
                            BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "engineerUpPage";
        }

        CompletedOrder completedOrder=dataBaseTypographService.getSingleCompletedOrder(completedOrderForExpertDTO.getIdCompletedOrder());
        completedOrder.setJadgmentCompany(completedOrderForExpertDTO.getJadgmentCompany());
        completedOrder.setRatingFirm(completedOrderForExpertDTO.getRatingFirm());
        completedOrder.setExpertOpinion(completedOrderForExpertDTO.getExpertOpinion());
        completedOrder.setFactDifficilty(completedOrderForExpertDTO.getFactDifficilty());

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

        OrderDTO orderDTO=new OrderDTO();
        model.addAttribute("orderDTO",orderDTO);

        return "clientOrderPage";
    }

    @RequestMapping("/saveorder")
    String SaveOrder(@Valid @ModelAttribute("orderDTO") OrderDTO orderDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "clientOrderPage";
        }

        TypeMachine typeMachine= dataBaseTypographService.getSingleTypeMachine(orderDTO.getIdTypeMachine());
        Machine machine=dataBaseTypographService.getSingleMachine(orderDTO.getIdMachine());
        SerialNumber serialNumber=dataBaseTypographService.getSingleSerialNumber(orderDTO.getIdSerialNumber());

        ClientRequest order=new ClientRequest(
                orderDTO.getFirm(),
                orderDTO.getInnFirm(),
                typeMachine,
                machine,
                serialNumber,
                orderDTO.getNameClient(),
                orderDTO.getPhoneClient(),
                orderDTO.getDescProblem(),
                orderDTO.getDataWish(),
                orderDTO.getAdress());


        saveOrUpdateService.saveClientRequest(order);

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
        clientOrderID.setId(idClientRequest);

        return "redirect:/admin/adminorder/updateinfo";
    }

    @RequestMapping("/admin/adminorder/updateinfo")
    String updateClientResult(Model model){

        ClientRequest singleClientRequest=dataBaseTypographService.getSingleClientRequest(clientOrderID.getId());
        clientRequestDTO.fillDTO(singleClientRequest);

        TypeMachine typeMachine=dataBaseTypographService.getSingleTypeMachine(singleClientRequest.getIdTypeMachine().getId());
        Machine machine=dataBaseTypographService.getSingleMachine(singleClientRequest.getIdMachine().getId());

        Integer levelDifficulty = singleClientRequest.getDifficilty();
        Integer idTypeMachine = singleClientRequest.getIdTypeMachine().getId();
        // Находим сотрудников компетентных по уровню сложности ремонта и типу машины.
        List<Employee> SuitableEmployees= dataBaseTypographService.
                getListEmployeeForReportWork(levelDifficulty,idTypeMachine);
        //
        List<EmployeeLinkedHashMap> workingCoverageOfDates=
                dataBaseTypographService.fillWorkingCoverageOfDates(SuitableEmployees,singleClientRequest.getDataWish());

        model.addAttribute("сlientOrderDTO",clientRequestDTO);
        model.addAttribute("Employee",SuitableEmployees);
        model.addAttribute("WorkingCoverage",workingCoverageOfDates.iterator());
        model.addAttribute("typeMachine",typeMachine);
        model.addAttribute("machine",machine);

        return "updateOrderWorkPage";
    }

    @RequestMapping("/saveАFullOrder")
    String SaveOrder(@Valid @ModelAttribute("сlientOrderDTO") ClientRequestDTO clientRequestDTO, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "updateOrderWorkPage";
        }

        ClientRequest singleClientRequest=dataBaseTypographService.getSingleClientRequest(clientOrderID.getId());
        clientRequestDTO.fillData(singleClientRequest,
                dataBaseTypographService.getSingleTypeMachine(clientRequestDTO.getIdTypeMachine()),
                dataBaseTypographService.getSingleMachine(clientRequestDTO.getIdMachine()),
                dataBaseTypographService.getSingleSerialNumber(clientRequestDTO.getIdSerialNumber())
        );
        saveOrUpdateService.updateClientRequest(singleClientRequest);

        return "redirect:/admin/adminorder/updateinfo";
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
         WorkDay workDayForFilling=new WorkDay(LocalDate.parse(selectedDate).getDayOfMonth());

        // вношу в него изменения соответствующие выбранному дню, вынужден гонять числа в строки,
        // так как RequestParam не может передавать массивы чисел.
         workDayForFilling.returnArrayInteger(arrayHours);

         //создаю мапу для хранения доступных часов для начала работы в выбранный день
         WorkHours workHours=new WorkHours();

         // заполняем Bean теми полями, которые понадобятся нам для сохранение сущности Work
         myDataBean.setId_employee(id_emp);
         myDataBean.setId_clientRequest(id_clientOrderUpdate);
         myDataBean.setDataTemp(LocalDate.parse(selectedDate));
         myDataBean.setTimeForecast(timeForecast);

        Work newWork=new Work();
        // вызываем график работы одного дня, для выбранного сотрудника
        List<Work> reportDay=dataBaseTypographService.getOneReportDay(id_emp,LocalDate.parse(selectedDate));

        model.addAttribute("listWork",reportDay);
        model.addAttribute("newWorkDay",newWork);
        // заполняю пустую мапу на основании рабочего дня и требуемого времени для ремонта
        model.addAttribute("hours",workHours.fillHours(workDayForFilling,timeForecast));

        return "selectedTabelDayPage";
    }

    @RequestMapping("/admin/adminorder/updateinfo/tableinfo/updateWorkDay")
    String updateNewWorkDay(@ModelAttribute("newWorkDay") Work work){
        // достаем из Bean нужные параметры
        saveOrUpdateService.saveWork(
                                    work,
                                    myDataBean.getId_employee(),
                                    myDataBean.getId_clientRequest(),
                                    myDataBean.getDataTemp(),
                                    myDataBean.getTimeForecast()
                            );

        return "redirect:/admin/adminorder";
    }

    //глобальные Beans, для того, чтобы дергать их из любого места.
    @ModelAttribute
    public void addAttributes(Model model) {

        Map<Integer,String> mapTypeMachine=mapsFromDBService.getListTypeMachines();
        Map<Integer,String> mapMachine=mapsFromDBService.getListMachines();
        List<String> listSerial=mapsFromDBService.getSerialNumber();

        model.addAttribute("typeMachine",mapTypeMachine);
        model.addAttribute("modelMachine",mapMachine);
        model.addAttribute("SerialNumberMachine",listSerial);

    }




}
