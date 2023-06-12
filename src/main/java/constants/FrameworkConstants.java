package constants;

import lombok.experimental.UtilityClass;

import java.nio.file.Paths;

@UtilityClass
public class FrameworkConstants {
    public static final String EVIDENCE_STORAGE = Paths.get("evidence", "screenshots").toString();

}
