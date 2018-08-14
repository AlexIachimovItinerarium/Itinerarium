package com.example.itinerarium.utils

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.support.v7.app.AppCompatActivity

class ScreenNavigation(activity: Activity) {

  var fragmentManager: FragmentManager

  init {
    fragmentManager = activity.fragmentManager
  }

  fun replaceFragment(activeFragment: Fragment, fragmentToReplace: Fragment) {
    fragmentManager.beginTransaction().remove(activeFragment).add(fragmentToReplace,
        fragmentToReplace.tag).commit()
  }

  fun addFragment(containerId: Int, fragmentToAdd: Fragment) {
    fragmentManager.beginTransaction().add(containerId, fragmentToAdd, fragmentToAdd.tag).commit()
  }

  fun switchActivity(context: Context, activity: Class<out AppCompatActivity>) {
    val intent = Intent(context, activity)
    intent.setFlags(FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(Intent(context, activity))
  }
}
