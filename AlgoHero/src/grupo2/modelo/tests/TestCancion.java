package grupo2.modelo.tests;

import grupo2.modelo.Cancion;
import grupo2.modelo.Compas;
import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.*;
import grupo2.modelo.tecla.*;
import junit.framework.TestCase;

public class TestCancion extends TestCase {

	public void testConstructor(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		assertEquals(unaCancion.getNombre(),"Una noche en la playa");//probamos que almacene correctamente el nobmre
		assertTrue(unaCancion.getTempo()==90); //probamos que inicialize el Tempo en 90
	}

	public void testSetTempo(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setTempo(50);
		assertTrue(unaCancion.getTempo()==50);//probamos que almacene correctamente el Tempo
		try{
			unaCancion.setTempo(29);
			fail("deberia haber lanzado una excepcion"); //Probamos que no permita ingresar un Tempo invalido
		}
		catch (RuntimeException e){return;}
		fail("deberia haber capturado");
	}
	
	public void testAgregarCompas() {
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();//por default se crea 4/4
		unCompas.agregarElemento(new Do(new Blanca())); //agregamos solo una blanca
		try 	// e intentamos agregar el compas inconcluso a la cancion
		{
			unaCancion.agregarCompas(unCompas);
			fail("deberia haber lanzada una excepcion");
		}
		catch(RuntimeException e){ return;}
		fail("deberia haber capturado");
		
	}
	
	
	public void testMapeo(){ //Probamos mapear algo sensillo
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();
		CombinacionDeTeclas teclas = new CombinacionDeTeclas();
		
		
		teclas.agregarTecla(new Tecla(65)); //Habilitamos las teclas A y B
		teclas.agregarTecla(new Tecla(66));
		unCompas.agregarElemento(new Do(new Blanca())); //Agregamos al compas notas
		unCompas.agregarElemento(new ReSostenido(new Negra()));
		unCompas.agregarElemento(new FaSostenido(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		unaCancion.mapear(Constantes.FRECUENCIA_DO, teclas);
		MapaDeTeclas unHash = unaCancion.getMapeo();
		
		assertTrue((unHash.obtenerCombinacion(new Do().getFrecuencia())).obtenerTecla().getCodigoASCII()==Constantes.CODIGO_ASCII_A); // Probamos que las notas esten mapeadas con su tecla correspondiente
	}

}