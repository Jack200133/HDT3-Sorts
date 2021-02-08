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

}