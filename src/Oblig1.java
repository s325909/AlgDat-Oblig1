import java.util.ArrayList;
import java.util.Arrays;

/**
 * Gruppemedlemmer:
 * Sondre Bitubekk - s321113
 * Jasotharan Cyril - s325909
 * Silje Bjoerknes - s320752
 */

public class Oblig1 {

    public static void main(String[] args) {

        /*

        // Bestem lengden av arrayet vi skal lage
        int num_values = 7;

        // Lag random array med metode 1
        int values1[] = randomArray1(num_values);
        printArray(values1);

        maks(values1);

        int[] sortert = {1,2,3,3,4,5,6,7,8,8,9,10};
        int[] usortert = {2,3,1,10,9,10,9,3,11,12};

        // Må fikse dette med inversjoner siden main metoden skal fjernes
        inversjoner = 0;
        System.out.println("Unike tall i sortert tabell " + antallUlikeSortert(sortert));
        System.out.println("Unike tall i usortert tabell " + antallUlikeUsortert(usortert));
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
     *
     * Antar at det menes at et enkelt tall i tabellen telles som et unikt tall
     * Ikke at det skal være 2 eller flere forskjellige tall
     */
    public static int antallUlikeSortert(int[] a) {

        bubble(a);

        if (inversjoner == 0) {
            return numDiffValues(a);
        } else
            throw new IllegalStateException
                    ("There are inversions, thus the array is not sorted ascending");
    }

    /**
     * Oppgave 3
     *
     * Uses bubble() method in order to sort the table in ascending order
     */
    public static int antallUlikeUsortert(int[] a) {
        if (a.length > 0) {
            for (int i = 0; i < a.length - 1; i++)
                bubble(a);
            return countUnique(a);
        } else {
            return 0;
        }
    }

//    Method obtain from this source:
//    https://stackoverflow.com/questions/32444193/count-different-values-in-array-in-java
//
//    Uses an arraylist and makes use of its many useful methods
//    in order to contain every unique number in the array
//    and further use its size to determine how many uniques numbers there are

    public static int numDiffValues(int[] a) {
        int numValues;
        ArrayList<Integer> diffNum = new ArrayList<>();

        for(int i = 0; i < a.length; i++){
            if(!diffNum.contains(a[i])){
                diffNum.add(a[i]);
            }
        }

        if(diffNum.size() > 0){
            numValues = diffNum.size();
        } else {
            numValues = 0;
        }

        return numValues;
    }

//    Method obtained from this source:
//    https://codereview.stackexchange.com/questions/114073/count-the-number-of-unique-elements-in-a-sorted-array
//
//    Requires that the array is sorted beforehand
//    Compares each pair of numbers to see whether they are similar
//    If they are different, increase the counter
//
//    Functions similarly to the method above, but without an assisting arraylist

    public static int countUnique(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Oppgave 5
     */

    public static void rotasjon(char[] a){

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; ++i){
            char tmp = a[i];
            //System.out.println(indx);

            a[i] = a[a.length - 1];
            a[a.length - 1] = tmp;

            System.out.println(Arrays.toString(a));


        }





    }






}
