package com.example.br.sorteiomega;

import android.util.Log;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Paulo Victor on 30/10/2017.
 */



public  class SorteioMega {
    private static final String TAG = "Sorteio Mega";

    public static List<Integer> sorteio(int quantity) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < quantity){
            Integer currentNumber = getRandomInt(60);
            if (currentNumberIsValid(currentNumber) && (!numbers.contains(currentNumber))){
                numbers.add(currentNumber);
            }
        }
        return numbers;
    }

    private static boolean currentNumberIsValid(Integer currentNumber) {
        return currentNumber > 0 && currentNumber < 61;
    }

    private static Integer getRandomInt(int limit) {
        return (int) (Math.random() * limit);
    }

    public static final void ordenaSorteio(int x[], int t) {
        int aux;
        for (int i = 0; i < t - 1; i++) {
            for (int j = i + 1; j < t; j++) {
                if (x[j] < x[i]) {
                    aux = x[i];
                    x[i] = x[j];
                    x[j] = aux;
                }
            }
        }
    }

}
