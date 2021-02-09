import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Main{
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        int contador =0;
        Scanner scanner = new Scanner(System.in);
        //generar numero
        generarNumeros(numeros);
        //agregar los datos
        Datos[] data = new Datos[3000];
        for(int i=0;i<3000;i++){
            //String numCadena = String.valueOf(numeros.get(i));
            data[i] = new Datos (numeros.get(i));
        }
       
        //menu para escoger el tipo de sorting
        boolean terminar=true;
        do{
            
            int opcion_numero=0;
            //menu
            System.out.println("________________________");
            System.out.println("1. Gnome sort");
            System.out.println("2. Merge sort");
            System.out.println("3. Quick sort");
            System.out.println("4. Radix sort");
            System.out.println("5. Buble sort");
            System.out.println("6. Salir");
            //pedir el numero de opcion
            boolean ciclo_numero=true;
            do{
                try{
                    String opcion = scanner.next();
                    //verificar que sea una opcion adecuada
                    opcion_numero = Integer.parseInt(opcion);
                    if(opcion_numero>=1 && opcion_numero<=6){
                        ciclo_numero=false;
                    }else{
                        System.out.println("Porfavor escoja una de las opcioens que se presentan en el menu");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo_numero);
            System.out.println("________________________");
            //accion
            if(opcion_numero==1){
                Sorting.gnomeSort(data);
                for(Datos ordenado : data){
                    System.out.println(ordenado);
                    contador++;
                }
                System.out.println("Cantidad de datos: " + contador);
                contador=0;
                
            }else if(opcion_numero==2){
                Comparable[] ordenado = Sorting.mergeSort(data);
                for(Comparable orden : ordenado){
                    System.out.println(orden);
                    contador++;
                }
                System.out.println("Cantidad de datos: " + contador);
                contador=0;
                
            }else if(opcion_numero==3){
                Sorting.QuickSort(data,0, data.length-1);
                for(Datos ordenado : data){
                    System.out.println(ordenado);
                    contador++;
                }
                System.out.println("Cantidad de datos: " + contador);
                contador=0;
            }else if(opcion_numero==4){
              Sorting.radixSort(data, data.length);
              for(Datos ordenado : data){
                    System.out.println(ordenado);
                    contador++;
                }
                System.out.println("Cantidad de datos: " + contador);
                contador=0;
            }else if(opcion_numero==5){
              Sorting.bubbleSort(data);
              for(Datos ordenado : data){
                    System.out.println(ordenado);
                    contador++;
                }
                System.out.println("Cantidad de datos: " + contador);
                contador=0;

            }else if(opcion_numero==6){
                System.out.println("Gracias, espero que vuelvas pronto");
                terminar=false;
            }
            //generar nuevos numeros cada vez
            generarNumeros(numeros);
            //agregar los datos
            data = new Datos[3000];
            for(int i=0;i<3000;i++){
                //String numCadena = String.valueOf(numeros.get(i));
                data[i] = new Datos (numeros.get(i));
            }
        }while(terminar);
        scanner.close();

    }

    public static void generarNumeros(ArrayList<Integer> numeros){
        numeros.clear();
        try{
            Random rand = new Random();
            String ruta = "numero.txt";
            String contenido;
            StringBuilder builder = new StringBuilder();
            //generar 3000 datos aleatorios
            for(int i=0;i<3000;i++){
                boolean ciclo = true;
                int aleatorio = rand.nextInt(6000);
                do{
                    if(numeros.contains(aleatorio)){
                        aleatorio = rand.nextInt(6000);
                    }else{
                        numeros.add(aleatorio);
                        ciclo=false;
                    }
                }while(ciclo);               
            }
            
            //guardar los numeros en string
            for(Integer item : numeros){
                builder.append(item + " ");
            }
            contenido = builder.toString();

            //realizar la creacion del file y guardarlo en ella
            File file = new File(ruta);
            if(!file.exists()){
                file.createNewFile();
            }
            //escritura
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            //limpiar el contenido del txt
            bw.write(contenido);
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}