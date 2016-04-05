# To be run in cygwin

# eureka server
mintty --title=eureka/8761 java -jar netflix-eureka-server/target/netflix-eureka-server-0.0.1-SNAPSHOT.jar &
sleep 10s

# microservice-one: 2 instances
mintty --title=microservice-one/9011 java -Dserver.port=9011 -jar netflix-microservice-one/target/microservice-one-0.0.1-SNAPSHOT.jar &
sleep 20s
mintty --title=microservice-one/9012 java -Dserver.port=9012 -jar netflix-microservice-one/target/microservice-one-0.0.1-SNAPSHOT.jar &
sleep 20s

# microservice-two: 4 instances
mintty --title=microservice-two/9021 java -Dserver.port=9021 -jar netflix-microservice-two/target/microservice-two-0.0.1-SNAPSHOT.jar &
sleep 20s
mintty --title=microservice-two/9022 java -Dserver.port=9022 -jar netflix-microservice-two/target/microservice-two-0.0.1-SNAPSHOT.jar &
sleep 20s
mintty --title=microservice-two/9023 java -Dserver.port=9023 -jar netflix-microservice-two/target/microservice-two-0.0.1-SNAPSHOT.jar &
sleep 25s

# zuul server
mintty --title=zuul/8080 java -jar netflix-zuul-server/target/netflix-zuul-server-0.0.1-SNAPSHOT.jar &
sleep 30s

# Turbine service
mintty --title=turbine/9200 java -jar netflix-hystrix-turbine/target/netflix-hystrix-turbine-0.0.1-SNAPSHOT.jar &
sleep 30s

# Hystrix Dashboard service
mintty --title=Hystrix-Dashboard/9100 java -jar netflix-hystrix-dashboard/target/netflix-hystrix-dashboard-0.0.1-SNAPSHOT.jar &
sleep 30s

cygstart http://localhost:8761
cygstart http://localhost:9100/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9200%2Fturbine.stream%3Fcluster%3DMYCLUSTER%20
