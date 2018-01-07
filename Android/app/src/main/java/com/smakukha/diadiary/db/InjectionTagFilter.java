package com.smakukha.diadiary.db;

/**
 * Created by mac on 05.08.2017.
 */

public class InjectionTagFilter {

    private Integer startTagId;
    private Integer endTagId;
    private Integer startInjectionId;
    private Integer endInjectionId;

    public InjectionTagFilter (Integer startTagId, Integer endTagId, Integer startInjectionId,
                               Integer endInjectionId) {
        super();
        this.startTagId = startTagId;
        this.endTagId = endTagId;
        this.startInjectionId = startInjectionId;
        this.endInjectionId = endInjectionId;
    }

    public Integer getStartTagId() {
        return startTagId;
    }

    public Integer getEndTagId() {
        return endTagId;
    }

    public Integer getStartInjectionId() {
        return startInjectionId;
    }

    public Integer getEndInjectionId() {
        return endInjectionId;
    }

    public String getWhereClause () {
        StringBuilder clause = new StringBuilder();
        if (startTagId != null && endTagId != null) {
            clause.append(" tag_id BETWEEN " + startTagId.toString() + " AND "
                    + endTagId.toString());
        }
        if (startInjectionId != null && endInjectionId != null) {
            clause.append(" injection_id BETWEEN " + startInjectionId.toString() + " AND "
                    + endInjectionId.toString());
        }
        if (clause.length() > 0)
            return "WHERE" + clause.toString();
        else
            return "";
    }

}
