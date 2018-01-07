package com.smakukha.diadiary.entity;

import java.util.Date;

/**
 * Created by mac on 01.08.2017.
 */

public class Insulin {

    private Integer insulinId;
    private Integer insulinTypeId;
    private String name;
    private Date buyDate;
    private Date startDate;
    private Date endDate;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverInsulinId;

    public Insulin (Integer insulinId, Integer insulinTypeId, String name,
                    Date buyDate, Date startDate, Date endDate,
                    String comment, Date created, Date changed,
                    Integer serverInsulinTypeId) {
        super();
        this.insulinId = insulinId;
        this.insulinTypeId = insulinTypeId;
        this.name = name;
        this.buyDate = buyDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverInsulinId = serverInsulinId;
    }

    public Integer getInsulinId() {
        return insulinId;
    }

    public Integer getInsulinTypeId() {
        return insulinTypeId;
    }

    public String getName() {
        return name;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
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

    public Integer getServerInsulinId() {
        return serverInsulinId;
    }
}
