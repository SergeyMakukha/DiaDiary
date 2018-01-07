package com.smakukha.diadiary.db;

import java.util.Date;

/**
 * Created by mac on 13.08.2017.
 */

final class SQLUtils {

    public static String getIntValue(Integer value) {
        if (value == null)
            return "NULL";
        else
            return value.toString();
    }

    public static String getStringValue(String value) {
        if (value == null)
            return "NULL";
        else
            return value;
    }

    public static String getDoubleValue(Double value) {
        if (value == null)
            return "NULL";
        else
            return "'" + value.toString() + "'";
    }

    public static String getDateValue(Date value) {
        if (value == null)
            return "NULL";
        else
            return ((Long)value.getTime()).toString();
    }
}
