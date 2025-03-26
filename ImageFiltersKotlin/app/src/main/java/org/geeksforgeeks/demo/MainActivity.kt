package org.geeksforgeeks.demo

import android.graphics.*
import android.opengl.GLSurfaceView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.mukesh.imageproccessing.*
import com.mukesh.imageproccessing.filters.*

class MainActivity : AppCompatActivity(), OnProcessingCompletionListener, OnFilterClickListener {
    private lateinit var result: Bitmap
    private var photoFilter: PhotoFilter? = null

    private lateinit var effectView: GLSurfaceView
    private lateinit var effectsRecyclerView: RecyclerView

    override fun onProcessingComplete(bitmap: Bitmap) {
        result = bitmap
    }

    override fun onFilterClicked(filters: Filters) {
        photoFilter?.applyEffect(
            BitmapFactory.decodeResource(resources, R.drawable.background), filters.filter
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        effectView = findViewById(R.id.effectView)
        effectsRecyclerView = findViewById(R.id.effectsRecyclerView)

        photoFilter = PhotoFilter(effectView, this)
        photoFilter?.applyEffect(
            BitmapFactory.decodeResource(resources, R.drawable.background),
            None()
        )
        effectsRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        effectsRecyclerView.setHasFixedSize(true)
        effectsRecyclerView.adapter = Adapter(getItems(), this)
    }

    private fun getItems(): MutableList<Filters> {
        return mutableListOf(
            Filters("None", None()),
            Filters("AutoFix", AutoFix()),
            Filters("Highlight", Highlight()),
            Filters("Brightness", Brightness()),
            Filters("Contrast", Contrast()),
            Filters("Cross Process", CrossProcess()),
            Filters("Documentary", Documentary()),
            Filters("Duo Tone", DuoTone()),
            Filters("Fill Light", FillLight()),
            Filters("Fisheye", FishEye()),
            Filters("Flip Horizontally", FlipHorizontally()),
            Filters("Flip Vertically", FlipVertically()),
            Filters("Grain", Grain()),
            Filters("Grayscale", Grayscale()),
            Filters("Lomoish", Lomoish()),
            Filters("Negative", Negative()),
            Filters("Posterize", Posterize()),
            Filters("Rotate", Rotate()),
            Filters("Saturate", Saturate()),
            Filters("Sepia", Sepia()),
            Filters("Sharpen", Sharpen()),
            Filters("Temperature", Temperature()),
            Filters("Tint", Tint()),
            Filters("Vignette", Vignette())
        )
    }
}