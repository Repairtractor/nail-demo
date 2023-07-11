package com.lcc.naildemo.schedule.task;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "nail.task.takeaway")
public class TakeawayTask extends NailTaskAbstract{

    @Override
    public void run() {
        System.out.println("TakeawayTask.run");
    }
}
