package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Si extends Nota {

	//Frecuencia caracteristica del tono Si en la octava 3
	private final static float FRECUENCIA_SI = 493;
	private final static int UbicacionCuerdaSi=576;

	public Si(){
		super(FRECUENCIA_SI);
	}
	
	public Si(Figura unaFigura){
		super(FRECUENCIA_SI,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaSi;
	}


	@Override
	protected void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer) {
		itCuer.next();
		itCuer.next();
		itCuer.next();
		itCuer.next();
		itCuer.next();
	}
}