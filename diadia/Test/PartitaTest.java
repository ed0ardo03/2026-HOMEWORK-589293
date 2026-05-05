import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambienti.Stanza;
import diadia.Partita;

class PartitaTest {
	
	private Partita partita;
	private Stanza stanza;
	
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.stanza = new Stanza("Bagno");
		this.partita.setStanzaCorrente(this.stanza);
	}
	
	@Test
	public void testGetStanzaCorrenteIsNull() {
		partita.setStanzaCorrente(null);
		assertNull(partita.getStanzaCorrente());
	}
	
	@Test
	public void tesGetStanzaCorrenteGiusta() {
		assertEquals(this.stanza, this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrenteSbagliata() {
		Stanza stanzaSbagliata = new Stanza("Rambo");
		assertNotEquals(stanzaSbagliata,this.partita.getStanzaCorrente());
	}

}
