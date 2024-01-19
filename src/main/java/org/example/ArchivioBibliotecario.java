package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArchivioBibliotecario {
    private List<ElementoCatalogo> archivio = new ArrayList<>();

    // Altri metodi della classe che hai già implementato...

    // Metodo per l'aggiunta di un elemento all'archivio
    public void aggiungiElemento(ElementoCatalogo elemento) {
        archivio.add(elemento);
    }

    // Metodo per la rimozione di un elemento dato un codice ISBN
    public void rimuoviElementoPerISBN(String codiceISBN) {
        archivio.removeIf(elemento -> elemento.getCodiceISBN().equals(codiceISBN));
    }

    // Metodo per la ricerca di un elemento per ISBN
    public Optional<ElementoCatalogo> cercaPerISBN(String codiceISBN) {
        return archivio.stream()
                .filter(elemento -> elemento.getCodiceISBN().equals(codiceISBN))
                .findFirst();
    }

    // Metodo per la ricerca di elementi per anno di pubblicazione
    public List<ElementoCatalogo> cercaPerAnnoPubblicazione(int anno) {
        return archivio.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    // Metodo per la ricerca di elementi per autore
    public List<ElementoCatalogo> cercaPerAutore(String autore) {
        return archivio.stream()
                .filter(elemento -> elemento instanceof Libro && ((Libro) elemento).getAutore().equals(autore))
                .collect(Collectors.toList());
    }
}
