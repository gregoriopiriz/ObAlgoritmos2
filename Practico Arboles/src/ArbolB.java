
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
		//creo un arbol vac�o
		ArbolB subDer = new ArbolB();
		//La ra�z del subarbol derecho es el nodo hijo derecho de la ra�z del �rbol
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
