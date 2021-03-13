/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td02;

/**
 * "Moment" app, written for the exercice dev2.td02 at HE2B-ESI school
 *
 * @author g56935
 */
public class MainMoment {

    public static void main(String[] args) {
        Moment moment1 = new Moment(2, 30, 10);
        Moment moment2 = new Moment(1, 10, 20);
        Moment moment3 = new Moment(3, 3, 3);
        System.out.println(moment1);
        System.out.println(moment2);
        System.out.println(moment3);
        System.out.println("moment1 = " + moment1.getHour() + "h, " + moment1.getMinute() + "m, " + moment1.getSecond() + "s");
        System.out.println("moment2 = " + moment2.getHour() + "h, " + moment2.getMinute() + "m, " + moment2.getSecond() + "s");
        System.out.println("moment3 = " + moment3.getHour() + "h, " + moment3.getMinute() + "m, " + moment3.getSecond() + "s");
        System.out.println("-------------------------------");
        Moment moment4 = new Moment(8, 15, 0);
        Moment moment5 = new Moment(8, 15, 0);
        Moment moment6 = moment4;
        Moment moment7 = new Moment(10, 15, 0);
        System.out.println(moment4+"=="+moment5+" : " + (moment4==moment5));
        System.out.println(moment4+"=="+moment6+" : " + (moment4==moment6));
        System.out.println(moment4+"=="+moment7+" : " + (moment4==moment7));
        System.out.println(moment4+"equals"+moment5+" : " + moment4.equals(moment5));
        System.out.println(moment4+"equals"+moment6+" : " + moment4.equals(moment6));
        System.out.println(moment4+"equals"+moment7+" : " + moment4.equals(moment7));
        System.out.println("-------------------------------");
        Moment moment8 = new Moment();
        System.out.println(moment8+" = "+moment8.toSeconds()+" seconds");
        System.out.println(moment1+" = "+moment1.toSeconds()+" seconds");
        System.out.println(moment3+" = "+moment3.toSeconds()+" seconds");
        System.out.println(moment1+" compareTo "+moment3+" = "+moment1.compareTo(moment3)+" seconds");
        System.out.println(moment3+" compareTo "+moment1+" = "+moment3.compareTo(moment1)+" seconds");
    }
}