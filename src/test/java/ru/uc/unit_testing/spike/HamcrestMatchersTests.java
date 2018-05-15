package ru.uc.unit_testing.spike;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class HamcrestMatchersTests {



    @Test
    public void collectionAssertSize () {
        List<Integer> numbers = Arrays.asList(12,34,56);
        assertThat(numbers, hasSize(3));
    }
    
    @Test
    public void collectionHasElements () {
        List<Integer> numbers = Arrays.asList(12,34,56);
        assertThat(numbers, hasItems(12,56));
    }
    
    @Test
    public void allItemsInCollectionGreaterThan10 () {
        List<Integer> numbers = Arrays.asList(12,34,56);
        assertThat(numbers, everyItem(greaterThan(10)));
    }
    
    @Test
    public void allItemsInCollectionLessThan100 () {
        List<Integer> numbers = Arrays.asList(12,34,56);
        assertThat(numbers, everyItem(lessThan(100)));
    }

    @Test
    public void equalCollections () {
        List<Integer> numbers = Arrays.asList(12,34,56);
        assertThat(numbers, equalTo(Arrays.asList(12,34,56)));
    }
}
