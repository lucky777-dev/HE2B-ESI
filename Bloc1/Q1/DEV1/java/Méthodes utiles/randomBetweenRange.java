package dev1;
/**
 *
 * @author XDF
 */
public class randomBetweenRange {

    static int randomRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }
}
