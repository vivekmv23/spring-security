package com.vivekmv23.spring.security.service;

import com.vivekmv23.spring.security.dao.ItemRepository;
import com.vivekmv23.spring.security.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemManagerServiceImpl implements ItemManagerService {

    private ItemRepository itemRepository;

    public ItemManagerServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addNewItem(Item item) {
        return itemRepository.insertIntoItem(item);
    }

    @Override
    public Item selectItemById(Long itemId) {
        return itemRepository.selectFromItem(itemId);
    }

    @Override
    public Item editItem(Item itemToUpdate) {
        return itemRepository.updateAnItem(itemToUpdate);
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepository.selectAllItem();
    }

    @Override
    public boolean deleteItemById(Long itemId) {
        return itemRepository.deleteFromItem(itemId);
    }
}
