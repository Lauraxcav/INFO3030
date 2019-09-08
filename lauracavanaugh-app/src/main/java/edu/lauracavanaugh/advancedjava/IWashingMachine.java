package edu.lauracavanaugh.advancedjava;

public interface IWashingMachine {
    boolean runWashCycle() throws WashException;
    boolean spinTub() throws WashException;
}
