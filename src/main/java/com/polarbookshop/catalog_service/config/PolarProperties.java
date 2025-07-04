package com.polarbookshop.catalog_service.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar") // Marks the class as a source for configuration properties starting with the prefix "polar"
public class PolarProperties {

    /**
     * A message to welcome users.
     */
    private String greeting; // Field for custom polar.greeting (prefix + field name) property, parsed as String.

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
