package com.example.extrahilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText num_hilos;
    EditText edit_matriz;
    Button boton;
    TextView resultado;
    //Matrices matriz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String ubicacion = "";
        InputStream is1000 = this.getResources().openRawResource(R.raw.mat1000);//Cambiar nombres por el de otras matrices

        num_hilos = (EditText) findViewById(R.id.edit_num_hilos);
        edit_matriz = (EditText) findViewById(R.id.edit_matriz);
        boton = (Button) findViewById(R.id.ejecutar);
        resultado = (TextView) findViewById(R.id.resultado);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hilos = ""+num_hilos.getText();
                String mat = "" + edit_matriz;
                String res = "";
                try{
                    //leemos las matrices
                    //creamos el objeto
                    //Si es secuencial tomamos tiempo con 1 hilo
                    //En otro caso tomamos tiempo con los hilos puestos
                    List<Thread> hilosL = new ArrayList<>();
                    leer();
                    resultado.setText(res);
                }catch (InterruptedException | IOException e){//La primer excepcion va, la segunda dependiendo de como leyeron su archvio
                    e.printStackTrace();
                }
            }
        });
    }

    public int[][] leer() throws  IOException{
        InputStream is = this.getResources().openRawResource(R.raw.mat1000);//actualicen esto, para poner cualquier archvio
        return null;
    }
}