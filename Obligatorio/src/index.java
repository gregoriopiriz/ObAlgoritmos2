import java.util.Arrays;
import java.util.Stack;

public class index {

	public static void main(String[] args) {

		// char preorden[] = {'G','E','A','I','B','M','C','L','D','F','K','J','H'};

		// char inorden[] = {'I','A','B','E','G','L','D','C','F','M','K','H','J'};

		ArbolB nuevo = new ArbolB();
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

		nuevo.setRaiz(nuevonodo);

		imprimirPostorden(nuevo.getRaiz());
		System.out.println("SEPARANDO ESTA MIERDA");
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

		/*
		 * int opcion=0, elemento; String nombre; ArbolB arbol = new ArbolB(); do { try
		 * { opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
		 * "1. Agregar un Nodo\n" + "2. Salir\n" + "Elige una Opcion...","Ej 2" ,
		 * JOptionPane.QUESTION_MESSAGE)); switch(opcion) { case 1: elemento =
		 * Integer.parseInt(JOptionPane.showInputDialog(null,
		 * "ingresa el numero del Nodo...", "Agregando Nodo" ,
		 * JOptionPane.QUESTION_MESSAGE)); nombre = JOptionPane.showInputDialog(null,
		 * "Ingresa el Nombre del Nodo...", "Agregando Nodo" ,
		 * JOptionPane.QUESTION_MESSAGE); arbol.agregarNodo(elemento, nombre); break;
		 * case 2: JOptionPane.showMessageDialog(null, "Fin Respuesta", "Fin"
		 * ,JOptionPane.QUESTION_MESSAGE); break; default:
		 * JOptionPane.showMessageDialog(null, "Opcion no valida",
		 * "Pon bien la opcion vite" ,JOptionPane.QUESTION_MESSAGE); }
		 * }catch(NumberFormatException n) { JOptionPane.showMessageDialog(null, "Error"
		 * + n.getMessage()); } }while(opcion!=2);
		 */

	}

	/*
	 * public static void listarItPreorden(ArbolB arbol) { Stack<NodoB> pila = new
	 * Stack<NodoB>();
	 * 
	 * NodoB aux = new NodoB(); aux=arbol.getRaiz();
	 * System.out.println(aux.getNombre()); while(!pila.isEmpty() || aux!=null)
	 * //Mientras que la pila no sea vacia o el auxiliar no sea nulo { if(aux==null)
	 * { System.out.println(pila.lastElement().getNombre()); aux=pila.lastElement();
	 * pila.pop(); aux=aux.getNodoDer(); } else { pila.push(aux);
	 * aux=aux.getNodoIzq(); } } }
	 */
	public static char[] addElement(char[] a, char e) {
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}

	public static void listarItPostorden(NodoB root) {
		if (root == null) {
			return;
		}
		Stack<NodoB> stack = new Stack<NodoB>();
		stack.push(root);
		while (!stack.isEmpty()) {
			NodoB next = stack.peek();
			if (next.getNodoDer() == root || next.getNodoIzq() == root
					|| (next.getNodoIzq() == null && next.getNodoDer() == null)) {
				stack.pop();
				System.out.println(next.getNombre());
				root = next;
			} else {
				if (next.getNodoDer() != null) {
					stack.push(next.getNodoDer());
				}
				if (next.getNodoIzq() != null) {
					stack.push(next.getNodoIzq());
				}
			}
		}
	}

	public static void listarItInorden(NodoB root) {
		if (root == null) {
			return;
		}
		Stack<NodoB> stack = new Stack<NodoB>();
		stack.push(root);
		while (!stack.isEmpty()) {
			NodoB next = stack.peek();
			if (next.getNodoDer() == root || next.getNodoIzq() == root
					|| (next.getNodoIzq() == null && next.getNodoDer() == null)) {
				stack.pop();
				System.out.println(next.getNombre());
				root = next;
			} else {
				if (next.getNodoDer() != null) {
					stack.push(next.getNodoDer());
				}
				if (next.getNodoIzq() != null) {
					stack.push(next.getNodoIzq());
				}
			}
		}
	}

