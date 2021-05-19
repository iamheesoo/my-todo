package com.toy.mytodo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.toy.mytodo.R
import kotlinx.android.synthetic.main.activity_main.*
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav.setOnNavigationItemSelectedListener { navigation(it) }
        nav.selectedItemId= R.id.nav_home
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
                startActivity(Intent(this, AddActivity::class.java))
                return true
            }
            R.id.nav_account ->{
                supportFragmentManager.beginTransaction().replace(R.id.main_content, AccountFragment()).commit()
                return true
            }
            else -> return false
        }
    }
}