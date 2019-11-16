package com.origami.teach.model;

/**
 *  A simple container class used to capture form data.
 */
public class Mood {
    
    private Boolean happy;
    private Boolean sad;

    /**
     * Java been pattern needs a default constructor
     */
    public Mood() {
    }

    public Mood(Boolean happy, Boolean sad) {
        this.happy = happy;
        this.sad = sad;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Boolean getSad() {
        return sad;
    }

    public void setSad(Boolean sad) {
        this.sad = sad;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "happy=" + happy +
                ", sad=" + sad +
                '}';
    }
}
