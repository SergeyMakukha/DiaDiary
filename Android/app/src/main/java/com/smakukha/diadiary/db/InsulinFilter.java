package com.smakukha.diadiary.db;

/**
 * Created by mac on 01.08.2017.
 */

public class InsulinFilter {

    private Integer startInsulinId;
    private Integer endInsulinId;
    private Integer insulinTypeId;
    private String insulinName;
    private Integer startDateFlag; // 0 - startDate IS NULL, other - startDate IS NT NULL
    private Integer endDateFlag; // 0 - endDate IS NULL, other - endDate IS NT NULL

    public InsulinFilter (Integer startInsulinId, Integer endInsulinId, Integer insulinTypeId,
                          String insulinName, Integer startDateFlag, Integer endDateFlag) {
        super();
        this.startInsulinId = startInsulinId;
        this.endInsulinId = endInsulinId;
        this.insulinTypeId = insulinTypeId;
        this.insulinName = insulinName;
        this.startDateFlag = startDateFlag;
        this.endDateFlag = endDateFlag;
    }

    public Integer getStartInsulinId() {
        return startInsulinId;
    }

    public Integer getEndInsulinId() {
        return endInsulinId;
    }

    public Integer getInsulinTypeId() {
        return insulinTypeId;
    }

    public String getInsulinName() {
        return insulinName;
    }

    public Integer getStartDateFlag() {
        return startDateFlag;
    }

    public Integer getEndDateFlag() {
        return endDateFlag;
    }

    public String getWhereClause () {
        StringBuilder clause = new StringBuilder();
        if (startInsulinId != null && endInsulinId != null) {
            clause.append(" insulin_id BETWEEN " + startInsulinId.toString() + " AND "
                    + endInsulinId.toString());
        }
        if (insulinTypeId != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" insulin_type_id = " + insulinTypeId);
        }
        if (insulinName != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" insulin_name LIKE '" + insulinName + "'");
        }
        if (startDateFlag != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            if (startDateFlag == 0)
                clause.append(" start_date IS NULL");
            else
                clause.append(" start_date IS NOT NULL");
        }
        if (endDateFlag != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            if (startDateFlag == 0)
                clause.append(" end_date IS NULL");
            else
                clause.append(" end_date IS NOT NULL");
        }
        if (clause.length() > 0)
            return "WHERE" + clause.toString();
        else
            return "";
    }
}
