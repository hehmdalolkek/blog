# Blog
A Spring Boot project. MySQL was used as a database, Flyway was used for migration. The project is built on: Spring Web MVC, Thymeleaf, Spring Data JPA, Testcontrainers. For security, Spring Security, OAuth2 were used - authorization was done using a form, Google and GitHub.

## Technologies
* Java 21
* Maven
* Spring Boot 3
* Spring Web
* Thymeleaf
* Spring Security
* Spring Data JPA
* Lombok
* MapStruct
* Passay
* MySQL
* Flyway
* Testcontainers

## Run locally
A working Docker is required to start the project. Docker uses a database launched using testcontainers.

You can build a jar file and run it from the command line:
```
git clone https://github.com/hehmdalolkek/blog.git
cd blog
./mvnw package
java -jar target/blog-0.0.1-SNAPSHOT.jar
```
You can then access the project at http://localhost:8080/.