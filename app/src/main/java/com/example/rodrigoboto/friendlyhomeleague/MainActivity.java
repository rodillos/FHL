package com.example.rodrigoboto.friendlyhomeleague;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView contador;
    FloatingActionButton mas, menos, reset, crear;
    EditText edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9,edit10;
    ArrayList<EditText> listaCampos = new ArrayList<>(10);
    Integer valorContador = 4;
    Integer valorMax = 10, valorMin = 4;

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
        crear.setOnClickListener(this);
        mas =(FloatingActionButton)findViewById(R.id.floatingActionButton2);
        mas.setOnClickListener(this);
        menos=(FloatingActionButton)findViewById(R.id.floatingActionButton3);
        menos.setOnClickListener(this);
        reset =(FloatingActionButton)findViewById(R.id.floatingActionButton1);
        reset.setOnClickListener(this);

    }

    private void asignadorEdit(){
        edit1 = (EditText)findViewById(R.id.editText1);
        listaCampos.add(edit1);
        edit2 = (EditText)findViewById(R.id.editText2);
        listaCampos.add(edit2);
        edit3 = (EditText)findViewById(R.id.editText3);
        listaCampos.add(edit3);
        edit4 = (EditText)findViewById(R.id.editText4);
        listaCampos.add(edit4);
        edit5 = (EditText)findViewById(R.id.editText5);
        listaCampos.add(edit5);
        edit6 = (EditText)findViewById(R.id.editText6);
        listaCampos.add(edit6);
        edit7 = (EditText)findViewById(R.id.editText7);
        listaCampos.add(edit7);
        edit8 = (EditText)findViewById(R.id.editText8);
        listaCampos.add(edit8);
        edit9 = (EditText)findViewById(R.id.editText9);
        listaCampos.add(edit9);
        edit10 = (EditText)findViewById(R.id.editText10);
        listaCampos.add(edit10);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton4:
                Toast.makeText(getApplicationContext(), R.string.crear, Toast.LENGTH_SHORT).show();
                generarTorneo(v);
                break;
            case R.id.floatingActionButton1:
                Toast.makeText(getApplicationContext(), R.string.reset, Toast.LENGTH_SHORT).show();
                break;
            case R.id.floatingActionButton2:
                valorContador++;
                controlarValores();
                mostrarOculatarCampo(1);
                contador.setText(valorContador.toString());
                break;
            case R.id.floatingActionButton3:
                valorContador--;
                controlarValores();
                mostrarOculatarCampo(2);
                break;
        }
    }

    private void controlarValores() {
        if (valorContador < valorMin) {
            contador.setText(valorMin.toString());
            valorContador = valorMin;
            Toast.makeText(getApplicationContext(), R.string.min, Toast.LENGTH_SHORT).show();
        }else if (valorContador > valorMax){
            contador.setText(valorMax.toString());
            valorContador = valorMax;
           Toast.makeText(getApplicationContext(), R.string.max, Toast.LENGTH_SHORT).show();
        }else{
            contador.setText(valorContador.toString());
        }
    }

    private void mostrarOculatarCampo(Integer valor){
        switch (valor) {
            case 1:
                listaCampos.get(valorContador -1).setVisibility(View.VISIBLE);
                break;
            case 2:
                listaCampos.get(valorContador -1).setVisibility(View.GONE);
                break;
        }
    }

    public void generarTorneo(View v){

        Intent intent = new Intent(this , TablaEncuentros.class);
        String cantidadJugadores = contador.getText().toString();
        intent.putExtra("CANTIDAD", cantidadJugadores);
        startActivity(intent);
    }
}
