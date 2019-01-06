package com.phil.cravinghero.supply.core;

import com.phil.cravinghero.supply.model.CupboardItem;

import java.util.List;

public interface CupboardComponent {
    CupboardItem addItemToCupboard(CupboardItem cupboardItem);
    List<CupboardItem> getAllCupboardItems();
}
