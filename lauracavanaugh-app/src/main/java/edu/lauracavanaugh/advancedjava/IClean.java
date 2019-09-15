package edu.lauracavanaugh.advancedjava;

/*
    The "service" that the WashingMachine uses, to clean clothes
 */
public interface IClean {

    String getCycle();
    void setCycle(String cycle);

    String getTemp();
    void setTemp(String temp);
}
