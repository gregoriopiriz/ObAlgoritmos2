import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class index {

	public static void main(String[] args) {

		
		ArbolB arbol = new ArbolB();
		NodoB nuevonodo = new NodoB(0, "G");// G
		NodoB nodoM = new NodoB(1, "M");// M
		NodoB nodoE = new NodoB(2, "E");// E
		nuevonodo.setNodoDer(nodoM);
		nuevonodo.setNodoIzq(nodoE);
		NodoB nodoA = new NodoB(2, "A");// A
		nodoE.setNodoIzq(nodoA);
		NodoB nodoI = new NodoB(3, "I");// I
		nodoA.setNodoIzq(nodoI);
		NodoB nodoB = new NodoB(4, "B");// B
		nodoA.setNodoDer(nodoB);
		NodoB nodoC = new NodoB(5, "C");// C
		NodoB nodoK = new NodoB(6, "K");// K
		nodoM.setNodoDer(nodoK);
		nodoM.setNodoIzq(nodoC);
		NodoB nodoL = new NodoB(7, "L");// L
		NodoB nodoF = new NodoB(8, "F");// F
		nodoC.setNodoDer(nodoF);
		nodoC.setNodoIzq(nodoL);
		NodoB nodoD = new NodoB(9, "D");// D
		nodoL.setNodoDer(nodoD);
		NodoB nodoJ = new NodoB(10, "J");// J
		nodoK.setNodoDer(nodoJ);
		NodoB nodoH = new NodoB(11, "H");// H
		nodoJ.setNodoIzq(nodoH);

		arbol.setRaiz(nuevonodo);
		
		
		ArbolB arbolEjercicio3 = new ArbolB();
		NodoB nodoRaiz= new NodoB(4, "m");
		NodoB nodo1 = new NodoB(2, "s");
		NodoB nodo2 = new NodoB(3, "t");
		NodoB nodo3 = new NodoB(3, "q");
		NodoB nodo4 = new NodoB(6, "d");
		NodoB nodo5 = new NodoB(5, "k");
		arbolEjercicio3.setRaiz(nodoRaiz);
		nodoRaiz.setNodoDer(nodo4);
		nodoRaiz.setNodoIzq(nodo3);
		nodo3.setNodoIzq(nodo1);
		nodo3.setNodoDer(nodo2);
		nodo4.setNodoIzq(nodo5);

		ArrayList<String> preordenControl = new ArrayList<String>();
		System.out.println("Imprimir Preorden Arbol Control");
		imprimirPreorden(arbolEjercicio3.getRaiz(), preordenControl);
		System.out.println("Imprimir Array Preorden Control");
		for (int i = 0; i < preordenControl.size(); i++) {
			System.out.println(preordenControl.get(i));
		}


		// Esto es para el ej 3 para ver si estan los caminos dentro del arbol
		// listas que se cargan mediante funcion recursiva segun el orden que queremos
		// obtener del arbol
		ArrayList<String> preorden = new ArrayList<String>();
		ArrayList<String> inorden = new ArrayList<String>();
		ArrayList<String> postorden = new ArrayList<String>();
		
		/*
		 * System.out.println("1-B Listar en Preorden"); imprimirItPostorden(arbol);
		 * System.out.println("1-B Listar en Inorden"); imprimirItInorden(arbol);
		 * System.out.println("SEPARANDO");
		 * 
		 * char preorden[] = {'G','E','A','I','B','M','C','L','D','F','K','J','H'}; char
		 * inorden[] = {'I','A','B','E','G','L','D','C','F','M','K','H','J'}; int len =
		 * inorden.length; ImprimirPostorden tree = new ImprimirPostorden();
		 * tree.printPost(inorden, preorden, 0, len - 1);
		 */
		// listarItPostorden(nuevo.getRaiz());

		// imprimirPosorden(nuevo);
		// System.out.print("Arbol recien salido del HORNO");
		// imprimirPosorden(nuevo);

		// ArbolB arbol = new ArbolB();
		// arbol.setRaiz(null);
		// arbol = insertarArbol(arbol, nuevo.subIzquierdo());

		// System.out.print("Sub arbol izquierdo de Nuevo");
		// imprimirPosorden(nuevo.subIzquierdo());

		// System.out.print("Arbol recien robado de otro arbol");
		// imprimirPosorden(arbol);

		//PARA QUE ESTO FUNCIONE SIEMPRE HAY QUE AGREGAR EN ESTE ORDEN RAIZ / IZQUIERDO / DERECHO
		// CREA ARBOLES BINARIOS DE BUSQUEDA
		int opcion = 0, elemento;
		String nombre;
		ArbolB arbolSwitch = new ArbolB();
		do {
			try {
				opcion = Integer.parseInt(
						JOptionPane.showInputDialog(null, "1. Agregar un Nodo\n" + "2. Salir\n" + "Elige una Opcion...",
								"Ej 2", JOptionPane.QUESTION_MESSAGE));
				switch (opcion) {
					case 1:
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el numero del Nodo...",
								"Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
						nombre = JOptionPane.showInputDialog(null, "Ingresa el Nombre del Nodo...", "Agregando Nodo",
								JOptionPane.QUESTION_MESSAGE);
								arbolSwitch.agregarNodo(elemento, nombre);
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Fin Respuesta", "Fin", JOptionPane.QUESTION_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opcion no valida", "Pon bien la opcion vite",
								JOptionPane.QUESTION_MESSAGE);
				}
			} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
			}
		} while (opcion != 2);

		System.out.println("Imprimir Preorden");
		imprimirPreorden(arbolSwitch.getRaiz(), preorden);
		System.out.println("Imprimir Array Preorden");
		for (int i = 0; i < preorden.size(); i++) {
			System.out.println(preorden.get(i));
		}
	}//	ACA TERMINA EL MAIN

	// 1B POSTORDEN ITERATIVA
	public static void imprimirItPostorden(ArbolB arbol) {
		NodoB raiz = arbol.getRaiz();
		if (raiz == null) {
			return;
		}
		Stack<NodoB> stack = new Stack<NodoB>();
		stack.push(raiz);
		while (!stack.isEmpty()) {
			NodoB siguiente = stack.peek();
			if (siguiente.getNodoDer() == raiz || siguiente.getNodoIzq() == raiz
					|| (siguiente.getNodoIzq() == null && siguiente.getNodoDer() == null)) {
				stack.pop();
				System.out.println(siguiente.getNombre());
				raiz = siguiente;
			} else {
				if (siguiente.getNodoDer() != null) {
					stack.push(siguiente.getNodoDer());
				}
				if (siguiente.getNodoIzq() != null) {
					stack.push(siguiente.getNodoIzq());
				}
			}
		}
	}

	// 1B INORDEN ITERATIVA
	public static void imprimirItInorden(ArbolB arbol) {
		Stack<NodoB> pila = new Stack<NodoB>();

		NodoB aux = new NodoB();
		aux = arbol.getRaiz();
		while (!pila.isEmpty() || aux != null) {
			if (aux == null) {
				System.out.println(pila.lastElement().getNombre());
				aux = pila.lastElement();
				pila.pop();
				aux = aux.getNodoDer();
			} else {
				pila.push(aux);
				aux = aux.getNodoIzq();
			}
		}
	}

	//EJERCICIO 3 ITERATIVO
	public static boolean comprobarCamino(ArbolB arbol, ArrayList<String> camino) {

        if (camino.get(0) == arbol.getRaiz().getNombre()) {
            NodoB nodoAux = arbol.getRaiz();

            ArrayList<String> caminoAux = new ArrayList<String>();
            caminoAux.add(nodoAux.getNombre());

            for (int i = 0; i < camino.size(); i++) {
                if (nodoAux.getNodoIzq() != null) {
                    if (camino.get(i) == nodoAux.getNodoIzq().getNombre()) {
                        nodoAux = nodoAux.getNodoIzq();
                        caminoAux.add(nodoAux.getNombre());
                    }
                } else if (nodoAux.getNodoDer() != null) {
                    if (camino.get(i) == nodoAux.getNodoDer().getNombre()) {
                        nodoAux = nodoAux.getNodoDer();
                        caminoAux.add(nodoAux.getNombre());
                    }
                }
            }
            if (caminoAux.equals(camino)) {
                return true;
            }
        }
        return false;
	}

	//EJERCICIO 3 RECURSIVO
	public static boolean comprobarCamino(ArbolB arbol, ArrayList<String> camino, int i) {
        boolean existe = false;
        if(camino.size() == i) {
            existe = true;
        }else if (arbol.getRaiz() != null && arbol.getRaiz().getNombre() == camino.get(i)) {
            existe = comprobarCamino(arbol.subIzquierdo(), camino, i + 1);

            if (existe == false)
			existe = comprobarCamino(arbol.subDerecho(), camino, i + 1);
        }else {
            existe = false;
        }
        return existe;
    }

	//FUNCIONES RECURSIVAS PARA IMPRIMIR LOS ORDENES Y GUARDARLOS EN LISTAS
	public static void imprimirPreorden(NodoB auxRaiz, ArrayList<String> lista) {
		if (auxRaiz != null) {
			lista.add(auxRaiz.getNombre());
			System.out.println(auxRaiz.getNombre() + " ");
			imprimirPreorden(auxRaiz.getNodoIzq(), lista);
			imprimirPreorden(auxRaiz.getNodoDer(), lista);
		}
	}

	public static void imprimirPostorden(NodoB auxRaiz, ArrayList<String> lista) {
		if (auxRaiz != null) {
			imprimirPostorden(auxRaiz.getNodoIzq(), lista);
			imprimirPostorden(auxRaiz.getNodoDer(), lista);
			lista.add(auxRaiz.getNombre());
			System.out.println(auxRaiz.getNombre() + " ");
		}
	}

	public static void imprimirInorden(NodoB auxRaiz, ArrayList<String> lista) {
		if (auxRaiz != null) {
			imprimirInorden(auxRaiz.getNodoIzq(), lista);
			lista.add(auxRaiz.getNombre());
			System.out.println(auxRaiz.getNombre() + " ");
			imprimirInorden(auxRaiz.getNodoDer(), lista);
		}
	}

}
