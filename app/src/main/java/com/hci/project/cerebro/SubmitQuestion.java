package com.hci.project.cerebro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Malavika Ramprasad on 11/29/2017.
 */

public class SubmitQuestion {
    @SerializedName("tag_id")
    @Expose
    int tag_id;
    @SerializedName("learner_id")
    @Expose
    int learner_id;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("id")
    @Expose
    int id;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getLearner_id() {
        return learner_id;
    }

    public void setLearner_id(int learner_id) {
        this.learner_id = learner_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestion_id() { return id; }

    public void setQuestion_id(int id) { this.id = id; }

    public SubmitQuestion(int tag_id, String description, int learner_id, int id) {
        this.learner_id = learner_id;
        this.tag_id = tag_id;
        this.description = description;
        this.id = id;
    }
}
