package com.example.aplicaciondeportivapmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

public class CronometroMain extends AppCompatActivity {

    private CountDownTimer contadorTiempo;
    private static final long tiempoComienzo=10000;
    private long tiempoQueda=tiempoComienzo;
    boolean tiempoCorriendo;
    private ProgressBar progressCircular;
    private TextView progressText;
    private ImageButton boton_play;
    int indice = 0;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cronometro_main);

        progressCircular=(ProgressBar) findViewById(R.id.progressBar);
        //boton_play=(ImageButton) findViewById(R.id.botonPrincipal);
        progressText=(TextView) findViewById(R.id.timer);

        boton_play.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                //comprobar si el tiempo está corriendo o no
                if(tiempoCorriendo){
                    pausarTiempo();

                }else {
                    continuarTiempo();
                }
            }

        });

        //actualizamos contador
        actualizarContador();

    }

    //método donde corre el tiempo en el progressbar y el contador
    private void continuarTiempo(){

        //creamos contador decreciente
        contadorTiempo=new CountDownTimer(tiempoQueda, 50){

            //mientras está en ejecución
            @Override
            public void onTick(long tiempoFinalizar){
                tiempoQueda=tiempoFinalizar;

                //actualizamos el contador
                actualizarContador();

                indice++;
                progressCircular.setProgress((int) (indice*6/(tiempoComienzo/1000)));
            }

            //método donde finaliza la ejecución
            public void onFinish(){

                tiempoCorriendo=false;
                //mostrar botón de play
                indice++;
                progressCircular.setProgress(100);
                boton_play.setVisibility(View.INVISIBLE);
            }
        }.start();

        tiempoCorriendo=true;
        //cambiar a botón de pausa
    }

    //método para parar el tiempo y cambiar el botón
    private void pausarTiempo(){

        contadorTiempo.cancel();
        tiempoCorriendo=false;
        //cambiar a botón de play

    }

    //método donde actualizamos los valores del contador
    private void actualizarContador(){

        int minutos = (int) (tiempoQueda /1000) /60;
        int segundos = (int) (tiempoQueda /1000) %60;

        String tiempoQuedaFormateado= String.format(Locale.getDefault(),"%02d:%02d", minutos, segundos);
        progressText.setText(tiempoQuedaFormateado);
    }
}