package to.uk.ilexiconn.jurassicraft.data.utility;

public class ControlledParam {

	float value;
	float change;
	float max;
	float min;
	
	public ControlledParam(float value, float change, float max, float min) {
		this.value = value;
		this.change = change;
		this.max = max;
		this.min = min;
	}
	
	public float getValue() {
		return value;
	}
	
	public void update() {
		value += change;
		if (value < min) value = min;
		if (value > max) value = max;
	}
}
