public class Sorting {

    //sort para tipo Gnome
    public static void gnomeSort(Comparable[] list){
        int i=1;
        int j=2;
        Comparable tmp;
        
        while(i<list.length){
            if(list[i-1].compareTo(list[i])>0){
                tmp = list[i-1];
                list[i-1] =list[i];
                list[i--] = tmp;
                i = (i==0) ? j++:i;
            }else{
                 i = j; j++;
            }
        }
    }

    //sort para tipo Merge
    public static  Comparable[] mergeSort(Comparable[] list) {
        if(list.length<=1){
            return list;
        }
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second); 
        merge(first, second, list);

        return list;
        
    }

    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.length && iSecond < second.length) 
        {
            if (first[iFirst].compareTo(second[iSecond]) > 0) 
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            } 
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
  }

  public static void bubbleSort(Comparable[] list) 
      { 
        int n = list.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (list[j].compareTo(list[j+1]) < 0 )  
                { 
                    // cambia arr[j+1] con arr[j] 
                    Comparable temp = list[j]; 
                    list[j] = list[j+1]; 
                    list[j+1] = temp; 
                } 
    }


	//Una función de utilidad para obtener el valor máximo en arr[] 
	private static int getMax(Comparable[] list, int n) 
	{ 
		int mx = arr[0]; 
		for (int i = 1; i < n; i++) 
			if (arr[i] > mx) 
				mx = arr[i]; 
		return mx; 
	} 

	// Una función para hacer el conteo de arr[] según 
	// el dígito representado por exp. 
	private static void countSort(Comparable[] list, int n, int exp) 
	{ 
		int output[] = new int[n]; // output array 
		int i; 
		int count[] = new int[10]; 
		Arrays.fill(count, 0); 

		// Almacenar el recuento de ocurrencias
		for (i = 0; i < n; i++) 
			count[(list[i] / exp) % 10]++; 

		// Cambiar count[i] para que count[i] contenga ahora 
		// posición real de este dígito en output[] 
		for (i = 1; i < 10; i++) 
			count[i] += count[i - 1]; 

	
		for (i = n - 1; i >= 0; i--) { 
			output[count[(list[i] / exp) % 10] - 1] = arr[i]; 
			count[(list[i] / exp) % 10]--; 
		} 

		//Copiar la matriz de salida a arr[], de modo que arr[] ahora 
		// contenga los números ordenados según el dígito actual 
		for (i = 0; i < n; i++) 
			list[i] = output[i]; 
	} 

	// La función principal que ordena arr[] de tamaño n utilizando 
	// Ordenación Radix 
	public static void radixSort(Comparable[] list, int n) 
	{ 
		// Encontrar el número máximo para conocer el número de dígitos 
		int m = getMax(list, n); 

		for (int exp = 1; m / exp > 0; exp *= 10) 
			countSort(list, n, exp); 
	} 


}