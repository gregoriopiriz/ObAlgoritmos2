
public class NodoB {
	
	private int dato;
	private String nombre;
	private NodoB padre;
	private NodoB nodoIzq;
	private NodoB nodoDer;
	
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public NodoB getNodoDer() {
		return nodoDer;
	}
	public void setNodoDer(NodoB nodoDer) {
		this.nodoDer = nodoDer;
	}
	public NodoB getNodoIzq() {
		return nodoIzq;
	}
	public void setNodoIzq(NodoB nodoIzq) {
		this.nodoIzq = nodoIzq;
	}
	
	public NodoB()
	{
		
	}
	public NodoB(int x, String n)
	{
		dato=x;
		nombre= n;
		nodoIzq = null;
		nodoDer= null;
		
	}
	public NodoB(int i) {
		dato= i;
		nodoIzq = null;
		nodoDer= null;
	}
	
	public String toString() {
		return nombre + " Su dato es " + dato;
	}
	public NodoB getPadre() {
		return padre;
	}
	public void setPadre(NodoB padre) {
		this.padre = padre;
	}

}
