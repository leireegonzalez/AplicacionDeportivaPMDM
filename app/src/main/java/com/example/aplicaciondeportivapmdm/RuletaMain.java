package com.example.aplicaciondeportivapmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class RuletaMain extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView tiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruleta_main);

        seekBar = findViewById(R.id.seek_bar);
        tiempo = findViewById(R.id.tiempo);



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
        int cantidad = seekBar.getProgress();

        int minutos = cantidad / 60;
        int segundos = cantidad % 60;

        String cadena= String.format(Locale.getDefault(),"%02d:%02d", minutos, segundos);
        tiempo.setText(cadena);
    }
}