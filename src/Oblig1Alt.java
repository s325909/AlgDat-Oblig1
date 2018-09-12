import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Oblig1Alt {

    public static int maks(int[] a) {
        if (a.length == 0)
            throw new NoSuchElementException("Tabellen kan ikke vaere tom!");

        for (int i = 0; i < a.length-1; ++i) {
            if (a[i] > a[i+1]) {
                int tmp = a[i+1];
                a[i+1] = a[i];
                a[i] = tmp;
            }
        }

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        int byttinger = 0;

        for (int j = 0; j < a.length-1; ++j) {
            if (a[j] > a[j+1]) {
                int tmp = a[j+1];
                a[j+1] = a[j];
                a[j] = tmp;
                ++byttinger;
            }
        }

        return byttinger;
    }

    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0)
            return 0;

        for (int i = 0; i < a.length-1; ++i) {
            if (a[i] > a[i+1])
                throw new IllegalStateException("Tabellen er ikke stigende!");
        }

        int max = maks(a);
        boolean[] hjelper = new boolean[max+1];

        for (int i = 0; i < a.length; ++i) {
            hjelper[a[i]] = true;
        }

        int sum = 0;
        for (int i = 0; i < hjelper.length; ++i) {
            if (hjelper[i])
                ++sum;
        }

        return sum;
    }

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

    public static void delsortering(int[] a) {
        int posLeft = 0;
        int posRight = a.length-1;

        while(posLeft < posRight) {
            boolean isEven = a[posRight] < 0 ? (-1*a[posRight])%2==0 : a[posRight]%2==0;
            if (isEven) {
                --posRight;
            } else {
                int tmp = a[posLeft];
                a[posLeft] = a[posRight];
                a[posRight] = tmp;
            }

            boolean isOdd = a[posLeft] < 0 ? (-1*a[posLeft])%2==1 : a[posLeft]%2==1;
            if (isOdd) {
                ++posLeft;
            } else {
                int tmp = a[posLeft];
                a[posLeft] = a[posRight];
                a[posRight] = tmp;
            }
        }

        boolean kunOdde = false;
        for (int i = 0; i < a.length; ++i) {
            if (a[i]%2==0) {
                posLeft = i;
                posRight = i;
                break;
            } else if(i == a.length-1) {
                kunOdde = true;
            }
        }

        if (kunOdde) {
            posLeft = a.length;
            posRight = a.length;
        }

        for (int j = posRight; j < a.length; ++j) {
            for (int k = j+1; k < a.length; ++k) {
                if (a[j] > a[k]) {
                    int tmp = a[j];
                    a[j] = a[k];
                    a[k] = tmp;
                }
            }
        }

        for (int j = 0; j < posLeft; ++j) {
            for (int k = j+1; k < posLeft; ++k) {
                if (a[j] > a[k]) {
                    int tmp = a[j];
                    a[j] = a[k];
                    a[k] = tmp;
                }
            }
        }
    }

    public static void rotasjon(char[] a) {
        if (a.length > 1) {
            char siste = a[a.length - 1];
            for (int i = a.length - 2; i >= 0; --i) {
                a[i + 1] = a[i];
            }
            a[0] = siste;
        }
    }

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

    public static String flett(String s, String t) {
        String concat = "";

        int idxS = 0;
        int idxT = 0;
        boolean flip = true;
        while(idxS < s.length() && idxT < t.length()) {
            if (flip) {
                concat += s.charAt(idxS);
                ++idxS;
            } else {
                concat += t.charAt(idxT);
                ++idxT;
            }
            flip = !flip;
        }

        if (s.length() > idxS) {
            concat += s.substring(idxS);
        }
        if (t.length() > idxT) {
            concat += t.substring(idxT);
        }

        return concat;
    }

    public static String flett(String... s) {
        String concat = "";

        int maxLen = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i].length() > maxLen)
                maxLen = s[i].length();
        }

        int idx = 0;
        while(idx < maxLen) {
            for (int i = 0; i < s.length; ++i) {
                if (idx < s[i].length()) {
                    concat += s[i].charAt(idx);
                }
            }
            ++idx;
        }

        return concat;
    }

    public static int[] indekssortering(int[] a) {
        int[] index = new int[a.length];

        for (int i = 0; i < index.length; ++i) {
            index[i] = i;
        }

        for (int i = 0; i < index.length; ++i) {
            for (int j = 0; j < index.length; ++j) {
                if (a[index[i]] < a[index[j]]) {
                    int tmp = index[i];
                    index[i] = index[j];
                    index[j] = tmp;
                }
            }
        }

        return index;
    }

    public static int[] tredjeMin(int[] a) {
        if (a.length < 3)
            throw new java.util.NoSuchElementException("Tabellen maa vaere lengre enn tre!");

        int[] startIdx = indekssortering(new int[]{a[0], a[1], a[2]});

        int m = startIdx[0];
        int nm = startIdx[1];
        int tm = startIdx[2];

        int min = a[m];
        int nestemin = a[nm];
        int tredjemin = a[tm];

        for (int i = 3; i < a.length; ++i) {
            if (a[i] < tredjemin) {
                if (a[i] < nestemin) {
                    if (a[i] < min) {
                        tm = nm;
                        tredjemin = nestemin;

                        nm = m;
                        nestemin = min;

                        m = i;
                        min = a[m];
                    } else {
                        tm = nm;
                        tredjemin = nestemin;

                        nm = i;
                        nestemin = a[nm];
                    }
                } else {
                    tm = i;
                    tredjemin = a[tm];
                }
            }
        }

        return new int[] {m,nm,tm};
    }

    public static boolean inneholdt(String a, String b) {
        Map<String, Integer> charMapA = stringFreqMap(a);
        Map<String, Integer> charMapB = stringFreqMap(b);

        for (Map.Entry<String, Integer> eleA : charMapA.entrySet()) {
            if (charMapB.containsKey(eleA.getKey())) {
                if (charMapB.get(eleA.getKey()) >= eleA.getValue()) {
                    //Cool
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static Map<String, Integer> stringFreqMap(String a) {
        Map<String, Integer> charMap = new HashMap<>();

        for (int i = 0; i < a.length(); ++i) {
            String charStr = String.valueOf(a.charAt(i));
            if (charMap.containsKey(charStr)) {
                int newValue = charMap.get(charStr) + 1;
                charMap.put(charStr, newValue);
            } else {
                charMap.put(charStr, 1);
            }
        }

        return charMap;
    }
}
