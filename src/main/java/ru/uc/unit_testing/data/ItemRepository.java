package ru.uc.unit_testing.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.uc.unit_testing.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
