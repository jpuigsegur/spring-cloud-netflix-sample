#  Spring Cloud Netflix Sample

This project is intended to be a test and practical example of several spring cloud technologies, namely:

- Service discovery via Eureka server
- Client side balancing using Ribbon
- Edge server using zuul
- Circuit breaker using Hystrix
- Real time monitoring using Hystrix Dashboard + Turbine
- Log correlation using sleuth
- Swagger to document microservices API

## Service discovery via Eureka server

## Client side balancing using Ribbon

## Edge server using zuul

Exposed endpoints:
http://localhost:8080/one/microservice-one/
http://localhost:8080/two/microservice-two/

## Circuit breaker using Hystrix

##  Real time monitoring

Real time monitoring using Hystrix Dashboard + Turbine to aggregate all monitoring streams in a single Dashboard.

## Log correlation using sleuth

  Adding spring.cloud.sleuth dependency we get a consistent TraceId added to all the 
  logs in all microservices, and we also get the following header in the JSon 
  response:  ` X-B3-TraceId: c058d819e6499487`

## Using swagger to document microservices API

  Online documentation and tester available at: http://localhost:xxxx/swagger-ui.html
  JSON swagger API specification available at: http://localhost:xxxx/api-docs/

## How to run test sample

Use run-test-suit.sh to start the test (in a local machine environment.
The script uses cygwin, although it shouldn't be difficult to change to a linux environment.


## Interesting Links

- http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
- https://github.com/ewolff/microservice  A similar demo (using docker)

### Hystrix

- https://github.com/Netflix/Hystrix/wiki/How-To-Use#common-patterns
- http://projects.spring.io/spring-cloud/spring-cloud.html#_hystrix_metrics_stream

### Turbine

- https://github.com/Netflix/Turbine/wiki/Configuration-(1.x)#provided-implementations-for-instancediscovery
- https://github.com/Netflix/Turbine/wiki/Configuration-(1.x)#important-note

### Swagger and SpringFox

- http://springfox.github.io/springfox/docs/current/
- https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X
- http://www.hascode.com/2015/07/integrating-swagger-into-a-spring-boot-restful-webservice-with-springfox/
- http://heidloff.net/article/usage-of-swagger-2-0-in-spring-boot-applications-to-document-apis/
- http://fizzylogic.nl/2015/07/29/quickly-generate-api-docs-for-your-spring-boot-application-using-springfox/

