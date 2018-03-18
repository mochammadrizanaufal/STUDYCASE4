package com.example.android.mochammadrizanaufal_1202154130_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView list_maha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("AsyncTask"); //set Title dengan title AsyncTask
        list_maha = findViewById(R.id.list_mhs); //binding listView
    }

    public void start_sync(View view) {
        new getData(list_maha).execute(); //proses asynctask mulai dieksekusi
    }

    //subclass ketika asynctask
    class getData extends AsyncTask<String, Integer, String>{
        ListView list_maha;
        ArrayAdapter adapter;
        ArrayList<String> list_nama;
        ProgressDialog dialog;


        //constructor asynctask dijalankan
        public getData(ListView list_maha){
            this.list_maha = list_maha;
            dialog = new ProgressDialog(ListActivity.this);
            list_nama = new ArrayList<>();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //menampilkan proses dialog
            dialog.setTitle("Loading Data..");
            dialog.setIndeterminate(true);
            dialog.setProgress(0);
            dialog.setMax(100);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    getData.this.cancel(true);
                }
            });

            dialog.show();

        }


        @Override
        protected String doInBackground(String... strings) {
            adapter = new ArrayAdapter<>( ListActivity.this, android.R.layout.simple_list_item_1, list_nama); //membuat adapter

            //menyimpan data array ke variable
            String[] mhs = getResources().getStringArray(R.array.nama_mahasiswa);
            //perulangan untuk menyimpan array
            for (int a = 0; a < mhs.length; a++) {
                final long persen = 100L * a / mhs.length;
                final String nama = mhs[a];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            dialog.setMessage((int) persen+"% - Adding "+nama);
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    list_nama.add(mhs[a]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        //method yang dijalankan ketika asynctask sudah dijalankan
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            list_maha.setAdapter(adapter);
            dialog.dismiss();
        }

    }


}