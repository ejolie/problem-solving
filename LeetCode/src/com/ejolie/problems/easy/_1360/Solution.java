package com.ejolie.problems.easy._1360;

/*
 * 1360. Number of Days Between Two Dates
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        String date1 = "2020-01-15", date2 = "2019-12-31";
        System.out.println(daysBetweenDates(date1, date2));
    }
    public static int daysBetweenDates(String date1, String date2) {
        DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null, d2 = null;
        int dayMs = 24 * 60 * 60 * 1000;
        long diffDay = 0;
        try {
            d1 = sourceFormat.parse(date1);
            d2 = sourceFormat.parse(date2);
            diffDay = Math.abs((d1.getTime() - d2.getTime()) / dayMs);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) diffDay;
    }
}
