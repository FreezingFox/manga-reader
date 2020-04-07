package com.example.mangareader.zoomphoto

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.google.android.material.snackbar.Snackbar

class ZoomPhotoGestureListener
    : GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    private var _view: View

    constructor(view: View) {
        this._view = view
    }

    override fun onShowPress(e: MotionEvent?) {}

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
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

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        Snackbar.make(_view, "onDoubleTap", Snackbar.LENGTH_SHORT).show()
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        Snackbar.make(_view, "onDoubleTapEvent", Snackbar.LENGTH_SHORT).show()
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        Snackbar.make(_view, "onSingleTapConfirmed", Snackbar.LENGTH_SHORT).show()
        return true
    }
}