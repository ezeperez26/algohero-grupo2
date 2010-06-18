package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class LaSostenido extends Nota {

	//Frecuencia caracteristica del tono La Sostenido en la octava 3
	private final static float FRECUENCIA_LA_SOSTENIDO = 466;
	
	public LaSostenido(){
		super(FRECUENCIA_LA_SOSTENIDO);
	}
	
	public LaSostenido(Figura unaFigura){
		super(FRECUENCIA_LA_SOSTENIDO,unaFigura);
	}
	
}