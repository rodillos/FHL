package com.example.rodrigoboto.friendlyhomeleague;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView contador;
    FloatingActionButton mas, menos, reset, crear;
    EditText edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9,edit10,edit11,edit12,edit13,edit14,edit15,edit16;
    Switch idaVuelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarBotones();
        contador =(TextView)findViewById(R.id.contador);
        asignadorEdit();
    }

    private void asignarBotones(){
        crear =(FloatingActionButton)findViewById(R.id.floatingActionButton4);
        mas =(FloatingActionButton)findViewById(R.id.floatingActionButton2);
        menos=(FloatingActionButton)findViewById(R.id.floatingActionButton3);
        reset =(FloatingActionButton)findViewById(R.id.floatingActionButton1);
    }

    private void asignadorEdit(){
        edit1 = (EditText)findViewById(R.id.editText5);
        edit2 = (EditText)findViewById(R.id.editText6);
        edit3 = (EditText)findViewById(R.id.editText7);
        edit4 = (EditText)findViewById(R.id.editText8);
        edit5 = (EditText)findViewById(R.id.editText9);
        edit6 = (EditText)findViewById(R.id.editText10);
        edit7 = (EditText)findViewById(R.id.editText11);
        edit8 = (EditText)findViewById(R.id.editText12);
        edit9 = (EditText)findViewById(R.id.editText13);
        edit10 = (EditText)findViewById(R.id.editText14);
        edit11 = (EditText)findViewById(R.id.editText15);
        edit12 = (EditText)findViewById(R.id.editText16);
        edit13 = (EditText)findViewById(R.id.editText17);
        edit14 = (EditText)findViewById(R.id.editText18);
        edit15 = (EditText)findViewById(R.id.editText19);
        edit16 = (EditText)findViewById(R.id.editText20);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton4:
                Toast.makeText(getApplicationContext(), R.string.crear, Toast.LENGTH_SHORT).show();
                break;
            case R.id.floatingActionButton1:
                Toast.makeText(getApplicationContext(), R.string.reset, Toast.LENGTH_SHORT).show();
                break;
            case R.id.floatingActionButton2:
                Toast.makeText(getApplicationContext(), R.string.agregar, Toast.LENGTH_SHORT).show();
                break;
            case R.id.floatingActionButton3:
                Toast.makeText(getApplicationContext(), R.string.remover, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
