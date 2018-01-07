package com.smakukha.diadiary.entity;

/**
 * Created by mac on 28.07.2017.
 */

import java.util.Date;

public class Tag {

    private Integer tagId;
    private String tagType;
    private String tagName;
    private String description;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverTagId;

    public Tag (Integer tagId, String tagType, String tagName,
                String description, String comment, Date created,
                Date changed, Integer serverTagId) {
        super();
        this.tagId = tagId;
        this.tagType = tagType;
        this.tagName = tagName;
        this.description = description;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverTagId = serverTagId;
    }

    public Integer getTagId() {
        return this.tagId;
    }

    public String getTagType() {
        return this.tagType;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getComment() {
        return this.comment;
    }

    public Date getCreated() {
        return this.created;
    }

    public Date getChanged() {
        return this.changed;
    }

    public Integer getServerTagId() {
        return serverTagId;
    }
}
