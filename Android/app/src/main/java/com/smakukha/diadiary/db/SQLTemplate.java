package com.smakukha.diadiary.db;

import java.util.Date;

/**
 * Created by mac on 28.07.2017.
 */

final class SQLTemplate {

    public static final String createTag = "CREATE TABLE tag"
            + "( tag_id INTEGER PRIMARY KEY"
            + ", tag_type TEXT"
            + ", tag_name TEXT"
            + ", description TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_tag_id TEXT"
            + "); ";

    public static final String createMeasure = "CREATE TABLE measure"
            + "( measure_id INTEGER PRIMARY KEY"
            + ", measure_time TEXT"
            + ", amount TEXT"
            + ", measure_unit TEXT"
            + ", description TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_measure_id TEXT"
            + "); ";

    public static final String createMeasureTag = "CREATE TABLE measure_tag"
            + "( measure_tag_id INTEGER PRIMARY KEY"
            + ", tag_id TEXT"
            + ", measure_id TEXT"
            + ", description TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_measure_tag_id TEXT"
            + "); ";

    public static final String createInsulinType = "CREATE TABLE insulin_type"
            + "( insulin_type_id INTEGER PRIMARY KEY"
            + ", name TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_insulin_type_id TEXT"
            + "); ";

    public static final String createInsulin = "CREATE TABLE insulin"
            + "( insulin_id INTEGER PRIMARY KEY"
            + ", insulin_type_id TEXT"
            + ", name TEXT"
            + ", buy_date TEXT"
            + ", start_date TEXT"
            + ", end_date TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_insulin_id TEXT"
            + "); ";

    public static final String createInjection = "CREATE TABLE injection"
            + "( injecton_id INTEGER PRIMARY KEY"
            + ", injection_time TEXT"
            + ", amount TEXT"
            + ", insulin_type_id TEXT"
            + ", insulin_id TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_injection_id TEXT"
            + "); ";

    public static final String createMeasureInjectionLink = "CREATE TABLE measure_injection_link"
            + "( measure_injecton_link_id INTEGER PRIMARY KEY"
            + ", measure_id TEXT"
            + ", injection_id TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_injection_id TEXT"
            + ", server_measure_injection_link_id TEXT"
            + "); ";

    public static final String createInjectionTag = "CREATE TABLE injection_tag"
            + "( injection_tag_id INTEGER PRIMARY KEY"
            + ", tag_id TEXT"
            + ", injection_id TEXT"
            + ", description TEXT"
            + ", comment TEXT"
            + ", created TEXT"
            + ", changed TEXT"
            + ", server_injection_tag_id TEXT"
            + "); ";
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String addTag = "INSERT INTO tag VALUES("
            + "1"
            + ", 'Measure'"
            + ", 'Перед едой'"
            + ", 'Descripion'"
            + ", 'Comment'"
            + ", " + new Date().getTime()
            + ", " + new Date().getTime()
            + ", NULL"
            + ");";
    public static final String addMeasure = "INSERT INTO measure VALUES("
            + "1"
            + ", " + new Date().getTime()
            + ", 133"
            + ", 'mg/dL'"
            + ", 'Descripion'"
            + ", 'Comment'"
            + ", " + new Date().getTime()
            + ", " + new Date().getTime()
            + ", NULL"
            + ");";
    public static final String addMeasureTag = "INSERT INTO measure_tag VALUES("
            + "1"
            + ", 1"
            + ", 1"
            + ", 'Descripion'"
            + ", 'Comment'"
            + ", " + new Date().getTime()
            + ", " + new Date().getTime()
            + ", NULL"
            + ");";
}
