package com.example.myapplication;

public class Timeclock {
    private long thoigian;
    private boolean toggle;
    private String tencongviec;

    public String getTencongviec() {
        return tencongviec;
    }

    public void setTencongviec(String tencongviec) {
        this.tencongviec = tencongviec;
    }

    public Timeclock(long thoigian, boolean toggle, String tencongviec) {
        this.thoigian = thoigian;
        this.toggle = toggle;
        this.tencongviec = tencongviec;
    }

    public long getThoigian() {
        return thoigian;
    }

    public void setThoigian(long thoigian) {
        this.thoigian = thoigian;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
}
