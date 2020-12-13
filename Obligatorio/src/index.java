import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

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

		//Esto es para el ej 3 para ver si estan los caminos dentro del arbol
		//listas que se cargan mediante funcion recursiva segun el orden que queremos obtener del arbol
		ArrayList<String> preorden = new ArrayList<String>();
		ArrayList<String> inorden = new ArrayList<String>();
		ArrayList<String> postorden = new ArrayList<String>();

		System.out.println("Imprimir Preorden");
		imprimirPreorden(arbol.getRaiz(), preorden);
		System.out.println("Imprimir Array Preorden");
		for (int i = 0; i < preorden.size(); i++) {
			System.out.println(preorden.get(i));
		}

		System.out.println("Imprimir Inorden");
		imprimirInorden(arbol.getRaiz(), inorden);
		System.out.println("Imprimir Array Inorden");
		for (int i = 0; i < inorden.size(); i++) {
			System.out.println(inorden.get(i));
		}

		System.out.println("Imprimir Postorden");
		imprimirPostorden(arbol.getRaiz(), postorden);
		System.out.println("Imprimir Array Postorden");
		for (int i = 0; i <postorden.size(); i++) {
			System.out.println(postorden.get(i));
		}

		/*
		System.out.println("1-B Listar en Preorden");
		imprimirItPostorden(arbol);
		System.out.println("1-B Listar en Inorden");
		imprimirItInorden(arbol);
		System.out.println("SEPARANDO");

		char preorden[] = {'G','E','A','I','B','M','C','L','D','F','K','J','H'};
		char inorden[] = {'I','A','B','E','G','L','D','C','F','M','K','H','J'};
        int len = inorden.length;
        ImprimirPostorden tree = new ImprimirPostorden();
		tree.printPost(inorden, preorden, 0, len - 1);
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

	/*public static char[] addElement(char[] a, char e) {
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}*/

	/*private static char[] addElement(char[] array, char push) {
		char[] longer = new char[array.length + 1];
		for (int i = 0; i < array.length; i++)
			longer[i] = array[i];
		longer[array.length] = push;
		return longer;
	}*/

	public static void imprimirArray(char[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i);
		}
	}

	//1B POSTORDEN TERMINADA
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

	//1B INORDEN TERMINADA
	public static void imprimirItInorden(ArbolB arbol)
    {
        Stack<NodoB> pila = new Stack<NodoB>(); 

        NodoB aux = new NodoB();
        aux=arbol.getRaiz();
        while(!pila.isEmpty() || aux!=null)
        {
            if(aux==null)
            {
                System.out.println(pila.lastElement().getNombre());
                aux=pila.lastElement();
                pila.pop();
                aux=aux.getNodoDer();
            }
            else
            {
                pila.push(aux);
                aux=aux.getNodoIzq();
            }
        }
	}
	
	public static void imprimirPreorden(NodoB auxRaiz, ArrayList<String> lista) {
		if (auxRaiz != null) {
			char c=auxRaiz.getNombre();
			String s=Character.toString(c);
			lista.add(s);
			System.out.println(auxRaiz.getNombre() + " ");
			imprimirPreorden(auxRaiz.getNodoIzq(), lista);
			imprimirPreorden(auxRaiz.getNodoDer(), lista);
		}
	}

	public static void imprimirPostorden(NodoB auxRaiz, ArrayList<String> lista) {
		if (auxRaiz != null) {
			imprimirPostorden(auxRaiz.getNodoIzq(), lista);
			imprimirPostorden(auxRaiz.getNodoDer(), lista);
			char c=auxRaiz.getNombre();
			String s=Character.toString(c);
			lista.add(s);
			System.out.println(auxRaiz.getNombre() + " ");
		}
	}

	public static void imprimirInorden(NodoB auxRaiz, ArrayList<String> lista) {
		if (auxRaiz != null) {
			imprimirInorden(auxRaiz.getNodoIzq(), lista);
			char c=auxRaiz.getNombre();
			String s=Character.toString(c);
			lista.add(s);
			System.out.println(auxRaiz.getNombre() + " ");
			imprimirInorden(auxRaiz.getNodoDer(), lista);
		}
	}

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