	public static void imprimirPreorden(NodoB reco) {
		if (reco != null) {
			System.out.println(reco.getNombre() + " ");
			imprimirPreorden(reco.getNodoIzq());
			imprimirPreorden(reco.getNodoDer());
		}
	}

	public static void imprimirPostorden(NodoB reco) {
		if (reco != null) {
			imprimirPostorden(reco.getNodoIzq());
			imprimirPostorden(reco.getNodoDer());
			System.out.println(reco.getNombre() + " ");
		}
	}

	public static void imprimirInorden(NodoB auxRaiz) {
		if (auxRaiz != null) {
			imprimirInorden(auxRaiz.getNodoIzq());
			System.out.println(auxRaiz.getNombre() + " ");
			imprimirInorden(auxRaiz.getNodoDer());
		}
	}

	static void printPostOrder(int in1[], int pre[], int n) {
		// The first element in pre[] is
		// always root, search it in in[]
		// to find left and right subtrees
		int root = search(in1, pre[0], n);

		// If left subtree is not empty,
		// print left subtree
		if (root != 0) {
			printPostOrder(in1, Arrays.copyOfRange(pre, 1, n), root);
		}

		// If right subtree is not empty,
		// print right subtree
		if (root != n - 1) {
			printPostOrder(Arrays.copyOfRange(in1, root + 1, n), Arrays.copyOfRange(pre, 1 + root, n), n - root - 1);
		}

		// Print root
		System.out.print(pre[0] + " ");
	}

	// A utility function to search x in arr[] of size n
	static int search(int arr[], int x, int n) {
		for (int i = 0; i < n; i++)
			if (arr[i] == x)
				return i;
		return -1;
	}

	/*
	 * public static char[] encontrarArbolDer(char raiz, char[] inorden) { char
	 * arbolDer[] = {}; boolean pasoRaiz = false; for (char i = 0; i <
	 * inorden.length; i++) { if(pasoRaiz){ arbolDer = addElement(arbolDer, i); }
	 * if(pasoRaiz == false){ if(raiz == i){ pasoRaiz = true; } } } return arbolDer;
	 * } public static char[] encontrarArbolIzq(char raiz, char[] inorden) { char
	 * arbolIzq[] = {}; boolean pasoRaiz = false; for (char i = 0; i <
	 * inorden.length; i++) { if(raiz == i){ pasoRaiz = true; } if(pasoRaiz ==
	 * false){ arbolIzq = addElement(arbolIzq, i); } } return arbolIzq; } public
	 * static char[] encontrarOrdenArbolDer(char raiz, char[] preorden) { char
	 * arbolDer[] = {}; boolean pasoRaiz = false; for (char i = 1; i <
	 * preorden.length; i++) { if(pasoRaiz){ arbolDer = addElement(arbolDer, i); }
	 * if(pasoRaiz == false){ if(raiz == i){ pasoRaiz = true; } } } return arbolDer;
	 * } public static char[] encontrarOrdenArbolIzq(char raiz, char[] preorden) {
	 * char arbolIzq[] = {}; boolean pasoRaiz = false; for (char i = 1; i <
	 * preorden.length; i++) { if(raiz == i){ pasoRaiz = true; } if(pasoRaiz ==
	 * false){ arbolIzq = addElement(arbolIzq, i); } } return arbolIzq; }/*
	 * 
	 * 
	 * /*public static ArbolB crearArbol(char[] preorden, char[] inorden ) { ArbolB
	 * arbol = new ArbolB(); arbol.agregarNodo(0, preorden[0]);
	 * 
	 * //char subDerecho[] = encontrarArbolDer(preorden[0], inorden);
	 * 
	 * 
	 * 
	 * return null; }
	 */

	public static ArbolB insertar(ArbolB arbol, int x) {
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

	public static ArbolB insertarArbol(ArbolB arbol, ArbolB otro) {
		if (otro.getRaiz() != null) {
			// Inserto primero la raiz como dato
			arbol = insertar(arbol, otro.getRaiz().getDato());
			// Llamo recursivamente para el subArbol izquierdo y el subarbol derecho
			insertarArbol(arbol, otro.subIzquierdo());
			insertarArbol(arbol, otro.subDerecho());
		}
		return arbol;
	}

}
