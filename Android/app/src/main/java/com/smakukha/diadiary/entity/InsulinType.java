package com.smakukha.diadiary.entity;

/**
 * Created by mac on 01.08.2017.
 */

import java.util.Date;

public class InsulinType {

    private Integer insulinTypeId;
    private String name;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverInsulinTypeId;

    public InsulinType (Integer insulinTypeId, String name, String comment,
                        Date created, Date changed, Integer serverInsulinTypeId) {
        super();
        this.insulinTypeId = insulinTypeId;
        this.name = name;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverInsulinTypeId = serverInsulinTypeId;
    }

    public Integer getInsulinTypeId() {
        return insulinTypeId;
    }

    public String getName() {
        return name;
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

    public Integer getServerInsulinTypeId() {
        return serverInsulinTypeId;
    }
}
