package com.example.mangareader.zoom

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.ortiz.touchview.TouchImageView


class ZoomImageView: TouchImageView {
    private lateinit var mDetector: GestureDetectorCompat

    constructor(context: Context?) : super(context) {
        this.init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs, 0) {
        this.init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int)
            : super(context, attrs, defStyle) {
        this.init()
    }

    private fun init() {
        this.mDetector = GestureDetectorCompat(this.context, ZoomGestureListener(this))
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }
}