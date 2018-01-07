package com.smakukha.diadiary.entity;

/**
 * Created by mac on 28.07.2017.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Measure {

    private Integer measureId;
    private Date measureTime;
    private Double amount;
    private String measureUnit;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverMeasureId;

    private ArrayList<Tag> tag;

    public Measure (Integer measureId, Date measureTime, Double amount,
                    String measureUnit, String comment, Date created,
                    Date changed, Integer serverMeasureId, List<Tag> tag) {
        super();
        this.measureId = measureId;
        this.measureTime = measureTime;
        this.amount = amount;
        this.measureUnit = measureUnit;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverMeasureId = serverMeasureId;
        if (tag != null)
            this.tag = new ArrayList<Tag>(tag);
        else
            this.tag = new ArrayList<Tag>();
    }

    public Integer getMeasureId() {
        return this.measureId;
    }

    public Date getMeasureTime() {
        return this.measureTime;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getMeasureUnit() {
        return this.measureUnit;
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

    public Integer getServerMeasureId() {
        return this.serverMeasureId;
    }

    public ArrayList<Tag> getTag() {
        return new ArrayList<Tag>(this.tag);
    }

    @Override
    public String toString() {
        return "Measure{" +
                "measureId=" + measureId +
                ", measureTime=" + measureTime +
                ", amount=" + amount +
                ", measureUnit='" + measureUnit + '\'' +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                ", changed=" + changed +
                ", serverMeasureId=" + serverMeasureId +
                ", tag=" + tag +
                '}';
    }
}
