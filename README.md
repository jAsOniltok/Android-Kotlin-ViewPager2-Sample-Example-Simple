# ViewPager2
viewPager2 sample

build.gradle (Module:app)

```kotlin
implementation 'androidx.viewpager2:viewpager2:1.0.0'
```
activity_main.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```
view_pager.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintTop_toTopOf="parent"
        android:id="@+id/textView"
        app:layout_constraintBottom_toBottomOf="parent"
        android:text="Test"
        android:textSize="14dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>
</androidx.constraintlayout.widget.ConstraintLayout>
```
```kotlin
package com.example.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private val data:Array<String>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_pager, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val textView:TextView = itemView.findViewById(R.id.textView)

        fun bind(data:String){
            textView.text = data
        }
    }
}
```
```kotlin
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
```
<img src="https://user-images.githubusercontent.com/46472692/86192086-a9acb780-bb83-11ea-8c2e-df2645fa0ecc.png" width="30%"></img>
<img src="https://user-images.githubusercontent.com/46472692/86191785-e6c47a00-bb82-11ea-9efa-0c1110225630.gif" width="30%"></img>
