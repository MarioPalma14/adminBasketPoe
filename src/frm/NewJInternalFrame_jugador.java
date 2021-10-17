/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pkg2labo_mpwt.conexion;
import pkg2labo_mpwt.query_mpwt;

/**
 *
 * @author Alejandro
 */
public class NewJInternalFrame_jugador extends javax.swing.JInternalFrame {
    ResultSet rs;
    conexion cn;
    query_mpwt consulta;
    int g_id_universidad, g_codigo, cant_jg;
    DefaultTableModel model;
//    ArrayList<String> ldui;
    public NewJInternalFrame_jugador() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();
//        ldui = new ArrayList<>();
        cn = new conexion();
        consulta = new query_mpwt();
        model = new DefaultTableModel();
        this.jtIdUni.setEditable(false);
        this.jTextField_cant_jugador.setEditable(false);
        //================================
        this.cargar_universidad();
        this.cargar_equipo();
        this.cargar_datos();
    }

    public void cargar_universidad(){
        
        try {
            this.jComboBox_Universidad.removeAll();
            rs = cn.query(consulta.cargar_univer());
            while (rs.next()) {
                this.jComboBox_Universidad.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
        }
    }
    
    public void cargar_equipo(){
        
        try {
            this.jComboBox_Equipo.removeAll();
            rs = cn.query(consulta.cargar_equipo());
            while(rs.next()){
                this.jComboBox_Equipo.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
        }
    }
    
    public void cargar_datos(){
        try {
            this.model.setNumRows(0);
            String[] nombreColum = {"DUI", "Nombre", "Posición", "edad", "estatura", "peso", "universidad", "equipo"};
            model.setColumnIdentifiers(nombreColum);
            rs = cn.query(consulta.cargar_jugadores());
            
            String dui, nombre, posicion, universidad, equipo, estatura, peso;
            int edad;
            while (rs.next()) {
                dui = rs.getString("dui");
                nombre = rs.getString("nombre");
                posicion = rs.getString("posicion");
                edad = rs.getInt("edad");
                estatura = rs.getString("estatura");
                peso = rs.getString("peso");
                universidad = rs.getString("universidad");
                equipo = rs.getString("equipo");
                
                model.addRow(new Object[]{dui, nombre, posicion, edad, estatura ,peso, universidad, equipo});
            }
            this.jTable1.setModel(model);
            this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTable1.setFillsViewportHeight(true);
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void filtro_equipo() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ResultSet rsa;
        try {
            conexion conex = new conexion();
            this.model.setNumRows(0);
            String[] nombreColum = {"DUI", "Nombre", "Posición", "edad", "estatura", "peso", "universidad", "equipo"};
            model.setColumnIdentifiers(nombreColum);
            rsa = conex.query(consulta.filtro_equipo(g_codigo));
            
            String dui, nombre, posicion, universidad, equipo, estatura, peso;
            int edad;
            while (rsa.next()) {
                dui = rsa.getString("dui");
                nombre = rsa.getString("nombre");
                posicion = rsa.getString("posicion");
                edad = rsa.getInt("edad");
                estatura = rsa.getString("estatura");
                peso = rsa.getString("peso");
                universidad = rsa.getString("universidad");
                equipo = rsa.getString("equipo");
                
                model.addRow(new Object[]{dui, nombre, posicion, edad, estatura ,peso, universidad, equipo});
            }
            this.jTable1.setModel(model);
            this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTable1.setFillsViewportHeight(true);
            this.jComboBox_Equipo.removeAll();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void filtro_Unis() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ResultSet rsa;
        try {
            conexion conex = new conexion();
            this.model.setNumRows(0);
            String[] nombreColum = {"DUI", "Nombre", "Posición", "edad", "estatura", "peso", "universidad", "equipo"};
            model.setColumnIdentifiers(nombreColum);
            rsa = conex.query(consulta.filtro_unv(g_id_universidad));
            
            String dui, nombre, posicion, universidad, equipo, estatura, peso;
            int edad;
            while (rsa.next()) {
                dui = rsa.getString("dui");
                nombre = rsa.getString("nombre");
                posicion = rsa.getString("posicion");
                edad = rsa.getInt("edad");
                estatura = rsa.getString("estatura");
                peso = rsa.getString("peso");
                universidad = rsa.getString("universidad");
                equipo = rsa.getString("equipo");
                
                model.addRow(new Object[]{dui, nombre, posicion, edad, estatura ,peso, universidad, equipo});
            }
            this.jTable1.setModel(model);
            this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTable1.setFillsViewportHeight(true);
            this.jComboBox_Equipo.removeAll();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void filtro_univer() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ResultSet rsa;
        try {
            conexion conex = new conexion();
            this.model.setNumRows(0);
            String[] nombreColum = {"DUI", "Nombre", "Posición", "edad", "estatura", "peso", "universidad", "equipo"};
            model.setColumnIdentifiers(nombreColum);
            rsa = conex.query(consulta.filtro_unv(g_id_universidad));
            
            String dui, nombre, posicion, universidad, equipo;
            int edad;
            double estatura, peso;
            while (rsa.next()) {
                dui = rsa.getString("dui");
                nombre = rsa.getString("nombre");
                posicion = rsa.getString("posicion");
                edad = rsa.getInt("edad");
                estatura = rsa.getDouble("estatura");
                peso = rsa.getDouble("peso");
                universidad = rsa.getString("universidad");
                equipo = rsa.getString("equipo");
                
                model.addRow(new Object[]{dui, nombre, posicion, edad, estatura ,peso, universidad, equipo});
            }
            this.jTable1.setModel(model);
            this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTable1.setFillsViewportHeight(true);
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void cant_jugador() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        cant_jg = 0;
        ResultSet rsa;
        try {
            conexion conex = new conexion();
            rsa = conex.query(consulta.cant_jugadores_equ(g_codigo));
            rsa.next();
            this.jTextField_cant_jugador.setText(rsa.getString("conteo"));
            cant_jg = Integer.parseInt(rsa.getString("conteo"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    
    public int posicione_free(String pos) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        int conteo = 0;
        ResultSet rsa;
        try {
            conexion conex = new conexion();
            rsa = conex.query(consulta.filtro_posi(pos, this.g_codigo));
            rsa.next();
            conteo = rsa.getInt("conteo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return conteo;
    }
    
    public void limpiar(){
        this.jFormattedTextField1.setText("");
        this.jTextField_nombre.setText("");
        this.jTextField_Edad.setText("");
        this.jTextField_Estatura.setText("");
        this.jTextField_peso.setText("");
        this.jFormattedTextField1.setEditable(true);
        this.jButton_agregar.setEnabled(true);
    }
    
    public ArrayList<String> dui_jugador() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ArrayList <String> ldui =  new ArrayList<>();
        String dui = "";
        ResultSet rs = null;
        try {
            conexion conex = new conexion();
            rs = conex.query(consulta.get_dui(this.jComboBox_pos.getSelectedItem().toString(), g_codigo));
            while (rs.next()){
                dui = rs.getString("dui");
                ldui.add(dui);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ldui;
    }
    //cod para modificar======================================================================================
//   
            
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtIdUni = new javax.swing.JTextField();
        jButton_limpiar = new javax.swing.JButton();
        jButton_filtrar = new javax.swing.JButton();
        jbFiltrarPorUnis = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_cant_jugador = new javax.swing.JTextField();
        jButton_agregar = new javax.swing.JButton();
        jButton_modi = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jComboBox_Universidad = new javax.swing.JComboBox<>();
        jComboBox_Equipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jTextField_nombre = new javax.swing.JTextField();
        jTextField_Edad = new javax.swing.JTextField();
        jTextField_Estatura = new javax.swing.JTextField();
        jTextField_peso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_pos = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Jugador");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton_limpiar.setBackground(new java.awt.Color(153, 0, 51));
        jButton_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_limpiar.setText("Limpiar");
        jButton_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limpiarActionPerformed(evt);
            }
        });

        jButton_filtrar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_filtrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_filtrar.setText("Filtrar por equipo");
        jButton_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_filtrarActionPerformed(evt);
            }
        });

        jbFiltrarPorUnis.setBackground(new java.awt.Color(0, 153, 153));
        jbFiltrarPorUnis.setForeground(new java.awt.Color(255, 255, 255));
        jbFiltrarPorUnis.setText("Filtrar por universidad");
        jbFiltrarPorUnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarPorUnisActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Codigo del equipo");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Jugadores");

        jButton_agregar.setBackground(new java.awt.Color(51, 153, 0));
        jButton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_agregar.setText("Agregar");
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });

        jButton_modi.setBackground(new java.awt.Color(51, 0, 153));
        jButton_modi.setForeground(new java.awt.Color(255, 255, 255));
        jButton_modi.setText("Modificar");
        jButton_modi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modiActionPerformed(evt);
            }
        });

        jButton_eliminar.setBackground(new java.awt.Color(153, 0, 0));
        jButton_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        jComboBox_Universidad.setBackground(new java.awt.Color(204, 255, 204));
        jComboBox_Universidad.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_Universidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_UniversidadActionPerformed(evt);
            }
        });

        jComboBox_Equipo.setBackground(new java.awt.Color(204, 255, 204));
        jComboBox_Equipo.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_Equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_EquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_filtrar)
                        .addGap(18, 18, 18)
                        .addComponent(jbFiltrarPorUnis))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox_Universidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox_Equipo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_cant_jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel7)))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(jtIdUni)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_agregar)
                        .addGap(87, 87, 87)
                        .addComponent(jButton_modi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_eliminar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Universidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Equipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_agregar)
                    .addComponent(jButton_modi)
                    .addComponent(jButton_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtIdUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_cant_jugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_limpiar)
                    .addComponent(jbFiltrarPorUnis)
                    .addComponent(jButton_filtrar))
                .addContainerGap())
        );

        jLabel1.setText("DUI:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Posición:");

        jLabel4.setText("Edad:");

        jLabel5.setText("Estatura en metros m:");

        jLabel6.setText("Peso lb:");

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTextField_Estatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_EstaturaActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Ingreso de jugadores");

        jComboBox_pos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BASE", "ESCOLTA", "ALERO", "ALA-PÍVOT", "PÍVOT" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(96, 96, 96))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(72, 72, 72)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_peso)
                            .addComponent(jTextField_Estatura)
                            .addComponent(jTextField_Edad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jTextField_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox_pos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 339, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(321, 321, 321))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel2)
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Estatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_UniversidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_UniversidadActionPerformed
        String data = (String) this.jComboBox_Universidad.getSelectedItem();
        int index = this.jComboBox_Universidad.getSelectedIndex();
        ResultSet rs = null;
        try {
            rs = cn.query(consulta.mostrar_universidad());
//            String nombre;
            int id_universidad = 0;
            for (int i = 0; i < index+1; i++) {
                rs.next();
                id_universidad = rs.getInt("id_universidad");
//                nombre = rs.getString("nombre");
            }
            this.g_id_universidad = id_universidad;
//            this.jtIdUni.setText(""+id_universidad);
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jComboBox_UniversidadActionPerformed

    private void jTextField_EstaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_EstaturaActionPerformed
        
    }//GEN-LAST:event_jTextField_EstaturaActionPerformed

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        if (cant_jg < 16) {
            if (this.jFormattedTextField1.getText().trim().length() == 1 || this.jTextField_nombre.getText().trim().equals("")||
                this.jTextField_Edad.getText().trim().equals("") || this.jTextField_Estatura.getText().trim().equals("")  ||
                this.jTextField_peso.getText().trim().equals("")){
                
                JOptionPane.showMessageDialog(null, "Error!Debe llenar todos los campos");
            }
            else{
                if (this.jComboBox_pos.getSelectedItem().toString().equals("BASE")) {
                    
                    int band_base = 1;
                    try {
                        if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 1) {
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText().trim());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();

                            estatura = estatura+" m";
                            peso = peso+" lb";
                            String sqlInsert = consulta.agg_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);

                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                this.cant_jugador();

                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InstantiationException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "La posición BASE (BA) esta llena");
                        }                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }  
                }
                
                else if(this.jComboBox_pos.getSelectedItem().toString().equals("ESCOLTA")){
                    int band_escol = 2;
                    try {
                        if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 2) {
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText().trim());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();

                            estatura = estatura+" m";
                            peso = peso+" lb";
                            String sqlInsert = consulta.agg_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);

                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                this.cant_jugador();

                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InstantiationException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "La posición ESCOLTA (E) esta llena");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }
                
                }
                else if(this.jComboBox_pos.getSelectedItem().toString().equals("ALERO")){
                    int band_alero = 4;
                    try {
                        if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 3) {
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText().trim());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();

                            estatura = estatura+" m";
                            peso = peso+" lb";
                            String sqlInsert = consulta.agg_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);

                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                this.cant_jugador();

                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InstantiationException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "La posición ALERO (SF) esta llena");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }
                }
                
                else if(this.jComboBox_pos.getSelectedItem().toString().equals("ALA-PÍVOT")){
                    int band_ala = 5;
                    try {
                        if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 4) {
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText().trim());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();

                            estatura = estatura+" m";
                            peso = peso+" lb";
                            String sqlInsert = consulta.agg_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);

                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                this.cant_jugador();

                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InstantiationException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "La posición ALA-PÍVOT (AP) esta llena");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }
                }
                else if(this.jComboBox_pos.getSelectedItem().toString().equals("PÍVOT")){
                    int band_pivot = 6;
                    try {
                        if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 5) {
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText().trim());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();

                            estatura = estatura+" m";
                            peso = peso+" lb";
                            String sqlInsert = consulta.agg_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);

                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                this.cant_jugador();

                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InstantiationException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "La posición PÍVOT (C) esta llena");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Error! El equipo está lleno");
        }
        this.limpiar();
    }//GEN-LAST:event_jButton_agregarActionPerformed

    private void jButton_modiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modiActionPerformed
