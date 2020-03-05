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
open following link in your web browser: 
<a href="http://localhost:8080/">http://localhost:8080/</a><br>
You will see the login page, use <b>user</b> as username and <b>1234</b> as password<br>

To get most active users open following link:
<a href="http://localhost:8080/reviews/top-users">Top users</a>

To get most commented food items open following link:
<a href="http://localhost:8080/reviews/top-products">Top products</a>

To get most used words open following link:
<a href="http://localhost:8080/reviews/top-words">Top words</a>

## Technology stack

Java 11, Spring Boot, Spring WebMVC, Spring Data, Spring Security, Swagger, H2 DB, Jackson CSV

## Author

<a href="https://github.com/ElvenNurse">Andrii Voloshyn</a>
