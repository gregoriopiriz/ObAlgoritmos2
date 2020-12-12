public class ArbolBB {
private NodoB raiz;	
	
	public NodoB getRaiz() {
		return raiz;
	}
	public void setRaiz(NodoB mRaiz) {
		this.raiz = mRaiz;
	}
	
	public ArbolBB()
	{
		raiz=null;
	}
	
	public ArbolBB subDerecho()
	{
		//creo un arbol vacío
		ArbolBB subDer = new ArbolBB();
		//La raíz del subarbol derecho es el nodo hijo derecho de la raíz del árbol
		subDer.setRaiz(this.raiz.getNodoDer());
		
		return subDer;
	}
	public ArbolBB subIzquierdo()
	{
		ArbolBB subIzq= new ArbolBB();
		subIzq.setRaiz(this.raiz.getNodoIzq());
		return subIzq;
	}
	
}