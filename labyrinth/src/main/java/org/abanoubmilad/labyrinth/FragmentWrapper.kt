package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.fragment.app.Fragment

class FragmentWrapper<T : Fragment>(
    private val fragmentClass: Class<T>,
    private val bundle: Bundle?,
    private var fragment: T?
) {
    constructor(fragment: T) : this(fragment.javaClass, fragment.arguments, fragment)

    fun fetchFragment(): T? {
        if (fragment == null) {
            fragment = fragmentClass.newInstance()
            fragment?.arguments = bundle
        }
        return fragment
    }

    fun clearRetainedFragment() {
        fragment = null
    }
}