package TablasDeMultiplicar2;

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
        pack();
        txtTexto.requestFocus();

        // Para cuando se presiona el boton Enviar con el mouse
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EnviarMensaje();
                tablaMultiplicar();
                txtTexto.setText(null);
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
                tablaMultiplicar();
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

    // Metodo para ingresar rangos
    private void tablaMultiplicar() {
        int j, i, multiplicacion = 0;

        String rangoStr = txtTexto.getText();
        String[] rangos = rangoStr.split("-");

        if (rangos.length == 2) {
            try{

                int inicio = Integer.parseInt(rangos[0]);
                int fin = Integer.parseInt(rangos[1]);

                if (fin < 10){
                    txtArea.setText("");
                    for (i = 1; i <= 10; i++) {
                        for (j = inicio; j <= fin; j++) {
                            multiplicacion = j * i;
                            txtArea.append(String.format("%d x %d = %d\t\t", j, i, multiplicacion));
                        }
                        txtArea.append("\n");
                    }
                }else{
                    txtArea.setText("");
                    for (j = inicio; j <= fin; j++) {
                        for (i = 1; i <= 5; i++) {
                            multiplicacion = i * j;
                            txtArea.append(String.format("%d x %d = %d\t\t", i, j, multiplicacion));
                        }
                        txtArea.append("\n");
                    }
                    txtArea.append("\n");
                    for (j = inicio; j <= fin; j++) {
                        for (i = 6; i <= 10; i++) {
                            multiplicacion = i * j;
                            txtArea.append(String.format("%d x %d = %d\t\t", i, j, multiplicacion));
                        }
                        txtArea.append("\n");
                    }
                }
            }catch (NumberFormatException e) {
                txtArea.setText("Ingresa un rango valido (ejemplo 1-10)");
                txtTexto.setText(null);
                txtTexto.requestFocus();
            }
        } else if (rangos.length == 1){
            try {
                int inicio = Integer.parseInt(rangos[0]);
                int fin = Integer.parseInt(rangos[0]);

                txtArea.setText("");

                for (i = 1; i <= 10; i++) {
                    for ( j = inicio; j <= fin; j++) {
                        multiplicacion = j * i;
                        txtArea.append(String.format("%d x %d = %d\t\t", j, i, multiplicacion));
                    }
                    txtArea.append("\n");
                }
                txtArea.append("\n");

            } catch (NumberFormatException e) {
                txtArea.setText("Ingresa un rango valido");
                txtTexto.setText(null);
                txtTexto.requestFocus();
            }
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
