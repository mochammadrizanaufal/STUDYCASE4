package com.example.android.mochammadrizanaufal_1202154130_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button list, gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.btn_list);
        gambar = findViewById(R.id.btn_gambar);
        setTitle("AsyncTask");



    }

    public void list(View view) { //pindah ke activity list mahasiswa
        Intent intent = new Intent (MainActivity.this, ListActivity.class);
        startActivity(intent);
    }

    public void gambar(View view) { //pindah ke activity search image
        Intent intent = new Intent(MainActivity.this, GambarActivity.class);
        startActivity(intent);
    }
}