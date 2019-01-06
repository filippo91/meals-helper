package com.phil.mealshelper.recipe.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Recipe {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private List<Ingredient> ingredients;
    private List<CookingStep> cookingSteps;
    private Integer duration;
    private Difficulty difficulty;




    public enum Difficulty {
        HARD("hard"),
        MEDIUM("medium"),
        EASY("easy");


        private String difficulty;

        Difficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        @Override
        public String toString() {
            return difficulty;
        }
    }
}
