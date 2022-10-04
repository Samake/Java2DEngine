package game_editor.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import engine.entities.lights.PointLight;
import testgame.LevelEditor;

public class EditorGUILights {
	
	public static PointLight selectedLight;
	public static JLabel lightName;
	
	public static JTextField xPosTextField;
	public static JTextField yPosTextField;
	public static JSlider redSlider;
	public static JSlider greenSlider;
	public static JSlider blueSlider;
	public static JSlider radiusSlider;
	public static JCheckBox pulsingCheckBox;
	public static JCheckBox flickeringCheckBox;
	public static JSlider delaySlider;
	public static JCheckBox enabledAtDayCheckBox;
	
	public static int width = 280;
	public static int lineHeight = 22;
	
	public static JPanel generateLightSettings(LevelEditor levelEditor) {
		
		JPanel finalPanel = new JPanel();
		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);

		addCaption(finalPanel);
		addLightName(finalPanel);
		addPosition(finalPanel);
		addColor(finalPanel);
		addRadius(finalPanel);
		addPulsing(finalPanel);
		addFlickering(finalPanel);
		addDelay(finalPanel);
		addEnabledAtDay(finalPanel);
		
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
		
		JLabel captionLabel = new JLabel("LIGHT SETTINGS");
		captionLabel.setForeground(Color.LIGHT_GRAY);
		captionPanel.add(captionLabel);
		
		captionPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(captionPanel);
	}
	
	private static void addLightName(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 5, lineHeight);
		
		JPanel lightNamePanel = new JPanel();
		lightNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		lightNamePanel.setBackground(Color.DARK_GRAY);
		
		Dimension lightNamePanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		lightNamePanel.setSize(lightNamePanelDimension);
		lightNamePanel.setMaximumSize(lightNamePanelDimension);
		lightNamePanel.setMinimumSize(lightNamePanelDimension);
		lightNamePanel.setPreferredSize(lightNamePanelDimension);
		
		JLabel lightNameLabel = new JLabel("Light ID: ");
		lightNameLabel.setForeground(Color.WHITE);
		lightNameLabel.setSize(labelPanelDimension);
		lightNameLabel.setMaximumSize(labelPanelDimension);
		lightNameLabel.setMinimumSize(labelPanelDimension);
		lightNameLabel.setPreferredSize(labelPanelDimension);
		
		lightNamePanel.add(lightNameLabel);
		
		lightName = new JLabel("");
		lightName.setForeground(Color.YELLOW);
		
		lightNamePanel.add(lightName);
		
		finalPanel.add(lightNamePanel);
	}
	
	private static void addPosition(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 6, lineHeight);
		Dimension positionPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		Dimension textFieldDimension = new Dimension(65, lineHeight);
		
		JPanel positionPanel = new JPanel();
		positionPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		positionPanel.setBackground(Color.DARK_GRAY);
		positionPanel.setSize(positionPanelDimension);
		positionPanel.setMaximumSize(positionPanelDimension);
		positionPanel.setMinimumSize(positionPanelDimension);
		positionPanel.setPreferredSize(positionPanelDimension);
		
		JLabel xLabel = new JLabel("X:");
		xLabel.setForeground(Color.WHITE);
		xLabel.setSize(labelPanelDimension);
		xLabel.setMaximumSize(labelPanelDimension);
		xLabel.setMinimumSize(labelPanelDimension);
		xLabel.setPreferredSize(labelPanelDimension);
		
		positionPanel.add(xLabel);
		
		xPosTextField = new JTextField();
		xPosTextField.setPreferredSize(textFieldDimension);
		xPosTextField.setMaximumSize(textFieldDimension);
		xPosTextField.setMinimumSize(textFieldDimension);
		xPosTextField.setSize(textFieldDimension);
		xPosTextField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	            	if (selectedLight != null) {
	        			int xPos = Integer.valueOf(xPosTextField.getText().trim());
	        			
	        			selectedLight.position.x = xPos;
	        		}
	            }
	        }
	    });
		
		positionPanel.add(xPosTextField);
		
		JLabel yLabel = new JLabel("Y:");
		yLabel.setForeground(Color.WHITE);
		yLabel.setSize(labelPanelDimension);
		yLabel.setMaximumSize(labelPanelDimension);
		yLabel.setMinimumSize(labelPanelDimension);
		yLabel.setPreferredSize(labelPanelDimension);
		
		positionPanel.add(yLabel);
		
		yPosTextField = new JTextField();
		yPosTextField.setPreferredSize(textFieldDimension);
		yPosTextField.setMaximumSize(textFieldDimension);
		yPosTextField.setMinimumSize(textFieldDimension);
		yPosTextField.setSize(textFieldDimension);
		yPosTextField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	            	if (selectedLight != null) {
	        			int yPos = Integer.valueOf(yPosTextField.getText().trim());
	        			
	        			selectedLight.position.y = yPos;
	        		}
	            }
	        }
	    });
		
		positionPanel.add(yPosTextField);
		
		finalPanel.add(positionPanel);
	}
	
	private static void addColor(JPanel finalPanel) {
		Dimension colorPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		Dimension labelPanelDimension = new Dimension(width / 5, (int) (lineHeight * 1.5));
		Dimension sliderDimension = new Dimension(width - 100, (int) (lineHeight * 0.5));
		
		JPanel redPanel = new JPanel();
		redPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		redPanel.setBackground(new Color(220, 90, 90));
		redPanel.setSize(colorPanelDimension);
		redPanel.setMaximumSize(colorPanelDimension);
		redPanel.setMinimumSize(colorPanelDimension);
		redPanel.setPreferredSize(colorPanelDimension);
		
		JLabel redLabel = new JLabel("R:");
		redLabel.setForeground(Color.WHITE);
		redLabel.setSize(labelPanelDimension);
		redLabel.setMaximumSize(labelPanelDimension);
		redLabel.setMinimumSize(labelPanelDimension);
		redLabel.setPreferredSize(labelPanelDimension);
		
		redPanel.add(redLabel);
		
		redSlider = new JSlider();
		redSlider.setPreferredSize(sliderDimension);
		redSlider.setMaximumSize(sliderDimension);
		redSlider.setMinimumSize(sliderDimension);
		redSlider.setSize(sliderDimension);
		redSlider.setMinimum(1);
		redSlider.setMaximum(255);
		redSlider.setValue(1);
		
		redSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (selectedLight != null) {
					int value = redSlider.getValue();
					changeColor(value, -1, -1);
				}
			}
		});
		
		redPanel.add(redSlider);

		JPanel greenPanel = new JPanel();
		greenPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		greenPanel.setBackground(new Color(90, 220, 90));
		greenPanel.setSize(colorPanelDimension);
		greenPanel.setMaximumSize(colorPanelDimension);
		greenPanel.setMinimumSize(colorPanelDimension);
		greenPanel.setPreferredSize(colorPanelDimension);
		
		JLabel greenLabel = new JLabel("G:");
		greenLabel.setForeground(Color.WHITE);
		greenLabel.setSize(labelPanelDimension);
		greenLabel.setMaximumSize(labelPanelDimension);
		greenLabel.setMinimumSize(labelPanelDimension);
		greenLabel.setPreferredSize(labelPanelDimension);
		
		greenPanel.add(greenLabel);
		
		greenSlider = new JSlider();
		greenSlider.setPreferredSize(sliderDimension);
		greenSlider.setMaximumSize(sliderDimension);
		greenSlider.setMinimumSize(sliderDimension);
		greenSlider.setSize(sliderDimension);
		greenSlider.setMinimum(1);
		greenSlider.setMaximum(255);
		greenSlider.setValue(1);
		
		greenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (selectedLight != null) {
					int value = greenSlider.getValue();
					changeColor(-1, value, -1);
				}
			}
		});
		
		greenPanel.add(greenSlider);

		JPanel bluePanel = new JPanel();
		bluePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		bluePanel.setBackground(new Color(90, 90, 220));
		bluePanel.setSize(colorPanelDimension);
		bluePanel.setMaximumSize(colorPanelDimension);
		bluePanel.setMinimumSize(colorPanelDimension);
		bluePanel.setPreferredSize(colorPanelDimension);
		
		JLabel blueLabel = new JLabel("B:");
		blueLabel.setForeground(Color.WHITE);
		blueLabel.setSize(labelPanelDimension);
		blueLabel.setMaximumSize(labelPanelDimension);
		blueLabel.setMinimumSize(labelPanelDimension);
		blueLabel.setPreferredSize(labelPanelDimension);
		
		bluePanel.add(blueLabel);
		
		blueSlider = new JSlider();
		blueSlider.setPreferredSize(sliderDimension);
		blueSlider.setMaximumSize(sliderDimension);
		blueSlider.setMinimumSize(sliderDimension);
		blueSlider.setSize(sliderDimension);
		blueSlider.setMinimum(1);
		blueSlider.setMaximum(255);
		blueSlider.setValue(1);
		
		blueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (selectedLight != null) {
					int value = blueSlider.getValue();
					changeColor(-1, -1, value);
				}
			}
		});
		
		bluePanel.add(blueSlider);
		
		finalPanel.add(redPanel);
		finalPanel.add(greenPanel);
		finalPanel.add(bluePanel);
	}

	private static void addRadius(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 5, (int) (lineHeight * 1.5));
		Dimension sliderDimension = new Dimension(width - 100, (int) (lineHeight * 0.5));
		
		JPanel radiusPanel = new JPanel();
		radiusPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		radiusPanel.setBackground(Color.DARK_GRAY);
		
		Dimension radiusPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		radiusPanel.setSize(radiusPanelDimension);
		radiusPanel.setMaximumSize(radiusPanelDimension);
		radiusPanel.setMinimumSize(radiusPanelDimension);
		radiusPanel.setPreferredSize(radiusPanelDimension);
		
		JLabel radiusLabel = new JLabel("Radius:");
		radiusLabel.setForeground(Color.WHITE);
		radiusLabel.setSize(labelPanelDimension);
		radiusLabel.setMaximumSize(labelPanelDimension);
		radiusLabel.setMinimumSize(labelPanelDimension);
		radiusLabel.setPreferredSize(labelPanelDimension);
		
		radiusPanel.add(radiusLabel);
		
		radiusSlider = new JSlider();
		radiusSlider.setPreferredSize(sliderDimension);
		radiusSlider.setMaximumSize(sliderDimension);
		radiusSlider.setMinimumSize(sliderDimension);
		radiusSlider.setSize(sliderDimension);
		radiusSlider.setMinimum(1);
		radiusSlider.setMaximum(200);
		radiusSlider.setValue(1);
		
		radiusSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (selectedLight != null) {
					int value = radiusSlider.getValue();
			    	selectedLight.radius = value;
				}
			}
		});

		radiusPanel.add(radiusSlider);
		
		finalPanel.add(radiusPanel);
	}
	
	private static void addPulsing(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 2, (int) (lineHeight * 1.5));
		
		JPanel pulsingPanel = new JPanel();
		pulsingPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pulsingPanel.setBackground(Color.DARK_GRAY);
		
		Dimension pulsingPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		pulsingPanel.setSize(pulsingPanelDimension);
		pulsingPanel.setMaximumSize(pulsingPanelDimension);
		pulsingPanel.setMinimumSize(pulsingPanelDimension);
		pulsingPanel.setPreferredSize(pulsingPanelDimension);
		
		pulsingCheckBox = new JCheckBox("Pulsing");
		pulsingCheckBox.setBackground(Color.DARK_GRAY);
		pulsingCheckBox.setForeground(Color.WHITE);
		pulsingCheckBox.setSize(labelPanelDimension);
		pulsingCheckBox.setMaximumSize(labelPanelDimension);
		pulsingCheckBox.setMinimumSize(labelPanelDimension);
		pulsingCheckBox.setPreferredSize(labelPanelDimension);
		
		pulsingCheckBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	if (selectedLight != null) {
		    		JCheckBox cb = (JCheckBox) event.getSource();

			        selectedLight.pulsing = cb.isSelected();
		    	}
		    }
		});
		
		pulsingPanel.add(pulsingCheckBox);
		
		finalPanel.add(pulsingPanel);
	}
	
	private static void addFlickering(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 2, (int) (lineHeight * 1.5));
		
		JPanel flickeringPanel = new JPanel();
		flickeringPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		flickeringPanel.setBackground(Color.DARK_GRAY);
		
		Dimension flickeringPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		flickeringPanel.setSize(flickeringPanelDimension);
		flickeringPanel.setMaximumSize(flickeringPanelDimension);
		flickeringPanel.setMinimumSize(flickeringPanelDimension);
		flickeringPanel.setPreferredSize(flickeringPanelDimension);
		
		flickeringCheckBox = new JCheckBox("Flickering");
		flickeringCheckBox.setBackground(Color.DARK_GRAY);
		flickeringCheckBox.setForeground(Color.WHITE);
		flickeringCheckBox.setSize(labelPanelDimension);
		flickeringCheckBox.setMaximumSize(labelPanelDimension);
		flickeringCheckBox.setMinimumSize(labelPanelDimension);
		flickeringCheckBox.setPreferredSize(labelPanelDimension);
		
		flickeringCheckBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	if (selectedLight != null) {
		    		JCheckBox cb = (JCheckBox) event.getSource();

			        selectedLight.flickering = cb.isSelected();
		    	}
		    }
		});
		
		flickeringPanel.add(flickeringCheckBox);
		
		finalPanel.add(flickeringPanel);
	}
	
	private static void addDelay(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 5, (int) (lineHeight * 1.5));
		Dimension delayPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		Dimension sliderDimension = new Dimension(width - 100, (int) (lineHeight * 0.5));
		
		JPanel delayPanel = new JPanel();
		delayPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		delayPanel.setBackground(Color.DARK_GRAY);
		delayPanel.setSize(delayPanelDimension);
		delayPanel.setMaximumSize(delayPanelDimension);
		delayPanel.setMinimumSize(delayPanelDimension);
		delayPanel.setPreferredSize(delayPanelDimension);
		
		JLabel delayLabel = new JLabel("Delay:");
		delayLabel.setForeground(Color.WHITE);
		delayLabel.setSize(labelPanelDimension);
		delayLabel.setMaximumSize(labelPanelDimension);
		delayLabel.setMinimumSize(labelPanelDimension);
		delayLabel.setPreferredSize(labelPanelDimension);
		
		delayPanel.add(delayLabel);
		
		delaySlider = new JSlider();
		delaySlider.setPreferredSize(sliderDimension);
		delaySlider.setMaximumSize(sliderDimension);
		delaySlider.setMinimumSize(sliderDimension);
		delaySlider.setSize(sliderDimension);
		delaySlider.setMinimum(1);
		delaySlider.setMaximum(200);
		delaySlider.setValue(1);
		
		delaySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (selectedLight != null) {
					int value = delaySlider.getValue();
			    	selectedLight.delay = value;
				}
			}
		});

		delayPanel.add(delaySlider);
		
		finalPanel.add(delayPanel);
	}
	
	private static void addEnabledAtDay(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 2, (int) (lineHeight * 1.5));
		
		JPanel enabledAtDayPanel = new JPanel();
		enabledAtDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		enabledAtDayPanel.setBackground(Color.DARK_GRAY);
		
		Dimension enabledAtDayPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		enabledAtDayPanel.setSize(enabledAtDayPanelDimension);
		enabledAtDayPanel.setMaximumSize(enabledAtDayPanelDimension);
		enabledAtDayPanel.setMinimumSize(enabledAtDayPanelDimension);
		enabledAtDayPanel.setPreferredSize(enabledAtDayPanelDimension);
		
		enabledAtDayCheckBox = new JCheckBox("EnabledAtDay");
		enabledAtDayCheckBox.setBackground(Color.DARK_GRAY);
		enabledAtDayCheckBox.setForeground(Color.WHITE);
		enabledAtDayCheckBox.setSize(labelPanelDimension);
		enabledAtDayCheckBox.setMaximumSize(labelPanelDimension);
		enabledAtDayCheckBox.setMinimumSize(labelPanelDimension);
		enabledAtDayCheckBox.setPreferredSize(labelPanelDimension);
		
		enabledAtDayCheckBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	if (selectedLight != null) {
		    		JCheckBox cb = (JCheckBox) event.getSource();

			        selectedLight.enabledAtDay = cb.isSelected();
		    	}
		    }
		});
		
		enabledAtDayPanel.add(enabledAtDayCheckBox);
		
		finalPanel.add(enabledAtDayPanel);
	}

	public static void updateLightValues(PointLight light) {
		selectedLight = light;
		
		if (selectedLight != null) {
			lightName.setText(String.valueOf(selectedLight.hashCode()));
			radiusSlider.setValue(selectedLight.radius);
			redSlider.setValue(selectedLight.color.getRed());
			greenSlider.setValue(selectedLight.color.getGreen());
			blueSlider.setValue(selectedLight.color.getBlue());
			xPosTextField.setText(String.valueOf((int) selectedLight.position.x));
			yPosTextField.setText(String.valueOf((int) selectedLight.position.y));
			pulsingCheckBox.setSelected(selectedLight.pulsing);
			flickeringCheckBox.setSelected(selectedLight.flickering);
			delaySlider.setValue(selectedLight.delay);
			enabledAtDayCheckBox.setSelected(selectedLight.enabledAtDay);
		}
	}
	
	public static void changeColor(int redValue, int greenValue, int blueValue) {
		if (selectedLight != null) {
			int red = selectedLight.color.getRed();
			int green = selectedLight.color.getGreen();
			int blue = selectedLight.color.getBlue();
			
			if (redValue >= 0) {
				red = redValue;
			}
			
			if (greenValue >= 0) {
				green = greenValue;
			}
			
			if (blueValue >= 0) {
				blue = blueValue;
			}
			
			
			selectedLight.color = new Color(red, green, blue);
		}
	}
}
