package com.phil.mealshelper.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quantity {
    private Double value;
    private Unit unit;

    public enum Unit {
        GR("gr"),
        ML("ml");

        private String unitName;

        Unit(String unitName) {
            this.unitName = unitName;
        }

        @Override
        public String toString() {
            return unitName;
        }
    }
}
