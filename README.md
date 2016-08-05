## spring-cloud-docker-demo
Spring Cloud based microservice architecture with docker cluster using docker-compose.
in-depth details: http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html

# Demo Components
* eureka - Service registry microservice.
* edge - Zuul based routing and load balancing microservice. access API via
* notes - Demo NIO and hystrix based microservice 3 docker instances.
* dashboard - Spring boot dashboard admin console for all microservices.

# Usage
* ./build_images.sh (Build docker images for all from code)
* cd docker
* ./run-cluster.sh

# Access/Ports
* eureka - http://localhost:8761
* edge - http://localhost:8080
* dashboard - http://localhost:8989
