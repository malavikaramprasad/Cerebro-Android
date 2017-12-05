package com.hci.project.cerebro;

import java.sql.Time;

/**
 * Created by Malavika Ramprasad on 12/3/2017.
 */

public class BookedSlot {

    //Time start_time;
    Time end_time;

//    public void setStart_time(Time start_time) {
//        this.start_time = start_time;
//    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

//    public Time getStart_time() {
//        return start_time;
//    }

    public Time getEnd_time() {
        return end_time;
    }
}
