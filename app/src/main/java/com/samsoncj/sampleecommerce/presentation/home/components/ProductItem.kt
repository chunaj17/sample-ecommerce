package com.samsoncj.sampleecommerce.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.samsoncj.sampleecommerce.R
import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel

@Composable
fun ProductItem(
    ecommerceModel: EcommerceModel,
    modifier: Modifier,
) {
    Card(modifier = modifier,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Image(
            painterResource(id = R.drawable.placeholder),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = ecommerceModel.title,
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = buildString {
                    append("price |")
                    append(ecommerceModel.price)
                },
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color =  MaterialTheme.colors.surface,
            )

        }
    }
    }
}