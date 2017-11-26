package com.example.br.sorteiomega;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Paulo Victor on 12/11/2017.
 */

public class ListaNumMegaActivity extends Activity {
    private ListView listNum;
    private List<NumeroMega> listNumero;
    private ArrayAdapter<NumeroMega> adapter;
    private  int adapterlayout = android.R.layout.simple_list_item_1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        listNum = (ListView) findViewById(R.id.listNumero);
    }


    private void carregarListaNumeroMega() {
        // Criacao do objeto DAO - inicio da conexao com BD
        NumeroMegaDAO dao = new NumeroMegaDAO(this);
        // chamada ao metodo listar
        this.listNumero = dao.listar();
        // Fim da conexao com BD
        dao.close();

        // O objeto ListaAlunoAdapter sabe converter listas de alunos em View
        adapter = new ArrayAdapter<NumeroMega>(this,adapterlayout,listNumero);

        // Associacao do Adapter aa ListView
        listNum.setAdapter(adapter);
        Log.e("LISTAGEM","chamada ao metodo listar" );

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregarListaNumeroMega();
    }
}
