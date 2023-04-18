package com.slocupdation.sloc_updation.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("deviceid")
    @Expose
    private String deviceid;
    @SerializedName("sessionid")
    @Expose
    private String sessionid;
    @SerializedName("rolesh")
    @Expose
    private String rolesh;
    @SerializedName("scode")
    @Expose
    private String scode;
    @SerializedName("pcode")
    @Expose
    private String pcode;
    @SerializedName("name")
    @Expose
    private String name;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getRolesh() {
        return rolesh;
    }

    public void setRolesh(String rolesh) {
        this.rolesh = rolesh;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
