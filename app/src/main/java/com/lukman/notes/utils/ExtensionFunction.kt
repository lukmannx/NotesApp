package com.lukman.notes.utils

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lukman.notes.R
import com.lukman.notes.ui.MainActivity

object ExtentionFunctions {
    fun Toolbar.setActionBar(requireActivity: FragmentActivity) {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        (requireActivity as MainActivity).setSupportActionBar(this)
        setupWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.updateFragment -> setNavigationIcon(R.drawable.ic_left_arrow)
                R.id.detailFragment -> setNavigationIcon(R.drawable.ic_left_arrow)
                R.id.addFragment -> setNavigationIcon(R.drawable.ic_left_arrow)
            }
        }
    }
}