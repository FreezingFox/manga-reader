package com.example.mangareader.controls

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.GestureDetectorCompat
import com.example.mangareader.R


class TouchToggleView: View {
    private lateinit var mDetector: GestureDetectorCompat
    lateinit var _orientation: String

    constructor(context: Context?) : super(context) {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs, 0) {
        setOrientation(attrs)
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int)
            : super(context, attrs, defStyle) {
        setOrientation(attrs)
        init()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes) {
        setOrientation(attrs)
        init()
    }

    private fun init() {
        this.mDetector = GestureDetectorCompat(this.context, TouchToggleGestureListener(this, _orientation))
    }

    private fun setOrientation(attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TouchToggleView,
            0, 0).apply {

                try {
                    val tmp = getString(R.styleable.TouchToggleView_toggleDirection)
                    _orientation = tmp ?: "left"
                } finally {
                    recycle()
                }
            }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }
}