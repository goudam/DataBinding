package com.example.databinding.model;

import android.database.Cursor;
import android.util.Log;


import java.io.Serializable;
import java.util.List;
import java.util.Set;


public class LoginResponseDto implements Serializable {

    boolean authenticationStatus;   // Status of Authentication - true - authenticated  , false - not authenticated

    String sessionid;    //Session id only if authentication is successful.
    String errorDescription;    //Session id only if authentication is successful.


    String key;

    long serverTime;

    String timezone;

    long loginDetailsId;

    List<GlobalConfigDto> globalConfigs;

    public boolean isAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(boolean authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getLoginDetailsId() {
        return loginDetailsId;
    }

    public void setLoginDetailsId(long loginDetailsId) {
        this.loginDetailsId = loginDetailsId;
    }

    public List<GlobalConfigDto> getGlobalConfigs() {
        return globalConfigs;
    }

    public void setGlobalConfigs(List<GlobalConfigDto> globalConfigs) {
        this.globalConfigs = globalConfigs;
    }
}
