package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        add_button.setOnClickListener {
            addFragment(TaskAddEditFormView.getInstance(), "task_add_edit_view")
        }
    }

    fun addFragment(fragment: Fragment, tag: String?) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment, tag)
            .addToBackStack(tag).apply {
                getCurrentFragment()?.let { currentFragment ->
                    hide(currentFragment)
                }
            }
            .commit()
    }

    fun getCurrentFragment() =
        supportFragmentManager.findFragmentByTag(
            supportFragmentManager.getBackStackEntryAt(
                supportFragmentManager.backStackEntryCount - 1
            ).name
        )
}