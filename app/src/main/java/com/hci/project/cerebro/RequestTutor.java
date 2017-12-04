package com.hci.project.cerebro;

import java.sql.Time;

/**
 * Created by Malavika Ramprasad on 12/4/2017.
 */

public class RequestTutor {
    int tutor_id;
    Time start_time;
    Time end_time;

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Time getStart_time() {
        return start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public int setTutor_id(int tutor_id) {
        return this.tutor_id = tutor_id;
    }

    public RequestTutor(int tutor_id, Time start_time, Time end_time){
        this.end_time = end_time;
        this.tutor_id = tutor_id;
        this.start_time = start_time;
    }

}
