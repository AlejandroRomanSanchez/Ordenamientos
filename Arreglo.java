public class Arreglo {
    public static <T extends Comparable<T>> void intercambia(T[ ] arreglo, int indice1, int indice2)
    throws Exception{
	int longitudDeArreglo;
	T auxiliar;
	
	if(arreglo == null) {
	    throw new Exception("El arreglo es null");
	}

	longitudDeArreglo = arreglo.length;
	
	if(indice1 < 0 || longitudDeArreglo <= indice1) {
	    throw new Exception("Índices fuera del rango");
	}

	if(indice2 < 0 || longitudDeArreglo <= indice2) {
	    throw new Exception("Índices fuera del rango");
	}

	auxiliar = arreglo[indice1];
	arreglo[indice1] = arreglo[indice2];
	arreglo[indice2] = auxiliar;
    }

    public static <T extends Comparable<T>> void selectionSort(T[ ] arreglo)
    throws Exception {      	
	int longitudDeArreglo;
	int indiceDeNuevoMinimo;

	if(arreglo == null) {
	    throw new Exception("El arreglo parámetro es null");
	}

	longitudDeArreglo = arreglo.length;

	for(int i = 0; i < longitudDeArreglo; i++) {
	    indiceDeNuevoMinimo = i;

	    for(int j = i + 1; j < longitudDeArreglo; j++) {
		if(arreglo[j].compareTo(arreglo[indiceDeNuevoMinimo]) < 0) {
		    indiceDeNuevoMinimo = j;
		}
	    }

	    Arreglo.intercambia(arreglo, i, indiceDeNuevoMinimo);
	}
    }

    public static <T extends Comparable<T>> void quickSort(T[ ] arreglo)
    throws Exception {
	int longitudDeArreglo = arreglo.length;
	Arreglo.quickSort(arreglo, 0, longitudDeArreglo - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[ ] arreglo, int limiteInferior,
							   int limiteSuperior)
    throws Exception {
	int indiceQueRebana;
	
	if(limiteInferior < limiteSuperior) {
	    indiceQueRebana = Arreglo.particiona(arreglo, limiteInferior, limiteSuperior);
	    Arreglo.quickSort(arreglo, limiteInferior, indiceQueRebana - 1);
	    Arreglo.quickSort(arreglo, indiceQueRebana + 1, limiteSuperior);
	}
    }

    public static <T extends Comparable<T>> int particiona(T[ ] arreglo, int limiteInferior,
							    int limiteSuperior)
    throws Exception {
	T valorSuperior = arreglo[limiteSuperior];
	int ultimoIndice = limiteInferior - 1;

	for(int i = limiteInferior; i <= limiteSuperior - 1; i++) {
	    if(arreglo[i].compareTo(valorSuperior) <= 0) {
		ultimoIndice = ultimoIndice + 1;
		Arreglo.intercambia(arreglo, ultimoIndice, i);
	    }
	}

	Arreglo.intercambia(arreglo, ultimoIndice + 1, limiteSuperior);
	return ultimoIndice + 1;
    }
    
    public static <T extends Comparable<T>> void imprime(T[ ] arreglo) {
	for(int i = 0; i < arreglo.length; i++) {
	    System.out.print(arreglo[i].toString( ) + "  ");
	}
	System.out.println( );
    }

    public static <T extends Comparable<T>> T[ ] mezcla(T[ ] arreglo1, T[ ] arreglo2) {
	int longitudDeArreglo1 = arreglo1.length;
	int longitudDeArreglo2 = arreglo2.length;
	Comparable[ ] arregloResultante = new Comparable[longitudDeArreglo1 + longitudDeArreglo2];
	int iteradorDeArreglo1 = 0;
	int iteradorDeArreglo2 = 0;
	int iteradorDeArregloResultante = 0;

	if(arreglo1 == null) {
	    return arreglo2;
	}

	if(arreglo2 == null) {
	    return arreglo1;
	}

	while(iteradorDeArreglo1 <= longitudDeArreglo1 - 1
	      && iteradorDeArreglo2 <= longitudDeArreglo2 - 1) {
	    if(arreglo1[iteradorDeArreglo1].compareTo(arreglo2[iteradorDeArreglo2]) <= 0) {
		arregloResultante[iteradorDeArregloResultante] = arreglo1[iteradorDeArreglo1];
		iteradorDeArreglo1++;
		iteradorDeArregloResultante++;
	    } else {
		arregloResultante[iteradorDeArregloResultante] = arreglo2[iteradorDeArreglo2];
		iteradorDeArreglo2++;
		iteradorDeArregloResultante++;
	    }
	}

	if(iteradorDeArreglo1 == longitudDeArreglo1) {
	    for(int i = iteradorDeArregloResultante; i < longitudDeArreglo1 + longitudDeArreglo2; i++) {
		arregloResultante[i] = arreglo2[iteradorDeArreglo2];
		iteradorDeArreglo2++;
	    }
	} else if(iteradorDeArreglo2 == longitudDeArreglo2) {
	    for(int i = iteradorDeArregloResultante; i < longitudDeArreglo1 + longitudDeArreglo2; i++) {
		arregloResultante[i] = arreglo1[iteradorDeArreglo1];
		iteradorDeArreglo1++;
	    }
	}

	return (T[ ]) arregloResultante;
    }

    public static <T extends Comparable<T>> Comparable[ ] mergeSort(T[ ] arreglo) {
	int longitudDeArreglo = arreglo.length;
	Comparable[ ] primeraMitad;
	Comparable[ ] segundaMitad;
	int longitudDePrimeraMitad;
	int longitudDeSegundaMitad;
	Comparable[ ] arregloResultante;

	if(arreglo == null || longitudDeArreglo == 1) {
	    return arreglo;
	}

	if(longitudDeArreglo == 2) {
	    arregloResultante = new Comparable[2];
	    
	    if(arreglo[0].compareTo(arreglo[1]) <= 0) {
		return arreglo;
	    } else {
		arregloResultante[0] = arreglo[1];
		arregloResultante[1] = arreglo[0];
	    }
	}

	if(longitudDeArreglo % 2 == 0) {
	    longitudDePrimeraMitad = longitudDeArreglo / 2;
	    longitudDeSegundaMitad = longitudDeArreglo / 2;	    	    
	} else {
	    longitudDePrimeraMitad = (longitudDeArreglo - 1) / 2;
	    longitudDeSegundaMitad = (longitudDeArreglo - 1) / 2 + 1;
	}

	primeraMitad = new Comparable[longitudDePrimeraMitad];
	segundaMitad = new Comparable[longitudDeSegundaMitad];

	for(int i = 0; i < longitudDePrimeraMitad; i++) {
	    primeraMitad[i] = arreglo[i];
	}

	for(int i = longitudDePrimeraMitad; i < longitudDeArreglo; i++) {
	    segundaMitad[i - longitudDePrimeraMitad] = arreglo[i];
	}

	primeraMitad = Arreglo.mergeSort(primeraMitad);
	segundaMitad = Arreglo.mergeSort(segundaMitad);
	arregloResultante = Arreglo.mezcla(primeraMitad, segundaMitad);

	return arregloResultante;
    }
    
    public static void main(String[ ] args) throws Exception {
	Integer[ ] arregloEnteros = {5, 12, 22, 3, 55, 8, 3, 10};
	Arreglo.imprime(arregloEnteros);
	Arreglo.selectionSort(arregloEnteros);
	System.out.println("Pruebas para selectionSort( ):");
	Arreglo.imprime(arregloEnteros);

	System.out.println("Pruebas para quickSort( ): ");
	Integer[ ] arregloEnteros1 = {5, 12, 22, 3, 55, 8, 3, 10};
	Arreglo.imprime(arregloEnteros1);
	Arreglo.quickSort(arregloEnteros1);
	Arreglo.imprime(arregloEnteros1);

	System.out.println("\n\nPruebas para mergeSort( );");
	Integer[ ] arregloEnteros2 = {5, 12, 22, 3, 55, 8, 3, 10};
	Arreglo.imprime(arregloEnteros2);
	Arreglo.imprime(Arreglo.mergeSort(arregloEnteros2));
    }
}
