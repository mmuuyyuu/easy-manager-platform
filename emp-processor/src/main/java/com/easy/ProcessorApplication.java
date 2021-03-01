package com.easy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Packge com.easy
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/2/18 14:58
 */
@EnableScheduling
@SpringBootApplication
public class ProcessorApplication {
    public static void main(String[] args) {

        try {
            System.out.println("Hello processor!");
            ConfigurableApplicationContext context = SpringApplication.run(ProcessorApplication.class, args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

