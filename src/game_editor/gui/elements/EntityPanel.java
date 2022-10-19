package game_editor.gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import engine.entities.EntityConfig;

public class EntityPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public EntityConfig entityBlueprint;
	public String name;
	
	public EntityPanel(EntityConfig entityBlueprint) {
		this.entityBlueprint = entityBlueprint;
		this.name = entityBlueprint.name.toLowerCase();
		
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);
	}
}
