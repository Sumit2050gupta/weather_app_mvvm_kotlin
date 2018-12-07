package kisan.com.fabproject;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView progress;
    private MainViewModel mainViewModel;
    private Button button;
    private ConstraintLayout errorView;
    private ConstraintLayout loadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        initView();



    }

    private void initView() {
        button = findViewById(R.id.button);
        errorView = findViewById(R.id.error);
        loadingView = findViewById(R.id.loading);
        progress = findViewById(R.id.imageView2);
        progress.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotation));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.retryButtonClick();
            }
        });
        setView();
    }

    private void setView() {
        mainViewModel.data.observe(this, new Observer<Resource>() {
            @Override
            public void onChanged(@Nullable Resource resource) {
                switch (resource.status){
                    case LOADING:
                        loadingView.setVisibility(View.VISIBLE);
                        errorView.setVisibility(View.GONE);
                        break;
                    case ERROR:
                        loadingView.setVisibility(View.GONE);
                        errorView.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtra("DATA",resource.data);
                        startActivity(intent);
                        finish();
                        break;
                 }
            }
        });
    }
}
