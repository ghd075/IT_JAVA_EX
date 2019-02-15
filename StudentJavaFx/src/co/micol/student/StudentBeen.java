package co.micol.student;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 학생 모델 클래스
 *
 */

public class StudentBeen {
	private StringProperty sId;
	private StringProperty sName;
	private StringProperty sAddr;
	private StringProperty sTel;
	
	 /**
     * 디폴트 생성자
     */
	
	public StudentBeen() {
		this(null,null,null,null);
	}
	
	 /**
     * 데이터를 초기화하는 생성자
     *
     * @param sId
     * @param sName
     */
	
	public StudentBeen(String sId, String sName, String sAddr, String sTel) {
		this.sId = new SimpleStringProperty(sId);
		this.sName = new SimpleStringProperty(sName);
		this.sAddr = new SimpleStringProperty(sAddr);
		this.sTel = new SimpleStringProperty(sTel);
	}

	public String getsId() {
		return sId.get();
	}
	
	public void setsId(String sId) {
		this.sId.set(sId);;
	}
	
	public StringProperty sIdProperty() {
		return sId;
	}

	public String getsName() {
		return sName.get();
	}
	
	public void setsName(String sName) {
		this.sName.set(sName);;
	}
	
	public StringProperty sNameProperty() {
		return sName;
	}

	public String getsAddr() {
		return sAddr.get();
	}
	
	public void setsAddr(String sAddr) {
		this.sAddr.set(sAddr);
	}
	
	public  StringProperty sAddrProperty() {
		return sAddr;
	}

	public String getsTel() {
		return sTel.get();
	}

	public void setsTel(String sTel) {
		this.sTel.set(sTel);
	}
	
	public StringProperty sTelProperty() {
		return sTel;
	}
}
