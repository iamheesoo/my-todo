package com.toy.mytodo

import android.app.Application
import android.content.Context
import com.toy.mytodo.adapter.TaskAdapter
import com.toy.mytodo.viewmodel.TaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(viewModelModule)
        }
    }

}

val viewModelModule = module {
    viewModel {
        TaskViewModel(get())
    }
}
