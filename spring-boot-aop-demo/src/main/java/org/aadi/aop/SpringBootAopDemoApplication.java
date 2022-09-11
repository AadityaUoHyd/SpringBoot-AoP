//JavaTechie AoP coding practice

package org.aadi.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopDemoApplication.class, args);
	}

}

/*
 * At first, Run this program.
 * 
 * Runner will test by-default, @After and @Before in console with given SoP's.
 * 
 * Now, clear your console.
 * 
 * Open browser and hit URL: "http://localhost:8080/findProducts/" - To test @Around
 * 
 * Hit URL: "http://localhost:8080/findProducts/101" - To test @AfterReturning
 * 
 * Hit URL: "http://localhost:8080/findProducts/105" - To test @AfterThrowing
 * 
 * */
