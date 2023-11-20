import java.util.HashMap;
import java.util.Map;

public class TablaAnalisisSintatico {

    public TablaAnalisisSintatico(){

    }

    public Map<String, Map<String, String>> obtenerTablaAnalisis() {
        Map<String, Map<String, String>> tabla = new HashMap<>();
        //  "Ɛ"   Simbolos de entrada       id   |   ,  |  select  |  dinstict  | from  |  *  |   .  |   $
        // Filas correspondientes a las producciones de la gramática(no terminales)
        tabla.put("Q", crearFila("ERROR", "ERROR", "1", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"));
        tabla.put("D", crearFila("2", "ERROR", "ERROR", "2", "ERROR", "2", "ERROR", "ERROR"));
        tabla.put("P", crearFila("3", "ERROR", "ERROR", "ERROR", "ERROR", "3", "ERROR", "ERROR"));
        tabla.put("A", crearFila("4", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"));
        tabla.put("A1", crearFila("ERROR", "5", "ERROR", "ERROR", "5", "ERROR", "ERROR", "ERROR"));
        tabla.put("A2", crearFila("6", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"));
        tabla.put("A3", crearFila("ERROR", "7", "ERROR", "ERROR", "7", "ERROR", "7", "ERROR"));
        tabla.put("T", crearFila("8", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"));
        tabla.put("T1", crearFila("ERROR", "9", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "9"));
        tabla.put("T2", crearFila("10", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"));
        tabla.put("T3", crearFila("11", "11", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "11"));

        return tabla;
    }

    private Map<String, String> crearFila(String... valores) {
        Map<String, String> fila = new HashMap<>();
        fila.put("id", valores[0]);
        fila.put(",", valores[1]);
        fila.put("select", valores[2]);
        fila.put("dinstict", valores[3]);
        fila.put("from", valores[4]);
        fila.put("*", valores[5]);
        fila.put(".", valores[6]);
        fila.put("$", valores[7]);
        return fila;
    }

}