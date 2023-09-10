package exercises;

import web.WebServer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CallingPrivateConstructor {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException {
        initConfiguration();
        WebServer webServer = new WebServer();
        webServer.startServer();//RUN - http://localhost:8080/greeting in brower after starting application
    }

    public static void initConfiguration() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<ServerConfiguration> constructor= ServerConfiguration.class.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        constructor.newInstance(8080,"Good Day!");
    }
}
