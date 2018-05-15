package ru.uc.unit_testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.uc.unit_testing.business.ItemBusinessService;
import ru.uc.unit_testing.model.Item;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    ItemBusinessService businessService;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-layer")
    public Item itemFromBusinessLayer() {
        return businessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items")
    public List<Item> showAllItems() {
        return businessService.retrieveAllItems();
    }

}
