package org.typograf.functionPack;

import java.time.LocalTime;
import java.util.Arrays;

public class WorkDay {
    int index = 0;
    int[] work = new int[10];

    public WorkDay(Integer index) {
        this.index = index;
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

    @Override
    public String toString() {
        return "WorkDay{" +
                "work=" + Arrays.toString(work) +
                '}';
    }
}
