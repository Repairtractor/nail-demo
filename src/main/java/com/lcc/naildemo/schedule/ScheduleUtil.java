package com.lcc.naildemo.schedule;

import com.lcc.naildemo.schedule.task.NailTaskAbstract;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class ScheduleUtil {

    static ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    /**
     * 定时执行任务
     *
     * @param command      任务
     * @param time         执行时间
     * @param initialDelay 间隔时间
     * @param unit         单位
     */
    public static ScheduledFuture<?> execute(Runnable command, LocalTime time, long initialDelay, TimeUnit unit) {
        //1. 首先将initialDelay转换为秒
        long initialDelaySeconds = unit.toSeconds(initialDelay);
        //2. 获取到第一次执行的时间间隔
        long firstInitialDelay = getFirstInitialDelay(time, initialDelaySeconds);
        return executor.scheduleAtFixedRate(command, firstInitialDelay, initialDelaySeconds, TimeUnit.SECONDS);
    }

    public static ScheduledFuture<?> execute(NailTaskAbstract task) {
        return execute(task, task.getLocalTime(), task.getInterval(), task.getUnit());
    }





    /**
     * 获取第一次执行的时间间隔
     *
     * @param time     执行时间
     * @param interval 间隔时间 ,单位秒
     * @return
     */
    private static long getFirstInitialDelay(LocalTime time, long interval) {
        // 获取当前时间
        LocalTime now = LocalTime.now();

        LocalTime nextExecutionTime = LocalTime.of(time.getHour(), time.getMinute(), time.getSecond());
        // 如果当前时间大于等于执行时间，则将执行时间设置为明天
        if (now.isAfter(nextExecutionTime)) {
            nextExecutionTime = nextExecutionTime.plusSeconds(interval);
        }
        // 计算当前时间到执行时间的时间间隔
        return Math.abs(ChronoUnit.SECONDS.between(nextExecutionTime, now));
    }


}
