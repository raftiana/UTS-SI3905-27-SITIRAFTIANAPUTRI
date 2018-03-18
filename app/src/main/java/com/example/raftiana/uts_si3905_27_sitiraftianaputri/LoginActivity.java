package com.example.raftiana.uts_si3905_27_sitiraftianaputri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user, passwod;
    Button login;
    String abe, cde, amel, passi,taon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.email);
        passwod = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        amel = getIntent().getStringExtra("imel");
        passi = getIntent().getStringExtra("pass");
        taon = getIntent().getStringExtra("taun");

        user.setText(amel);
        passwod.setText(passi);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abe = user.getText().toString();
                cde = passwod.getText().toString();

                if (abe.equals(amel) && cde.equals(passi)){
                    Toast.makeText(LoginActivity.this, "mantab", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(LoginActivity.this, HomeActivity.class);
                    a.putExtra("hutan",taon);
                    a.putExtra("nama",amel);
                    startActivity(a);
                }else
                    Toast.makeText(LoginActivity.this, "salah", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
