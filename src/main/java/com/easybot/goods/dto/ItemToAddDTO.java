package com.easybot.goods.dto;

import com.easybot.goods.model.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemToAddDTO {
    private Long id;
    private String serialNumber;
    private Long manufacturerId;
    private Long categoryId;
    private Float price;
    private Long quantity;
    private List<PropertyValueToAddDTO> propertyValueDTOs = new ArrayList<>();

    public Item toItem() {
        Item item = new Item();

        item.setId(getId());
        item.setSerialNumber(getSerialNumber());
        item.setPrice(getPrice());
        item.setQuantity(getQuantity());

        return item;
    }

}
