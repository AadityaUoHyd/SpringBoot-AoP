# SpringBoot-AoP Demo program for centralised logging

- Program to write logging mechanism using spring AOP, decoupled secondary business logic from primary business, 
  using Spring AoP in Spring Boot environment.

- After running this program :
 
 * Runner will test by-default, @After and @Before in console with given SoP's.
 
 * Now, clear your console.
 
 * Open browser and hit URL: "http://localhost:8080/findProducts/" - To test @Around
 
 * Again clear your console & Hit URL: "http://localhost:8080/findProducts/101" - To test @AfterReturning
 
 * Hit URL: "http://localhost:8080/findProducts/105" - To test @AfterThrowing
 

