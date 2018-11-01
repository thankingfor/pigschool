package xyz.pigschool.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class XyzManagerTag implements Serializable{
    private Integer id;

    private String content;

    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}