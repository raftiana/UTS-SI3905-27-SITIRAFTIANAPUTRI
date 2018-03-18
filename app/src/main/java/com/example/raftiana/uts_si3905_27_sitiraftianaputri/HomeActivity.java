package com.example.raftiana.uts_si3905_27_sitiraftianaputri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    TextView mTahun, mNama;
    int mYear;
    int tahuna;
    String namae, tahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTahun = (TextView)findViewById(R.id.umur);
        mNama = (TextView)findViewById(R.id.nama);

        namae = getIntent().getStringExtra("nama");
        mNama.setText(namae);

        tahun = getIntent().getStringExtra("hutan");
        tahuna = Integer.parseInt(tahun);

        Calendar now =  Calendar.getInstance();
        mYear = now.get(Calendar.YEAR) - tahuna;
        mTahun.setText(String.valueOf(mYear));
    }
}

