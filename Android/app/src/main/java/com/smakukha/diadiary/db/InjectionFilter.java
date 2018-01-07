package com.smakukha.diadiary.db;

import java.util.Date;

/**
 * Created by mac on 02.08.2017.
 */

public class InjectionFilter {

    private Integer startInjectionId;
    private Integer endInjectionId;
    private Date startInjectionTime;
    private Date endInjectionTime;
    private Double startInjectionAmount;
    private Double endInjectionAmount;
    private Integer insulinTypeId;
    private Integer insulinId;

    public InjectionFilter (Integer startInjectionId, Integer endInjectionId, Date startInjectionTime,
                            Date endInjectionTime, Double startInjectionAmount, Double endInjectionAmount,
                            Integer insulinTypeId, Integer insulinId) {
        super();
        this.startInjectionId = startInjectionId;
        this.endInjectionId = endInjectionId;
        this.startInjectionTime = startInjectionTime;
        this.endInjectionTime = endInjectionTime;
        this.startInjectionAmount = startInjectionAmount;
        this.endInjectionAmount = endInjectionAmount;
        this.insulinTypeId = insulinTypeId;
        this.insulinId = insulinId;
    }

    public Integer getStartInjectionId() {
        return startInjectionId;
    }

    public Integer getEndInjectionId() {
        return endInjectionId;
    }

    public Date getStartInjectionTime() {
        return startInjectionTime;
    }

    public Date getEndInjectionTime() {
        return endInjectionTime;
    }

    public Double getStartInjectionAmount() {
        return startInjectionAmount;
    }

    public Double getEndInjectionAmount() {
        return endInjectionAmount;
    }

    public Integer getInsulinTypeId() {
        return insulinTypeId;
    }

    public Integer getInsulinId() {
        return insulinId;
    }

    public String getWhereClause() {
        StringBuilder clause = new StringBuilder();
        if (startInjectionId != null && endInjectionId != null) {
            clause.append(" injection_id BETWEEN " + startInjectionId.toString() + " AND "
                    + endInjectionId.toString());
        }
        if (startInjectionTime != null && endInjectionTime != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" injection_time BETWEEN " + startInjectionTime.getTime() + " AND "
                    + endInjectionTime.getTime());
        }
        if (startInjectionAmount != null && endInjectionAmount != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" injection_amount BETWEEN " + startInjectionAmount.toString() + " AND "
                    + endInjectionAmount.toString());
        }
        if (insulinTypeId != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" insulin_type_id = " + insulinTypeId.toString());
        }
        if (insulinId != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" insulin_id = " + insulinId.toString());
        }
        if (clause.length() > 0)
            return "WHERE" + clause.toString();
        else
            return "";
    }

}
