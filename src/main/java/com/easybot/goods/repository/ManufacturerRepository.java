package com.easybot.goods.repository;

import com.easybot.goods.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository <Manufacturer, Long> {
}
