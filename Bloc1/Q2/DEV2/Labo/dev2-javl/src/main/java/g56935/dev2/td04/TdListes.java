/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td04;

import java.util.ArrayList;
import g56935.dev2.td02.Moment;
import java.util.List;

/**
 *
 * @author g56935
 */
public class TdListes {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(42);
        System.out.println(myList);
        System.out.println("Sum = " + sum(myList));
        myList.add(54);
        System.out.println(myList);
        System.out.println("Sum = " + sum(myList));
        myList.set(1, 44);
        System.out.println(myList);
        System.out.println("Sum = " + sum(myList));
        myList.add(1, 43);
        System.out.println(myList);
        System.out.println("Sum = " + sum(myList));
        myList.remove(myList.size() - 1);
        System.out.println(myList);
        System.out.println("Sum = " + sum(myList));
        myList.remove(0);
        System.out.println(myList);
        System.out.println("Sum = " + sum(myList));
        myList.clear();
        System.out.println(myList);
        System.out.println("Sum = " + sum(myList));
        exercice12();
    }
    
    /* EXERCICE 9 
    i=i+1 vaut i+1
    i+=1  vaut i+1
    i++   vaut i <----------- CELLE-CI !
    ++i   vaut i+1
    */
    
    /* EXERCICE 10
    int i;
    System.out.println(List.of(i=42, i++, --i));
    Ceci affichera "[42, 42, 42]"
    */
    
    /* EXERCICE 11
    1. Le tableau sera {1, 2, 3, 4, 5}
    2. Le tableau sera {0, 1, 2, 3, 4}
    3. Error IndexOutOfBoundsException car tab[5] n'existe pas
    4. Le tableau sera {1, 2, 3, 4, 5}
    */
    
    public static void exercice12() {
        int nbLignes = 3;
        int nbCols = 5;
        boolean stop = false;
        int lg = 0, col = 0;
        while(!stop) {
            System.out.printf("[%d %d]\n", lg, col);
            stop = !(++col < nbCols) && !(++lg < nbLignes); // <---- IL FALLAIT CHANGER col++ PAR ++col sinon il y avait une boucle infinie
            col %= nbCols;
        }
    }
    
    /**
     * Calculates the sum of the integers of a List of integers
     *
     * @return an integer with the sum of all the integers of the List
     */
    public static int sum(ArrayList<Integer> list) {
        int result = 0;
        for (int nb : list) {
            result += nb;
        }
        return result;
    }

    /**
     * Adds the an Array of integers in another Array of integers
     *
     * @param list1 the Array of integers where we want to add the elements
     * @param list2 the Array of integers we want to add to List1
     */
    public static void concatenation(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        for (int nb : list2) {
            list1.add(nb);
        }
    }

    /**
     * Removes both extremes of an Array of integers (deletes the minmum and the
     * maximum)
     *
     * Throws an error if the list is null
     *
     * @param list the Array of integers where we want to delete the extremes
     */
    public static void delExtremes(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("<error> The list is null in [delExtremes] method !");
        }
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(minIndex)) {
                minIndex = i;
            }
            if (list.get(i) > list.get(maxIndex)) {
                maxIndex = i;
            }
        }
        list.remove(minIndex);
        if (minIndex != maxIndex) {
            list.remove(maxIndex);
        }
    }

    /**
     * Removes the duplicates elements of an ArrayList of integers and returns a
     * new ArrayList of integers with unique elements
     *
     * @param list the ArrayList of integers where we want to remove the
     * duplicated elements
     * @return an ArrayList of integers with unique elemnts of list
     */
    public static ArrayList<Integer> delDuplicatesNewList(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean add = true;
        for (int i = 0; i < list.size(); i++) {
            add = true;
            for (int j = 0; j < result.size(); j++) {
                if (list.get(i) == result.get(j)) {
                    add = false;
                }
            }
            if (add) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    /**
     * Removes the duplicates elements of an ArrayList of integers
     *
     * @param list the ArrayList of integers where we want to remove the
     * duplicated elements
     */
    public static void delDuplicates(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i) == list.get(j)) {
                    list.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Merges two sorted ArrayLists of integers in a new sorted ArrayList of
     * integers
     *
     * @param list1 the first sorted ArrayList of integers to merge
     * @param list2 the second sorted ArrayList of integers to merge
     * @return a new sorted ArrayList of integers with list1 and list2 merged
     */
    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.size() || index2 < list2.size()) {
            if (index1 < list1.size() && index2 < list2.size()) {
                if (list1.get(index1) <= list2.get(index2)) {
                    result.add(list1.get(index1));
                    index1++;
                } else {
                    result.add(list2.get(index2));
                    index2++;
                }
            } else if (index1 < list1.size()) {
                result.add(list1.get(index1));
                index1++;
            } else if (index2 < list2.size()) {
                result.add(list2.get(index2));
                index2++;
            }
        }
        return result;
    }

    /**
     * Gives the earlier Moment of an ArrayList of Moments
     *
     * @param moments an ArrayList of Moments
     * @return the earlier Moment of the ArrayList of Moments
     */
    public static Moment earlier(ArrayList<Moment> moments) {
        Moment result = moments.get(0);
        for (int i = 1; i < moments.size(); i++) {
            if (result.getHour() > moments.get(i).getHour()
                    || (result.getHour() == moments.get(i).getHour() && result.getMinute() > moments.get(i).getMinute())
                    || (result.getHour() == moments.get(i).getHour() && result.getMinute() == moments.get(i).getMinute() && result.getSecond() > moments.get(i).getSecond())) {
                result = moments.get(i);
            }
        }
        return result;
    }
}