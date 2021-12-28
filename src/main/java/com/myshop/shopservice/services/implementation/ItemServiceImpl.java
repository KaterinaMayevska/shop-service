package com.myshop.shopservice.services.implementation;

import com.myshop.shopservice.repository.ItemRepository;
import com.myshop.shopservice.repository.model.Item;
import com.myshop.shopservice.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public final class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepo;
    public List<Item> findAll(){
        return itemRepo.findAll();

    }
    public Item findById(Long id) throws IllegalArgumentException{
        final Optional<Item> maybeItem = itemRepo.findById(id);
        if(maybeItem.isEmpty()) throw new RuntimeException("Impossible to do (Sorry)");
        else return maybeItem.get();
    }
    public Long create(String articul, String name, Double price){
        final Item item = new Item(articul, name, price);
        final Item savedItem = itemRepo.save(item);
        return savedItem.getId();
    }
    public void update(Long id, String articul, String name, Double price) throws IllegalArgumentException{
        final Optional<Item> maybeItem = itemRepo.findById(id);
        if(maybeItem.isEmpty())throw new RuntimeException("Item not found (Sorry)");
        final Item item = maybeItem.get();
        if(articul!=null && !articul.isBlank()) item.setArticul(articul);
        if(name!=null && !name.isBlank()) item.setName(name);
        if(price!=0) item.setPrice(price);
        itemRepo.save(item);
    }
    public void delete(Long id) throws IllegalArgumentException{
        final Optional<Item> maybeItem = itemRepo.findById(id);
        if(maybeItem.isEmpty()) throw new RuntimeException("No such item (Sorry)");
        itemRepo.deleteById(id);
    }
}
