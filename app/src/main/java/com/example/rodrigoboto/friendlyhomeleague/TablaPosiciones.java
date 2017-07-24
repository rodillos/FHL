package com.example.rodrigoboto.friendlyhomeleague;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class TablaPosiciones extends AppCompatActivity {
    //TODO:crear ultima pantalla donde se muestren los primeros 3 puestos
    //esconder es la cantidad de jugadores que no van a jugar , es decir
    // 10- cantidad de jugadores es esconder, que por defecto es 6 TODO: traer cantidad de jugadores desde la primer activity
    Integer esconder = 6;
    TableRow jugador5, jugador6,jugador7,jugador8,jugador9,jugador10;
    TextView pJ1,pJ2,pJ3,pJ4,pJ5,pJ6,pJ7,
            pJ8,pJ9,pJ10,pG1, pE1, pP1, p1,pG2, pE2, pP2, p2,pG3, pE3, pP3, p3,pG4, pE4, pP4, p4,
            pG5, pE5, pP5, p5,pG6, pE6, pP6, p6,pG7, pE7, pP7, p7,pG8, pE8, pP8, p8,pG9, pE9, pP9,
            p9,pG10, pE10, pP10, p10, PTS1,PTS2,PTS3,PTS4,PTS5,PTS6,PTS7,PTS8,PTS9,PTS10;
    FloatingActionButton volver , finalizar;
    ArrayList<TextView> listaPJ = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPG = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPE = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPP = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPTS = new ArrayList<>(10);// en 0 esta lo correspondiente a 10 TODO:agregar Columna en XML

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_posiciones);
        asignarJugadoresVariables();
        esconderJugadorVariable(esconder);
        volver = (FloatingActionButton)findViewById(R.id.volver);//TODO: hacer que este boton me devuelva a la activity anterior AKA tabla encuentros
        finalizar = (FloatingActionButton)findViewById(R.id.finalizar);//TODO: hacer que este boton me lleve a una pantalla que se muestren los primeros 3
        asignarPartidos();

        Intent intentTabla = getIntent();
        Bundle bundle2 = intentTabla.getExtras();
        if (bundle2 != null){
            Integer cantidadJugadores = Integer.parseInt(bundle2.get("PARTICIPANTES").toString());
        }
    }

    private void asignarPartidos(){
        pJ1 = (TextView)findViewById(R.id.PJ1);
        pJ2 = (TextView)findViewById(R.id.PJ2);
        pJ3 = (TextView)findViewById(R.id.PJ3);
        pJ4 = (TextView)findViewById(R.id.PJ4);
        pJ5  = (TextView)findViewById(R.id.PJ5);
        pJ6  = (TextView)findViewById(R.id.PJ6);
        pJ7  = (TextView)findViewById(R.id.PJ7);
        pJ8  = (TextView)findViewById(R.id.PJ8);
        pJ9  = (TextView)findViewById(R.id.PJ9);
        pJ10  = (TextView)findViewById(R.id.PJ0);
        pG1 = (TextView)findViewById(R.id.PG1);
        pE1 = (TextView)findViewById(R.id.Pe1);
        pP1 = (TextView)findViewById(R.id.PP1);
        p1 = (TextView)findViewById(R.id.posicion1);
        pG2 = (TextView)findViewById(R.id.PG2);
        pE2 = (TextView)findViewById(R.id.Pe2);
        pP2 = (TextView)findViewById(R.id.PP2);
        p2 = (TextView)findViewById(R.id.posicion2);
        pG3   = (TextView)findViewById(R.id.PG3);
        pE3 = (TextView)findViewById(R.id.Pe3);
        pP3  = (TextView)findViewById(R.id.PP3);
        p3 = (TextView)findViewById(R.id.posicion3);
        pG4   = (TextView)findViewById(R.id.PG4);
        pE4  = (TextView)findViewById(R.id.Pe4);
        pP4 = (TextView)findViewById(R.id.PP4);
        p4 = (TextView)findViewById(R.id.posicion4);
        pG5  = (TextView)findViewById(R.id.PG5);
        pE5  = (TextView)findViewById(R.id.Pe5);
        pP5  = (TextView)findViewById(R.id.PP5);
        p5 = (TextView)findViewById(R.id.posicion5);
        pG6   = (TextView)findViewById(R.id.PG6);
        pE6  = (TextView)findViewById(R.id.Pe6);
        pP6  = (TextView)findViewById(R.id.PP6);
        p6 = (TextView)findViewById(R.id.posicion6);
        pG7   = (TextView)findViewById(R.id.PG7);
        pE7  = (TextView)findViewById(R.id.Pe7);
        pP7  = (TextView)findViewById(R.id.PP7);
        p7 = (TextView)findViewById(R.id.posicion7);
        pG8   = (TextView)findViewById(R.id.PG8);
        pE8  = (TextView)findViewById(R.id.Pe8);
        pP8  = (TextView)findViewById(R.id.PP8);
        p8 = (TextView)findViewById(R.id.posicion8);
        pG9   = (TextView)findViewById(R.id.PG9);
        pE9  = (TextView)findViewById(R.id.Pe9);
        pP9 = (TextView)findViewById(R.id.PP9);
        p9 = (TextView)findViewById(R.id.posicion9);
        pG10   = (TextView)findViewById(R.id.PG0);
        pE10  = (TextView)findViewById(R.id.Pe0);
        pP10  = (TextView)findViewById(R.id.PP0);
        p10= (TextView)findViewById(R.id.posicion0);
        listaPJ.addAll(Arrays.asList(pJ10,pJ1,pJ2,pJ3,pJ4,pJ5,pJ6,pJ7,pJ8,pJ9));
        listaPG.addAll(Arrays.asList(pG10,pG1,pG2,pG3,pG4,pG5,pG6,pG7,pG8,pG9));
        listaPE.addAll(Arrays.asList(pE10,pE1,pE2,pE3,pE4,pE5,pE6,pE7,pE8,pE9));
        listaPP.addAll(Arrays.asList(pP10,pP1,pP2,pP3,pP4,pP5,pP6,pP7,pP8,pP9));
        listaPTS.addAll(Arrays.asList(PTS10,PTS1,PTS2,PTS3,PTS4,PTS5,PTS6,PTS7,PTS8,PTS9));//TODO: hacer asignaciones de ID luego de crearlos en XML
    }

    private void asignarJugadoresVariables(){
        jugador5 = (TableRow)findViewById(R.id.fila5); //6

        jugador6 = (TableRow)findViewById(R.id.fila6); //5

        jugador7 = (TableRow)findViewById(R.id.fila7); //4

        jugador8 = (TableRow)findViewById(R.id.fila8); //3

        jugador9 = (TableRow)findViewById(R.id.fila9); //2

        jugador10 = (TableRow)findViewById(R.id.fila10); //1

    }

    private void esconderJugadorVariable(Integer esconder){
        if (esconder == 6)
            jugador5.setVisibility(View.GONE);
        else if (esconder == 5)
            jugador6.setVisibility(View.GONE);
        else if (esconder == 4)
            jugador7.setVisibility(View.GONE);
        else if (esconder == 3)
            jugador8.setVisibility(View.GONE);
        else if (esconder == 2)
            jugador9.setVisibility(View.GONE);
        else if (esconder == 1)
            jugador10.setVisibility(View.GONE);
        }


    }

