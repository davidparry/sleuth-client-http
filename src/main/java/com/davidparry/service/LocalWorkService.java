package com.davidparry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LocalWorkService {

    private final Logger logger = LoggerFactory.getLogger(LocalWorkService.class);


    public String doWorkFor(long time) {
        logger.info("Starting some work for {} milliseconds", time);
        workingCall("Beginning");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            logger.error("Error simulating work for {} milliseconds ", time, e);
        }
        logger.debug("Completed doing the work for {} milliseconds", time);
        workingCall("End");
        return "done" + time;
    }

    public void workingCall(String message) {
        logger.info("Working call getting called @ the "+ message);
    }


}
