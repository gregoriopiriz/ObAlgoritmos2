import javax.swing.JOptionPane;

public class index {

	public static void main(String[] args) {

		/*
		ArbolB nuevo = new ArbolB();
		
		NodoB nuevonodo = new NodoB("G");
		NodoB nodoM = new NodoB("M");
		NodoB nodoE = new NodoB("E");
		nuevonodo.setNodoIzq(nodoM);
		nuevonodo.setNodoDer(nodoE);
		NodoB nodoA = new NodoB("A");
		nodoE.setNodoDer(nodoA);
		NodoB nodoI = new NodoB("I");
		nodoA.setNodoDer(nodoI);
		NodoB nodoB = new NodoB("B");
		nodoA.setNodoIzq(nodoB);
		NodoB nodoC = new NodoB("C");
		NodoB nodoK = new NodoB("K");
		nodoM.setNodoIzq(nodoK);
		nodoM.setNodoDer(nodoC);
		NodoB nodoL = new NodoB("L");
		NodoB nodoF = new NodoB("F");
		nodoC.setNodoIzq(nodoF);
		nodoC.setNodoDer(nodoL);
		NodoB nodoD = new NodoB("D");
		nodoL.setNodoIzq(nodoD);
		NodoB nodoJ = new NodoB("J");
		nodoK.setNodoIzq(nodoJ);
		NodoB nodoH = new NodoB("H");
		nodoJ.setNodoDer(nodoH);

		
		nuevo.setRaiz(nuevonodo);
		
		
		//imprimirPosorden(nuevo);
		
		imprimirPosorden(nuevo);
		*/
		/*
		int opcion=0, elemento;
		String nombre;
		ArbolB arbol = new ArbolB();
		do {
			try {
				opcion= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar un Nodo\n" 
			+ "2. Salir\n" 
			+ "Elige una Opcion...","Ej 2"
						, JOptionPane.QUESTION_MESSAGE));
				switch(opcion) {
				case 1:
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"ingresa el numero del Nodo...", "Agregando Nodo"
							, JOptionPane.QUESTION_MESSAGE));
					nombre = JOptionPane.showInputDialog(null, 
							"Ingresa el Nombre del Nodo...", "Agregando Nodo"
							, JOptionPane.QUESTION_MESSAGE);
					arbol.agregarNodo(elemento, nombre);
					break;
				case 2:
					JOptionPane.showMessageDialog(null,  "Fin Respuesta", "Fin"
							,JOptionPane.QUESTION_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null,  "Opcion no valida", "Pon bien la opcion vite"
							,JOptionPane.QUESTION_MESSAGE);
				}
			}catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
			}
		}while(opcion!=2);
	*/
		
		
		
		char preorden[] = {'G','E','A','I','B','M','C','L','D','F','K','J','H'};
		
		char inorden[] = {'I','A','B','E','G','L','D','C','F','M','K','H','J'};
		
	}

	
	public static void imprimirPreorden(NodoB reco)
    {
        if (reco != null)
        {
            System.out.println(reco.getDato() + " ");
            imprimirPreorden(reco.getNodoIzq());
            imprimirPreorden(reco.getNodoDer());
        }
    }
	
	public static void imprimirPostorden(NodoB reco)
    {
        if (reco != null)
        {
        	imprimirPostorden(reco.getNodoIzq());
        	imprimirPostorden(reco.getNodoDer());
            System.out.println(reco.getDato() + " ");
        }
    }
	
	public static void imprimirInorden(NodoB auxRaiz)
    {
		if (auxRaiz != null)
        {
			imprimirInorden(auxRaiz.getNodoIzq());
        	System.out.println(auxRaiz.getDato() + " ");
        	imprimirInorden(auxRaiz.getNodoDer());
        }
    }
	
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
	}
	
	public static char[] encontrarArbolDer(char raiz, char[] inorden) {
		char devolver[] = {};
		
		
		return devolver;
	}

	
	public static ArbolB crearArbol(char[] preorden, char[] inorden ) {
		ArbolB arbol = new ArbolB();
		arbol.agregarNodo(0, preorden[0]);
		
		char subDerecho[] = encontrarArbolDer(preorden[0], inorden);
		
		
		
		return null;
	}
	
	
}
	
	
