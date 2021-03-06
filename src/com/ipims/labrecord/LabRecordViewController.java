package com.ipims.labrecord;

import java.util.ArrayList;
import java.util.List;

import com.ipims.MenuViewController;
import com.ipims.database.DatabaseManager;
import com.ipims.models.LabRecord;
import com.ipims.models.User;
import com.ipims.models.User.UserType;
import com.ipims.usersession.UserSession;
import com.ipims.views.EnterLabRecordView;
import com.ipims.views.LabRecordView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

public class LabRecordViewController {

	private LabRecordView view;
	private LabRecordManager labManager;
	private LabRecord currentlySelectedLab;

	//--------------- View Controller methods ---------------
	//--------------------------------------------------------
	
public  LabRecordViewController() {
	labManager = new LabRecordManager();
	view = new LabRecordView();
	view.createLabRecordView(UserSession.getInstance().getCurrentUser(), this);

}

public Scene getScene() {
	return view.getCurrentScene();
}

	public void goBack() {
		 MenuViewController menu = new MenuViewController();
         view.getStage().setScene(menu.getScene());
         
	}
	
	
	public void didSelectItem(int index, int patientid) {
		
		User user = UserSession.getInstance().getCurrentUser();

		List<LabRecord> list = getListOfLabRecords(patientid);

		
		if (user.getUsertype() == UserType.LABSTAFF || user.getUsertype() == UserType.DOCTOR) {
			
		
		LabRecordView updateView = new LabRecordView();
		currentlySelectedLab = list.get(index);
		updateView.createUpdateLabRecordView(currentlySelectedLab, this);
		view.getStage().setScene(updateView.getCurrentScene());
		view = updateView;
		
	}
	}

	
	public ObservableList<String> getPatientLabRecordList (int patientid) {

		List<LabRecord> LabRecordList = getListOfLabRecords(patientid);
		List<String> stringLabList = new ArrayList<>();
		for (int i = 0; i < LabRecordList.size(); i++) {
			LabRecord lab = LabRecordList.get(i);
			int index = i+1;
			
			
			String str = "Name: "+ DatabaseManager.getInstance().getUser(lab.getPatientId()).getName()+"\nDate: " +lab.getDate() +"\nCalcium: "+ lab.getCalcium()+"\nGlucose: "+ lab.getGlucose()+"\nMagnesium:  "+ lab.getMagnesium()+"\nSodium:  "+ lab.getSodium();
			stringLabList.add(str);
		}
		ObservableList<String> items = FXCollections.observableArrayList (stringLabList);
		return items;
	}

	
	private List<LabRecord>getListOfLabRecords(int patientid) {

		// Pass patientid in order to get all lab records for that patient 
		
		List<LabRecord> LabRecordList = null;
		
			LabRecordList = labManager.getLabRecordsForPatient(patientid);
		
		return LabRecordList;
		
	}

	
	
	public void handleUpdateGoBack() {
		LabRecordView backToAppoinment = new LabRecordView();
		backToAppoinment.createLabRecordView(UserSession.getInstance().getCurrentUser(), this);
		view.getStage().setScene(backToAppoinment.getCurrentScene());
		view = backToAppoinment;
	}
	
	public void handleUpdateClick(LabRecord updatedLabRecord) {
		

		labManager.updateLabRecord(currentlySelectedLab, updatedLabRecord);
		currentlySelectedLab = null;
		handleUpdateGoBack();
		view.showInfo("LabRecord updated.");
		
		
	}
	
	
	public void handleLabRecordDeletion() {
		labManager.deleteLabRecord(currentlySelectedLab);
		currentlySelectedLab = null;
		handleUpdateGoBack();
		view.showInfo("Lab Record cancelled!");
	}


	
	
	
	
}

