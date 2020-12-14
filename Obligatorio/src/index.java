import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class index {

	public static void main(String[] args) {

		// ARMANDO EL ARBOL DEL EJ 2 MANUALMENTE
		ArbolB arbolEj2 = new ArbolB();
		NodoB nuevonodo = new NodoB(0, "G");
		NodoB nodoM = new NodoB(1, "M");
		NodoB nodoE = new NodoB(2, "E");
		nuevonodo.setNodoDer(nodoM);
		nuevonodo.setNodoIzq(nodoE);
		NodoB nodoA = new NodoB(2, "A");
		nodoE.setNodoIzq(nodoA);
		NodoB nodoI = new NodoB(3, "I");
		nodoA.setNodoIzq(nodoI);
		NodoB nodoB = new NodoB(4, "B");
		nodoA.setNodoDer(nodoB);
		NodoB nodoC = new NodoB(5, "C");
		NodoB nodoK = new NodoB(6, "K");
		nodoM.setNodoDer(nodoK);
		nodoM.setNodoIzq(nodoC);
		NodoB nodoL = new NodoB(7, "L");
		NodoB nodoF = new NodoB(8, "F");
		nodoC.setNodoDer(nodoF);
		nodoC.setNodoIzq(nodoL);
		NodoB nodoD = new NodoB(9, "D");
		nodoL.setNodoDer(nodoD);
		NodoB nodoJ = new NodoB(10, "J");
		nodoK.setNodoDer(nodoJ);
		NodoB nodoH = new NodoB(11, "H");
		nodoJ.setNodoIzq(nodoH);

		arbolEj2.setRaiz(nuevonodo);

		ArrayList<String> preordenArbolEj2 = new ArrayList<String>();
		ArrayList<String> inordenArbolEj2 = new ArrayList<String>();
		ArrayList<String> postordenArbolEj2 = new ArrayList<String>();

		imprimirItPostorden(arbolEj2, postordenArbolEj2);
		imprimirItInorden(arbolEj2, inordenArbolEj2);
		/*
		 * FUNCIONES PARA PROBAR RECURSIVAMENTE EL 1B (TAMBIEN COMENTADO EN EL SWITCH)
		 * imprimirPreorden(arbolEj2.getRaiz(), preordenArbolEj2);
		 * imprimirInorden(arbolEj2.getRaiz(), inordenArbolEj2);
		 * imprimirPostorden(arbolEj2.getRaiz(), postordenArbolEj2);
		 */
		// ARMANDO EL ARBOL DEL EJ 3 MANUALMENTE
		ArbolB arbolEj3 = new ArbolB();
		NodoB nodoRaiz = new NodoB(4, "m");
		NodoB nodo1 = new NodoB(2, "s");
		NodoB nodo2 = new NodoB(3, "t");
		NodoB nodo3 = new NodoB(3, "q");
		NodoB nodo4 = new NodoB(6, "d");
		NodoB nodo5 = new NodoB(5, "k");
		nodoRaiz.setNodoDer(nodo4);
		nodoRaiz.setNodoIzq(nodo3);
		nodo3.setNodoIzq(nodo1);
		nodo3.setNodoDer(nodo2);
		nodo4.setNodoIzq(nodo5);
		arbolEj3.setRaiz(nodoRaiz);

		ArrayList<String> preordenArbolEj3 = new ArrayList<String>();
		ArrayList<String> inordenArbolEj3 = new ArrayList<String>();
		ArrayList<String> postordenArbolEj3 = new ArrayList<String>();

		imprimirItPostorden(arbolEj3, postordenArbolEj3);
		imprimirItInorden(arbolEj3, inordenArbolEj3);

		/*
		 * FUNCIONES PARA PROBAR RECURSIVAMENTE EL 1B (TAMBIEN COMENTADO EN EL SWITCH)
		 * imprimirPreorden(arbolEj3.getRaiz(), preordenArbolEj3);
		 * imprimirInorden(arbolEj3.getRaiz(), inordenArbolEj3);
		 * imprimirPostorden(arbolEj3.getRaiz(), postordenArbolEj3);
		 */
		/*
		 * ArrayList<String> preordenControl = new ArrayList<String>();
		 * System.out.println("Imprimir Preorden Arbol Control");
		 * imprimirPreorden(arbolEj3.getRaiz(), preordenControl);
		 * System.out.println("Imprimir Array Preorden Control"); for (int i = 0; i <
		 * preordenControl.size(); i++) { System.out.println(preordenControl.get(i)); }
		 */

		// Esto es para el ej 3 para ver si estan los caminos dentro del arbol
		// listas que se cargan mediante funcion recursiva segun el orden que queremos
		// obtener del arbol
		ArrayList<String> preorden = new ArrayList<String>();
		ArrayList<String> inorden = new ArrayList<String>();
		ArrayList<String> postorden = new ArrayList<String>();

		/*	  
		char preorden[] = {'G','E','A','I','B','M','C','L','D','F','K','J','H'}; 
		char inorden[] = {'I','A','B','E','G','L','D','C','F','M','K','H','J'};
		ImprimirPostorden impPost = new ImprimirPostorden();
		impPost.imprimirPost(inorden, preorden, 0, inorden.length - 1);
		 */

		// PARA QUE ESTO FUNCIONE SIEMPRE HAY QUE AGREGAR EN ESTE ORDEN RAIZ / IZQUIERDO / DERECHO
		// CREA ARBOLES BINARIOS DE BUSQUEDA
		// PARA CASE 1 DE CREAR TU PROPIO ARBOL
		int opcion = 0, elemento;
		String nombre;
		ArbolB arbolSwitch = new ArbolB();
		ArrayList<String> preordenarbolSwitch = new ArrayList<String>();
		ArrayList<String> inordenarbolSwitch = new ArrayList<String>();
		ArrayList<String> postordenarbolSwitch = new ArrayList<String>();

		String posibleRecorrido;

		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(
						null, "1. Crea tu propio Arbol\n" + "2. Ejercicio 1-B\n" + "3. Ejercicio 2-C\n"
								+ "4. Ejercicio 3\n" + "5. Salir\n" + "Elige una Opcion...",
						"Ej 2", JOptionPane.QUESTION_MESSAGE));
				switch (opcion) {
					case 1:
						do {
							try {
								opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Recuerda agregar los nodos en orden Raiz / Izquierdo / Derecho\n" +
										"1. Agregar un Nodo\n" + "2. Salir\n" + "Elige una Opcion...", "Ej 2",
										JOptionPane.QUESTION_MESSAGE));
								switch (opcion) {
									case 1:
										elemento = Integer.parseInt(
												JOptionPane.showInputDialog(null, "ingresa el numero del Nodo...",
														"Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
										nombre = JOptionPane.showInputDialog(null, "Ingresa el Nombre del Nodo...",
												"Agregando Nodo", JOptionPane.QUESTION_MESSAGE);
										arbolSwitch.agregarNodo(elemento, nombre);
										break;
									case 2:
										JOptionPane.showMessageDialog(null, "Fin Respuesta", "Fin",
												JOptionPane.QUESTION_MESSAGE);
										break;
									default:
										JOptionPane.showMessageDialog(null, "Opcion no valida",
												"Pon bien la opcion vite", JOptionPane.QUESTION_MESSAGE);
								}
							} catch (NumberFormatException n) {
								JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
							}
						} while (opcion != 2);
						/* ESTA COMENTADO PARA QUE NO QUEDE DOBLE AL IR A LOS EJERCICIOS
						// imprimiendo Preorden del arbol nuevo
						imprimirPreorden(arbolSwitch.getRaiz(), preordenarbolSwitch);
						JOptionPane.showMessageDialog(null,
								"Arbol creado en Preorden\n" + preordenarbolSwitch.toString());

						// imprimiendo Postorden del arbol nuevo
						imprimirPostorden(arbolSwitch.getRaiz(), postordenarbolSwitch);
						JOptionPane.showMessageDialog(null,
								"Arbol creado en Postorden\n" + postordenarbolSwitch.toString());

						// imprimiendo Inorden del arbol nuevo
						imprimirInorden(arbolSwitch.getRaiz(), inordenarbolSwitch);
						JOptionPane.showMessageDialog(null,
								"Arbol creado en Inorden\n" + inordenarbolSwitch.toString());
						*/
						break;
					case 2:
						do {
							try {
								if (arbolSwitch.getRaiz() != null) {
									opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
											"Elige el arbol en el que quieres probar\n" + "1. Arbol Ejercicio 2\n"
													+ "2. Arbol Ejercicio 3\n" + "3. Tu Arbol\n" + "4. Salir\n"
													+ "Elige una Opcion...",
											"Ej 2", JOptionPane.QUESTION_MESSAGE));
								}
								if (arbolSwitch.getRaiz() == null) {
									opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
											"Elige el arbol en el que quieres probar\n" + "1. Arbol Ejercicio 2\n"
													+ "2. Arbol Ejercicio 3\n" + "4. Salir\n" + "Elige una Opcion...",
											"Ej 2", JOptionPane.QUESTION_MESSAGE));
								}
								switch (opcion) {
									case 1:
										// ITERATIVO SE PUEDE VER COMO SE LLENAN ESTAS LISTAS DEBAJO DE LA DEFINICION DE
										// CADA ARBOL
										JOptionPane.showMessageDialog(null,
												"Arbol creado en Postorden\n" + postordenArbolEj2.toString());
										JOptionPane.showMessageDialog(null,
												"Arbol creado en Inorden\n" + inordenArbolEj2.toString());
										/*
										 * RECURSIVO JOptionPane.showMessageDialog(null, "Arbol creado en Preorden\n" +
										 * preordenArbolEj2.toString()); JOptionPane.showMessageDialog(null,
										 * "Arbol creado en Inorden\n" + inordenArbolEj2.toString());
										 * JOptionPane.showMessageDialog(null, "Arbol creado en Postorden\n" +
										 * postordenArbolEj2.toString());
										 */
										break;
									case 2:
										// ITERATIVO SE PUEDE VER COMO SE LLENAN ESTAS LISTAS DEBAJO DE LA DEFINICION DE
										// CADA ARBOL
										JOptionPane.showMessageDialog(null,
												"Arbol creado en Postorden\n" + postordenArbolEj3.toString());
										JOptionPane.showMessageDialog(null,
												"Arbol creado en Inorden\n" + inordenArbolEj3.toString());
										/*
										 * RECURSIVO JOptionPane.showMessageDialog(null, "Arbol creado en Preorden\n" +
										 * preordenArbolEj3.toString()); JOptionPane.showMessageDialog(null,
										 * "Arbol creado en Inorden\n" + inordenArbolEj3.toString());
										 * JOptionPane.showMessageDialog(null, "Arbol creado en Postorden\n" +
										 * postordenArbolEj3.toString());
										 */
										break;
									case 3:
										// ITERATIVO LA FUNCION imprimirItPostorden Y imprimirItInorden IMPRIMEN Y A LA
										// VEZ CREAN UNA LISTA
										imprimirItPostorden(arbolSwitch, postordenarbolSwitch);
										JOptionPane.showMessageDialog(null,
												"Arbol creado en Postorden\n" + postordenarbolSwitch.toString());
										imprimirItInorden(arbolSwitch, inordenarbolSwitch);
										JOptionPane.showMessageDialog(null,
												"Arbol creado en Inorden\n" + inordenarbolSwitch.toString());
										/*
										 * RECURSIVO JOptionPane.showMessageDialog(null, "Arbol creado en Preorden\n" +
										 * preordenarbolSwitch.toString()); JOptionPane.showMessageDialog(null,
										 * "Arbol creado en Inorden\n" + inordenarbolSwitch.toString());
										 * JOptionPane.showMessageDialog(null, "Arbol creado en Postorden\n" +
										 * postordenarbolSwitch.toString());
										 */
										break;
									case 4:
										JOptionPane.showMessageDialog(null, "Fin Respuesta", "Fin",
												JOptionPane.QUESTION_MESSAGE);
										break;
									default:
										JOptionPane.showMessageDialog(null, "Opcion no valida",
												"Pon bien la opcion vite", JOptionPane.QUESTION_MESSAGE);
								}
							} catch (NumberFormatException n) {
								JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
							}
						} while (opcion != 4);
						break;
					case 3:
						String ingresoPreorden;
						String ingresoInorden;
						ingresoPreorden = JOptionPane.showInputDialog(null, "Ingresa el recorrido en Preorden...",
								"Guardando recorrido", JOptionPane.QUESTION_MESSAGE);
						ArrayList<String> recorridoPreorden = new ArrayList<String>(
								Arrays.asList(ingresoPreorden.split("")));
						char[] pre = recorridoPreorden.stream().collect(Collectors.joining()).toCharArray();

						ingresoInorden = JOptionPane.showInputDialog(null, "Ingresa el recorrido en Inorden...",
								"Guardando recorrido", JOptionPane.QUESTION_MESSAGE);
						ArrayList<String> recorridoInorden = new ArrayList<String>(
								Arrays.asList(ingresoInorden.split("")));
						char[] in = recorridoInorden.stream().collect(Collectors.joining()).toCharArray();

						ImprimirPostorden ej2C = new ImprimirPostorden();
						ej2C.imprimirPost(in, pre, 0, pre.length - 1);
						JOptionPane.showMessageDialog(null, "Recorrido en Postorden segun Preorden e Inorden\n"
								+ ej2C.resultadoPostorden.toString());
						break;
					case 4:
						do {
							try {
								if (arbolSwitch.getRaiz() != null) {
									opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
											"Elige el arbol en el que quieres probar\n" + "1. Arbol Ejercicio 2\n"
													+ "2. Arbol Ejercicio 3\n" + "3. Tu Arbol\n" + "4. Salir\n"
													+ "Elige una Opcion...",
											"Ej 2", JOptionPane.QUESTION_MESSAGE));
								}
								if (arbolSwitch.getRaiz() == null) {
									opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
											"Elige el arbol en el que quieres probar\n" + "1. Arbol Ejercicio 2\n"
													+ "2. Arbol Ejercicio 3\n" + "4. Salir\n" + "Elige una Opcion...",
											"Ej 2", JOptionPane.QUESTION_MESSAGE));
								}
								switch (opcion) {
									case 1:
										posibleRecorrido = JOptionPane.showInputDialog(null,
												"Ingresa el recorrido que quieres consultar...", "Guardando recorrido",
												JOptionPane.QUESTION_MESSAGE);
										ArrayList<String> listPosibleRecorrido = new ArrayList<String>(
												Arrays.asList(posibleRecorrido.split("")));
										JOptionPane.showMessageDialog(null, "¿El camino se encuentra?\n"
												+ comprobarCamino(arbolEj2, listPosibleRecorrido));
										break;
									case 2:
										posibleRecorrido = JOptionPane.showInputDialog(null,
												"Ingresa el recorrido que quieres consultar...", "Guardando recorrido",
												JOptionPane.QUESTION_MESSAGE);
										ArrayList<String> listPosibleRecorrido1 = new ArrayList<String>(
												Arrays.asList(posibleRecorrido.split("")));
										JOptionPane.showMessageDialog(null, "¿El camino se encuentra?\n"
												+ comprobarCamino(arbolEj3, listPosibleRecorrido1));
										break;
									case 3:
										posibleRecorrido = JOptionPane.showInputDialog(null,
												"Ingresa el recorrido que quieres consultar...", "Guardando recorrido",
												JOptionPane.QUESTION_MESSAGE);
										ArrayList<String> listPosibleRecorrido2 = new ArrayList<String>(
												Arrays.asList(posibleRecorrido.split("")));
										JOptionPane.showMessageDialog(null, "¿El camino se encuentra?\n"
												+ comprobarCamino(arbolSwitch, listPosibleRecorrido2));
										break;
									case 4:
										JOptionPane.showMessageDialog(null, "Fin Respuesta", "Fin",
												JOptionPane.QUESTION_MESSAGE);
										break;
									default:
										JOptionPane.showMessageDialog(null, "Opcion no valida",
												"Pon bien la opcion vite", JOptionPane.QUESTION_MESSAGE);
								}
							} catch (NumberFormatException n) {
								JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
							}
						} while (opcion != 4);
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Fin Respuesta", "Fin", JOptionPane.QUESTION_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opcion no valida", "Pon bien la opcion vite",
								JOptionPane.QUESTION_MESSAGE);
				}
			} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
			}
		} while (opcion != 5);

		// imprimir
		System.out.println("Imprimir Preorden");
		imprimirPreorden(arbolSwitch.getRaiz(), preorden);
		System.out.println("Imprimir Array Preorden");
		for (int i = 0; i < preorden.size(); i++) {
			System.out.println(preorden.get(i));
		}
	}// ACA TERMINA EL MAIN

	// 1B POSTORDEN ITERATIVA CON AGREGAR A ARRAYLIST
	public static void imprimirItPostorden(ArbolB arbol, ArrayList<String> lista) {
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
				lista.add(siguiente.getNombre());
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

	// 1B INORDEN ITERATIVA CON AGREGAR A ARRAYLIST
	public static void imprimirItInorden(ArbolB arbol, ArrayList<String> lista) {
		Stack<NodoB> pila = new Stack<NodoB>();

		NodoB aux = new NodoB();
		aux = arbol.getRaiz();
		while (!pila.isEmpty() || aux != null) {
			if (aux == null) {
				lista.add(pila.lastElement().getNombre());
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

	// EJERCICIO 3 ITERATIVO
	public static boolean comprobarCamino(ArbolB arbol, ArrayList<String> camino) {
		boolean devolver = false;
		String nombRaiz = arbol.getRaiz().getNombre();
		String cero = camino.get(0);
		
		if (cero.equals(nombRaiz)) {
			NodoB nodoAux = arbol.getRaiz();

			ArrayList<String> caminoAux = new ArrayList<String>();
			caminoAux.add(nodoAux.getNombre());

			for (int i = 0; i < camino.size(); i++) {
				if (nodoAux.getNodoIzq() != null && camino.get(i).equals(nodoAux.getNodoIzq().getNombre())) {
					nodoAux = nodoAux.getNodoIzq();
					caminoAux.add(nodoAux.getNombre());
				} else if (nodoAux.getNodoDer() != null && camino.get(i).equals(nodoAux.getNodoDer().getNombre())) {
					nodoAux = nodoAux.getNodoDer();
					caminoAux.add(nodoAux.getNombre());
				}
			}
			if (caminoAux.equals(camino)) {
				devolver = true;
			}
		}
		return devolver;
	}

	// FUNCIONES RECURSIVAS PARA IMPRIMIR LOS ORDENES Y GUARDARLOS EN LISTAS
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
