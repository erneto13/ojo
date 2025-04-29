import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AbrirArchivoTexto {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);

        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);

                StringBuilder sb = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    sb.append(linea);
                    sb.append(System.lineSeparator());
                }

                textArea.setText(sb.toString());

                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
