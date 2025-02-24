package design_patterns.singletony;

public class Config {

    private String server;
    private int port;

    private static Config INSTANCE;

    private Config() {

    }

    // Lazy ve Eager
    public static Config getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Config();
        }
        return INSTANCE;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
