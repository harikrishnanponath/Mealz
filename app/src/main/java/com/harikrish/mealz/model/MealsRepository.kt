package com.harikrish.mealz.model

import com.harikrish.mealz.model.response.MealCategoriesResponse

class MealsRepository {
    fun getMeals(): MealCategoriesResponse = MealCategoriesResponse(arrayListOf())
}