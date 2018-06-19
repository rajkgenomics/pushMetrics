package genomics.pushdatadog;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import genomics.pushdatadog.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	App rajApp = new App();
    	rajApp.main(null);
        assertTrue( true );
    }
    
    /**
     * Rigourous Test2 :-)
     */
    public void testApp2()
    {
        assertTrue( false );
    }
}
