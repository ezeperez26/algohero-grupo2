package grupo2.modelo.tests.nota;

import static org.junit.Assert.assertEquals;
import grupo2.modelo.constantes.*;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.*;

import org.junit.Test;

//ACLARACION: SE USO JUNIT 4, POR FAVOR USAR ESA VERSION!!

public class ReSostenidoTest {

	@Test
	public void testGetFrecuenciaConstructor1() {
		// Se crea la nota ReSostenido usando su constructor sin parametros 
		Nota unaNota = new ReSostenido();
		
		// Se comparan las frecuencias que almacena el objeto con la almacenada en la clase constantes
		assertEquals("Frecuencia inicializada incorrectamente", Constantes.FRECUENCIA_RE_SOSTENIDO, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetFrecuenciaConstructor2() {
		// Se crea la nota ReSostenido estableciendo cualquier figura (en este caso Negra) 
		Nota unaNota = new ReSostenido(new Negra());
		
		// Se comparan las frecuencias que almacena el objeto con la almacenada en la clase constantes
		assertEquals("Frecuencia inicializada incorrectamente", Constantes.FRECUENCIA_RE_SOSTENIDO, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetDuracionDefault() {
		// Se crea la nota ReSostenido usando su constructor sin parametros 
		Nota unaNota = new ReSostenido();
		
		// La duracion de la nota ReSostenido por default es 1 Negra
		assertEquals("Duracion inicializada incorrectamente", Constantes.NEGRA, unaNota.getDuracion(), 0.00001);
	}

	@Test
	public void testGetDuracionRedonda() {
		// Se crea la nota ReSostenido y se pasa una figura Redonda 
		Nota unaNota = new ReSostenido(new Redonda());
		
		// La duracion de la figura Redonda es de 4 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.REDONDA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionBlanca() {
		// Se crea la nota ReSostenido y se pasa una figura Blanca 
		Nota unaNota = new ReSostenido(new Blanca());
		
		// La duracion de la figura Blanca es de 2 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.BLANCA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionNegra() {
		// Se crea la nota ReSostenido y se pasa una figura Negra
		Nota unaNota = new ReSostenido(new Negra());
		
		// La duracion de la figura Negra es de 1 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.NEGRA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionCorchea() {
		// Se crea la nota ReSostenido y se pasa una figura Corchea
		Nota unaNota = new ReSostenido(new Corchea());
		
		// La duracion de la figura Corchea es de 0.5 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.CORCHEA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionSemicorchea() {
		// Se crea la nota ReSostenido y se pasa una figura Semicorchea
		Nota unaNota = new ReSostenido(new Semicorchea());
		
		// La duracion de la figura Semicorchea es de 0.25 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.SEMICORCHEA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionFusa() {
		// Se crea la nota ReSostenido y se pasa una figura Fusa
		Nota unaNota = new ReSostenido(new Fusa());
		
		// La duracion de la figura Fusa es de 0.125 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.FUSA, unaNota.getDuracion(), 0.00001);
	}
	
}