import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class VentanaDeError extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaDeError frame = new VentanaDeError("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaDeError(String mensaje) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 188);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(mensaje);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(34, 12, 740, 76);
        contentPane.add(lblNewLabel);

        JButton AceptarError = new JButton("Aceptar");
        AceptarError.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // CERRAR VENTANA AL DARLE ACEPTAR
                dispose();
            }
        });
        AceptarError.setFont(new Font("Tahoma", Font.BOLD, 18));
        AceptarError.setBounds(611, 96, 163, 42);
        AceptarError.setBackground(Color.WHITE);
        AceptarError.setForeground(Color.BLACK);
        AceptarError.setBorder(new LineBorder(Color.BLACK, 2, true));
        contentPane.add(AceptarError);

        contentPane.setBackground(Color.RED); // Cambia el color del fondo de la ventana
    }

}
