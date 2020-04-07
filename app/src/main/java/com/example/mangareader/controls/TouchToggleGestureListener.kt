package com.example.mangareader.controls

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlin.math.abs

class TouchToggleGestureListener(view: View, orientation: String) :
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private var _view: View = view
    private var _orientation: String = orientation

    override fun onShowPress(e: MotionEvent?) {}
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        return false
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        val message = if (this._orientation == "left") "Is this what you wanted?" else "Was it worth it?"
        Snackbar.make(_view, message, Snackbar.LENGTH_SHORT).show()
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        // do not mess with this, it needs to be sent down to the zoomable image
        return false
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        // send to ZoomImageView
        val diffY = e2!!.y - e1!!.y
        val diffX = e2.x - e1.x
        if (abs(diffY) > abs(diffX)) {
            Snackbar.make(_view, "M-M-M-M-Menu", Snackbar.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {}
}