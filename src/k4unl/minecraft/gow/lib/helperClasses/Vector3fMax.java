package k4unl.minecraft.gow.lib.helperClasses;

public class Vector3fMax {

	private float xMin;
	private float xMax;
	
	private float yMin;
	private float yMax;
	
	private float zMin;
	private float zMax;
	
	public Vector3fMax(float _xMin, float _xMax, float _yMin, float _yMax, float _zMin, float _zMax){
		xMin = _xMin;
		xMax = _xMax;
		
		yMin = _yMin;
		yMax = _yMax;
		
		zMin = _zMin;
		zMax = _zMax;
	}
	
	public float getXMin(){
		return xMin;
	}
	
	public float getXMax(){
		return xMax;
	}
	
	public float getYMin(){
		return yMin;
	}
	
	public float getYMax(){
		return yMax;
	}
	
	public float getZMin(){
		return zMin;
	}
	
	public float getZMax(){
		return zMax;
	}
}

