package ru.uc.unit_testing.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.uc.unit_testing.model.Item;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTests {

    @Autowired
    ItemRepository repository;

    @Test
    public void findAll () {

        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

    @Test
    public void retrieveItemWithId10001 () {

        Item item = repository.findById(10001).get();
        assertEquals(10001, item.getId());
    }


}
