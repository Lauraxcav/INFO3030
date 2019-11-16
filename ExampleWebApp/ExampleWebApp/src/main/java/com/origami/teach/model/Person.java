package com.origami.teach.model;

/**
 * This class used for processing form data.
 *
 */
public class Person {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void processData() {
        System.out.println("going to process data");
    }

    public boolean validateData() {

        if ((this.firstName == null) || (this.lastName == null))
            return false;

        return true;

    }
}