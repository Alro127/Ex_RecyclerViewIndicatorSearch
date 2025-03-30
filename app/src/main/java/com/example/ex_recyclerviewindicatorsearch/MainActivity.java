package com.example.ex_recyclerviewindicatorsearch;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex_recyclerviewindicatorsearch.model.IconModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcIcon;
    List<IconModel> arrayList1;
    IconAdapter iconAdapter;
    androidx.appcompat.widget.SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcIcon = findViewById(R.id.rcIcon);

        arrayList1 = new ArrayList<>();
        arrayList1.add(new IconModel(R.drawable.icon1, "jfdjfjdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon3, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon4, "dfgfhvh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon5, "jfdjfjdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon6, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon7, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon8, "dfgfhvh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon9, "dfgfhvh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon1, "jfdjfjdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon3, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon4, "dfgfhvh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon5, "jfdjfjdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon6, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon7, "sddff sfsdf"));
        arrayList1.add(new IconModel(R.drawable.icon8, "dfgfhvh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon9, "dfgfhvh sxdff"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2,
                GridLayoutManager.HORIZONTAL, false);

        rcIcon.setLayoutManager(gridLayoutManager);
        iconAdapter = new IconAdapter(getApplicationContext(), arrayList1);
        rcIcon.setAdapter(iconAdapter);

        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration());

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query ) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        for (IconModel iconModel:arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                list.add(iconModel);
            }
        }
        if (list.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }
        else {
            iconAdapter.setListenerList(list);
        }
    }

}