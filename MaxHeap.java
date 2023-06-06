public class MaxHeap<T extends Comparable<T>> {
    public T[ ] maxHeap;
    public int cardinalidadDelMaxHeap;

    public MaxHeap(T[ ] arreglo, int cardinalidadDelMaxHeap) {
	this.maxHeap = arreglo;
	this.cardinalidadDelMaxHeap = cardinalidadDelMaxHeap;
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
	    indiceDelMayor = indiceDeHijoIzquierdo;
	} else {
	    indiceDelMayor = indiceDeNodo;
	}

	if(indiceDeHijoDerecho <= this.cardinalidadDelMaxHeap - 1
	   && maxHeap[indiceDelMayor].compareTo(maxHeap[indiceDeHijoDerecho]) < 0) {
	    indiceDelMayor = indiceDeHijoDerecho;
	}

	if(indiceDelMayor != indiceDeNodo) {
	    Arreglo.intercambia(maxHeap, indiceDeNodo, indiceDelMayor);
	    maxHeapificaAlNodoEn(indiceDelMayor);
	}
    }

    public void  construyeUnMaxHeap(int cardinalidadDelMaxHeap) throws Exception {
	this.cardinalidadDelMaxHeap = cardinalidadDelMaxHeap;

	for(int i = cardinalidadDelMaxHeap/ 2 - 1; 0 <= i; i--) {
	    this.maxHeapificaAlNodoEn(i);
	}
    }
}
