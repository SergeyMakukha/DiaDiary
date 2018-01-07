package com.smakukha.diadiary.db;

/**
 * Created by mac on 01.08.2017.
 */

public class InsulinTypeFilter {

    private Integer startInsulinTypeId;
    private Integer endInsulinTypeId;
    private String name;

    public InsulinTypeFilter (Integer startInsulinTypeId, Integer endInsulinTypeId, String name) {
        super();
        this.startInsulinTypeId = startInsulinTypeId;
        this.endInsulinTypeId = endInsulinTypeId;
        this.name = name;
    }

    public Integer getStartInsulinTypeId() {
        return startInsulinTypeId;
    }

    public Integer getEndInsulinTypeId() {
        return endInsulinTypeId;
    }

    public String getName() {
        return name;
    }

    public String getWhereClause () {
        StringBuilder clause = new StringBuilder();
        if (startInsulinTypeId != null && endInsulinTypeId != null) {
            clause.append(" insulin_type_id BETWEEN " + startInsulinTypeId.toString() + " AND "
                    + endInsulinTypeId.toString());
        }
        if (name != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" name LIKE '" + name + "'");
        }
        if (clause.length() > 0)
            return "WHERE" + clause.toString();
        else
            return "";
    }
}
