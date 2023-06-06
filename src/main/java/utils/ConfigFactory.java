package utils;

import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigCache;

@UtilityClass
public class ConfigFactory {
    public static FrameworkConfigurer getConfig(){
        return ConfigCache.getOrCreate(FrameworkConfigurer.class);
    }
}
