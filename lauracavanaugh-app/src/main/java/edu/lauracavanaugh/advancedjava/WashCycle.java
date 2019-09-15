package edu.lauracavanaugh.advancedjava;

/**
 * Wash Cycle determines the agitator and spin speed, as well as the water temp
 */
public class WashCycle implements IClean {
    private String cycle;
    private String temp;

    public WashCycle(String cycle, String temp) {
        this.cycle = cycle;
        this.temp = temp;
    }
    public String getCycle() {
        return this.cycle;
    }
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
    public String getTemp() {
        return this.temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
}
