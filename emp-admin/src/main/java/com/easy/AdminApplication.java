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
public class AdminApplication {


    public static void main(String[] args) {

        try {

            System.out.println("Hello World!");
            ConfigurableApplicationContext context = SpringApplication.run(AdminApplication.class, args);

         //   BalanceMapper mapper = context.getBean(BalanceMapper.class);
         //   Balance risk = new Balance();

         //   Page<Balance> list = PageHelper.startPage(1, 11).doSelectPage(() -> mapper.list(risk));

        //    System.out.println("result ::: " + list.getTotal());
            //ModelAndAlgorithm p = new ModelAndAlgorithmProcessor();

            //  p.process("commonlisted");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}