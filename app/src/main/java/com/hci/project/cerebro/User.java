package com.hci.project.cerebro;

import java.sql.Time;

/**
 * Created by Malavika Ramprasad on 11/29/2017.
 */

public class User {
    int id;
    String first_name;
    String last_name;
    String email;
    float rating;
    float x_coordinate;
    float y_coordinate;
    Time start_time;
    Time end_time;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public float getRating() {
        return rating;
    }

    public float getX_coordinate() {
        return x_coordinate;
    }

    public float getY_coordinate() {
        return y_coordinate;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public void setX_coordinate(float x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(float y_coordinate) {
        this.y_coordinate = y_coordinate;
    }
}
