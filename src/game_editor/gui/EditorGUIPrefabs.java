package game_editor.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import engine.entities.Entity;
import engine.entities.EntityConfig;
import game_content.resources.Prefabs;
import game_content.resources.Sheets;
import game_editor.Editor;
import game_editor.gui.elements.EntityPanel;
import runnables.LevelEditor;

public class EditorGUIPrefabs {
	
	public static Entity selectedPrefab;
	public static JLabel prefabID;
	public static JLabel prefabName;
	
	public static JTextField xPosTextField;
	public static JTextField yPosTextField;
	
	private static JPanel prefabsPanel = new JPanel();
	private static JScrollPane scrollPane;
	private static JPanel selektorPanel = new JPanel();
	public static EntityPanel slotImage;
	
	private static Dimension buttonDimension;
	private static int prefabsCount = 0;
	private static EntityPanel[] prefabPanels = new EntityPanel[9999];
	private static Font font = new Font("serif", Font.PLAIN, 10);
	
	public static int width = 280;
	public static int lineHeight = 22;

	public static JPanel generatePrefabSettings(LevelEditor levelEditor) {
		JPanel finalPanel = new JPanel();

		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);

		generatePrefabPanels();
		
		addCaption(finalPanel);
		addPrefabName(finalPanel);
		addPosition(finalPanel);
		addPrefabSelector(finalPanel);
		addPrefabs(finalPanel);
		
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
		
		JLabel captionLabel = new JLabel("PREFAB SETTINGS");
		captionLabel.setForeground(Color.LIGHT_GRAY);
		captionPanel.add(captionLabel);
		
		captionPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(captionPanel);
	}
	
	private static void addPrefabName(JPanel finalPanel) {
		Dimension prefabNamePanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.25));
		Dimension labelPanelDimension = new Dimension(width / 3, lineHeight);
		
		JPanel prefabNameFinalPanel = new JPanel();
		prefabNameFinalPanel.setLayout(new BoxLayout(prefabNameFinalPanel, BoxLayout.PAGE_AXIS));
		prefabNameFinalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		prefabNameFinalPanel.setBackground(Color.DARK_GRAY);
		
		JPanel prefabIDPanel = new JPanel();
		prefabIDPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		prefabIDPanel.setBackground(Color.DARK_GRAY);
		prefabIDPanel.setSize(prefabNamePanelDimension);
		prefabIDPanel.setMaximumSize(prefabNamePanelDimension);
		prefabIDPanel.setMinimumSize(prefabNamePanelDimension);
		prefabIDPanel.setPreferredSize(prefabNamePanelDimension);
		
		JLabel prefabIDLabel = new JLabel("Prefab ID: ");
		prefabIDLabel.setForeground(Color.WHITE);
		prefabIDLabel.setSize(labelPanelDimension);
		prefabIDLabel.setMaximumSize(labelPanelDimension);
		prefabIDLabel.setMinimumSize(labelPanelDimension);
		prefabIDLabel.setPreferredSize(labelPanelDimension);
		
		prefabIDPanel.add(prefabIDLabel);
		
		prefabID = new JLabel("");
		prefabID.setForeground(Color.YELLOW);
		
		prefabIDPanel.add(prefabID);
		prefabNameFinalPanel.add(prefabIDPanel);
		
		JPanel prefabNamePanel = new JPanel();
		prefabNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		prefabNamePanel.setBackground(Color.DARK_GRAY);
		prefabNamePanel.setSize(prefabNamePanelDimension);
		prefabNamePanel.setMaximumSize(prefabNamePanelDimension);
		prefabNamePanel.setMinimumSize(prefabNamePanelDimension);
		prefabNamePanel.setPreferredSize(prefabNamePanelDimension);
		
		JLabel prefabNameLabel = new JLabel("Prefab Name: ");
		prefabNameLabel.setForeground(Color.WHITE);
		prefabNameLabel.setSize(labelPanelDimension);
		prefabNameLabel.setMaximumSize(labelPanelDimension);
		prefabNameLabel.setMinimumSize(labelPanelDimension);
		prefabNameLabel.setPreferredSize(labelPanelDimension);
		
		prefabNamePanel.add(prefabNameLabel);
		
		prefabName = new JLabel("");
		prefabName.setForeground(Color.YELLOW);
		
		prefabNamePanel.add(prefabName);
		prefabNameFinalPanel.add(prefabNamePanel);
		
		finalPanel.add(prefabNameFinalPanel);
	}
	
	private static void addPosition(JPanel finalPanel) {
		Dimension labelPanelDimension = new Dimension(width / 6, lineHeight);
		Dimension positionPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		Dimension textFieldDimension = new Dimension(65, lineHeight);
		
		JPanel positionFinalPanel = new JPanel();
		positionFinalPanel.setLayout(new BoxLayout(positionFinalPanel, BoxLayout.PAGE_AXIS));
		positionFinalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		positionFinalPanel.setBackground(Color.DARK_GRAY);
		
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
	            	if (selectedPrefab != null) {
	        			int xPos = Integer.valueOf(xPosTextField.getText().trim());
	        			
	        			selectedPrefab.position.x = xPos;
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
	            	if (selectedPrefab != null) {
	        			int yPos = Integer.valueOf(yPosTextField.getText().trim());
	        			
	        			selectedPrefab.position.y = yPos;
	        		}
	            }
	        }
	    });
		
		positionPanel.add(yPosTextField);
		
		positionFinalPanel.add(positionPanel);
		positionFinalPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(positionFinalPanel);
	}
	
	private static void addPrefabSelector(JPanel finalPanel) {
		Dimension captionPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		Dimension filterPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		JPanel finalSelektorPanel = new JPanel();
		finalSelektorPanel.setLayout(new BoxLayout(finalSelektorPanel, BoxLayout.PAGE_AXIS));
		finalSelektorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		finalSelektorPanel.setBackground(Color.DARK_GRAY);
		
		JPanel captionPanel = new JPanel();
		captionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		captionPanel.setBackground(Color.DARK_GRAY);
		captionPanel.setPreferredSize(captionPanelDimension);
		
		JLabel captionLabel = new JLabel("ENTITY SELEKTOR");
		captionLabel.setForeground(Color.LIGHT_GRAY);
		captionPanel.add(captionLabel);
		
		finalSelektorPanel.add(captionPanel);

		selektorPanel = new JPanel();
		selektorPanel.setBackground(Color.DARK_GRAY);
		slotImage = generateSelektorCard(prefabPanels[0].entityBlueprint);
		selektorPanel.add(slotImage);
		selektorPanel.revalidate();
		selektorPanel.repaint();
		
		finalSelektorPanel.add(selektorPanel);
		finalSelektorPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

		JPanel filterPanel = new JPanel();
		filterPanel.setPreferredSize(filterPanelDimension);
		filterPanel.setBackground(Color.DARK_GRAY);
		
		JTextField filterField = new JTextField();
		filterField.setPreferredSize(new Dimension(width - 20, lineHeight));
		filterField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	            	filterPrefabs(filterField.getText().trim().toLowerCase());
	            }
	        }
	    });
		
		filterPanel.add(filterField);
		finalSelektorPanel.add(filterPanel);
		
		finalPanel.add(finalSelektorPanel);
	}
	
	private static void addPrefabs(JPanel finalPanel) {
		int emptyButtonSpace = 0;
		prefabsCount = emptyButtonSpace;
		
		for (EntityConfig entityBlueprint : Prefabs.list) {
			if (entityBlueprint != null) {
				prefabsCount++;
			}
		}
		
		int lines = prefabsCount;
		int lineSize = buttonDimension.height;
		int height = lines * lineSize;
		
		Dimension scrollPaneDimension = new Dimension(width, 440);
		Dimension panelDimension = new Dimension(width - 20, height);

		prefabsPanel.setLayout(new BoxLayout(prefabsPanel, BoxLayout.PAGE_AXIS));
		prefabsPanel.setPreferredSize(panelDimension);
		prefabsPanel.setSize(panelDimension);
		prefabsPanel.setMaximumSize(panelDimension);
		prefabsPanel.setMinimumSize(panelDimension);
		prefabsPanel.setBackground(Color.DARK_GRAY);
		
		for (EntityPanel entityPanel : prefabPanels) {
			if (entityPanel !=  null) {
				prefabsPanel.add(entityPanel);
				prefabsPanel.revalidate();
				prefabsPanel.repaint();
			}
		}
		
		scrollPane = new JScrollPane(prefabsPanel);
		scrollPane.setLayout(new ScrollPaneLayout()); 
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane.setSize(scrollPaneDimension);
		scrollPane.setMaximumSize(scrollPaneDimension);
		scrollPane.setMinimumSize(scrollPaneDimension);
		scrollPane.setPreferredSize(scrollPaneDimension);
		scrollPane.getVerticalScrollBar().setUnitIncrement(buttonDimension.height);
		
		finalPanel.add(scrollPane);
	}
	
	private static void generatePrefabPanels() {
		int iconScale = 4;
		int iconSize = Sheets.OBJECTS_SHEET.tileSize * iconScale;
		
		buttonDimension = new Dimension(iconSize, iconSize);
		
		int index = 0;
		
		for (int i = 0; i < Prefabs.list.length; i++) {
			EntityConfig entityBlueprint = Prefabs.list[i];
		
			if (entityBlueprint != null) {
				EntityPanel buttonPanel = generatePrefabCard(entityBlueprint);
				prefabPanels[index] = buttonPanel;
				index++;
			}
		}
	}

	private static EntityPanel generatePrefabCard(EntityConfig entityBlueprint) {
		int lineSize = buttonDimension.height;
		Dimension buttonPanelDimension = new Dimension(width - 50, lineSize);
		
		EntityPanel buttonPanel = new EntityPanel(entityBlueprint);
		buttonPanel.setPreferredSize(buttonPanelDimension);
		buttonPanel.setSize(buttonPanelDimension);
		buttonPanel.setMaximumSize(buttonPanelDimension);
		buttonPanel.setMinimumSize(buttonPanelDimension);
		
		JButton button = new JButton();
		button.setPreferredSize(buttonDimension);
		button.setSize(buttonDimension);
		button.setMaximumSize(buttonDimension);
		button.setMinimumSize(buttonDimension);
		
		button.setBackground(Color.DARK_GRAY);
		button.setIcon(entityBlueprint.icon);
		button.setActionCommand(entityBlueprint.name.toLowerCase());
		button.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if (SwingUtilities.isLeftMouseButton(e)) {
					Editor.prefabSlot = entityBlueprint.name;
					
					selektorPanel.removeAll();
					
					slotImage = generateSelektorCard(entityBlueprint);
					
					selektorPanel.add(slotImage);
					selektorPanel.revalidate();
					selektorPanel.repaint();
		    	}
			}
		});
		
		JLabel buttonText = new JLabel(entityBlueprint.name);
		buttonText.setForeground(Color.LIGHT_GRAY);
		buttonText.setFont(font);
		
		buttonPanel.add(button, BorderLayout.LINE_START);
		buttonPanel.add(buttonText, BorderLayout.CENTER);
		
		return buttonPanel;
	}
	
	private static EntityPanel generateSelektorCard(EntityConfig entityBlueprint) {
		int lineSize = buttonDimension.height;
		Dimension buttonPanelDimension = new Dimension(width - 50, lineSize);
		
		EntityPanel buttonPanel = new EntityPanel(entityBlueprint);
		buttonPanel.setPreferredSize(buttonPanelDimension);
		buttonPanel.setSize(buttonPanelDimension);
		buttonPanel.setMaximumSize(buttonPanelDimension);
		buttonPanel.setMinimumSize(buttonPanelDimension);
		
		JButton button = new JButton();
		button.setPreferredSize(buttonDimension);
		button.setSize(buttonDimension);
		button.setMaximumSize(buttonDimension);
		button.setMinimumSize(buttonDimension);
		button.setBackground(Color.DARK_GRAY);
		button.setIcon(entityBlueprint.icon);
		
		JLabel buttonText = new JLabel(entityBlueprint.name);
		buttonText.setForeground(Color.LIGHT_GRAY);
		buttonText.setFont(font);
		
		buttonPanel.add(button, BorderLayout.LINE_START);
		buttonPanel.add(buttonText, BorderLayout.CENTER);
		
		return buttonPanel;
	}
	
	public static void updatePrefabValues(Entity entity) {
		selectedPrefab = entity;
		
		if (selectedPrefab != null) {
			prefabID.setText(String.valueOf(selectedPrefab.hashCode()));
			prefabName.setText(selectedPrefab.config.name);
			xPosTextField.setText(String.valueOf((int) selectedPrefab.position.x));
			yPosTextField.setText(String.valueOf((int) selectedPrefab.position.y));
		}
	}
	
	private static void filterPrefabs(String name) {
		prefabsPanel.removeAll();
		
		int lines = 0;
		
		for (EntityPanel entityPanel : prefabPanels) {
			if (entityPanel !=  null) {
				if (entityPanel.name.contains(name)) {
					prefabsPanel.add(entityPanel);
					prefabsPanel.revalidate();
					prefabsPanel.repaint();
					
					lines++;
				}
			}
		}
		
		int lineSize = buttonDimension.height;
		int height = lines * lineSize;
		
		Dimension panelDimension = new Dimension(width - 20, height);
		prefabsPanel.setPreferredSize(panelDimension);
		
		scrollPane.revalidate();
		scrollPane.repaint();
	}
}
