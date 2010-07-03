package algo3c1g2.modelo;

import java.util.*;

import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.*;

/**
 *
 * 
 * @author Grupo 2 - Algoritmos 3 - FIUBA
 */
public class Cancion {

	//Tempo por default de una cancion
	private final static int TEMPO_DEFAULT = 90;
	
	private String nombre;
	private int tempo; //[negras/minuto]
	private ArrayList<Compas> compaces;
	
	/* mapeo: almacanena correspondencias entre un tono
	 * (diferenciado por su frecuencia) y una combinacion de teclas
	 */
	private MapaDeTeclas mapeo;
	
	
	// Constructor que asigna nombre a la cancion e inicializa colecciones
	/**
	 * @param Nombre Nombre de la canci�n
	 */
	public Cancion(String Nombre) {
		this.setNombre(Nombre);
		this.tempo = TEMPO_DEFAULT;
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new MapaDeTeclas();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	

	/**
	 * @param tempo Tempo de la canci�n en un valor entre 30 y 150
	 * @throws TempoInvalidoException Cuando no se cumple la precondici�n en el par�metro
	 */
	public void setTempo(int tempo) {
		if ((tempo<30)||(tempo>150)){
			throw new TempoInvalidoException();
		}
		this.tempo = tempo;
	}

	public int getTempo() {
		return tempo;
	}
	
	
	/**
	 * @param unCompas Compas a agregar a la canci�n
	 * @throws CompasInvalidoExcepcion Si el comp�s no est� completo
	 */
	public void agregarCompas(Compas unCompas) {
		if (unCompas.estaInconcluso()){
			throw new CompasInvalidoExcepcion();
		}
		this.compaces.add(unCompas);
	}

	
	public void mapear(Nota nota, CombinacionDeTeclas combinacion){
		this.mapeo.agregarMapeo(nota, combinacion);
	}

	
	
	
	
	/* Post-condicion: devuelve el elemento de la cancion correspondiente
	 * al instante ingresado
	 */
	public ElementoDeCompas getElemento(double instante,double presicion){
		if(instante<0){
			throw new TiempoNegativoExcepcion();
		}
		Iterator<Compas> itCompaces=this.getIteratorCompaces();
		
		//Contador del tiempo transcurrido total a medida que se recorre la cancion
		double LineaDeTiempo = 0.00; 
		boolean LlegoAlElemento= false;  
		boolean sePaso=false;
		ElementoDeCompas unElemento = null;
		
		//Recorro los compaces hasta llegar al instante ingresado
		while(!LlegoAlElemento && itCompaces.hasNext()&&!sePaso){
			Compas unCompas = itCompaces.next();
			Iterator<ElementoDeCompas> itElementos = unCompas.getIteratorElementos();
			//verificamos si el siguiente compas contiene el instante que buscamos, sino seguimos iterando los compaces.
			//if(this.entraEnElRangoDePresicion(LineaDeTiempo+this.duracionDeUnCompasEnSegundos(unCompas), instante, this.duracionDeUnCompasEnSegundos(unCompas)+presicion)){
			//Recorremos los elementos del compas 
			while(itElementos.hasNext() && !LlegoAlElemento && !sePaso){
				unElemento = itElementos.next();
				LlegoAlElemento = this.entraEnElRangoDePresicion(LineaDeTiempo, instante, presicion);
				sePaso = (LineaDeTiempo>(instante+presicion));
				LineaDeTiempo += unElemento.getDuracionEnSegundos(this.getTempo()); 
			}
			//}
		}

		unElemento=(!sePaso&&LlegoAlElemento)?unElemento:null;
		
		return unElemento;
	}
	
	
	/* Pre-condicion: Recibe una combinacion de teclas y un instante en que fueron presionadas
	 * Post-condicion: devuelve true si coincide con el mapeo de la cancion en el instante indicado.
	 */
	public boolean verificarTeclas(CombinacionDeTeclas teclasPresionadas, double instante,double presicion) {
		ElementoDeCompas unElemento=this.getElemento(instante,presicion);
	
		
		boolean resultado=(unElemento.isNota())? 
				this.chequear(this.getMapeo().obtenerCombinacion((Nota)unElemento), teclasPresionadas)
				:false;
		return resultado;
	}
	
	public String getMapaDeTeclasEnString(Nota unaNota){
		CombinacionDeTeclas unaCombinacionDeTeclas=mapeo.obtenerCombinacion(unaNota);
		return unaCombinacionDeTeclas.getTeclasTexto();
	}
	
	
	/***
	 *  METODOS AUXILIARES INTERNOS
	 ***/
	
	//devuelve true si las teclas presionadas se corresponden a las teclas asociadas a la nota en el mapeo
	private boolean chequear(CombinacionDeTeclas teclasDelMapeo,	CombinacionDeTeclas teclasPresionadas){
		Iterator<Tecla> itTeclasPresionadas = teclasPresionadas.getIteradorTeclas();
		boolean resultado= true;
		while(itTeclasPresionadas.hasNext()&&resultado){
			Tecla unaTeclaPresionada = itTeclasPresionadas.next();
			resultado = (teclasDelMapeo.contains(unaTeclaPresionada));
		}
		return resultado;
	}
	
	
	public MapaDeTeclas getMapeo(){
		return mapeo;
	}
	
	public Iterator<Compas> getIteratorCompaces(){
		IteradorCliente<Compas> unIterator = new IteradorCliente<Compas>(this.compaces);
		return unIterator;
	}
	
	
	//devuelve true si el valor ingresado se encuentra dentro del rango de presicion entorno a entorno segun la presicion del juego 
	private boolean entraEnElRangoDePresicion(double valor,double entorno,double presicion){ 
		return ((valor<=(entorno+presicion))&&(valor>=(entorno-presicion)));
	}
}
