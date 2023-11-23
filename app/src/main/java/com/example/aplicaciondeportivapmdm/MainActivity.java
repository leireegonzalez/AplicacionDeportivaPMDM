package com.example.aplicaciondeportivapmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton play_button;
    private Button trabajo_button;
    private Button descanso_button;
    private Button ejercicio_button;
    private Button rondas_button;
    private Button reinicio_button;

    private EditText editTextTrabajo;
    private EditText editTextDescanso;
    private EditText editTextEjercicios;
    private EditText editTextRondas;
    private EditText editTextReinicioRonda;


    private boolean botonpulsado= false;
    public static final String EXTRA_TIME = "tiempo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaro los botones
        play_button = findViewById(R.id.botonPrincipal);
        trabajo_button = findViewById(R.id.botonTrabajo);
        descanso_button = findViewById(R.id.botonDescanso);
        ejercicio_button = findViewById(R.id.botonEjercicios);
        rondas_button = findViewById(R.id.botonRondas);
        reinicio_button = findViewById(R.id.botonreinicioRonda);

        //declaro los edittext
        editTextTrabajo= findViewById(R.id.editTextTrabajo);
        editTextDescanso= findViewById(R.id.editTextDescanso);
        editTextEjercicios= findViewById(R.id.editTextEjercicios);
        editTextRondas= findViewById(R.id.editTextRondas);
        editTextReinicioRonda= findViewById(R.id.editTextReinicioRonda);







        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCronometroActivity();


            }
        });


        trabajo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonpulsado= false;

                openRuletaActivity("trabajo");

                botonpulsado= true;

            }
            // Código en la ActividadDestino

        });
        descanso_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                botonpulsado= false;


                openRuletaActivity("descanso");
                botonpulsado= true;

            }
        });
        ejercicio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonpulsado= false;

                openRuletaActivity("ejercicio");

                botonpulsado= true;

            }
        });
        rondas_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity("rondas");

            }
        });
        reinicio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clave="reinicio" ;
                openRuletaActivity(clave);

            }
        });



            actualizaredittext(editTextTrabajo);
            actualizaredittext(editTextDescanso);
            actualizaredittext(editTextEjercicios);
            actualizaredittext(editTextRondas);
            actualizaredittext(editTextReinicioRonda);


    }

    private void actualizaredittext(EditText editText) {

        Intent intent = getIntent();
        String valor = intent.getStringExtra(EXTRA_TIME);

        editText.setText(valor);
    }


    private void openCronometroActivity() {
        Intent intent = new Intent(MainActivity.this, CronometroMain.class);
        startActivity(intent);
    }

    private void openRuletaActivity(String texto) {
        Intent intent = new Intent(MainActivity.this, RuletaMain.class);

        startActivity(intent);
    }
}