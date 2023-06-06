package com.easybot.goods.controller;

import com.easybot.goods.dto.ItemDTO;
import com.easybot.goods.dto.ItemToAddDTO;
import com.easybot.goods.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;


    // Тестовый метод - вывод всех товаров
    @GetMapping
    public ResponseEntity<List<ItemDTO>> testGoods() {
        return ResponseEntity.ok(goodsService.getAllItems());
    }

    // Добавление товара
    @PostMapping()
    public ResponseEntity<ItemDTO> addItem(@RequestBody ItemToAddDTO itemDTO) {
        return ResponseEntity.ok(goodsService.addItem(itemDTO));

    }

    // Редактирование товара
    @PutMapping("")
    public ResponseEntity<ItemDTO> editItem(@RequestBody ItemToAddDTO itemDTO) {
        return ResponseEntity.ok(goodsService.editItem(itemDTO));
    }

    // Просмотр всех существующих товаров по типу
    @GetMapping("/category/{category_id}")
    public ResponseEntity<List<ItemDTO>> getItemsByCategory(@PathVariable(name = "category_id") Long categoryId) {
        return ResponseEntity.ok(goodsService.getItemsByCategory(categoryId));
    }

    // Просмотр товара по идентификатору
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(goodsService.getItemById(id));

    }


}
