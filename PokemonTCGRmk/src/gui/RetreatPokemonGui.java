package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import cardAbstract.Card;
import gui.Panels.GenericCardListPanel;

public class RetreatPokemonGui extends JDialog {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 150;
	
	private List<Card> selectedCards;
	
	public RetreatPokemonGui() {
		super(MainGui.MAIN_GUI, true);
		this.setResizable(false);
		this.setTitle("Choose energy cards");
		this.setLayout(null);
		this.setSize(WIDTH, HEIGHT);
		List<Card> cl = new ArrayList<Card>();
		cl.addAll(MainGui.ARENA.getAttActive().getEnergyCards());
		selectedCards = new ArrayList<Card>();
		try {
			GenericCardListPanel gcl = new GenericCardListPanel(this, cl, SelectedListener.class);
			gcl.setBounds(0, 0, WIDTH, HEIGHT);
			this.add(gcl);
		} catch (Exception e) {
			System.out.println("ERROR: COULD NOT CREATE RETREAT GUI");
		}
	}

	public List<Card> selectedCards() {
		return selectedCards;
	}
}
