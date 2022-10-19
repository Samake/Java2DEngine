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
import game_content.resources.Objects;
import game_content.resources.Sheets;
import game_editor.Editor;
import game_editor.gui.elements.EntityPanel;
import testgame.LevelEditor;

public class EditorGUIEntities {

	public static Entity selectedEntity;
	public static JLabel entityID;
	public static JLabel entityName;
	
	public static JTextField xPosTextField;
	public static JTextField yPosTextField;
	
	private static JPanel entitiesPanel = new JPanel();
	private static JScrollPane scrollPane;
	private static JPanel selektorPanel = new JPanel();
	public static EntityPanel slotImage;
	
	private static Dimension buttonDimension;
	private static int entitiesCount = 0;
	private static EntityPanel[] entityPanels = new EntityPanel[9999];
	private static Font font = new Font("serif", Font.PLAIN, 10);
	
	public static int width = 280;
	public static int lineHeight = 22;
	
	public static JPanel generateEntitySettings(LevelEditor levelEditor) {
		
		JPanel finalPanel = new JPanel();
		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);
		
		generateEntityPanels();

		addCaption(finalPanel);
		addEntityName(finalPanel);
		addPosition(finalPanel);
		addEntitySelector(finalPanel);
		addEntities(finalPanel);
		
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
		
		JLabel captionLabel = new JLabel("ENTITY SETTINGS");
		captionLabel.setForeground(Color.LIGHT_GRAY);
		captionPanel.add(captionLabel);
		
		captionPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(captionPanel);
	}
	
	private static void addEntityName(JPanel finalPanel) {
		Dimension entityNamePanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.25));
		Dimension labelPanelDimension = new Dimension(width / 3, lineHeight);
		
		JPanel entityNameFinalPanel = new JPanel();
		entityNameFinalPanel.setLayout(new BoxLayout(entityNameFinalPanel, BoxLayout.PAGE_AXIS));
		entityNameFinalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		entityNameFinalPanel.setBackground(Color.DARK_GRAY);
		
		JPanel entityIDPanel = new JPanel();
		entityIDPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		entityIDPanel.setBackground(Color.DARK_GRAY);
		entityIDPanel.setSize(entityNamePanelDimension);
		entityIDPanel.setMaximumSize(entityNamePanelDimension);
		entityIDPanel.setMinimumSize(entityNamePanelDimension);
		entityIDPanel.setPreferredSize(entityNamePanelDimension);
		
		JLabel entityIDLabel = new JLabel("Entity ID: ");
		entityIDLabel.setForeground(Color.WHITE);
		entityIDLabel.setSize(labelPanelDimension);
		entityIDLabel.setMaximumSize(labelPanelDimension);
		entityIDLabel.setMinimumSize(labelPanelDimension);
		entityIDLabel.setPreferredSize(labelPanelDimension);
		
		entityIDPanel.add(entityIDLabel);
		
		entityID = new JLabel("");
		entityID.setForeground(Color.YELLOW);
		
		entityIDPanel.add(entityID);
		
		entityNameFinalPanel.add(entityIDPanel);
		
		
		JPanel entityNamePanel = new JPanel();
		entityNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		entityNamePanel.setBackground(Color.DARK_GRAY);
		entityNamePanel.setSize(entityNamePanelDimension);
		entityNamePanel.setMaximumSize(entityNamePanelDimension);
		entityNamePanel.setMinimumSize(entityNamePanelDimension);
		entityNamePanel.setPreferredSize(entityNamePanelDimension);
		
		JLabel entityNameLabel = new JLabel("Entity Name: ");
		entityNameLabel.setForeground(Color.WHITE);
		entityNameLabel.setSize(labelPanelDimension);
		entityNameLabel.setMaximumSize(labelPanelDimension);
		entityNameLabel.setMinimumSize(labelPanelDimension);
		entityNameLabel.setPreferredSize(labelPanelDimension);
		
		entityNamePanel.add(entityNameLabel);
		
		entityName = new JLabel("");
		entityName.setForeground(Color.YELLOW);
		
		entityNamePanel.add(entityName);
		
		entityNameFinalPanel.add(entityNamePanel);
		
		finalPanel.add(entityNameFinalPanel);
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
	            	if (selectedEntity != null) {
	        			int xPos = Integer.valueOf(xPosTextField.getText().trim());
	        			
	        			selectedEntity.position.x = xPos;
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
	            	if (selectedEntity != null) {
	        			int yPos = Integer.valueOf(yPosTextField.getText().trim());
	        			
	        			selectedEntity.position.y = yPos;
	        		}
	            }
	        }
	    });
		
		positionPanel.add(yPosTextField);
		
		positionFinalPanel.add(positionPanel);
		positionFinalPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(positionFinalPanel);
	}
	
	private static void addEntitySelector(JPanel finalPanel) {
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
		slotImage = generateSelektorCard(entityPanels[0].entityBlueprint);
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
	            	filterEntities(filterField.getText().trim().toLowerCase());
	            }
	        }
	    });
		
		filterPanel.add(filterField);
		finalSelektorPanel.add(filterPanel);
		
		finalPanel.add(finalSelektorPanel);
	}

	private static void addEntities(JPanel finalPanel) {
		int emptyButtonSpace = 0;
		entitiesCount = emptyButtonSpace;
		
		for (EntityConfig entityBlueprint : Objects.entityList) {
			if (entityBlueprint != null) {
				entitiesCount++;
			}
		}
		
		int lines = entitiesCount;
		int lineSize = buttonDimension.height;
		int height = lines * lineSize;
		
		Dimension scrollPaneDimension = new Dimension(width, 440);
		Dimension panelDimension = new Dimension(width - 20, height);

		entitiesPanel.setLayout(new BoxLayout(entitiesPanel, BoxLayout.PAGE_AXIS));
		entitiesPanel.setPreferredSize(panelDimension);
		entitiesPanel.setSize(panelDimension);
		entitiesPanel.setMaximumSize(panelDimension);
		entitiesPanel.setMinimumSize(panelDimension);
		entitiesPanel.setBackground(Color.DARK_GRAY);
		
		for (EntityPanel entityPanel : entityPanels) {
			if (entityPanel !=  null) {
				entitiesPanel.add(entityPanel);
				entitiesPanel.revalidate();
				entitiesPanel.repaint();
			}
		}
		
		scrollPane = new JScrollPane(entitiesPanel);
		scrollPane.setLayout(new ScrollPaneLayout()); 
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane.setSize(scrollPaneDimension);
		scrollPane.setMaximumSize(scrollPaneDimension);
		scrollPane.setMinimumSize(scrollPaneDimension);
		scrollPane.setPreferredSize(scrollPaneDimension);
		scrollPane.getVerticalScrollBar().setUnitIncrement(buttonDimension.height);
		
		finalPanel.add(scrollPane);
	}
	
	private static void generateEntityPanels() {
		int iconScale = 4;
		int iconSize = Sheets.OBJECTS_SHEET.tileSize * iconScale;
		
		buttonDimension = new Dimension(iconSize, iconSize);
		
		int index = 0;
		
		for (int i = 0; i < Objects.entityList.length; i++) {
			EntityConfig entityBlueprint = Objects.entityList[i];
			
			if (entityBlueprint != null) {
				EntityPanel buttonPanel = generateEntityCard(entityBlueprint);
				entityPanels[index] = buttonPanel;
				index++;
			}
		}
	}

	private static EntityPanel generateEntityCard(EntityConfig entityBlueprint) {
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
					Editor.entitySlot = entityBlueprint.name;
					
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
	
	public static void updateEntityValues(Entity entity) {
		selectedEntity = entity;
		
		if (selectedEntity != null) {
			entityID.setText(String.valueOf(selectedEntity.hashCode()));
			entityName.setText(selectedEntity.config.name);
			xPosTextField.setText(String.valueOf((int) selectedEntity.position.x));
			yPosTextField.setText(String.valueOf((int) selectedEntity.position.y));
		}
	}
	
	private static void filterEntities(String name) {
		entitiesPanel.removeAll();
		
		int lines = 0;
		
		for (EntityPanel entityPanel : entityPanels) {
			if (entityPanel !=  null) {
				if (entityPanel.name.contains(name.trim())) {
					entitiesPanel.add(entityPanel);
					entitiesPanel.revalidate();
					entitiesPanel.repaint();
					
					lines++;
				}
			}
		}
		
		int lineSize = buttonDimension.height;
		int height = lines * lineSize;
		
		Dimension panelDimension = new Dimension(width - 20, height);
		entitiesPanel.setPreferredSize(panelDimension);
		
		scrollPane.revalidate();
		scrollPane.repaint();
	}
}
