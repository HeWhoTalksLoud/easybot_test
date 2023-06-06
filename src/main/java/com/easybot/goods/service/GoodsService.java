package com.easybot.goods.service;

import com.easybot.goods.dto.ItemDTO;
import com.easybot.goods.dto.ItemToAddDTO;
import com.easybot.goods.dto.PropertyValueToAddDTO;
import com.easybot.goods.exception.NotFoundException;
import com.easybot.goods.model.*;
import com.easybot.goods.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final PropertyRepository propertyRepository;
    private final ItemPropertyValueRepository itemPropertyValueRepository;

    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();

        if (items.isEmpty()) {
            throw new NotFoundException("Товары отсутствуют");
        }

        List<ItemDTO> dtos = items.stream()
                .map(ItemDTO::fromItem)
                .collect(Collectors.toList());

        return dtos;
    }

    public ItemDTO addItem(ItemToAddDTO itemDTO) {
        itemDTO.setId(null);
        return saveItem(itemDTO);
    }
    public ItemDTO editItem(ItemToAddDTO itemDTO) {
        return saveItem(itemDTO);
    }

    private ItemDTO saveItem(ItemToAddDTO itemDTO) {
        Item item = itemDTO.toItem();
        Long manufacturerId = itemDTO.getManufacturerId();
        Long categoryId = itemDTO.getCategoryId();
        item.setManufacturer(manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new NotFoundException("Производитель с ид. " + manufacturerId + " не найден")));
        item.setCategory(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Категория с ид. " + categoryId + " не найдена")));
        Item savedItem = itemRepository.save(item);
        Long savedItemId = savedItem.getId();
        List<PropertyValueToAddDTO> dtos = itemDTO.getPropertyValueDTOs();
        if (dtos != null && !dtos.isEmpty()) {
            Set<ItemPropertyValue> propertyValues = new HashSet<>();
            itemDTO.getPropertyValueDTOs().forEach(propertyValueToAddDTO -> {
                ItemPropertyValue ipv = new ItemPropertyValue();
                ipv.setItem(item);
                Long propertyId = propertyValueToAddDTO.getPropertyId();
                Property property = propertyRepository.findById(propertyId)
                        .orElseThrow(() -> new NotFoundException("Свойство с ид. " + propertyId + " не найдено"));
                ipv.setProperty(property);
                ipv.setValue(propertyValueToAddDTO.getValue());
                ItemPropertyKey ipk = new ItemPropertyKey();
                ipk.setItemId(savedItemId);
                ipk.setPropertyId(propertyId);
                ipv.setId(ipk);
                itemPropertyValueRepository.save(ipv);
                propertyValues.add(ipv);
            });
            savedItem.setPropertyValues(propertyValues);
        }
        savedItem = itemRepository.save(savedItem);

        return ItemDTO.fromItem(savedItem);

    }


    public List<ItemDTO> getItemsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Категория с ид. " + categoryId + " отсутствует"));
        List<Item> items = itemRepository.findAllByCategory_Id(categoryId);

        if (items.isEmpty()) {
            throw new NotFoundException("Товары в категории \"" + category.getName() + "\" отсутствуют");
        }

        List<ItemDTO> dtos = items.stream()
                .map(ItemDTO::fromItem)
                .collect(Collectors.toList());

        return dtos;
    }

    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Предмет с ид. " + id + " не найден"));
        return ItemDTO.fromItem(item);
    }
}
