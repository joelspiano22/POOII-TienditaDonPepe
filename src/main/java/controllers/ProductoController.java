/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import models.Producto;

/**
 *
 * @author sebap
 */
public class ProductoController {

    List<Producto> lst = new ArrayList<>();
    private final String directoryRoute = "./src/main/java/data/";
    private final String fileName = "productos.csv";

    public ProductoController() {
        cargar();
    }

    public List<Producto> getLst() {
        return lst;
    }

    public void setLst(List<Producto> lst) {
        this.lst = lst;
    }
    
    public void add(Producto obj) {
        lst.add(obj);
    }

    public Producto get(int i) {
        return lst.get(i);
    }

    public void set(int i, Producto obj) {
        lst.set(i, obj);
    }

    public void remove(Producto obj) {
        lst.remove(obj);
    }

    public void remove(int i) {
        lst.remove(i);
    }

    public int size() {
        return lst.size();
    }

    public int getCorrelativo() {
        if (size() <= 0) {
            return 1;
        }
        return get(size() - 1).getCodigo() + 1;
    }

    public Producto search(int codigo) {
        for (int i = 0; i < size(); i++) {
            if (lst.get(i).getCodigo() == codigo) {
                return lst.get(i);
            }
        }
        return null;
    }

    public void grabar() {
        try {
            PrintWriter pw;
            String linea;

            pw = new PrintWriter(new FileWriter(directoryRoute + fileName));

            for (int i = 0; i < size(); i++) {
                linea = (get(i).getCodigo() + ";"
                        + get(i).getNombre() + ";"
                        + get(i).getPrecio() + ";"
                        + get(i).getStock() + ";"
                        + get(i).getDescripcion() + ";"
                        + get(i).getCategoria());
                pw.println(linea);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargar() {
        try {
            BufferedReader br;
            String linea = null;
            String[] array = null;

            br = new BufferedReader(new FileReader(directoryRoute + fileName));

            while ((linea = br.readLine()) != null) {
                array = linea.split(";");

                Producto a = new Producto();

                a.setCodigo(Integer.parseInt(array[0].trim()));
                a.setNombre(array[1].trim());
                a.setPrecio(Double.parseDouble(array[2].trim()));
                a.setStock(Integer.parseInt(array[3].trim()));
                a.setDescripcion(array[4].trim());
                a.setCategoria(array[5].trim());
                add(a);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
