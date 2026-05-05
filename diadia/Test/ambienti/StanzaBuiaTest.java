package ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia cella;
	private Attrezzo lanterna;
	private Stanza gecella;
	
	@BeforeEach
	public void setup() {
		cella = new StanzaBuia("cella" ,"lanterna");
		lanterna = new Attrezzo("lanterna",2);
		gecella = new Stanza("cella");
		
	}

	@Test
	void testGetDescrizioneSuccesso() {
		cella.addAttrezzo(lanterna);
		gecella.addAttrezzo(lanterna);
		assertEquals(this.gecella.getDescrizione(), this.cella.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneFallimento() {
		
		assertEquals("Qui c'è buio pesto", this.cella.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneFallimentoNull() {
		cella.setAttrezzoLuce(null);
		assertEquals("Qui c'è buio pesto", this.cella.getDescrizione());
	}

}
