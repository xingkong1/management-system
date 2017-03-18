package com.giit.www.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class TaskJob {
    @Scheduled(cron = "0 0 0 1 * ?")
    public void job() {
        TermContainer.update();
    }
}
