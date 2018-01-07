package com.smakukha.diadiary.db;

/**
 * Created by mac on 29.07.2017.
 */

public class TagFilter {

    private Integer startTagId;
    private Integer endTagId;
    private String tagType;
    private String tagName;

    public TagFilter (Integer startTagId, Integer endTagId, String tagType, String tagName) {
        super();
        this.startTagId = startTagId;
        this.endTagId = endTagId;
        this.tagType = tagType;
        this.tagName = tagName;
    }

    public Integer getStartTagId() {
        return startTagId;
    }

    public Integer getEndTagId() {
        return endTagId;
    }

    public String getTagType() {
        return tagType;
    }

    public String getTagName() {
        return tagName;
    }

    public String getWhereClause() {
        StringBuilder clause = new StringBuilder();
        if (startTagId != null && endTagId != null) {
            clause.append(" tag_id BETWEEN " + startTagId.toString() + " AND "
                    + endTagId.toString());
        }
        if (tagType != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" tag_type = '" + tagType + "'");
        }
        if (tagName != null) {
            if (clause.length() > 0) {
                clause.append(" AND");
            }
            clause.append(" tag_name LIKE '" + tagName + "'");
        }
        if (clause.length() > 0)
            return "WHERE" + clause.toString();
        else
            return "";
    }
}
