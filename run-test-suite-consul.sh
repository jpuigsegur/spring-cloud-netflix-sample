# To be run in cygwin

# Build demo (select discoveryServiceConsul profile)
mvn clean package -P -discoveryServiceEureka,discoveryServiceConsul

# Consul server
# Download consul from consul.io and run locally in development mode
mintty --title=consul/8500 consul agent -dev -bind=127.0.0.1 &
sleep 20s

# microservice-one: 2 instances
mintty --title=microservice-one/9011 java -Dserver.port=9011 -jar microservice-one/target/microservice-one-0.0.1-SNAPSHOT.jar &
sleep 20s
mintty --title=microservice-one/9012 java -Dserver.port=9012 -jar microservice-one/target/microservice-one-0.0.1-SNAPSHOT.jar &
sleep 20s

# microservice-two: 3 instances
mintty --title=microservice-two/9021 java -Dserver.port=9021 -jar microservice-two/target/microservice-two-0.0.1-SNAPSHOT.jar &
sleep 20s
mintty --title=microservice-two/9022 java -Dserver.port=9022 -jar microservice-two/target/microservice-two-0.0.1-SNAPSHOT.jar &
sleep 20s
mintty --title=microservice-two/9023 java -Dserver.port=9023 -jar microservice-two/target/microservice-two-0.0.1-SNAPSHOT.jar &
sleep 25s

# zuul server
mintty --title=zuul/8080 java -jar netflix-zuul-server/target/netflix-zuul-server-0.0.1-SNAPSHOT.jar &
sleep 30s

# Turbine service (still limited functionality with consul)
#mintty --title=turbine/9200 java -jar netflix-hystrix-turbine/target/netflix-hystrix-turbine-0.0.1-SNAPSHOT.jar &
#sleep 30s

# Hystrix Dashboard service
#mintty --title=Hystrix-Dashboard/9100 java -jar netflix-hystrix-dashboard/target/netflix-hystrix-dashboard-0.0.1-SNAPSHOT.jar &
#sleep 30s

cygstart http://localhost:8500

