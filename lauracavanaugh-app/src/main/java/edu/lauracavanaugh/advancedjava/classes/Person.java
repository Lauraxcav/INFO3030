package edu.lauracavanaugh.advancedjava.classes;

import edu.lauracavanaugh.advancedjava.interfaces.IPerson;

/**
 *
 * @author laura
 */
public class Person implements IPerson {

    private String name;

    /**
     * I can't remember when this constructor is called...
     */
    public Person(String name) {
        this.name = name;
   }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
