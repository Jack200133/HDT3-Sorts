//solo seria meter este dato dentro del sorting diria yo, ahi seria que cambies unas cosas para que use el compareTo
//las que puse ahi de los dos metodos no son los correctos, digamos si ordena y todo pero la escrutura no es de la que puse asi que tendre que investigar para ver como exactamente hacen sorts los dos q puse.

class bubble 
{ 
    void Bubble(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    }
} 