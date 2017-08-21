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
    TextView J1, J2, J3, J4, J5, J6, J7, J8, J9, J10;
    TableRow fila5, fila6, fila7, fila8, fila9, fila10;
    TextView pJ1, pJ2, pJ3, pJ4, pJ5, pJ6, pJ7,
            pJ8, pJ9, pJ10, pG1, pE1, pP1, p1, pG2, pE2, pP2, p2, pG3, pE3, pP3, p3, pG4, pE4, pP4, p4,
            pG5, pE5, pP5, p5, pG6, pE6, pP6, p6, pG7, pE7, pP7, p7, pG8, pE8, pP8, p8, pG9, pE9, pP9,
            p9, pG10, pE10, pP10, p10, PTS1, PTS2, PTS3, PTS4, PTS5, PTS6, PTS7, PTS8, PTS9, PTS10;

    jugadorDatos jugador1,jugador2,jugador3,jugador4,jugador5,jugador6,jugador7,jugador8,jugador9
            ,jugador10;

    ArrayList<Integer> partidos = new ArrayList<>(45);
    FloatingActionButton volver, finalizar;
    ArrayList<String> nombreJugadores = new ArrayList<>(10);
    ArrayList<TextView> listaPosiciones = new ArrayList<>();
    ArrayList<jugadorDatos> Jugadores = new ArrayList<>();
    ArrayList<TextView> listaPJ = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPG = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPE = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPP = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    ArrayList<TextView> listaPTS = new ArrayList<>(10);// en 0 esta lo correspondiente a 10
    //TODO modificar las asignaciones a array para que se agreguen en una posicion especifica, para asi no extender la lista mas a alla de su tamaño
    static class jugadorDatos {
        String nombre;
        Integer partidosJugados, partidosGanados,partidosEmpatados,partidosPerdidos, puntos, posicion;
        ArrayList<Integer> partidosLocal = new ArrayList<>();
        ArrayList<Integer> partidosVisitante = new ArrayList<>();

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public void setPartidosLocal(ArrayList<Integer> local){
            this.partidosLocal = local;
        }

        public ArrayList<Integer> getPartidosLocal(){
            return this.partidosLocal;
        }

        public void setPartidosVisitante(ArrayList<Integer> visitante){
            this.partidosVisitante = visitante;
        }

        public ArrayList<Integer> getPartidosvisitante(){
            return this.partidosVisitante;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_posiciones);
        asignarJugadoresVariables();
        esconderJugadorVariable(esconder);
        volver = (FloatingActionButton) findViewById(R.id.volver);//TODO: hacer que este boton me devuelva a la activity anterior AKA tabla encuentros
        finalizar = (FloatingActionButton) findViewById(R.id.finalizar);//TODO: hacer que este boton me lleve a una pantalla que se muestren los primeros 3

        Intent intentTabla = getIntent();
        Bundle bundle = intentTabla.getExtras();
        nombreJugadores = intentTabla.getStringArrayListExtra("NOMBRES");
        partidos = intentTabla.getIntegerArrayListExtra("PARTIDOS");

        if (bundle != null && !(nombreJugadores.isEmpty()) && !(partidos.isEmpty())) {
            Integer cantidadJugadores = Integer.parseInt(bundle.get("CANTIDAD").toString());
        }

        ArrayList<String> nombres = intentTabla.getStringArrayListExtra("NOMBRES");
        crearJugadores(nombres);
        calcularPuntos();
        calcularPosiciones();

    }

    //asigna todos los datos asocioados al jugador a una variable de clase jugadorDatos
    private void crearJugadores(ArrayList<String> listaNombres){

        asignarJugadores();
        asignarPartidos();
        asiganarNombres(listaNombres);
    }

    private void asignarJugadores() {
        J1 = (TextView) findViewById(R.id.jugador1);
        J2 = (TextView) findViewById(R.id.jugador2);
        J3 = (TextView) findViewById(R.id.jugador3);
        J4 = (TextView) findViewById(R.id.jugador4);
        J5 = (TextView) findViewById(R.id.jugador5);
        J6 = (TextView) findViewById(R.id.jugador6);
        J7 = (TextView) findViewById(R.id.jugador7);
        J8 = (TextView) findViewById(R.id.jugador8);
        J9 = (TextView) findViewById(R.id.jugador9);
        J10 = (TextView) findViewById(R.id.jugador10);
    }

    //calcula las posiciones de los jugadores de acuerdo a los puntos de cada uno
    private void calcularPosiciones(){

        String auxiliar, auxiliar2;
        
        for(int i=1;i < Jugadores.size();i++){
            for (int j=0 ; j < Jugadores.size() - 1; j++){
                Integer puntosJugador1 = Integer.parseInt(Jugadores.get(j).puntos.toString());
                Integer puntosJugador2 = Integer.parseInt(Jugadores.get(j+1).puntos.toString());
                if ( puntosJugador1 < puntosJugador2){
                    auxiliar = Jugadores.get(j).posicion.toString();
                    auxiliar2 = Jugadores.get(j+1).posicion.toString();
                    Jugadores.get(j).posicion = Integer.parseInt(auxiliar2);
                    Jugadores.get(j+1).posicion = Integer.parseInt(auxiliar);
                    }
                }
            }
        }

    //TODO esto deberia ya estar asignado desde la primer activity e irse pasando entre todas
    private void asiganarNombres(ArrayList<String> lista) {

        for (Integer i = 0; i < lista.size(); i++)
            Jugadores.get(i).nombre  = lista.get(i).toString();

    }

    //calcula los puntos para TODOS los jugadores
    private void calcularPuntos() {

        for(Integer i = 0; i> 10; i++)
            calcularPuntosJugador(Jugadores.get(i));

    }

    //Calcula los puntos para cada jugador
    private void calcularPuntosJugador(jugadorDatos jugador){

        Integer puntos;

        puntos = Integer.parseInt(jugador.partidosGanados.toString()) * 3;

        puntos += Integer.parseInt(jugador.partidosEmpatados.toString());

        jugador.puntos = Integer.parseInt(puntos.toString());
    }

    //asigna las ids de los partidos (jugados,ganados,empatados y perdidos), puntos, y posiciones
    private void asignarPartidos() {

        pJ1 = (TextView) findViewById(R.id.PJ1);
        pJ2 = (TextView) findViewById(R.id.PJ2);
        pJ3 = (TextView) findViewById(R.id.PJ3);
        pJ4 = (TextView) findViewById(R.id.PJ4);
        pJ5 = (TextView) findViewById(R.id.PJ5);
        pJ6 = (TextView) findViewById(R.id.PJ6);
        pJ7 = (TextView) findViewById(R.id.PJ7);
        pJ8 = (TextView) findViewById(R.id.PJ8);
        pJ9 = (TextView) findViewById(R.id.PJ9);
        pJ10 = (TextView) findViewById(R.id.PJ0);
        pG1 = (TextView) findViewById(R.id.PG1);
        pE1 = (TextView) findViewById(R.id.Pe1);
        pP1 = (TextView) findViewById(R.id.PP1);
        p1 = (TextView) findViewById(R.id.posicion1);
        PTS1 = (TextView) findViewById(R.id.Pts1);
        pG2 = (TextView) findViewById(R.id.PG2);
        pE2 = (TextView) findViewById(R.id.Pe2);
        pP2 = (TextView) findViewById(R.id.PP2);
        p2 = (TextView) findViewById(R.id.posicion2);
        PTS2 = (TextView) findViewById(R.id.Pts2);
        pG3 = (TextView) findViewById(R.id.PG3);
        pE3 = (TextView) findViewById(R.id.Pe3);
        pP3 = (TextView) findViewById(R.id.PP3);
        p3 = (TextView) findViewById(R.id.posicion3);
        PTS3 = (TextView) findViewById(R.id.Pts3);
        pG4 = (TextView) findViewById(R.id.PG4);
        pE4 = (TextView) findViewById(R.id.Pe4);
        pP4 = (TextView) findViewById(R.id.PP4);
        p4 = (TextView) findViewById(R.id.posicion4);
        PTS4 = (TextView) findViewById(R.id.Pts4);
        pG5 = (TextView) findViewById(R.id.PG5);
        pE5 = (TextView) findViewById(R.id.Pe5);
        pP5 = (TextView) findViewById(R.id.PP5);
        p5 = (TextView) findViewById(R.id.posicion5);
        PTS5 = (TextView) findViewById(R.id.Pts5);
        pG6 = (TextView) findViewById(R.id.PG6);
        pE6 = (TextView) findViewById(R.id.Pe6);
        pP6 = (TextView) findViewById(R.id.PP6);
        p6 = (TextView) findViewById(R.id.posicion6);
        PTS6 = (TextView) findViewById(R.id.Pts6);
        pG7 = (TextView) findViewById(R.id.PG7);
        pE7 = (TextView) findViewById(R.id.Pe7);
        pP7 = (TextView) findViewById(R.id.PP7);
        p7 = (TextView) findViewById(R.id.posicion7);
        PTS7 = (TextView) findViewById(R.id.Pts7);
        pG8 = (TextView) findViewById(R.id.PG8);
        pE8 = (TextView) findViewById(R.id.Pe8);
        pP8 = (TextView) findViewById(R.id.PP8);
        p8 = (TextView) findViewById(R.id.posicion8);
        PTS8 = (TextView) findViewById(R.id.Pts8);
        pG9 = (TextView) findViewById(R.id.PG9);
        pE9 = (TextView) findViewById(R.id.Pe9);
        pP9 = (TextView) findViewById(R.id.PP9);
        p9 = (TextView) findViewById(R.id.posicion9);
        PTS9 = (TextView) findViewById(R.id.Pts9);
        pG10 = (TextView) findViewById(R.id.PG0);
        pE10 = (TextView) findViewById(R.id.Pe0);
        pP10 = (TextView) findViewById(R.id.PP0);
        p10 = (TextView) findViewById(R.id.posicion0);
        PTS10 = (TextView) findViewById(R.id.Pts10);
        listaPosiciones.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
        listaPJ.addAll(Arrays.asList(pJ10, pJ1, pJ2, pJ3, pJ4, pJ5, pJ6, pJ7, pJ8, pJ9));
        listaPG.addAll(Arrays.asList(pG10, pG1, pG2, pG3, pG4, pG5, pG6, pG7, pG8, pG9));
        listaPE.addAll(Arrays.asList(pE10, pE1, pE2, pE3, pE4, pE5, pE6, pE7, pE8, pE9));
        listaPP.addAll(Arrays.asList(pP10, pP1, pP2, pP3, pP4, pP5, pP6, pP7, pP8, pP9));
        listaPTS.addAll(Arrays.asList(PTS10, PTS1, PTS2, PTS3, PTS4, PTS5, PTS6, PTS7, PTS8, PTS9));
    }

    //asigna las filas que pueden ocultarse
    private void asignarJugadoresVariables() {
        fila5 = (TableRow) findViewById(R.id.fila5); //6

        fila6 = (TableRow) findViewById(R.id.fila6); //5

        fila7 = (TableRow) findViewById(R.id.fila7); //4

        fila8 = (TableRow) findViewById(R.id.fila8); //3

        fila9 = (TableRow) findViewById(R.id.fila9); //2

        fila10 = (TableRow) findViewById(R.id.fila10); //1

    }

    //esconde dependiendo la cantidad de 'esconder'
    private void esconderJugadorVariable(Integer esconder) {
        if (esconder == 6)
            fila5.setVisibility(View.GONE);
        else if (esconder == 5)
            fila6.setVisibility(View.GONE);
        else if (esconder == 4)
            fila7.setVisibility(View.GONE);
        else if (esconder == 3)
            fila8.setVisibility(View.GONE);
        else if (esconder == 2)
            fila9.setVisibility(View.GONE);
        else if (esconder == 1)
            fila10.setVisibility(View.GONE);
    }

    //For que implementa definirResultadosPorJugador a todos los Jugadores
    private void definirResultadoPartidos(){

        for (Integer i = 0; i > Jugadores.size(); i++)
            definirResultadosPorJugador(Jugadores.get(i));
    }

    private void definirResultadosPorJugador(jugadorDatos jugador){

        ArrayList<Integer> listita = jugador.getPartidosLocal();
        //for (Integer i = 0; i < listita.size(); i++);
            //no se que hacer si que venga ya el resultado de los partidos desde la anterior activity
            // o se deberia calcular acá, ahora  es muy tarde, mañana u hoy a la ncohe, lo pensamos bien
            //para calcular aca se deberia tener accseso a la lista con los radio group y con el
        // switch preguntar si es 1,2 o 3 para asi saber si GEP .

    }
}

