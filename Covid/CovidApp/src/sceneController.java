import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class sceneController extends scrapping {

    @FXML
    private Label new_data;
    @FXML
    private Label date;
    @FXML
    private Label today;
    @FXML
    private Label new_covid;
    @FXML
    private Label covid;
    @FXML
    private Label new_deaths;
    @FXML
    private Label death;
    @FXML
    private Label new_health;
    @FXML
    private Label health;
    @FXML
    private Button button;

    @FXML
    void onSubmitBtnClick(ActionEvent event) throws Exception {
        // txtPol.setText("Do powiedzenia masz: " + txtFld.getText());
        date.setText(scrapping.getData());
        covid.setText(scrapping.getDzisiaj());
        death.setText(scrapping.getZgony());
        health.setText(scrapping.getWyzdrowialo());
    }

}
