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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import engine.entities.EntityBluePrint;
import game_content.entities.player.Player;
import game_content.resources.NPCs;
import testgame.LevelEditor;

public class EditorGUIPlayer {
	
	public static Player player;
	public static JTextField xPosTextField;
	public static JTextField yPosTextField;
	public static JComboBox<String> skinComboBox;
	public static String skinName = "";

	public static int width = 280;
	public static int lineHeight = 22;
	
	public static JPanel generatePlayerSettings(LevelEditor levelEditor) {
		JPanel finalPanel = new JPanel();

		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);

		addCaption(finalPanel);
		addPosition(finalPanel);
		addSkinSelector(levelEditor, finalPanel);
		
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
		
		JLabel captionLabel = new JLabel("PLAYER SETTINGS");
		captionLabel.setForeground(Color.LIGHT_GRAY);
		captionPanel.add(captionLabel);
		
		captionPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(captionPanel);
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
	            	if (player != null) {
	        			int xPos = Integer.valueOf(xPosTextField.getText().trim());
	        			
	        			player.position.x = xPos;
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
	            	if (player != null) {
	        			int yPos = Integer.valueOf(yPosTextField.getText().trim());
	        			
	        			player.position.y = yPos;
	        		}
	            }
	        }
	    });
		
		positionPanel.add(yPosTextField);
		
		positionFinalPanel.add(positionPanel);
		positionFinalPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		finalPanel.add(positionFinalPanel);
	}
	
	private static void addSkinSelector(LevelEditor levelEditor, JPanel finalPanel) {
		
		JPanel skinPanel = new JPanel();
		skinPanel.setLayout(new BoxLayout(skinPanel, BoxLayout.PAGE_AXIS));
		skinPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		skinPanel.setBackground(Color.DARK_GRAY);
		
		skinComboBox = new JComboBox<String>();
		
		for (EntityBluePrint skin : NPCs.npcList) {
			if (skin != null) {
				skinComboBox.addItem(skin.name);
			}
		}
		
		skinComboBox.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
            	 skinName = (String) skinComboBox.getSelectedItem();
            	 
            	 EntityBluePrint skin = NPCs.getBluePrintByName(skinName);

            	 levelEditor.changePlayer(skin);
             }
         });
		
		skinPanel.add(skinComboBox);
		finalPanel.add(skinPanel);
	}
	
	public static void updatePlayerValues(Player playerIn) {
		player = playerIn;
		
		if (player != null) {
			xPosTextField.setText(String.valueOf((int) player.position.x));
			yPosTextField.setText(String.valueOf((int) player.position.y));
			//skinComboBox.setSelectedItem(player.bluePrint.name);
		}
	}
}
