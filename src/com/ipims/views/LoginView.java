package com.ipims.views;


import com.ipims.usersession.LoginViewController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class LoginView extends BaseView {

	public void createLoginView(LoginViewController parentController) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Login");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);

		// Create Login Button

		Button loginBtn = new Button("Login");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(loginBtn);
		grid.add(hbBtn, 1, 4);

		// Create New User Button

		Button btn2 = new Button("New User");
		HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn2.getChildren().add(btn2);
		grid.add(hbBtn2, 1, 5);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		//If login button is pressed

		loginBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				//parentController.handleLoginButtonClick("Asd","asd");
				
				System.out.println(userTextField.getText()); // for testing
				System.out.println(pwBox.getText()); // for testing
				parentController.handleLoginButtonClick(userTextField.getText(), pwBox.getText());

			}
		});

		//If New User button is pressed
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				parentController.handleNewUserButtonClick();

			}
		});


		currentScene = new Scene(grid, 300, 275);
		
	
	}
}
