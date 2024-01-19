package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class ArchivioBibliotecario {
    private List<ElementoCatalogo> archivio = new ArrayList<>();

    public List<ElementoCatalogo> getArchivio() {
        return archivio;
    }

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

    //Metodo per il salvataggio dell'archivio sul disco
    public static void salvaProdottiSuDisco(List<ElementoCatalogo> elemento) throws IOException {
        File file = new File("dirProdotti/prodotti.txt");

        String stringaProdotti = elemento.stream().map(p->p.getCodiceISBN()+"@"+p.getTitolo()+"@"+p.getAnnoPubblicazione()+ "@"+ p.getNumeroPagine()).collect(Collectors.joining("#"));

        FileUtils.writeStringToFile(file, stringaProdotti, Charset.defaultCharset(), true);
    }
    public static ArrayList<ElementoCatalogo> leggiProdottiDaDisco() throws IOException {
        File file = new File("dirProdotti/prodotti.txt");

        String stringaProdotti =  FileUtils.readFileToString(file, Charset.defaultCharset());

        String[] stringheSingoloProdotto = stringaProdotti.split("#");


        ArrayList<ElementoCatalogo> prodotti = Arrays.stream(stringheSingoloProdotto).map(s -> {String[] stringaCaratteristicheProdotto = s.split("@");
            ElementoCatalogo e = new ElementoCatalogo(
                    stringaCaratteristicheProdotto[0],
                    stringaCaratteristicheProdotto[1],
                    Integer.parseInt(stringaCaratteristicheProdotto[2]),
                    Integer.parseInt(stringaCaratteristicheProdotto[3]));
            return e;}).collect(Collectors.toCollection(ArrayList::new));
        return prodotti;
    }


}
