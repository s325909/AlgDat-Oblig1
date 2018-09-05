import java.util.Arrays;

public class Oblig1 {

    public static void main(String[] args) {

        /*

        // Bestem lengden av arrayet vi skal lage
        int num_values = 7;

        // Lag random array med metode 1
        int values1[] = randomArray1(num_values);
        printArray(values1);

        maks(values1);

        //int[] test = {1,2,3,4,5};

        //antallUlikeSortert(values1);

        */

        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        rotasjon(abc);
    }

    //OPPGAVE 1

    /*
    Når blir det flest ombyttinger?
    - Når det største tallet er først i tabellen
    Når blir det færrest?
    - Når tabellen er i stigende rekkefølge
    Hvor mange blir det i gjennomsnitt?
    -
     */


    public static int maks(int[] a) {
        int max = a[0];


        for (int i = 0; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
                System.out.println(max);

                bubble(a);
                //bubble_srt(a);
            }
        }
        return max;
    }


    public static void bubble_srt(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            //System.out.println("i=" + i);
            bubble(a);
        }
    }

    public static int inversjoner = 0;

    public static void bubble(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] > a[i + 1]) {
                System.out.println("Inversjon i plass " + i + ", bytter om");
                int tmp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = tmp;
                System.out.println(Arrays.toString(a));

                inversjoner = inversjoner + 1;
            }
        }
    }




    /**
     * Funksjon som lager et array med tilfeldige tall mellom
     * 1 og num_values uten duplikater
     *
     * @param num_values Lengden på arrayet
     * @return Array med lengde num_values
     */
    public static int[] randomArray1(int num_values) {
        System.out.println("randomArray1 lager et array");
        int values[] = new int[num_values];
        int taken[] = new int[num_values];

        // Loop over arrayen og fyll med tall
        for (int i = 0; i < num_values; ++i) {
            //values[i] = i+1;
            int random_value = (int) (Math.random() * num_values + 1);
            if (taken[random_value - 1] == 1) {
                i = i - 1;
            } else {
                values[i] = random_value;
                taken[random_value - 1] = 1;
            }
        }

        return values;
    }


    /**
     * Funksjon som skriver ut et array til skjerm
     *
     * @param a Arrayet å skrive ut
     */
    public static void printArray(int[] a) {
        System.out.print("[");
        if (a.length > 0) {
            System.out.print(a[0]);
        }
        for (int i = 1; i < a.length; ++i) {
            System.out.print(", " + a[i]);
        }
        System.out.println("]");
    }

    /**
     * Oppgave 2
     */
    public static int antallUlikeSortert(int[] a) {

        bubble(a);

        System.out.println("hei på deg" + inversjoner);

        if (inversjoner == 0) {
            return 0;
        } else
            throw new IllegalStateException
                    ("Det finnes inversjoner => tabellen er ikke sortert stigende");
    }

    /**
     * Oppgave 3
     */
    public static int antallUlikeUsortert(int[] a) {
        if (a.length > 0) {

            return 0;

        } else {
            return 0;
        }
    }

    /**
     * Oppgave 5
     */

    public static void rotasjon(char[] a){

        char indx;

        for (int i = 0; i < a.length; ++i){
            indx = a[i];
            System.out.println(indx);

            /*
            for (i = 0; i < a.length - 1; ++i) {
                a[i] = a[i + 1];
                a[i + 1] = indx;
                System.out.println(Arrays.toString(a));

            }
            */

            for (i = 1; i < a.length - 1; i++) {
               a[i] = a[i-1];
               indx = a[0];
               System.out.println(indx);
               System.out.println(Arrays.toString(a));

            }

        }




    }






}
