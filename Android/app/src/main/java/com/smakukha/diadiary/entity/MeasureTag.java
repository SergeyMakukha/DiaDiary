package com.smakukha.diadiary.entity;

import java.util.Date;

/**
 * Created by mac on 28.07.2017.
 */

public class MeasureTag {

    private Integer measureTagId;
    private Integer tagId;
    private Integer measureId;
    private String comment;
    private Date created;
    private Date changed;
    private Integer serverMeasureTagId;

    public MeasureTag (Integer measureTag, Integer tagId, Integer MeasureId,
                       String comment, Date created, Date changed,
                       Integer serverMeasureTagId) {
        super();
        this.measureTagId = measureTagId;
        this.tagId = tagId;
        this.measureId = measureId;
        this.comment = comment;
        this.created = created;
        this.changed = changed;
        this.serverMeasureTagId = serverMeasureTagId;
    }


    public Integer getMeasureTagId() {
        return measureTagId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public Integer getMeasureId() {
        return measureId;
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

    public Integer getServerMeasureTagId() {
        return serverMeasureTagId;
    }
}
