package co.micol.student.view;

import co.micol.student.MainApp;
import co.micol.student.StudentBeen;
import co.micol.student.StudentDelect;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class StudentView {
	@FXML
	private TableView<StudentBeen> studentTable;
	@FXML
	private TableColumn<StudentBeen, String> studentIdColumn;
	@FXML
	private TableColumn<StudentBeen, String> studentNameColumn;

	@FXML
	private Label studentIdLabel;
	@FXML
	private Label studentNameLabel;
	@FXML
	private Label studentAddLabel;
	@FXML
	private Label studentTelLable;

	// 메인 애플리케이션 참조
	private MainApp mainApp;
	
	//삭제 클래스 객체 생성
	private StudentDelect delect = new StudentDelect();
	
	/**
	 * 생성자. initialize() 메서드 이전에 호출된다.
	 */
	public StudentView() {
	}

	/**
	 * 컨트롤러 클래스를 초기화한다. 
	 * fxml 파일이 로드되고 나서 자동으로 호출된다.
	 */
	@FXML
	private void initialize() {
		// 학생 테이블의 두 열을 초기화한다.
		studentIdColumn.setCellValueFactory(cellData -> cellData.getValue().sIdProperty());
		studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().sNameProperty());
		
		//학생 정보를 지운다.
		showStudentDatails(null);
		
		//선택을 감지하고 그 때마다 학생테이블의 자세한 정보를 보여준다.
		studentTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showStudentDatails(newValue));
	}

	/**
	 * 참조를 다시 유지하기 위해 메인 애플리케이션이 호출한다.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// 테이블에 observable 리스트 데이터를 추가한다.
		studentTable.setItems(mainApp.getStudentData());
	}

	/**
	 * 학생의 자세한 정보를 보여주기 위해 모든 텍스트 필드를 채운다. 만일 student이 null이면 모든 텍스트 필드가 지워진다.
	 */
	private void showStudentDatails(StudentBeen student) {
		if (student != null) {
			// student 객체로 lable에 정보를 채움
			studentIdLabel.setText(student.getsId());
			studentNameLabel.setText(student.getsName());
			studentAddLabel.setText(student.getsAddr());
			studentTelLable.setText(student.getsTel());
		} else {
			// student이 null이면 모든 텍스트를 지움
			studentIdLabel.setText("");
			studentNameLabel.setText("");
			studentAddLabel.setText("");
			studentTelLable.setText("");
		}
	}
	
	/**
	 * 사용자가 삭제 버튼을 클릭하면 호출된다.
	 */
	@FXML
	private void handleDeleteStudent() {
		String sId = studentIdLabel.getText();
	    int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
	    if(selectedIndex >= 0) {
	    	studentTable.getItems().remove(selectedIndex);
	    }else {
	    	Alert alert = new Alert(AlertType.WARNING);
	    	alert.initOwner(mainApp.getPrimaryStage());
	    	alert.setTitle("No Selection");
	    	alert.setHeaderText("학번을 선택하지 않았습니다.");
	    	alert.setContentText("테이블에서 학번을 선택해주세요.");
	    	
	    	alert.showAndWait();
	    }
	   
	    delect.processDao(sId);
	}
	
	/**
	 * 사용자가 new 버튼을 클릭할 때 호출된다.
	 * 새로운 학생 정보를 넣기 위해 다이얼로그를 연다.
	 */
	@FXML
	private void handleNewStudent() {
	    StudentBeen tempStudent = new StudentBeen();
	    boolean okClicked = mainApp.showStudentNewDialog(tempStudent);
	    if (okClicked) {
	        mainApp.getStudentData().add(tempStudent);
	    }
	}
	
	/**
	 * 사용자가 edit 버튼을 클릭할 때 호출된다.
	 * 선택한 학생 정보를 변경하기 위해 다이얼로그를 연다.
	 */
	@FXML
	private void handleEditStudent() {
	    StudentBeen selectedStudent = studentTable.getSelectionModel().getSelectedItem();
	    if (selectedStudent != null) {
	        boolean okClicked = mainApp.showStudentEditDialog(selectedStudent);
	        if (okClicked) {
	            showStudentDatails(selectedStudent);
	        }

	    } else {
	        // 아무것도 선택하지 않았다.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
	    }
	}
	
	 /**
     * 사용자가 종료을 클릭하면 호출된다.
     */
    @FXML
    private void handleExit() {
    	Platform.exit();
    }
}
