package edu.lauracavanaugh.advancedjava;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class WashingMachineTest extends TestCase
{
    private WashingMachine machineDelicates;
    private WashingMachine machineNormal;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WashingMachineTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WashingMachineTest.class );
    }

    public void setup() {
        this.machineDelicates = new WashingMachine(new DelicateCycle());
        this.machineNormal = new WashingMachine(new NormalCycle());
}
    /**
     * Test a wash cycle
     */

    public void testWashCycle()
    {
        setup();
        assertEquals( this.machineDelicates.getWashCycle(),"delicate");
     }

    public void testRunCycle()
    {
        setup();
        try {
            assertTrue(this.machineDelicates.runWashCycle());
        }
        catch (WashException e) {}
    }

    public void testSpin() {
        setup();
        try {
            assertTrue(this.machineDelicates.spinTub());
        } catch (WashException e) {}
    }
}


