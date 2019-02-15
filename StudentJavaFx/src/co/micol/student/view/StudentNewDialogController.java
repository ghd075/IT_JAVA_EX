package co.micol.student.view;

import co.micol.student.StudentBeen;
import co.micol.student.StudentInsert;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 학생 정보를 변경하는 다이얼로그
 *
 * @author Marco Jakob
 */
public class StudentNewDialogController {
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
	
	//입력 클래스 객체 생성
	private StudentInsert insert = new StudentInsert();
	
	public StudentNewDialogController() {
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
    	
    	if(isInputValid()) {
    		student.setsId(sIdField.getText());
    		student.setsName(sNameField.getText());
    		student.setsAddr(sAddrField.getText());
    		student.setsTel(sTelField.getText());
    		
    	    String sId = sIdField.getText();
    	    String sName = sNameField.getText();
    	    String sAddr = sAddrField.getText();
    	    String sTel = sTelField.getText();
    		okClicked = true;
    		dialogStage.close();
    		insert.processDao(sId, sName, sAddr, sTel);
    	}
    }
    
    
    /**
     * 사용자가 cancel을 클릭하면 호출된다.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * 텍스트 필드로 사용자 입력을 검사한다.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";
        
        if (sIdField.getText() == null || sIdField.getText().length() == 0) {
            errorMessage += "학번을 입력해주세요.\n";
        }
        if (sNameField.getText() == null || sNameField.getText().length() == 0) {
            errorMessage += "이름을 입력해주세요.\n";
        }
        
        if (sAddrField.getText() == null || sAddrField.getText().length() == 0) {
            errorMessage += "주소를 입력해주세요.\n";
        }
        if (sTelField.getText() == null || sTelField.getText().length() == 0) {
            errorMessage += "전화번호를 입력해주세요.\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // 오류 메시지를 보여준다.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("값을 입력하지 않았습니다.");
            alert.setContentText(errorMessage);

            alert.showAndWait(); //기다려준다.

            return false;
        }
    }

}
