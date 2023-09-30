package base;

public class AppData {
    public static String platform = System.getProperty("platform", "ios");
    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "true");


}

//mvn clean test -Dplatform=android312412