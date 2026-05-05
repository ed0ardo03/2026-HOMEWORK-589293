package ambienti;

import attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	private String attrezzoLuce;
	static final private String s = "Qui c'è buio pesto";
	

	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoLuce = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		
		if(this.hasAttrezzo(this.attrezzoLuce)) {
			return super.getDescrizione();
		}else {
			return s;
		}
	}
	
	public void setAttrezzoLuce(String nome) {
		this.attrezzoLuce = nome;
	}
}
