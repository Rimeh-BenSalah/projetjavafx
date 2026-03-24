package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PromotionController {
    @FXML private Button queenBtn, rookBtn, bishopBtn, knightBtn;
    private String promotionChoice = "Q";

    @FXML public void selectQueen() { promotionChoice="Q"; close(); }
    @FXML public void selectRook() { promotionChoice="R"; close(); }
    @FXML public void selectBishop() { promotionChoice="B"; close(); }
    @FXML public void selectKnight() { promotionChoice="N"; close(); }

    private void close() {
        Stage stage = (Stage) queenBtn.getScene().getWindow();
        stage.close();
    }

    public String getPromotionChoice() { return promotionChoice; }
}