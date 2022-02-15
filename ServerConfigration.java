package webServer;

import java.net.InetSocketAddress;

/**
 * @author Tatek Ahmed on 2/15/2022
 **/

public class ServerConfigration {

    private static ServerConfigration serverConfigurationInstance;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfigration(int port, String greetingMessage) {
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost",port);

        if (serverConfigurationInstance == null){
            serverConfigurationInstance = this;
        }
    }

    public static ServerConfigration getInstance(){
        return serverConfigurationInstance;
    }

    public InetSocketAddress getServerAddress() {
        return this.serverAddress;
    }
    public String getGreetingMessage(){
        return this.greetingMessage;
    }
}
