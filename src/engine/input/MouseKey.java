package engine.input;

public class MouseKey extends Key {

	private int numTimesClicked = 0;
    private boolean clicked = false;
    private boolean dragged = false;
    
    public MouseKey() {
    	
    }

    public int getNumTimesClicked() {
        return numTimesClicked;
    }

    public boolean isClicked() {
    	if (clicked) {
    		clicked = false;
    		return true;
    	}
    	
    	return false;
    }

    public void setClicked(boolean isClicked) {
    	clicked = isClicked;
    	
    	if (clicked) {
    		numTimesClicked++;
    	}
    }
    
    public boolean isDragged() {
    	return dragged;
    }
    
    public void setDragged(boolean isDragged) {
    	dragged = isDragged;
    }
}
