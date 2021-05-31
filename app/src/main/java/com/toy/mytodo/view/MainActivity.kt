package com.toy.mytodo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import com.toy.mytodo.R
import com.toy.mytodo.databinding.ActivityMainBinding
import com.toy.mytodo.repository.dto.Task
import com.toy.mytodo.viewmodel.TaskViewModel
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {

    private val TAG="MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private val taskViewModel by viewModels<TaskViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.lifecycleOwner=this

        launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode== RESULT_OK){
                val task=it.data?.extras?.get(DATA_TASK) as Task
                insertTask(task)
            }
        }

        binding.nav.setOnNavigationItemSelectedListener { navigation(it) }
        binding.nav.selectedItemId= R.id.nav_home

    }

    private fun navigation(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.nav_home -> {
                var start=DateTime().withDayOfMonth(1).withTimeAtStartOfDay().millis
                val millis= DateTime(start).plusMonths(5).millis
                supportFragmentManager.beginTransaction().replace(R.id.main_content, HomeFragment(application)).commit()
                return true
            }
            R.id.nav_add ->{
                val intent=Intent(this@MainActivity, AddActivity::class.java)
                launcher.launch(intent)
                return true
            }
            R.id.nav_account ->{
                supportFragmentManager.beginTransaction().replace(R.id.main_content, AccountFragment()).commit()
                return true
            }
            else -> return false
        }
    }

    private fun insertTask(task: Task){
        Log.d(TAG, "$task")
        taskViewModel.insert(task)
    }

    companion object{
        const val DATA_TASK="DATA_TASK"
    }
}