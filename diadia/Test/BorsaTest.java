import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;
import giocatore.Borsa;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo sandalo;
	private Attrezzo ciavatta;
	
	
	@BeforeEach
	public void  setup() {
		this.borsa = new Borsa(5);
		this.sandalo = new Attrezzo("sandalo", 2);
		this.ciavatta = new Attrezzo("ciavatta", 1);
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(this.borsa.addAttrezzo(null));
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testAddAttrezzoGiustoSuccesso() {
		assertTrue(this.borsa.addAttrezzo(sandalo));
		assertEquals(1, this.borsa.getNumeroAttrezzi());
		assertEquals(2, this.borsa.getPeso());
		assertTrue(this.borsa.hasAttrezzo("sandalo"));
		assertEquals(sandalo, this.borsa.getAttrezzo("sandalo"));
	}
	
	@Test
	public void testAddAttrezzoGiustoFallimentoPesoMax() {
		this.borsa.addAttrezzo(sandalo);
		this.borsa.addAttrezzo(sandalo);
		assertEquals(4, this.borsa.getPeso());
		assertFalse(this.borsa.addAttrezzo(sandalo));
		assertEquals(4, this.borsa.getPeso());
	}
	
	@Test
	public void testAddAttrezzoGiustoFallimentoNumeroAttrezzi() {
		this.borsa.setPesoMax(20);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		assertEquals(10, this.borsa.getPeso());
		assertFalse(this.borsa.addAttrezzo(sandalo));
	}
	
	@Test
	public void testRemoveAttrezzoNull() {
		assertNull(this.borsa.removeAttrezzo(null));
	}

	@Test
	public void testRemoveAttrezzoSuccesso() {
		this.borsa.addAttrezzo(ciavatta);
		assertEquals(ciavatta, this.borsa.removeAttrezzo("ciavatta"));
		assertEquals(0, this.borsa.getNumeroAttrezzi());
		assertEquals(0, this.borsa.getPeso());
	}
	
	@Test
	public void testRemoveAttrezzoSuccessoNelMezzo() {
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(ciavatta);
		this.borsa.addAttrezzo(sandalo);
		this.borsa.addAttrezzo(ciavatta);
		assertEquals(4, this.borsa.getNumeroAttrezzi());
		assertEquals(5, this.borsa.getPeso());
		assertEquals(sandalo, this.borsa.removeAttrezzo("sandalo"));
		assertEquals(3, this.borsa.getNumeroAttrezzi());
		assertEquals(3, this.borsa.getPeso());
	}
	
	@Test
	public void testRemoveAttrezzoFallimentoAssente() {
		this.borsa.addAttrezzo(ciavatta);
		assertNull(this.borsa.removeAttrezzo("sandala"));
		assertEquals(1, this.borsa.getNumeroAttrezzi());
	}
	
	
}
