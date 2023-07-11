package com.lcc.naildemo.schedule;

import com.lcc.naildemo.schedule.task.NailTaskAbstract;
import com.plan.forecast.dubbo.DubboService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Slf4j
@RequiredArgsConstructor
public class ScheduledTaskRunner implements ApplicationRunner {

    private final Collection<NailTaskAbstract> tasks;




    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("TakeawayTask.run........");

        tasks.forEach(ScheduleUtil::execute);
    }
}
