package engine.input;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import engine.debug.Log;
import engine.utils.Vector2f;

public class InputHandler implements KeyListener, MouseMotionListener, MouseListener {
	
	public Key playerUp = new Key();
    public Key playerDown = new Key();
    public Key playerLeft = new Key();
    public Key playerRight = new Key();
    
    public Key cameraUp = new Key();
    public Key cameraDown = new Key();
    public Key cameraLeft = new Key();
    public Key cameraRight = new Key();
    public Key toggleCamera = new Key();
    
    public Key toggleDebug = new Key();
    
    public Key lshift = new Key();
    public Key lctrl = new Key();
    
    public Key num1 = new Key();
    public Key num2 = new Key();
    public Key num3 = new Key();
    public Key num4 = new Key();
    public Key num5 = new Key();
    public Key num6 = new Key();
    public Key num7 = new Key();
    public Key num8 = new Key();
    public Key num9 = new Key();
    
    public Key keyF1 = new Key();
    public Key keyF2 = new Key();
    public Key keyF3 = new Key();
    public Key keyF4 = new Key();
    
    public MouseKey lmouse = new MouseKey();
    public MouseKey mmouse = new MouseKey();
    public MouseKey rmouse = new MouseKey();
    
    public Vector2f mousePosition = new Vector2f();
    public boolean mouseInWindow = true;

	public InputHandler(Canvas game) {
        game.addKeyListener(this);
        game.addMouseMotionListener(this);
        game.addMouseListener(this);
        
        Log.print("Added input methods...");
    }

	public void toggleKeyPressed(int keyCode, boolean isPressed) {
        if (keyCode == KeyEvent.VK_W) {
            playerUp.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_S) {
            playerDown.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_A) {
            playerLeft.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_D) {
            playerRight.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_UP) {
            cameraUp.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_DOWN) {
        	cameraDown.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_LEFT) {
        	cameraLeft.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_RIGHT) {
        	cameraRight.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_SHIFT) {
        	lshift.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_CONTROL) {
        	lctrl.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_C) {
        	toggleCamera.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_V) {
        	toggleDebug.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_1) {
        	num1.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_2) {
        	num2.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_3) {
        	num3.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_4) {
        	num4.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_5) {
        	num5.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_6) {
        	num6.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_7) {
        	num7.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_8) {
        	num8.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_9) {
        	num9.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_F1) {
        	keyF1.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_F2) {
        	keyF2.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_F3) {
        	keyF3.setPressed(isPressed);
        }
        
        if (keyCode == KeyEvent.VK_F4) {
        	keyF4.setPressed(isPressed);
        }
    }
	
	public void toggleKeyTyped(int keyCode, boolean isTyped) {
		if (keyCode == KeyEvent.VK_W) {
            playerUp.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_S) {
            playerDown.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_A) {
            playerLeft.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_D) {
            playerRight.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_UP) {
            cameraUp.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_DOWN) {
        	cameraDown.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_LEFT) {
        	cameraLeft.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_RIGHT) {
        	cameraRight.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_SHIFT) {
        	lshift.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_CONTROL) {
        	lctrl.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_C) {
        	toggleCamera.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_V) {
        	toggleDebug.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_1) {
        	num1.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_2) {
        	num2.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_3) {
        	num3.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_4) {
        	num4.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_5) {
        	num5.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_6) {
        	num6.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_7) {
        	num7.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_8) {
        	num8.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_9) {
        	num9.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_F1) {
        	keyF1.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_F2) {
        	keyF2.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_F3) {
        	keyF3.setTyped(isTyped);
        }
        
        if (keyCode == KeyEvent.VK_F4) {
        	keyF4.setTyped(isTyped);
        }
    }

    public void keyPressed(KeyEvent e) {
    	//System.err.println(e.getKeyCode() + " keyPressed");
    	toggleKeyPressed(e.getKeyCode(), true);
    	toggleKeyTyped(e.getKeyCode(), true);
    }

    public void keyTyped(KeyEvent e) {
    	//System.err.println(e.getKeyCode() + " keyTyped");
    	//toggleKeyTyped(e.getKeyCode(), true);
    }
    
    public void keyReleased(KeyEvent e) {
    	//System.err.println(e.getKeyCode() + " keyReleased");
    	toggleKeyPressed(e.getKeyCode(), false);
    }
    
    public void toggleMouseKeyPressed(int keyCode, boolean isPressed) {
        if (keyCode == MouseEvent.BUTTON1) {
        	lmouse.setPressed(isPressed);
        }
        
        if (keyCode == MouseEvent.BUTTON2) {
        	mmouse.setPressed(isPressed);
        }
        
        if (keyCode == MouseEvent.BUTTON3) {
        	rmouse.setPressed(isPressed);
        }
    }
    
    public void toggleMouseKeyClicked(int keyCode, boolean isPressed) {
        if (keyCode == MouseEvent.BUTTON1) {
        	lmouse.setClicked(isPressed);
        }
        
        if (keyCode == MouseEvent.BUTTON2) {
        	mmouse.setClicked(isPressed);
        }
        
        if (keyCode == MouseEvent.BUTTON3) {
        	rmouse.setClicked(isPressed);
        }
    }
    
    public void toggleMouseKeyDragged(int keyCode, boolean isDragged) {
        if (keyCode == MouseEvent.BUTTON1) {
        	lmouse.setDragged(isDragged);
        }
        
        if (keyCode == MouseEvent.BUTTON2) {
        	mmouse.setDragged(isDragged);
        }
        
        if (keyCode == MouseEvent.BUTTON3) {
        	rmouse.setDragged(isDragged);
        }
    }
    
    public void mousePressed(MouseEvent e) {
    	//System.err.println(e.getButton() + " mousePressed");
    	toggleMouseKeyPressed(e.getButton(), true);
    	toggleMouseKeyClicked(e.getButton(), true);
	}
    
	public void mouseDragged(MouseEvent e) {
		//System.err.println(e.getButton() + " mouseDragged");
		toggleMouseKeyDragged(e.getButton(), true);
	}

	public void mouseClicked(MouseEvent e) {
		//System.err.println(e.getButton() + " mouseClicked");
	}

	public void mouseReleased(MouseEvent e) {
		//System.err.println(e.getButton() + " mouseReleased");
		toggleMouseKeyPressed(e.getButton(), false);
		toggleMouseKeyClicked(e.getButton(), false);
		toggleMouseKeyDragged(e.getButton(), false);
	}

	public void mouseEntered(MouseEvent e) {
		mouseInWindow = true;
	}

	public void mouseExited(MouseEvent e) {
		mouseInWindow = false;
	}
	
	public void mouseMoved(MouseEvent e) {
		if (mouseInWindow) {
			mousePosition.set(e.getX(), e.getY());
		}
	}


}
