package for_test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class TestDataTime {
//    static LocalTime start=LocalTime.of(10,00);
//    static LocalTime end=LocalTime.of(20,00);



    public static void main(String[] args) {
        int incr=0;
        LocalDate locDate0=LocalDate.now();
        LocalDate copylocDate0=locDate0;
        System.out.println(locDate0);
        LocalDate locDate1=LocalDate.of(2022, Month.MAY,10);
        LocalDate locDateFinish;
        LinkedHashMap<Integer,WorkDay> workSession = new LinkedHashMap<>();

        while (copylocDate0.isBefore(locDate1)){
            workSession.put(copylocDate0.getDayOfMonth(),new WorkDay());
            incr+=1;
            copylocDate0=copylocDate0.plusDays(1);
            if (incr>20) {
                locDateFinish=locDate0.plusDays(20);
                System.out.println("Цикл прервался " + locDateFinish);
                break;
            }
        }
        System.out.println("Промежуточное значение мапы \n" + workSession);
        System.out.println(incr);


        if (incr<20) {
            for(int i=incr;i<20;i++){
                workSession.put(copylocDate0.getDayOfMonth(),new WorkDay());
                copylocDate0=copylocDate0.plusDays(1);
            }
            locDateFinish = copylocDate0;
            System.out.println("Дата " + locDate1 + " в нужном диапазоне " + locDateFinish);
        }

        System.out.println("\nФинальное значение мапы \n" + workSession.toString());

        LocalTime lt1=LocalTime.of(15,00);
        LocalTime lt2=LocalTime.of(10,00);
        LocalTime lt3=LocalTime.of(13,00);
        LocalTime lt4=LocalTime.of(19,00);
        WorkDay wd=new WorkDay();
        wd.byWorkNow(lt1,(byte) 4);
        System.out.println(wd);
        wd.byWorkNow(lt2,(byte) 3);
        System.out.println(wd);
        wd.byWorkNow(lt3,(byte) 2);
        System.out.println(wd);
//        wd.byWorkNow(lt4,(byte) 1);
//        System.out.println(wd);
        workSession.replace(4,wd);
        System.out.println("==========================");

        Iterator<Map.Entry<Integer,WorkDay>> iterator=workSession.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,WorkDay> entry=iterator.next();
            System.out.println(entry);
        }

        workSession.get(4).byWorkNow(lt4,(byte) 1);

        Iterator<Map.Entry<Integer,WorkDay>> iterator2=workSession.entrySet().iterator();
        while (iterator2.hasNext()){
            Map.Entry<Integer,WorkDay> entry=iterator2.next();
            System.out.println(entry);
        }
    }
}

class WorkDay {
    byte[] work=new byte[10];
    WorkDay (){
        for (int i=0;i<work.length;i++){
            work[i]=1;
        }
        //System.out.println(Arrays.toString(work));
    }

    void byWorkNow(LocalTime l1, byte b){
        byte buffer=(byte)l1.getHour();
        buffer-=10;
        if ((buffer+b)>10) System.out.println("Рабочий день до 20:00! Переносим работу на завтра");
        else{
            if ((work[buffer]==0) || (work[buffer+b-1]==0)) System.out.println("Время занято!");
            else {
                for (int i = buffer; i < (buffer + b); i++) {
                    work[i] = 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "WorkDay{" +
                "work=" + Arrays.toString(work) +
                '}';
    }
}
