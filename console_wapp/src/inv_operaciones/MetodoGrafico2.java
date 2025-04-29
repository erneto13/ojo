package inv_operaciones;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MetodoGrafico2 {

    private JFrame frame;
    private JButton btnCreateLabel;
    private ArrayList<JLabel> labels;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MetodoGrafico2 window = new MetodoGrafico2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MetodoGrafico2() {
        initialize();
        labels = new ArrayList<JLabel>();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        btnCreateLabel = new JButton("Crear Label");
        btnCreateLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel("Nuevo Label");
                frame.getContentPane().add(label);
                frame.getContentPane().validate();
                frame.getContentPane().repaint();
                labels.add(label);
            }
        });
        frame.getContentPane().add(btnCreateLabel);
    }
}
