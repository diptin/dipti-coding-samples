package org.diptin.numbers.tests;

import junit.framework.Assert;
import org.diptin.numbers.FibonacciSeries;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by dipti on 9/24/15.
 */
@RunWith(Parameterized.class)
public class FibonacciSeriesTest {
    private int input;
    private int expected;

    public FibonacciSeriesTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {0,0},
                {1,1},
                {2,1},
                {5,5},
                {8,21},
                {-2,-1}
        });
    }

    @Test
    public void testGetFibonacciForRank () {
        FibonacciSeries fibObj = new FibonacciSeries();
        Assert.assertEquals(expected, fibObj.getFibonacciForRank(input));
    }

}
