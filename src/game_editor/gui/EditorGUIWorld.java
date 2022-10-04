package game_editor.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import engine.core.Config;
import testgame.LevelEditor;

public class EditorGUIWorld {

	public static JLabel timeOfDayLabel;
	public static JSlider timeOfDaySlider;
	public static int currentHour = 0;

	public static int width = 280;
	public static int lineHeight = 22;

	public static JPanel generateWorldSettings(LevelEditor levelEditor) {
		JPanel finalPanel = new JPanel();
		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);

		addCaption(finalPanel);
		addGameSpeed(finalPanel);
		addTimeOfDay(levelEditor, finalPanel);
		//addWorldGenerator(levelEditor, finalPanel);
		//addWorldSmooth(levelEditor, finalPanel);
		//addUnlock(levelEditor, finalPanel);
		
		return finalPanel;
	}

	private static void addCaption(JPanel finalPanel) {
		Dimension captionPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		JPanel captionPanel = new JPanel();
		captionPanel.setLayout(new BoxLayout(captionPanel, BoxLayout.PAGE_AXIS));
		captionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		captionPanel.setBackground(Color.DARK_GRAY);
		captionPanel.setSize(captionPanelDimension);
		captionPanel.setMaximumSize(captionPanelDimension);
		captionPanel.setMinimumSize(captionPanelDimension);
		captionPanel.setPreferredSize(captionPanelDimension);
		
		JLabel captionLabel = new JLabel("WORLD SETTINGS");
		captionLabel.setForeground(Color.LIGHT_GRAY);
		captionPanel.add(captionLabel);
		
		captionPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(captionPanel);
	}
	
	private static void addGameSpeed(JPanel finalPanel) {
		Dimension gameSpeedPanelDimension = new Dimension(width - 20, (int) (lineHeight * 2));
		Dimension sliderDimension = new Dimension(width - 20, (int) (lineHeight * 0.5));
		
		JPanel gameSpeedPanel = new JPanel();
		gameSpeedPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gameSpeedPanel.setBackground(Color.DARK_GRAY);
		gameSpeedPanel.setSize(gameSpeedPanelDimension);
		gameSpeedPanel.setMaximumSize(gameSpeedPanelDimension);
		gameSpeedPanel.setMinimumSize(gameSpeedPanelDimension);
		gameSpeedPanel.setPreferredSize(gameSpeedPanelDimension);
		
		JLabel gameSpeedLabel = new JLabel("Gamespeed: " + Config.GAME_SPEED);
		gameSpeedLabel.setForeground(Color.LIGHT_GRAY);
		gameSpeedPanel.add(gameSpeedLabel);

		JSlider gameSpeedSlider = new JSlider();
		gameSpeedSlider.setPreferredSize(sliderDimension);
		gameSpeedSlider.setMaximumSize(sliderDimension);
		gameSpeedSlider.setMinimumSize(sliderDimension);
		gameSpeedSlider.setSize(sliderDimension);
		gameSpeedSlider.setMinimum(1);
		gameSpeedSlider.setMaximum(100);
		gameSpeedSlider.setValue(Config.GAME_SPEED);
		
		gameSpeedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				Config.GAME_SPEED = gameSpeedSlider.getValue();
				gameSpeedLabel.setText("Gamespeed: " + Config.GAME_SPEED);
			}
		});

		gameSpeedPanel.add(gameSpeedSlider);
		
		finalPanel.add(gameSpeedPanel);
	}
	
	private static void addTimeOfDay(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension timeOfDayPanelDimension = new Dimension(width - 20, (int) (lineHeight * 2));
		Dimension sliderDimension = new Dimension(width - 20, (int) (lineHeight * 0.5));
		
		JPanel timeOfDayPanel = new JPanel();
		timeOfDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		timeOfDayPanel.setBackground(Color.DARK_GRAY);
		timeOfDayPanel.setSize(timeOfDayPanelDimension);
		timeOfDayPanel.setMaximumSize(timeOfDayPanelDimension);
		timeOfDayPanel.setMinimumSize(timeOfDayPanelDimension);
		timeOfDayPanel.setPreferredSize(timeOfDayPanelDimension);
		
		timeOfDayLabel = new JLabel("DayTime: 12:00");
		timeOfDayLabel.setForeground(Color.LIGHT_GRAY);
		timeOfDayPanel.add(timeOfDayLabel);

		timeOfDaySlider = new JSlider();
		timeOfDaySlider.setPreferredSize(sliderDimension);
		timeOfDaySlider.setMaximumSize(sliderDimension);
		timeOfDaySlider.setMinimumSize(sliderDimension);
		timeOfDaySlider.setSize(sliderDimension);
		timeOfDaySlider.setMinimum(0);
		timeOfDaySlider.setMaximum(23);
		timeOfDaySlider.setValue(12);
		
		timeOfDaySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				levelEditor.setDayTime(timeOfDaySlider.getValue());
				timeOfDayLabel.setText("DayTime: " + timeOfDaySlider.getValue());
			}
		});

		timeOfDayPanel.add(timeOfDaySlider);
		
		finalPanel.add(timeOfDayPanel);
		
	}

	
	private static void addWorldGenerator(LevelEditor levelEditor, JPanel finalPanel) {
		JButton generateLevelButton = new JButton("Generate");
		generateLevelButton.setBackground(Color.GRAY);
		
		generateLevelButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if (SwingUtilities.isLeftMouseButton(e)) {
					levelEditor.generateWorld();
            	}
			}
		});
		
		finalPanel.add(generateLevelButton);
	}
	
	private static void addWorldSmooth(LevelEditor levelEditor, JPanel finalPanel) {
		JButton smoothLevelButton = new JButton("Smooth");
		smoothLevelButton.setBackground(Color.GRAY);
		
		smoothLevelButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if (SwingUtilities.isLeftMouseButton(e)) {
					levelEditor.smoothLevel();
            	}
			}
		});
		
		finalPanel.add(smoothLevelButton);
	}
	
	private static void addUnlock(LevelEditor levelEditor, JPanel finalPanel) {
		JButton unlockTilesButton = new JButton("Unlock");
		unlockTilesButton.setBackground(Color.GRAY);
		
		unlockTilesButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if (SwingUtilities.isLeftMouseButton(e)) {
					levelEditor.unlockTiles();
            	}
			}
		});
		
		finalPanel.add(unlockTilesButton);
	}
	
	public static void updateWorldValues(int hour, int minute) {
		currentHour = hour;
		timeOfDayLabel.setText("DayTime: " + String.format("%02d", hour) + ":" + String.format("%02d", minute));
		timeOfDaySlider.setValue(hour);
	}
}
