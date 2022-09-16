package engine.input;

public class Key {

	private int numTimesPressed = 0;
	private int numTimesTyped = 0;
    private boolean pressed = false;
    private boolean typed = false;
    
    public Key() {
    	
    }
  
    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean isPressed) {
    	pressed = isPressed;
        
    	if (isPressed) {
    		numTimesPressed++;
        }
    }
    
    public boolean isTyped() {
    	if (typed) {
    		typed = false;
    		return true;
    	}
    	
        return false;
    }
    
    public void setTyped(boolean isTyped) {
    	if (typed != isTyped) {
    		typed = isTyped;
    		
    		if (isTyped) {
        		numTimesTyped++;
            }
    	}
    }
    
    public int getNumTimesPressed() {
        return numTimesPressed;
    }
    
    public int getNumTimesTyped() {
        return numTimesTyped;
    }
}
