package webServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Tatek Ahmed on 2/15/2022
 **/

public class MyHttpServer {
    public void startServer() throws IOException{

        HttpServer httpServer = HttpServer.create(ServerConfigration.getInstance().getServerAddress(),0);

        httpServer.createContext("/greeting").setHandler(exchange -> {
            String responseMessage = ServerConfigration.getInstance().getGreetingMessage();
            exchange.sendResponseHeaders(200, responseMessage.length());
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });

        System.out.println(String.format("Starting server on port %s: %d",
                ServerConfigration.getInstance().getServerAddress().getHostName(),
                ServerConfigration.getInstance().getServerAddress().getPort()));

        httpServer.start();

    }
}
