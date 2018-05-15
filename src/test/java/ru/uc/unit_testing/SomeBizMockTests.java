package ru.uc.unit_testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.uc.unit_testing.business.SomeBizImpl;
import ru.uc.unit_testing.data.SomeDataService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBizMockTests {

    @InjectMocks
    SomeBizImpl business;

    @Mock
    SomeDataService mockService;

    @Test
    public void SomeOfEmpty_EqualsZero () {
        when(mockService.retrieveData()).thenReturn(new int[]{});

        assertEquals(0, business.calculateSumViaDataService());
    }

    @Test
    public void SumOfOneAndOne_EqualsThree() {
        when(mockService.retrieveData()).thenReturn(new int[]{1, 2});

        assertEquals(3, business.calculateSumViaDataService());
    }

    @Test
    public void SumOfOne_EqualsOne () {
        when(mockService.retrieveData()).thenReturn(new int[]{1});

        assertEquals(1, business.calculateSumViaDataService());
    }
}
