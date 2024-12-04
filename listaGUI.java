import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listaGUI extends JFrame {
    private lista inventario;
    private JTextArea areaResultados;
    private JTextField campoValor;

    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JButton ordenarButton;

    private JPanel pGeneral;

    public listaGUI() {
        inventario = new lista();
        initComponents();

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    inventario.insertar(valor);
                    actualizarResultado();
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    inventario.eliminar(valor);
                    actualizarResultado();
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    Nodo resultado = inventario.buscar(valor);
                    if (resultado != null) {
                        areaResultados.setText("Objeto encontrado: " + resultado.valor);
                    } else {
                        areaResultados.setText("Objeto no encontrado.");
                    }
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventario.ordenar();
                actualizarResultado();
            }
        });
    }

    private void initComponents() {
        pGeneral = new JPanel();
        pGeneral.setLayout(new BoxLayout(pGeneral, BoxLayout.Y_AXIS));
        pGeneral.setBackground(Color.DARK_GRAY);

        areaResultados = new JTextArea(10, 30);
        areaResultados.setBackground(Color.BLACK);
        areaResultados.setForeground(Color.WHITE);
        areaResultados.setEditable(false);

        campoValor = new JTextField(10);

        agregarButton = new JButton("Agregar");
        eliminarButton = new JButton("Eliminar");
        buscarButton = new JButton("Buscar");
        ordenarButton = new JButton("Ordenar");

        agregarButton.setBackground(Color.GREEN);
        eliminarButton.setBackground(Color.RED);
        buscarButton.setBackground(Color.CYAN);
        ordenarButton.setBackground(Color.ORANGE);

        pGeneral.add(new JLabel("Valor:"));
        pGeneral.add(campoValor);
        pGeneral.add(agregarButton);
        pGeneral.add(eliminarButton);
        pGeneral.add(buscarButton);
        pGeneral.add(ordenarButton);
        pGeneral.add(new JScrollPane(areaResultados));

        setContentPane(pGeneral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void actualizarResultado() {
        areaResultados.setText("Inventario: " + inventario.mostrar());
    }

    public static void main(String[] args) {
        new listaGUI();
    }
}
