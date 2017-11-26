package com.example.br.sorteiomega;

/**
 * Created by Paulo Victor on 30/10/2017.
 */

public  class SorteioMega {
    public static void sorteio(int s[], int linha) {
        int numero_sorteio, d = 0, tam = 0;
        boolean repete;
        repete = false;
        s[d] = (int) (Math.random() * 60);
//		tam++;
        while (tam < linha) {
            numero_sorteio = (int) (Math.random() * 60);
            for (int j = 0; j < linha; j++) {
                if (s[j] == numero_sorteio) {
                    repete = true;
                }
            }
            if (repete == false) {
                s[tam] = numero_sorteio;
                System.out.println(s[tam]);
                tam++;
            }

        }
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
