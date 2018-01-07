package com.smakukha.diadiary.entity;

import java.util.Date;

/**
 * Created by mac on 04.08.2017.
 */

public class MeasureInjectionLink {

    private Integer measureInjectionLinkId;
    private Integer measureId;
    private Integer injectionId;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverMeasureInjectionLinkId;

    public MeasureInjectionLink (Integer measureInjectionLinkId, Integer measureId, Integer injectioId,
                                 String comment, Date created, Date changed,
                                 Integer serverMeasureInjectionLinkId) {
        super();
        this.measureInjectionLinkId = measureInjectionLinkId;
        this.measureId = measureId;
        this.injectionId = injectionId;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverMeasureInjectionLinkId = serverMeasureInjectionLinkId;
    }

    public Integer getMeasureInjectionLinkId() {
        return measureInjectionLinkId;
    }

    public Integer getMeasureId() {
        return measureId;
    }

    public Integer getInjectionId() {
        return injectionId;
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

    public Integer getServerMeasureInjectionLinkId() {
        return serverMeasureInjectionLinkId;
    }
}
