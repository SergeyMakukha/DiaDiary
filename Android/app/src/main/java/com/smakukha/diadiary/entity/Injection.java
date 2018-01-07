package com.smakukha.diadiary.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 02.08.2017.
 */

public class Injection {

    private Integer injectionId;
    private Date injectionTime;
    private Double amount;
    private Integer insulinTypeId;
    private Integer insulinId;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverInjectionId;

    private ArrayList<Tag> injectionTag;
    private ArrayList<MeasureInjectionLink> measureInjectionLink;

    public Injection(Integer injectionId, Date injectionTime, Double amount,
                     Integer insulinTypeId, Integer insulinId, String comment,
                     Date created, Date changed, Integer serverInjectionTypeId,
                     List<Tag> injectionTag, List<MeasureInjectionLink> measureInjectionLink) {
        super();
        this.injectionId = injectionId;
        this.injectionTime = injectionTime;
        this.amount = amount;
        this.insulinTypeId = insulinTypeId;
        this.insulinId = insulinId;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverInjectionId = serverInjectionId;
        if (injectionTag != null)
            this.injectionTag = new ArrayList<Tag>(injectionTag);
        else
            this.injectionTag = new ArrayList<Tag>();
        if (measureInjectionLink != null)
            this.measureInjectionLink = new ArrayList<MeasureInjectionLink>(measureInjectionLink);
        else
            this.measureInjectionLink = new ArrayList<MeasureInjectionLink>();
    }

    public Integer getInjectionId() {
        return injectionId;
    }

    public Date getInjectionTime() {
        return injectionTime;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getInsulinTypeId() {
        return insulinTypeId;
    }

    public Integer getInsulinId() {
        return insulinId;
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

    public Integer getServerInjectionId() {
        return serverInjectionId;
    }

    public ArrayList<Tag> getInjectionTag() {
        return injectionTag;
    }

    public ArrayList<MeasureInjectionLink> getMeasureInjectionLink() {
        return measureInjectionLink;
    }
}
