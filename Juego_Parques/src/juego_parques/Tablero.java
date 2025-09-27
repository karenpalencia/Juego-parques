/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_parques;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author palen
 */
public class Tablero {

    private ArrayList<Casilla> ruta;
    private Map<String.ArrayList<Casilla>> pasillos;
    private Point meta;

    public Tablero() {
        ruta = new ArrayList<>();
        pasillos = new HashMap<>();
        inicializarRutaReal();
        inicializarMeta();
        inicializarPasillos();
    }

    private void inicializarRutaReal() {
        int[][] coords = new int[68][2];
        int i = 0;

        for (int x = 0; x <= 8; x++) {
            coords[i++] = new int[]{x, 14};
        }
        for (int x = 9; x <= 14; x++) {
            coords[i++] = new int[]{x, 14};
        }

        for (int y = 13; y >= 9; y--) {
            coords[i++] = new int[]{14, y};
        }
        for (int y = 8; y >= 6; y--) {
            coords[i++] = new int[]{14, y};
        }
        for (int y = 5; y >= 0; y--) {
            coords[i++] = new int[]{14, y};
        }

        for (int x = 13; x >= 9; x--) {
            coords[i++] = new int[]{x, 0};
        }
        for (int x = 8; x >= 7; x--) {
            coords[i++] = new int[]{x, 0};
        }
        for (int x = 6; x >= 0; x--) {
            coords[i++] = new int[]{x, 0};
        }

        for (int y = 1; y <= 6; y--) {
            coords[i++] = new int[]{0, y};
        }
        for (int y = 7; y <= 8; y--) {
            coords[i++] = new int[]{0, y};
        }
        for (int y = 9; y <= 14; y--) {
            coords[i++] = new int[]{0, y};
        }

        for (int k = 0; k < coords.length; k++) {
            Point p = new Point(coords[k][0], coords[k][1]);
            ruta.add(new Casilla(p, "normal", null));

        }
        int[] salidas = {5, 22, 39, 56};
        String[] colores = {"rojo", "azul", "verde", "amarillo"};
        for (int k = 0; k < salidas.length; k++) {
            int idx = salidas[k];
            if (idx >= 0 && idx < ruta.size()) {
                ruta.get(idx).setTipo("salida");
                ruta.get(idx).setColor(colores[k]);
            }
        }
        int[] seguros = {10, 17, 27, 34, 44, 51, 61, 68 - 1};
        for (int s : seguros) {
            if (s >= 0 && s < ruta.size()) {
                ruta.get(s).setTipo("seguro");
            }

        }
        int[] trampas = {9, 25, 42, 58};
        for (int t : trampas) {
            if (t >= 0 && t < ruta.size()) {
                ruta.get(t).setTipo("trampa");
            }

        }
    }

    private void inicializarPasillos() {
        pasillos.put("rojo", new ArrayList<>());
        pasillos.put("azul", new ArrayList<>());
        pasillos.put("verde", new ArrayList<>());
        pasillos.put("amarillo", new ArrayList<>());

        for (int y = 1; y <= 6; y++) {
            pasillos.get("rojo").add(new Casilla(new Point(7, y), "pasillo", "rojo"));
        }
        for (int x = 8; x <= 13; x++) {
            pasillos.get("azul").add(new Casilla(new Point(x, 7), "pasillo", "azul"));
        }
        for (int y = 8; y <= 13; y++) {
            pasillos.get("verde").add(new Casilla(new Point(7, y), "pasillo", "verde"));
        }
        for (int x = 1; x <= 6; x++) {
            pasillos.get("amarillo").add(new Casilla(new Point(x, 7), "pasillo", "amarillo"));
        }

    }

    private void inicializarMeta() {
        meta = new Point(7, 7);
    }

    public ArrayList<Casilla> getRuta() {
        return ruta;
    }

    public Map<String, ArrayList<Casilla>> getPasillos() {
        return pasillos;
    }

    public Point getMeta() {
        return meta;
    }
}
