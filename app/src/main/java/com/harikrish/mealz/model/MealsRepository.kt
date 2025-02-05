package com.harikrish.mealz.model

import com.harikrish.mealz.model.api.MealsWebService
import com.harikrish.mealz.model.response.MealCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallBack: (response: MealCategoriesResponse?) -> Unit) {
        return webService.getMeals().enqueue(object: Callback<MealCategoriesResponse>{
            override fun onResponse(
                call: Call<MealCategoriesResponse>,
                response: Response<MealCategoriesResponse>
            ) {
                if (response.isSuccessful)
                    successCallBack(response.body())
            }

            override fun onFailure(call: Call<MealCategoriesResponse>, t: Throwable) {

            }
        })
    }
}