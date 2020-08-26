/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.example_multi_nav_activity.*
import org.abanoubmilad.labyrinth.Builder
import org.abanoubmilad.labyrinth.INavHolder
import org.abanoubmilad.labyrinth.Labyrinth
import org.abanoubmilad.labyrinth.R
import org.abanoubmilad.labyrinth.demo.tab0.Welcome
import org.abanoubmilad.labyrinth.demo.tab1.Leaderboard
import org.abanoubmilad.labyrinth.demo.tab2.Register

class ExampleMultiNavActivity : AppCompatActivity(), INavHolder {

    lateinit var labyrinth: Labyrinth
    override fun getINav() = labyrinth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_multi_nav_activity)

        labyrinth = Builder(
            viewModelStoreOwner = this,
            lifecycleOwner = this,
            fragmentManager = supportFragmentManager,

            fragmentContainerId = R.id.nav_host_container,
            bottomNavigationView = bottom_nav,

            rootTabFragmentsInitializer = listOf(
                { Welcome() },
                { Leaderboard() },
                { Register() }
            ),
            menuItemIdToRootTabFragmentIndexMap = hashMapOf(
                R.id.home to 0,
                R.id.list to 1,
                R.id.form to 2

            )).apply {
            defaultSelectedTabIndex = 1
            saveStateEnabled = true
            resetOnSameTabClickEnabled = false

        }.build()
    }


    override fun onDestroy() {
        labyrinth.onDestroy()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (labyrinth.shouldCallSuperOnBackPressed())
            super.onBackPressed()
    }

}
