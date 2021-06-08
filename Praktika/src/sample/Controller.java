package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField vvodIndexa;

    @FXML
    private Button stepPoisk;

    @FXML
    void Show_Message(ActionEvent event) {
        int s = Integer.parseInt(vvodIndexa.getText());
        String result = until;
        JOptionPane.showMessageDialog(null,result);
    }





    @FXML
    void initialize() {
        public static void main(String[] args) throws FileNotFoundException, IOException {
            String searchWord = "ходил"; // слово заменить на нужное
            FileInputStream fis = new FileInputStream(new File("E:/1.txt")); // путь заменить на нужный
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();
            String[] lines = new String(content, "Cp1251").split("\n"); // кодировку указать нужную
            int i = 1;
            for (String line : lines) {
                String[] words = line.split(" ");
                int j = 1;
                for (String word : words) {
                    if (word.equalsIgnoreCase(searchWord)) {
                        System.out.println("Найдено в " + i + "-й строке, " + j + "-е слово");
                    }
                    j++;
                }
                i++;
            }
        }
        return until;




    }
}
