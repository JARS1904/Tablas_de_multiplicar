package TablasDeMulttiplicar;

import javax.swing.*;
import java.awt.event.*;

public class TablasTexArea extends JFrame{
    private JLabel lblTablas;
    private JTextArea txtArea;
    private JTextField txtTexto;
    private JButton btnEnviar;
    private JButton btnLimpiar;
    private JButton btnCerrar;
    private JPanel panelMain;

    private TablasTexArea() {
        setContentPane(panelMain);

        // Para cuando se presiona el boton Enviar con el mouse
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnviarMensaje();

            }
        });

        // Para cuando se presiona el boton Limpiar con el mouse
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.setText(null);
                txtTexto.setText(null);
                txtTexto.requestFocus();
            }
        });

        // Para cuando se presiona el boton Cerrar con el mouse
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        /*
        *Para obtener el numero en string del TextField,
        *volverlo un entero y mostrar la tabla multiplicar
        * del numero castadeao de string a int
        */
        txtTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entrada = txtTexto.getText();
                int numero = Integer.parseInt(entrada);
                tablaMultiplicar(numero);
            }
        });

        /*
        * Para cuando se quiere usar la tecla ENTER del teclado
        * agregara el texto al TextArea y borrara el texto del
        * JTextFild
        * */
        btnEnviar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                EnviarMensaje();
                txtTexto.setText(null);
                txtTexto.requestFocus();
            }
        });

        /*
        * Esto valida si se presiono la teclka enter, para
        * redirigir el foco del TextField al JButton
        * */
        txtTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnEnviar.requestFocus();
                }
            }
        });
    }

    // Metodo para calcular la tabla de multiplicar
    private void tablaMultiplicar(int numero) {
        txtArea.setText("Tabla del " + numero + "\n");
        for (int i=1; i <=10; i++) {
            int resultado = numero * i;
            txtArea.append(numero + " x " + i + " = " + resultado + "\n");
        }
    }

    // Para enviar el texto al TextArea
    private void EnviarMensaje() {
        txtArea.append(txtTexto.getText() + "\n");
    }

    // Metodo principal
    public static void main(String[] args) {
        TablasTexArea tablas = new TablasTexArea();
        tablas.setTitle("GUI en IJ");
        tablas.setSize(500, 500);
        tablas.setVisible(true);
        tablas.setLocationRelativeTo(null);
        tablas.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
