package game_editor.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import engine.core.LevelEditor;
import engine.sprites.IconLoader;
import game_content.resources.Sheets;

public class EditorGUIWorld {


	public static int width = 280;
	public static int lineHeight = 22;

	public static JPanel generateWorldSettings(LevelEditor levelEditor) {
		JPanel finalPanel = new JPanel();
		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.setBackground(Color.DARK_GRAY);

		addCaption(finalPanel);
		addTimeChange(levelEditor, finalPanel);
		addWorldGenerator(levelEditor, finalPanel);
		addWorldSmooth(levelEditor, finalPanel);
		addUnlock(levelEditor, finalPanel);
		
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

	private static void addTimeChange(LevelEditor levelEditor, JPanel finalPanel) {
		int iconScale = 3;
		int iconSize = Sheets.EDITOR_SHEET.tileSize * iconScale;
		
		JButton editorChangeDayTime= new JButton();
		editorChangeDayTime.setPreferredSize(new Dimension(iconSize, iconSize));
		editorChangeDayTime.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 8, 1, iconScale));
		editorChangeDayTime.setBackground(Color.GRAY);
		
		editorChangeDayTime.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if (SwingUtilities.isLeftMouseButton(e)) {
					levelEditor.setEditorModeDayTime(1);
            	}
				
				if (SwingUtilities.isRightMouseButton(e)) {
					levelEditor.setEditorModeDayTime(-1);
            	}
			}
		});
		
		finalPanel.add(editorChangeDayTime);
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
}
