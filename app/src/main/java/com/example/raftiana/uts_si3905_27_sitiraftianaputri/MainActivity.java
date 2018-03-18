package com.example.raftiana.uts_si3905_27_sitiraftianaputri;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText mEmail, mPassword, mTanggal, mTahun;
    Button mNext;
    String mSpinnerBulan;
    private static final String TAG_ACTIVITY = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mTanggal = (EditText) findViewById(R.id.tanggal);
        mTahun = (EditText) findViewById(R.id.tahun);
        mNext = (Button) findViewById(R.id.signup);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
                // Set the dialog title.
                myAlertBuilder.setTitle("Alert");
                // Set the dialog message.
                myAlertBuilder.setMessage("Yakin data yang dimasukkan sudah benar?");

                // Add the buttons.
                myAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        String email = mEmail.getText().toString();
                        String pass = mPassword.getText().toString();
                        String taun = mTahun.getText().toString();
                        i.putExtra("imel", email);
                        i.putExtra("pass", pass);
                        i.putExtra("taun", taun);
                        startActivity(i);
                    }
                });
                // Add the buttons.
                myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                        Toast.makeText(getApplicationContext(), "Pressed Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                // Create and show the AlertDialog.
                myAlertBuilder.show();
            }
        });

        Spinner spinnerBulan = (Spinner) findViewById(R.id.bulan);
        if (spinnerBulan != null) {
            spinnerBulan.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapterBulan = ArrayAdapter.createFromResource(this,
                R.array.array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapterBulan.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinnerBulan != null) {
            spinnerBulan.setAdapter(adapterBulan);
        }
    }

        public void onRadioButtonClicked(View view) {
            switch (view.getId()) {
                case R.id.pria:
                    Toast.makeText(this, "Pria dipilih", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.wanita:
                    Toast.makeText(this, "wanita dipilih", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerBulan = adapterView.getItemAtPosition(i).toString();
        String showString = mSpinnerBulan;
        Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
    }
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG_ACTIVITY,"ga ada yang dipilih");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
