package com.example.mangareader.zoom

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.example.mangareader.R
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class ZoomGestureListener(view: View) : GestureDetector.OnGestureListener {
    private var _view: View = view

    override fun onShowPress(e: MotionEvent?) {}

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        val view = _view.findViewById<ZoomImageView>(R.id.readerImg)
        loadPage(view)
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent?) {}

    private fun loadPage(view: ZoomImageView) {
        // this is a mock-up, have mercy
        Picasso
            .get()
            .load("https://pbs.twimg.com/media/EMok3CSU4AE7osn?format=jpg&name=large")
            .fit()
            .centerInside()
            .into(view)
    }
}