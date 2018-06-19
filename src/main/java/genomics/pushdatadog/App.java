package genomics.pushdatadog;

import com.timgroup.statsd.ServiceCheck;
import com.timgroup.statsd.StatsDClient;
import com.timgroup.statsd.NonBlockingStatsDClient;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final StatsDClient statsd = new NonBlockingStatsDClient(
		    "my.prefix",                          /* prefix to any stats; may be null or empty string */
		    "localhost",                        /* common case: localhost */
		    8125,                                 /* port */
		    new String[] {"rajpushmethod:laptop"}            /* Datadog extension: Constant tags, always applied */
		  );
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World! ABout to push some metrics" );
        Random rand = new Random();        
//        statsd.incrementCounter("foo");
//        statsd.recordGaugeValue("bar", 100);
//        statsd.recordGaugeValue("baz", 0.01); /* DataDog extension: support for floating-point gauges */
//        statsd.recordHistogramValue("qux", 15);     /* DataDog extension: histograms */
//        statsd.recordHistogramValue("qux", 15.5);   /* ...also floating-point */
//        statsd.recordDistributionValue("qux", 15);     /* DataDog extension: global distributions */
//        statsd.recordDistributionValue("qux", 15.5);   /* ...also floating-point */
//
//        ServiceCheck sc = ServiceCheck
//              .builder()
//              .withName("my.check.name")
//              .withStatus(ServiceCheck.Status.OK)
//              .build();
//        statsd.serviceCheck(sc); /* Datadog extension: send service check status */
//
//        /* Compatibility note: Unlike upstream statsd, DataDog expects execution times to be a
//         * floating-point value in seconds, not a millisecond value. This library
//         * does the conversion from ms to fractional seconds.
//         */
//        statsd.recordExecutionTime("bag", 25, "cluster:foo"); /* DataDog extension: cluster tag */
        
        pushCounterMetrics(rand.nextInt(50));
        pushGaugeMetrics(rand.nextInt(50));
        pushHistogramMetrics(rand.nextInt(50));
        
    }
    
    public static void pushCounterMetrics(int numTimes) {
    	for (int i=0; i < numTimes; i++) {
    		statsd.incrementCounter("raj_page_hits","webpage:page1");
    		
    		// For Page2 increment by 2
    		statsd.incrementCounter("raj_page_hits",2,"webpage:page2");
    	}
    }
    
    public static void pushGaugeMetrics(int numTimes) {
    	
    	//Im pretty sure that only the last value will be taken by the dogstatd agent for Gauges.
    	//So, even though Im looping here, it should only be the last value. Just want to see what happens...
    	for (int i=0; i < numTimes; i++) {
    		
    		statsd.recordGaugeValue("raj_economic_climate",numTimes,"webpage:page1");
    		
    		// For Page2 multiply by 2
    		statsd.recordGaugeValue("raj_economic_climate",numTimes*2,"webpage:page2");
    	}
    }
    
    public static void pushHistogramMetrics(int numTimes) {
    	
    	// This should record each of these values, and show the mean, 95th percentile, max, min etc etc..
    	for (int i=0; i < numTimes; i++) {
    		
    		statsd.recordHistogramValue("raj_page_loadtime",numTimes,"webpage:page1");
    		
    		// For Page2 multiply by 2
    		statsd.recordHistogramValue("raj_page_loadtime",numTimes*2,"webpage:page2");
    	}
    }
}
