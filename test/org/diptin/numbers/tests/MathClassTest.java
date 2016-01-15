package org.diptin.numbers.tests;

import junit.framework.Assert;
import org.diptin.numbers.MathClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

public class MathClassTest {
    MathClass mathClass;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInitExceptionOnTotalStudents() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Total number of students can not be negative");
        mathClass = new MathClass(-1,9);
    }

    @Test
    public void testInitExceptionOnRegularStudents() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("required students must be positive number, greater than total number of students");
        mathClass = new MathClass(5,6);
    }

    @Before
    public void initMathClass() {
        mathClass = new MathClass(5,3);
    }
    @Test
    public void testIsClassCancelledPositive() {
        Assert.assertEquals(true, mathClass.isClassCancelled(new int[]{-1,0,4,3,2}));
    }

    @Test
    public void testIsClassCancelledNegative() {
        Assert.assertEquals(false, mathClass.isClassCancelled(new int[]{-1,0,4,3,0}));
    }

    @Test
    public void testArrivalTimeNPE() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("arrival time can not be null");
        int[] nullTest = null;
        mathClass.isClassCancelled(nullTest);
    }

    @Test
    public void testArrivalTimeException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("arrival times for exactly");
        mathClass.isClassCancelled(new int[]{3,4,5});
    }

}
