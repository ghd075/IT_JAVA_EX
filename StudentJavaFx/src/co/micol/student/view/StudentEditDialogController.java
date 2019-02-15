package co.micol.student.view;

import co.micol.student.StudentBeen;
import co.micol.student.StudentUpdate;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 학생 정보를 변경하는 다이얼로그
 *
 * @author Marco Jakob
 */
public class StudentEditDialogController {
	@FXML
	private TextField sIdField;;
	@FXML
	private TextField sNameField;
	@FXML
	private TextField sAddrField;
	@FXML
	private TextField sTelField;
	
	private Stage dialogStage;
	private StudentBeen student;
	private boolean okClicked = false;
	
	//수정 클래스 객체 생성
	private StudentUpdate update = new StudentUpdate();
	
	public StudentEditDialogController() {
		// TODO Auto-generated constructor stub
	}
	/**
     * 컨트롤러 클래스를 초기화한다.
     * 이 메서드는 fxml 파일이 로드된 후 자동으로 호출된다.
     */
    @FXML
    private void initialize() {
    }
    /**
     * 이 다이얼로그의 스테이지를 설정한다.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * 다이얼로그에서 변경될 학생정보를 설정한다.
     *
     * @param person
     */
    public void setStudent(StudentBeen student) {
    	this.student = student;
    	
    	sIdField.setText(student.getsId());
		sNameField.setText(student.getsName());
		sAddrField.setText(student.getsAddr());
		sTelField.setText(student.getsTel());
    }
    
    /**
     * 사용자가 OK를 클릭하면 true를, 그 외에는 false를 반환한다.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * 사용자가 OK를 클릭하면 호출된다.
     */
    @FXML
    private void handleOk() {
    	student.setsId(sIdField.getText());
		student.setsName(sNameField.getText());
		student.setsAddr(sAddrField.getText());
		student.setsTel(sTelField.getText());
		
	    String sId = sIdField.getText();
	    String sAddr = sAddrField.getText();
	    String sTel = sTelField.getText();
	    
		okClicked = true;
		update.processDao(sId, sAddr, sTel);
		dialogStage.close();
    }
    
    /**
     * 사용자가 cancel을 클릭하면 호출된다.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
