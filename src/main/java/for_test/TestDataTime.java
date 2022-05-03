package for_test;

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
        EmpMap.workSession.get(3).byWorkNow(lt2,(byte) 3);
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

class WorkDay {
    int index=0;
    byte[] work=new byte[10];
    WorkDay (Integer index){
        this.index=index;
        for (int i=0;i<work.length;i++){
            work[i]=1;
        }
    }

    void byWorkNow(LocalTime l1, byte b){
        try {
            byte buffer=(byte)l1.getHour();
            buffer-=10;
            if (b+buffer<=10) {
                for (int i = buffer; i < (buffer + b); i++) {
                    work[i] = 0;
                }

            }else System.out.println("ArrayIndexOutOfBoundsException \n Вводные данные ошибочны" +
                    "(Выход за предел рабочего времени) index:" + index);

        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException \n Вводные данные ошибочны index:" + index);
        } finally {

        }

    }

    Boolean checkDayForWork(byte b){
        byte attr=0;
        for (int i = 0; i < 10; i++) {
            if (work[i] == 1) {
                attr+=1;
                if (attr==b) return true;
            } else attr=0;
        }
        return false;
    }

    @Override
    public String toString() {
        return "WorkDay{" +
                "work=" + Arrays.toString(work) +
                '}';
    }
}
//Суть: нужно собрать инфу в мапу, показывающий доступность инженера. Если в текущий день он занят, то
//хорошо бы знать в какие ближайшие дни от этой даты он свободен. Если дата далекая, то до нее 10 дней и после
//нее 10 дней должны быть видны. Если же Дата ближайшая(до 10 дней), то вывести информацию от текущего дня
//и 20 последующих дней

class EmployeeLinkedHashMap{
    //для вычисления количества дней до желаемой даты
    int incrSearch=0;

    LinkedHashMap<Integer,WorkDay> workSession = new LinkedHashMap<>();
    LocalDate now=LocalDate.now();


    public EmployeeLinkedHashMap(LocalDate wishDate) {

        LocalDate copyNow=now;
        // Желаемая дата выходит за центр(больше чем 10 дней от текущего дня)?
        while (copyNow.isBefore(wishDate)){
            incrSearch+=1;
            copyNow=copyNow.plusDays(1);
            if (incrSearch>10) {break;}
        }
        // Если не больше 10 дней, то начинаем заполнят мапу от текущего дня
        if (incrSearch<=10) {
            copyNow=now;
            for(int i=0;i<20;i++){
                workSession.put(copyNow.getDayOfMonth(),new WorkDay(copyNow.getDayOfMonth()));
                copyNow=copyNow.plusDays(1);
            }
        }
        // Если нет, то отнимает от желаем даты 10 дней, чтобы до желаемой даты были дни(10) и после(тоже 10)
        else{
            copyNow=wishDate.minusDays(10);

            for(int i=0;i<20;i++){
                workSession.put(copyNow.getDayOfMonth(),new WorkDay(copyNow.getDayOfMonth()));
                copyNow=copyNow.plusDays(1);
            }
        }
    }

}

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
