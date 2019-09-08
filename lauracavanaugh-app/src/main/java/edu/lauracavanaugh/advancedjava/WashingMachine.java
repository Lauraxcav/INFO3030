package edu.lauracavanaugh.advancedjava;

public class WashingMachine implements IWashingMachine {

    private WashCycle cycle;

    public WashingMachine(WashCycle cycle) {
        this.cycle = cycle;
    }

    public String getWashCycle() { return this.cycle.getCycle(); }

    public boolean runWashCycle() {
        // add water at proper temp
        String waterTemp = cycle.getTemp();

        // add soap

        // agitate the tub at proper speed
        String agitateSpeed = cycle.getCycle();

        // rinse with water

        // drain
        return true;
     }

     public boolean spinTub() {
        // spin the tub at proper speed
        String spinSpeed = cycle.getCycle();

        // spin the tub, etc.
         return true;
     }


}
