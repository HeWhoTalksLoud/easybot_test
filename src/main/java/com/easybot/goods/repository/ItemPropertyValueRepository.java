package com.easybot.goods.repository;

import com.easybot.goods.model.ItemPropertyKey;
import com.easybot.goods.model.ItemPropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPropertyValueRepository extends JpaRepository<ItemPropertyValue, ItemPropertyKey> {
}
