package listaligadadoble;
import java.util.Scanner;

class nodo {
    int info;
    nodo ligaSiguiente;
    nodo ligaAnterior;   
}

class nodocreado {
    static nodo P = null;  
    static nodo Q = null;  

    public static void CreaInicio() {
        Scanner y = new Scanner(System.in);
        int opc = 1;
        int dato;

        if (P == null) {
            P = new nodo();
            System.out.println("Dame Dato: ");
            dato = y.nextInt();
            P.info = dato;
            P.ligaSiguiente = null;
            P.ligaAnterior = null;
            Q = P;
        }

        do {
            nodo nuevoNodo = new nodo();
            System.out.println("Dame Dato: ");
            dato = y.nextInt();
            nuevoNodo.info = dato;

            nuevoNodo.ligaSiguiente = P;
            nuevoNodo.ligaAnterior = null;

            if (P != null) {
                P.ligaAnterior = nuevoNodo;
            }
            P = nuevoNodo;

            System.out.println("Otro nodo? 1(SI) 2 (NO)");
            opc = y.nextInt();
        } while (opc != 2);

        ImprimirLista();
    }

    public static void CreaFinal() {
        Scanner y = new Scanner(System.in);
        int opc = 1;
        int dato;

        if (Q == null) {
            Q = new nodo();
            System.out.println("Dame Dato: ");
            dato = y.nextInt();
            Q.info = dato;
            Q.ligaSiguiente = null;
            Q.ligaAnterior = null;
            P = Q;
        }

        do {
            nodo nuevoNodo = new nodo();
            System.out.println("Dame Dato: ");
            dato = y.nextInt();
            nuevoNodo.info = dato;

            nuevoNodo.ligaSiguiente = null;
            nuevoNodo.ligaAnterior = Q;

            if (Q != null) {
                Q.ligaSiguiente = nuevoNodo;
            }
            Q = nuevoNodo;

            System.out.println("Otro nodo? 1(SI) 2 (NO)");
            opc = y.nextInt();
        } while (opc != 2);

        ImprimirLista();
    }

    public static void InsertarInicio() {
        Scanner y = new Scanner(System.in);
        if (P == null) {
            System.out.println("Lista vacía, creando primer nodo.");
            CreaInicio();
            return;
        }

        nodo nuevoNodo = new nodo();
        System.out.println("Dame Dato: ");
        int dato = y.nextInt();
        nuevoNodo.info = dato;

        nuevoNodo.ligaSiguiente = P;
        nuevoNodo.ligaAnterior = null;

        P.ligaAnterior = nuevoNodo;
        P = nuevoNodo;

        ImprimirLista();
    }

    public static void InsertarFinal() {
        Scanner y = new Scanner(System.in);
        if (Q == null) {
            System.out.println("Lista vacía, creando primer nodo.");
            CreaFinal();
            return;
        }

        nodo nuevoNodo = new nodo();
        System.out.println("Dame Dato: ");
        int dato = y.nextInt();
        nuevoNodo.info = dato;

        nuevoNodo.ligaSiguiente = null;
        nuevoNodo.ligaAnterior = Q;

        Q.ligaSiguiente = nuevoNodo;
        Q = nuevoNodo;

        ImprimirLista();
    }

    public static void EliminarPrincipio() {
        if (P == null) {
            System.out.println("La lista esta vacia creala.");
            return;
        }

        P = P.ligaSiguiente;

        if (P != null) {
            P.ligaAnterior = null;
        } else {
            Q = null; 
        }

        ImprimirLista();
    }

    public static void EliminarFinal() {
        if (Q == null) {
            System.out.println("La lista esta vacia, inserta algo.");
            return;
        }

        Q = Q.ligaAnterior;

        if (Q != null) {
            Q.ligaSiguiente = null;
        } else {
            P = null;
        }

        ImprimirLista();
    }

