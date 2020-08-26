/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/19/20 1:49 PM
 *  * Last modified 5/1/20 11:06 PM
 *
 */

package org.abanoubmilad.labyrinth

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 5/1/20 11:05 PM
 *  * Last modified 5/1/20 11:05 PM
 *
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        // Observe the internal MutableLiveData
        super.observe(owner, Observer { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    fun call() {
        value = null
    }
}