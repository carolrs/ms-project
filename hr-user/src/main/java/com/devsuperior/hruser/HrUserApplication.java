package com.devsuperior.hroauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

        //String senhaCriada = "123456";

        //String hashed = passwordEncoder.encode(senhaCriada);
       // System.out.println("BCRYPT = " + hashed);


        //boolean correct = passwordEncoder.matches(senhaCriada, hashed);

        //boolean wrong = passwordEncoder.matches("56789", hashed);

       /* System.out.println("Correta: " + correct);
        System.out.println("Errada: " + wrong);


        boolean isWrong = true;
        int senha = 0;
        long start = System.currentTimeMillis();
        while (isWrong) {

            if (passwordEncoder.matches(senha+"", hashed)) {
                isWrong = false;
            } else {
                senha++;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("Sua senha é: " + senha + " e foi encontrada em " + ((end - start) / 1000));*/

    }
}
