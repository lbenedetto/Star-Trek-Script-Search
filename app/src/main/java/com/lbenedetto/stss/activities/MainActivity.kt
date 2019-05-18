package com.lbenedetto.stss.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.lbenedetto.stss.R
import com.lbenedetto.stss.room.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.main_navigation_host_fragment)
        bottom_navigation.setupWithNavController(navController)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "startrek-db"
        ).build()
    }

}
