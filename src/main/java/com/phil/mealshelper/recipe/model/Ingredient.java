package com.phil.mealshelper.recipe.model;

import com.phil.mealshelper.common.model.TradeItem;
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
