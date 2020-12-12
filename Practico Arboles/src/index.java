
public class index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArbolB arbol = new ArbolB();
		NodoB hoja5n = new NodoB(-5,3);
		NodoB hoja1 = new NodoB(1,2);
		NodoB hoja8 = new NodoB(8,3);
		NodoB nodo4 = new NodoB(4,2);
		NodoB nodo3 = new NodoB(3,2);
		NodoB nodo2n = new NodoB(-2,2);
		NodoB nodo2 = new NodoB(2,1);
		NodoB nodo9 = new NodoB(9,1);
		NodoB raiz = new NodoB(5,0);

		arbol.setRaiz(raiz);
		arbol.getRaiz().setNodoIzq(nodo2);
		arbol.getRaiz().setNodoDer(nodo9);
		nodo2.setNodoIzq(nodo3);
		nodo2.setNodoDer(nodo4);
		nodo9.setNodoIzq(nodo2n);
		nodo9.setNodoDer(hoja1);
		//nodo3.setNodoIzq(hoja8);
		//nodo3.setNodoDer(hoja5n);
		
		ArbolB nuevo = new ArbolB();
		NodoB nuevonodo = new NodoB(80);
		NodoB nodoI = new NodoB(4);
		NodoB nodoD = new NodoB(5);
		nuevonodo.setNodoIzq(nodoI);
		nuevonodo.setNodoDer(nodoD);
		nuevo.setRaiz(nuevonodo);
		
		System.out.println(altura(arbol));
		System.out.println(equilibrado(arbol));

		imprimirConNivel(arbol);
		//imprimirConNivel(clon(arbol));
		//imprimirConNivel(espejo(arbol));
		
		//prueba(arbol,0);
		//pruebaNivel(arbol,2);
		//imprimir(arbol);
	}

	public int cantNodos(ArbolB arbol) {
		int cant = 0;
		if (arbol.getRaiz() != null) {
			cant = 1 + cantNodos(arbol.subDerecho()) + cantNodos(arbol.subIzquierdo());
		}
		return cant;
	}

	public static boolean raizEsHoja(ArbolB arbol) {
		boolean hoja = false;
		if (arbol.getRaiz().getNodoIzq() == null && arbol.getRaiz().getNodoDer() == null) {
			hoja = true;
		}
		return hoja;
	}

	public int cantHojas(ArbolB arbol) {
		int cant = 0;

		if (raizEsHoja(arbol)) {
			cant = 1;
		} else {
			cant = cantHojas(arbol.subIzquierdo()) + cantHojas(arbol.subDerecho());
		}
		return cant;

	}

	// Es el n�mero de nodos del arbol sin contar la ra�z
	public int peso(ArbolB arbol) {
		int cant = 0;
		if (arbol.getRaiz() != null) {
			cant = peso(arbol.subIzquierdo()) + peso(arbol.subDerecho());
		}
		return cant;

	}

	public int peso2(ArbolB arbol) {
		return cantNodos(arbol) - 1;
	}

	// La altura de un nodo en un �rbol es la m�xima longitud de un camino que va
	// desde el nodo a una hoja.
	public static int altura(ArbolB arbol) {
		int altura = 0;
		if (arbol.getRaiz() != null) {
			if (raizEsHoja(arbol)) {
				altura = 0;
			} else {
				/*
				 * Le sumo uno para considerar la distancia del nodo izquierdo o derecho hasta
				 * la ra�z
				 */
				altura = 1 + Math.max(altura(arbol.subIzquierdo()), altura(arbol.subDerecho()));
			}
		}
		return altura;
	}

	public boolean todosPares(ArbolB arbol) {
		boolean pares = true;
		if (arbol.getRaiz() == null) {
			pares = true;
		} else {
			/* Pregunto si el resto de dividir el valor de la raiz entre dos es cero */
			if (arbol.getRaiz().getDato() % 2 != 0) {
				pares = false;
			} else // Si la raiz es par, evaluo el subIzquierdo y subDerecho
			{
				if (todosPares(arbol.subIzquierdo()) == true && todosPares(arbol.subDerecho()) == true) {
					pares = true;
				} else {
					pares = false;
				}

				// pares=todosPares(arbol.subDerecho()) && todosPares(arbol.subIzquierdo());
			}

		}

		return pares;
	}

	public boolean iguales(ArbolB a, ArbolB b) {
		boolean iguales = false;
		if (a.getRaiz() == null && b.getRaiz() == null) // Si las dos raices son nulas
		{
			iguales = true;
		} else if (a.getRaiz() == null || b.getRaiz() == null) // Si una de las dos es nula
		{
			iguales = false;
		} else // Ninguna de las dos raices son nulas
		{
			// Las dos raices son iguales y los izquierdos y derechos son iguales
			if ((a.getRaiz().getDato() == b.getRaiz().getDato()) && iguales(a.subIzquierdo(), b.subIzquierdo())
					&& iguales(a.subDerecho(), b.subDerecho())) {
				iguales = true;
			} else {
				iguales = false;
			}
		}
		return iguales;

	}

	public static ArbolB clon(ArbolB arbol) {
		ArbolB nuevo = new ArbolB();
		// La ra�z es diferente de null
		if (arbol.getRaiz() != null) {
			NodoB nodoNuevo = new NodoB(arbol.getRaiz().getDato());
			// Creo un nodo solo con el dato de la raiz

			// Seteo los nodos subIzquierdo y subDerecho como la ra�z de un nuevo clon
			nodoNuevo.setNodoIzq(clon(arbol.subIzquierdo()).getRaiz());
			nodoNuevo.setNodoDer(clon(arbol.subDerecho()).getRaiz());

			nuevo.setRaiz(nodoNuevo);
		}
		return nuevo;
	}

	public static ArbolB espejo(ArbolB arbol) {
		ArbolB nuevo = new ArbolB();
		// La ra�z es diferente de null
		if (arbol.getRaiz() != null) {
			NodoB nodoNuevo = new NodoB(arbol.getRaiz().getDato());
			// Creo un nodo solo con el dato de la raiz

			// Seteo los nodos subIzquierdo y subDerecho como la ra�z de un nuevo clon
			nodoNuevo.setNodoIzq(espejo(arbol.subDerecho()).getRaiz());
			nodoNuevo.setNodoDer(espejo(arbol.subIzquierdo()).getRaiz());

			nuevo.setRaiz(nodoNuevo);
		}
		return nuevo;
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
	
	public static boolean equilibrado(ArbolB arbol)
	{
		int alturaIzq = altura(arbol.subIzquierdo());
		int alturaDer= altura(arbol.subDerecho());
		
		if(Math.abs(alturaIzq-alturaDer)<=1)
		{
			return true;
		}
		else return false;
	}	
	
	/*
	private static void imprimirPosorden(NodoB nodoAux) {
		if (nodoAux != null) {
			System.out.println(nodoAux.getDato());
			imprimirPosorden(nodoAux.getNodoIzq());
			imprimirPosorden(nodoAux.getNodoDer());

		}
	}

	public static void imprimirPosorden(ArbolB arbol) {
		imprimirPosorden(arbol.getRaiz());
		System.out.println();
	}*/
	
	PARA EL PARCIAL 
	
    public static ArbolBB insertar(ArbolBB arbol, int x) {
        // Si el arbol es vac�o inserto el valor como ra�z
        if (arbol.getRaiz() == null) {
            NodoB nuevo = new NodoB(x);
            arbol.setRaiz(nuevo);
        } else {
            if (x < arbol.getRaiz().getDato()) // El dato es menor a la ra�z
            {
                // Tengo que insertarlo a la izquierda
                arbol.getRaiz().setNodoIzq(insertar(arbol.subIzquierdo(), x).getRaiz());
            } else if (x > arbol.getRaiz().getDato())// el dato es mayor a la raiz
            {
                // Tengo que insertarlo a la derecha
                arbol.getRaiz().setNodoDer(insertar(arbol.subDerecho(), x).getRaiz());
            } else // Si el dato es igual
            {
                // No inserto nada
                System.out.print("El dato ya existe en el Arbol");
            }
        }
        return arbol;
    }

    /*
    b) void borrarMínimo ();
    Pos: Elimina el menor elemento del ABB. 
    */
    public static ArbolBB borrarMin(ArbolBB arbol) {
		if (arbol.getRaiz() != null) // �rbol no vac�o
		{
			if (arbol.getRaiz().getNodoIzq() == null)
			// Si el arbol izquierdo es vac�o, el minimo es la ra�z
			{
				// Borro la ra�z
				NodoB nuevaRaiz = arbol.getRaiz().getNodoDer();
				arbol.setRaiz(nuevaRaiz);
			} else // sino el minimo est� en el arbol izquierdo
			{
				arbol.getRaiz().setNodoIzq(borrarMin(arbol.subIzquierdo()).getRaiz());
			}

		}
		return arbol;
	}

    /*
    c) void borrarElemento (int x);
    Pre: El elemento x pasado como parámetro pertenece al ABB.
    Pos: Elimina el elemento x del ABB, manteniéndolo ordenado. 
    */

    public static ArbolBB insertarArbol(ArbolBB arbol, ArbolBB otro) {
		if (otro.getRaiz() != null) {
			// Inserto primero la raiz como dato
			arbol = insertar(arbol, otro.getRaiz().getDato());
			// Llamo recursivamente para el subArbol izquierdo y el subarbol derecho
			insertarArbol(arbol, otro.subIzquierdo());
			insertarArbol(arbol, otro.subDerecho());
		}
		return arbol;
	}

    public static ArbolBB borrarElemento(int x, ArbolBB arbol) {
		// buscar el 5
		if (arbol.getRaiz().getDato() == x) // El dato es igual a la ra�z
		{
			// Recorro lo que resta de �rbol para insertarlo
			ArbolBB nuevo = new ArbolBB();
			nuevo.setRaiz(arbol.getRaiz());

			arbol.setRaiz(null);
			arbol = insertarArbol(arbol, nuevo.subIzquierdo());
			arbol = insertarArbol(arbol, nuevo.subDerecho());

		} else if (x < arbol.getRaiz().getDato()) // El dato es menor a la ra�z
		{
			arbol.getRaiz().setNodoIzq(borrarElemento(x, arbol.subIzquierdo()).getRaiz());
		} else // El dato es mayor a la ra�z
		{
			arbol.getRaiz().setNodoDer(borrarElemento(x, arbol.subDerecho()).getRaiz());
		}
		return arbol;
    }
    
    /* 
    d) boolean pertenece (int x);
    Pos: Retorna true sii el dato pasado como parámetro pertenece al ABB. 
    */

    public static boolean pertenece(ArbolBB arbol, int x) {
		boolean existe = false;
		if (arbol.getRaiz().getDato() == x) {
			existe = true;
		} else if (x < arbol.getRaiz().getDato()) {
			existe = pertenece(arbol.subIzquierdo(), x);
		} else // x > raiz
		{
			existe = pertenece(arbol.subDerecho(), x);
		}

		return existe;
    }
    
    /*
    e) void listarAscendente ();
    Pos: Lista en pantalla los elementos del ABB ordenados de menor a mayor.
    */

    public static void listar(ArbolBB arbol) {
		if (arbol.getRaiz() != null) {
			listar(arbol.subIzquierdo());
			System.out.println(arbol.getRaiz().getDato());
			listar(arbol.subDerecho());
		}
    }
    
    /*
    f) void listarDescendente ();
    Pos: Lista en pantalla los elementos del ABB ordenados de mayor a menor. 
    */

    public static void listarDesc(ArbolBB arbol) {
		if (arbol.getRaiz() != null) {
			
			listarDesc(arbol.subDerecho());
			System.out.println(arbol.getRaiz().getDato());
			listarDesc(arbol.subIzquierdo());			
		}
	}

	
}
	
	
