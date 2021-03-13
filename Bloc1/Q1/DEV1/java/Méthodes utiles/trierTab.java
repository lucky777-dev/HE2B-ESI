package dev1;

/**
 *
 * @author XDF
 */
public class trierTab {

    static void triBulle(int[] tab) {
        for (int i = 0; i < tab.length-1; i++) {
            for (int j = 0; j < tab.length-i-1; j++) {
                if (tab[j] > tab[j + 1]) {
                    swap(tab, j, j + 1);
                }
            }
        }
    }

    static void triInsertion(int[] tab) {
        for (int nbTriés = 1; nbTriés < tab.length; nbTriés++) {
            int valeurAInserer = tab[nbTriés];
            int pos = nbTriés - 1;
            while (pos >= 0 && tab[pos] > valeurAInserer) {
                tab[pos + 1] = tab[pos];
                pos--;
            }
            tab[pos + 1] = valeurAInserer;
        }
    }

    static void triSelection(int[] tab) {
        for (int nbTriés = 0; nbTriés < tab.length - 1; nbTriés++) {
            int posMin = indiceDuMinimum(tab, nbTriés);
            swap(tab, nbTriés, posMin);
        }
    }

    static int indiceDuMinimum(int[] tab, int posDépart) {
        int posMin = posDépart;
        for (int pos = posDépart + 1; pos < tab.length; pos++) {
            if (tab[pos] < tab[posMin]) {
                posMin = pos;
            }
        }
        return posMin;
    }

    static void swap(int[] tab, int pos1, int pos2) {
        if (pos1 != pos2) {
            int temp = tab[pos1];
            tab[pos1] = tab[pos2];
            tab[pos2] = temp;
        }
    }
}
