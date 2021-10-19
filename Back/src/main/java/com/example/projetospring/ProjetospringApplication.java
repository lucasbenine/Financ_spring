package com.example.projetospring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetospringApplication {

    public static void main(String[] args) {       
    	
    	SpringApplication.run(ProjetospringApplication.class, args);

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.comprasparaguai.com.br");
    }
    
}

