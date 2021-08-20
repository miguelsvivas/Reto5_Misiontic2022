package utp.misiontic2022.c2.p21.reto4.vista;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import utp.misiontic2022.c2.p21.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_3;

public class VistaTabla  extends JFrame{

    private ControladorRequerimientos controlador;

    private JTable tabla; 

    public VistaTabla(){
        initUI();
        setLocationRelativeTo(null);
        controlador = new ControladorRequerimientos();
    }

    private void initUI(){
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

        var tbd =new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Consulta 1", panel);




        var panelEntrada = new JPanel();

        

        var btnConsulta = new JButton("Consultar requerimiento 1 ");
        var btnConsulta2 = new JButton("Consultar requerimiento 2 ");
        var btnConsulta3 = new JButton("Consultar requerimiento 3 ");
        btnConsulta.addActionListener(e -> cargarTablaConsulta());
        btnConsulta2.addActionListener(e -> cargarTablaConsulta2());
        btnConsulta3.addActionListener(e -> cargarTablaConsulta3());
        

        panelEntrada.add(btnConsulta);
        panelEntrada.add(btnConsulta2);
        panelEntrada.add(btnConsulta3);
        



        panel.add(panelEntrada, BorderLayout.PAGE_START);

        //Tabla
        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void cargarTablaConsulta() {
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel = new Requerimiento1TableModel();
            tableModel.setData(lista);
            tabla.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void cargarTablaConsulta2() {
        try {
            var lista = controlador.consultarRequerimiento2();
            var tableModel2 = new Requerimiento2TableModel();
            tableModel2.setData(lista);
            tabla.setModel(tableModel2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTablaConsulta3() {
        try {
            var lista = controlador.consultarRequerimiento3();
            var tableModel3 = new Requerimiento3TableModel();
            tableModel3.setData(lista);
            tabla.setModel(tableModel3);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }


    private class Requerimiento1TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_1> data;//lista de datos rq 1

        public void setData(ArrayList<Requerimiento_1> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {//Agregar nombres a las columnas
            switch (column) {
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio Unidad";
                // case 2:
                //     return "Importado";
                // case 3:
                    
                // case 4:
                //     return "Cantidad";                   
                    
            }
            
            return super.getColumnName(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Integer.class;                   
                    
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() { //Numero de filas
            return data.size();            
        }

        @Override
        public int getColumnCount() { //Numero de columnas
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registros = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registros.getNombreMaterial();
                    
                case 1:
                    return registros.getPrecioUnidad();
                // case 2:
                //     return registros.getImportado();
                // case 3:
                //     return registros.getPrecioUnidad();
                // case 4:
                //     return registros.getCantidad();                   
                    
            }

            return null;
        }
        
    }

    private class Requerimiento2TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_2> data;//lista de datos rq 2

        public void setData(ArrayList<Requerimiento_2> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {//Agregar nombres a las columnas
            switch (column) {
                case 0:
                    return "Constructora";
                case 1:
                    return "Ciudad";
                // case 2:
                //     return "Importado";
                // case 3:
                    
                // case 4:
                //     return "Cantidad";                   
                    
            }
            
            return super.getColumnName(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Integer.class;                   
                    
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() { //Numero de filas
            return data.size();            
        }

        @Override
        public int getColumnCount() { //Numero de columnas
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registros = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registros.getConstructora();
                    
                case 1:
                    return registros.getCiudad();
                // case 2:
                //     return registros.getImportado();
                // case 3:
                //     return registros.getPrecioUnidad();
                // case 4:
                //     return registros.getCantidad();                   
                    
            }

            return null;
        }
        
    }

    private class Requerimiento3TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_3> data;//lista de datos rq 1

        public void setData(ArrayList<Requerimiento_3> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {//Agregar nombres a las columnas
            switch (column) {
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio Unidad";
                 case 2:
                     return "Importado";
                 case 3:
                    return "precio";
                 case 4:
                     return "Cantidad";                   
                    
            }
            
            return super.getColumnName(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Integer.class;                   
                    
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() { //Numero de filas
            return data.size();            
        }

        @Override
        public int getColumnCount() { //Numero de columnas
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registros = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registros.getProveedor();
                    
                case 1:
                    return registros.getNombreMaterial();
                 case 2:
                     return registros.getImportado();
                 case 3:
                     return registros.getPrecioUnidad();
                 case 4:
                     return registros.getCantidad();                   
                    
            }

            return null;
        }
        
    }


    
}
