# Student-Management-System
A simple Spring Framework web application based on Spring Data Jpa, Thymeleaf and Spring MVC

## What's Inside
* Maven
* Spring Core
* Spring Data (Jpa, Hibernate & MySql)
* Spring MVC
* Thymeleaf

![Capture](https://user-images.githubusercontent.com/112062787/194829052-0ff962c6-299f-4cf9-aa2c-f552e66c741a.PNG)

![Capture2](https://user-images.githubusercontent.com/112062787/194828828-e754a21d-a598-4c49-a0a4-296321a27a8a.PNG)


## Installation 
Copy then paste on command line to clone the project

`git clone https://github.com/vincolia/Student-Management-System.git`

The project is build on Maven, Pick your IDE then Import Maven > Existing Maven Project 

## Database Configuration
Download and Install [Xampp](https://www.apachefriends.org/download.html) Open and then start `Apache and MySQL`.

Go to http://localhost/phpmyadmin/ or on your MySQL Workbench

Create a MySQL database with the name `sms-db`, you can change the credentials to `/src/main/resources/application.properties`

Default ones are:
```
spring.datasource.url=jdbc:mysql://localhost:3306/sms_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
```

## How to Run
Run the project on your IDE then go to http://localhost:8080/admin/student/home
