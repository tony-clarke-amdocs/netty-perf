import io.gatling.recorder.GatlingRecorder
import io.gatling.recorder.config.RecorderPropertiesBuilder

object Recorder extends App {

	val props = new RecorderPropertiesBuilder
	props.simulationsFolder(IDEPathHelper.recorderOutputDirectory.toString)
	props.simulationPackage("computerdatabase")

	GatlingRecorder.fromMap(props.build, Some(IDEPathHelper.recorderConfigFile))
}
