package com.easybot.goods.controller;

import com.easybot.goods.dto.ItemDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    // todo Добавление товара
    @PostMapping()
    public void addItem(@RequestBody ItemDTO itemDTO) {

    }

    // todo Редактирование товара
    @PutMapping("")
    public void editItem(@RequestBody ItemDTO itemDTO) {

    }

    // todo Просмотр всех существующих товаров по типу
    @GetMapping("/type/{type_id}")
    public void getItemsByType(@PathVariable(name = "type_id") String typeId) {

    }

    // todo Просмотр товара по идентификатору
    @GetMapping("/{id}}")
    public void getItemById(@PathVariable(name = "id") Long id) {

    }


}
