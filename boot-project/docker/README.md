# Dockerizing a Spring Boot Application

This guide demonstrates how to containerize a Spring Boot application using Docker.

## Step 1: Create a Spring Boot Project

1. Create a new Spring Boot project using [Spring Initializr](https://start.spring.io).
2. Add dependencies for Spring Web when generating the project.

## Step 2: Implement a Controller

Create a controller class `HomeController` with a simple endpoint to test the application.

````java
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/test")
    public String test() {
        return "Welcome to Docker World";
    }
}

## Step:5 Run your application to test your application
``` ./mvnw spring-boot:run  ```

## Step:6 Access the endpoint at [http://localhost:8080/home/test](http://localhost:8080/home/test).


## Step:7 Dockerizing our application
a. Create a jar file
``` ./mvnw clean package ```

b.create Dockerfile file
```touch Dockerfile```

c. Write the command inside Dockerfile
````

FROM openjdk:17
WORKDIR /app
COPY ./target/docker-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
CMD ["java","-jar","docker-0.0.1-SNAPSHOT.jar"]

````

d. build  images
```$ docker build -t [name:tag] . ```
```$ docker build -t shiva/dockerspringboot . ```

e. run our docker container directly with images
```$ docker run -d -p [host_port]:[container_port] --name [container_name] [image_id/image_tag] ```

```$ docker run -d -p 8080:8080 --name dockerspringcont1 shiva/dockerspringboot ```
f. check container running
``` docker container ps ```

g. run our dockerize application
Access the endpoint at [http://localhost:8080/home/test](http://localhost:8080/home/test).





````
