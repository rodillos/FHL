package com.example.rodrigoboto.friendlyhomeleague;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TablaEncuentros extends AppCompatActivity {
    Integer cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_encuentros);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            String recibido = bundle.get("CANTIDAD").toString();
            cantidad = Integer.parseInt(recibido);
        }
    }

}
