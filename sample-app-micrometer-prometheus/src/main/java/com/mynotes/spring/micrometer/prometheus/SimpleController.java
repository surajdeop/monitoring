package com.mynotes.spring.micrometer.prometheus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SimpleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);


    @GetMapping("/hello")
    public String hello() {
        LOGGER.info( "This is hello Get call");
        return "Hello from test service!!";
    }

    @GetMapping("/hello400")
    public ResponseEntity hello400() {
        LOGGER.info( "This is 400 HTTP status call");
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/hello500")
    public ResponseEntity hello500() {
        LOGGER.info( "This is 500 HTTP status call");
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/latency")
    public ResponseEntity latency() {
        int sleepFor = 11;
        try {
            Thread.sleep(1000 * sleepFor);
        } catch(InterruptedException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/difflatency")
    public ResponseEntity diffLatency() {
        int sleepFor = new Random().nextInt(11);
        LOGGER.info( "Sleep for sec = " + sleepFor);
        try {
            Thread.sleep(1000 * sleepFor);
        } catch(InterruptedException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/createLogs")
    public ResponseEntity createLogs() {
        final int count = 100;
        final String mgs = "Generating fsdr {} logs";
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < new Random().nextInt(10) * count; i++) {
                    LOGGER.info(mgs, "info");
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < new Random().nextInt(10) * count; i++) {
                    LOGGER.debug(mgs , "debug");
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < new Random().nextInt(10) * count; i++) {
                    LOGGER.trace(mgs, "trace");
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < new Random().nextInt(10) * count; i++) {
                    LOGGER.warn(mgs, "warn");
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < new Random().nextInt(10) * count; i++) {
                    LOGGER.error(mgs, "error");
                }
            }
        }).start();
        return new ResponseEntity(HttpStatus.OK);
    }

    private Thread generateLogs(String level) {
        final int count = 100;
        final String mgs = "Generating fsdr {} logs";
        return new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < new Random().nextInt(10) * count; i++) {
                    LOGGER.error(mgs, level);
                }
            }
        });
    }
}
