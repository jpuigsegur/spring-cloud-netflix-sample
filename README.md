Netflix Spring Cloud Sample
###########################

Eureka server
=============

- http://localhost:8761

Microservices
=============

Accessing microservice ONE directly:

- http://localhost:9001/

Accessing microservice TWO directly:

- http://localhost:9001/

Via zuul server:

- http://localhost:8080/microservice-one
- http://localhost:8080/microservice-two

Hystrix Dashboard
=================

- http://localhost:9100/hystrix

  - http://localhost:9100/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9001%2Fhystrix.stream
  - http://localhost:9001/hystrix.stream
  - http://localhost:9100/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8080%2Fhystrix.stream
  - http://localhost:8080/hystrix.stream


Launch projects
===============




Links
=====

- http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
- http://projects.spring.io/spring-cloud/spring-cloud.html#_hystrix_metrics_stream

- https://github.com/Netflix/Turbine/wiki/Configuration-(1.x)#provided-implementations-for-instancediscovery
- https://github.com/Netflix/Turbine/wiki/Configuration-(1.x)#important-note

- https://github.com/ewolff/microservice  An interesting similar demo


Other info
==========

- Turbine 2.x:   turbine.combineHostPort = true   (it seems we do not need it under spring.cloud.netflix)
