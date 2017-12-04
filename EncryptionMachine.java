/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionmachine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author ericbrigham
 */
public class EncryptionMachine extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       //Naming the application in the top left of the window
       primaryStage.setTitle("Encryption Machine");
       primaryStage.show();
       //creating a GridPane Layout
       GridPane thepane = new GridPane();
       thepane.setAlignment(Pos.CENTER);
       thepane.setHgap(10);
       thepane.setVgap(10); 
       thepane.setPadding(new Insets(25, 25, 25, 25));
         Scene scene = new Scene(thepane, 400, 325);
         
       //Setting up the Title
       Text theTitle = new Text("Caesar Cipher Encryptor");
       theTitle.setFont(Font.font("Times", FontWeight.NORMAL, 14));
       theTitle.setTextAlignment(TextAlignment.CENTER);
            //this centering doesn't work for some reason
       thepane.add(theTitle, 0, 0, 2, 1);
       //Setting up the textboxes 
       //PlainText
       Label plainText = new Label("Plain Text:");
       thepane.add(plainText, 0, 1);
       TextField plainTextField = new TextField();
       thepane.add(plainTextField, 1,1);
       /*CipherText
       Label cipherText = new Label("Cipher Text:");
       thepane.add(cipherText, 0, 4);
       TextField cipherTextField = new TextField();
       thepane.add(cipherTextField, 1,4);
       */
       //Shift
       Label shiftAmount = new Label("Shift By:");
       thepane.add(shiftAmount, 0, 2);
       TextField shiftAmountField = new TextField();
       thepane.add(shiftAmountField, 1,2);
            //stipulate that this must be an integer between 1 and 26
            Text allowedNums = new Text();
            allowedNums.setFont(Font.font("Times", FontWeight.NORMAL, 8));
            allowedNums.setText("Please enter whole numbers between 1 and 26");
            thepane.add(allowedNums, 1,3);
            

       //Add Button to encrypt the text
       Button encryptNow = new Button("Encrypt My Text");        
       HBox box = new HBox(10);
       box.setAlignment(Pos.BOTTOM_CENTER);
       box.getChildren().add(encryptNow);
       thepane.add(box, 1, 5);
       //Final
       final Text cipherText = new Text();
       thepane.add(cipherText, 1, 6);
       
       encryptNow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String enciphered = "";
                String encryptThis = plainTextField.getText();
                int Shift = Integer.parseInt(shiftAmountField.getText());
                int length = encryptThis.length();
                for(int n = 0; n < length; n++){
                    char c = (char)(encryptThis.charAt(n) + Shift);
                    if(c > 'z'){
                        enciphered += (char)(encryptThis.charAt(n) - (26-Shift));
                    }
                    else if(((char)(encryptThis.charAt(n)) == ' ')){
                        enciphered += ' ';
                    }
                    else{
                        enciphered += (char)(encryptThis.charAt(n) + Shift);
                    }
                }
                cipherText.setText("Cipher Text: " + enciphered);
            }
        });
       
       primaryStage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
