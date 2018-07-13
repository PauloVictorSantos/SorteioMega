package com.example.br.sorteiomega;

import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Paulo Victor on 12/11/2017.
 */

public class FormHelper {
    int quatnum = 6;
    int sorteio[] = new int[quatnum];
    private TextView numero;
    private NumeroMega numeroMega;

    public FormHelper(MainActivity activity){
        numero =(TextView)activity.findViewById(R.id.numeros);
        numeroMega=new NumeroMega();
    }

    public NumeroMega getNumeroMega() {
        numeroMega.setNumeroMega(numero.getText().toString());
        return numeroMega;
    }

    public void  sorteio(){
        List<Integer> numbers = SorteioMega.sorteio(quatnum);
        Collections.sort(numbers);
        numero.setText(Arrays.toString(numbers.toArray()).replaceAll("\\[|\\]", ""));
    }

}
