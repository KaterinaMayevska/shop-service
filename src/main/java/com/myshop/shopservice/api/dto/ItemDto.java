package com.myshop.shopservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String articul;
    private String name;
    private Double price;
}
