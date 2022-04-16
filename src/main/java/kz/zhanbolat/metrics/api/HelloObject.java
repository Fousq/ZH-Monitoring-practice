package kz.zhanbolat.metrics.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloObject {

    @JsonProperty("hello-message")
    private String helloMessage;

    public HelloObject(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }
}
