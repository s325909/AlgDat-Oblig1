import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Gruppemedlemmer:
 * Sondre Bitubekk - s321113
 * Jasotharan Cyril - s325909
 * Silje Bjoerknes - s320752
 */

public class Oblig1 {

    private Oblig1(){}

    /**
     * Oppgave 1
     *
     * Når er det flest ombyttinger?
     * - Når det stoerste tallet er foerst i tabellen
     *
     * Når blir det faerrest ombyttinger?
     * - Når tabellen er i stigende rekkefoelge
     *
     * Hvor mange blir det i gjennomsnitt?
     * -
     */

    // Runs the bubble method, which will sort the values of the array in ascending order.
    // Thus the highest index will contain the largest number.
    public static int maks(int[] a) {
        if (a.length == 0)
            throw new NoSuchElementException("Array cannot be empty!");

        bubble(a);
        return a[a.length-1];
    }

    // Runs the bubble method which counts the number of times two values are being switched
    public static int ombyttinger(int[] a) {
        bubble(a);
        return inversjoner;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall
        for (int i = 0; i < n; i++)
            a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k

            int temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }

        return a;                        // permutasjonen returneres
    }

    /**
     * Oppgave 2
     *
     * Calls the ombyttiner() method first, which will return the number of times values are being switched.
     * If this number equals 0, run another method which adds each unique value in the array
     * into a new ArrayList. The size of the ArrayList equals the number of unique values.
     */
    public static int antallUlikeSortert(int[] a) {
        if (ombyttinger(a) == 0) {
            return numDiffValues(a);
        } else
            throw new IllegalStateException
                    ("There are inversions, thus the array is not sorted ascending");

        // Can also use method countUnique(), as long as the array is sorted, which it is
        // when bubble(a) is called.

        // Another way to solve this task is to use a temporary boolean table which has the length
        // equal to the largest number in array 'a'. Then you use each value of array 'a' as index
        // in the boolean table and set each of these to true. As such, only unique values are counted.
        // Finally you can iterate through each index of the boolean table and count each 'true' value.
    }

    /**
     * Oppgave 3
     *
     * Method gradually goes through each index in a.
     * As each index i is selected, its value is compared to all the values of index j in a descending order.
     *
     * I.e. a[2] is compared to a[1] and a[0]. If a[i] equals a[j], the boolean is set to true
     * and 'sum' is not increased.
     */
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0)
            return 0;

        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            boolean alleredeTelt = false;
            for (int j = i-1; j >= 0; --j) {
                if (a[i] == a[j]) {
                    alleredeTelt = true;
                }
            }

            if (!alleredeTelt)
                ++sum;
        }

        return sum;
    }

    /**
     * Oppgave 4
     */

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static void delsortering(int[] a, int v, int h, int skilleverdi) {


            for (int i = 0; i < a.length; i++) {

                while (true){
                    while (v/2 % 2 == 0 && a[v]<skilleverdi ){
                        v++;
                    } ;
                    while (h/2 % 2 != 0 && a[h]>=skilleverdi){
                        h--;
                    }
                }

            /*int element = a[i];
            int j = i - 1;
            if (a[i] / 2 % 2 == 0) {

                while (j >= 0 && a[j] > element) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = element;*/

            /*if(a[i] % 2 == 0){
                System.out.println(a[i]);
            }*/
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

    public static void rotasjon(char[] a, int k) {
        if (a.length > 1) {
            char[] tmp = new char[a.length];
            if (k >= 0) {
                for (int i = 0; i < a.length; ++i) {
                    tmp[(i+k)%a.length] = a[i];
                }
                for (int i = 0; i < a.length; ++i) {
                    a[i] = tmp[i];
                }
            } else {
                for (int i = a.length-1; i >= 0; --i) {
                    tmp[(((a.length - 1) - i) - k)%a.length] = a[i];
                }
                for (int i = 0; i < a.length; ++i) {
                    a[i] = tmp[(a.length - 1) - i];
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
     *
     *
     */
    public static String flett(String... s) {

        String tmp = "";
        int maxLen = 0;

        for (int i = 0; i < s.length; ++i) {
            if (s[i].length() > maxLen)
                maxLen = s[i].length();
        }

        int idx = 0;
        while(idx < maxLen) {
            for (int i = 0; i < s.length; ++i) {
                if (idx < s[i].length()) {
                    tmp += s[i].charAt(idx);
                }
            }
            ++idx;
        }

        return tmp;
    }

    /**
     * Oppgave 8
     */
    public static int[] indekssortering(int[] a) {

        return a;
    }

    /**
     * Oppgave 9
     */

    public static int[] tredjeMin(int[] a){

        System.out.println(Arrays.toString(a));

        if (a.length < 3){
            throw new NoSuchElementException("Arrayet har for få elemnter");
        }

        int startIndx[] = indekssortering(new int[]{a[0], a[1], a[2]});

        int m = startIndx[0];
        int nm = startIndx[1];
        int tm = startIndx[2];

        int min = a[m];
        int nestemin = a[nm];
        int tredjemin = a[tm];

        for (int i = 3; i < a.length; ++i){
            if (a[i] < min){
                tredjemin = nestemin;
                tm = nm;

                nestemin = min;
                nm = m;

                min = a[i];
                m = i;
            }
            else if (a[i] < nestemin){
                tredjemin = nestemin;
                tm = nm;

                nestemin = a[i];
                nm = i;
            }
            else if (a[i] < tredjemin){
                tredjemin = a[i];
                tm = i;
            }
        }

        System.out.println("minste verdi: " + min);
        System.out.println("nest minste verdi: " + nestemin);
        System.out.println("tredje minste verdi: " + tredjemin);

        int[] minArray = {min, nestemin, tredjemin};
        System.out.println(Arrays.toString(minArray));

        //return minArray;
        return new int[] {m,nm,tm};
    }

    /**
     * Oppgave 10
     */

    public  static boolean inneholdt(String  a,  String  b) {

        if (a.length() ==  0 || b.length() == 0) {
            throw new IllegalArgumentException("Strings of length 0 are illegal");
        }


        String string = a + b;
        String s = string.toUpperCase();
        System.out.println(s);

        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));

        // Create a new StringBuilder.
        StringBuilder builder = new StringBuilder();

        // Loop and append values.
        for (int i = 0; i < 5; i++) {
            builder.append(string);
        }
        // Convert to string.
        String result = builder.toString();

        // Print result.
        System.out.println(result);


        return true;
    }




    ///// Hjelpemetoder /////////////////////////////////////////

    public static int inversjoner = 0;

    // Method for sort an array a, via bubble-sorting.
    // Compares two pairs of values, and moves the largest number to the right.
    public static void bubble(int[] a) {
        inversjoner = 0;

        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] > a[i + 1]) {
                int tmp = a[i+1];
                a[i+1] = a[i];
                a[i] = tmp;
                ++inversjoner;
            }
        }
    }

//    Method obtain from this source:
//    https://stackoverflow.com/questions/32444193/count-different-values-in-array-in-java
//
//    Creates an ArrayList and adds each unique value in array 'a' into it.
//    The size of the ArrayList will then equal the number of unique values.
//
//    This method doesn't require the array to be sorted, but it obviously uses an ArrayList as help

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

    public static void main(String[] args) {


        int[] a = randomArray(3);
        //int[] a = { 1, 8, 6, 7, 5, 4, 9};

        char[] b = {'A', 'B','C', 'D', 'E'};
        Oblig1Alt.rotasjon(b, -2);
        //tredjeMin(a);
        inneholdt("AaA", "BBb");

//        int[] a = randomArray(9);
//        //int[] a = { 1, 8, 6, 7, 5, 4, 9};
//        tredjeMin(a);

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
