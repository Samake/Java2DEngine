package game_editor.gui;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import runnables.LevelEditor;

public class EditorGUIMenuBar {
	
	public static void addMenuBar(LevelEditor levelEditor, JFrame frame) {
		MenuBar menuBar = new MenuBar();  
		Menu menuMap = new Menu("Map");  
 
		MenuItem menuMapNew = new MenuItem("New Map");
		menuMapNew.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					levelEditor.newMap();
				}
			}
        );
		
		MenuItem menuMapLoad = new MenuItem("Load Map");
		menuMapLoad.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					levelEditor.loadMap();
				}
			}
	    );
		
		MenuItem menuMapSave = new MenuItem("Save Map");
		menuMapSave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					levelEditor.saveMap();
				}
			}
        );
         
		menuMap.add(menuMapNew);  
        menuMap.add(menuMapLoad);  
        menuMap.add(menuMapSave);  
         
        menuBar.add(menuMap);
         
        frame.setMenuBar(menuBar); 
	}
}
