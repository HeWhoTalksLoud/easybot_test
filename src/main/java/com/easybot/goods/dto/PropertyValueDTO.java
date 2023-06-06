package com.easybot.goods.dto;

import com.easybot.goods.model.ItemPropertyValue;
import lombok.Data;

@Data
public class PropertyValueDTO {
    private String property;
    private String value;

    public static PropertyValueDTO fromItemPropertyValue(ItemPropertyValue ipv) {
        PropertyValueDTO dto = new PropertyValueDTO();
        dto.setProperty(ipv.getProperty().getName());
        dto.setValue(ipv.getValue());

        return dto;
    }
}
