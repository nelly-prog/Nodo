package nodo;

class Nodo {
    private int valor;
    private Nodo nodoIzq;
    private Nodo nodoDer;

   
    public Nodo(int valor) {
        this.valor = valor;
        this.nodoIzq = null;
        this.nodoDer = null;
    }

    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(Nodo nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public Nodo getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(Nodo nodoDer) {
        this.nodoDer = nodoDer;
    }
}

class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.getValor()) {
            nodo.setNodoIzq(insertarRecursivo(nodo.getNodoIzq(), valor));
        } else {
            nodo.setNodoDer(insertarRecursivo(nodo.getNodoDer(), valor));
        }

        return nodo;
    }

    
    public void inOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.getNodoIzq());
            System.out.print(nodo.getValor() + " ");
            inOrdenRecursivo(nodo.getNodoDer());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        
      
        int[] numeros = {60, 41, 74, 16, 53, 65, 25, 46, 55, 63, 70, 42, 62, 64};
        
        
        for (int numero : numeros) {
            arbol.insertar(numero);
        }

        
        System.out.println("Números en orden:");
        arbol.inOrden();
    }
}