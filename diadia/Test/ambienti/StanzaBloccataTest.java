package ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata cella;
	private Attrezzo chiave;
	private Stanza gecella;
	private Stanza aula;
	private Stanza segreteria;
	
	@BeforeEach
	public void setup() {
		cella = new StanzaBloccata("cella", "nord", "chiave");
		chiave = new Attrezzo("chiave", 2);
		gecella = new Stanza("cella");
		aula = new Stanza("aula");
		cella.impostaStanzaAdiacente("nord", aula);
		aula.impostaStanzaAdiacente("sud", cella);
		segreteria = new Stanza("segreteria");
		cella.impostaStanzaAdiacente("est", segreteria);
		segreteria.impostaStanzaAdiacente("ovest", cella);
		
		gecella.impostaStanzaAdiacente("nord", aula);
		gecella.impostaStanzaAdiacente("est", segreteria);
	}

	@Test
	void testGetStanzaAdiacenteSuccessoConBloccata() {
		cella.addAttrezzo(chiave);
		
		
		assertEquals(aula, cella.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetStanzaAdiacenteFallimento() {
		assertEquals(cella, cella.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetStanzaAdiacenteNull() {
		cella.setChiave(null);
		
		
		assertEquals(cella, cella.getStanzaAdiacente("nord"));
	}
	
	
	@Test
	void testGetStanzaAdiacenteSuccessoNoBloccata() {
		
		
		assertEquals(segreteria , cella.getStanzaAdiacente("est"));
	}
	
	
	
	
	@Test
	void testGetDescrizioneSuccesso() {
		cella.addAttrezzo(chiave);
		gecella.addAttrezzo(chiave);
		
		assertEquals(gecella.getDescrizione(), cella.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneFallimento() {
		
		assertNotEquals(gecella.getDescrizione(), cella.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneFallimentoNull() {
		cella.setChiave(null);
		
		assertNotEquals(gecella.getDescrizione(), cella.getDescrizione());
	}

}