//        try {       
//            this.jTextField1.setText(this.dui_jugador().get(1));
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String mensaje_actu = "";
        if (this.jTextField_nombre.getText().trim().equals("") || this.jTextField_Edad.getText().trim().equals("") || 
            this.jTextField_Estatura.getText().trim().equals("") || this.jTextField_peso.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Error!Debe llenar todos los campos");
        }
        
        else{
            try {
                if(this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) == 1){
                    if(this.dui_jugador().contains(this.jFormattedTextField1.getText())){
                        String dui = this.jFormattedTextField1.getText();
                        String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                        String posicion = this.jComboBox_pos.getSelectedItem().toString();
                        int edad = Integer.parseInt(this.jTextField_Edad.getText());
                        String estatura = this.jTextField_Estatura.getText().trim();
                        String peso = this.jTextField_peso.getText().trim();
                        estatura = estatura+" m";
                        peso = peso+" lb";
                        
                        String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                        try {
                            cn.query_ingreso_actu_elim(sqlInsert);
                            this.cargar_datos();
                            mensaje_actu = "Datos del jugador actualizados.";
                        } catch (SQLException ex) {                            
                            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                        this.cargar_datos();
                        
                    }
                    
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.jComboBox_pos.getSelectedItem().toString().equals("BASE")) {
                int band_base = 1;
                try {
                    
                    if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 1) {
                        
                        String dui = this.jFormattedTextField1.getText();
                        String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                        String posicion = this.jComboBox_pos.getSelectedItem().toString();
                        int edad = Integer.parseInt(this.jTextField_Edad.getText());
                        String estatura = this.jTextField_Estatura.getText().trim();
                        String peso = this.jTextField_peso.getText().trim();
                        estatura = estatura+" m";
                        peso = peso+" lb";

                        String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                        try {
                            cn.query_ingreso_actu_elim(sqlInsert);
                            this.cargar_datos();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                        this.cargar_datos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, mensaje_actu+"\nLa posición BASE (BA) esta llena");
                    }
                } catch (Exception e) {
                }
            }
            else if (this.jComboBox_pos.getSelectedItem().toString().equals("ESCOLTA")){
                int band_escol = 2;
                try {
                    if(this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) == 2){
                        if(this.dui_jugador().contains(this.jFormattedTextField1.getText())){
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();
                            estatura = estatura+" m";
                            peso = peso+" lb";
                            
                            String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                mensaje_actu = "Datos del jugador actualizados.";
                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, ex.toString());
                            }
                            this.cargar_datos();

                        }
                        
                    }
                } catch (ClassNotFoundException ex) {                    
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 2) {
                        
                        String dui = this.jFormattedTextField1.getText();
                        String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                        String posicion = this.jComboBox_pos.getSelectedItem().toString();
                        int edad = Integer.parseInt(this.jTextField_Edad.getText());
                        String estatura = this.jTextField_Estatura.getText().trim();
                        String peso = this.jTextField_peso.getText().trim();
                        estatura = estatura+" m";
                        peso = peso+" lb";

                        String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                        try {
                            cn.query_ingreso_actu_elim(sqlInsert);
                            this.cargar_datos();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                        this.cargar_datos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, mensaje_actu+"\nLa posición ESCOLTA (E) esta llena");
                    }
                } catch (Exception e) {
                }
            }
            else if (this.jComboBox_pos.getSelectedItem().toString().equals("ALERO")){
                int band_alero = 4;
                try {
                    if(this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) == 3){
                        if(this.dui_jugador().contains(this.jFormattedTextField1.getText())){
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();
                            estatura = estatura+" m";
                            peso = peso+" lb";
                            
                            String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                mensaje_actu = "Datos del jugador actualizados.";
                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, ex.toString());
                            }
                            this.cargar_datos();

                        }
                        
                    }
                } catch (ClassNotFoundException ex) {                    
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 3) {
                       
                        String dui = this.jFormattedTextField1.getText();
                        String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                        String posicion = this.jComboBox_pos.getSelectedItem().toString();
                        int edad = Integer.parseInt(this.jTextField_Edad.getText());
                        String estatura = this.jTextField_Estatura.getText().trim();
                        String peso = this.jTextField_peso.getText().trim();
                        estatura = estatura+" m";
                        peso = peso+" lb";

                        String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                        try {
                            cn.query_ingreso_actu_elim(sqlInsert);
                            this.cargar_datos();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                        this.cargar_datos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, mensaje_actu+"\nLa posición ALERO (SF) esta llena");
                    }
                } catch (Exception e) {
                }
            }
            else if (this.jComboBox_pos.getSelectedItem().toString().equals("ALA-PÍVOT")){
                int band_ala = 5;
                try {
                    if(this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) == 4){
                        if(this.dui_jugador().contains(this.jFormattedTextField1.getText())){
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();
                            estatura = estatura+" m";
                            peso = peso+" lb";
                            
                            String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                mensaje_actu = "Datos del jugador actualizados.";
                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, ex.toString());
                            }
                            this.cargar_datos();

                        }
                        
                    }
                } catch (ClassNotFoundException ex) {                    
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 4) {
                        
                        String dui = this.jFormattedTextField1.getText();
                        String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                        String posicion = this.jComboBox_pos.getSelectedItem().toString();
                        int edad = Integer.parseInt(this.jTextField_Edad.getText());
                        String estatura = this.jTextField_Estatura.getText().trim();
                        String peso = this.jTextField_peso.getText().trim();
                        estatura = estatura+" m";
                        peso = peso+" lb";

                        String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                        try {
                            cn.query_ingreso_actu_elim(sqlInsert);
                            this.cargar_datos();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                        this.cargar_datos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, mensaje_actu+"\nLa posición ALA-PÍVOT (AP) esta llena");
                    }
                } catch (Exception e) {
                }
            }   
            else if (this.jComboBox_pos.getSelectedItem().toString().equals("PÍVOT")){
                int band_piv = 6;
                try {
                    if(this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) == 5){
                        if(this.dui_jugador().contains(this.jFormattedTextField1.getText())){
                            String dui = this.jFormattedTextField1.getText();
                            String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                            String posicion = this.jComboBox_pos.getSelectedItem().toString();
                            int edad = Integer.parseInt(this.jTextField_Edad.getText());
                            String estatura = this.jTextField_Estatura.getText().trim();
                            String peso = this.jTextField_peso.getText().trim();
                            estatura = estatura+" m";
                            peso = peso+" lb";
                            
                            String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                            try {
                                cn.query_ingreso_actu_elim(sqlInsert);
                                this.cargar_datos();
                                mensaje_actu = "Datos del jugador actualizados.";
                            } catch (SQLException ex) {
                                Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, ex.toString());
                            }
                            this.cargar_datos();

                        }
                        
                    }
                } catch (ClassNotFoundException ex) {                    
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (this.posicione_free(this.jComboBox_pos.getSelectedItem().toString()) < 5) {
                        
                        String dui = this.jFormattedTextField1.getText();
                        String nombre = this.jTextField_nombre.getText().trim().toUpperCase();
                        String posicion = this.jComboBox_pos.getSelectedItem().toString();
                        int edad = Integer.parseInt(this.jTextField_Edad.getText());
                        String estatura = this.jTextField_Estatura.getText().trim();
                        String peso = this.jTextField_peso.getText().trim();
                        estatura = estatura+" m";
                        peso = peso+" lb";

                        String sqlInsert = consulta.actu_jugador(dui, nombre, posicion, edad, estatura, peso, this.g_id_universidad, this.g_codigo);
                        try {
                            cn.query_ingreso_actu_elim(sqlInsert);
                            this.cargar_datos();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                        this.cargar_datos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, mensaje_actu+"\nLa posición PÍVOT (C) esta llena");
                    }
                } catch (Exception e) {
                }
            }
            
        }
        this.limpiar();
    }//GEN-LAST:event_jButton_modiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.jFormattedTextField1.setEditable(false);
        this.jButton_agregar.setEnabled(false);
        int index = this.jTable1.getSelectedRow();
        this.jFormattedTextField1.setText(((DefaultTableModel)this.jTable1.getModel()).getValueAt(index, 0).toString());
        this.jTextField_nombre.setText(((DefaultTableModel)this.jTable1.getModel()).getValueAt(index, 1).toString());
        //
        this.jComboBox_pos.setSelectedItem(((DefaultTableModel)this.jTable1.getModel()).getValueAt(index, 2).toString());
        //
        this.jTextField_Edad.setText(((DefaultTableModel)this.jTable1.getModel()).getValueAt(index, 3).toString());
        this.jTextField_Estatura.setText(((DefaultTableModel)this.jTable1.getModel()).getValueAt(index, 4).toString());
        this.jTextField_peso.setText(((DefaultTableModel)this.jTable1.getModel()).getValueAt(index, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        String dui = this.jFormattedTextField1.getText();
        String SqlDelete = this.consulta.elim_jugador(dui);
        try {
            cn.query_ingreso_actu_elim(SqlDelete);
            this.cargar_datos();
            this.limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limpiarActionPerformed
        this.limpiar();
        this.cargar_datos();
    }//GEN-LAST:event_jButton_limpiarActionPerformed

    private void jComboBox_EquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_EquipoActionPerformed
        int index = this.jComboBox_Equipo.getSelectedIndex();
        ResultSet rs = null;
        try {
            conexion conex = new conexion();
            rs = conex.query(consulta.equipos());
            int codigo = 0;
            for (int i = 0; i < index+1; i++) {
                rs.next();
                codigo = rs.getInt("codigo");
            }
            this.g_codigo = codigo;
            this.jtIdUni.setText(""+codigo);
            this.cant_jugador();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jComboBox_EquipoActionPerformed

    private void jButton_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_filtrarActionPerformed
        try {
            this.filtro_equipo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_filtrarActionPerformed

    private void jbFiltrarPorUnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarPorUnisActionPerformed
        try {
            this.filtro_Unis();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewJInternalFrame_jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbFiltrarPorUnisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_filtrar;
    private javax.swing.JButton jButton_limpiar;
    private javax.swing.JButton jButton_modi;
    private javax.swing.JComboBox<String> jComboBox_Equipo;
    private javax.swing.JComboBox<String> jComboBox_Universidad;
    private javax.swing.JComboBox<String> jComboBox_pos;
    private javax.swing.JFormattedTextField jFormattedTextField1;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_Edad;
    private javax.swing.JTextField jTextField_Estatura;
    private javax.swing.JTextField jTextField_cant_jugador;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_peso;
    private javax.swing.JButton jbFiltrarPorUnis;
    private javax.swing.JTextField jtIdUni;
    // End of variables declaration//GEN-END:variables
}
