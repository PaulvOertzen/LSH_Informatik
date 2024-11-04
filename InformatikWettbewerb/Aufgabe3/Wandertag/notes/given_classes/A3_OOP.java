import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/** 
 * @author: Benjamin Sauerstein
 * Date:    13.09.2024
 * Fuer die 3. Aufgabe des 43. Bundeswettbewerbs Informatik
 */

public class A3_OOP{    
    int s;
    int wege[][];
    public A3_OOP(){
        // Die beiden untere Zeile verwenden, um einen Pfad zur Datei anzugeben.
        // SimpleInput input = new SimpleInput();
        // String datei = input.getString("Bitte Dateipfad für Loesung eingeben!");
        // oder die Datei im Projektordner speichern, dann reicht die Angabe des Dateinamens:
        String datei = "wandern1.txt";
        File file = new File(datei);
        if (!file.canRead() || !file.isFile()){
            System.exit(0);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(datei));
            s = Integer.parseInt(in.readLine()); //Reads Number of Datasets
            wege = new int[s][2];
            for (int i=0; i<s; i++){  
                String zeile = in.readLine();
                String l[] = zeile.split(" ");
                wege[i][0] = Integer.parseInt(l[0]);
                wege[i][1] = Integer.parseInt(l[1]);
            }
            aufgabeLoesen();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {}
        } 
    }

    //ab hier kann die Aufgabe inhaltlich bearbeitet werden 
    public void aufgabeLoesen(){
        System.out.println("Die erste Person geht minimal " + wege[0][0] + " Kilometer und maximal " + wege[0][1] + " Kilometer");
    }
}