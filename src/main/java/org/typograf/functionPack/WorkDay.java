package org.typograf.functionPack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Arrays;

public class WorkDay {
    private static final Logger log= LoggerFactory.getLogger(WorkDay.class);
    int dayOfMonth = 0;
    int[] work = new int[10];

    public WorkDay(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        for (int i = 0; i < work.length; i++) {
            work[i] = 1;
        }
    }

    // Проверка и изменеие: Необходимое время для работы может ли вписаться в конкретный рабочий день.
    public void byWorkNow(LocalTime selectedTimeForWork, int timeForecast) {

            int selectedHour = selectedTimeForWork.getHour();
            // Отнимаем сразу 10 часов, чтобы синхронизировать часы с началом рабочего дня
            // Рабочий день начинаеться с 10:00
            selectedHour -= 10;
            // График с 10:00-20:00. Если требуемое время заставляет перерабатывать сотрудника
            // значит такая работа порочна. И массив не заполняется по такой заявке.
            if (timeForecast + selectedHour <= 10) {
                for (int i = selectedHour; i < (selectedHour + timeForecast); i++) {
                    work[i] = 0;
                }
            } else {
                log.warn("(Выход за предел рабочего времени) День: {}",dayOfMonth);
                System.err.println("ArrayIndexOutOfBoundsException. День ошибки:" + dayOfMonth);
            }


    }

    // "Полезная" функция, но не нашедшая применения. Пожалуй на релизе удалю.
    // Проверяет вписываеться ли отведенное количество на ремонт часов в текущий день.
    public Boolean checkDayForWork(int hourseForWork) {
        byte attr = 0;
        for (int i = 0; i < 10; i++) {
            if (work[i] == 1) {
                attr += 1;
                if (attr == hourseForWork) return true;
            } else attr = 0;
        }
        return false;
    }

    // возвращаем символ, который будет выведен во view, "+" сотрудник может, "-" сотрудник занят.
    // Еденица в массиве означает свободный час. Если заполнен еденицами весь, значит день полностью свободен.
    public String ReturnDayForWorkStatus(int timeForecast) {
        byte tempIncrement = 0;
        for (int i = 0; i < 10; i++) {
            if (work[i] == 1) {
                //копим инкремент
                tempIncrement += 1;
                //если совпадает с требуемым временем, то "+"
                if (tempIncrement == timeForecast) return "(+)";
                // если нет, то "-"
            } else tempIncrement = 0;
        }
        return "(-)";
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    // переводим числовой вид массива в строку(Handler передающий со View чтобы не ругался на "не строку")
    public String returnArrayString(){
        String hoursArray = new String();

        for(int i=0;i<work.length;i++){
            hoursArray=hoursArray.concat(String.valueOf(work[i])).concat(" ");
        }

        return hoursArray;
    }

    // Обратный перевод из строки в числовое значение массива
    public void returnArrayInteger(String returnedStringArray){
        String[] arrayHours=new String[10];
        arrayHours=returnedStringArray.split(" ");

        for(int i=0;i<work.length;i++){
            work[i]=Integer.valueOf(arrayHours[i]);
        }
    }

    public int[] getWork() {
        return work;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void setWork(int[] work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "WorkDay{" +
                "work=" + Arrays.toString(work) +
                '}';
    }
}
