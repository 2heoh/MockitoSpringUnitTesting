package ru.uc.unit_testing.spike;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTests {


    @Test
    public void collectionSize3AndHasElement12 () {
        List<Integer> numbers = Arrays.asList(12,34,56);
        assertThat(numbers).hasSize(3).contains(12);
    }

    @Test
    public void allElementsInCollectionMoreThan10 () {
        List<Integer> numbers = Arrays.asList(12,34,56);
        assertThat(numbers).allMatch( x -> x > 10);
    }
    
    @Test
    public void emptyString () {
        String empty = "";
        assertThat(empty).isEmpty();
    }
}
