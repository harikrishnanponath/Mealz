package com.harikrish.mealz.ui.meals

import androidx.lifecycle.ViewModel
import com.harikrish.mealz.model.MealsRepository
import com.harikrish.mealz.model.response.MealCategoriesResponse
import com.harikrish.mealz.model.response.MealResponse

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()) : ViewModel() {
    fun getMeals(successCallBack: (response: MealCategoriesResponse?) -> Unit) {
         repository.getMeals{ response ->
             successCallBack(response)
         }
    }
}