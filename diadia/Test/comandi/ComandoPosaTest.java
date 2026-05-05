package comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;
import diadia.IOConsole;
import diadia.Partita;
import giocatore.Borsa;

class ComandoPosaTest {
	
	private ComandoPosa c;
	private Partita p;
	private Borsa b;
	private Attrezzo ciabatta;
	private Attrezzo sandalo;
	
	@BeforeEach
	public void setup() {
		this.c = new ComandoPosa();
		this.p = new Partita();
		this.b = this.p.getGiocatore().getBorsa();
		this.ciabatta = new Attrezzo("ciabatta", 2);
		this.sandalo = new Attrezzo("sandalo", 1);
		this.b.addAttrezzo(ciabatta);
		this.b.addAttrezzo(sandalo);
		this.c.setIOConsole(new IOConsole());
	}
	

	@Test
	void testComandoPosaEseguiSuccesso() {
		assertEquals(2, this.b.getNumeroAttrezzi());
		assertEquals(3, this.b.getPeso());
		c.setParametro("ciabatta");
		c.esegui(p);
		
		assertEquals(ciabatta, p.getStanzaCorrente().getAttrezzo("ciabatta"));
		assertFalse(b.hasAttrezzo("ciabatta"));
	}
	
	@Test
	void testComandoPosaEseguiFallimento() {
		assertEquals(2, this.b.getNumeroAttrezzi());
		assertEquals(3, this.b.getPeso());
		c.setParametro("ciao");
		c.esegui(p);
		
		assertFalse(b.hasAttrezzo("ciao"));
		assertFalse(p.getStanzaCorrente().hasAttrezzo("ciao"));
	}
	
	@Test
	void testComandoPosaEseguiFallimentoNull() {
		assertEquals(2, this.b.getNumeroAttrezzi());
		assertEquals(3, this.b.getPeso());
		c.setParametro(null);
		c.esegui(p);
		

		assertEquals(2, this.b.getNumeroAttrezzi());
		assertEquals(3, this.b.getPeso());

		assertEquals(1, this.p.getStanzaCorrente().getNumeroAttrezzi());
		assertEquals("osso", p.getStanzaCorrente().getAttrezzo("osso").getNome());
	}

}
