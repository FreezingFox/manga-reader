package com.example.mangareader.controls

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.google.android.material.snackbar.Snackbar

class TouchToggleGestureListener(view: View, orientation: String) : GestureDetector.OnGestureListener {
    private var _view: View = view
    private var _orientation: String = orientation

    override fun onShowPress(e: MotionEvent?) {}

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        Snackbar.make(_view, "What are you doing senpai?", Snackbar.LENGTH_SHORT).show()
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        val message = if (this._orientation == "left") "Is this what you wanted?" else "Was it worth it?"
        Snackbar.make(_view, message, Snackbar.LENGTH_SHORT).show()
        return false
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        // send to ZoomImageView
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