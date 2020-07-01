package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val data = arrayOf("aa","bb","cc","dd")
		pager.adapter = ViewPagerAdapter(data)
		pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
		pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
			override fun onPageSelected(position: Int) {
				super.onPageSelected(position)
				Toast.makeText(this@MainActivity, "onPageSelected", Toast.LENGTH_SHORT).show()
			}
		})
	}
}