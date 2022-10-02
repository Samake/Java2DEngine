package game_editor.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.sprites.IconLoader;
import game_content.resources.Sheets;
import testgame.LevelEditor;

public class EditorGUISlots {

	public static void addEditorSlots(LevelEditor levelEditor, JFrame frame) {
		int iconScale = 3;
		int iconSize = Sheets.EDITOR_SHEET.tileSize * iconScale;
		
		JPanel editorModesPanel = new JPanel();
		editorModesPanel.setBackground(Color.DARK_GRAY);
		
		JButton editorModeTiles = new JButton();
		editorModeTiles.setPreferredSize(new Dimension(iconSize, iconSize));
		editorModeTiles.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 0, 0, 1, 1, iconScale));
		editorModeTiles.setBackground(Color.GRAY);
		
		editorModeTiles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorModeTiles();
            }
        });
		
		editorModesPanel.add(editorModeTiles);
		
		JButton editorModeEntities = new JButton();
		editorModeEntities.setPreferredSize(new Dimension(iconSize, iconSize));
		editorModeEntities.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 1, 0, 1, 1, iconScale));
		editorModeEntities.setBackground(Color.GRAY);
		
		editorModeEntities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorModeEntities();
            }
        });
		
		editorModesPanel.add(editorModeEntities);
		
		JButton editorModeLights = new JButton();
		editorModeLights.setPreferredSize(new Dimension(iconSize, iconSize));
		editorModeLights.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 2, 0, 1, 1, iconScale));
		editorModeLights.setBackground(Color.GRAY);
		
		editorModeLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorModeLights();
            }
        });
		
		editorModesPanel.add(editorModeLights);
		
		JButton editorModeSounds = new JButton();
		editorModeSounds.setPreferredSize(new Dimension(iconSize, iconSize));
		editorModeSounds.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 3, 0, 1, 1, iconScale));
		editorModeSounds.setBackground(Color.GRAY);
		
		editorModeSounds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorModeSounds();
            }
        });
		
		editorModesPanel.add(editorModeSounds);
		
		JButton editorModePlayer = new JButton();
		editorModePlayer.setPreferredSize(new Dimension(iconSize, iconSize));
		editorModePlayer.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 4, 0, 1, 1, iconScale));
		editorModePlayer.setBackground(Color.GRAY);
		
		editorModePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorModePlayer();
            }
        });
		
		editorModesPanel.add(editorModePlayer);
		
		JButton editorModePrefabs = new JButton();
		editorModePrefabs.setPreferredSize(new Dimension(iconSize, iconSize));
		editorModePrefabs.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 5, 0, 1, 1, iconScale));
		editorModePrefabs.setBackground(Color.GRAY);
		
		editorModePrefabs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorModePrefabs();
            }
        });
		
		editorModesPanel.add(editorModePrefabs);
		
		JButton editorMode7= new JButton();
		editorMode7.setPreferredSize(new Dimension(iconSize, iconSize));
		editorMode7.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 6, 0, 1, 1, iconScale));
		editorMode7.setBackground(Color.GRAY);
		
		editorMode7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorMode7();
            }
        });
		
		editorModesPanel.add(editorMode7);
		
		JButton editorMode8= new JButton();
		editorMode8.setPreferredSize(new Dimension(iconSize, iconSize));
		editorMode8.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 7, 0, 1, 1, iconScale));
		editorMode8.setBackground(Color.GRAY);
		
		editorMode8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	levelEditor.setEditorMode8();
            }
        });
		
		editorModesPanel.add(editorMode8);
		
		JButton editorChangeDayTime= new JButton();
		editorChangeDayTime.setPreferredSize(new Dimension(iconSize, iconSize));
		editorChangeDayTime.setIcon(IconLoader.getIconfromSheet(Sheets.EDITOR_SHEET, 8, 0, 1, 1, iconScale));
		editorChangeDayTime.setBackground(Color.GRAY);
		
		editorChangeDayTime.addActionListener(new ActionListener(){
			 @Override
	            public void actionPerformed(ActionEvent e) {
	            	levelEditor.setEditorModeWorld();
	            }
	        });
		
		editorModesPanel.add(editorChangeDayTime);
		
		frame.add(editorModesPanel, BorderLayout.SOUTH);
	}
}
