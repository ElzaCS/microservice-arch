# Microservice-Architecture
Sample currency-conversion app made of multiple micro-services.

Microservices include:
- **limits-service**: manages constants related to deployment
    - http://localhost:8888/limits-service/default
- **currency-conversion-service**: calculates equivalent value in currency
    - http://localhost:8100/currency-convertor-feign/from/USD/to/INR/quantity/100
- **currency-exchange-service**: constants related to currency conversion
    - http://localhost:8000/currency-exchange/from/USD/to/INR
    - http://localhost:8000/h2-console (in-memory db)
- **netflix-eureka-naming-server**: recognizes various instances of different services for load-balancing and communication between micro-services
    - http://localhost:8761/
- **netflix-zuul-api-gateway-server**: API gateway for all micro-services to implement common features like authentication/authorization, fallback methods, etc.
    - without gatewayRouter: http://localhost:8765/{app-name}/{uri}
        - http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
        - http://localhost:8765/currency-conversion-service/currency-convertor-feign/from/USD/to/INR/quantity/100
    - with gatewayRouter: http://localhost:8765/{uri}
        - http://localhost:8765/currency-convertor-feign/from/USD/to/INR/quantity/100


Dependencies include:
- [H2database](https://mvnrepository.com/artifact/com.h2database/h2): In-memory database
- [Feign-Client](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-feign): Useful for creating proxy between microservices
- **spring-cloud-loadbalancer**: Useful for loadbalancing, imported with project at https://start.spring.io/
- [Zuul-Client](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-zuul)
- [Hystrix](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-hystrix)
- [Eureka-Client](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client): To register each microservice with eureka, useful for load-balancing and communication between microservices
- [Sleuth-Client](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-sleuth)
- [Zipkin-Client](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-zipkin): For distributed tracing of logs
- [RabbitMQ-Client](https://mvnrepository.com/artifact/org.springframework.amqp/spring-rabbit): Useful for communication between micro-services and zipkin

## Local Setup
- Requirements include:
    - Setup a local-gitconfig-repo: To fetch limits from limits-service
    - [RabbitMQ](https://www.digitalocean.com/community/tutorials/how-to-install-and-manage-rabbitmq): For communication between the microservices and Zipkin
    - [Zipkin](https://zipkin.io/pages/quickstart): To trace logs of different microservices at a single place
        - Run at commandline: `RABBIT_URI=amqp://localhost java -jar zipkin.jar`
        - Default url: http://localhost:9411/zipkin
- Run each microservice as a Java application

## Docker Setup
- Building docker images for each microservice: `mvn spring-boot:build-image -DskipTests`
- Update image name in docker-compose.yaml
- Run `docker-compose up`