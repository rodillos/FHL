package com.example.rodrigoboto.friendlyhomeleague;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TablaEncuentros extends AppCompatActivity implements View.OnClickListener {
    Integer cantidadJugadores;

    TextView Jugador1, Jugador2, Jugador3, Jugador4, Jugador5, Jugador6, Jugador7, Jugador8, Jugador9,
            Jugador10;

    ArrayList<TableRow> listaEncuentrosRow = new ArrayList<>(45);
    ArrayList<RadioGroup> listaEncuentrosRadio = new ArrayList<>(45);

    TableRow E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, E11, E12, E13, E14, E15, E16, E17, E18, E19, E20, E21, E22, E23, E24,
            E25, E26, E27, E28, E29, E30, E31, E32, E33, E34, E35, E36, E37, E38, E39, E40, E41, E42, E43, E44, E45;

    FloatingActionButton verTabla, volverAMain;

    RadioGroup RE1, RE2, RE3, RE4, RE5, RE6, RE7, RE8, RE9, RE10, RE11, RE12, RE13, RE14, RE15, RE16, RE17, RE18, RE19, RE20, RE21, RE22, RE23, RE24, RE25, RE26, RE27, RE28, RE29, RE30, RE31, RE32, RE33, RE34, RE35, RE36, RE37, RE38, RE39, RE40, RE41, RE42, RE43, RE44, RE45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_encuentros);
        asignarEncuentos();
        asignarRadioEncuentros();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String recibido = bundle.get("CANTIDAD").toString();
            cantidadJugadores = Integer.parseInt(recibido);
        }

        verTabla = (FloatingActionButton) findViewById(R.id.verTabla);
        verTabla.setOnClickListener(this);

        volverAMain = (FloatingActionButton) findViewById(R.id.volverAMain);
        volverAMain.setOnClickListener(this);

        esconderEncuentros(cantidadJugadores);
    }

   private void esconderEncuentros(Integer cantidadJugadores){
        switch (cantidadJugadores){
            case 4:
                esconderMaximoEncuentros();
            //TODO: implementa esconderPara5Jugadores, y asi cada uno implementa el siguiente para reciclcar codigo
                break;
            case 5:
                esconderPara5Jugadores();
                break;
            case 6:
                esconderPara6Jugadores();
                break;
            case 7:
                esconderPara7Jugadores();
                break;
            case 8:
                esconderPara8Jugadores();
                break;
            case 9:
                esconderPara9Jugadores();
                break;
            default: break;
        }
    }

    private void esconderMaximoEncuentros(){
        esconderPara5Jugadores();

        ArrayList<Integer>listaDeEncuentrosPara4 = new ArrayList<>(4);
        listaDeEncuentrosPara4.addAll(Arrays.asList(27,18,12,34));

        esconderRowDeLista(listaDeEncuentrosPara4);
    }



    private void esconderPara5Jugadores(){
        esconderPara6Jugadores();

        ArrayList<Integer>listaDeEncuentrosPara5 = new ArrayList<>(5);
        listaDeEncuentrosPara5.addAll(Arrays.asList(22,28,42,6,39));

        esconderRowDeLista(listaDeEncuentrosPara5);
    }

    private void esconderPara6Jugadores(){
        esconderPara7Jugadores();

        ArrayList<Integer>listaDeEncuentrosPara6 = new ArrayList<>(6);
        listaDeEncuentrosPara6.addAll(Arrays.asList(32,23,11,29,43,8));

        esconderRowDeLista(listaDeEncuentrosPara6);
    }

    private void esconderPara7Jugadores(){
        esconderPara8Jugadores();

        ArrayList<Integer>listaDeEncuentrosPara7 = new ArrayList<>(7);
        listaDeEncuentrosPara7.addAll(Arrays.asList(37,33,19,7,9,25,10));

        esconderRowDeLista(listaDeEncuentrosPara7);
    }

    private void esconderPara8Jugadores() {
        esconderPara9Jugadores();
        ArrayList<Integer> listaDeEncuentrosPara8 = new ArrayList<>(8);
        listaDeEncuentrosPara8.addAll(Arrays.asList(41,38,16,24,13,20,30,35));

        esconderRowDeLista(listaDeEncuentrosPara8);
    }

    private void esconderPara9Jugadores(){
        ArrayList<Integer> listaDeEncuentrosPara9 = new ArrayList<>(17);
        listaDeEncuentrosPara9.addAll(Arrays.asList(41,38,24,16,13,20,30,35,14,15,17,21,26,31,36,40,44));
        //Todos los casilleros son un valor menos para encontrarlos en la lista

        esconderRowDeLista(listaDeEncuentrosPara9);
    }

    private void esconderRowDeLista(ArrayList<Integer> lista){

        for(Integer contador = 0; contador <= lista.size(); contador++){

            Integer encuentro = lista.get(contador);

            TableRow rowDeJugadores = listaEncuentrosRow.get(encuentro);

            if (rowDeJugadores.isShown())
                rowDeJugadores.setVisibility(View.INVISIBLE);
        }
    }

    public void onClick(View v){
       switch (v.getId()){
           case R.id.verTabla:
               verTabla(v);
               break;
           default: break;
       }

    }

    private void asignarEncuentos(){
        E1 =  (TableRow) findViewById(R.id.e1);
        E2 =  (TableRow) findViewById(R.id.e2);
        E3 =  (TableRow) findViewById(R.id.e3);
        E4 =  (TableRow) findViewById(R.id.e4);
        E5 =  (TableRow) findViewById(R.id.e5);
        E6 =  (TableRow) findViewById(R.id.e6);
        E7 =  (TableRow) findViewById(R.id.e7);
        E8 =  (TableRow) findViewById(R.id.e8);
        E9 =  (TableRow) findViewById(R.id.e9);
        E10 = (TableRow) findViewById(R.id.e0);
        E11 = (TableRow) findViewById(R.id.e11);
        E12 = (TableRow) findViewById(R.id.e12);
        E13 = (TableRow) findViewById(R.id.e13);
        E14 = (TableRow) findViewById(R.id.e14);
        E15 = (TableRow) findViewById(R.id.e15);
        E16 = (TableRow) findViewById(R.id.e16);
        E17 = (TableRow) findViewById(R.id.e17);
        E18 = (TableRow) findViewById(R.id.e18);
        E19 = (TableRow) findViewById(R.id.e19);
        E20 = (TableRow) findViewById(R.id.e20);
        E21 = (TableRow) findViewById(R.id.e21);
        E22 = (TableRow) findViewById(R.id.e22);
        E23 = (TableRow) findViewById(R.id.e23);
        E24 = (TableRow) findViewById(R.id.e24);
        E25 = (TableRow) findViewById(R.id.e25);
        E26 = (TableRow) findViewById(R.id.e26);
        E27 = (TableRow) findViewById(R.id.e27);
        E28 = (TableRow) findViewById(R.id.e28);
        E29 = (TableRow) findViewById(R.id.e29);
        E30 = (TableRow) findViewById(R.id.e30);
        E31 = (TableRow) findViewById(R.id.e31);
        E32 = (TableRow) findViewById(R.id.e32);
        E33 = (TableRow) findViewById(R.id.e33);
        E34 = (TableRow) findViewById(R.id.e34);
        E35 = (TableRow) findViewById(R.id.e35);
        E36 = (TableRow) findViewById(R.id.e36);
        E37 = (TableRow) findViewById(R.id.e37);
        E38 = (TableRow) findViewById(R.id.e38);
        E39 = (TableRow) findViewById(R.id.e39);
        E40 = (TableRow) findViewById(R.id.e40);
        E41 = (TableRow) findViewById(R.id.e41);
        E42 = (TableRow) findViewById(R.id.e42);
        E43 = (TableRow) findViewById(R.id.e43);
        E44 = (TableRow) findViewById(R.id.e44);
        E45 = (TableRow) findViewById(R.id.e45);
        listaEncuentrosRow.addAll(Arrays.asList(E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,E11,E12,E13,E14,E15,
                E16,E17,E18,E19,E20,E21,E22,E23,E24,E25,E26,E27,E28,E29,E30,E31,E32,E33,E34,E35,E36,
                E37,E38,E39,E40,E41,E42,E43,E44,E45));
    }

    private void asignarRadioEncuentros(){
    RE1  = (RadioGroup)findViewById(R.id.encuentro1);
    RE2  = (RadioGroup)findViewById(R.id.encuentro2);
    RE3  = (RadioGroup)findViewById(R.id.encuentro3);
    RE4  = (RadioGroup)findViewById(R.id.encuentro4);
    RE5  = (RadioGroup)findViewById(R.id.encuentro5);
    RE6  = (RadioGroup)findViewById(R.id.encuentro6);
    RE7  = (RadioGroup)findViewById(R.id.encuentro7);
    RE8  = (RadioGroup)findViewById(R.id.encuentro8);
    RE9  = (RadioGroup)findViewById(R.id.encuentro9);
    RE10 = (RadioGroup)findViewById(R.id.encuentro0);
    RE11 = (RadioGroup)findViewById(R.id.encuentro11);
    RE12 = (RadioGroup)findViewById(R.id.encuentro12);
    RE13 = (RadioGroup)findViewById(R.id.encuentro13);
    RE14 = (RadioGroup)findViewById(R.id.encuentro14);
    RE15 = (RadioGroup)findViewById(R.id.encuentro15);
    RE16 = (RadioGroup)findViewById(R.id.encuentro16);
    RE17 = (RadioGroup)findViewById(R.id.encuentro17);
    RE18 = (RadioGroup)findViewById(R.id.encuentro18);
    RE19 = (RadioGroup)findViewById(R.id.encuentro19);
    RE20 = (RadioGroup)findViewById(R.id.encuentro20);
    RE21 = (RadioGroup)findViewById(R.id.encuentro21);
    RE22 = (RadioGroup)findViewById(R.id.encuentro22);
    RE23 = (RadioGroup)findViewById(R.id.encuentro23);
    RE24 = (RadioGroup)findViewById(R.id.encuentro24);
    RE25 = (RadioGroup)findViewById(R.id.encuentro25);
    RE26 = (RadioGroup)findViewById(R.id.encuentro26);
    RE27 = (RadioGroup)findViewById(R.id.encuentro27);
    RE28 = (RadioGroup)findViewById(R.id.encuentro28);
    RE29 = (RadioGroup)findViewById(R.id.encuentro29);
    RE30 = (RadioGroup)findViewById(R.id.encuentro30);
    RE31 = (RadioGroup)findViewById(R.id.encuentro31);
    RE32 = (RadioGroup)findViewById(R.id.encuentro32);
    RE33 = (RadioGroup)findViewById(R.id.encuentro33);
    RE34 = (RadioGroup)findViewById(R.id.encuentro34);
    RE35 = (RadioGroup)findViewById(R.id.encuentro35);
    RE36 = (RadioGroup)findViewById(R.id.encuentro36);
    RE37 = (RadioGroup)findViewById(R.id.encuentro37);
    RE38 = (RadioGroup)findViewById(R.id.encuentro38);
    RE39 = (RadioGroup)findViewById(R.id.encuentro39);
    RE40 = (RadioGroup)findViewById(R.id.encuentro40);
    RE41 = (RadioGroup)findViewById(R.id.encuentro41);
    RE42 = (RadioGroup)findViewById(R.id.encuentro42);
    RE43 = (RadioGroup)findViewById(R.id.encuentro43);
    RE44 = (RadioGroup)findViewById(R.id.encuentro44);
    RE45 = (RadioGroup)findViewById(R.id.encuentro45);
    listaEncuentrosRadio.addAll(Arrays.asList(RE1,RE2,RE3,RE4,RE5,RE6,RE7,RE8,RE9,RE10,RE11,RE12,RE13,RE14,RE15,
                RE16,RE17,RE18,RE19,RE20,RE21,RE22,RE23,RE24,RE25,RE26,RE27,RE28,RE29,RE30,RE31,RE32,RE33,RE34,RE35,RE36,
                RE37,RE38,RE39,RE40,RE41,RE42,RE43,RE44,RE45));
    }

    public void verTabla(View v){
        Intent intentTabla = new Intent(this, TablaPosiciones.class);

        intentTabla.putExtra("PARTICIPANTES", cantidadJugadores);

        startActivity(intentTabla);
    }

}
