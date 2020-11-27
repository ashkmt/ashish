package pojo;

public class wind {

	private double speed = 0.0;
	
	private int deg = 0;
	
	public wind() {
		
	}
	public wind(double speed, int deg) {
		this.speed= speed;
		this.deg = deg;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getDeg() {
		return deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}
	public boolean equals(Object obj) {
		wind wind = (wind) obj;
		if(this.speed==wind.speed&&this.deg==wind.deg)
			return true;
		else
			return false;
	}
}
