package com.example.br.sorteiomega;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


public class MainActivity extends Activity {
    private Button numeroSorte, guardarNumero, visualizarNumero;
    private FormHelper helper;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        helper = new FormHelper(this);
    }

    private void initComponents() {
        numeroSorte = (Button) findViewById(R.id.numeroSorte);
        guardarNumero = (Button) findViewById(R.id.guardarNumero);
        visualizarNumero = (Button) findViewById(R.id.visualizarNumero);

        numeroSorte.setOnClickListener(v->{
            helper.sorteio();
            guardarNumero.setEnabled(true);
        });

        guardarNumero.setOnClickListener(v -> {
            salvarNumero();
            Snackbar.make(v,R.string.success_message, Snackbar.LENGTH_LONG).show();
        });

        visualizarNumero.setOnClickListener(v -> startActivity(new Intent(v.getContext(), ListaNumMegaActivity.class)));
    }

    private void salvarNumero() {
        NumeroMega numeroMega = helper.getNumeroMega();
        NumeroMegaDAO dao = new NumeroMegaDAO(MainActivity.this);
        dao.cadastrar(numeroMega);
        dao.close();
    }
}
