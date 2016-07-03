package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private TextField startNumber;

    @FXML
    private TextField endNumber;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField qty;

    private List<String> mNumberList = new ArrayList<String>();
    private List<String> mNumberNoSpaceList = new ArrayList<String>();
    public String mFileName = "numbers.csv";

    String number="";
    String start="";
    int mStart = 0;


    public void run() {
        startNumber.requestFocus();
    }


    public void noText() {
        if (startNumber.getText().length() < 5) {
            textArea.setText("Please enter a number starting with the 4 digit prefix code...");
        }
    }
//TODO check noQty
    public void noQty() {
        if(Integer.parseInt(qty.getText()) < 1) {
            textArea.setText("OOPS...you forgot to add your quantity");
        }
    }

    public void handleStart(ActionEvent actionEvent) {
        noText();
        noQty();
        mNumberList.clear();
        ModTest modTest = new ModTest(startNumber.getText());
        textArea.setText("");
        textArea.appendText("The FORWARD numbering sequence is: " + "\n\n");
        System.out.printf("The FORWARD numbering sequence is : %n", startNumber.getText());
        for (int number : modTest.forwardCount(Integer.parseInt(qty.getText()))) {
            System.out.println(modTest.getCode() + number + " " +
                    modTest.checkDigit(Integer.toString(number)));
            textArea.appendText(modTest.getCode() + number + " " +
                    modTest.checkDigit(Integer.toString(number)) + "\n");
            mNumberList.add(modTest.getCode() + number + " " +
                    modTest.checkDigit(Integer.toString(number)) +
                "," + modTest.getCode() + number + modTest.checkDigit(Integer.toString(number)));
        }
    }

    public void handleEnd(ActionEvent actionEvent) {
        noText();
        noQty();
        mNumberList.clear();
        ModTest modTest = new ModTest(startNumber.getText());
        textArea.setText("");
        textArea.appendText("The REVERSE numbering sequence is: " + "\n\n");
        System.out.printf("The REVERSE numbering sequence is : %n", startNumber.getText());
        for (int number : modTest.backwardCount(Integer.parseInt(qty.getText()))) {
            System.out.println(modTest.getCode() + number + " " +
                    modTest.checkDigit(Integer.toString(number)));
            textArea.appendText(modTest.getCode() + number + " " +
                    modTest.checkDigit(Integer.toString(number)) + "\n");
            mNumberList.add(modTest.getCode() + number + " " +
                    modTest.checkDigit(Integer.toString(number)) +
                    "," + modTest.getCode() + number + modTest.checkDigit(Integer.toString(number)));
        }
    }

    public void exportTo(String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                PrintWriter writer = new PrintWriter(fos);
        ) {
            for (String n : mNumberList) {
                writer.printf("%s %n", n);

            }
        } catch (IOException ioe) {
            System.out.printf("Problem saving  %s %n", fileName);
            ioe.printStackTrace();
        }
    }

    public void handlePrint(ActionEvent actionEvent) {
//        String userHomeFolder = System.getProperty("user.home");
//        exportTo(userHomeFolder,"numbers.csv");
        exportTo("/Users/brisson22/Desktop/numbers.csv");

    }




}
