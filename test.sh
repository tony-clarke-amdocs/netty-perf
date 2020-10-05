#!/bin/bash
mvn clean package

java -jar gateway/target/gateway-0.0.1-SNAPSHOT.jar &
java -jar restapp/target/restapp-current-SNAPSHOT.jar &
sleep 20
(
  cd gatling-test
  mvn clean package
  GATLING_CMD="mvn gatling:test -Dnusers=100 -Dgatling.http.ahc.requestTimeout=2200 -Dgatling.http.ssl.trustStore.password=changeit -Dgatling.http.ssl.trustStore.file=truststore.jks -Dgatling.http.ssl.trustStore.type=JKS"
  ${GATLING_CMD} -Dgatling.simulationClass=gateway.GatewaySimulation || true
)
curl -k -X POST https://localhost:7443/actuator/shutdown
curl -k -X POST https://localhost:9443/actuator/shutdown
