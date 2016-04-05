Spring Cloud Netflix Sample
===========================

This project is intended to be a test of several spring cloud technologies, namely:

- Service discovery via Eureka server
- Client side balancing using Ribbon
- Edge server using zuul
- Circuit breaker using Hystrix
- Real time monitoring using Hystrix Dashboard + Turbine to aggregate all monitoring streams
- Log correlation using sleuth

  X-B3-TraceId: c058d819e6499487


Run test sample
---------------

Use run-test-suit.sh to start the test (in a local machine environment.
The script uses cygwin, although it shouldn't be difficult to change to a linux environment.


Interesting Links
-----------------

- http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
- http://projects.spring.io/spring-cloud/spring-cloud.html#_hystrix_metrics_stream
- https://github.com/Netflix/Hystrix/wiki/How-To-Use#common-patterns

- https://github.com/Netflix/Turbine/wiki/Configuration-(1.x)#provided-implementations-for-instancediscovery
- https://github.com/Netflix/Turbine/wiki/Configuration-(1.x)#important-note

- https://github.com/ewolff/microservice  A similar demo (using docker)

