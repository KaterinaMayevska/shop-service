package com.myshop.shopservice.services;
import com.myshop.shopservice.repository.model.Item;
import java.util.List;



public interface ItemService {
    public List<Item> findAll();

    public Item findById(Long id) throws IllegalArgumentException;

    public Long create(String articul, String name, Double price);

    public void update(Long id, String articul, String name, Double price) throws IllegalArgumentException;

    public void delete(Long id) throws IllegalArgumentException;


}
