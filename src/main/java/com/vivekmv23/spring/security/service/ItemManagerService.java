package com.vivekmv23.spring.security.service;

import com.vivekmv23.spring.security.domain.Item;
import java.util.List;

public interface ItemManagerService {

    Item addNewItem(Item item);
    Item selectItemById(Long itemId);
    Item editItem(Item item);
    List<Item> getAllItem();
    boolean deleteItemById(Long itemId);

}
