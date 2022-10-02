package game_editor.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import engine.tiles.TileBluePrint;
import game_content.resources.Sheets;
import game_content.resources.Tiles;
import game_editor.Editor;
import testgame.LevelEditor;

public class EditorGUITiles {

	public static JLabel leftSlotImage;
	public static JLabel rightSlotImage;
	private static JPanel tilesPanel = new JPanel();
	private static JScrollPane scrollPane;
	
	private static Dimension buttonDimension;
	private static int tilesCount = 0;
	private static JButton[] buttons = new JButton[9999];
	
	public static int width = 280;
	public static int lineHeight = 22;
	
	public static JPanel generateTileSlots(LevelEditor levelEditor) {
	
		JPanel finalPanel = new JPanel();

		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);

		addCaption(finalPanel);
		addEditorSlots(finalPanel);
		addSmoothOptions(finalPanel);
		addFilter(finalPanel);
		addTiles(finalPanel);
		
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
		
		JLabel captionLabel = new JLabel("TILE SETTINGS");
		captionLabel.setForeground(Color.LIGHT_GRAY);
		captionPanel.add(captionLabel);
		
		captionPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(captionPanel);
	}
	
	private static void addEditorSlots(JPanel finalPanel) {
		
		Dimension slotFinalPanelDimension = new Dimension(width - 20, 75);
		Dimension slotPanelDimension = new Dimension(width - 20, 55);
		
		JPanel slotsFinalPanel = new JPanel();
		slotsFinalPanel.setLayout(new BoxLayout(slotsFinalPanel, BoxLayout.PAGE_AXIS));
		slotsFinalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slotsFinalPanel.setBackground(Color.DARK_GRAY);
		slotsFinalPanel.setSize(slotFinalPanelDimension);
		slotsFinalPanel.setMaximumSize(slotFinalPanelDimension);
		slotsFinalPanel.setMinimumSize(slotFinalPanelDimension);
		slotsFinalPanel.setPreferredSize(slotFinalPanelDimension);
		
		JPanel slotsPanel = new JPanel();
		slotsPanel.setLayout(new BoxLayout(slotsPanel, BoxLayout.LINE_AXIS));
		slotsPanel.setBackground(Color.DARK_GRAY);
		slotsPanel.setSize(slotPanelDimension);
		slotsPanel.setMaximumSize(slotPanelDimension);
		slotsPanel.setMinimumSize(slotPanelDimension);
		slotsPanel.setPreferredSize(slotPanelDimension);
		
		JLabel leftSlotLabel = new JLabel("Left:");
		leftSlotLabel.setForeground(Color.LIGHT_GRAY);
		slotsPanel.add(leftSlotLabel);
		slotsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		leftSlotImage = new JLabel(Tiles.getBluePrintByID(0).icon);
		slotsPanel.add(leftSlotImage);
		slotsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JLabel rightSlotLabel = new JLabel("Right:");
		rightSlotLabel.setForeground(Color.LIGHT_GRAY);
		slotsPanel.add(rightSlotLabel);
		slotsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		rightSlotImage = new JLabel(Tiles.getBluePrintByID(0).icon);
		slotsPanel.add(rightSlotImage);
		
		slotsFinalPanel.add(slotsPanel);
		slotsFinalPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		slotsFinalPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(slotsFinalPanel);
	}
	
	private static void addSmoothOptions(JPanel finalPanel) {
		Dimension smoothPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		Dimension smoothDimension = new Dimension(width - 20, lineHeight);
		
		JPanel smoothPanel = new JPanel();
		smoothPanel.setLayout(new BoxLayout(smoothPanel, BoxLayout.LINE_AXIS));
		smoothPanel.setBackground(Color.DARK_GRAY);
		smoothPanel.setSize(smoothPanelDimension);
		smoothPanel.setMaximumSize(smoothPanelDimension);
		smoothPanel.setMinimumSize(smoothPanelDimension);
		smoothPanel.setPreferredSize(smoothPanelDimension);
		
		JCheckBox checkBoxSmooth = new JCheckBox("Smooth tiles");
		checkBoxSmooth.setBackground(Color.DARK_GRAY);
		checkBoxSmooth.setForeground(Color.LIGHT_GRAY);
		checkBoxSmooth.setSize(smoothDimension);
		checkBoxSmooth.setMaximumSize(smoothDimension);
		checkBoxSmooth.setMinimumSize(smoothDimension);
		checkBoxSmooth.setPreferredSize(smoothDimension);
		
		checkBoxSmooth.setSelected(Editor.smoothTiles);
		
		checkBoxSmooth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Editor.smoothTiles = checkBoxSmooth.isSelected();
            }
        });
		
		smoothPanel.add(checkBoxSmooth);
		
		finalPanel.add(smoothPanel);
	}
	
	private static void addFilter(JPanel finalPanel) {
		Dimension filterPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		Dimension filterDimension = new Dimension(width - 20, lineHeight);
		
		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.PAGE_AXIS));
		filterPanel.setBackground(Color.DARK_GRAY);
		filterPanel.setSize(filterPanelDimension);
		filterPanel.setMaximumSize(filterPanelDimension);
		filterPanel.setMinimumSize(filterPanelDimension);
		filterPanel.setPreferredSize(filterPanelDimension);
		
		JTextField filterField = new JTextField();
		filterField.setSize(filterDimension);
		filterField.setMaximumSize(filterDimension);
		filterField.setMinimumSize(filterDimension);
		filterField.setPreferredSize(filterDimension);
		filterField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	            	filterTiles(filterField.getText().trim().toLowerCase());
	            }
	        }
	    });
		
		filterPanel.add(filterField);
		
		finalPanel.add(filterPanel);
	}

	private static void addTiles(JPanel finalPanel) {
		int iconScale = 3;
		int iconSize = Sheets.EDITOR_SHEET.tileSize * iconScale;
		int tilesGap = 2;
		int tilesPerLine = 5;
		
		buttonDimension = new Dimension(iconSize, iconSize);
		
		int emptyButtonSpace = 5;
		tilesCount = emptyButtonSpace;
		
		for (TileBluePrint tileBlueprint : Tiles.tileTypes) {
			if (tileBlueprint != null) {
				tilesCount++;
			}
		}
		
		int lines = getLinesCount(tilesCount, tilesPerLine);
		int height = lines * (iconSize + tilesGap * 2);
		
		Dimension scrollPaneDimension = new Dimension(width - 20, 530);
		Dimension panelDimension = new Dimension(width - 50, height);
		
		tilesPanel.setLayout(new GridLayout(lines, tilesPerLine, tilesGap, tilesGap));
		tilesPanel.setSize(panelDimension);
		tilesPanel.setMaximumSize(panelDimension);
		tilesPanel.setMinimumSize(panelDimension);
		tilesPanel.setPreferredSize(panelDimension);
		tilesPanel.setBackground(Color.DARK_GRAY);
		
		int index = 0;
		
		for (TileBluePrint tileBlueprint : Tiles.tileTypes) {
			if (tileBlueprint != null) {
				JButton button = new JButton();
				
				button.setSize(buttonDimension);
				button.setMaximumSize(buttonDimension);
				button.setMinimumSize(buttonDimension);
				button.setPreferredSize(buttonDimension);
				button.setIcon(tileBlueprint.icon);
				button.setActionCommand(tileBlueprint.name.toLowerCase());

				button.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent e){
						if (SwingUtilities.isLeftMouseButton(e)) {
							Editor.tileSlotIDLeft = tileBlueprint.id;
							
							if (leftSlotImage != null) {
								leftSlotImage.setIcon(Tiles.getBluePrintByID(tileBlueprint.id).icon);
							}
		            	}
						
						if (SwingUtilities.isRightMouseButton(e)) {
							Editor.tileSlotIDRight = tileBlueprint.id;
							
							if (rightSlotImage != null) {
								rightSlotImage.setIcon(Tiles.getBluePrintByID(tileBlueprint.id).icon);
							}
		            	}
					}
				});
				
				tilesPanel.add(button);
				
				tilesPanel.revalidate();
				tilesPanel.repaint();
				
				buttons[index] = button;
				index++;
			}
		}
	
		scrollPane = new JScrollPane(tilesPanel);
		scrollPane.setLayout(new ScrollPaneLayout()); 
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane.setSize(scrollPaneDimension);
		scrollPane.setMaximumSize(scrollPaneDimension);
		scrollPane.setMinimumSize(scrollPaneDimension);
		scrollPane.setPreferredSize(scrollPaneDimension);
		scrollPane.getVerticalScrollBar().setUnitIncrement(buttonDimension.height);
		
		finalPanel.add(scrollPane);
	}

	private static int getLinesCount(int count, int space) {
		int intResult = count / space;
		float floatResult = (float) count / (float) space;
		
		if (floatResult > intResult) {
			intResult++;
		}

		return intResult;
	}
	
	private static void filterTiles(String value) {
		tilesPanel.removeAll();
		tilesPanel.revalidate();
		tilesPanel.repaint();
		
		for (JButton button : buttons) {
			if (button !=  null) {
				if (button.getActionCommand().contains(value)) {
					tilesPanel.add(button);
					
					tilesPanel.revalidate();
					tilesPanel.repaint();
				}
			}
		}
		
		for (int i = tilesPanel.getComponentCount(); i < tilesCount; i++) {
			JButton button = new JButton();
			
			button.setSize(buttonDimension);
			button.setMaximumSize(buttonDimension);
			button.setMinimumSize(buttonDimension);
			button.setPreferredSize(buttonDimension);
			button.setBackground(Color.DARK_GRAY);
			
			tilesPanel.add(button);
			tilesPanel.revalidate();
			tilesPanel.repaint();
		}
		
		scrollPane.revalidate();
		scrollPane.repaint();
	}
}
