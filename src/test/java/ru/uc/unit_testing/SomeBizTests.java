package ru.uc.unit_testing;

import org.junit.Test;
import ru.uc.unit_testing.business.SomeBizImpl;

import static org.junit.Assert.assertEquals;

public class SomeBizTests {

    @Test
    public void calculateSum() {
        SomeBizImpl b = new SomeBizImpl();
        int result = b.calcualteSum(new int[] {1,2,3});
        int expected = 6;

        assertEquals(expected, result);
    }

    @Test
    public void calculateSum_forEmptyData () {
        SomeBizImpl biz = new SomeBizImpl();
        int result = biz.calcualteSum(new int[]{});
        assertEquals(0, result);
    }

    @Test
    public void calculateSum_forOneValue () {
        SomeBizImpl biz = new SomeBizImpl();
        int result = biz.calcualteSum(new int[]{1});
        assertEquals(1, result);
    }




}
