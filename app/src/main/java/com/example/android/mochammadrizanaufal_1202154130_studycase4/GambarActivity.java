package com.example.android.mochammadrizanaufal_1202154130_studycase4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GambarActivity extends AppCompatActivity {
    //deklasi variable yang akan digunakan
    ImageView image;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
        setTitle("AsyncTask"); //set title aplikasi dengan nama

        //binding data
        image = (ImageView) findViewById(R.id.gambar);
        url = findViewById(R.id.img_url);
    }

    public void search(View view) { //method ketika klik tombol search
        //loading gambar dan mengambil gambar dari internet dan simpan ke image view
        Picasso.with(GambarActivity.this).load(url.getText().toString())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(image);
    }
}