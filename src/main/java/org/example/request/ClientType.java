package org.example.request;

public class ClientType {
    private String type;
    public static ClientType heavy = new ClientType("heavy");
    public static ClientType light = new ClientType("light");
    private ClientType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
