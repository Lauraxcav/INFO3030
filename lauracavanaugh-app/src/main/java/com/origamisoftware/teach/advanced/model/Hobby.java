package com.origamisoftware.teach.advanced.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Models the Hobby table
 */
@Entity
public class Hobby {

    private int id;
    private String name;
    private String description;
    private int minimumAge;

    /**
     * Primary Key - Unique ID for a particular row in the hobby table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the hobby table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name column as a String
     */
    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getName() {
        return name;
    }

    /**
     * Specify the person's name
     *
     * @param name a String value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the value of the description column as a String
     */
    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 2056)
    public String getDescription() {
        return description;
    }

    /**
     * Specify the Hobby's description
     *
     * @param description a String value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The recommended age for the hobby, an int value
     * @return the value of the minimum_age column as an int value
     */
    @Basic
    @Column(name = "minimum_age", nullable = false, insertable = true, updatable = true)
    public int getMinimumAge() {
        return minimumAge;
    }

    /**
     * Specify the recommended age for the hobby
     * @param minimumAge  an int value
     */
    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobby hobby = (Hobby) o;

        if (id != hobby.id) return false;
        if (minimumAge != hobby.minimumAge) return false;
        if (description != null ? !description.equals(hobby.description) : hobby.description != null)
            return false;
        if (name != null ? !name.equals(hobby.name) : hobby.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + minimumAge;
        return result;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minimumAge=" + minimumAge +
                '}';
    }
}
