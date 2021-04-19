package org.unipampa.edu.br;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FeedBackController implements Initializable {

    Stage dialogStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void timeFeedBack(){
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dialogStage.close();
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
