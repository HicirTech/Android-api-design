package com.BCIS.brak_trak_api_tester;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Temp {

    private int id;
    private float temp;
    private LocalDateTime time;

    Temp(int id, float temp, String time) {
        this.id = Integer.valueOf(id);
        this.temp = Float.valueOf(temp);

        time = time.substring(0,19);
        String date = time.split("T")[0];
        String dateTime = time.split("T")[1];
        LocalDate dateP = LocalDate.parse(date);
        LocalTime timeP = LocalTime.parse(dateTime,DateTimeFormatter.ofPattern("HH:mm:ss"));


        this.time = LocalDateTime.of(dateP,timeP);
    }

    public String toString() {
        return this.id + " " + this.temp + " " + this.time;
    }

}
