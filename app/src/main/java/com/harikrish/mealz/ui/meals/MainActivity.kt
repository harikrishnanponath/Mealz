package com.harikrish.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.harikrish.mealz.model.response.MealResponse
import com.harikrish.mealz.ui.theme.MealzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealzTheme {
                MeelsCategoriesScreen()
            }
        }
    }
}


@Composable
fun MeelsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberedMeals = remember { mutableStateOf(emptyList<MealResponse>()) }
    viewModel.getMeals { response ->
        val mealsFromApi = response?.categories
        rememberedMeals.value = mealsFromApi.orEmpty()
    }
    Scaffold { innerpadding ->
        LazyColumn(modifier = Modifier.padding(innerpadding)) {
            items(rememberedMeals.value) { meal ->
                Text(text = meal.name)

            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzTheme {
        MeelsCategoriesScreen()
    }
}