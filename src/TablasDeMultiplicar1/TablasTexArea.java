package TablasDeMultiplicar1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        pack();
        txtTexto.requestFocus();

        // Para cuando se presiona el boton Enviar con el mouse
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entrada = txtTexto.getText();  // Guarda el contenido del textField

                if (esNumero(entrada)) {
                    txtTexto.setText(null);  // Borra el textField solo si es un número
                } else {
                    EnviarMensaje();  // Muestra el texto en el textArea si no es un número
                    txtTexto.setText(null);
                    txtTexto.requestFocus();
                }
                tablaMultiplicar(entrada);  // Llama a la función
                txtTexto.requestFocus();
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
                tablaMultiplicar(entrada);
                txtTexto.setText(null);
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

    // Método para verificar si la cadena es un número
    private boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Metodo para calcular la tabla de multiplicar
    private void tablaMultiplicar(String entrada) {
        int numero = Integer.parseInt(entrada);

        if (numero >= 1 && numero <= 10) {
            txtArea.append("\nTabla del " + numero + "\n");
            for (int i=1; i <=10; i++) {
                int resultado = numero * i;
                txtArea.append(numero + " x " + i + " = " + resultado + "\n");
            }
            txtArea.append("\n");
            txtTexto.setText(null);
            txtTexto.requestFocus();
        } else {
            txtArea.append(entrada + "\n");
            txtTexto.setText(null);
            txtTexto.requestFocus();
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