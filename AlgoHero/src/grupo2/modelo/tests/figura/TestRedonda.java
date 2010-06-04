package grupo2.modelo.tests.figura;

import static org.junit.Assert.*;
import grupo2.modelo.figura.*;

import org.junit.Test;

// SE ESTA USANDO JUNIT 4

public class TestRedonda {

	@Test
	public void testGetDuracion() {
		// Creo la figura Redonda
		Figura unaFigura = new Redonda();
		
		// La figura Redonda tiene una duracion de 4 Negras
		assertEquals("Mal inicializada la duracion", 4.00, unaFigura.getDuracion(), 0.00001);
	}

}
