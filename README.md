# ARQ-Demo-Project
Springboot Microservice that fetchs the Customer details from H2 DB using Spring JPA Repository.

# Framework / Libraries used:
        1. Java
        2. Springboot
        3. SpringBoot-started-web
        4. H2 DB
        5. Spring-data-jpa
        6. lombok
        7. Springboot-test-Junit


# Building and Running the application in local
        mvn clean install
        mvn clean spring-boot:run

# Exposed Endpoints

       1. View Account List: 
       Implemented Pagination with Maximun of 6 test accounts.
        http://localhost:8080/com/bnk/cust/v2/accounts?pageSize=6&pageNo=0

       2. View Account Transactions:
        http://localhost:8080/com/bnk/cust/v2/accoutTransaction/2222222222

1. Accountnumbers available in DB for test purpose:
111111111, 222222222, 333333333, 444444444, 555555555, 666666666
2. Transaction Details available for below Account Number for test purpose:
1111111111, 2222222222, 333333333
 - Account number length should not be more than 10
 - AppCorreleationID Header has to be passed
 - Sample postman collection updated in the Repo.
