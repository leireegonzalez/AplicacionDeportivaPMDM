package com.example.aplicaciondeportivapmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton play_button;
    private Button trabajo_button;
    private Button descanso_button;
    private Button ejercicio_button;
    private Button rondas_button;
    private Button reinicio_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_button = findViewById(R.id.botonPrincipal);
        trabajo_button = findViewById(R.id.botonTrabajo);
        descanso_button = findViewById(R.id.botonDescanso);
        ejercicio_button = findViewById(R.id.botonEjercicios);
        rondas_button = findViewById(R.id.botonRondas);
        reinicio_button = findViewById(R.id.botonreinicioRonda);


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
            }
        });
        descanso_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();
            }
        });
        ejercicio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();
            }
        });
        rondas_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();
            }
        });
        reinicio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuletaActivity();
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