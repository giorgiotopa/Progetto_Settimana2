package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainBiblioteca {
    public static void main(String[] args) {
        ArchivioBibliotecario archivioBibliotecario = new ArchivioBibliotecario();

        // Aggiunta di elementi
        Libro libro1 = new Libro("123456789", "Titolo Libro 1", 2022, 200, "Autore Libro 1", "Genere Libro 1");
        Libro libro2 = new Libro("987654321", "Titolo Libro 2", 2020, 150, "Autore Libro 2", "Genere Libro 2");
        Rivista rivista1 = new Rivista("111222333", "Titolo Rivista 1", 2021, 50, Periodicità.SETTIMANALE);

        archivioBibliotecario.aggiungiElemento(libro1);
        archivioBibliotecario.aggiungiElemento(libro2);
        archivioBibliotecario.aggiungiElemento(rivista1);

        // Ricerca per ISBN
        Optional<ElementoCatalogo> risultatoRicercaISBN = archivioBibliotecario.cercaPerISBN("123456789");
        risultatoRicercaISBN.ifPresent(elemento -> System.out.println("Elemento trovato per ISBN: " + elemento));

        // Ricerca per anno di pubblicazione
        List<ElementoCatalogo> risultatoRicercaAnno = archivioBibliotecario.cercaPerAnnoPubblicazione(2020);
        System.out.println("Elementi trovati per anno di pubblicazione 2020:");
        risultatoRicercaAnno.forEach(elemento -> System.out.println(elemento));

        // Ricerca per autore
        List<ElementoCatalogo> risultatoRicercaAutore = archivioBibliotecario.cercaPerAutore("Autore Libro 1");
        System.out.println("Elementi trovati per autore 'Autore Libro 1':");
        risultatoRicercaAutore.forEach(elemento -> System.out.println(elemento));

        // Rimozione di un elemento per ISBN
        archivioBibliotecario.rimuoviElementoPerISBN("987654321");

        //Salvataggio dei prodotti sul disco
        try {
            archivioBibliotecario.salvaProdottiSuDisco(archivioBibliotecario.getArchivio());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Caricamento dei prodotti dal disco

        ArrayList<ElementoCatalogo> prodottiDalDisco;
        try {
            prodottiDalDisco = archivioBibliotecario.leggiProdottiDaDisco();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sul disco sono presenti i seguenti prodotti: " + prodottiDalDisco);

    }
}
