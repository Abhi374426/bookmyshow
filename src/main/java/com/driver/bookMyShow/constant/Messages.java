package com.driver.bookMyShow.constant;

public class Messages {
    public static String SUCCESS = "success";
    public static String IS = "is";
    public static String FAILED = "failed";
    public static String NOT_FOUND = "not found";
    public static String ALREADY_PRESENT = "already present";
    public static String FETECH = "fetech";
    public static String THEATER = "Theater";
    public static String ONE_TAB = " ";
    public static String DOT = ".";
    public static String Not_Active="not active";
    public static String SCREEN="screen";
    public static String Not_Valid="type not valid";
    public static String INVALID = "invalid";
    public static String TYPE = "type";
    public static String SEAT="seat";
    public static String SEAT_ARRANGEMENT="seatArrangement";
    public static String SHOW="show";
    public static String FACILITY="facility";
    public static String UPDATE="update";
    public static String WITH="with";
    public static String AND="and";
    public static String MATCHS="matchs";
    public static String COMPLETED = "completed";
    public static String RUNNING = "running";
    public static String INITIATED = "initiated";

    public static String getMessageWithDesc(String component, String msg) {
        return component + ONE_TAB + IS + ONE_TAB + msg + DOT;
    }
}
