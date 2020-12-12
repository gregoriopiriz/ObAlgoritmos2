public class index {
	public static void main(String[] args) {
		
	ArbolBB nuevo = new ArbolBB();
	insertar(nuevo, 1);
	insertar(nuevo, 7);
	insertar(nuevo, 4);
	insertar(nuevo, 3);
	insertar(nuevo, 2);
	
	imprimirConNivel(nuevo);
	
	System.out.println("¿Esta el numero " + 5 + " en el arbol?");	
	System.out.println(buscar(nuevo, 5));
	System.out.println("");
	
	System.out.println("El mayor elemento del arbol es " + mayorValor(nuevo));
	System.out.println("");
	
	System.out.println("Antes de borrar maximo");
	imprimirConNivel(nuevo);
	
	borrarMaximo(nuevo);
	
	System.out.println("Despues de borrar");
	imprimirConNivel(nuevo);
	
	}
	
	 
	public static ArbolBB insertar(ArbolBB arbol, int x) {
		NodoB raiz = arbol.getRaiz();
		arbol.setRaiz(insertarNodo(raiz, x));
		return arbol;
		}
	
	public static NodoB insertarNodo(NodoB aux, int x) {
		if(aux == null) {
			aux = new NodoB(x);
			}else if(x < aux.getDato()) {
				NodoB izquierdo = insertarNodo(aux.getNodoIzq(), x);
				aux.setNodoIzq(izquierdo);
			}else if(x > aux.getDato()) {
				NodoB derecho = insertarNodo(aux.getNodoDer(), x);
				aux.setNodoDer(derecho);
			}else {
				System.out.println("Dato duplicado por favor ingrese otro dato");
			}
			return aux;
		}
	
	 public static boolean buscar(ArbolBB arbol, int x) {
		 NodoB raiz = arbol.getRaiz();
		 while(raiz != null) {
			 if(x == raiz.getDato()) {
				 return true;
			 }else {
				 if(x > raiz.getDato()) {
					 raiz = raiz.getNodoDer();
				 }else {
					 raiz = raiz.getNodoIzq();
				 	}
			 	}
		 	}
		 	return false;
	 	}
	
	 
	 public static int mayorValor(ArbolBB arbol) {
		 NodoB raiz = new NodoB();
	        if (arbol.getRaiz() != null) {
	            raiz = arbol.getRaiz();
	        }
	            while (raiz.getNodoDer() != null) {
	            	raiz = raiz.getNodoDer();
	        }
	            return raiz.getDato();
	 	}
	 
	 public static ArbolBB borrarMaximo(ArbolBB arbol) {
			if (arbol.getRaiz() != null)
			{
				if (arbol.getRaiz().getNodoDer() == null)
				{
					NodoB nuevaRaiz = arbol.getRaiz().getNodoIzq();
					arbol.setRaiz(nuevaRaiz);
				} else
				{
					arbol.getRaiz().setNodoDer(borrarMaximo(arbol.subDerecho()).getRaiz());
				}
			}
			return arbol;
		}
	 	
	private static void imprimirConNivel(NodoB nodoAux, int nivel) {
		if (nodoAux != null) {
			imprimirConNivel(nodoAux.getNodoIzq(), nivel + 1);
			imprimirConNivel(nodoAux.getNodoDer(), nivel + 1);
			System.out.println(nodoAux.getDato() + "(" + nivel + ") - ");
			}
		}

	public static void imprimirConNivel(ArbolBB arbol) {
		imprimirConNivel(arbol.getRaiz(), 1);
		System.out.println();
		}
}
