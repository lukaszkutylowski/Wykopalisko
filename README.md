# **Wykopalisko Web Application**

This is a web application which contains functionalities like: registration user, login / logut user, add new discoveries with link URL, voting on discoveries.

## Used technologies:
* Dependency Injection
* Spring MVC
* Spring Boot
* OOP
* JSP
* JSTL
* HTML
* CSS
* DAO Factory
* JDBC
* Exception
* SQL / Prepared SQL
* Spring Tool Suite STS

## Description

### WykopaliskoDemo3Application

It is an Spring Boot application start class with *SpringBootApplication* annotation.

![alt text](/.readmeimages/image2.jpg)

### ConnectionProvider

*ConnectionProvider* class file contains database connection configuration.
In this application is used MySQL database.
Connection with database is provided by *MysqlDataSource dataSource* object.
*getDataSource()* method set database url, user and password connected with database.
*getConnection()* method initialize connection with database wuth using *MysqlDataSource dataSource* object.

![alt text](/.readmeimages/image3.jpg)

