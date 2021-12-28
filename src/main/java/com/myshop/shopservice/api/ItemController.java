package com.myshop.shopservice.api;


import com.myshop.shopservice.api.dto.ItemDto;
import com.myshop.shopservice.repository.model.Item;
import com.myshop.shopservice.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public final class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> index() {
        final List<Item> items = itemService.findAll();
      return ResponseEntity.ok(items);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Item> show(@PathVariable long id) {
        try{
            final Item item = itemService.findById(id);
            return ResponseEntity.ok(item);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }}


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ItemDto itemDto) {
        final String articul = itemDto.getArticul();
        final String name =itemDto.getName();
        final Double price = itemDto.getPrice();
        final Long id = itemService.create(articul, name, price);
        final String location = String.format("/items/%d", id);
        return ResponseEntity.created(URI.create(location)).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ItemDto itemDto){
        final String articul = itemDto.getArticul();
        final String name = itemDto.getName();
        final Double price = itemDto.getPrice();
        try{
            itemService.update(id, articul, name, price);
            return  ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e){
        return ResponseEntity.notFound().build();
    }}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            itemService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
        return ResponseEntity.notFound().build();
    }}

    @GetMapping("/dto/{id}")
    public ResponseEntity<ItemDto> getDtoById(@PathVariable Long id) {
        try {
            Item item = itemService.findById(id);
            ItemDto itemDto = new ItemDto(item.getArticul(),item.getName(), item.getPrice());

            return ResponseEntity.ok(itemDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}



