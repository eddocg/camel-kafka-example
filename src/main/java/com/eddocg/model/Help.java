package com.eddocg.model;

import java.io.Serializable;

public class Help implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3760083727723291908L;

    private String sequence;

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

}
