
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
	
	/*public void agregarNodo(int d, char n) {
		NodoB nuevo = new NodoB(d, n);
		if(raiz==null) {
			raiz=nuevo;
		}else {
			NodoB aux=raiz;
			NodoB padre;
			while(true) {
				padre=aux;
				if(d<aux.getDato()) {
					aux=aux.getNodoIzq();
					if(aux==null) {
						padre.setNodoIzq(nuevo);
						return;
					}
				}else {
					aux=aux.getNodoDer();
					if(aux==null) {
						padre.setNodoDer(nuevo);
						return;
					}
				}
			}
		}
	}*/
	/*
	public void insertar(int i, String nombre) {
		NodoB n = new NodoB();
		n.setNombre(nombre);;
		
		if(raiz==null) {
			raiz=n;
		}else {
			NodoB aux = raiz;
			while(aux!=null) {
				n.setPadre(aux);
			}
		}
		
	}*/
	

}
