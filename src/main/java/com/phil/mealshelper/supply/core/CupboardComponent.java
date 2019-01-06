package com.phil.mealshelper.supply.core;

import com.phil.mealshelper.supply.model.CupboardItem;

import java.util.List;

public interface CupboardComponent {
    CupboardItem addItemToCupboard(CupboardItem cupboardItem);
    List<CupboardItem> getAllCupboardItems();
}
