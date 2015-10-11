package com.ipims.views;

import com.ipims.healthconditions.HealthViewController;
import com.ipims.models.User;
import com.ipims.models.User.UserType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.Scene;
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


public class HealthView extends BaseView {

	public void createHealthview(User user, HealthViewController parentController) {

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(25));
		vbox.setSpacing(8);

		// Add title and main menu 

		HBox hbox = new HBox();
		hbox.setSpacing(10);

		Text title = new Text("Health");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		hbox.getChildren().add(title);

		Button mainMenuBtn = new Button("Main Menu");
		mainMenuBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				parentController.goBack();


			}
		});
		hbox.getChildren().add(mainMenuBtn);
		vbox.getChildren().add(hbox);

		// Add patient selector if the user is not Patient
		if(user.getUsertype() == UserType.PATIENT) {
			HBox hbox2 = new HBox();
			hbox2.setSpacing(10);

			Label docLabel = new Label("Patient:");

			ComboBox<String> docComboBox = new ComboBox<String>();
			docComboBox.getItems().addAll(
					"cxv",
					"ASD" 
					);

			hbox2.getChildren().addAll(docLabel, docComboBox);
			vbox.getChildren().add(hbox2);
		}

		// Add Medical History box
		vbox.getChildren().add(addMedicalHistory());

		// Add Medical Condition box
		vbox.getChildren().add(addMedicalCondition());

		Text subTitle = new Text("View Health Conditions");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		vbox.getChildren().add(subTitle);

		ListView<String> list = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList (
				"1. (History) Severe Chest Pain");
		list.setItems(items);
		vbox.getChildren().add(list);

		currentScene = new Scene(vbox, 500, 700);
	}

	public VBox addMedicalHistory() {

		VBox baseVbox = new VBox();
		baseVbox.setPadding(new Insets(15));
		baseVbox.setSpacing(8);
		baseVbox.setStyle("-fx-background-color: #336699;");

		Text title = new Text("Medical History");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		title.setFill(Color.WHITE);

		Label conditionLabel = new Label("History:");
		conditionLabel.setTextFill(Color.WHITE);

		ComboBox<String> conditionComboBox = new ComboBox<String>();
		conditionComboBox.getItems().addAll(
				"Chest Pain",
				"Heart Problems",
				"Diabities"
				);

		Label commentsLabel = new Label("Comments:");
		commentsLabel.setTextFill(Color.WHITE);

		TextField commentsTextField = new TextField();

		commentsTextField.setMaxSize(400, 55);


		Button submitBtn = new Button("Submit");
		submitBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller


			}
		});


		baseVbox.getChildren().addAll(title, 
				conditionLabel, 
				conditionComboBox, 
				commentsLabel,
				commentsTextField,
				submitBtn);

		return baseVbox;
	}

	public VBox addMedicalCondition() {

		VBox baseVbox = new VBox();
		baseVbox.setPadding(new Insets(15));
		baseVbox.setSpacing(8);
		baseVbox.setStyle("-fx-background-color: #336699;");

		Text title = new Text("Current Medical Condition");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		title.setFill(Color.WHITE);
		Label conditionLabel = new Label("Condition:");
		conditionLabel.setTextFill(Color.WHITE);

		ComboBox<String> conditionComboBox = new ComboBox<String>();
		conditionComboBox.getItems().addAll(
				"Chest Pain",
				"Heart Problems",
				"Diabities"
				);

		Label commentsLabel = new Label("Comments:");
		commentsLabel.setTextFill(Color.WHITE);

		TextField commentsTextField = new TextField();

		commentsTextField.setMaxSize(400, 55);

		Button submitBtn = new Button("Submit");
		submitBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller


			}
		});
		
		baseVbox.getChildren().addAll(title, 
				conditionLabel, 
				conditionComboBox, 
				commentsLabel, 
				commentsTextField,
				submitBtn);

		return baseVbox;
	}


}