package com.ipims.views;

import com.ipims.MenuViewController;
import com.ipims.models.User;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;


import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class MenuView extends BaseView {


	public void createMenuScene(User user, MenuViewController parentController) {

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(25));
		vbox.setSpacing(8);
		vbox.setAlignment(Pos.CENTER);

		
		Text scenetitle = new Text("Menu");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		vbox.getChildren().add(scenetitle);
		
		//If the passed in user is patient, create the menu for patient.

		Text welcomeTitle = new Text("Welcome User: " + user.getName() + " (" + user.getUserTypeString() + ")");
		welcomeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		vbox.getChildren().add(welcomeTitle);
		
		vbox.getChildren().add(appoinmentButton(parentController));
		vbox.getChildren().add(updateHealthButton(parentController));
		vbox.getChildren().add(generateStatsButton(parentController));
		vbox.getChildren().add(PrescribeMedButton(parentController));
		vbox.getChildren().add(PatientCaseButton(parentController));
		vbox.getChildren().add(LabRecordButton(parentController));
		vbox.getChildren().add(EnterLabRecordButton(parentController));

		vbox.getChildren().add(ViewPatientInfoButton(parentController));
		

//		if (user.getUsertype() == UserType.PATIENT) {
//			
//			Text welcomeTitle = new Text("Welcome User");
//			welcomeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
//			vbox.getChildren().add(welcomeTitle);
//			
//			vbox.getChildren().add(appoinmentButton(parentController));
//			vbox.getChildren().add(updateHealthButton(parentController));
//			vbox.getChildren().add(labRecordButton(parentController));
//			
//			
//			
//
//		} else if (user.getUsertype() == UserType.HSPSTAFF) {
//			
//		}

		vbox.getChildren().add(logoutButton(parentController));
		
		createScene(vbox);
	}

	private Button appoinmentButton(MenuViewController parentController) {
		Button scheduleAppBtn = new Button("Appointments");
		
		scheduleAppBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handleAppointments();

			}
		});
		return scheduleAppBtn;
	}

	private Button updateHealthButton(MenuViewController parentController) {
		Button updateHealthBtn = new Button("Health Condition(s)/Concern(s)");
		updateHealthBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handleHealthCondition();

			}
		});
		return updateHealthBtn;
	}
	
	
	private Button generateStatsButton(MenuViewController parentController) {
		Button btn = new Button("Generate Statistical Reports");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handleGenerateStatsReports();
			}
		});
		return btn;
	}
	
	
	
	
	private Button PrescribeMedButton(MenuViewController parentController) {
		
		Button PrescribeMedBtn = new Button("Prescribe Medication(s)");
		PrescribeMedBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handlePrescribeMed();

			}
		});
		return PrescribeMedBtn;
	}
	
	private Button PatientCaseButton(MenuViewController parentController) {
		
		Button PatientCaseBtn = new Button("View Patient Case");
		PatientCaseBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handlePatientCase();

			}
		});
		return PatientCaseBtn;
	}
	
	
	private Button LabRecordButton(MenuViewController parentController) {
		
		Button LabRecordBtn = new Button("View Lab Record");
		LabRecordBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handleLabRecord();

			}
		});
		return LabRecordBtn;
	}
	
	private Button EnterLabRecordButton(MenuViewController parentController) {
		
		Button EnterLabRecordBtn = new Button("Enter Lab Record");
		EnterLabRecordBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handleEnterLabRecord();

			}
		});
		return EnterLabRecordBtn;
	}


	private Button logoutButton(MenuViewController parentController) {
		Button logoutBtn = new Button("Logout");
		logoutBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handleLogout();

			}
		});
		return logoutBtn;
	}
	
	private Button ViewPatientInfoButton(MenuViewController parentController) {
		Button vpBtn = new Button("View Patient Info");
		vpBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// Pass the control of handling button clicks to the view controller
				parentController.handleViewPatientInfo();
			}
		});
		return vpBtn;
	}
}
