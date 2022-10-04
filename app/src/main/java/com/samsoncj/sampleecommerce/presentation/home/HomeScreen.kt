package com.samsoncj.sampleecommerce.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samsoncj.sampleecommerce.presentation.home.components.ProductItem
import com.samsoncj.sampleecommerce.presentation.home.logic.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    viewModel.getProducts()
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Products",
            modifier = Modifier
                .padding(4.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.padding(16.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        LazyColumn {
            items(state.data) { product ->
                ProductItem(
                    ecommerceModel = product,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { },
                )

                Spacer(modifier = Modifier.height(16.dp))

            }
        }

    }
}