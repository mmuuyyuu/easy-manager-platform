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
 * @Date 2020/12/11 15:14
 */
@EnableScheduling
@SpringBootApplication
public class PortalApplication {


    public static void main(String[] args) {

        try {

            System.out.println("Hello World!");
            ConfigurableApplicationContext context = SpringApplication.run(PortalApplication.class, args);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}