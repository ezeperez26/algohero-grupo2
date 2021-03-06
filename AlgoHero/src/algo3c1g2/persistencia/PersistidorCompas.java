package algo3c1g2.persistencia;

import java.util.Iterator;
import java.util.List;

import org.jdom.DataConversionException;
import org.jdom.Element;

import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.ElementoDeCompas;

/**
 * Clase de persistencia externa del {@code Compas}.
 * Utiliza las librerias JDOM.
 * 
 * @author Ezequiel P�rez Dittler
 */
public class PersistidorCompas {

	/**
	 * Persiste el {@code Compas}, sus atributos y sus notas.
	 * 
	 * @param unCompas {@code Compas} a persistir.
	 * @return Retorna el {@code Element} correspondiente a un nodo XML.
	 */
	@SuppressWarnings("unchecked")
	public Element persistir(Compas unCompas) {
		Element root = new Element(unCompas.getClass().getSimpleName());
		
		//Guardo los atributos...
		Integer numeradorInteger = unCompas.getNumerador();
		Integer denominadorInteger = unCompas.getDenominador();
		root.setAttribute("numerador", numeradorInteger.toString());
		root.setAttribute("denominador", denominadorInteger.toString());
			
		//Almaceno la lista de compaces en un nodo hijo
		Iterator itElementos = unCompas.getIteratorElementos();
		PersistidorElemento unPersistidorElemento = new PersistidorElemento();
		
		//recorro la coleccion ElementosDeCompas y los voy persistiendo
		while (itElementos.hasNext()){
			ElementoDeCompas unElemento = (ElementoDeCompas) itElementos.next();
			Element unNodoCompas = unPersistidorElemento.persistir(unElemento);
			root.addContent(unNodoCompas);
		}
		
		return root;
	}

	/**
	 * Obtiene el {@code Compas} a traves de un {@code Element}.
	 * 
	 * @param root Nodo raiz que deberia contener el {@code Compas}.
	 * @return Devuelve el {@code Compas} obtenido.
	 * @throws DataConversionException Si el elemento no tiene {@code Compas}.
	 */
	@SuppressWarnings("unchecked")
	public Compas obtenerCompas(Element root) throws DataConversionException {
		//creo el compas a devolver
		Compas unCompas = new Compas();
		
		//agrego los atributos
		int numerador = (int) root.getAttribute("numerador").getLongValue();
		int denominador = (int) root.getAttribute("denominador").getLongValue();
		unCompas.setNumerador(numerador);
		unCompas.setDenominador(denominador);
				
		//ahora tengo que obtener los elementos del compas
		List elementos = root.getChildren("ElementoDeCompas");
		Iterator itElementos = elementos.iterator();
		PersistidorElemento unPersistidorCompas = new PersistidorElemento();
		
		//recorro la coleccion para cargar los elementos al compas
		while (itElementos.hasNext()){
			Element unElemento = (Element) itElementos.next();
			ElementoDeCompas unElementDeCompas = unPersistidorCompas.obtenerElemento(unElemento);
			unCompas.agregarElemento(unElementDeCompas);
		}
		
		return unCompas;
	}

}
