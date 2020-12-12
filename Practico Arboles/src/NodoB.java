
public class NodoB {
	
	private int dato;
	private NodoB nodoIzq;
	private NodoB nodoDer;
	
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
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
	public NodoB(int x)
	{
		dato=x;
		nodoIzq = null;
		nodoDer= null;
		
	}
	public NodoB(int i, int j) {
		dato= i;
		nodoIzq = null;
		nodoDer= null;
	}

}
