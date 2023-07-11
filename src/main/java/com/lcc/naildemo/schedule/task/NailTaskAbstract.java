package com.lcc.naildemo.schedule.task;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Data
public abstract class NailTaskAbstract implements Runnable {


    private String time;


    private Long interval;


    private TimeUnit unit;

    public LocalTime getLocalTime() {
        return LocalTime.parse(getTime(), DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
