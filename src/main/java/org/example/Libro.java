package org.example;

public class Libro extends ElementoCatalogo{
    private String autore;
    private String genere;

    public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }
    public String getGenere() {
        return genere;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }
}
