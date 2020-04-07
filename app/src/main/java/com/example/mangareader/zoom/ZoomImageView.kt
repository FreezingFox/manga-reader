package com.example.mangareader.zoom

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import com.google.android.material.snackbar.Snackbar
import com.ortiz.touchview.TouchImageView


class ZoomImageView: TouchImageView {
    private lateinit var mDetector: GestureDetectorCompat
    private lateinit var _context: Context

    constructor(context: Context?) : super(context) {
        this.init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs, 0) {
        this.init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int)
            : super(context, attrs, defStyle) {
        this.init(context)
    }

    private fun init(context: Context?) {
        this.mDetector = GestureDetectorCompat(context, ZoomGestureListener(this))
        this._context = context!!

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
//        return if (this.mDetector.onTouchEvent(event))
//            true
//        else super.onTouchEvent(event)
        Toast.makeText(context, "hiii", Toast.LENGTH_SHORT).show()
        this.mDetector.onTouchEvent(event)
        this.performClick()
        return true
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }
}