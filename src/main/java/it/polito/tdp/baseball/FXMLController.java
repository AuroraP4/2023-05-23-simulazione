package it.polito.tdp.baseball;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.baseball.model.Grado;
import it.polito.tdp.baseball.model.Model;
import it.polito.tdp.baseball.model.People;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConnesse;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private Button btnDreamTeam;

    @FXML
    private Button btnGradoMassimo;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtYear;

    @FXML
    void doCalcolaConnesse(ActionEvent event) {
    	this.txtResult.appendText("\nCi sono " + this.model.componentiConnesse() +
    			" componenti connesse \n");
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	double salario = 0.0;
    	int anno = 0;
    	try {
    	salario = Double.parseDouble(this.txtSalary.getText())*1000000;
    	anno = Integer.parseInt(this.txtYear.getText()); }
    	catch (NumberFormatException e){ 
    		this.txtResult.setText("Il salario e l'anno devono essere valori numerici");
    		return;
    	}
    	
    	//check sull'anno tra il 1871 e 2019
    	//check sul salario che sia positivo
    	
    	this.model.creaGrafo(anno, salario);
    	this.txtResult.setText("Grafo creato!");
    	this.txtResult.appendText("\nCi sono " + this.model.nVertices() + " vertici\n");
    	this.txtResult.appendText("Ci sono " + this.model.nArchi() + " archi\n");
    	
      	this.btnGradoMassimo.setDisable(false);
    	this.btnConnesse.setDisable(false);
    	this.btnDreamTeam.setDisable(false);
    }
    

    
    @FXML
    void doDreamTeam(ActionEvent event) {
    	int anno = 0;
    	try {
    	anno = Integer.parseInt(this.txtYear.getText()); }
    	catch (NumberFormatException e){ 
    		this.txtResult.setText("L'anno deve essere un valor numerico");
    		return;
    	}
    	this.model.calcolaDreamTeam(Integer.parseInt(this.txtYear.getText()));
    	this.txtResult.appendText("\nIl dream team ha un salario di " + 
    				this.model.getSalarioDreamTeam());
    	this.txtResult.appendText("\nI giocatori sono \n");
    	List<People> dreamTeam = model.getDreamTeam();
    	for(People p: dreamTeam) {
    		txtResult.appendText(p + "\n");
    	}
    }

   
    @FXML
    void doGradoMassimo(ActionEvent event) {
    	List<Grado> grado = model.gradoMassimo();
    	this.txtResult.appendText("\nI vertici di grado massimo sono \n");
    	for(Grado g: grado ) {
    		this.txtResult.appendText(g.getPlayer() + " " + g.getGrado() + "\n");
    	}
    }

    
    @FXML
    void initialize() {
        assert btnConnesse != null : "fx:id=\"btnConnesse\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDreamTeam != null : "fx:id=\"btnDreamTeam\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnGradoMassimo != null : "fx:id=\"btnGradoMassimo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSalary != null : "fx:id=\"txtSalary\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtYear != null : "fx:id=\"txtYear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