    public static void EliminarAntesDe() {
        Scanner y = new Scanner(System.in);
        System.out.println("Ingrese el nodo de referencia: ");
        int referencia = y.nextInt();
        
        if (P == null || P.ligaSiguiente == null) {
            System.out.println("No hay nodo antes de " + referencia );
            return;
        }

        nodo actual = P;
        while (actual != null && actual.info != referencia) {
            actual = actual.ligaSiguiente;
        }

        if (actual == null) {
            System.out.println("El nodo de referencia no existe.");
        } else if (actual.ligaAnterior == null) {
            System.out.println("No hay nodo antes del nodo de referencia.");
        } else {
            nodo nodoAEliminar = actual.ligaAnterior;
            nodo previo = nodoAEliminar.ligaAnterior;

            if (previo != null) {
                previo.ligaSiguiente = actual;
            } else {
                P = actual; 
            }

            actual.ligaAnterior = previo;

            System.out.println("Nodo antes del valor de referencia eliminado.");
            ImprimirLista();
        }
    }
    
    public static void EliminarDespuesDe(){
        Scanner y = new Scanner(System.in);
        System.out.println("Ingrese el nodo de referencia: ");
        int referencia = y.nextInt();
        
        if (P == null) {
            System.out.println("No hay nodo después de: " + referencia);
            return;
        }

        nodo actual = P;
        while (actual != null && actual.info != referencia) {
            actual = actual.ligaSiguiente;
        }

        if (actual == null) {
            System.out.println("El nodo de referencia no existe.");
        } else if (actual.ligaSiguiente == null) {
            System.out.println("No hay nodo después del nodo de referencia.");
        } else {
            nodo nodoAEliminar = actual.ligaSiguiente;
            nodo siguiente = nodoAEliminar.ligaSiguiente;

            if (siguiente != null) {
                siguiente.ligaAnterior = actual;
            } else {
                Q = actual;
            }
            actual.ligaSiguiente = siguiente;

            System.out.println("Nodo después del valor de referencia eliminado.");
            ImprimirLista();
        }
    }

    public static void ImprimirLista() {
        System.out.println("La Lista Creada es: ");
        for (nodo i = P; i != null; i = i.ligaSiguiente) {
            System.out.println("Dato: " + i.info);
        }
    }

    public static void ImprimirInversa() {
        System.out.println("La lista creada en orden inverso es: ");
        for (nodo i = Q; i != null; i = i.ligaAnterior) {
            System.out.println("Dato: " + i.info);
        }
    }

    public static void InsertarAntesDe(int referencia, int dato) {
        if (P == null) {
            System.out.println("La lista no tiene nada.");
            return;
        }

        nodo actual = P;
        while (actual != null && actual.info != referencia) {
            actual = actual.ligaSiguiente;
        }

        if (actual == null) {
            System.out.println("El nodo de referencia no existe.");
        } else {
            nodo nuevoNodo = new nodo();
            nuevoNodo.info = dato;
            nuevoNodo.ligaSiguiente = actual;
            nuevoNodo.ligaAnterior = actual.ligaAnterior;

            if (actual.ligaAnterior != null) {
                actual.ligaAnterior.ligaSiguiente = nuevoNodo;
            } else {
                P = nuevoNodo;
            }

            actual.ligaAnterior = nuevoNodo;

            System.out.println("Nodo insertado antes del valor de referencia.");
            ImprimirLista();
        }
    }

