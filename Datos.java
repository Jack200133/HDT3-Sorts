public class Datos implements Comparable<Datos>{

    private Integer lastNumero;

    public Datos(Integer valor){
        lastNumero = valor;
    }

    public String toString(){

        return String.valueOf(lastNumero);
    }

    public int compareTo(Datos dato){
        Integer result;
        Integer otroDato = ((Datos)dato).getlastNumero();
        result=otroDato.compareTo(lastNumero);

        return result;
    }
    
    public Integer getlastNumero(){
        return lastNumero;
    }


}