package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecarioTest {

    @Test
    void denegar_préstamo() {
        Bibliotecario bibliotecario = new Bibliotecario();
        Ficha_socio fSocio = new Ficha_socio();
        fSocio.historial = new Historial();
        bibliotecario._unnamed_Ficha_socio_25 = fSocio;

        //Creamos el ejemplar
        Ficha_ejemplar f = new Ficha_ejemplar();
        f._estado = "Disponible";
        Ejemplar e = new Ejemplar();
        e.fichaEjemplar = f;
        Libro l = new Libro();
        l.ejemplares.add(e);

        //Añadimos el ejemplar a la biblioteca
        bibliotecario.biblioteca.catalogo.libros.put("Test", l);

        bibliotecario.biblioteca.usuarios.put(0, bibliotecario);

        //Comprobamos que el préstamo no se deniega, pues el usuario tiene un ejemplar y no está penalizado
        /*
            El test da error debido a que el atributo biblioteca de Bibliotecario no está inicializado
         */
        assertAll(
                () -> assertFalse(bibliotecario.Denegar_préstamo("Test", 0))
        );

        bibliotecario.biblioteca = new Biblioteca();

        //Comprobamos que devuelve true cuando no existe el ejemplar en la biblioteca
        assertAll(
                () -> assertTrue(bibliotecario.Denegar_préstamo("Test", 0))
        );
    }

    @Test
    void denegar_préstamoCajaBlanca() {
        Bibliotecario bibliotecario = new Bibliotecario();
        Ficha_socio fSocio = new Ficha_socio();
        fSocio.historial = new Historial();
        bibliotecario._unnamed_Ficha_socio_25 = fSocio;

        //Creamos el ejemplar
        Ficha_ejemplar f = new Ficha_ejemplar();
        f._estado = "Disponible";
        Ejemplar e = new Ejemplar();
        e.fichaEjemplar = f;
        Libro l = new Libro();
        l.ejemplares.add(e);

        //Añadimos el ejemplar a la biblioteca
        bibliotecario.biblioteca.catalogo.libros.put("Test", l);

        bibliotecario.biblioteca.usuarios.put(0, bibliotecario);

        //No hay ejemplar
        assertTrue(bibliotecario.Denegar_préstamo("", 0));

        //Hay ejemplar, pero el usuario no existe
        assertTrue(bibliotecario.Denegar_préstamo("Test", 8));

        bibliotecario._unnamed_Ficha_socio_25.set_estado("Penalizado");
        //Hay ejemplar, pero el usuario está penalizado
        //Para este test se ha tenido que implementar un método para modificar el estado de la ficha de socio
        assertTrue(bibliotecario.Denegar_préstamo("Test", 0));

        fSocio.set_estado("");
        //Hay ejemplar y el usuario no está penalizado
        assertFalse(bibliotecario.Denegar_préstamo("Test", 0));
    }
}