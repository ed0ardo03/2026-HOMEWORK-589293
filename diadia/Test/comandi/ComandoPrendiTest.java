package comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;
import diadia.IOConsole;
import diadia.Partita;
import giocatore.Borsa;

class ComandoPrendiTest {
	
	private ComandoPrendi c;
	private Attrezzo ciabatta;
	private Partita p;
	private Borsa b;
	
	@BeforeEach
	public void setup() {
		this.c = new ComandoPrendi();
		this.ciabatta = new Attrezzo("ciabatta", 2);
		this.p = new Partita();
		this.b = p.getGiocatore().getBorsa();
		p.getStanzaCorrente().addAttrezzo(ciabatta);
		c.setParametro("ciabatta");
		this.c.setIOConsole(new IOConsole());
	}

	@Test
	void testEseguiSuccesso() {
		
		c.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("osso"));
		assertFalse(p.getStanzaCorrente().hasAttrezzo("ciabatta"));
		assertEquals(1, p.getStanzaCorrente().getNumeroAttrezzi());
		assertEquals(ciabatta, b.getAttrezzo("ciabatta"));
	}
	
	@Test
	void testEseguiFallimentoParametroInesistente() {
		c.setParametro("ciao");
		c.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("osso"));
		assertFalse(p.getStanzaCorrente().hasAttrezzo("ciao"));
		assertEquals(2, p.getStanzaCorrente().getNumeroAttrezzi());
		assertEquals(0, b.getNumeroAttrezzi());
		assertFalse(b.hasAttrezzo("ciao"));
	}
	
	@Test
	void testEseguiFallimentoNull() {
		c.setParametro(null);
		c.esegui(p);
		assertEquals(2, p.getStanzaCorrente().getNumeroAttrezzi());
		assertEquals(0, b.getNumeroAttrezzi());
	}

}
