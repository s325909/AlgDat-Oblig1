public class Oblig1 {

    public static void main(String[] args){
        // Bestem lengden av arrayet vi skal lage
        int num_values = 15;

        // Lag random array med metode 1
        int values1[] = randomArray1(num_values);
        printArray(values1);

        maks(values1);
    }


    public static int maks(int[] a){
        int max = a[0];

        for (int i = 0; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
                System.out.println(max);
            }
        }
        return max;
    }


    /**
     * Funksjon som lager et array med tilfeldige tall mellom
     * 1 og num_values uten duplikater
     * @param num_values Lengden på arrayet
     * @return Array med lengde num_values
     */
    public static int[] randomArray1(int num_values) {
        System.out.println("randomArray1 lager et array");
        int values[] = new int[num_values];
        int taken[] = new int[num_values];

        // Loop over arrayen og fyll med tall
        for (int i=0; i<num_values; ++i) {
            //values[i] = i+1;
            int random_value = (int) (Math.random()*num_values + 1);
            if (taken[random_value-1] == 1) {
                i = i-1;
            }
            else {
                values[i] = random_value;
                taken[random_value-1] = 1;
            }
        }

        return values;
    }


    /**
     * Funksjon som skriver ut et array til skjerm
     * @param a Arrayet å skrive ut
     */
    public static void printArray(int[] a) {
        System.out.print("[");
        if (a.length > 0) {
            System.out.print(a[0]);
        }
        for (int i=1; i<a.length; ++i) {
            System.out.print(", " + a[i]);
        }
        System.out.println("]");
    }

    /**
     * Oppgave 2
     */
    public static int antallUlikeSortert(int[] a) {
        return 0;
    }

    /**
     * Oppgave 3
     */
    public static int antallUlikeUsortert(int[] a) {
        if (a.length > 0) {



        } else {
            return 0;
        }
    }
}
