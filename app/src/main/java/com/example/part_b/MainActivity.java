package com.example.part_b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import retrofit2.Call;
//import okhttp3.Call;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    /*
    private Button searchButton;
    private ProgressBar progressBar;
    private static final String BASE_URL="https://pixabay.com/api/";
    private static final String API_KEY="40137803-a043df52f2110266eb208471c";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton=findViewById(R.id.searchButton);
        progressBar=findViewById(R.id.progressBar);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();
                ImageService
            }
        });

    }
     */
    RecyclerView rvImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_images);
        rvImages=findViewById(R.id.rvImages);
        getImages();
    }

    private void getImages() {
        Call<List<ImageResult>> apiCall=RetrofitClient.getInstance().getApis().getImages();
        apiCall.enqueue(new Callback<List<ImageResult>>() {
            @Override
            public void onResponse(Call<List<ImageResult>> call, Response<List<ImageResult>> response) {
                List<ImageResult> imageResults = response.body();
                Toast.makeText(MainActivity.this, "Images", Toast.LENGTH_SHORT).show();
                setAdapter(imageResults);
            }

            @Override
            public void onFailure(Call<List<ImageResult>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setAdapter(List<ImageResult> imageResultList) {
        rvImages.setLayoutManager(new LinearLayoutManager(this));
        rvAdaptor rvAdaptor_1=new rvAdaptor(this,imageResultList);
        rvImages.setAdapter(rvAdaptor_1);
    }

}