package edu.lauracavanaugh.advancedjava;

import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 * Use this class to create a Washing Machine.
 * Each washing machine should use a wash cycle.
 *
 *
 */
public class WashingMachine implements IWashingMachine {

    private WashCycle cycle;

    /**
     * Constructor
     * @param cycle - the wash cycle selected for this machine
     */
    public WashingMachine(WashCycle cycle) {
        this.cycle = cycle;
    }

    public String getWashCycle() {
        return this.cycle.getCycle();
    }

    /**
     * run a wash cycle
     * @throws WashException if the water is too hot, etc.
     */
    public boolean runWashCycle() throws WashException {

         // add water at proper temp
        String waterTemp = cycle.getTemp();
        if (!waterTemp.equals("cold")&(!waterTemp.equals("warm"))) {
            throw new WashException("water temp is too hot");
        }

        // add soap

        // agitate the tub at proper speed
        String agitateSpeed = cycle.getCycle();
        if (!agitateSpeed.equals("delicate")&(!agitateSpeed.equals("normal"))) {
            throw new WashException("agitate cycle is too fast for this old tub");
        }

        // rinse with water

        // drain

        return true;
     }

    /**
     * Spin the tub at the correct speed for the cycle
     * @throws WashException
     */
      public boolean spinTub() throws WashException {

        // spin the tub at proper speed
        String spinSpeed = cycle.getCycle();
        if (!spinSpeed.equals("delicate")&(!spinSpeed.equals("normal"))) {
            throw new WashException("spin cycle is too fast for this old tub");
        }
        // spin the tub, etc.

          return true;
      }
}
