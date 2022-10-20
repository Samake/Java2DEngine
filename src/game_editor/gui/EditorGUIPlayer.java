package game_editor.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import engine.entities.EntityConfig;
import engine.entities.npc.clothes.ClothesNPC;
import engine.entities.npc.clothes.ClothesNPC.CLOTHTYPE;
import engine.utils.Misc;
import game_content.entities.player.Player;
import game_content.resources.Clothes;
import game_content.resources.NPCs;
import testgame.LevelEditor;

public class EditorGUIPlayer {
	
	public static Player player;
	public static JTextField xPosTextField;
	public static JTextField yPosTextField;
	
	public static JComboBox<String> skinComboBox;
	public static String skinName = "";
	
	public static JTextField hatTypeTextField;
	public static ArrayList<ClothesNPC> hatTypes;
	
	public static JTextField hairTypeTextField;
	public static ArrayList<ClothesNPC> hairTypes;
	
	public static JTextField eyeTypeTextField;
	public static ArrayList<ClothesNPC> eyeTypes;
	
	public static JTextField mouthTypeTextField;
	public static ArrayList<ClothesNPC> mouthTypes;
	
	public static JTextField beardTypeTextField;
	public static ArrayList<ClothesNPC> beardTypes;
	
	public static JTextField accessoiresTypeTextField;
	public static ArrayList<ClothesNPC> accessoiresTypes;
	
	public static JTextField earTypeTextField;
	public static ArrayList<ClothesNPC> earTypes;
	
	public static JTextField bodyTypeTextField;
	public static ArrayList<ClothesNPC> bodyTypes;
	
	public static JTextField legTypeTextField;
	public static ArrayList<ClothesNPC> legTypes;
	
	public static JTextField feetTypeTextField;
	public static ArrayList<ClothesNPC> feetTypes;
	
	public static int width = 280;
	public static int lineHeight = 22;
	
	public static JPanel generatePlayerSettings(LevelEditor levelEditor) {
		JPanel finalPanel = new JPanel();

		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);

		addCaption(finalPanel);
		addPosition(finalPanel);
		addSkinSelector(levelEditor, finalPanel);
		addHatSelector(levelEditor, finalPanel);
		addHairSelector(levelEditor, finalPanel);
		addEyeSelector(levelEditor, finalPanel);
		addMouthSelector(levelEditor, finalPanel);
		addEarSelector(levelEditor, finalPanel);
		addBeardSelector(levelEditor, finalPanel);
		addAccessoiresSelector(levelEditor, finalPanel);
		addBodySelector(levelEditor, finalPanel);
		addLegSelector(levelEditor, finalPanel);
		addFeetSelector(levelEditor, finalPanel);
		addRandomizer(levelEditor, finalPanel);
		
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
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		
		JPanel skinPanel = new JPanel();
		skinPanel.setLayout(new BoxLayout(skinPanel, BoxLayout.PAGE_AXIS));
		skinPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		skinPanel.setBackground(Color.DARK_GRAY);
		
		JLabel modelLabel = new JLabel("Player Model");
		modelLabel.setForeground(Color.LIGHT_GRAY);
		modelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		modelLabel.setSize(lineDimension);
		modelLabel.setMaximumSize(lineDimension);
		modelLabel.setMinimumSize(lineDimension);
		modelLabel.setPreferredSize(lineDimension);
		
		skinPanel.add(modelLabel);
		
		skinComboBox = new JComboBox<String>();
		skinComboBox.setSize(lineDimension);
		skinComboBox.setMaximumSize(lineDimension);
		skinComboBox.setMinimumSize(lineDimension);
		skinComboBox.setPreferredSize(lineDimension);
		
		for (EntityConfig skin : NPCs.list) {
			if (skin != null) {
				if (skin.name.contains("HUMAN_CHAR")) {
					skinComboBox.addItem(skin.name);
				}
			}
		}
		
