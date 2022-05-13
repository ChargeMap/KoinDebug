package com.chargemap_beta.koin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chargemap_beta.koin.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val injectedClass: InjectedClass = InjectedClass()

    private val viewModel by viewModel<MainActivityViewModel> {
        parametersOf(injectedClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val localInjectedClass = injectedClass
        val viewModelInjectedClass = viewModel.injectedClass

        Log.d("TEST", "$localInjectedClass == $viewModelInjectedClass")
    }
}