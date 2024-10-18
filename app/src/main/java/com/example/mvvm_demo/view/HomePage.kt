package com.example.mvvm_demo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.lifecycle.ViewModel
import com.example.mvvm_demo.viewmodel.HomeVieModel

@Composable
fun HomePage(modifier: Modifier = Modifier, viewModel: HomeVieModel) {

    val userData = viewModel.userData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()

    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Button(onClick = {
            viewModel.getUserData()
        }) {
            Text(text="Get Data")
        }

        if(isLoading.value==true){
            CircularProgressIndicator()
        }else{
            userData.value?.name?.let {
                Text(text = "NAME $it")
            }

            userData.value?.age?.let {
                Text(text = "AGE $it")
            }
        }
    }
}