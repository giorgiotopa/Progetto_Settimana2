package org.example;

public class Rivista extends ElementoCatalogo{
    private Periodicità periodicita;

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
    public Periodicità getPeriodicita() {
        return periodicita;
    }
    public void setPeriodicita(Periodicità periodicita) {
        this.periodicita = periodicita;
    }
}
