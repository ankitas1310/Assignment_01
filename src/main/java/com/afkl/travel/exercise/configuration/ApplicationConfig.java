package com.afkl.travel.exercise.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "travel.security")
public class ApplicationConfig {

    private String appUserName;
    private String appUserPasswords;
    private String appUserRole;
    private String appUserEndPoint;

    private String adminUserName;
    private String adminPasswords;
    private String adminRole;
    private String adminEndPoint;

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getAppUserPasswords() {
        return appUserPasswords;
    }

    public void setAppUserPasswords(String appUserPasswords) {
        this.appUserPasswords = appUserPasswords;
    }

    public String getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(String appUserRole) {
        this.appUserRole = appUserRole;
    }

    public String getAppUserEndPoint() {
        return appUserEndPoint;
    }

    public void setAppUserEndPoint(String appUserEndPoint) {
        this.appUserEndPoint = appUserEndPoint;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPasswords() {
        return adminPasswords;
    }

    public void setAdminPasswords(String adminPasswords) {
        this.adminPasswords = adminPasswords;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public String getAdminEndPoint() {
        return adminEndPoint;
    }

    public void setAdminEndPoint(String adminEndPoint) {
        this.adminEndPoint = adminEndPoint;
    }
}
