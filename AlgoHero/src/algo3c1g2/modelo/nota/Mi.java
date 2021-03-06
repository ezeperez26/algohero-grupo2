package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class Mi extends Nota {

	//Frecuencia caracteristica del tono Mi en la octava 3
	private final static int FRECUENCIA_MI = 64;
	private final static int CUERDA = 3;
	
	public Mi(){
		super(FRECUENCIA_MI);
	}
	
	public Mi(Figura unaFigura){
		super(FRECUENCIA_MI, unaFigura);
	}

	public int getCuerda() {
		return Mi.CUERDA;
	}
	
}