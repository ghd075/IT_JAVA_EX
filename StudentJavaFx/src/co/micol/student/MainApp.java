package co.micol.student;

import java.io.IOException;

import co.micol.student.view.StudentEditDialogController;
import co.micol.student.view.StudentNewDialogController;
import co.micol.student.view.StudentView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	/**
	 * 학생에 대한 observable 리스트
	 */
	private ObservableList<StudentBeen> studentData = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("학생관리 시스템");
		this.primaryStage.setResizable(false);
		this.primaryStage.getIcons().add(new Image("file:resources/images/student_manager.png"));

		initRootLayout();
		showStudentOverview();
	}

	/**
	 * 상위 레이아웃을 초기화한다.
	 */
	public void initRootLayout() {
		try {
			// fxml 파일에서 상위 레이아웃을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// 상위 레이아웃을 포함하는 scene을 보여준다.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 상위 레이아웃 안에 학생 요약(student overview)을 보여준다.
	 */
	public void showStudentOverview() {
		try {
			// 학생 요약을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/form.fxml"));
			AnchorPane StudentOverview = (AnchorPane) loader.load();

			// 학생 요약을 상위 레이아웃 가운데로 설정한다.
			rootLayout.setCenter(StudentOverview);

			// 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
			StudentView controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * student의 자세한 정보를 변경하기 위해 다이얼로그를 연다. 만일 사용자가 OK를 클릭하면 주어진 Student에 내용을 저장한 후
	 * true를 반환한다.
	 *
	 * @param person the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showStudentNewDialog(StudentBeen student) {
		try {
			// fxml 파일을 로드하고 나서 새로운 스테이지를 만든다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/StudentNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// 다이얼로그 스테이지를 만든다.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Student");
			dialogStage.setResizable(false);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// student을 컨트롤러에 설정한다.
			StudentNewDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setStudent(student);
			
			//아이콘 설정
			dialogStage.getIcons().add(new Image("file:resources/images/add.png"));

			// 다이얼로그를 보여주고 사용자가 닫을 때까지 기다린다.
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * student의 자세한 정보를 변경하기 위해 다이얼로그를 연다. 만일 사용자가 OK를 클릭하면 주어진 Student에 내용을 저장한 후
	 * true를 반환한다.
	 *
	 * @param person the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showStudentEditDialog(StudentBeen student) {
		try {
			// fxml 파일을 로드하고 나서 새로운 스테이지를 만든다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/StudentEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// 다이얼로그 스테이지를 만든다.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Student");
			dialogStage.setResizable(false);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// student을 컨트롤러에 설정한다.
			StudentEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setStudent(student);

			//아이콘 설정
			dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
			
			// 다이얼로그를 보여주고 사용자가 닫을 때까지 기다린다.
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 생성자
	 */
	public MainApp() {
		// studentSelect 호출해서 데이터 불러오기
		StudentSelect studentSelect = new StudentSelect();
		studentData = studentSelect.selectPerson();
	}

	/**
	 * 학생에 대한 observable 리스트를 반환한다.
	 * 
	 * @return
	 */
	public ObservableList<StudentBeen> getStudentData() {
		return studentData;
	}

	/**
	 * 메인 스테이지를 반환한다.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
