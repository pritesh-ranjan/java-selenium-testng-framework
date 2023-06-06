package utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "system:properties",
        "file:${user.dir}/src/main/resources/config.properties"
})
public interface FrameworkConfigurer extends Config {
    String browser();
    String environment();

    @Key("${environment}.url")
    String url();

    String host();

    String accountKey();

}
