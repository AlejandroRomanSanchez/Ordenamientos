public class MaxHeap<T extends Comparable<T>> {
    public T[ ] maxHeap;
    public int cardinalidadDelMaxHeap;

    public MaxHeap(T[ ] arreglo, int cardinalidadDelMaxHeap) {
	this.maxHeap = arreglo;
	this.cardinalidadDelMaxHeap = cardinalidadDelMaxHeap;
    }

    public int getCardinalidadDelMaxHeap( ) {
	return cardinalidadDelMaxHeap;
    }

    public int devuelveIndiceDeIzquierdo(int indiceDeNodo) {
	return 2 * indiceDeNodo + 1;
    }

    public int devuelveIndiceDeDerecho(int indiceDeNodo) {
	return 2 * indiceDeNodo + 2;
    }

    public void maxHeapificaAlNodoEn(int indiceDeNodo) throws Exception {
	int indiceDeHijoIzquierdo = this.devuelveIndiceDeIzquierdo(indiceDeNodo);
	int indiceDeHijoDerecho = this.devuelveIndiceDeDerecho(indiceDeNodo);
	int indiceDelMayor;

	if(indiceDeHijoIzquierdo <= this.cardinalidadDelMaxHeap - 1
	   && maxHeap[indiceDeNodo].compareTo(maxHeap[indiceDeHijoIzquierdo]) < 0) {
	    System.out.println("Como existe hijo izquierdo y como el nodo es menor que "
			       + "su hijo izquierdo.");
	    indiceDelMayor = indiceDeHijoIzquierdo;
	} else {
	    System.out.println("Como no existe hijo izquierdo o como el hijo izquierdo"
			       + " es menor o igual que el nodo");
	    indiceDelMayor = indiceDeNodo;
	}
	
	if(indiceDeHijoDerecho <= this.cardinalidadDelMaxHeap - 1
	   && maxHeap[indiceDelMayor].compareTo(maxHeap[indiceDeHijoDerecho]) < 0) {
	    System.out.println("Como existe hijo derecho y el nodo es menor que su hijo derecho");
	    indiceDelMayor = indiceDeHijoDerecho;
	}
	
	if(indiceDelMayor != indiceDeNodo) {
	    System.out.println("Como el mayor de estos tres no fue el nodo");
	    System.out.println("Intercambiamos " + maxHeap[indiceDeNodo] + " con "
			       + maxHeap[indiceDelMayor]);
	    Arreglo.intercambia(maxHeap, indiceDeNodo, indiceDelMayor);
	    System.out.println("Ahora conservamos la propiedad de max-heap a " + maxHeap[indiceDelMayor]);
	    maxHeapificaAlNodoEn(indiceDelMayor);
	}
    }

    public void  construyeUnMaxHeap(int cardinalidadDelMaxHeap) throws Exception {
	this.cardinalidadDelMaxHeap = cardinalidadDelMaxHeap;

	System.out.println("Recorremos todos los nodos que no son hojas del max-heap, "
			   + " o dicho de otro modo, recorremos el arreglo de derecha a"
			   + " izquierda, desde el piso de la mitad de "
			   + this.getCardinalidadDelMaxHeap( ) 
			   + " menos una unidad hasta el índice cero");
	for(int i = cardinalidadDelMaxHeap/ 2 - 1; 0 <= i; i--) {
	    System.out.println("En el índice " + i + ", procedemos a conservar la propiedad"
			       + " de max-heap al nodo de índice " + i + " junto con sus dos"
			       + " hijos");
	    this.maxHeapificaAlNodoEn(i);
	}
    }
}
