package com.hci.project.cerebro;

import java.sql.Time;

/**
 * Created by Malavika Ramprasad on 12/2/2017.
 */

public class UserLocAndTime {
    public double x_coordinate;
    public double y_coordinate;
    Time start_time;
    Time end_time;

    public Time getEnd_time() {
        return end_time;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    public UserLocAndTime(double x_coordinate, double y_coordinate, Time start_time, Time end_time)
    {
        this.end_time = end_time;
        this.start_time = start_time;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }
}
