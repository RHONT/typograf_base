package org.typograf.functionPack;

import java.time.LocalDate;
import java.time.LocalTime;


    // Хранилище ключей. Этот образец для Bean
public class MyData {
    private Integer id_employee;
    private Integer id_clientRequest;
    private LocalDate dataTemp;

    public Integer getTimeForecast() {
        return timeForecast;
    }

    public void setTimeForecast(Integer timeForecast) {
        this.timeForecast = timeForecast;
    }

    private Integer timeForecast;

    public MyData() {
    }

    public Integer getId_employee() {
        return id_employee;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
    }

    public Integer getId_clientRequest() {
        return id_clientRequest;
    }

    public void setId_clientRequest(Integer id_clientRequest) {
        this.id_clientRequest = id_clientRequest;
    }

    public LocalDate getDataTemp() {
        return dataTemp;
    }

    public void setDataTemp(LocalDate dataTemp) {
        this.dataTemp = dataTemp;
    }


}
