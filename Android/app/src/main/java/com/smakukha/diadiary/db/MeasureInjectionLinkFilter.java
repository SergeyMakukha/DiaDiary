package com.smakukha.diadiary.db;

/**
 * Created by mac on 05.08.2017.
 */

public class MeasureInjectionLinkFilter {

    private Integer startMeasureId;
    private Integer endMeasureId;
    private Integer startInjectionId;
    private Integer endInjectionId;

    public MeasureInjectionLinkFilter (Integer startMeasureId, Integer endMeasureId, Integer startInjectionId,
                               Integer endInjectionId) {
        super();
        this.startMeasureId = startMeasureId;
        this.endMeasureId = endMeasureId;
        this.startInjectionId = startInjectionId;
        this.endInjectionId = endInjectionId;
    }

    public Integer getStartMeasureId() {
        return startMeasureId;
    }

    public Integer getEndMeasureId() {
        return endMeasureId;
    }

    public Integer getStartInjectionId() {
        return startInjectionId;
    }

    public Integer getEndInjectionId() {
        return endInjectionId;
    }

    public String getWhereClause () {
        StringBuilder clause = new StringBuilder();
        if (startMeasureId != null && endMeasureId != null) {
            clause.append(" measure_id BETWEEN " + startMeasureId.toString() + " AND "
                    + endMeasureId.toString());
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
