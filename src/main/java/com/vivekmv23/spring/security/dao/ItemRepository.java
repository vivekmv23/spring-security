package com.vivekmv23.spring.security.dao;

import com.vivekmv23.spring.security.domain.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Item insertIntoItem(Item item){
        entityManager.persist(item);
        return item;
    }

    @Transactional
    public boolean deleteFromItem(long itemId){
        Item itemToDelete = entityManager.find(Item.class, itemId);
        entityManager.remove(itemToDelete);
        return true;
    }

    @Transactional
    public Item updateAnItem(Item itemToUpdate){
        entityManager.merge(itemToUpdate);
        return itemToUpdate;
    }

    public Item selectFromItem(long itemId){
        return entityManager.find(Item.class, itemId);
    }

    public List<Item> selectAllItem(){
        return entityManager.createQuery("from Item", Item.class).getResultList();
    }
}
