package webServer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Tatek Ahmed on 2/15/2022
 **/

public class App {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        initConfiguration();
        MyHttpServer myHttpServer = new MyHttpServer();
        myHttpServer.startServer();
    }

    public static void initConfiguration() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<ServerConfigration> constructor =
                ServerConfigration.class.getDeclaredConstructor(int.class,String.class);
        constructor.setAccessible(true);
        constructor.newInstance(8080,"<h1>Hi, Tatek! </h1>");
    }
}
