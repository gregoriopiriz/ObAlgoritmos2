
public class index {

	public static void main(String[] args) {

		ArbolB arbol = new ArbolB();
		NodoB raiz = new NodoB(2,0);
		NodoB nodo1d = new NodoB(4,1);
		NodoB nodo1i = new NodoB(6,2);
		NodoB nodo2d = new NodoB(8,3);
		NodoB nodo2i = new NodoB(10,4);
		NodoB nodo3d = new NodoB(12,5);

		arbol.setRaiz(raiz);
		arbol.getRaiz().setNodoIzq(nodo1i);
		arbol.getRaiz().setNodoDer(nodo1d);
		nodo1i.setNodoIzq(nodo2i);
		nodo1i.setNodoDer(nodo2d);
		nodo1d.setNodoDer(nodo3d);
	
		System.out.println("Arbol inicial");
		imprimirConNivel(arbol);
		System.out.println("---------------------------");
		System.out.println("Ej1 copia del arbol");
		imprimirConNivel(ejercicio1(arbol));
		System.out.println("---------------------------");
		System.out.println("Ej2 ¿son divisibles los nodos?");
		System.out.println(ejercicio2(arbol));
		System.out.println("---------------------------");
		System.out.println("Ej3a Altura del arbol");
		System.out.println(ejercicio3a(arbol));
		System.out.println("---------------------------");
		System.out.println("Ej3b ¿Es equilibrado?");
		System.out.println(ejercicio3b(arbol));
		System.out.println("---------------------------");
		System.out.println("Ej4a Cantidad de nodos");
		System.out.println(ejercicio4a(arbol));
		System.out.println("---------------------------");
		System.out.println("Suma de los datos de los nodos");
		System.out.println(sumarNodos(arbol.getRaiz()));
		System.out.println("---------------------------");
		System.out.println("Ej4b Promedio de los datos de los nodos");
		System.out.println(ejercicio4b(arbol));
	}
	
	public static ArbolB ejercicio1(ArbolB arbol) {
		ArbolB copia = new ArbolB();

		if (arbol.getRaiz() != null) {
			NodoB nodoNuevo = new NodoB(arbol.getRaiz().getDato());

			nodoNuevo.setNodoIzq(ejercicio1(arbol.subIzquierdo()).getRaiz());
			nodoNuevo.setNodoDer(ejercicio1(arbol.subDerecho()).getRaiz());

			copia.setRaiz(nodoNuevo);
		}
		return copia;
	}
	
	public static boolean ejercicio2(ArbolB arbol) {
		boolean divisible = true;
		if (arbol.getRaiz() == null) {
			divisible = true;
		} else {
			if (arbol.getRaiz().getDato() % 2 != 0) {
				divisible = false;
			} else
			{
				if (ejercicio2(arbol.subIzquierdo()) == true && ejercicio2(arbol.subDerecho()) == true) {
					divisible = true;
				} else {
					divisible = false;
				}
			}
		}
		return divisible;
	}
	
	public static int ejercicio3a(ArbolB arbol) {
		int altura = 0;
		if (arbol.getRaiz() != null) {
			if (arbol.getRaiz().getNodoIzq() == null && arbol.getRaiz().getNodoDer() == null) {
				altura = 0;
			} else {
				altura = 1 + Math.max(ejercicio3a(arbol.subIzquierdo()), ejercicio3a(arbol.subDerecho()));
			}
		}
		return altura;
	}
	
	public static boolean ejercicio3b(ArbolB arbol)
	{
		int alturaIzq = ejercicio3a(arbol.subIzquierdo());
		int alturaDer= ejercicio3a(arbol.subDerecho());
		
		if(alturaIzq-alturaDer <= 1)
		{
			return true;
		}
		else {
			return false;			
		}
	}
	
	public static int ejercicio4a(ArbolB arbol) {
		int cantidad = 0;
		if (arbol.getRaiz() != null) {
			cantidad = 1 + ejercicio4a(arbol.subIzquierdo()) + ejercicio4a(arbol.subDerecho());
		}
		return cantidad;
	}
	
	public static int sumarNodos(NodoB raiz) {
		if(raiz != null) {
			int aux = raiz.getDato();
			int izq = sumarNodos(raiz.getNodoIzq());
			int der = sumarNodos(raiz.getNodoDer());
			return izq+aux+der;
		}
		return 0;
	}
	
	public static int ejercicio4b(ArbolB arbol) {
		int suma = sumarNodos(arbol.getRaiz());
		int cantidad = ejercicio4a(arbol); 
		return suma / cantidad;
	}	
	
	private static void imprimirConNivel(NodoB nodoAux, int nivel) {
		if (nodoAux != null) {
			imprimirConNivel(nodoAux.getNodoIzq(), nivel + 1);
			imprimirConNivel(nodoAux.getNodoDer(), nivel + 1);
			System.out.println(nodoAux.getDato() + "(" + nivel + ") - ");

		}
	}

	public static void imprimirConNivel(ArbolB arbol) {
		imprimirConNivel(arbol.getRaiz(), 1);
		System.out.println();
	}
	
}