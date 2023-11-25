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
        //preanalisis = this.tokens.get(i);
            // Definir las producciones para la gramática de SQL
            producciones.put("Q", new String[]{"select D from T"});
            producciones.put("D", new String[]{"distinct  P", "P"});
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

        Stack<String> pila = new Stack<>();
        pila.push("$");
        pila.push("Q");
        String X = pila.pop();

        int flag;
        String var_a="";
        String[] produccion_correcta;
        while(!X.equals("$")){//La pila no esta vacia
            flag=0;
            a=tokens.get(ip);
            var_a=a.getLexema();
            System.out.println("X:"+X+" a:"+a.getLexema());
            if(this.esID(a.getLexema())){
                var_a="id";
            }

            if(X.equals(var_a)){/*X.equals(tokens.get(i))   Si X es a*/
                //System.out.println(X+"="+a.getLexema());
                ip++;
            }else if(X.equals("")){//X es epsilon

            }else if(this.EsTerminal(X)){//X es un terminal
                System.out.println("ERROR1");
                return false; // Error de sintaxis
            }else if((tabla.get(X).get(var_a)).equals("ERROR")){//M[x,a] es error
                System.out.println("ERROR2");
                return false; // Error de sintaxis
            }else if(!tabla.get(X).get(var_a).equals("ERROR")){//M[x,a] = X -> Y1Y2...Yk
                produccion_correcta=producciones.get(X)[0].split(" ");
                if(producciones.get(X).length > 1 /*&& !X.equals(a.getLexema())*/){
                    if(produccion_correcta[0].equals(var_a)){
                        flag=0;
                    }else {
                        flag=1;
                    }
                }else{
                    flag=0;
                }
                String[] nuevo_elem=producciones.get(X)[flag].split(" ");
                System.out.println("Salida: "+X+"->"+producciones.get(X)[flag]);
                for(int i=0; i < nuevo_elem.length; i++){
                    //System.out.println(nuevo_elem[nuevo_elem.length-i-1]);
                    pila.push(nuevo_elem[nuevo_elem.length-i-1]);
                }
            }
            X = pila.pop();
        }

        return true; // Éxito en el análisis sintáctico
    }

    public boolean EsTerminal(String elem){

        /*Scanner scanner = new Scanner(source);//Detecta los no terminales como id
        List<Token> tokens = scanner.scanTokens();*/
        String[] palabras_reservadas = {"Q", "D", "P", "A", "A1", "A2", "A3", "T", "T1", "T2", "T3"};

        for(int i=0;i<palabras_reservadas.length;i++){
            if(elem.equals(palabras_reservadas[i])){
                return false;
            }
        }
        return true;
    }

    public boolean esID(String elem){

        /*Scanner scanner = new Scanner(source);//Detecta los no terminales como id
        List<Token> tokens = scanner.scanTokens();*/
        String[] palabras_reservadas = {"select", "from", ",", "distinct", "*", "$", "."};

        for(int i=0;i<palabras_reservadas.length;i++){
            if(elem.equals(palabras_reservadas[i])){
                return false;
            }
        }
        return true;
    }

}
