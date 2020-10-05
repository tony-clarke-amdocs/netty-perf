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

### Results
The test calls a microservice via a gateway.

__Summary__

Upgrading from io.projectreactor.netty 0.9.7 to 0.9.10 results in timeouts during NFT tests.
The details of the test are as follows:

- 20 minute duration
- 100 users/clients
- Ramp 5 users/sec
- Pace is 300 ms
- Request timeout is 2200 ms

Running the test with io.projectreactor.netty 0.9.1 results in timeouts in 8 out of 
10 runs. Running the test with io.projectreactor.netty 0.9.7 results in no timeouts 
in 10 out of 10 runs.

### How To Run
To run with io.projectreactor.netty 0.9.10, from the root directory ./test.sh  

To run with io.projectreactor.netty 0.9.7, edit gateway/pom.xml and change the version of 
io.projectreactor.netty to 0.9.7, then from the root directory ./test.sh.

The results can be found in gatling-test/target/gatling/
