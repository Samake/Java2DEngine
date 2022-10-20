package engine.utils;

public class Vector2f {

	public float x;
	public float y;
	
	public Vector2f() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2f vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	public void add(Vector2f vector) {
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public void sub(float x, float y) {
		this.x -= x;
		this.y -= y;
	}
	
	public void sub(Vector2f vector) {
		this.x -= vector.x;
		this.y -= vector.y;
	}
	
	public void mul(float x, float y) {
		this.x *= x;
		this.y *= y;
	}
	
	public void mul(Vector2f vector) {
		this.x *= vector.x;
		this.y *= vector.y;
	}
	
	public void div(float x, float y) {
		this.x /= x;
		this.y /= y;
	}
	
	public void div(Vector2f vector) {
		this.x /= vector.x;
		this.y /= vector.y;
	}
	
	public float distance(float x, float y) {
		float dx = this.x - x;
	    float dy = this.y - y;
	    return (float) Math.sqrt(dx * dx + dy * dy);
	}
	
	public float distance(Vector2f vector) {
		float dx = this.x - vector.x;
	    float dy = this.y - vector.y;
	    return (float) Math.sqrt(dx * dx + dy * dy);
	}

	public float dot(float x, float y) {
		float dx = this.x * x;
	    float dy = this.y * y;
	    
	    return dx + dy;
	}
	
	public float dot(Vector2f vector) {
		float dx = this.x * vector.x;
	    float dy = this.y * vector.y;
	    
	    return dx + dy;
	}
	
	public void normalize() {
		float xBase = this.x;
		float yBase = this.y;
		float length = (float) Math.sqrt(this.x * this.x + this.y * this.y);
		
		this.x = xBase / length;
		this.y = yBase / length;
	}
}
