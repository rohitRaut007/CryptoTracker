package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.presentation.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.greenBackground

@Composable
fun PriceChange(
    change: DisplayableNumber
){
    val contentColor = if(change.value < 0){
        MaterialTheme.colorScheme.onErrorContainer
    } else{
        Color.Green
    }

    val backgroundColor = if(change.value < 0){
        MaterialTheme.colorScheme.onErrorContainer
    }else{
        greenBackground
    }

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(100f))
            .background(backgroundColor)
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = if(change.value<0){
                Icons.Default.KeyboardArrowDown
            }else{
                Icons.Default.KeyboardArrowUp
            },
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = contentColor
        )
        Text(
            text = "${change.formatted} %",
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )

    }

}

@PreviewLightDark
@Composable
private fun PriceChangePreview(){
   CryptoTrackerTheme {
       PriceChange(
           change = DisplayableNumber(
               value = 11.45,
               formatted = "11.45"
           )
       )
   }
}