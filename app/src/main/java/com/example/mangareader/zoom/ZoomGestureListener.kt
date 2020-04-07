package com.example.mangareader.zoom

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.google.android.material.snackbar.Snackbar

class ZoomGestureListener(view: View) :
    GestureDetector.OnGestureListener{
    private var _view: View = view

    override fun onShowPress(e: MotionEvent?) {}

    override fun onDown(e: MotionEvent?): Boolean {
        _view.measure(0, 0)
        val viewWidth = _view.measuredWidth
        val posX = e!!.x
        val message = if (posX < viewWidth / 2) "Is this what you wanted?" else "Was it worth it?"
        Snackbar.make(_view, message, Snackbar.LENGTH_SHORT).show()
        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
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

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        _view.measure(0, 0)
        val viewWidth = _view.measuredWidth
        val posX = e!!.x
        val message = if (posX < viewWidth / 2) "Is this what you wanted?" else "Was it worth it?"
        Snackbar.make(_view, message, Snackbar.LENGTH_SHORT).show()
        return true
    }
}