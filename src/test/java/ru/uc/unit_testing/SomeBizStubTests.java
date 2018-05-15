package ru.uc.unit_testing;

import org.junit.Test;
import ru.uc.unit_testing.business.SomeBizImpl;
import ru.uc.unit_testing.data.SomeDataService;

import static org.junit.Assert.assertEquals;

class StubDataService implements SomeDataService {

    int[] Data;

    public StubDataService(int[] data) {
        Data = data;
    }

    @Override
    public int[] retrieveData() {
        return Data;
    }
}


public class SomeBizStubTests {
    @Test
    public void WhenIHaveEmptyData_ThanIGetEmptySum () {
        SomeBizImpl biz = new SomeBizImpl();

        biz.setSomeDataService(new StubDataService(new int[]{}));

        assertEquals(0, biz.calculateSumViaDataService());
    }

    @Test
    public void calculateSum() {
        SomeBizImpl b = new SomeBizImpl();
        b.setSomeDataService(new StubDataService(new int[]{1,2,3}));
        int result = b.calculateSumViaDataService();
        int expected = 6;

        assertEquals(expected, result);
    }

    @Test
    public void calculateSum_forOneValue () {
        SomeBizImpl biz = new SomeBizImpl();
        biz.setSomeDataService(new StubDataService(new int[]{1}));
        int result = biz.calculateSumViaDataService();
        assertEquals(1, result);
    }
}
