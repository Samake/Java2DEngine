package engine.utils;

public class Vector3f {

	public float x;
	public float y;
	public float z;
	
	public Vector3f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void add(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void add(Vector3f vector) {
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
	}
	
	public void sub(float x, float y, float z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
	}
	
	public void sub(Vector3f vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
	}
	
	public void mul(float x, float y, float z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
	}
	
	public void mul(Vector3f vector) {
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
	}
	
	public void div(float x, float y, float z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
	}
	
	public void div(Vector3f vector) {
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
	}
	
	public float distance(float x, float y, float z) {
		float dx = this.x - x;
	    float dy = this.y - y;
	    float dz = this.z - z;
	    
	    return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
	}
	
	public float distance(Vector3f vector) {
		float dx = this.x - vector.x;
	    float dy = this.y - vector.y;
	    float dz = this.z - vector.z;
	    
	    return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
	}
	
	public void cross(float x, float y, float z) {
	    float dx = this.y * z - this.z * y;
	    float dy = this.z * x - this.x * z;
	    float dz = this.x * y - this.y * x;
	    
	    this.x = dx;
	    this.y = dy;
	    this.z = dz;
	}
	
	public void cross(Vector3f vector) {
	    float dx = this.y * vector.z - this.z * vector.y;
	    float dy = this.z * vector.x - this.x * vector.z;
	    float dz = this.x * vector.y - this.y * vector.x;
	    
	    this.x = dx;
	    this.y = dy;
	    this.z = dz;
	}
	
	public void cross(Vector3f vector1, Vector3f vector2) {
		float dx = vector1.y * vector2.z - vector1.z * vector2.y;
	    float dy = vector1.z * vector2.x - vector1.x * vector2.z;
	    float dz = vector1.x * vector2.y - vector1.y * vector2.x;
	    
	    this.x = dx;
	    this.y = dy;
	    this.z = dz;
	}
	
	public float dot(float x, float y, float z) {
		float dx = this.x * x;
	    float dy = this.y * y;
	    float dz = this.z * z;
	    
	    return dx + dy + dz;
	}
	
	public float dot(Vector3f vector) {
		float dx = this.x * vector.x;
	    float dy = this.y * vector.y;
	    float dz = this.z * vector.z;
	    
	    return dx + dy + dz;
	}
	
	public void normalize() {
		float highAmount = this.x;
		
		if (this.y > highAmount) {
			highAmount = this.y;
		}
		
		if (this.z > highAmount) {
			highAmount = this.z;
		}
		
		float value = 1 / highAmount;
		
		this.x = this.x * value;
		this.y = this.y * value;
		this.z = this.z * value;
	}
}