    public static void InsertarDespuesDe(int referencia, int dato) {
        if (P == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        nodo actual = P;
        while (actual != null && actual.info != referencia) {
            actual = actual.ligaSiguiente;
        }

        if (actual == null) {
            System.out.println("El nodo de referencia no existe.");
        } else {
            nodo nuevoNodo = new nodo();
            nuevoNodo.info = dato;
            nuevoNodo.ligaSiguiente = actual.ligaSiguiente;
            nuevoNodo.ligaAnterior = actual;

            if (actual.ligaSiguiente != null) {
                actual.ligaSiguiente.ligaAnterior = nuevoNodo;
            } else {
                Q = nuevoNodo;
            }

            actual.ligaSiguiente = nuevoNodo;

            System.out.println("Nodo insertado despues del valor de referencia.");
            ImprimirLista();
        }
    }

    public static void EliminarNodo(int x) {
        if (P == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        nodo actual = P;
        while (actual != null && actual.info != x) {
            actual = actual.ligaSiguiente;
        }

        if (actual == null) {
            System.out.println("El nodo no se encontró.");
        } else {
            if (actual.ligaAnterior != null) {
                actual.ligaAnterior.ligaSiguiente = actual.ligaSiguiente;
            } else {
                P = actual.ligaSiguiente;
            }

            if (actual.ligaSiguiente != null) {
                actual.ligaSiguiente.ligaAnterior = actual.ligaAnterior;
            } else {
                Q = actual.ligaAnterior;
            }

            System.out.println("Nodo eliminado.");
            ImprimirLista();
        }
    }

    public static void BuscarNodo(int x) {
        nodo actual = P;
        while (actual != null) {
            if (actual.info == x) {
                System.out.println("Nodo encontrado: " + x);
                return;
            }
            actual = actual.ligaSiguiente;
        }
        System.out.println("Nodo no encontrado: " + x);
    }
}

public class ListaLigadaDoble {
    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);
        int opc, referencia, dato;

        do {
            System.out.println("\nMenu listas doblemente enlazadas");
            System.out.println("1. Crear Inicio");
            System.out.println("2. Crear Final");
            System.out.println("3. Insertar al Inicio");
            System.out.println("4. Insertar al Final");
            System.out.println("5. Eliminar al Inicio");
            System.out.println("6. Eliminar al Final");
            System.out.println("7. Insertar Antes De");
            System.out.println("8. Insertar Después De");
            System.out.println("9. Eliminar Antes De");
            System.out.println("10. Eliminar Después De");
            System.out.println("11. Eliminar Nodo");
            System.out.println("12. Buscar Nodo");
            System.out.println("13. Imprimir Lista");
            System.out.println("14. Imprimir Lista Inversa");
            System.out.println("15. Salir");
            System.out.print("Opción: ");
            opc = y.nextInt();

            switch (opc) {
                case 1:
                    nodocreado.CreaInicio();
                    break;
                case 2:
                    nodocreado.CreaFinal();
                    break;
                case 3:
                    nodocreado.InsertarInicio();
                    break;
                case 4:
                    nodocreado.InsertarFinal();
                    break;
                case 5:
                    nodocreado.EliminarPrincipio();
                    break;
                case 6:
                    nodocreado.EliminarFinal();
                    break;
                case 7:
                    System.out.print("Nodo de referencia: ");
                    referencia = y.nextInt();
                    System.out.print("Dato a insertar: ");
                    dato = y.nextInt();
                    nodocreado.InsertarAntesDe(referencia, dato);
                    break;
                case 8:
                    System.out.print("Nodo de referencia: ");
                    referencia = y.nextInt();
                    System.out.print("Dato a insertar: ");
                    dato = y.nextInt();
                    nodocreado.InsertarDespuesDe(referencia, dato);
                    break;
                case 9:
                    nodocreado.EliminarAntesDe();
                    break;
                case 10:
                    nodocreado.EliminarDespuesDe();
                    break;
                case 11:
                    System.out.print("Nodo a eliminar: ");
                    dato = y.nextInt();
                    nodocreado.EliminarNodo(dato);
                    break;
                case 12:
                    System.out.print("Nodo a buscar: ");
                    dato = y.nextInt();
                    nodocreado.BuscarNodo(dato);
                    break;
                case 13:
                    nodocreado.ImprimirLista();
                    break;
                case 14:
                    nodocreado.ImprimirInversa();
                    break;
                case 15:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opc != 15);
    }
}

