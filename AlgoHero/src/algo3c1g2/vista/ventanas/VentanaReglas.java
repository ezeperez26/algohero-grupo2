package algo3c1g2.vista.ventanas;

import java.awt.Component;


public class VentanaReglas extends VentanaMensaje{


	public VentanaReglas(Component ventana){
		super(ventana);
	}

	
	public String getTexto(){
			
		String reglas = "Reglas\n";
		
		String parrafo1;
	
		
		parrafo1 = 
				
				"\n --El juego consta de una cancion y de una Guitarra.\n " +
				"\n --Usted tendra....\n";
				
		
	   
		return reglas += parrafo1 ;
	
	}

	protected String getTitulo() {
		return "Reglas";
	}
	

	
}
