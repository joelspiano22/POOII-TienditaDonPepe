/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examw7dthb;

import controllers.CategoriasController;
import controllers.ProductoController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Operaciones;
import models.Producto;

/**
 *
 * @author sebap
 */
public class BodeguitaDonPepe extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel();

    ProductoController pc = new ProductoController();
    CategoriasController cc = new CategoriasController();
    Operaciones op = new Operaciones();

    private void agregarColumnas() {
        List<String> Columnas = new ArrayList<>(Arrays.asList("Codigo", "Nombre", "Precio", "Stock", "Descripcion", "Categoria"));

        dtm.setRowCount(0);

        for (String x : Columnas) {
            dtm.addColumn(x);
        }

        this.tableMain.setModel(dtm);
        /**/
        List<String> Columnas2 = new ArrayList<>(Arrays.asList("Categoria", "Cantidad"));

        dtm2.setRowCount(0);

        for (String x : Columnas2) {
            dtm2.addColumn(x);
        }

        this.tableAuxiliar.setModel(dtm2);
    }

    private void listar(boolean inicio) {
        if (pc.size() <= 0) {
            if (!inicio) {
                JOptionPane.showMessageDialog(this, "La tabla no tiene datos");
            }
            return;
        }
        dtm.setRowCount(0);

        for (int i = 0; i < pc.size(); i++) {
            if (pc.get(i).getNombre().toUpperCase().contains(txtBuscar.getText().toUpperCase()) &&
                pc.get(i).getCategoria().toUpperCase().contains(this.getCategoriaBuscar().toUpperCase())) {

                Object arreglo[] = new Object[6];
                arreglo[0] = pc.get(i).getCodigo();
                arreglo[1] = pc.get(i).getNombre();
                arreglo[2] = pc.get(i).getPrecio();
                arreglo[3] = pc.get(i).getStock();
                arreglo[4] = pc.get(i).getDescripcion();
                arreglo[5] = pc.get(i).getCategoria();

                dtm.addRow(arreglo);
            }
        }
        this.tableMain.setModel(dtm);

        ArrayList<ArrayList<Object>> result = op.getCoincidenciasDeTipo(pc.getLst());
        dtm2.setRowCount(0);
        for (int i = 0; i < result.size(); i++) {
            Object arreglo[] = new Object[2];
            arreglo[0] = result.get(i).get(0);
            arreglo[1] = result.get(i).get(1);
            dtm2.addRow(arreglo);
        }
        this.tableAuxiliar.setModel(dtm2);
    }

    private void actualizar(boolean inicio) {
        listar(inicio);
        if (pc.size() <= 0) {
            txtOutput.setText("No hay Mascotas Registradas");
            return;
        }
        Producto productoMayor = op.precioMayor(pc.getLst());
        Producto productoMenor = op.precioMenor(pc.getLst());
        double precioPromedio = op.promedio(pc.getLst());
        txtOutput.setText("Total de productos Registrados: " + pc.size()
                + "\n\nStock Total de productos: " + op.sumarStock(pc.getLst())
                + "\n\nProducto de Mayor Precio es: " + productoMayor.getNombre()
                + " (S/. " + productoMayor.getPrecio() + ") , \nCódigo "
                + productoMayor.getCodigo() + ", Stock de " + productoMayor.getStock()
                + " productos"
                + "\n\nProducto de Menor Precio es: " + productoMenor.getDescripcion()
                + " (S/. " + productoMenor.getPrecio() + ") , \nCódigo "
                + productoMenor.getCodigo() + ", Stock de " + productoMenor.getStock()
                + " productos"
                + "\n\n Precio Promedio: " + precioPromedio);
    }

    private int getCodigo() {
        return Integer.parseInt(txtCodigo.getText());
    }

    private String getNombre() {
        return txtNombre.getText();
    }

    private Double getPrecio() {
        return Double.parseDouble(txtPrecio.getText());
    }

    private int getStock() {
        return Integer.parseInt(txtStock.getText());
    }

    private String getDescripcion() {
        return txtDescripcion.getText();
    }

    private String getCategoria() {
        return (String) cmBxCategoria.getSelectedItem();
    }

    private String getCategoriaBuscar() {
        return (String) cmBxBuscar.getSelectedItem();
    }

    private void setComboBox(List<String> s) {
        dcbm.removeAllElements();
        for (String x : s) {
            dcbm.addElement(x);
        }
        this.cmBxCategoria.setModel(dcbm);
        dcbm2.removeAllElements();
        for (String x : s) {
            dcbm2.addElement(x);
        }
        this.cmBxBuscar.setModel(dcbm2);
    }

    /**
     * Creates new form BodeguitaDonPepe
     */
    public BodeguitaDonPepe() {
        initComponents();
        agregarColumnas();
        if (cc.size() > 0) {
            setComboBox(cc.getCategorias());
        }
        actualizar(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMain = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAuxiliar = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        cmBxCategoria = new javax.swing.JComboBox<>();
        cmBxBuscar = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextPane();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TIENDITA DE DON PEPE");

        jLabel2.setText("Código");

        jLabel3.setText("Nombre");

        jLabel4.setText("Precio");

        jLabel5.setText("Stock");

        jLabel6.setText("Buscar");

        jLabel7.setText("Descrip.");

        jLabel8.setText("Categoria");

        tableMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tableMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMain);

        tableAuxiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tableAuxiliar);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        cmBxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmBxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmBxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmBxBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Data Output");

        jScrollPane3.setViewportView(txtOutput);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCodigo)
                                            .addComponent(txtNombre)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmBxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmBxBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGrabar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmBxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmBxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnNuevo)
                    .addComponent(btnGrabar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtCodigo.setText(String.valueOf(pc.getCorrelativo()));
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtDescripcion.setText("");
        cmBxCategoria.setSelectedItem("");
        txtBuscar.setText("");
        cmBxBuscar.setSelectedItem("");
        actualizar(false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        int rpta = JOptionPane.showConfirmDialog(this, "Deseas Grabar el Registro", "Grabar", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.NO_OPTION == rpta) {
            return;
        }

        if (pc.search(getCodigo()) != null) {
            JOptionPane.showMessageDialog(this, "Mascota existente");
            return;
        }

        Producto prod = new Producto(getCodigo(), getNombre(), getPrecio(), getStock(), getDescripcion(), getCategoria());
        pc.add(prod);
        pc.grabar();
        btnNuevoActionPerformed(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int msg = JOptionPane.showConfirmDialog(this, "Deseas Eliminar el Registro", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION) {
            msg = JOptionPane.showConfirmDialog(this, "¿Estas seguro?, esta acción es irreversible", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (msg == JOptionPane.NO_OPTION) {
                return;
            }
        } else {
            return;
        }

        Producto a = pc.search(getCodigo());
        if (a != null) {
            //modificar datos
            pc.remove(a);
            JOptionPane.showMessageDialog(this, "Registro Actualizado!!!", "Mensaje", 1);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontro!!!", "Mensaje", 3);
        }
        actualizar(false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int msg = JOptionPane.showConfirmDialog(this, "Deseas Modificar el Registro", "Modificar", JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.NO_OPTION) {
            return;
        }
        Producto a = pc.search(getCodigo());
        if (a != null) {
            //modificar datos
            a.setNombre(getNombre());
            a.setPrecio(getPrecio());
            a.setStock(getStock());
            a.setDescripcion(getDescripcion());
            a.setCategoria(getCategoria());

            listar(false);//actualizar la lista
            pc.grabar();
            JOptionPane.showMessageDialog(this, "Registro Actualizado!!!", "Mensaje", 1);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontro!!!", "Mensaje", 3);
        }
        // TODO add your handling code here:
        actualizar(false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (pc.search(getCodigo()) == null) {
            JOptionPane.showMessageDialog(this, "Producto no Encontrado");
            return;
        }
        Producto obj = pc.search(getCodigo());
        JOptionPane.showMessageDialog(this, "Código: " + obj.getCodigo() + "\nNombre: "
                + obj.getNombre() + "\nPrecio: S/." + obj.getPrecio()
                + "\nStock: " + obj.getStock());
// TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed
     
    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        listar(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cmBxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmBxBuscarActionPerformed
        listar(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_cmBxBuscarActionPerformed

    private void tableMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMainMouseClicked
        this.txtCodigo.setText(dtm.getValueAt(this.tableMain.getSelectedRow(), 0).toString());
        this.txtNombre.setText(dtm.getValueAt(this.tableMain.getSelectedRow(), 1).toString());
        this.txtPrecio.setText(dtm.getValueAt(this.tableMain.getSelectedRow(), 2).toString());
        this.txtStock.setText(dtm.getValueAt(this.tableMain.getSelectedRow(), 3).toString());
        this.txtDescripcion.setText(dtm.getValueAt(this.tableMain.getSelectedRow(), 4).toString());

        try {
            this.cmBxCategoria.setSelectedItem(dtm.getValueAt(this.tableMain.getSelectedRow(), 5).toString());
        } catch (Exception e) {
            this.cmBxCategoria.setSelectedItem("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMainMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BodeguitaDonPepe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BodeguitaDonPepe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BodeguitaDonPepe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BodeguitaDonPepe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BodeguitaDonPepe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmBxBuscar;
    private javax.swing.JComboBox<String> cmBxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableAuxiliar;
    private javax.swing.JTable tableMain;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextPane txtOutput;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
