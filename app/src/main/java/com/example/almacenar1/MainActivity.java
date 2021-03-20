package com.example.almacenar1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText email;
    Button btn_Eject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.EditText);
        btn_Eject = findViewById(R.id.Button);

        SharedPreferences pf = getSharedPreferences("datos", Context.MODE_PRIVATE);
        email.setText(pf.getString("mail",""));
    }
    public void ejecutar(View v){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("mail", email.getText().toString());
        editor.commit();
        finish();
    }
}