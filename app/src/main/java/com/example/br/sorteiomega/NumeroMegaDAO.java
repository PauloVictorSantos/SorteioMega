package com.example.br.sorteiomega;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulo Victor on 12/11/2017.
 */

public class NumeroMegaDAO extends SQLiteOpenHelper{

    private static final int VERSAO = 1;
    private static final String TABELA = "T_Megasena";
    private static final String DATABASE = "BD_Megasena";

    // Constante para log no Logcat
    private static final String TAG = "MEGA_SENA";

    public NumeroMegaDAO(Context context) {
        // Chamada o construtor que sabe acessar o BD
        super(context, DATABASE, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE " + TABELA + "( "
                + "id INTEGER PRIMARY KEY, "
                + "NumeroMega TEXT )";

        // Execucao do comando no SQLite
        db.execSQL(ddl);
        Log.i(TAG, "Tabela criada: " + TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void cadastrar(NumeroMega numeroMega) {

        // Objeto para armazenar os valores dos campos
        ContentValues values = new ContentValues();

        // Definicao de valores dos campos da tabela
        values.put("NumeroMega", numeroMega.getNumeroMega());

        // Inserir dados do Aluno no BD
        getWritableDatabase().insert(TABELA, null, values);
        Log.i(TAG, "numero cadastrado: " + numeroMega.getNumeroMega());
    }


    public List<NumeroMega> listar() {
        // Definicao da colecao de alunos
        List<NumeroMega> lista = new ArrayList<NumeroMega>();

        // Definicao da instrucao SQL
        String sql = "Select NumeroMega from " +TABELA+ "  order by id";

        // Objeto que recebe os registros do banco de dados
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        try {
            while (cursor.moveToNext()) {
                // Criacao de nova referencia
                NumeroMega numeroMega = new NumeroMega();
                // Carregar os atributos com dados do BD

                numeroMega.setNumeroMega(cursor.getString(0));

                // Adicionar novo  a lista
                lista.add(numeroMega);
            }
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            cursor.close();
        }
        return lista;
    }

}
