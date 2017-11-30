package com.hci.project.cerebro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Malavika Ramprasad on 11/29/2017.
 */

public class SubmitQuestion {
    @SerializedName("tag_id")
    @Expose
    String tag_id;
    @SerializedName("learner_id")
    @Expose
    String learner_id;
    @SerializedName("description")
    @Expose
    String description;

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getLearner_id() {
        return learner_id;
    }

    public void setLearner_id(String learner_id) {
        this.learner_id = learner_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubmitQuestion(String tag_id, String description, String learner_id) {
        this.learner_id = learner_id;
        this.tag_id = tag_id;
        this.description = description;
    }
}
