package com.ipims.views;

import com.ipims.healthconditions.HealthViewController; // should be taken out
import com.ipims.hsp.ViewPatientInfoViewController;
import com.ipims.models.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ViewPatientInfoView extends BaseView {
	public void createViewPatientInfoView(ViewPatientInfoViewController parentController) {			
			
			final Text actionTarget = new Text();
		
			VBox vbox = new VBox();
			vbox.setPadding(new Insets(25));
			vbox.setSpacing(8);

			HBox hbox = new HBox();
			hbox.setSpacing(10);
			
			Label PatientLabel = new Label("Patient:");
			PatientLabel.setTextFill(Color.BLACK);
			PatientLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			
			Label titleLabel = new Label("View Patient Information");
			titleLabel.setTextFill(Color.BLACK);
			titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			
			TextField PatientTextField = new TextField();
			PatientTextField.setMaxSize(250, 55);

			Button mainMenuBtn = new Button("Menu");
			mainMenuBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					parentController.goBack();


				}
			});
			
			Button submitBtn = new Button("Submit");
			submitBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					actionTarget.setFill(Color.GREEN);
					actionTarget.setText("Submit Button Pressed!");
					// send to database
				}
			});
			
			hbox.getChildren().addAll(titleLabel, mainMenuBtn);
			vbox.getChildren().add(hbox);
			
			ListView<String> list = new ListView<String>();
			ObservableList<String> items = FXCollections.observableArrayList (
					"Patient Information goes here!"
				);
		
			
			list.setItems(items); // moved
			
			HBox patientHbox = new HBox();
			patientHbox.setSpacing(10);
			
			patientHbox.getChildren().addAll(PatientLabel, PatientTextField, submitBtn);
			
			vbox.getChildren().add(patientHbox);
			vbox.getChildren().add(list);
			
			Button viewAnotherBtn = new Button("View Another Patient");
			viewAnotherBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					items.clear();
					PatientTextField.clear();
					actionTarget.setFill(Color.GREEN);
					actionTarget.setText("Button pressed! List cleared.");
				}
			});
			
			// to display success or error message
			vbox.getChildren().addAll(viewAnotherBtn, actionTarget);
			
			
			createScene(vbox);

	}

	
}