package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.fragment.app.Fragment

class FragmentWrapper<T : Fragment>(
    private val fragmentClass: Class<T>,
    private val bundle: Bundle?,
    private var fragment: T?
) {
    constructor(fragment: T) : this(fragment.javaClass, fragment.arguments, fragment)

    fun fetchFragment(): T {
        fragment?.let {
            return it
        }

        val created = fragmentClass.newInstance()
        created.arguments = bundle
        fragment = created

        return created
    }

    fun clearRetainedFragment() {
        fragment = null
    }
}