# Amazon Food Review

Demo application to practice with Spring Boot

## Description

This should be RESTful app. We are not interesting in the UI.

The goal of this task is to analyze and transform the > 500.000 reviews from amazon.

We are interested in:

1) Finding 1000 most active users (profile names)

2) Finding 1000 most commented food items (item ids).

3) Finding 1000 most used words in the reviews

## Instructions

Run application, on first run it will download file with data (~300MB).<br>
Wait until data from file will be inserted into DataBase (DB).<br><br>
After receiving message like<br>
<b>Started AmazonReviewApplication in 60.295 seconds (JVM running for 61.352)</b><br>
application is running and you can continue work with it.

### Authorization

Application using JWT token for authentication.
You need to get JWT token by sending **POST** request to:<br>
<a href="http://localhost:8080/authenticate">http://localhost:8080/authenticate</a><br>
with body 
<pre>
{
    "username":"user", 
    "password":"1234"
}
</pre>
From response you need get token (example of response):
<pre>
{
    "jwt": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTgzNzgwMDE1LCJpYXQiOjE1ODM3NjIwMTV9.E2Hc-Kdytev220OG83Fgpu3PF7Y11eV036lOpeq6JvlJx2l0QufpcGFKZijpNpo1kWAyTcb3KWrqKPEC-m6M_g"
}
</pre>
and add Authorization header for you next requests with **Bearer** + token, for example:<br>
<pre>
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTgzNzgwMDE1LCJpYXQiOjE1ODM3NjIwMTV9.E2Hc-Kdytev220OG83Fgpu3PF7Y11eV036lOpeq6JvlJx2l0QufpcGFKZijpNpo1kWAyTcb3KWrqKPEC-m6M_g
</pre>

### Review controller

There are following functions available:

To get most active users use following link:
<a href="http://localhost:8080/reviews/top-users">localhost:8080/reviews/top-users</a>

To get most commented food items use following link:
<a href="http://localhost:8080/reviews/top-products">localhost:8080/reviews/top-products</a>

To get most used words use following link:
<a href="http://localhost:8080/reviews/top-words">localhost:8080/reviews/top-words</a>

Use **GET** method, also pagination available.
Use parameters "**page**" and "**limit**", for example:<br>
<a href="http://localhost:8080/reviews/top-users?page=3&limit=10">localhost:8080/reviews/top-users?page=3&limit=10</a>

## Technology stack

Java 11, Spring Boot, Spring WebMVC, Spring Data, Spring Security, JWT, Swagger, H2 DB, Jackson CSV

## Author

<a href="https://github.com/ElvenNurse">Andrii Voloshyn</a>
