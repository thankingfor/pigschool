package xyz.pigschool.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class XyzManagerTotal implements Serializable{
    private String recorddateid;

    private Integer userLogin;

    private Integer userRegister;

    private Integer userVisit;

    private Integer managerPushContent;

    private Date created;

    public String getRecorddateid() {
        return recorddateid;
    }

    public void setRecorddateid(String recorddateid) {
        this.recorddateid = recorddateid == null ? null : recorddateid.trim();
    }

    public Integer getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(Integer userLogin) {
        this.userLogin = userLogin;
    }

    public Integer getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(Integer userRegister) {
        this.userRegister = userRegister;
    }

    public Integer getUserVisit() {
        return userVisit;
    }

    public void setUserVisit(Integer userVisit) {
        this.userVisit = userVisit;
    }

    public Integer getManagerPushContent() {
        return managerPushContent;
    }

    public void setManagerPushContent(Integer managerPushContent) {
        this.managerPushContent = managerPushContent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}