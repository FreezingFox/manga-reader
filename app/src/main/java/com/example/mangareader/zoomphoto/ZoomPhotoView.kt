package com.example.mangareader.zoomphoto

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.github.chrisbanes.photoview.PhotoView

class ZoomPhotoView: PhotoView {
    private var _detector: GestureDetectorCompat

    init {
        _detector = GestureDetectorCompat(this.context, ZoomPhotoGestureListener(this))
    }

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attr: AttributeSet) : super(context, attr, 0)
    constructor(context: Context, attr: AttributeSet, defStyle: Int) : super(context, attr, defStyle)

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (_detector.onTouchEvent(event))
            return true
        return super.dispatchTouchEvent(event)
    }

}