package com.smakukha.diadiary.db;

import java.util.Date;

/**
 * Created by mac on 29.07.2017.
 */

public class MeasureFilter {

    private Integer startMeasureId;
    private Integer endMeasureId;
    private Date startMeasureTime;
    private Date endMeasureTime;
    private Double startAmount;
    private Double endAmount;

    public MeasureFilter (Integer startMeasureId, Integer endMeasureId, Date startMeasureTime,
                          Date endMeasureTime, Double startAmount, Double endAmount) {
        super();
        this.startMeasureId = startMeasureId;
        this.endMeasureId = endMeasureId;
        this.startMeasureTime = startMeasureTime;
        this.endMeasureTime = endMeasureTime;
        this.startAmount = startAmount;
        this.endAmount = endAmount;
    }

    public Integer getStartMeasureId() {
        return startMeasureId;
    }

    public Integer getEndMeasureId() {
        return endMeasureId;
    }

    public Date getStartMeasureTime() {
        return startMeasureTime;
    }

    public Date getEndMeasureTime() {
        return endMeasureTime;
    }

    public Double getStartAmount() {
        return startAmount;
    }

    public Double getEndAmont() {
        return endAmount;
    }

    public String getWhereClause() {
        StringBuilder clause = new StringBuilder();
        if (startMeasureId != null && endMeasureId != null) {
            clause.append(" measure_id BETWEEN " + startMeasureId.toString() + " AND "
            + endMeasureId.toString());
        }
        if (startMeasureTime != null && endMeasureTime != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" measure_time BETWEEN " + startMeasureTime.getTime() + " AND "
            + endMeasureTime.getTime());
        }
        if (startAmount != null && endAmount != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" measure_amount BETWEEN " + startAmount.toString() + " AND "
                    + endAmount.toString());
        }
        if (clause.length() > 0)
            return "WHERE" + clause.toString();
        else
            return "";
    }

    @Override
    public String toString() {
        return "MeasureFilter{" +
                "startMeasureId=" + startMeasureId == null ? "null" : startMeasureId.toString() +
                ", endMeasureId=" + endMeasureId == null ? "null" : endMeasureId.toString()+
                ", startMeasureTime=" + startMeasureTime == null ? "null" : startMeasureTime.toString() +
                ", endMeasureTime=" + endMeasureTime == null ? "null" : endMeasureTime.toString() +
                ", startAmount=" + startAmount == null ? "null" : startAmount.toString() +
                ", endAmount=" + endAmount == null ? "null" : endAmount.toString() +
                '}';
    }
}
