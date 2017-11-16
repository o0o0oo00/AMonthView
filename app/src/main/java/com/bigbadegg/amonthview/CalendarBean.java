package com.bigbadegg.amonthview;

import java.io.Serializable;

/**
 * Created by cy on 2017/11/16.
 */

public class CalendarBean implements Serializable {
    int day;
    String text;
    boolean select;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public CalendarBean(int day, String text) {
        this.day = day;
        this.text = text;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
