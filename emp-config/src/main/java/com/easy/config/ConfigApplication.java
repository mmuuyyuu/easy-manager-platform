package com.easy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Packge com.easy.config
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2020/12/10 16:09
 */
@SpringBootApplication
@EnableScheduling
public class ConfigApplication {
    public static void main(String[] args) {

        try {
             System.out.println("Hello World!");
            ConfigurableApplicationContext context = SpringApplication.run(ConfigApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
