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
		//creo un arbol vac�o
		ArbolBB subDer = new ArbolBB();
		//La ra�z del subarbol derecho es el nodo hijo derecho de la ra�z del �rbol
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