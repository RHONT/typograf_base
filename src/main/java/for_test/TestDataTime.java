package for_test;


import org.typograf.functionPack.EmployeeLinkedHashMap;
import org.typograf.functionPack.WorkDay;
import org.typograf.functionPack.WorkHours;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class TestDataTime {
//    static LocalTime start=LocalTime.of(10,00);
//    static LocalTime end=LocalTime.of(20,00);



    public static void main(String[] args) {
        LocalDate locDate1=LocalDate.of(2022, Month.MAY,16);
        EmployeeLinkedHashMap empMap=new EmployeeLinkedHashMap(locDate1);
        WorkHours hours=new WorkHours();



        LocalTime lt1=LocalTime.of(15,00);
        LocalTime lt2=LocalTime.of(10,00);
        LocalTime lt3=LocalTime.of(13,00);
        LocalTime lt4=LocalTime.of(19,00);

        WorkDay wd=new WorkDay(locDate1.getDayOfMonth());
        wd.byWorkNow(lt1,4);
        System.out.println(wd);
        wd.byWorkNow(lt2,3);
        System.out.println(wd);
//
//        wd.byWorkNow(lt3,2);
//        System.out.println(wd);
//        wd.byWorkNow(lt4,1);
//        System.out.println(wd);

        empMap.workSession.replace(locDate1,wd);
        System.out.println(hours.fillHours(wd));
        System.out.println("str");
        System.out.println(wd.returnArrayString());
        WorkDay wdTest=new WorkDay(1);
        wdTest.returnArrayInteger(wd.returnArrayString());
        System.out.println("Новый день");
        System.out.println(Arrays.toString(wdTest.getWork()));








        Iterator<Map.Entry<LocalDate,WorkDay>> iterator2=empMap.workSession.entrySet().iterator();
        while (iterator2.hasNext()){
            Map.Entry<LocalDate,WorkDay> entry=iterator2.next();
            System.out.println(entry);

//        Iterator<Map.Entry<Integer,WorkDay>> iterator2=EmpMap.workSession.entrySet().iterator();
//        while (iterator2.hasNext()){
//            Map.Entry<Integer,WorkDay> entry=iterator2.next();
//            System.out.println(entry);
        }
    }
}

//Суть: нужно собрать инфу в мапу, показывающий доступность инженера. Если в текущий день он занят, то
//хорошо бы знать в какие ближайшие дни от этой даты он свободен. Если дата далекая, то до нее 10 дней и после
//нее 10 дней должны быть видны. Если же Дата ближайшая(до 10 дней), то вывести информацию от текущего дня
//и 20 последующих дней

//
//while (copylocDate0.isBefore(locDate1)){
//        workSession.put(copylocDate0.getDayOfMonth(),new WorkDay());
//        incr+=1;
//        copylocDate0=copylocDate0.plusDays(1);
//        if (incr>20) {
//        locDateFinish=locDate0.plusDays(20);
//        System.out.println("Цикл прервался " + locDateFinish);
//        break;
//        }
//        }
//        System.out.println("Промежуточное значение мапы \n" + workSession);
//        System.out.println(incr);
//
//
//        if (incr<20) {
//        for(int i=incr;i<20;i++){
//        workSession.put(copylocDate0.getDayOfMonth(),new WorkDay());
//        copylocDate0=copylocDate0.plusDays(1);
//        }
//        locDateFinish = copylocDate0;
//        System.out.println("Дата " + locDate1 + " в нужном диапазоне " + locDateFinish);
//        }
