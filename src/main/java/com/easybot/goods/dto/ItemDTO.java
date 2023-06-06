package com.easybot.goods.dto;

import com.easybot.goods.model.Item;
import com.easybot.goods.model.ItemPropertyValue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ItemDTO {
    private Long id;
    private String serialNumber;
    private String manufacturer;
    private String category;
    private Float price;
    private Long quantity;
    private List<PropertyValueDTO> propertyValueDTOs = new ArrayList<>();



    public static ItemDTO fromItem(Item item) {
        ItemDTO dto = new ItemDTO();

        dto.setId(item.getId());
        dto.setSerialNumber(item.getSerialNumber());
        dto.setManufacturer(item.getManufacturer().getName());
        dto.setCategory(item.getCategory().getName());
        dto.setPrice(item.getPrice());
        dto.setQuantity(item.getQuantity());
        Set<ItemPropertyValue> ipvSet = item.getPropertyValues();
        if (ipvSet != null && !ipvSet.isEmpty()) {
            List<PropertyValueDTO> DTOs = new ArrayList<>();
            ipvSet.forEach(itemPropertyValue -> DTOs.add(PropertyValueDTO.fromItemPropertyValue(itemPropertyValue)));
            dto.setPropertyValueDTOs(DTOs);
        }

        return dto;
    }
}
