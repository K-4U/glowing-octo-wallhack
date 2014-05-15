package k4unl.minecraft.gow.lib.helperClasses;


public class Vector3fMax {

	private float xMin;
	private float xMax;
	
	private float yMin;
	private float yMax;
	
	private float zMin;
	private float zMax;
	
	public Vector3fMax(float _xMin, float _yMin, float _zMin, float _xMax, float _yMax, float _zMax){
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
	
	public void setXMin(float _x){
		xMin = _x;
	}
	
	public void setXMax(float _x){
		xMax = _x;
	}
	
	public void setYMin(float _y){
		yMin = _y;
	}
	
	public void setYMax(float _y){
		yMax = _y;
	}
	
	public void setZMin(float _z){
		zMin = _z;
	}
	
	public void setZMax(float _z){
		zMax = _z;
	}
}

