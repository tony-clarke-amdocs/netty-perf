package gateway

import scala.concurrent.duration._
import scala.io.Source
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GatewaySimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("https://localhost")
    .inferHtmlResources()
    .acceptHeader("application/json")
    .acceptEncodingHeader("gzip, deflate")
    .contentTypeHeader("application/json")
    .userAgentHeader("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")

  object TestGateway {
    val call = exec(http("gateway")
      .get("https://localhost:9443/greeting")
      .check(status.is(200)))
  }
  val TestGatewayScenario = scenario("gateway").forever(pace(300 milliseconds).exec(TestGateway.call))

  val nUsers = Integer.parseInt(System.getProperty("nusers"))
  val nRampUsersPerSecond = 5

  setUp(
    TestGatewayScenario.inject(rampUsers(nUsers) during (nUsers / nRampUsersPerSecond seconds)))
    .maxDuration(20 minutes).protocols(httpProtocol)
    .assertions(
      global.successfulRequests.percent.is(100)
    )
}
