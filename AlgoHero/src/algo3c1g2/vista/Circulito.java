package algo3c1g2.vista;

import java.awt.Color;

import programa.VentanaPrincipalInicialJuego;
import algo3c1g2.modelo.nota.Nota;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Circulito implements ObjetoVivo, Posicionable {

	private int x;
	private int y;
	private boolean habilitado;
	private static int POSICION_INICIAL_Y=-48; 
	private VistaCirculito vista;
	private Nota nota;
	
	public Circulito(int ubicacionEnX){
		
		this.x=ubicacionEnX;
		this.y=POSICION_INICIAL_Y;
		habilitado=false;
	}
	
	public boolean estaHabilitado(){
		return this.habilitado;
	}
	
	public void habilitar(){
		this.habilitado=true;
	}
	
	public void reiniciar(){
		this.y=POSICION_INICIAL_Y;
		this.habilitado=false;
		this.vista.setColor(Color.RED);
	}
	
	@Override
	public void vivir() {	
		if(habilitado){
		this.y=this.y+2; //ese 2 deberia depender del tempo de la cancion no? es la velocidad con la q se desplaza el circulito (2/0.015)
		}
		if(this.y>VentanaPrincipalInicialJuego.TAMA�O_VERTICAL){  
			this.reiniciar();
		}
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x=x;		
	}

	public void setDibujable(VistaCirculito vistaCir) {
		this.vista=vistaCir;
		
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Nota getNota() {
		return nota;
	}

	public VistaCirculito getVista() {
		return vista;
	}

}
