package com.example.frontend

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private var selectedTab: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //绑定控件和布局
        val hotLayout: LinearLayout = findViewById(R.id.hotLayout)
        val dynamicLayout: LinearLayout = findViewById(R.id.dynamicLayout)
        val personLayout: LinearLayout = findViewById(R.id.personLayout)

        var hotText: TextView = findViewById(R.id.hot_tx);
        var dynamicText: TextView = findViewById(R.id.dynamic_tx);
        var personText: TextView = findViewById(R.id.person_tx);
        //设置默认界面为HotFragment
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragment_container,HotFragment())
            .commit()

        hotLayout.setOnClickListener {
            // 检查是否被选中
            if (selectedTab != 1) {
                //设置界面
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container,HotFragment())
                    .commit()

                // 设置其他按钮为未选中状态
                dynamicLayout.setBackgroundResource(R.drawable.front_border);
                personLayout.setBackgroundResource(R.drawable.front_border);
                // 设置 home 按钮的选中状态
                hotLayout.setBackgroundResource(R.drawable.front_border_select);
                selectedTab = 1
            }
        }
        dynamicLayout.setOnClickListener {
            // 检查是否被选中
            if (selectedTab != 2) {
                //设置界面
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, DynamicFragment())
                    .commit()
git
                // 设置其他按钮为未选中状态
                hotLayout.setBackgroundResource(R.drawable.front_border);
                personLayout.setBackgroundResource(R.drawable.front_border);
                // 设置 home 按钮的选中状态
                dynamicLayout.setBackgroundResource(R.drawable.front_border_select);
                selectedTab = 2
            }
        }
        personLayout.setOnClickListener {
            // 检查是否被选中
            if (selectedTab != 3) {
                //设置界面
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, PersonFragment())
                    .commit()

                // 设置其他按钮为未选中状态
                hotLayout.setBackgroundResource(R.drawable.front_border);
                dynamicLayout.setBackgroundResource(R.drawable.front_border);
                // 设置 home 按钮的选中状态
                personLayout.setBackgroundResource(R.drawable.front_border_select);
                selectedTab = 3
            }
        }


    }


}