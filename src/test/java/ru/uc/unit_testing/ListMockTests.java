package ru.uc.unit_testing;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTests {
    List<String> mock = mock(List.class);
    
    
    @Test
    public void SizeOfList () {
        
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }
    
    @Test
    public void returnDifferentValues () {
        when(mock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }
    
    @Test
    public void returnWithParameters () {
        when(mock.get(0)).thenReturn("one");
        assertEquals("one", mock.get(0));
        assertEquals(null, mock.get(1));
    }
    
    @Test
    public void returnWithGenericParameters () {
        when(mock.get(anyInt())).thenReturn("some value");
        assertEquals("some value", mock.get(10));
    }
    
    @Test
    public void verificationBasics () {
        // SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);


        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapture () {
        mock.add("Some String");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Some String", captor.getValue());
    }

    @Test
    public void multipleCapturing () {
        mock.add("Some string 1");
        mock.add("Some string 2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("Some string 1", allValues.get(0));
        assertEquals("Some string 2", allValues.get(1));

    }
    
    @Test
    public void mocking () {
        ArrayList arrayListMock = mock(ArrayList.class);

        arrayListMock.get(0);
        arrayListMock.size();

        arrayListMock.add("1");
        arrayListMock.add("2");
        arrayListMock.size();

        when(arrayListMock.size()).thenReturn(5);
    }

    @Test
    public void spying () {
        ArrayList arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("0");

        arrayListSpy.get(0);
        arrayListSpy.size();

        arrayListSpy.add("1");
        arrayListSpy.add("2");
        arrayListSpy.size();

        when(arrayListSpy.size()).thenReturn(5);
    }

}
