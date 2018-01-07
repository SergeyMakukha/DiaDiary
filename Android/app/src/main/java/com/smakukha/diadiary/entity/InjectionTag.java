package com.smakukha.diadiary.entity;

import java.util.Date;

/**
 * Created by mac on 04.08.2017.
 */

public class InjectionTag {

    private Integer injectionTagId;
    private Integer tagId;
    private Integer injectionId;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverInjectionTagId;

    public InjectionTag (Integer injectionTagId, Integer tagId, Integer injectionId,
                         String comment, Date created, Date changed,
                         Integer serverInjectionTagId) {
        super();
        this.injectionTagId = injectionTagId;
        this.tagId = tagId;
        this.injectionId = injectionId;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverInjectionTagId = serverInjectionTagId;
    }

    public Integer getInjectionTagId() {
        return injectionTagId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public Integer getInjectionId() {
        return injectionId;
    }

    public String getComment() {
        return comment;
    }

    public Date getCreated() {
        return created;
    }

    public Date getChanged() {
        return changed;
    }

    public Integer getServerInjectionTagId() {
        return serverInjectionTagId;
    }
}
