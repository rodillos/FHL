package com.example.rodrigoboto.friendlyhomeleague;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class TablaEncuentros extends AppCompatActivity implements View.OnClickListener {

    Integer cantidadJugadores;
    ArrayList<Integer> partidosFinal = new ArrayList<>(45);
    ArrayList<RadioButton> partidosLocal = new ArrayList<>(45);
    ArrayList<RadioButton> partidosEmpate = new ArrayList<>(45);
    ArrayList<RadioButton> partidosVisitante = new ArrayList<>(45);

    ArrayList<TextView> Jugador1, Jugador2, Jugador3, Jugador4, Jugador5, Jugador6, Jugador7,
            Jugador8, Jugador9, Jugador10;
    ArrayList<ArrayList<TextView>> listaJugadores = new ArrayList<>(10);
    ArrayList<TableRow> listaEncuentrosRow = new ArrayList<>();
    ArrayList<RadioGroup> listaEncuentrosRadio = new ArrayList<>();
    ArrayList<String> listaDeNombres = new ArrayList<>(10);
    ArrayList<Integer> partidosGanados = new ArrayList<>(10);

    TableRow E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, E11, E12, E13, E14, E15, E16, E17, E18, E19, E20, E21, E22, E23, E24,
            E25, E26, E27, E28, E29, E30, E31, E32, E33, E34, E35, E36, E37, E38, E39, E40, E41, E42, E43, E44, E45;

    FloatingActionButton verTabla, volverAMain;

    RadioGroup RE1, RE2, RE3, RE4, RE5, RE6, RE7, RE8, RE9, RE10, RE11, RE12, RE13, RE14, RE15, RE16, RE17, RE18, RE19, RE20, RE21, RE22, RE23, RE24, RE25, RE26, RE27, RE28, RE29, RE30, RE31, RE32, RE33, RE34, RE35, RE36, RE37, RE38, RE39, RE40, RE41, RE42, RE43, RE44, RE45;
    //TODOS LOS BOTONES QUE SON LOCALES
    RadioButton RBL1, RBL2, RBL3, RBL4, RBL5, RBL6, RBL7, RBL8, RBL9, RBL10, RBL11, RBL12, RBL13, RBL14, RBL15, RBL16, RBL17, RBL18, RBL19, RBL20, RBL21, RBL22, RBL23, RBL24, RBL25, RBL26, RBL27, RBL28, RBL29, RBL30, RBL31, RBL32, RBL33, RBL34, RBL35, RBL36, RBL37, RBL38, RBL39, RBL40, RBL41, RBL42, RBL43, RBL44, RBL45;
    //TODOS LOS BOTONES QUE SON EMPATE
    RadioButton RBE1, RBE2, RBE3, RBE4, RBE5, RBE6, RBE7, RBE8, RBE9, RBE10, RBE11, RBE12, RBE13, RBE14, RBE15, RBE16, RBE17, RBE18, RBE19, RBE20, RBE21, RBE22, RBE23, RBE24, RBE25, RBE26, RBE27, RBE28, RBE29, RBE30, RBE31, RBE32, RBE33, RBE34, RBE35, RBE36, RBE37, RBE38, RBE39, RBE40, RBE41, RBE42, RBE43, RBE44, RBE45;
    //TODOS LOS BOTONES QUE SON VISITANTE
    RadioButton RBV1, RBV2, RBV3, RBV4, RBV5, RBV6, RBV7, RBV8, RBV9, RBV10, RBV11, RBV12, RBV13, RBV14, RBV15, RBV16, RBV17, RBV18, RBV19, RBV20,
            RBV21, RBV22, RBV23, RBV24, RBV25, RBV26, RBV27, RBV28, RBV29, RBV30, RBV31, RBV32, RBV33, RBV34, RBV35, RBV36, RBV37, RBV38, RBV39, RBV40, RBV41, RBV42, RBV43, RBV44, RBV45;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_encuentros);
        asignarEncuentos();
        asignarRadioEncuentros();
        asignarRadioLocal();
        asignarRadioEmpate();
        asignarRadioVisitante();
        asignarJugadores();
        partidosGanados.addAll(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        Intent intent = getIntent();
        Bundle cantidad = intent.getExtras();

        listaDeNombres = intent.getStringArrayListExtra("NOMBRES");

        if (cantidad != null && listaDeNombres != null) {
            String recibido = cantidad.getString("CANTIDAD");
            cantidadJugadores = Integer.parseInt(recibido);
        }

        verTabla = (FloatingActionButton) findViewById(R.id.verTabla);
        verTabla.setOnClickListener(this);

        volverAMain = (FloatingActionButton) findViewById(R.id.volverAMain);
        volverAMain.setOnClickListener(this);

        esconderEncuentros(cantidadJugadores);
        acoplarNombres(listaDeNombres);

        verTabla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pasarAPosiciones(view);
            }
        });

    }

    //Asigna todas las IDs correspondientes a cada jugador a una lista identificadora
    private void asignarJugadores() {
        asignarJugador1();
        asignarJugador2();
        asignarJugador3();
        asignarJugador4();
        asignarJugador5();
        asignarJugador6();
        asignarJugador7();
        asignarJugador8();
        asignarJugador9();
        asignarJugador10();
        listaJugadores.addAll(Arrays.asList(Jugador1, Jugador2, Jugador3, Jugador4, Jugador5, Jugador6, Jugador7, Jugador8, Jugador9, Jugador10));

    }

    private void asignarJugador1() {
        Jugador1 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador1);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador11);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador12);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador13);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador14);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador15);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador16);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador17);
        Jugador1.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador18);
        Jugador1.add(jugador);
    }

    private void asignarJugador2() {
        Jugador2 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador2);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador21);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador22);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador23);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador24);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador25);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador26);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador27);
        Jugador2.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador28);
        Jugador2.add(jugador);
    }

    private void asignarJugador3() {
        Jugador3 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador3);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador31);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador32);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador33);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador34);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador35);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador36);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador37);
        Jugador3.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador38);
        Jugador3.add(jugador);
    }

    private void asignarJugador4() {
        Jugador4 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador4);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador41);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador42);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador43);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador44);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador45);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador46);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador47);
        Jugador4.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador48);
        Jugador4.add(jugador);
    }

    private void asignarJugador5() {
        Jugador5 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador5);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador51);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador52);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador53);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador54);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador55);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador56);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador57);
        Jugador5.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador58);
        Jugador5.add(jugador);
    }

    private void asignarJugador6() {
        Jugador6 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador6);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador61);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador62);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador63);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador64);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador65);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador66);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador67);
        Jugador6.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador68);
        Jugador6.add(jugador);
    }

    private void asignarJugador7() {
        Jugador7 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador7);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador71);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador72);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador73);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador74);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador75);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador76);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador77);
        Jugador7.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador78);
        Jugador7.add(jugador);
    }

    private void asignarJugador8() {
        Jugador8 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador8);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador81);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador82);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador83);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador84);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador85);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador86);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador87);
        Jugador8.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador88);
        Jugador8.add(jugador);
    }

    private void asignarJugador9() {
        Jugador9 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador9);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador91);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador92);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador93);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador94);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador95);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador96);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador97);
        Jugador9.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador98);
        Jugador9.add(jugador);
    }

    private void asignarJugador10() {
        Jugador10 = new ArrayList<>();
        TextView jugador = (TextView) findViewById(R.id.jugador10);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador101);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador102);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador103);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador104);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador105);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador106);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador107);
        Jugador10.add(jugador);
        jugador = (TextView) findViewById(R.id.jugador108);
        Jugador10.add(jugador);
    }

    //selelctor que dependiendo la cantidad de jugadores (obtenida por parametro) ejecuta esconderpara...
    private void esconderEncuentros(Integer cantidadJugadores) {
        switch (cantidadJugadores) {
            case 4:
                esconderMaximoEncuentros();
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
            default:
                break;
        }
    }

    //contiene las filas que se deben ocultar si hay 6 jugadores, ejecutando el de 9 , 8 , 7, 6 y 5
    private void esconderMaximoEncuentros() {
        esconderPara5Jugadores();

        ArrayList<Integer> listaDeEncuentrosPara4 = new ArrayList<>(Arrays.asList(27, 18, 12, 34));

        esconderRowDeLista(listaDeEncuentrosPara4);
    }

    //contiene las filas que se deben ocultar si hay 5 jugadores, ejecutando el de 9 , 8 , 7 y 6
    private void esconderPara5Jugadores() {
        esconderPara6Jugadores();

        ArrayList<Integer> listaDeEncuentrosPara5 = new ArrayList<>(Arrays.asList(22, 28, 42, 6, 39));

        esconderRowDeLista(listaDeEncuentrosPara5);
    }

    //contiene las filas que se deben ocultar si hay 6 jugadores, ejecutando el de 9 , 8 y 7
    private void esconderPara6Jugadores() {
        esconderPara7Jugadores();

        ArrayList<Integer> listaDeEncuentrosPara6 = new ArrayList<>(Arrays.asList(32, 23, 11, 29, 43, 8));

        esconderRowDeLista(listaDeEncuentrosPara6);
    }

    //contiene las filas que se deben ocultar si hay 7 jugadores, ejecutando el de 9 y 8
    private void esconderPara7Jugadores() {
        esconderPara8Jugadores();

        ArrayList<Integer> listaDeEncuentrosPara7 = new ArrayList<>((Arrays.asList(37, 33, 19, 7, 9, 25, 10)));

        esconderRowDeLista(listaDeEncuentrosPara7);
    }

    //contiene las filas que se deben ocultar si hay 8 jugadores, ejecutando el de 9
    private void esconderPara8Jugadores() {
        esconderPara9Jugadores();

        ArrayList<Integer> listaDeEncuentrosPara8 = new ArrayList<>(Arrays.asList(41, 38, 16, 24, 13, 20, 30, 35));

        esconderRowDeLista(listaDeEncuentrosPara8);
    }

    //contiene las filas que se deben ocultar si hay 9 jugadores
    private void esconderPara9Jugadores() {
        ArrayList<Integer> listaDeEncuentrosPara9 = new ArrayList<>(Arrays.asList(41, 38, 24, 16, 13, 20, 30, 35, 14, 15, 17, 21, 26, 31, 36, 40, 44));

        esconderRowDeLista(listaDeEncuentrosPara9);
    }

    //esconde las filas (correspondientes los encuentros) que se les pasan por parametro
    private void esconderRowDeLista(ArrayList<Integer> lista) {

        for (Integer contador = 0; contador < lista.size(); contador++) {

            Integer encuentro = lista.get(contador);

            TableRow rowDeJugadores = listaEncuentrosRow.get(encuentro);

            rowDeJugadores.setVisibility(View.GONE);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.verTabla:
                verTabla(v);
                break;
            default:
                break;
        }

    }

    //generamos listaEncuentrosRow
    private void asignarEncuentos() {
        E1 = (TableRow) findViewById(R.id.e1);
        E2 = (TableRow) findViewById(R.id.e2);
        E3 = (TableRow) findViewById(R.id.e3);
        E4 = (TableRow) findViewById(R.id.e4);
        E5 = (TableRow) findViewById(R.id.e5);
        E6 = (TableRow) findViewById(R.id.e6);
        E7 = (TableRow) findViewById(R.id.e7);
        E8 = (TableRow) findViewById(R.id.e8);
        E9 = (TableRow) findViewById(R.id.e9);
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
        listaEncuentrosRow.addAll(Arrays.asList(E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, E11, E12, E13, E14, E15,
                E16, E17, E18, E19, E20, E21, E22, E23, E24, E25, E26, E27, E28, E29, E30, E31, E32, E33, E34, E35, E36,
                E37, E38, E39, E40, E41, E42, E43, E44, E45));
    }

    //generamos listaEncuentrosRadio -> radioGroup de los partidos
    private void asignarRadioEncuentros() {
        RE1 = (RadioGroup) findViewById(R.id.encuentro1);
        RE2 = (RadioGroup) findViewById(R.id.encuentro2);
        RE3 = (RadioGroup) findViewById(R.id.encuentro3);
        RE4 = (RadioGroup) findViewById(R.id.encuentro4);
        RE5 = (RadioGroup) findViewById(R.id.encuentro5);
        RE6 = (RadioGroup) findViewById(R.id.encuentro6);
        RE7 = (RadioGroup) findViewById(R.id.encuentro7);
        RE8 = (RadioGroup) findViewById(R.id.encuentro8);
        RE9 = (RadioGroup) findViewById(R.id.encuentro9);
        RE10 = (RadioGroup) findViewById(R.id.encuentro0);
        RE11 = (RadioGroup) findViewById(R.id.encuentro11);
        RE12 = (RadioGroup) findViewById(R.id.encuentro12);
        RE13 = (RadioGroup) findViewById(R.id.encuentro13);
        RE14 = (RadioGroup) findViewById(R.id.encuentro14);
        RE15 = (RadioGroup) findViewById(R.id.encuentro15);
        RE16 = (RadioGroup) findViewById(R.id.encuentro16);
        RE17 = (RadioGroup) findViewById(R.id.encuentro17);
        RE18 = (RadioGroup) findViewById(R.id.encuentro18);
        RE19 = (RadioGroup) findViewById(R.id.encuentro19);
        RE20 = (RadioGroup) findViewById(R.id.encuentro20);
        RE21 = (RadioGroup) findViewById(R.id.encuentro21);
        RE22 = (RadioGroup) findViewById(R.id.encuentro22);
        RE23 = (RadioGroup) findViewById(R.id.encuentro23);
        RE24 = (RadioGroup) findViewById(R.id.encuentro24);
        RE25 = (RadioGroup) findViewById(R.id.encuentro25);
        RE26 = (RadioGroup) findViewById(R.id.encuentro26);
        RE27 = (RadioGroup) findViewById(R.id.encuentro27);
        RE28 = (RadioGroup) findViewById(R.id.encuentro28);
        RE29 = (RadioGroup) findViewById(R.id.encuentro29);
        RE30 = (RadioGroup) findViewById(R.id.encuentro30);
        RE31 = (RadioGroup) findViewById(R.id.encuentro31);
        RE32 = (RadioGroup) findViewById(R.id.encuentro32);
        RE33 = (RadioGroup) findViewById(R.id.encuentro33);
        RE34 = (RadioGroup) findViewById(R.id.encuentro34);
        RE35 = (RadioGroup) findViewById(R.id.encuentro35);
        RE36 = (RadioGroup) findViewById(R.id.encuentro36);
        RE37 = (RadioGroup) findViewById(R.id.encuentro37);
        RE38 = (RadioGroup) findViewById(R.id.encuentro38);
        RE39 = (RadioGroup) findViewById(R.id.encuentro39);
        RE40 = (RadioGroup) findViewById(R.id.encuentro40);
        RE41 = (RadioGroup) findViewById(R.id.encuentro41);
        RE42 = (RadioGroup) findViewById(R.id.encuentro42);
        RE43 = (RadioGroup) findViewById(R.id.encuentro43);
        RE44 = (RadioGroup) findViewById(R.id.encuentro44);
        RE45 = (RadioGroup) findViewById(R.id.encuentro45);
        listaEncuentrosRadio.addAll(Arrays.asList(RE1, RE2, RE3, RE4, RE5, RE6, RE7, RE8, RE9, RE10, RE11, RE12, RE13, RE14, RE15,
                RE16, RE17, RE18, RE19, RE20, RE21, RE22, RE23, RE24, RE25, RE26, RE27, RE28, RE29, RE30, RE31, RE32, RE33, RE34, RE35, RE36,
                RE37, RE38, RE39, RE40, RE41, RE42, RE43, RE44, RE45));
    }

    //Mover a siguiente Activity TablaPosiciones
    public void verTabla(View v) {
        Intent intentTabla = new Intent(this, TablaPosiciones.class);

        intentTabla.putExtra("PARTICIPANTES", cantidadJugadores);
        intentTabla.putStringArrayListExtra("NOMBRES", listaDeNombres);

        startActivity(intentTabla);
    }

    private void asignarRadioLocal() {

        RBL1 = (RadioButton) findViewById(R.id.local1);
        RBL2 = (RadioButton) findViewById(R.id.local2);
        RBL3 = (RadioButton) findViewById(R.id.local3);
        RBL4 = (RadioButton) findViewById(R.id.local4);
        RBL5 = (RadioButton) findViewById(R.id.local5);
        RBL6 = (RadioButton) findViewById(R.id.local6);
        RBL7 = (RadioButton) findViewById(R.id.local7);
        RBL8 = (RadioButton) findViewById(R.id.local8);
        RBL9 = (RadioButton) findViewById(R.id.local9);
        RBL10 = (RadioButton) findViewById(R.id.local10);
        RBL11 = (RadioButton) findViewById(R.id.local11);
        RBL12 = (RadioButton) findViewById(R.id.local12);
        RBL13 = (RadioButton) findViewById(R.id.local13);
        RBL14 = (RadioButton) findViewById(R.id.local14);
        RBL15 = (RadioButton) findViewById(R.id.local15);
        RBL16 = (RadioButton) findViewById(R.id.local16);
        RBL17 = (RadioButton) findViewById(R.id.local17);
        RBL18 = (RadioButton) findViewById(R.id.local18);
        RBL19 = (RadioButton) findViewById(R.id.local19);
        RBL20 = (RadioButton) findViewById(R.id.local20);
        RBL21 = (RadioButton) findViewById(R.id.local21);
        RBL22 = (RadioButton) findViewById(R.id.local22);
        RBL23 = (RadioButton) findViewById(R.id.local23);
        RBL24 = (RadioButton) findViewById(R.id.local24);
        RBL25 = (RadioButton) findViewById(R.id.local25);
        RBL26 = (RadioButton) findViewById(R.id.local26);
        RBL27 = (RadioButton) findViewById(R.id.local27);
        RBL28 = (RadioButton) findViewById(R.id.local28);
        RBL29 = (RadioButton) findViewById(R.id.local29);
        RBL30 = (RadioButton) findViewById(R.id.local30);
        RBL31 = (RadioButton) findViewById(R.id.local31);
        RBL32 = (RadioButton) findViewById(R.id.local32);
        RBL33 = (RadioButton) findViewById(R.id.local33);
        RBL34 = (RadioButton) findViewById(R.id.local34);
        RBL35 = (RadioButton) findViewById(R.id.local35);
        RBL36 = (RadioButton) findViewById(R.id.local36);
        RBL37 = (RadioButton) findViewById(R.id.local37);
        RBL38 = (RadioButton) findViewById(R.id.local38);
        RBL39 = (RadioButton) findViewById(R.id.local39);
        RBL40 = (RadioButton) findViewById(R.id.local40);
        RBL41 = (RadioButton) findViewById(R.id.local41);
        RBL42 = (RadioButton) findViewById(R.id.local42);
        RBL43 = (RadioButton) findViewById(R.id.local43);
        RBL44 = (RadioButton) findViewById(R.id.local44);
        RBL45 = (RadioButton) findViewById(R.id.local45);

        partidosLocal.addAll(Arrays.asList(RBL1, RBL2, RBL3, RBL4, RBL5, RBL6, RBL7, RBL9, RBL10, RBL12, RBL13, RBL14, RBL16, RBL19, RBL20, RBL21, RBL22, RBL23,
                RBL24, RBL26, RBL27, RBL28, RBL29, RBL30, RBL31, RBL32, RBL33, RBL34, RBL35, RBL36, RBL37, RBL38, RBL39, RBL40, RBL4, RBL42,
                RBL43, RBL44, RBL45, RBL8, RBL11, RBL15, RBL17, RBL18, RBL25));
    }

    private void asignarRadioEmpate() {

        RBE1 = (RadioButton) findViewById(R.id.empate1);
        RBE2 = (RadioButton) findViewById(R.id.empate2);
        RBE3 = (RadioButton) findViewById(R.id.empate3);
        RBE4 = (RadioButton) findViewById(R.id.empate4);
        RBE5 = (RadioButton) findViewById(R.id.empate5);
        RBE6 = (RadioButton) findViewById(R.id.empate6);
        RBE7 = (RadioButton) findViewById(R.id.empate7);
        RBE8 = (RadioButton) findViewById(R.id.empate8);
        RBE9 = (RadioButton) findViewById(R.id.empate9);
        RBE10 = (RadioButton) findViewById(R.id.empate10);
        RBE11 = (RadioButton) findViewById(R.id.empate11);
        RBE12 = (RadioButton) findViewById(R.id.empate12);
        RBE13 = (RadioButton) findViewById(R.id.empate13);
        RBE14 = (RadioButton) findViewById(R.id.empate14);
        RBE15 = (RadioButton) findViewById(R.id.empate15);
        RBE16 = (RadioButton) findViewById(R.id.empate16);
        RBE17 = (RadioButton) findViewById(R.id.empate17);
        RBE18 = (RadioButton) findViewById(R.id.empate18);
        RBE19 = (RadioButton) findViewById(R.id.empate19);
        RBE20 = (RadioButton) findViewById(R.id.empate20);
        RBE21 = (RadioButton) findViewById(R.id.empate21);
        RBE22 = (RadioButton) findViewById(R.id.empate22);
        RBE23 = (RadioButton) findViewById(R.id.empate23);
        RBE24 = (RadioButton) findViewById(R.id.empate24);
        RBE25 = (RadioButton) findViewById(R.id.empate25);
        RBE26 = (RadioButton) findViewById(R.id.empate26);
        RBE27 = (RadioButton) findViewById(R.id.empate27);
        RBE28 = (RadioButton) findViewById(R.id.empate28);
        RBE29 = (RadioButton) findViewById(R.id.empate29);
        RBE30 = (RadioButton) findViewById(R.id.empate30);
        RBE31 = (RadioButton) findViewById(R.id.empate31);
        RBE32 = (RadioButton) findViewById(R.id.empate32);
        RBE33 = (RadioButton) findViewById(R.id.empate33);
        RBE34 = (RadioButton) findViewById(R.id.empate34);
        RBE35 = (RadioButton) findViewById(R.id.empate35);
        RBE36 = (RadioButton) findViewById(R.id.empate36);
        RBE37 = (RadioButton) findViewById(R.id.empate37);
        RBE38 = (RadioButton) findViewById(R.id.empate38);
        RBE39 = (RadioButton) findViewById(R.id.empate39);
        RBE40 = (RadioButton) findViewById(R.id.empate40);
        RBE41 = (RadioButton) findViewById(R.id.empate41);
        RBE42 = (RadioButton) findViewById(R.id.empate42);
        RBE43 = (RadioButton) findViewById(R.id.empate43);
        RBE44 = (RadioButton) findViewById(R.id.empate44);
        RBE45 = (RadioButton) findViewById(R.id.empate45);

        partidosLocal.addAll(Arrays.asList(RBE1, RBE2, RBE3, RBE4, RBE5, RBE6, RBE7, RBE9, RBE10, RBE12, RBE13, RBE14, RBE16, RBE19, RBE20, RBE21, RBE22, RBE23,
                RBE24, RBE26, RBE27, RBE28, RBE29, RBE30, RBE31, RBE32, RBE33, RBE34, RBE35, RBE36, RBE37, RBE38, RBE39, RBE40, RBE4, RBE42,
                RBE43, RBE44, RBE45, RBE8, RBE11, RBE15, RBE17, RBE18, RBE25));
    }

    private void asignarRadioVisitante() {

        RBV1 = (RadioButton) findViewById(R.id.visitante1);
        RBV2 = (RadioButton) findViewById(R.id.visitante2);
        RBV3 = (RadioButton) findViewById(R.id.visitante3);
        RBV4 = (RadioButton) findViewById(R.id.visitante4);
        RBV5 = (RadioButton) findViewById(R.id.visitante5);
        RBV6 = (RadioButton) findViewById(R.id.visitante6);
        RBV7 = (RadioButton) findViewById(R.id.visitante7);
        RBV8 = (RadioButton) findViewById(R.id.visitante8);
        RBV9 = (RadioButton) findViewById(R.id.visitante9);
        RBV10 = (RadioButton) findViewById(R.id.visitante10);
        RBV11 = (RadioButton) findViewById(R.id.visitante11);
        RBV12 = (RadioButton) findViewById(R.id.visitante12);
        RBV13 = (RadioButton) findViewById(R.id.visitante13);
        RBV14 = (RadioButton) findViewById(R.id.visitante14);
        RBV15 = (RadioButton) findViewById(R.id.visitante15);
        RBV16 = (RadioButton) findViewById(R.id.visitante16);
        RBV17 = (RadioButton) findViewById(R.id.visitante17);
        RBV18 = (RadioButton) findViewById(R.id.visitante18);
        RBV19 = (RadioButton) findViewById(R.id.visitante19);
        RBV20 = (RadioButton) findViewById(R.id.visitante20);
        RBV21 = (RadioButton) findViewById(R.id.visitante21);
        RBV22 = (RadioButton) findViewById(R.id.visitante22);
        RBV23 = (RadioButton) findViewById(R.id.visitante23);
        RBV24 = (RadioButton) findViewById(R.id.visitante24);
        RBV25 = (RadioButton) findViewById(R.id.visitante25);
        RBV26 = (RadioButton) findViewById(R.id.visitante26);
        RBV27 = (RadioButton) findViewById(R.id.visitante27);
        RBV28 = (RadioButton) findViewById(R.id.visitante28);
        RBV29 = (RadioButton) findViewById(R.id.visitante29);
        RBV30 = (RadioButton) findViewById(R.id.visitante30);
        RBV31 = (RadioButton) findViewById(R.id.visitante31);
        RBV32 = (RadioButton) findViewById(R.id.visitante32);
        RBV33 = (RadioButton) findViewById(R.id.visitante33);
        RBV34 = (RadioButton) findViewById(R.id.visitante34);
        RBV35 = (RadioButton) findViewById(R.id.visitante35);
        RBV36 = (RadioButton) findViewById(R.id.visitante36);
        RBV37 = (RadioButton) findViewById(R.id.visitante37);
        RBV38 = (RadioButton) findViewById(R.id.visitante38);
        RBV39 = (RadioButton) findViewById(R.id.visitante39);
        RBV40 = (RadioButton) findViewById(R.id.visitante40);
        RBV41 = (RadioButton) findViewById(R.id.visitante41);
        RBV42 = (RadioButton) findViewById(R.id.visitante42);
        RBV43 = (RadioButton) findViewById(R.id.visitante43);
        RBV44 = (RadioButton) findViewById(R.id.visitante44);
        RBV45 = (RadioButton) findViewById(R.id.visitante45);

        partidosLocal.addAll(Arrays.asList(RBV1, RBV2, RBV3, RBV4, RBV5, RBV6, RBV7, RBV9, RBV10, RBV12, RBV13, RBV14, RBV16, RBV19, RBV20, RBV21, RBV22, RBV23,
                RBV24, RBV26, RBV27, RBV28, RBV29, RBV30, RBV31, RBV32, RBV33, RBV34, RBV35, RBV36, RBV37, RBV38, RBV39, RBV40, RBV4, RBV42,
                RBV43, RBV44, RBV45, RBV8, RBV11, RBV15, RBV17, RBV18, RBV25));

    }

    private void acoplarNombres(ArrayList<String> listaDeNombres) {
        Integer i;
        for (i = 0; i < listaDeNombres.size(); i++) {
            acoplarNombreAJugador(listaJugadores.get(i), listaDeNombres.get(i));
        }
    }

    private void acoplarNombreAJugador(ArrayList<TextView> Jugador, String Nombre) {
        for (Integer i = 0; i < Jugador.size(); i++)
            Jugador.get(i).setText(Nombre);
    }

    //devuelve true/false si el partido fue o no jugado, comparando el radio group
    private boolean seJugo(RadioGroup partido) {
        if (partido.getVisibility() == View.GONE || partido.getCheckedRadioButtonId() == -1)
            return false;
        else
            return true;
    }

    //forma una lista con 1,2,3 para determinar el partido y asi enviarla a la tabla de Posiciones
    private void calcularPartidos(ArrayList<RadioGroup> agendaPartidos) {

        for (Integer i = 0; i <= agendaPartidos.size(); i++) {

            if (seJugo(agendaPartidos.get(i))) {
                partidosFinal.add(i, resultadoPartido(agendaPartidos.get(i)));
            } else {
                partidosFinal.add(i, -1);
            }
        }
    }

    @NonNull
    private Integer resultadoPartido(RadioGroup partido) {
        Integer resultadoPartido = partido.getCheckedRadioButtonId();

        if (estaEn(resultadoPartido, partidosLocal))
            return 1;
        else if (estaEn(resultadoPartido, partidosEmpate))
            return 2;
        else
            return 3;
    }

    @NonNull
    private Boolean estaEn(Integer resultado, ArrayList<RadioButton> listaResultados) {
        Integer i = 0;
        while (i < listaResultados.size()) {
            Integer resultadoComparador = 0;
            try {
                resultadoComparador = Integer.parseInt(listaResultados.get(i).toString().trim());
            } catch (NumberFormatException e) {
            }
            if (resultado == resultadoComparador)
                return true;
            else
                i++;
        }
        return false;
    }

    private void pasarAPosiciones(View v) {
        Intent intent = new Intent(this, TablaPosiciones.class);
        intent.putStringArrayListExtra("NOMBRES", listaDeNombres);
        intent.putExtra("CANTIDAD", cantidadJugadores);
        intent.putIntegerArrayListExtra("PARTIDOS", partidosFinal);
        startActivity(intent);
    }

}


//TODO se podria crear una lisa que contenga todos los partidos que puede llegar a jugar un jugador (local y visitante)
// y además un valor centinela al terminar local, que pueda separarse en TablaPosciones, y asi mandar solo una lista.

//radioGroups jugador 1 LOCAL 1,3,5,23,28,33,38,42,16 - NO TIENE VISITANTE
//jugador 2 L: 4,6,19,24,29,34,39,45 - V: 1
//jugador 3 L: 2,43,20,25,30,35,41 - V:6,3
//jugador 4 L: 13,40,44,26,31,37 - V:2,5,4
//jugador 5 L: 7,17,9,11,27 - V:28,13,19,35
//jugador 6 L: 12,10,36,22 - V:23,29,43,7,40
//jugador 7 L: 8,21,18 - V: 33,24,12,30,44,9
//jugador 8 L: 14,32 - V: 38,34,20,8,10,26,11
//jugador 9 L: 15 - V: 42,39,25,17,14,21,31,36
//jugador 0 L: / - V: 15,1618,22,27,32,37,41,45