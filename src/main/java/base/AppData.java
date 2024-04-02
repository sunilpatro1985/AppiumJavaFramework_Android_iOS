package base;

public class AppData {
    public static String platform = System.getProperty("platform", "android");
    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "false");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "false");
    public static String isCloud = System.getProperty("isCloud", "true");


}

//mvn clean test -Dplatform=android312412