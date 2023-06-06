package com.easybot.goods.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ItemPropertyKey implements Serializable {
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "property_id")
    private Long propertyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPropertyKey that = (ItemPropertyKey) o;
        return Objects.equals(itemId, that.itemId) && Objects.equals(propertyId, that.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, propertyId);
    }
}
