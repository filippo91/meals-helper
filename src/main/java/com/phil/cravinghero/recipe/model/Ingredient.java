package com.phil.cravinghero.recipe.model;

import com.phil.cravinghero.common.model.TradeItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Ingredient extends TradeItem {
    public Ingredient(String gtin){
        super(gtin);
    }
}
