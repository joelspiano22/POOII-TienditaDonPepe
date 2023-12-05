/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebap
 */
public class CategoriasController {
    private List<String> categorias=new ArrayList<>();
    private final String directoryRoute="./src/main/java/data/";
    private final String fileName="categorias.csv";
    
    public CategoriasController() {
        cargar();
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    public int size()
    {
        return categorias.size();
    }
    public void cargar()
    {
        try{
            BufferedReader br;
            String linea = null;
            String[] array = null;
            
            br = new BufferedReader(new FileReader(directoryRoute+fileName));
            
            while((linea = br.readLine())!= null){
                array = linea.split(";");
                for(String x: array)
                {
                    categorias.add(x.trim());
                }
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
