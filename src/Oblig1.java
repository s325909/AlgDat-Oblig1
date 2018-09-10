import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Gruppemedlemmer:
 * Sondre Bitubekk - s321113
 * Jasotharan Cyril - s325909
 * Silje Bjoerknes - s320752
 */

public class Oblig1 {

    private Oblig1(){}
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
    public static int[] randomArray(int num_values) {
        System.out.println("randomArray2 lager et array");
        int values[] = new int[num_values];

        //Fyll arrayet med tallene 1 til 10
        for (int i=0; i<num_values; ++i) {
            values[i] = i+1;
        }

        //Loop gjennom arrayet, og bytt random
        for (int i=num_values-1; i > 0; --i) {
            // Trekk et tilfeldig tall mellom 0 og i
            int k = (int) (Math.random()*i);

            //bytt tallene k og i
            int temp = values[i];
            values[i] = values[k];
            values[k] = temp;
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

        inversjoner = 0;
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
     * Oppgave 4
     */

    public static void delsortering(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int element = a[i];
            int j = i - 1;
            if (a[i] / 2 % 2 == 0) {

                while (j >= 0 && a[j] > element) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = element;

            /*if(a[i] % 2 == 0){
                System.out.println(a[i]);
            }*/
            }
        }
    }


    /**
     * Oppgave 5
     */

    public static void rotasjon(char[] a){

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; ++i){
            char tmp = a[i];

            a[i] = a[a.length - 1];
            a[a.length - 1] = tmp;

            System.out.println(Arrays.toString(a));


        }
    }

    /**
     * Oppgave 6
     */

    public static void rotasjon(char[] a, int k){

        System.out.println(Arrays.toString(a));

        if (k > 0) {
            for (int j = 0; j < k; j++) {
                for (int i = 0; i < a.length; ++i) {
                    char tmp = a[i];
                    a[i] = a[a.length - 1];
                    a[a.length - 1] = tmp;

                    //System.out.println(Arrays.toString(a));

                }
            }
        } else {

            for (int j = 0; j > k; j--) {
                for (int i = a.length-1; i > 0; --i) {
                    char tmp = a[0];
                    a[0] = a[i];
                    a[i] = tmp;

                    //System.out.println(Arrays.toString(a));
                }
            }
        }
    }

    /**
     * Oppgave 7a
     *
     * Turns both parameter strings into arrays, and creates a new array
     * with the combined length of these two. This gives us control over
     * each letter, so we may merge them together by using their array index.
     */

    public static String flett(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] c = new char[a.length + b.length];
        int diff = a.length - b.length;

        // Temporary variables to control each array's index
        int i = 0, j = 0, l = 0;

        // Fills in each letter from the two provided arrays at
        // every other index of the new array.
        // This will only fill in letters until either array is depleted
        while (j < a.length && l < b.length) {
            c[i++] = a[j++];
            c[i++] = b[l++];
        }

        // The remaining letters of either array is then filled in
        // at the remaining slots in the new array
        while (i < c.length) {
            if (diff > 0) {
                c[i++] = a[j++];
            } else if (diff < 0) {
                c[i++] = b[l++];
            }
        }

        return String.valueOf(c);
    }

    /**
     * Oppgave 7b
     */
    public static String flett(String... s) {

        String tmp = "";
        String[] totalString = new String[s.length];

        System.out.println(s.length);

        for (int i = 0; i < s[i].length() - 1; i++) {
            System.out.println(s[i].length());
            System.out.println(i);
            for (int j = 0; j < s.length - 1; j++) {
                System.out.println(s[j].charAt(i));
                tmp += s[j].charAt(i);
                //System.out.println(j);
            }
        }

        return tmp;
    }


    /**
     * Oppgave 9
     */

    public static int[]tredjeMin(int[]  a){

        System.out.println(Arrays.toString(a));

        if (a.length < 3){
            throw new NoSuchElementException("Arrayet har for få elemnter");
        }

        int firstMin = a[0];
        int secondMin = a[1];
        int thirdMin = a[2];


        for (int i = 3; i < a.length; ++i){
            if (a[i] < firstMin){
                thirdMin = secondMin;
                secondMin = firstMin;
                firstMin = a[i];
            }
            else if (a[i] < secondMin){
                thirdMin = secondMin;
                secondMin = a[i];
            }
            else if (a[i] < thirdMin){
                thirdMin = a[i];
            }
        }

        System.out.println("first minimum is: " + firstMin);
        System.out.println("second minimum is: " + secondMin);
        System.out.println("third minimum is: " + thirdMin);

        int[] minArray = {firstMin, secondMin, thirdMin};
        System.out.println(Arrays.toString(minArray));

        return minArray;

    }

    public static void main(String[] args) {

        int[] a = randomArray(7);  // num_values må være minst 5!
        //int[] a = { 1, 8, 6, 7, 5, 4, 9};
        tredjeMin(a);

        /*
        String test = flett("AM ","L","GEDS","ORATKRR","R TRTE","IO","TGAUU");
        System.out.println(test);
        */

//        String a = flett("AB CGD", "D EF");
//        String b = flett("heidei", "jaja");
//        System.out.println(a + " " + b);

        /*

        // Bestem lengden av arrayet vi skal lage
        int num_values = 7;

        // Lag random array med metode 1
        int values1[] = randomArray(num_values);
        printArray(values1);

        maks(values1);

        int[] sortert = {1,2,3,3,4,5,6,7,8,8,9,10};
        int[] usortert = {2,3,1,10,9,10,9,3,11,12};

        System.out.println("Unike tall i sortert tabell " + antallUlikeSortert(sortert));
        System.out.println("Unike tall i usortert tabell " + antallUlikeUsortert(usortert));
        */

//        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
//
//        rotasjon(abc, 6);
//
//        System.out.println(Arrays.toString(abc));
//
//        String s = "abc";
//        char[] stest = s.toCharArray();
//        System.out.println(Arrays.toString(stest));

    }
}
