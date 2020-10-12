### Purpose
To demonstrate timeout occurrences when upgrading from io.projectreactor.netty 0.9.7 to 0.9.10.

### How
Deploy Spring Cloud Gateway that will route requests to a spring boot microservice.
Gatling will drive the load, measure the latency and plot the graphs.
All components are running on the same host.
- Spring Boot 2.3.0
- Spring Cloud (Hoxton.SR6)
- Netty 4.1.49
- Spring Cloud Gateway 2.2.3.

### Test Configuration
The test calls a microservice via a gateway.

__Summary__

In order to trigger the failure scenario the test may need to be adjusted for the hardware it runs on. The 
out of box configuration can trigger the failure on MacBook Pro 2.8 GHz i7. The test configuration options are:

- 20 minute duration
- 140 users/clients
- Ramp 5 users/sec
- Pace is 100 ms
- Request timeout is 1500 ms

Out of box the test runs with reactor netty 0.9.7 and the test is expected to pass.

### How To Run
To run with io.projectreactor.netty 0.9.7, from the root directory ./test.sh  

To run with io.projectreactor.netty 0.9.10, edit gateway/pom.xml and change the version of 
io.projectreactor.netty to 0.9.7, then from the root directory ./test.sh.

The results can be found in gatling-test/target/gatling/
