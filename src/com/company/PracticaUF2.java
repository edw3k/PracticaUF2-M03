package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PracticaUF2 {

    public static void main(String[] args) {
        menu();
    }

    /**
     * Menú principal
     */
    public static void menu() {
        Scanner lector = new Scanner(System.in);
        int opcio;
        ArrayList<String> dades = new ArrayList<>();
        float[] dadesIMC = new float[4];
        do {
            System.out.println("**Benvingut/da a l'aplicació de Fitness\nIntrodueix el que vols fer");
            System.out.println("""
                1.Introduir dades
                2.Introduir dades IMC
                3.Càlcul IMC
                4.Composició corporal
                5.Tipus d'entrenament
                6.Mostrar planificació
                7.Sortir""");
            opcio = lector.nextInt();
            lector.nextLine();
            switch (opcio) {
                case 1 -> dades = dadesBasiques();
                case 2 -> dadesIMC = preguntarMassaCorporal();
                case 3 -> {
                    System.out.println("**Càlcul IMC**");
                    System.out.println("El teu IMC és: " + calcularMassaCorporal(dadesIMC));
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("**Composició corporal**");
                    System.out.println("La teva composició corporal és: " + resultatIMC(dadesIMC));
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("**Tipus d'entrenament");
                    tipusEntrenament();
                    System.out.println();
                }
                case 6 -> planningFinal(dades, dadesIMC);
            }
        } while (opcio != 7);
    }

    /** Pregunta les dades bàsiques
     *
     * @return dades ArrayList amb les dades bàsiques
     */
    public static ArrayList<String> dadesBasiques() {
        ArrayList<String> dades = new ArrayList<>();
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            System.out.println("*Informació bàsica*");
            System.out.println("Nom: ");
            dades.add(lector.nextLine());
            System.out.println("Primer cognom: ");
            dades.add(lector.nextLine());
            System.out.println("Segon cognom: ");
            dades.add(lector.nextLine());
            System.out.println("Introdueix el teu DNI: ");
            dades.add(lector.nextLine());
            System.out.println("Introdueix el teu correu electrònic: ");
            dades.add(lector.nextLine());
        }
        return dades;
    }

    /** Pregunta la massa corporal
     * @param // float[] dadesMassa
     * @return dadesIMC Array amb la massa corporal
     */
    public static float calcularMassaCorporal(float[] dadesMassa) {
        return dadesMassa[2] / (dadesMassa[3] * dadesMassa[3]);
    }

    /** Pregunta la massa corporal
     *
     * @return dadesIMC Array amb la massa corporal
     */
    public static float[] preguntarMassaCorporal() {
        Scanner lector = new Scanner(System.in);
        float[] dadesMassa = new float[4];
        dadesMassa[0] = controlErrors("Digues la teva edat", 0, 99);
        dadesMassa[1] = controlErrors("Digues el teu gènere - 1. Home | 2. Dona", 1, 2);
        dadesMassa[2] = controlErrors("Digues el teu pes: ", 0, 500);
        dadesMassa[3] = controlErrors("Digues la teva alçada: ", 0, 3);
        boolean invalidInput;
        do {
            try {
                System.out.println("Vols introduir de nou les teves dades ?(s/n)");
                String resposta = lector.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    invalidInput = true;
                    dadesMassa = preguntarMassaCorporal();
                } else if (resposta.equalsIgnoreCase("n")) {
                    invalidInput = false;
                } else {
                    System.out.println("Resposta no vàlida");
                    invalidInput = true;
                }
            } catch (Exception e) {
                System.out.println("Resposta no vàlida");
                invalidInput = true;
            }
        } while (invalidInput);

        return dadesMassa;
    }

    /** Calcula el resultat de l'IMC
     *
     * @param dadesMasa Array amb la massa corporal
     * @return resultatIMC String amb el resultat de l'IMC
     */
    public static String resultatIMC(float[] dadesMasa) {
        float imc = calcularMassaCorporal(dadesMasa);
        if (imc < 18.5) {
            return "Sota pes normal";
        } else if (imc >= 18.5 && imc < 25) {
            return "Pes normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepès";
        } else if (imc >= 30 && imc < 35) {
            return "Obesitat grau 1";
        } else if (imc >= 35 && imc < 40) {
            return "Obesitat grau 2";
        } else {
            return "Obesitat grau 3";
        }
    }

    /** Controla els errors de les dades introduïdes
     *
     * @param missatge String amb el missatge a mostrar
     * @param min Int. amb el valor mínim
     * @param max Int. amb el valor màxim
     * @return dades float amb la dada introduïda
     */
    public static float controlErrors(String missatge, float min, float max) {
        Scanner lector = new Scanner(System.in);
        float numero = 0;
        boolean error = true;
        do {
            try {
                System.out.println(missatge);
                numero = lector.nextFloat();
                if (numero >= min && numero <= max) {
                    error = false;
                } else {
                    System.out.println("Error, el número introduït no és vàlid");
                }
            } catch (Exception e) {
                System.out.println("Error, el número introduït no és vàlid");
                lector.nextLine();
            }
        } while (error);
        return numero;
    }

    /** Mostra el tipus d'entrenament
     *
     */
    public static int tipusEntrenament() {
        int entrenament = 0;
        Scanner lector = new Scanner(System.in);
        System.out.println("1. Entrenament de cames\n2. Entrenament de braços\n3. Entrenament abdominal");
        entrenament= lector.nextInt();
        lector.nextLine();
        return entrenament;
    }

    /** Retorna el tipus d'entrenament triat per l'usuari.
        * @param entrenament el número que indica el tipus d'entrenament triat per l'usuari
        * @return un número que correspon al tipus d'entrenament triat per l'usuari
     */

    public static int entrenamentEscollit(int entrenament) {
        if (entrenament == 1) {
            return 1;
        } else if (entrenament == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    /** Retorna el tipus d'entrenament indicat per l'usuari dependent de l'IMC i el tipus d0entrenament escollit.
        * @param imc de tipus float que indica el resultat de l'IMC
        * @return un número que correspon al tipus d'entrenament triat per l'usuari
     */
    public static String entrenamentPersonalitzat(float[] imc) {
        int a = 0;
        int entrenament = entrenamentEscollit(a);
        String entrenamentPersonalitzat = "";
        if (calcularMassaCorporal(imc) <= 16.00 || calcularMassaCorporal(imc) <= 24.99 && entrenament == 1) {
            entrenamentPersonalitzat = """
                    Planificació
                    Squats - 12 repeticions x 3
                    Extensions de cames - 12 repeticions x 3
                    Curls d'una cama - 6 repeticions/cama x 3""";
            //add entrenamentPersonalitzat to arraylist usuaris
            return entrenamentPersonalitzat;
        } else if (calcularMassaCorporal(imc) <= 16.00 || calcularMassaCorporal(imc) <= 24.99 && entrenament == 2) {
            System.out.println("Planificació");
            entrenamentPersonalitzat = """
                    Planificació
                    Flexions amb mancuernes (o sense) - 15 repeticions x 2
                    Fons de tríceps - 30 repeticions x 2
                    Voladors laterals - 15 repeticions x 2""";
            return entrenamentPersonalitzat;
        } else if (calcularMassaCorporal(imc) <= 16.00 || calcularMassaCorporal(imc) <= 24.99 && entrenament == 3) {
            System.out.println("Planificació");
            entrenamentPersonalitzat = """
                    Planificació
                    Flexions de tronc - 15 repeticions x 2
                    Flexions de tronc lateral - 15 repeticions x 2
                                """;
            return entrenamentPersonalitzat;
        }
//OBES
        if (calcularMassaCorporal(imc) <= 25.00 || calcularMassaCorporal(imc) <= 29.99 && entrenament == 1) {
            entrenamentPersonalitzat = """
                    Planificació
                    Sentadilles - 6 repeticions x 2
                    Extensions de cames - 6 repeticions x 2
                    Curls d'una cama - 3 repeticions/cama x 4""";
            return entrenamentPersonalitzat;
        } else if (calcularMassaCorporal(imc) <= 25.00 || calcularMassaCorporal(imc) <= 29.99 && entrenament == 2) {
            System.out.println("Planificació");
            entrenamentPersonalitzat = """
                    Planificació
                    Flexions amb mancuernes (o sense) - 20 repeticions x 2
                    Fons de tríceps - 10 repeticions x 2
                    Vols laterals - 5 repeticions x 4""";
            return entrenamentPersonalitzat;
        } else if (calcularMassaCorporal(imc) <= 25.00 || calcularMassaCorporal(imc) <= 29.99 && entrenament == 3) {
            entrenamentPersonalitzat = """
                    Planificació
                    Roda abdominal - 10 repeticions
                    Elevació de cames - 15 repeticions
                    Abdominal estàtic - 10 repeticions""";
            return entrenamentPersonalitzat;
        }
//SOBREPÈS
        if (calcularMassaCorporal(imc) <= 30.00 || calcularMassaCorporal(imc) <= 40.00 && entrenament == 1) {
            entrenamentPersonalitzat = """
                    Planificació
                    Sentadilles - 6 repeticions x 1
                    Extensions de cames - 6 repeticions x 1
                    Curls d'una cama - 3 repeticions/cama x 2""";
            return entrenamentPersonalitzat;
        } else if (calcularMassaCorporal(imc) <= 30.00 || calcularMassaCorporal(imc) <= 40.00 && entrenament == 2) {
            System.out.println("Planificació");
            entrenamentPersonalitzat = """
                    Planificació
                    Flexions amb mancuernes (o sense) - 10 repeticions x 2
                    Fons de tríceps - 5 repeticions x 2
                    Vols laterals - 5 repeticions x 2""";
            return entrenamentPersonalitzat;
        } else if (calcularMassaCorporal(imc) <= 30.00 || calcularMassaCorporal(imc) <= 40.00 && entrenament == 3) {
            entrenamentPersonalitzat = """
                    **Planificació
                    Roda abdominal - 5 repeticions
                    Elevació de cames - 10 repeticions
                    Abdominal estàtic - 5 repeticions""";
            return entrenamentPersonalitzat;
        }
        return entrenamentPersonalitzat;
    }


    /** Mostra el planning final
     *
     * @param dades ArrayList amb les dades bàsiques
     * @param dadesIMC Array amb la massa corporal
     */
    public static void planningFinal(ArrayList<String>dades, float[] dadesIMC){
        System.out.println("Nom: "+dades.get(0));
        System.out.println("Primer cognom: "+dades.get(1));
        System.out.println("Segon cognom: "+dades.get(2));
        System.out.println("DNI: "+dades.get(3));
        System.out.println("Mail: "+dades.get(4));

        System.out.println("IMC: " + calcularMassaCorporal(dadesIMC));
        System.out.println("Composició corporal: " + resultatIMC(dadesIMC));
        System.out.println(entrenamentPersonalitzat(dadesIMC));
        System.out.println();
    }
}

