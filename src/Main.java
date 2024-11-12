
import java.util.Scanner;

public class Main {


    public static void main(String[] Args) {

        Scanner sc = new Scanner(System.in);
        //eingabe wird durch den scanner "wahrgenommen", dieser wird initialisiert

        System.out.println("Gebe eine Nachricht zum verschlüsseln ein:");
        String Nachricht = sc.nextLine();
        //user input (zu Verschlüsselende Zeichenkette)
        System.out.print("Gebe den Schlüssel ein:");
        int Schuessel = sc.nextInt();
        //Verschiebung durch CAESAR
        String GT = verschluesseln(Nachricht, Schuessel);

        System.out.println("verschlüsselte Nachricht: " + GT);
    }

    public static String verschluesseln(String Nachricht,int Schluessel)
    {
        StringBuilder GT = new StringBuilder();
//speichert die verschlüsselte Nachricht
        Nachricht = Nachricht.toLowerCase();
//Nachricht in Kleinbuchstaben

        for (int i = 0; i < Nachricht.length(); i++)
        //wir gehen durch die Zeichenkette
        {
            char b = Nachricht.charAt(i);
            //Extraktion des Zeichens an der aktuellen Position i der Zeichenkette
            if (Character.isLetter(b))
            //Überprüft, ob das aktuelle Zeichen ein Buchstabe ist(Optional
            {
                b = (char) ((((b - 'a') + Schluessel + 26) % 26) + 'a');
                //  Diese Zeile verschlüsselt den Buchstaben b durch Verschiebung
                //  seines ASCII-Wertes basierend auf dem angegebenen Schlüssel.
                //  Sie stellt sicher, dass das Ergebnis innerhalb des Alphabets bleibt,
                //  indem es modulo 26 gerechnet und anschließend wieder in einen Buchstaben konvertiert wird.
            }
            //Modulo erklärung/beispiel
            //Bei 10 % 3 ist das Ergebnis 1, da 10 durch 3 geteilt wird und
            // 3 genau 3-mal in 10 passt, wobei ein Rest von 1 bleibt.
            //  Bei 15 % 4 ist das Ergebnis 3, da 15 durch 4 geteilt wird und
            //  4 genau 3-mal in 15 passt, wobei ein Rest von 3 bleibt.
            //sorgt dafür das der rest genutzt wird, um wieder vorne anzufangen.

            GT.append(b);
            //Speichert die verschlüsselte Nachricht(Geheim Nachricht)
        }
        return GT.toString();

    }


}
