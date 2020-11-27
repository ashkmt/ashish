package pojo;

public class DominentCond {



	private wind wn = new wind();
	
	public DominentCond(wind win) {
		this.wn = win;
	
	}

	public wind getWn() {
		return wn;
	}

	public void setWn(wind wn) {
		this.wn = wn;
	}
	
	public boolean equals(Object obj) {
		wind wind = (wind) obj;
		if(this.wn.equals(wind))
			return true;
		else
			return false;
	}
}
