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

### Example main page after registration, login and add some content

On this page we can get info about login user (Niezalogowany / Zalogowany jako: username). We can go to main page (Główna), add some content (Dodaj / Zaloguj, aby dodać) and login/logout (Zaloguj/Wyloguj).
After add some content we can add vote up or vote down and click link below description to redirect in blank browser tab.

![alt text](/.readmeimages/image20.jpg)

### Logout page

![alt text](/.readmeimages/image21.jpg)

### Register page

![alt text](/.readmeimages/image22.jpg)

### Enter username and password and click on "Zarejestruj".

![alt text](/.readmeimages/image23.jpg)

### In MySQL database we have one record in user table

![alt text](/.readmeimages/image24.jpg)

### To login enter username and password and click "Zaloguj".

![alt text](/.readmeimages/image25.jpg)

### We have information "Zalogowany jako: użytkownik001".

![alt text](/.readmeimages/image26.jpg)

### Adding content

To add content click "Dodaj" and enter name of content, ULR page and description. Next Click "Dodaj!".

![alt text](/.readmeimages/image27.jpg)

### Added content

On the main page we have content, votes and link.

![alt text](/.readmeimages/image28.jpg)

### Discovery content table

In MySQL database we have information about discovery id, entered data, user id, how many are votes this discovery (up an down).

![alt text](/.readmeimages/image29.jpg)

### Voting

User can add one up vote and one down vote according to one discovery.

![alt text](/.readmeimages/image30.jpg)

### Discovery table

In MySQL database vote up field is update.

![alt text](/.readmeimages/image31.jpg)

### Vote table

In MySQL database we have information about vote id, discovery id, user id and kind of vote (up or down).

![alt text](/.readmeimages/image32.jpg)

### Logout

After logout we have information "Niezalogowany". We can click "Główna" to redirect to main page.

![alt text](/.readmeimages/image33.jpg)

### Admin

In this application exists possibility to add one admin user.

![alt text](/.readmeimages/image34.jpg)

### Admin register and login

![alt text](/.readmeimages/image35.jpg)

![alt text](/.readmeimages/image36.jpg)

![alt text](/.readmeimages/image37.jpg)

![alt text](/.readmeimages/image38.jpg)

### Admin user voting

Admin can add vote on some content. Vote up is registered in MySQL database.

![alt text](/.readmeimages/image39.jpg)

![alt text](/.readmeimages/image40.jpg)

![alt text](/.readmeimages/image41.jpg)

### Admin user adding content

Admin can add some content. This informations are registered in MySQL database too.

![alt text](/.readmeimages/image42.jpg)

![alt text](/.readmeimages/image43.jpg)

### After logout main page

![alt text](/.readmeimages/image44.jpg)

### Add down vote - another user

Content can get vote from author and another users.

![alt text](/.readmeimages/image45.jpg)

![alt text](/.readmeimages/image46.jpg)

![alt text](/.readmeimages/image47.jpg)

### Registration next user

![alt text](/.readmeimages/image48.jpg)

![alt text](/.readmeimages/image49.jpg)

### Next user add up vote and down vote

![alt text](/.readmeimages/image50.jpg)

![alt text](/.readmeimages/image51.jpg)

![alt text](/.readmeimages/image52.jpg)