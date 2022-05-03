package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentPosition: Int = 0
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Fragment1>(R.id.fl1)
            }
            fragmentPosition = 0
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Fragment2>(R.id.fl2)
            }
        }
        var caption: Button = findViewById(R.id.caption)
        caption.setOnClickListener { View ->
            if (fragmentPosition == 0) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<Fragment1>(R.id.fl2)
                }
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<Fragment2>(R.id.fl1)
                }
                fragmentPosition = 1
            }
            else{
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<Fragment1>(R.id.fl1)
                }
                fragmentPosition = 0
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<Fragment2>(R.id.fl2)
                }
            }
        }
    }
}