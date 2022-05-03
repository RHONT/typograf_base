package for_test;

import org.typograf.functionPack.EmployeeLinkedHashMap;
import org.typograf.functionPack.WorkDay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class TestDataTime {
//    static LocalTime start=LocalTime.of(10,00);
//    static LocalTime end=LocalTime.of(20,00);



    public static void main(String[] args) {
        LocalDate locDate1=LocalDate.of(2022, Month.MAY,10);
        EmployeeLinkedHashMap EmpMap=new EmployeeLinkedHashMap(locDate1);
        List<Integer> tl=new ArrayList<>();
        tl.add(11);
        tl.add(22);
        System.out.println(tl.get(0));


        LocalTime lt1=LocalTime.of(15,00);
        LocalTime lt2=LocalTime.of(10,00);
        LocalTime lt3=LocalTime.of(13,00);
        LocalTime lt4=LocalTime.of(19,00);

        WorkDay wd=new WorkDay(50);
        wd.byWorkNow(lt1,(byte) 4);
        System.out.println(wd);
        wd.byWorkNow(lt2,(byte) 3);
        System.out.println(wd);
//        wd.byWorkNow(lt3,(byte) 2);
//        System.out.println(wd);
//        wd.byWorkNow(lt4,(byte) 1);
//        System.out.println(wd);
        EmpMap.workSession.replace(4,wd);
        EmpMap.workSession.get(4).byWorkNow(lt2,(byte) 3);
        EmpMap.workSession.get(10).byWorkNow(lt4,(byte) 3);
        EmpMap.workSession.get(10).byWorkNow(lt4,(byte) 1);


        System.out.println(EmpMap.workSession.get(4).checkDayForWork((byte) 2));

        Iterator<Map.Entry<Integer,WorkDay>> iterator2=EmpMap.workSession.entrySet().iterator();
        while (iterator2.hasNext()){
            Map.Entry<Integer,WorkDay> entry=iterator2.next();
            System.out.println(entry);
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
