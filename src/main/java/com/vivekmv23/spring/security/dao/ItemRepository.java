package com.vivekmv23.spring.security.dao;

import com.vivekmv23.spring.security.domain.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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

    public Item selectFromItem(long itemId){
        entityManager.getTransaction().begin();
        return entityManager.find(Item.class, itemId);
    }

    @Transactional
    public Item updateAnItem(Item item){
        entityManager.merge(item);
        return item;
    }

    public List<Item> selectAllItem(){
        return entityManager.createQuery("select item from Item item", Item.class).getResultList();
    }
}
