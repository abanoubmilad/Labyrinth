/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*
import org.abanoubmilad.labyrinth.R

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        multinav.setOnClickListener {
            startActivity(Intent(this, ExampleMultiNavActivity::class.java))
        }
        nav.setOnClickListener {
            startActivity(Intent(this, ExampleSingleNavActivity::class.java))
        }
    }


}
