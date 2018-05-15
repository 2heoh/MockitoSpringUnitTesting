package ru.uc.unit_testing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.uc.unit_testing.business.ItemBusinessService;
import ru.uc.unit_testing.business.SomeBizImpl;
import ru.uc.unit_testing.data.ItemRepository;
import ru.uc.unit_testing.data.SomeDataService;
import ru.uc.unit_testing.model.Item;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTests {

    @InjectMocks
    ItemBusinessService service;

    @Mock
    ItemRepository repository;

    @Test
    public void retrieveAllData () {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1, "Item", 10, 10)));

        List<Item> expected = Arrays.asList(new Item(1, "Item", 10, 10));

        List<Item> items = service.retrieveAllItems();


        assertEquals(100, items.get(0).getValue());
    }

}
