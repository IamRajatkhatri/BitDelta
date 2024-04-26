package utils;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"system:properties",
	"system:env",
"file:${user.dir}/src/main/resources/config.properties"})
//@Config.Sources(value="file:${config.path}")
public interface FrameworkConfig extends Config {

	@DefaultValue("dev")
	String environment();

	@Key("${environment}.username")
	String username();

	//@DefaultValue("CHROME")
	//BrowserType browser();

	@DefaultValue("SECONDS")
	TimeUnit value();

	@DefaultValue("15")
	Long timeout();

	@Key("${environment}.url")
	String url();

}
