package com.miniProject;

public class RecordRoute {
    String from;
    String to;
    int distance;
    String time;
    String fare;

    public RecordRoute(String from, String to, int distance, String time, String fare) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.time = time;
        this.fare = fare;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }



}
