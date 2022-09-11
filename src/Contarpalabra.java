import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Contarpalabra {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Falta el nombre de archivo");
            System.exit(0);
        }
        FileReader fi = null;
        try {
            fi = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
        BufferedReader inputFile = new BufferedReader(fi);
        String texto = null;
        int numberCount = 0;
        ArrayList<String> list = new ArrayList<String>();
        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";

        try {
            System.out.println("Ingresa la palabra a buscar en el archivo");
            Scanner sc = new Scanner(System.in);
            String palabra=sc.nextLine();
            while ((texto = inputFile.readLine()) != null) {
                if (texto.trim().length() == 0) {
                    continue; // la linea esta vacia, continuar
                }
                String words[] = texto.split( delimiters );
                list.addAll(Arrays.stream(words).toList());
                for(String w : list){
                    if(w.toLowerCase().equals(palabra)){
                        numberCount++;

                }
                }list.clear();

            }
            System.out.println("El número de veces en las que la palabra : "+palabra+" se repite en el archivo: "+args[0]+" es de: "+numberCount);
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}