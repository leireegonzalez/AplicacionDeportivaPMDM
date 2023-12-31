package com.example.aplicaciondeportivapmdm;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RuletaMain extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView tiempo;
    private Button volver;

    private boolean isUpdating = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruleta_main);

        seekBar = findViewById(R.id.seek_bar);
        tiempo = findViewById(R.id.tiempo);
        volver = findViewById(R.id.volver);

        volver.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                String time = tiempo.getText().toString();
                // Crear un Intent para abrir la segunda actividad
                Intent intent = new Intent(RuletaMain.this, MainActivity.class);

                // Adjuntar datos al Intent con putExtra
                intent.putExtra(MainActivity.EXTRA_TIME, time);
                startActivity(intent);
            }

        });


        tiempo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!isUpdating) {
                    isUpdating = true;
                    String cadena = tiempo.getText().toString();

                    // Formato para analizar la cadena
                    SimpleDateFormat formato = new SimpleDateFormat("mm:ss", Locale.getDefault());

                    try {
                        // Analizar la cadena y obtener un objeto Date
                        Date tiempoDate = formato.parse(String.valueOf(tiempo));

                        // Convertir la fecha a milisegundos
                        long tiempoMillis = tiempoDate.getTime();

                        // Convertir milisegundos a segundos
                        int tiempoEnSegundos = (int) (tiempoMillis / 1000);

                        if (tiempoEnSegundos > 180) {
                            tiempoEnSegundos = 180;
                        }

                        seekBar.setProgress(tiempoEnSegundos, true);

                    } catch (ParseException e) {
                        e.printStackTrace();


                    }
                }

                isUpdating = false;

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {
                cambiaValor();
            }
            @Override
            public void onStartTrackingTouch (SeekBar seekBar) {
                cambiaValor();
            }
            @Override
            public void onStopTrackingTouch (SeekBar seekBar) {
                cambiaValor();
            }

        });


    }

    private void cambiaValor() {
        if (!isUpdating) {
            isUpdating = true;
            int cantidad = seekBar.getProgress();

            int minutos = cantidad / 60;
            int segundos = cantidad % 60;

            String cadena = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
            tiempo.setText(cadena);
        }

        isUpdating = false;

    }

}