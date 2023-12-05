/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebap
 */
public class Operaciones {

    public Operaciones() {
    }

    public int sumarStock(List<Producto> x) {
        int suma = 0;
        for (Producto y : x) {
            suma += y.getStock();
        }
        return suma;
    }

    public Producto precioMayor(List<Producto> x) {
        if (x.size() <= 0) {
            return null;
        }

        Producto mayor = x.get(0);

        for (Producto y : x) {
            if (mayor.getPrecio()< y.getPrecio()) {
                mayor = y;
            }
        }
        return mayor;
    }
    public Producto precioMenor(List<Producto> x) {
        if (x.size() <= 0) {
            return null;
        }

        Producto menor = x.get(0);

        for (Producto y : x) {
            if (menor.getPrecio() > y.getPrecio()) {
                menor = y;
            }
        }
        return menor;
    }
    public double promedio(List<Producto> x) {
        if (x.size() <= 0) {
            return 0;
        }
        double suma=0;
        for(Producto y:x)
        {
            suma+=y.getPrecio();
        }
        suma/=x.size();
        return suma;
    }
    
    public ArrayList<ArrayList<Object>> getCoincidenciasDeTipo(List<Producto> bd) {
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<ArrayList<Object>> salida = new ArrayList<>();
        boolean encontrado = false;
        for (Producto x : bd) {
            encontrado = false;
            for (String a : nombres) {
                if (a.equalsIgnoreCase(x.getCategoria())) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                nombres.add(x.getCategoria());
            }
        }
        int temporalInt;

        for (String a : nombres) {
            ArrayList<Object> temporal = new ArrayList<>();
            temporal.clear();
            temporalInt = 0;
            temporal.add(a);
            for (Producto x : bd) {
                if (a.equalsIgnoreCase(x.getCategoria())) {
                    temporalInt++;
                }
            }
            temporal.add(temporalInt);
            salida.add(temporal);
        }

        return salida;
    }
}
