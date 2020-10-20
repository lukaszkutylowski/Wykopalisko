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

### WykopaliskoDemo3Application.java

It is an Spring Boot application start class with *SpringBootApplication* annotation.

![alt text](/.readmeimages/image2.jpg)

### ConnectionProvider.java

*ConnectionProvider* class file contains database connection configuration.
In this application is used MySQL database.
Connection with database is provided by *MysqlDataSource dataSource* object.
*getDataSource()* method set database url, user and password connected with database.
*getConnection()* method initialize connection with database wuth using *MysqlDataSource dataSource* object.

![alt text](/.readmeimages/image3.jpg)

### User.java

*User* class it is a data model class with fields: user_id, username, password, is_admin; empty constructor and constructor with fields (without user_id).
Moveover this class contains getters, setters, toString, hashCode and equals methods.

![alt text](/.readmeimages/image4.jpg)

### Discovery.java

*Discovery* class it is a data model class with fields: discovery_id, name, description, url, User user, vote_up, vote_down; empty constructor and constructor with fields.
Moveover this class contains getters, setters, toString, hashCode and equals methods.

![alt text](/.readmeimages/image5.jpg)

### Vote.java

*Vote* class it is a data model class with fields: vote_id, discovery_id, user_id, type; empty constructor and constructor with fields (without user_id).
Moveover this class contains getters, setters, toString, hashCode and equals methods.

![alt text](/.readmeimages/image6.jpg)