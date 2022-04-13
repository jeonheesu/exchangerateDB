package dto;

public class ExDTO {

	private int eNum;
	private String eID;
	private String ePW;
	/**
	 * @return the eNum
	 */
	public int geteNum() {
		return eNum;
	}
	/**
	 * @param eNum the eNum to set
	 */
	public void seteNum(int eNum) {
		this.eNum = eNum;
	}
	/**
	 * @return the eID
	 */
	public String geteID() {
		return eID;
	}
	/**
	 * @param eID the eID to set
	 */
	public void seteID(String eID) {
		this.eID = eID;
	}
	/**
	 * @return the ePW
	 */
	public String getePW() {
		return ePW;
	}
	/**
	 * @param ePW the ePW to set
	 */
	public void setePW(String ePW) {
		this.ePW = ePW;
	}
	@Override
	public String toString() {
		return "ExDTO [eNum=" + eNum + ", eID=" + eID + ", ePW=" + ePW + "]";
	}
	
	
	
}
