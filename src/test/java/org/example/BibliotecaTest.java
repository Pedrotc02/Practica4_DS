package org.example;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @org.junit.jupiter.api.Test
    void devuelve_Libro() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario u = new Usuario();
        Ficha_socio fSocio = new Ficha_socio();
        fSocio.historial = new Historial();
        u._unnamed_Ficha_socio_25 = fSocio;
        Préstamo p = new Préstamo();
        p._fechaTope = LocalDateTime.of(2023, 12, 22, 10, 30);
        p._ejemplar = new Ejemplar();
        Ficha_ejemplar fEjemplar = new Ficha_ejemplar();
        p._ejemplar.fichaEjemplar = fEjemplar;

        biblioteca.usuarios.put(0, u);
        biblioteca.prestamos.put(0, p);

        biblioteca.Devuelve_Libro(0, 0);

        //Comprobamos que el estado de la ficha del ejemplar no ha cambiado a "Disponible", pues el usuario ha recibido una penalización
        /*
            Este test daba error debido a que los HashMap de la clase Biblioteca no estaban inicializados
            Tras corregirlo, dio fallo debido a que Historial no inicializaba el HashMap _prestamos
         */
        assertAll(
                () -> assertNotEquals("Disponible", fEjemplar._estado)
        );
    }

    @org.junit.jupiter.api.Test
    void devuelve_LibroCajaBlanca() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario u = new Usuario();
        Ficha_socio fSocio = new Ficha_socio();
        fSocio.historial = new Historial();
        u._unnamed_Ficha_socio_25 = fSocio;
        Préstamo p = new Préstamo();
        p._ejemplar = new Ejemplar();
        Ficha_ejemplar fEjemplar = new Ficha_ejemplar();
        p._ejemplar.fichaEjemplar = fEjemplar;

        biblioteca.usuarios.put(0, u);
        biblioteca.prestamos.put(0, p);

        /*
            Se ha añadido la comprobación inicial de los identificadores pasados como parámetros para, en caso de
            no existir préctamo o usuario, no continuar con la función

            Además, se ha tenido que inicializar el estado de la ficha de ejemplar
         */

        //Para fecha de devolución posterior
        p._fechaTope = LocalDateTime.of(2023, 12, 22, 10, 30);
        biblioteca.Devuelve_Libro(0, 0);
        assertAll(
                () -> assertNotEquals("Disponible", fEjemplar._estado)
        );

        //Para fecha de devolución anterior
        p._fechaTope = LocalDateTime.now();
        p._fechaTope.plusDays(1);
        biblioteca.Devuelve_Libro(0, 0);
        assertAll(
                () -> assertEquals("Disponible", fEjemplar._estado)
        );
    }

    @org.junit.jupiter.api.Test
    void getEjemplar() {
        Biblioteca biblioteca = new Biblioteca();
        Ficha_ejemplar f = new Ficha_ejemplar();
        f._estado = "Disponible";
        Ejemplar e = new Ejemplar();
        e.fichaEjemplar = f;
        Libro l = new Libro();
        l.ejemplares.add(e);
        biblioteca.catalogo.libros.put("Test", l);

        //Comprobamos que devuelve el ejemplar correcto
        /*
            Este test daba error debido a que el atributo catalogo de Biblioteca no estaba inicializado
         */
        assertAll(
                () -> assertEquals(e, biblioteca.getEjemplar("Test"))
        );

        f._estado = "";

        //Comprobamos que si el estado de la Ficha_ejemplar es distinto de "Disponible", no devuelve el ejemplar
        assertAll(
                () -> assertNull(biblioteca.getEjemplar("Test"))
        );
    }

    @org.junit.jupiter.api.Test
    void getUsuario() {

        Biblioteca biblioteca = new Biblioteca();
        Usuario u = new Usuario();

        biblioteca.usuarios.put(0, u);

        //Comprobamos que devuelve el usuario almacenado con clave "0"
        assertAll(
                () -> assertEquals(u, biblioteca.getUsuario(0))
        );

        //Comprobamos que devuelve null, pues no hay usuario almacenado para la clave 8
        assertAll(
                () -> assertNull(biblioteca.getUsuario(8))
        );
    }
}