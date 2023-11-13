import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class AnalisadorSDI {

    private int ip = 0;
    private Token a;
    private final List<Token> tokens;

    private Map<String, String[]> producciones = new HashMap<>();
    TablaAnalisisSintatico M =  new TablaAnalisisSintatico();
    Map<String, Map<String, String>> tabla = M.obtenerTablaAnalisis();

    // Ejemplo de cómo acceder a un valor en la tabla

    public AnalisadorSDI(List<Token> tokens){
        this.tokens = tokens;
        preanalisis = this.tokens.get(i);
            // Definir las producciones para la gramática de SQL
            producciones.put("Q", new String[]{"select D from T"});
            producciones.put("D", new String[]{"distinct P", "P"});
            producciones.put("P", new String[]{"*", "A"});
            producciones.put("A", new String[]{"A2 A1"});
            producciones.put("A1", new String[]{", A", ""});
            producciones.put("A2", new String[]{"id A3"});
            producciones.put("A3", new String[]{". id", ""});
            producciones.put("T", new String[]{"T2 T1"});
            producciones.put("T1", new String[]{", T", ""});
            producciones.put("T2", new String[]{"id T3"});
            producciones.put("T3", new String[]{"id", ""});

        }


    public boolean analizarEntrada() {
        //Definir Pila
        a=tokens.get(ip);
        Stack<String> pila = new Stack<>();
        pila.push("$");
        pila.push("Q");

        String X = pila.pop();

        while(!X.equals("$")){//La pila no esta vacia
            if(a.equals(X)){/*X.equals(tokens.get(i))   Si X es a*/
                ip++;
            }else if(a.equals(TipoToken)){//si a es un terminal
                return false; // Error de sintaxis
            }else if(tabla.get(X).get(a.getLexema()) == "ERROR"){

            }else if(producciones.containsKey(tabla.get(X).get(a.getLexema()))){

            }else{
                return false; // Error de sintaxis
            }
            X = pila.pop();
        }

        return true; // Éxito en el análisis sintáctico
    }

    /*public boolean esTerminal(String caracter){
        for (){
            if(caracter==){

            }
        }

        tokens.get()
    }*/


}
