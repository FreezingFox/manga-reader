package com.example.mangareader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareader.zoomphoto.ZoomPhotoView
import com.squareup.picasso.Picasso

class MangaReaderActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var chapterList: Array<Int> = Array<Int>(10) { i -> i }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_manga_reader)
        val view = findViewById<ZoomPhotoView>(R.id.readerImg)
        loadPageTo(view)

//        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
//            // use this setting to improve performance if you know that changes
//            // in content do not change the layout size of the RecyclerView
//            setHasFixedSize(false)
//
//            // use a linear layout manager
//            layoutManager = viewManager
//
//            // specify an viewAdapter (see also next example)
//            adapter = viewAdapter
//        }
    }

    private fun loadPageTo(view: ZoomPhotoView) {
        // this is a mock-up, have mercy
        Picasso
            .get()
            .load("https://pbs.twimg.com/media/EL-wkMoUEAAlNWY?format=jpg&name=900x900")
            .fit()
            .centerInside()
            .into(view)
    }
}
