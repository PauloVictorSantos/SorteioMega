package com.example.br.sorteiomega;

/**
 * Created by Paulo Victor on 12/11/2017.
 */

public class NumeroMega {
    Long Id;

    @Override
    public String toString() {
        return  NumeroMega;
    }

    String NumeroMega;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNumeroMega() {
        return NumeroMega;
    }

    public void setNumeroMega(String numeroMega) {
        NumeroMega = numeroMega;
    }

}