		skinComboBox.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
            	 skinName = (String) skinComboBox.getSelectedItem(); 
            	 EntityConfig skin = NPCs.getConfigByName(skinName);
            	 levelEditor.changePlayer(skin);
             }
         });
		
		skinPanel.add(skinComboBox);
		finalPanel.add(skinPanel);
	}
	
	private static void addHatSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		hatTypes = Clothes.getClothesByType(CLOTHTYPE.HAT);
		hatTypes.add(null);
		
		JPanel hatPanel = new JPanel();
		hatPanel.setLayout(new BoxLayout(hatPanel, BoxLayout.PAGE_AXIS));
		hatPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		hatPanel.setBackground(Color.DARK_GRAY);
		
		JLabel hatLabel = new JLabel("Hat Type");
		hatLabel.setForeground(Color.LIGHT_GRAY);
		hatLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		hatLabel.setSize(lineDimension);
		hatLabel.setMaximumSize(lineDimension);
		hatLabel.setMinimumSize(lineDimension);
		hatLabel.setPreferredSize(lineDimension);
		
		hatPanel.add(hatLabel);
		
		JPanel hatSelectorPanel = new JPanel();
		hatSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeHatID(levelEditor, -1);
            }
		});
		
		hatSelectorPanel.add(buttonLeft);
		
		hatTypeTextField = new JTextField("EMPTY");
		hatTypeTextField.setSize(selektorDimension);
		hatTypeTextField.setMaximumSize(selektorDimension);
		hatTypeTextField.setMinimumSize(selektorDimension);
		hatTypeTextField.setPreferredSize(selektorDimension);

		hatSelectorPanel.add(hatTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeHatID(levelEditor, 1);
            }
		});
		
		hatSelectorPanel.add(buttonRight);
		
		hatPanel.add(hatSelectorPanel);
		finalPanel.add(hatPanel);
	}
	
	private static void addHairSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		hairTypes = Clothes.getClothesByType(CLOTHTYPE.HAIR);
		hairTypes.add(null);
		
		JPanel hairPanel = new JPanel();
		hairPanel.setLayout(new BoxLayout(hairPanel, BoxLayout.PAGE_AXIS));
		hairPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		hairPanel.setBackground(Color.DARK_GRAY);
		
		JLabel hairLabel = new JLabel("Hair Type");
		hairLabel.setForeground(Color.LIGHT_GRAY);
		hairLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		hairLabel.setSize(lineDimension);
		hairLabel.setMaximumSize(lineDimension);
		hairLabel.setMinimumSize(lineDimension);
		hairLabel.setPreferredSize(lineDimension);
		
		hairPanel.add(hairLabel);
		
		JPanel hairSelectorPanel = new JPanel();
		hairSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeHairID(levelEditor, -1);
            }
		});
		
		hairSelectorPanel.add(buttonLeft);
		
		hairTypeTextField = new JTextField("EMPTY");
		hairTypeTextField.setSize(selektorDimension);
		hairTypeTextField.setMaximumSize(selektorDimension);
		hairTypeTextField.setMinimumSize(selektorDimension);
		hairTypeTextField.setPreferredSize(selektorDimension);

		hairSelectorPanel.add(hairTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeHairID(levelEditor, 1);
            }
		});
		
		hairSelectorPanel.add(buttonRight);
		
		hairPanel.add(hairSelectorPanel);
		finalPanel.add(hairPanel);
	}
	
	private static void addEyeSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		eyeTypes = Clothes.getClothesByType(CLOTHTYPE.EYES);
		eyeTypes.add(null);
		
		JPanel eyePanel = new JPanel();
		eyePanel.setLayout(new BoxLayout(eyePanel, BoxLayout.PAGE_AXIS));
		eyePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		eyePanel.setBackground(Color.DARK_GRAY);
		
		JLabel eyeLabel = new JLabel("Eye Type");
		eyeLabel.setForeground(Color.LIGHT_GRAY);
		eyeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		eyeLabel.setSize(lineDimension);
		eyeLabel.setMaximumSize(lineDimension);
		eyeLabel.setMinimumSize(lineDimension);
		eyeLabel.setPreferredSize(lineDimension);
		
		eyePanel.add(eyeLabel);
		
		JPanel eyeSelectorPanel = new JPanel();
		eyeSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeEyeID(levelEditor, -1);
            }
		});
		
		eyeSelectorPanel.add(buttonLeft);
		
		eyeTypeTextField = new JTextField("EMPTY");
		eyeTypeTextField.setSize(selektorDimension);
		eyeTypeTextField.setMaximumSize(selektorDimension);
		eyeTypeTextField.setMinimumSize(selektorDimension);
		eyeTypeTextField.setPreferredSize(selektorDimension);

		eyeSelectorPanel.add(eyeTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeEyeID(levelEditor, 1);
            }
		});
		
		eyeSelectorPanel.add(buttonRight);
		
		eyePanel.add(eyeSelectorPanel);
		finalPanel.add(eyePanel);
	}
	
	private static void addMouthSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		mouthTypes = Clothes.getClothesByType(CLOTHTYPE.MOUTH);
		mouthTypes.add(null);
		
		JPanel mouthPanel = new JPanel();
		mouthPanel.setLayout(new BoxLayout(mouthPanel, BoxLayout.PAGE_AXIS));
		mouthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mouthPanel.setBackground(Color.DARK_GRAY);
		
		JLabel mouthLabel = new JLabel("Mouth Type");
		mouthLabel.setForeground(Color.LIGHT_GRAY);
		mouthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mouthLabel.setSize(lineDimension);
		mouthLabel.setMaximumSize(lineDimension);
		mouthLabel.setMinimumSize(lineDimension);
		mouthLabel.setPreferredSize(lineDimension);
		
		mouthPanel.add(mouthLabel);
		
		JPanel mouthSelectorPanel = new JPanel();
		mouthSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeMouthID(levelEditor, -1);
            }
		});
		
		mouthSelectorPanel.add(buttonLeft);
		
		mouthTypeTextField = new JTextField("EMPTY");
		mouthTypeTextField.setSize(selektorDimension);
		mouthTypeTextField.setMaximumSize(selektorDimension);
		mouthTypeTextField.setMinimumSize(selektorDimension);
		mouthTypeTextField.setPreferredSize(selektorDimension);

		mouthSelectorPanel.add(mouthTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeMouthID(levelEditor, 1);
            }
		});
		
		mouthSelectorPanel.add(buttonRight);
		
		mouthPanel.add(mouthSelectorPanel);
		finalPanel.add(mouthPanel);
	}
	
	private static void addEarSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		earTypes = Clothes.getClothesByType(CLOTHTYPE.EAR);
		earTypes.add(null);
		
		JPanel earPanel = new JPanel();
		earPanel.setLayout(new BoxLayout(earPanel, BoxLayout.PAGE_AXIS));
		earPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		earPanel.setBackground(Color.DARK_GRAY);
		
		JLabel earLabel = new JLabel("Ear Type");
		earLabel.setForeground(Color.LIGHT_GRAY);
		earLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		earLabel.setSize(lineDimension);
		earLabel.setMaximumSize(lineDimension);
		earLabel.setMinimumSize(lineDimension);
		earLabel.setPreferredSize(lineDimension);
		
		earPanel.add(earLabel);
		
		JPanel earSelectorPanel = new JPanel();
		earSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeEarID(levelEditor, -1);
            }
		});
		
		earSelectorPanel.add(buttonLeft);
		
		earTypeTextField = new JTextField("EMPTY");
		earTypeTextField.setSize(selektorDimension);
		earTypeTextField.setMaximumSize(selektorDimension);
		earTypeTextField.setMinimumSize(selektorDimension);
		earTypeTextField.setPreferredSize(selektorDimension);

		earSelectorPanel.add(earTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeEarID(levelEditor, 1);
            }
		});
		
		earSelectorPanel.add(buttonRight);
		
		earPanel.add(earSelectorPanel);
		finalPanel.add(earPanel);
	}
	
	private static void addBeardSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		beardTypes = Clothes.getClothesByType(CLOTHTYPE.BEARD);
		beardTypes.add(null);
		
		JPanel beardPanel = new JPanel();
		beardPanel.setLayout(new BoxLayout(beardPanel, BoxLayout.PAGE_AXIS));
		beardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		beardPanel.setBackground(Color.DARK_GRAY);
		
		JLabel beardLabel = new JLabel("Beard Type");
		beardLabel.setForeground(Color.LIGHT_GRAY);
		beardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		beardLabel.setSize(lineDimension);
		beardLabel.setMaximumSize(lineDimension);
		beardLabel.setMinimumSize(lineDimension);
		beardLabel.setPreferredSize(lineDimension);
		
		beardPanel.add(beardLabel);
		
		JPanel mouthSelectorPanel = new JPanel();
		mouthSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeBeardID(levelEditor, -1);
            }
		});
		
		mouthSelectorPanel.add(buttonLeft);
		
		beardTypeTextField = new JTextField("EMPTY");
		beardTypeTextField.setSize(selektorDimension);
		beardTypeTextField.setMaximumSize(selektorDimension);
		beardTypeTextField.setMinimumSize(selektorDimension);
		beardTypeTextField.setPreferredSize(selektorDimension);

		mouthSelectorPanel.add(beardTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeBeardID(levelEditor, 1);
            }
		});
		
		mouthSelectorPanel.add(buttonRight);
		
		beardPanel.add(mouthSelectorPanel);
		finalPanel.add(beardPanel);
	}
	
	private static void addAccessoiresSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		accessoiresTypes = Clothes.getClothesByType(CLOTHTYPE.ACCESSOIRES);
		accessoiresTypes.add(null);
		
		JPanel accessoiresPanel = new JPanel();
		accessoiresPanel.setLayout(new BoxLayout(accessoiresPanel, BoxLayout.PAGE_AXIS));
		accessoiresPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		accessoiresPanel.setBackground(Color.DARK_GRAY);
		
		JLabel beardLabel = new JLabel("Accessoires Type");
		beardLabel.setForeground(Color.LIGHT_GRAY);
		beardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		beardLabel.setSize(lineDimension);
		beardLabel.setMaximumSize(lineDimension);
		beardLabel.setMinimumSize(lineDimension);
		beardLabel.setPreferredSize(lineDimension);
		
		accessoiresPanel.add(beardLabel);
		
		JPanel accessoiresSelectorPanel = new JPanel();
		accessoiresSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeAccessoiresID(levelEditor, -1);
            }
		});
		
		accessoiresSelectorPanel.add(buttonLeft);
		
		accessoiresTypeTextField = new JTextField("EMPTY");
		accessoiresTypeTextField.setSize(selektorDimension);
		accessoiresTypeTextField.setMaximumSize(selektorDimension);
		accessoiresTypeTextField.setMinimumSize(selektorDimension);
		accessoiresTypeTextField.setPreferredSize(selektorDimension);

		accessoiresSelectorPanel.add(accessoiresTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeAccessoiresID(levelEditor, 1);
            }
		});
		
		accessoiresSelectorPanel.add(buttonRight);
		
		accessoiresPanel.add(accessoiresSelectorPanel);
		finalPanel.add(accessoiresPanel);
	}
	
	private static void addBodySelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		bodyTypes = Clothes.getClothesByType(CLOTHTYPE.BODY);
		bodyTypes.add(null);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.PAGE_AXIS));
		bodyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		bodyPanel.setBackground(Color.DARK_GRAY);
		
		JLabel bodyLabel = new JLabel("Body Type");
		bodyLabel.setForeground(Color.LIGHT_GRAY);
		bodyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		bodyLabel.setSize(lineDimension);
		bodyLabel.setMaximumSize(lineDimension);
		bodyLabel.setMinimumSize(lineDimension);
		bodyLabel.setPreferredSize(lineDimension);
		
		bodyPanel.add(bodyLabel);
		
		JPanel bodySelectorPanel = new JPanel();
		bodySelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeBodyID(levelEditor, -1);
            }
		});
		
		bodySelectorPanel.add(buttonLeft);
		
		bodyTypeTextField = new JTextField("EMPTY");
		bodyTypeTextField.setSize(selektorDimension);
		bodyTypeTextField.setMaximumSize(selektorDimension);
		bodyTypeTextField.setMinimumSize(selektorDimension);
		bodyTypeTextField.setPreferredSize(selektorDimension);

		bodySelectorPanel.add(bodyTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeBodyID(levelEditor, 1);
            }
		});
		
		bodySelectorPanel.add(buttonRight);
		
		bodyPanel.add(bodySelectorPanel);
		finalPanel.add(bodyPanel);
	}
	
	private static void addLegSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		legTypes = Clothes.getClothesByType(CLOTHTYPE.LEGS);
		legTypes.add(null);
		
		JPanel legsPanel = new JPanel();
		legsPanel.setLayout(new BoxLayout(legsPanel, BoxLayout.PAGE_AXIS));
		legsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		legsPanel.setBackground(Color.DARK_GRAY);
		
		JLabel legsLabel = new JLabel("Legs Type");
		legsLabel.setForeground(Color.LIGHT_GRAY);
		legsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		legsLabel.setSize(lineDimension);
		legsLabel.setMaximumSize(lineDimension);
		legsLabel.setMinimumSize(lineDimension);
		legsLabel.setPreferredSize(lineDimension);
		
		legsPanel.add(legsLabel);
		
		JPanel legsSelectorPanel = new JPanel();
		legsSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeLegsID(levelEditor, -1);
            }
		});
		
		legsSelectorPanel.add(buttonLeft);
		
		legTypeTextField = new JTextField("EMPTY");
		legTypeTextField.setSize(selektorDimension);
		legTypeTextField.setMaximumSize(selektorDimension);
		legTypeTextField.setMinimumSize(selektorDimension);
		legTypeTextField.setPreferredSize(selektorDimension);

		legsSelectorPanel.add(legTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeLegsID(levelEditor, 1);
            }
		});
		
		legsSelectorPanel.add(buttonRight);
		
		legsPanel.add(legsSelectorPanel);
		finalPanel.add(legsPanel);
	}
	
	private static void addFeetSelector(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension lineDimension = new Dimension(width - 20, lineHeight);
		Dimension buttonDimension = new Dimension(42, lineHeight);
		Dimension selektorDimension = new Dimension(width - 115, lineHeight);
		
		feetTypes = Clothes.getClothesByType(CLOTHTYPE.FEET);
		feetTypes.add(null);
		
		JPanel feetsPanel = new JPanel();
		feetsPanel.setLayout(new BoxLayout(feetsPanel, BoxLayout.PAGE_AXIS));
		feetsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		feetsPanel.setBackground(Color.DARK_GRAY);
		
		JLabel feetsLabel = new JLabel("Feets Type");
		feetsLabel.setForeground(Color.LIGHT_GRAY);
		feetsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		feetsLabel.setSize(lineDimension);
		feetsLabel.setMaximumSize(lineDimension);
		feetsLabel.setMinimumSize(lineDimension);
		feetsLabel.setPreferredSize(lineDimension);
		
		feetsPanel.add(feetsLabel);
		
		JPanel feetsSelectorPanel = new JPanel();
		feetsSelectorPanel.setBackground(Color.DARK_GRAY);
		
		JButton buttonLeft = new JButton("<");
		buttonLeft.setBackground(Color.DARK_GRAY);
		buttonLeft.setForeground(Color.LIGHT_GRAY);
		buttonLeft.setSize(buttonDimension);
		buttonLeft.setMaximumSize(buttonDimension);
		buttonLeft.setMinimumSize(buttonDimension);
		buttonLeft.setPreferredSize(buttonDimension);
		
		buttonLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeFeetsID(levelEditor, -1);
            }
		});
		
		feetsSelectorPanel.add(buttonLeft);
		
		feetTypeTextField = new JTextField("EMPTY");
		feetTypeTextField.setSize(selektorDimension);
		feetTypeTextField.setMaximumSize(selektorDimension);
		feetTypeTextField.setMinimumSize(selektorDimension);
		feetTypeTextField.setPreferredSize(selektorDimension);

		feetsSelectorPanel.add(feetTypeTextField);
		
		JButton buttonRight = new JButton(">");
		buttonRight.setBackground(Color.DARK_GRAY);
		buttonRight.setForeground(Color.LIGHT_GRAY);
		buttonRight.setSize(buttonDimension);
		buttonRight.setMaximumSize(buttonDimension);
		buttonRight.setMinimumSize(buttonDimension);
		buttonRight.setPreferredSize(buttonDimension);
		
		buttonRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changeFeetsID(levelEditor, 1);
            }
		});
		
		feetsSelectorPanel.add(buttonRight);
		
		feetsPanel.add(feetsSelectorPanel);
		finalPanel.add(feetsPanel);
	}
	
	private static void addRandomizer(LevelEditor levelEditor, JPanel finalPanel) {
		Dimension randomizerPanelDimension = new Dimension(width - 20, (int) (lineHeight * 1.5));
		
		JPanel randomizerPanel = new JPanel();
		randomizerPanel.setLayout(new BoxLayout(randomizerPanel, BoxLayout.PAGE_AXIS));
		randomizerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		randomizerPanel.setBackground(Color.DARK_GRAY);
		randomizerPanel.setSize(randomizerPanelDimension);
		randomizerPanel.setMaximumSize(randomizerPanelDimension);
		randomizerPanel.setMinimumSize(randomizerPanelDimension);
		randomizerPanel.setPreferredSize(randomizerPanelDimension);
		
		JButton randomButton = new JButton("Random Character");
		randomButton.setBackground(Color.DARK_GRAY);
		randomButton.setForeground(Color.LIGHT_GRAY);
		
		randomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	randomizeCharacter(levelEditor);
            }
		});
		
		randomizerPanel.add(randomButton);
		
		finalPanel.add(randomizerPanel);
	}
	
	private static void randomizeCharacter(LevelEditor levelEditor) {
		int hatRandomValue = Misc.randomInteger(0, 100);
		int earRandomValue = Misc.randomInteger(0, 100);
		int beardRandomValue = Misc.randomInteger(0, 100);
		int accessoireRandomValue = Misc.randomInteger(0, 100);
		
		if (hatRandomValue > 65) {
			levelEditor.changePlayerHat(hatTypes.get(Misc.randomInteger(0, hatTypes.size() - 1)));
		} else {
			levelEditor.changePlayerHat(null);
		}
		
		if (earRandomValue > 80) {
			levelEditor.changePlayerEar(earTypes.get(Misc.randomInteger(0, earTypes.size() - 1)));
		} else {
			levelEditor.changePlayerEar(null);
		}
		
		if (beardRandomValue > 95) {
			levelEditor.changePlayerBeard(beardTypes.get(Misc.randomInteger(0, beardTypes.size() - 1)));
		} else {
			levelEditor.changePlayerBeard(null);
		}
		
		if (accessoireRandomValue > 85) {
			levelEditor.changePlayerAccessoire(accessoiresTypes.get(Misc.randomInteger(0, accessoiresTypes.size() - 1)));
		} else {
			levelEditor.changePlayerAccessoire(null);
		}
		
		levelEditor.changePlayerHair(hairTypes.get(Misc.randomInteger(0, hairTypes.size() - 1)));
		levelEditor.changePlayerEyes(eyeTypes.get(Misc.randomInteger(0, eyeTypes.size() - 1)));
		levelEditor.changePlayerMouth(mouthTypes.get(Misc.randomInteger(0, mouthTypes.size() - 1)));
		levelEditor.changePlayerBody(bodyTypes.get(Misc.randomInteger(0, bodyTypes.size() - 1)));
		levelEditor.changePlayerLegs(legTypes.get(Misc.randomInteger(0, legTypes.size() - 1)));
		levelEditor.changePlayerFeets(feetTypes.get(Misc.randomInteger(0, feetTypes.size() - 1)));
		
	}

	private static void changeHatID(LevelEditor levelEditor, int value) {
		if (hatTypes.size() > 1) {
			int currentHatID = getCurrentHatID();
			int newHatID = currentHatID + value;
	
			if (newHatID >= 0 && newHatID <= hatTypes.size() - 1) {
				levelEditor.changePlayerHat(hatTypes.get(newHatID));
				return;
			} else {
				if (newHatID >= hatTypes.size()) {
					levelEditor.changePlayerHat(hatTypes.get(0));
					return;
				} 
				
				if (newHatID == -1) {
					int id = hatTypes.size() - 1;
					levelEditor.changePlayerHat(hatTypes.get(id));
					return;
				}
				
				if (newHatID <= -2) {
					int id = hatTypes.size() - 2;
					levelEditor.changePlayerHat(hatTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentHatID() {
		for (ClothesNPC hat : hatTypes) {
			if (hat != null) {
				if (hat.name.equals(hatTypeTextField.getText())) {
					return hatTypes.indexOf(hat);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeHairID(LevelEditor levelEditor, int value) {
		if (hairTypes.size() > 1) {
			int currentHairID = getCurrentHairID();
			int newhairID = currentHairID + value;
	
			if (newhairID >= 0 && newhairID <= hairTypes.size() - 1) {
				levelEditor.changePlayerHair(hairTypes.get(newhairID));
				return;
			} else {
				if (newhairID >= hairTypes.size()) {
					levelEditor.changePlayerHair(hairTypes.get(0));
					return;
				} 
				
				if (newhairID == -1) {
					int id = hairTypes.size() - 1;
					levelEditor.changePlayerHair(hairTypes.get(id));
					return;
				}
				
				if (newhairID <= -2) {
					int id = hairTypes.size() - 2;
					levelEditor.changePlayerHair(hairTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentHairID() {
		for (ClothesNPC hair : hairTypes) {
			if (hair != null) {
				if (hair.name.equals(hairTypeTextField.getText())) {
					return hairTypes.indexOf(hair);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeEyeID(LevelEditor levelEditor, int value) {
		if (eyeTypes.size() > 1) {
			int currentEyeID = getCurrentEyeID();
			int newEyeID = currentEyeID + value;
	
			if (newEyeID >= 0 && newEyeID <= eyeTypes.size() - 1) {
				levelEditor.changePlayerEyes(eyeTypes.get(newEyeID));
				return;
			} else {
				if (newEyeID >= eyeTypes.size()) {
					levelEditor.changePlayerEyes(eyeTypes.get(0));
					return;
				} 
				
				if (newEyeID == -1) {
					int id = eyeTypes.size() - 1;
					levelEditor.changePlayerEyes(eyeTypes.get(id));
					return;
				}
				
				if (newEyeID <= -2) {
					int id = eyeTypes.size() - 2;
					levelEditor.changePlayerEyes(eyeTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentEyeID() {
		for (ClothesNPC eye : eyeTypes) {
			if (eye != null) {
				if (eye.name.equals(eyeTypeTextField.getText())) {
					return eyeTypes.indexOf(eye);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeMouthID(LevelEditor levelEditor, int value) {
		if (mouthTypes.size() > 1) {
			int currentMouthID = getCurrentMouthID();
			int newMouthID = currentMouthID + value;
	
			if (newMouthID >= 0 && newMouthID <= mouthTypes.size() - 1) {
				levelEditor.changePlayerMouth(mouthTypes.get(newMouthID));
				return;
			} else {
				if (newMouthID >= mouthTypes.size()) {
					levelEditor.changePlayerMouth(mouthTypes.get(0));
					return;
				} 
				
				if (newMouthID == -1) {
					int id = mouthTypes.size() - 1;
					levelEditor.changePlayerMouth(mouthTypes.get(id));
					return;
				}
				
				if (newMouthID <= -2) {
					int id = mouthTypes.size() - 2;
					levelEditor.changePlayerMouth(mouthTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentMouthID() {
		for (ClothesNPC mouth : mouthTypes) {
			if (mouth != null) {
				if (mouth.name.equals(mouthTypeTextField.getText())) {
					return mouthTypes.indexOf(mouth);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeEarID(LevelEditor levelEditor, int value) {
		if (earTypes.size() > 1) {
			int currentEarID = getCurrentEarID();
			int newEarID = currentEarID + value;

			if (newEarID >= 0 && newEarID <= earTypes.size() - 1) {
				levelEditor.changePlayerEar(earTypes.get(newEarID));
				return;
			} else {
				if (newEarID >= earTypes.size()) {
					levelEditor.changePlayerEar(earTypes.get(0));
					return;
				} 
				
				if (newEarID == -1) {
					int id = earTypes.size() - 1;
					levelEditor.changePlayerEar(earTypes.get(id));
					return;
				}
				
				if (newEarID <= -2) {
					int id = earTypes.size() - 2;
					levelEditor.changePlayerEar(earTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentEarID() {
		for (ClothesNPC ear : earTypes) {
			if (ear != null) {
				if (ear.name.equals(earTypeTextField.getText())) {
					return earTypes.indexOf(ear);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeBeardID(LevelEditor levelEditor, int value) {
		if (beardTypes.size() > 1) {
			int currentBeardID = getCurrentBeardID();
			int newBeardID = currentBeardID + value;

			if (newBeardID >= 0 && newBeardID <= beardTypes.size() - 1) {
				levelEditor.changePlayerBeard(beardTypes.get(newBeardID));
				return;
			} else {
				if (newBeardID >= beardTypes.size()) {
					levelEditor.changePlayerBeard(beardTypes.get(0));
					return;
				} 
				
				if (newBeardID == -1) {
					int id = beardTypes.size() - 1;
					levelEditor.changePlayerBeard(beardTypes.get(id));
					return;
				}
				
				if (newBeardID <= -2) {
					int id = beardTypes.size() - 2;
					levelEditor.changePlayerBeard(beardTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentBeardID() {
		for (ClothesNPC beard : beardTypes) {
			if (beard != null) {
				if (beard.name.equals(beardTypeTextField.getText())) {
					return beardTypes.indexOf(beard);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeAccessoiresID(LevelEditor levelEditor, int value) {
		if (accessoiresTypes.size() > 1) {
			int currentAccessoireID = getCurrentAccessoiresID();
			int newAccessoireID = currentAccessoireID + value;

			if (newAccessoireID >= 0 && newAccessoireID <= accessoiresTypes.size() - 1) {
				levelEditor.changePlayerAccessoire(accessoiresTypes.get(newAccessoireID));
				return;
			} else {
				if (newAccessoireID >= accessoiresTypes.size()) {
					levelEditor.changePlayerAccessoire(accessoiresTypes.get(0));
					return;
				} 
				
				if (newAccessoireID == -1) {
					int id = accessoiresTypes.size() - 1;
					levelEditor.changePlayerAccessoire(accessoiresTypes.get(id));
					return;
				}
				
				if (newAccessoireID <= -2) {
					int id = accessoiresTypes.size() - 2;
					levelEditor.changePlayerAccessoire(accessoiresTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentAccessoiresID() {
		for (ClothesNPC accessoire : accessoiresTypes) {
			if (accessoire != null) {
				if (accessoire.name.equals(accessoiresTypeTextField.getText())) {
					return accessoiresTypes.indexOf(accessoire);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeBodyID(LevelEditor levelEditor, int value) {
		if (bodyTypes.size() > 1) {
			int currentBodyID = getCurrentBodyID();
			int newBodyID = currentBodyID + value;
	
			if (newBodyID >= 0 && newBodyID <= bodyTypes.size() - 1) {
				levelEditor.changePlayerBody(bodyTypes.get(newBodyID));
				return;
			} else {
				if (newBodyID >= bodyTypes.size()) {
					levelEditor.changePlayerBody(bodyTypes.get(0));
					return;
				} 
				
				if (newBodyID == -1) {
					int id = bodyTypes.size() - 1;
					levelEditor.changePlayerBody(bodyTypes.get(id));
					return;
				}
				
				if (newBodyID <= -2) {
					int id = bodyTypes.size() - 2;
					levelEditor.changePlayerBody(bodyTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentBodyID() {
		for (ClothesNPC body : bodyTypes) {
			if (body != null) {
				if (body.name.equals(bodyTypeTextField.getText())) {
					return bodyTypes.indexOf(body);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeLegsID(LevelEditor levelEditor, int value) {
		if (legTypes.size() > 1) {
			int currentLegsID = getCurrentLegsID();
			int newLegsID = currentLegsID + value;
	
			if (newLegsID >= 0 && newLegsID <= legTypes.size() - 1) {
				levelEditor.changePlayerLegs(legTypes.get(newLegsID));
				return;
			} else {
				if (newLegsID >= legTypes.size()) {
					levelEditor.changePlayerLegs(legTypes.get(0));
					return;
				} 
				
				if (newLegsID == -1) {
					int id = legTypes.size() - 1;
					levelEditor.changePlayerLegs(legTypes.get(id));
					return;
				}
				
				if (newLegsID <= -2) {
					int id = legTypes.size() - 2;
					levelEditor.changePlayerLegs(legTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentLegsID() {
		for (ClothesNPC legs : legTypes) {
			if (legs != null) {
				if (legs.name.equals(legTypeTextField.getText())) {
					return legTypes.indexOf(legs);
				}
			}
		}
		
		return -1;
	}
	
	private static void changeFeetsID(LevelEditor levelEditor, int value) {
		if (feetTypes.size() > 1) {
			int currentFeetsID = getCurrentFeetsID();
			int newFeetsID = currentFeetsID + value;
	
			if (newFeetsID >= 0 && newFeetsID <= feetTypes.size() - 1) {
				levelEditor.changePlayerFeets(feetTypes.get(newFeetsID));
				return;
			} else {
				if (newFeetsID >= feetTypes.size()) {
					levelEditor.changePlayerFeets(feetTypes.get(0));
					return;
				} 
				
				if (newFeetsID == -1) {
					int id = feetTypes.size() - 1;
					levelEditor.changePlayerFeets(feetTypes.get(id));
					return;
				}
				
				if (newFeetsID <= -2) {
					int id = feetTypes.size() - 2;
					levelEditor.changePlayerFeets(feetTypes.get(id));
					return;
				}
			}
		}
	}
	
	private static int getCurrentFeetsID() {
		for (ClothesNPC feets : feetTypes) {
			if (feets != null) {
				if (feets.name.equals(feetTypeTextField.getText())) {
					return feetTypes.indexOf(feets);
				}
			}
		}
		
		return -1;
	}

	public static void updatePlayerValues(Player playerIn) {
		player = playerIn;
		
		if (player != null) {
			xPosTextField.setText(String.valueOf((int) player.position.x));
			yPosTextField.setText(String.valueOf((int) player.position.y));
	
			if (!skinComboBox.getSelectedItem().toString().equals(player.config.name)) {
				skinComboBox.setSelectedItem(player.config.name);
			}
			
			if (player.hatSlot.cloth != null) {
				hatTypeTextField.setText(player.hatSlot.cloth.name);
			} else {
				hatTypeTextField.setText("EMPTY");
			}
			
			if (player.hairSlot.cloth != null) {
				hairTypeTextField.setText(player.hairSlot.cloth.name);
			} else {
				hairTypeTextField.setText("EMPTY");
			}
			
			if (player.eyeSlot.cloth != null) {
				eyeTypeTextField.setText(player.eyeSlot.cloth.name);
			} else {
				eyeTypeTextField.setText("EMPTY");
			}
			
			if (player.mouthSlot.cloth != null) {
				mouthTypeTextField.setText(player.mouthSlot.cloth.name);
			} else {
				mouthTypeTextField.setText("EMPTY");
			}
			
			if (player.earSlot.cloth != null) {
				earTypeTextField.setText(player.earSlot.cloth.name);
			} else {
				earTypeTextField.setText("EMPTY");
			}
			
			if (player.beardSlot.cloth != null) {
				beardTypeTextField.setText(player.beardSlot.cloth.name);
			} else {
				beardTypeTextField.setText("EMPTY");
			}
			
			if (player.accessoiresSlot.cloth != null) {
				accessoiresTypeTextField.setText(player.accessoiresSlot.cloth.name);
			} else {
				accessoiresTypeTextField.setText("EMPTY");
			}
			
			if (player.bodySlot.cloth != null) {
				bodyTypeTextField.setText(player.bodySlot.cloth.name);
			} else {
				bodyTypeTextField.setText("EMPTY");
			}
			
			if (player.legSlot.cloth != null) {
				legTypeTextField.setText(player.legSlot.cloth.name);
			} else {
				legTypeTextField.setText("EMPTY");
			}
			
			if (player.feetSlot.cloth != null) {
				feetTypeTextField.setText(player.feetSlot.cloth.name);
			} else {
				feetTypeTextField.setText("EMPTY");
			}
		}
	}
}
