package ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;

class StanzaTest {
	
	private Stanza bagno;
	private Stanza salotto;
	private Attrezzo sandalo;

	@BeforeEach
	public void setUp() {
		
		this.bagno = new Stanza("bagno");
		this.salotto = new Stanza("salotto");
		this.sandalo = new Attrezzo("sandalo",2);
		
	}

	@Test
	public void testImpostaStanzaAdiacenteGiusta() {
		
		this.bagno.impostaStanzaAdiacente("nord", this.salotto);
		this.salotto.impostaStanzaAdiacente("sud", this.bagno);
		assertEquals(this.salotto, this.bagno.getStanzaAdiacente("nord"));
		assertEquals(this.bagno, this.salotto.getStanzaAdiacente("sud"));
		assertEquals(1, this.bagno.getNumeroStanzeadiacenti());
		assertEquals(1, this.salotto.getNumeroStanzeadiacenti());
	}
	
	@Test
	public void testImpostaStanzaAdiacenteNull() {
		
		this.bagno.impostaStanzaAdiacente("nord", null);
		assertNull(this.bagno.getStanzaAdiacente("nord"));
		assertEquals(0, this.bagno.getNumeroStanzeadiacenti());
	}
	
	@Test
	public void testImpostaStanzaAdiacenteDirezioneNull() {
		
		this.bagno.impostaStanzaAdiacente(null, this.salotto);
		
		assertNull(this.bagno.getStanzaAdiacente("nord"));
		assertNull(this.bagno.getStanzaAdiacente("sud"));
		assertNull(this.bagno.getStanzaAdiacente("est"));
		assertNull(this.bagno.getStanzaAdiacente("ovest"));
		assertEquals(0, this.bagno.getNumeroStanzeadiacenti());
		
	}
	
	
	@Test
	public void testImpostaStanzaAdiacentePiena() {
		
		this.bagno.impostaStanzaAdiacente("nord", this.salotto);
		this.bagno.impostaStanzaAdiacente("sud", this.salotto);
		this.bagno.impostaStanzaAdiacente("ovest", this.salotto);
		this.bagno.impostaStanzaAdiacente("est", this.salotto);
		
		assertEquals(4, this.bagno.getNumeroStanzeadiacenti());
		
		this.bagno.impostaStanzaAdiacente("catania", this.salotto);
		
		assertEquals(4, this.bagno.getNumeroStanzeadiacenti());
		assertNull(this.bagno.getStanzaAdiacente("catania"));
	}
	
	@Test
	public void testAddAttrezzoValido() {
		this.bagno.addAttrezzo(sandalo);
		
		assertEquals(1, this.bagno.getNumeroAttrezzi());
		assertTrue(this.bagno.hasAttrezzo("sandalo"));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		this.bagno.addAttrezzo(null);
		
		assertEquals(0, this.bagno.getNumeroAttrezzi());
	}
	
	@Test
	public void testAddAttrezzoStanzaPiena() {
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		this.bagno.addAttrezzo(sandalo);
		assertEquals(10, this.bagno.getNumeroAttrezzi());
		
		assertFalse(this.bagno.addAttrezzo(sandalo));
		
	}

}
