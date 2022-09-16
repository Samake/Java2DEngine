package engine.core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import engine.debug.Log;
import engine.input.InputHandler;
import engine.rendering.Renderer;
import engine.scene.Scene;
import engine.sound.SoundManager;

public class Engine extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public String title = Config.APPLICATION_NAME + " || " + Config.APPLICATION_VERSION;
	public JFrame frame;

	public boolean isRunning = false;
	
	public InputHandler input;
	public Renderer renderer;
	public Scene scene;
	
	public Engine(int windowWidth, int windowHeight, int zoom) {
		
		if (windowWidth > 0 && windowHeight > 0 && zoom > 0) {
			Config.RESOLUTION_WIDTH = windowWidth;
			Config.RESOLUTION_HEIGHT = windowHeight;
			Config.WINDOW_SCALE = zoom;
			
			Config.WINDOW_WIDTH = Config.RESOLUTION_WIDTH / Config.WINDOW_SCALE;
			Config.WINDOW_HEIGHT = Config.RESOLUTION_HEIGHT / Config.WINDOW_SCALE;
		}
		
		SoundManager.init();
		
		setMinimumSize(new Dimension(Config.WINDOW_WIDTH * Config.WINDOW_SCALE, Config.WINDOW_HEIGHT * Config.WINDOW_SCALE));
		setMaximumSize(new Dimension(Config.WINDOW_WIDTH * Config.WINDOW_SCALE, Config.WINDOW_HEIGHT * Config.WINDOW_SCALE));
		setPreferredSize(new Dimension(Config.WINDOW_WIDTH * Config.WINDOW_SCALE, Config.WINDOW_HEIGHT * Config.WINDOW_SCALE));
		
		buildWindowGUI();
	}
	
	public void buildWindowGUI() {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setTitle(title);
		frame.requestFocusInWindow();
		
		frame.addWindowListener(new WindowAdapter() {
			 @Override
			 public void windowClosing(WindowEvent e) {
				 Log.print("Game stopping...");
				 stop();
			 }
		});
	}
	
	public synchronized void start() {
		isRunning = true;
		new Thread(this).start();
	}
	
	public void run() {
		long lastTimeStamp = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		
		int frames = 0;
		int ticks = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTimeStamp) / nsPerTick;
			lastTimeStamp = now;
			boolean shouldRender = false;
			
			while(delta >= 1) {
				ticks++;
				update();
				delta -= 1;
				shouldRender = true;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (shouldRender) {
				frames++;
				render();
			}
			
			if (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				
				frame.setTitle(title + " || " + frames + " FPS, " + ticks + " UPS");
				
				ticks = 0;
				frames = 0;	
			}
		}
	}
	
	public void update() {

	}
	
	public void render() {

	}
	
	public void cleanUp() {
		if (scene != null) {
			scene.cleanUp();
		}
	}
	
	public synchronized void stop() {
		cleanUp();
		
		Log.print(title + " was stopped!");
		
		isRunning = false;
		
		Runtime rt = Runtime.getRuntime();
		rt.exit(ABORT);
		
		System.exit(0);
	}
}
