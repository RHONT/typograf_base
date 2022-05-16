package org.typograf.functionPack;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class WorkDay {
    int index = 0;
    int[] work = new int[10];

    public WorkDay(Integer dayOfMonth) {
        this.index = dayOfMonth;
        for (int i = 0; i < work.length; i++) {
            work[i] = 1;
        }
    }

    public void byWorkNow(LocalTime l1, int b) {
        try {
            int buffer = l1.getHour();
            buffer -= 10;
            if (b + buffer <= 10) {
                for (int i = buffer; i < (buffer + b); i++) {
                    work[i] = 0;
                }

            } else System.out.println("ArrayIndexOutOfBoundsException \n Вводные данные ошибочны" +
                    "(Выход за предел рабочего времени) index:" + index);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException \n Вводные данные ошибочны index:" + index);
        } finally {

        }

    }

    public Boolean checkDayForWork(int b) {
        byte attr = 0;
        for (int i = 0; i < 10; i++) {
            if (work[i] == 1) {
                attr += 1;
                if (attr == b) return true;
            } else attr = 0;
        }
        return false;
    }

    public String ReturnDayForWorkStatus(int b) {

        byte attr = 0;
        for (int i = 0; i < 10; i++) {
            if (work[i] == 1) {
                attr += 1;
                if (attr == b) return "(+)";
            } else attr = 0;
        }
        return "(-)";
    }

    @Override
    public String toString() {
        return "WorkDay{" +
                "work=" + Arrays.toString(work) +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public int[] getWork() {
        return work;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setWork(int[] work) {
        this.work = work;
    }

    public String returnArrayString(){
        String hoursArray = new String();

        for(int i=0;i<work.length;i++){
            hoursArray=hoursArray.concat(String.valueOf(work[i])).concat(" ");
        }

        return hoursArray;
    }
    public void returnArrayInteger(String returnedStringArray){
        String[] arrayHours=new String[10];
        arrayHours=returnedStringArray.split(" ");

        for(int i=0;i<work.length;i++){
            work[i]=Integer.valueOf(arrayHours[i]);
        }

    }
}
