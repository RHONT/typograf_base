package for_test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.TreeSet;

public class TestDataTime {
    static LocalTime start=LocalTime.of(10,00);
    static LocalTime end=LocalTime.of(20,00);


    public static void main(String[] args) {
        LocalTime lt1;
        lt1=LocalTime.of(15,00);
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
        wd.byWorkNow(lt4,(byte) 1);
        System.out.println(wd);

    }
}

class WorkDay {
    byte[] work=new byte[10];

    WorkDay (){

        for (int i=0;i<work.length;i++){
            work[i]=1;
        }
        System.out.println(Arrays.toString(work));
    }

    void byWorkNow(LocalTime l1, byte b){
        byte buffer=(byte)l1.getHour();


        buffer-=10;
//        if (buffer>0) buffer-=1;

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
