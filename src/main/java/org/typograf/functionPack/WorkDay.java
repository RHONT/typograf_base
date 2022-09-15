package org.typograf.functionPack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Arrays;

public class WorkDay {

    private static final Logger log= LoggerFactory.getLogger(WorkDay.class);
    int dayOfMonth;
    int[] work = new int[10];

    // заполняем массив "1" и присваиваем dayOfMonth значение дня месяца
    public WorkDay(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        Arrays.fill(work, 1);
    }

    // Проверка и изменение: Необходимое время для работы может ли вписаться в конкретный рабочий день.
    public void byWorkNow(LocalTime selectedTimeForWork, int timeForecast) {

            int selectedHour = selectedTimeForWork.getHour();
            // Отнимаем сразу 10 часов, чтобы синхронизировать часы с началом рабочего дня
            // Рабочий день начинается с 10:00
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

    // Возвращаем символ, который будет выведен во view, "+" сотрудник может, "-" сотрудник занят.
    // Единица в массиве означает свободный час. Если заполнен единицами весь, значит день полностью свободен.
    public String ReturnDayForWorkStatus(int timeForecast) {
        byte tempIncrement = 0;
        for (int i = 0; i < 10; i++) {
            if (work[i] == 1) {
                //копим инкремент
                tempIncrement += 1;
                //если совпадает с требуемым временем, то "+"
                if (tempIncrement == timeForecast) return "(+)";
                // если нет, то обнуляем инкремент и начинаем его копить заново
            } else tempIncrement = 0;
        }
        return "(-)";
    }


    // переводим числовой вид массива в строку(Handler передающий со View чтобы не ругался на "не строку")
    public String returnArrayString(){
        String hoursArray = "";

        for (int j : work) {
            hoursArray = hoursArray.concat(String.valueOf(j)).concat(" ");
        }
        return hoursArray;
    }

    // Обратный перевод из строки в числовое значение массива
    public void returnArrayInteger(String returnedStringArray){
        String[] arrayHours = returnedStringArray.split(" ");

        for(int i=0;i<work.length;i++){
            work[i]=Integer.parseInt(arrayHours[i]);
        }
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int[] getWork() {
        return work;
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
