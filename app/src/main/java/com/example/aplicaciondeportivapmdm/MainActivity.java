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
                openRuletaActivity();

                // Código en la ActividadDestino
                Intent intent = getIntent();
                String valor = intent.getStringExtra("tiempo");

                editTextTrabajo.setText(valor);

            }
        });
        descanso_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();

                // Código en la ActividadDestino
                Intent intent = getIntent();
                String valor = intent.getStringExtra("tiempo");

                editTextDescanso.setText(valor);
            }
        });
        ejercicio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();

                // Código en la ActividadDestino
                Intent intent = getIntent();
                String valor = intent.getStringExtra("tiempo");

                editTextEjercicios.setText(valor);
            }
        });
        rondas_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();
                // Código en la ActividadDestino
                Intent intent = getIntent();
                String valor = intent.getStringExtra("tiempo");

                editTextRondas.setText(valor);
            }
        });
        reinicio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();
                // Código en la ActividadDestino
                Intent intent = getIntent();
                String valor = intent.getStringExtra("tiempo");

                editTextReinicioRonda.setText(valor);
            }
        });

    }
    private void openCronometroActivity() {
        Intent intent = new Intent(MainActivity.this, CronometroMain.class);
        startActivity(intent);
    }

    private void openRuletaActivity() {
        Intent intent = new Intent(MainActivity.this, RuletaMain.class);
        startActivity(intent);
    }
}