package ui;

import java.awt.ScrollPane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;
import model.Partaker;
import model.VolleyballEvent;

public class VolleyballEvent_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField path;

    @FXML
    private Label message;

    @FXML
    private TextField idSpectators;

    @FXML
    private Label spectatorId;

    @FXML
    private Label timeSpectators;

    @FXML
    private TextField idPartaker;

    @FXML
    private Label PartakerId;

    @FXML
    private Label timePartaker;

    @FXML
    private ImageView image;

    @FXML
    private Label data;
    
    @FXML
    private Label id;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label email;

    @FXML
    private Label gender;

    @FXML
    private Label country;

    @FXML
    private Label birthday;
    
    @FXML
    private ScrollPane show;
    
    private VolleyballEvent volleyBallEvent; 
    
 
    private File f;

    @FXML
    void exportFile(ActionEvent event) throws IOException {
    	path.setText("data/MOCK_DATA.csv");
    	
    }

    @FXML
    void loadFile(ActionEvent event){
    	if(f!=null)
    		message.setVisible(true);
    	else {
    		message.setVisible(true);
    		message.setText("Sorry we were unnable to load the new gest(s)");
    	}
    }

    @FXML
    void searchParticipant(ActionEvent event) {
    	long time = System.currentTimeMillis();
    	try {
    		int id = Integer.parseInt(idPartaker.getText());
    		showDataInScreen(volleyBallEvent.searchPartaker(id));
    	}catch (NumberFormatException e) {
    		Alert score = new Alert(AlertType.ERROR);
        	score.setTitle(" IV Copa Panamericana de Voleibol Masculino Sub-21");
        	score.initStyle(StageStyle.DECORATED);
        	score.setContentText("Please introduce a number");
        	score.show();
    	}
    	timePartaker.setText((System.currentTimeMillis()-time)/1000+" segs");
    }

    @FXML
    void searchSpectators(ActionEvent event) {
    	long time = System.currentTimeMillis();
    	try {
    		int id = Integer.parseInt(idSpectators.getText());
    		showDataInScreen(volleyBallEvent.searchSpectator(id));
    	}catch (NumberFormatException e) {
    		Alert score = new Alert(AlertType.ERROR);
        	score.setTitle(" IV Copa Panamericana de Voleibol Masculino Sub-21");
        	score.initStyle(StageStyle.DECORATED);
        	score.setContentText("Please introduce a number");
        	score.show();
    	}
    	
    	timeSpectators.setText((System.currentTimeMillis()-time)/1000+" segs");
    }
    
    public void showDataInScreen(Partaker p) {
    	image.setImage(new Image(p.getPhoto()));
    	id.setText(p.getId()+"");
    	firstName.setText(p.getFirstName());
    	lastName.setText(p.getLastName());
    	email.setText(p.getEmail());
    	gender.setText(p.getGender());
    	country.setText(p.getCountry());
    	birthday.setText(p.getBirthday());
    }
    
    @FXML
    void graphParticipant(ActionEvent event) {
    	System.out.println("");
    }

    public void graph(int n, int y, Partaker p) {
    	System.out.println("");
    }
    
    
    @FXML
    void graphSpectators(ActionEvent event) {
    	System.out.println("");
    }

    @FXML
    void initialize() {
    	volleyBallEvent = new VolleyballEvent();
    	message.setVisible(false);
    }
}