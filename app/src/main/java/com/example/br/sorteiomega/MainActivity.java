package com.example.br.sorteiomega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Button numeroSorte, guardarNumero, visualizarNumero;
    private FormHelper helper;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroSorte = (Button) findViewById(R.id.numeroSorte);
        guardarNumero = (Button) findViewById(R.id.guardarNumero);
        visualizarNumero = (Button) findViewById(R.id.visualizarNumero);
        helper = new FormHelper(this);

        numeroSorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.sorteio();
            }
        });

        guardarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumeroMega numeroMega = helper.getNumeroMega();
                NumeroMegaDAO dao = new NumeroMegaDAO(MainActivity.this);
                dao.cadastrar(numeroMega);
                dao.close();
            }
        });

        visualizarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), ListaNumMegaActivity.class);
                startActivity(intent);
            }
        });

    }
}
