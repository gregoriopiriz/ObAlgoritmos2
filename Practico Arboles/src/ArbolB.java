
public class ArbolB {
	private NodoB raiz;	
	
	public NodoB getRaiz() {
		return raiz;
	}
	public void setRaiz(NodoB mRaiz) {
		this.raiz = mRaiz;
	}
	
	public ArbolB()
	{
		raiz=null;
	}	
	public ArbolB subDerecho()
	{
		//creo un arbol vacío
		ArbolB subDer = new ArbolB();
		//La raíz del subarbol derecho es el nodo hijo derecho de la raíz del árbol
		subDer.setRaiz(this.raiz.getNodoDer());
		
		return subDer;
	}
	public ArbolB subIzquierdo()
	{
		ArbolB subIzq= new ArbolB();
		subIzq.setRaiz(this.raiz.getNodoIzq());
		return subIzq;
	}

}
