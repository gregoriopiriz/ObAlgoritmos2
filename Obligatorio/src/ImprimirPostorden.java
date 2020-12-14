import java.util.ArrayList;

public class ImprimirPostorden {
    public int anterior = 0; 
    public ArrayList<String> resultadoPostorden = new ArrayList<String>();

    public void imprimirPost(char[] inorden, char[] preorden, int comienzo, int fin) 
    { 
        if (comienzo > fin) {
            return;         
        }
  
        int auxi = buscar(inorden, comienzo, fin, preorden[anterior++]); 
  
        imprimirPost(inorden, preorden, comienzo, auxi - 1); 
  
        imprimirPost(inorden, preorden, auxi + 1, fin); 
  
        char coso=inorden[auxi];
        String s=Character.toString(coso);
        resultadoPostorden.add(s);
        System.out.print(inorden[auxi] + " ");
    } 
  
    public int buscar(char[] inorden, int comienzo, int fin, int data) 
    { 
        int i = 0; 
        for (i = comienzo; i < fin; i++){
            if (inorden[i] == data) {
                return i;             
            } 
        }
        return i; 
    }
    
} 