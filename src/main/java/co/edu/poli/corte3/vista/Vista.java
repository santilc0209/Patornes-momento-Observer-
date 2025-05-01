package co.edu.poli.corte3.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import co.edu.poli.corte3.modelo.Producto;
import co.edu.poli.corte3.modelo.Observer;

public class Vista extends JFrame implements Observer {
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnDeshacer;
    private JList<Producto> listaProductos;
    private DefaultListModel<Producto> listModel;

    public Vista() {
        setTitle("Gestión de Productos - Patrón Memento y Observer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(2, 2));
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelCampos.add(txtPrecio);

        add(panelCampos, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        listaProductos = new JList<>(listModel);
        add(new JScrollPane(listaProductos), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar Producto");
        btnModificar = new JButton("Modificar Producto");
        btnDeshacer = new JButton("Deshacer Cambios");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnDeshacer);

        add(panelBotones, BorderLayout.SOUTH);
    }

    public String getNombreProducto() {
        return txtNombre.getText().trim();
    }

    public double getPrecioProducto() {
        try {
            return Double.parseDouble(txtPrecio.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void actualizarLista(List<Producto> productos) {
        listModel.clear();  // Limpiar la lista antes de agregar los nuevos productos
        for (Producto p : productos) {
            listModel.addElement(p);  // Añadir cada producto a la lista
        }
    }

    public int getProductoSeleccionadoIndex() {
        return listaProductos.getSelectedIndex();
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnDeshacer() {
        return btnDeshacer;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void actualizar() {
        List<Producto> productosList = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            productosList.add(listModel.getElementAt(i));
        }
        actualizarLista(productosList);  // Actualiza la lista con los productos del modelo
    }
}
