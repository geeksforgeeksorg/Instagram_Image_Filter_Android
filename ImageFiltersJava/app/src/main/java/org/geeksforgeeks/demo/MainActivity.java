package org.geeksforgeeks.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mukesh.imageproccessing.OnProcessingCompletionListener;
import com.mukesh.imageproccessing.PhotoFilter;
import com.mukesh.imageproccessing.filters.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnProcessingCompletionListener, OnFilterClickListener {

    private PhotoFilter photoFilter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        GLSurfaceView effectView = findViewById(R.id.effectView);
        RecyclerView effectsRecyclerView = findViewById(R.id.effectsRecyclerView);

        photoFilter = new PhotoFilter(effectView, this);
        photoFilter.applyEffect(
                BitmapFactory.decodeResource(getResources(), R.drawable.background),
                new None()
        );

        effectsRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        effectsRecyclerView.setHasFixedSize(true);
        effectsRecyclerView.setAdapter(new Adapter(getItems(), this));
    }

    private List<Filters> getItems() {
        List<Filters> filterList = new ArrayList<>();
        filterList.add(new Filters("None", new None()));
        filterList.add(new Filters("AutoFix", new AutoFix()));
        filterList.add(new Filters("Highlight", new Highlight()));
        filterList.add(new Filters("Brightness", new Brightness()));
        filterList.add(new Filters("Contrast", new Contrast()));
        filterList.add(new Filters("Cross Process", new CrossProcess()));
        filterList.add(new Filters("Documentary", new Documentary()));
        filterList.add(new Filters("Duo Tone", new DuoTone()));
        filterList.add(new Filters("Fill Light", new FillLight()));
        filterList.add(new Filters("Fisheye", new FishEye()));
        filterList.add(new Filters("Flip Horizontally", new FlipHorizontally()));
        filterList.add(new Filters("Flip Vertically", new FlipVertically()));
        filterList.add(new Filters("Grain", new Grain()));
        filterList.add(new Filters("Grayscale", new Grayscale()));
        filterList.add(new Filters("Lomoish", new Lomoish()));
        filterList.add(new Filters("Negative", new Negative()));
        filterList.add(new Filters("Posterize", new Posterize()));
        filterList.add(new Filters("Rotate", new Rotate()));
        filterList.add(new Filters("Saturate", new Saturate()));
        filterList.add(new Filters("Sepia", new Sepia()));
        filterList.add(new Filters("Sharpen", new Sharpen()));
        filterList.add(new Filters("Temperature", new Temperature()));
        filterList.add(new Filters("Tint", new Tint()));
        filterList.add(new Filters("Vignette", new Vignette()));

        return filterList;
    }

    @Override
    public void onProcessingComplete(@NonNull Bitmap bitmap) {
    }

    @Override
    public void onFilterClicked(Filters filters) {
        if (photoFilter != null) {
            photoFilter.applyEffect(
                    BitmapFactory.decodeResource(getResources(), R.drawable.background),
                    filters.getFilter()
            );
        }
    }
}