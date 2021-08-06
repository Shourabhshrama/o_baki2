package com.kuberkings.obaki






import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import com.kuberkings.obaki.screens.bottomview.chat.DashboardFragment
import com.kuberkings.obaki.screens.bottomview.home.HomeFragment
import com.kuberkings.obaki.screens.bottomview.notifications.NotificationsFragment
import com.kuberkings.obaki.screens.bottomview.orders.OrderFragment
import com.kuberkings.obaki.screens.chef.onboarding.ChefOnboardingActivity
import com.kuberkings.obaki.screens.notification.NotificationActivity
import com.kuberkings.obaki.screens.order.OrderActivity
import com.kuberkings.obaki.screens.profile.ProfileActivity
import com.kuberkings.obaki.util.CustomBottomNavigationView
import com.kuberkings.obaki.util.Utility


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    var drawerLayout: DrawerLayout? = null
   lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
   lateinit var sideNavigationView: NavigationView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mToolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false);

        var curvedBottomNavigationView =
            findViewById<CustomBottomNavigationView>(R.id.customBottomBar)
        curvedBottomNavigationView.inflateMenu(R.menu.bottom_nav_menu)
        drawerLayout = findViewById(R.id.my_drawer_layout)
        sideNavigationView = findViewById(R.id.sideNavigationView)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.nav_open,
            R.string.nav_close
        )


        drawerLayout?.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        switchToFragment1(HomeFragment())


        curvedBottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    switchToFragment1(HomeFragment())
                }
                R.id.Search -> {
                    switchToFragment1(OrderFragment())
                }
                R.id.Profile -> {
                    switchToFragment1(DashboardFragment())
                }
                R.id.Settings -> {
                    switchToFragment1(NotificationsFragment())
                }
            }
            true
        }

        sideNavigationView.setNavigationItemSelectedListener(this);



    }

        fun switchToFragment1(Fragment :Fragment) {
        val manager: FragmentManager = supportFragmentManager
        manager.beginTransaction().replace(R.id.container, Fragment).commit()
    }

   override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.profile -> {
                Utility.startActivity(
                    this@MainActivity,
                    ProfileActivity::class.java
                )
            }
            R.id.newTour -> {
                Utility.startActivity(
                    this@MainActivity,
                    ChefOnboardingActivity::class.java
                )
            }
            R.id.notification -> {
                Utility.startActivity(
                    this@MainActivity,
                    NotificationActivity::class.java
                )
            }
            R.id.orders -> {
                Utility.startActivity(
                    this@MainActivity,
                    OrderActivity::class.java
                )
            }
        }
        //close navigation drawer
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}