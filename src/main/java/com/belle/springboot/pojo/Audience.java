package com.belle.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="audience")
@Component
public class Audience {
    private String clientId;
    private String base64Secret;
    private String name;
    private Integer expiresSecond;

    @Override
    public String toString() {
        return "Audience{" +
                "clientId='" + clientId + '\'' +
                ", base64Secret='" + base64Secret + '\'' +
                ", name='" + name + '\'' +
                ", expiresSecond=" + expiresSecond +
                '}';
    }

    public String getClientId() {
        return clientId;
    }

    public Audience setClientId(String clientId) {
        this.clientId=clientId;
        return this;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public Audience setBase64Secret(String base64Secret) {
        this.base64Secret=base64Secret;
        return this;
    }

    public String getName() {
        return name;
    }

    public Audience setName(String name) {
        this.name=name;
        return this;
    }

    public Integer getExpiresSecond() {
        return expiresSecond;
    }

    public Audience setExpiresSecond(Integer expiresSecond) {
        this.expiresSecond=expiresSecond;
        return this;
    }
}
