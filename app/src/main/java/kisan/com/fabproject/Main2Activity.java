package kisan.com.fabproject;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Main2ViewModel main2ViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        main2ViewModel = ViewModelProviders.of(this).get(Main2ViewModel.class);
        init();
        main2ViewModel.setIntent(getIntent());
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_view);

        setRecyclerView();
    }

    private void setRecyclerView() {
        main2ViewModel.recycleList.observe(this, new Observer<List<ForcastModel>>() {
            @Override
            public void onChanged(@Nullable List<ForcastModel> forcastModels) {
                ForcastAdapter adapter = new ForcastAdapter(forcastModels);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Main2Activity.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
