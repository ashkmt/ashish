package pojo;

import java.util.List;

public class ForecastData {

	private int cnt;
	private int cod;
	private String message;
	private List<DominentCond> list;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<DominentCond> getList() {
		return list;
	}
	public void setList(List<DominentCond> list) {
		this.list = list;
	}
	public ForecastData () {
		
	}
	public ForecastData(List<DominentCond> list, int cnt, int cod, String message) {
		this.list = list;
		this.message = message;
		this.cnt=cnt;
		this.cod=cod;
	}
}
