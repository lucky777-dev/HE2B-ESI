package dev1;

import java.util.Arrays;

/**
 *
 * @author XDF
 */
public class reverserTab {

    static void renverserTableau(char[] tab) {
        System.out.println("before: " + Arrays.toString(tab));
        for (int i = 0; i < tab.length / 2; i++) {
            char temp = tab[i];
            tab[i] = tab[tab.length - i - 1];
            tab[tab.length - i - 1] = temp;
        }
        System.out.println("after: " + Arrays.toString(tab));
    }
}
