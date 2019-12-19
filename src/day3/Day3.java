package day3;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {

        String path1 = "R995,U671,R852,U741,R347,U539,R324,U865,R839,U885,R924,D983,R865,D823,R457,U124,R807,U941,R900,U718,R896,D795,R714,D129,R465,U470,L625,U200,L707,U552,L447,D305,L351,D571,L346,D38,L609,U581,L98,D707,R535,D332,L23,D630,L66,U833,L699,D445,L981,D81,L627,U273,R226,D51,L177,D806,R459,D950,R627,U462,L382,D847,R335,D573,L902,D581,L375,D288,R26,U922,R710,D159,R481,U907,L852,U926,L905,D140,L581,U908,R158,D955,R349,U708,R196,D13,R628,D862,L899,U50,L56,D89,L506,U65,R664,D243,L701,D887,L552,U665,L674,U813,L433,U87,R951,D970,R914,D705,R79,U328,L107,D86,L307,U550,L872,U224,L595,D600,R442,D426,L139,U528,R680,U35,L951,D275,L78,U113,L509,U821,R150,U668,L981,U102,L632,D864,R636,D597,R385,U322,R464,U249,L286,D138,L993,U329,R874,D849,R6,D632,L751,U235,R817,D495,L152,D528,R872,D91,R973,D399,L14,D544,R20,U54,L793,U90,L756,D36,R668,D221,L286,D681,L901,U312,R290,D874,L155,U863,R35,D177,R900,D865,R250,D810,L448,D648,L358,U308,R986,D562,L112,D858,R77,D880,L12,U702,L987,D662,R771,U6,R643,U845,R54,U987,L994,D878,L934,U805,L85,D760,L775,D578,L557,U544,L522,U495,L678,D68,R615,U700,L415,U597,L964,D858,R504,U805,L392,U140,L721,D215,L842,U929,L30,U64,L748,D136,R274,D605,R863,U460,L354,U78,R705,D298,L456,U117,R308,D186,L707,D367,R824,U965,L162,D19,R950,D582,R911,D436,L165,U506,L186,D906,L69,U412,R810,U13,L350,U314,R192,U963,L143,D937,L685,D574,R434,D937,L365,U646,L741,U703,L66,U959,L103,U799,L480,U340,R981,U96,L675,U662,R536,U15,R171,U382,R396,D431,L922,D662,R365,D921,R915";
        String path2 = "L999,D290,L462,D773,L687,D706,L785,D219,R102,U307,L466,D166,R11,D712,L675,D844,R834,U665,R18,D91,R576,U187,L832,D969,L856,U389,R275,D587,L153,U329,R833,U762,R487,U607,R232,D361,R301,D738,L121,D896,R729,D767,R596,U996,R856,D849,R748,D506,L949,U166,R194,D737,L946,D504,L908,D980,L249,U885,R930,D910,R860,D647,L985,U688,L695,U207,L182,D444,R809,D394,R441,U664,L721,U31,R690,U597,R694,U942,R878,U320,R874,U162,L840,U575,L602,U649,L337,D775,L316,D588,R603,D175,L299,D538,R117,U213,L542,D429,R969,D641,R946,D373,L406,D119,R58,D686,R460,U906,L303,D13,L209,D546,R33,D545,R806,U615,R416,D294,L932,D877,R270,U350,R40,U720,L248,D13,L120,D657,L787,U313,R93,U922,R330,D184,L595,D578,R144,D213,L827,U787,R41,D142,R340,D733,L547,U595,L49,U652,L819,D691,R871,D628,R117,U880,L140,U736,L776,U151,R781,U582,R438,D382,R747,D390,R956,U44,L205,U680,R775,D152,L8,D80,R730,U922,L348,U363,L44,D355,R556,D880,R734,U60,R102,U776,L822,D732,L332,D769,L272,D784,R908,U58,L252,U290,R478,D192,R638,U548,R169,D946,L749,D638,L962,U844,R458,D283,R354,U95,L271,U738,R764,U757,R862,U176,L699,D810,L319,U866,R585,U743,L483,D502,R904,D248,L792,D37,R679,U607,L439,U326,L105,U95,L486,D214,R981,U260,R801,U212,L718,U302,L644,D987,L73,U228,L576,U507,L231,D63,R871,U802,R282,D237,L277,U418,R116,U194,R829,U786,L982,D131,R630,U358,R939,D945,L958,D961,R889,U949,L469,D980,R25,D523,L830,U343,R780,U581,R562,U115,L569,D959,R738,U299,L719,U732,L444,D579,L13,U242,L953,U169,R812,D821,R961,D742,R814,D483,R479,D123,L745,D892,L534";

        List<Point> commonPoints = getPointList(path1);
        commonPoints.retainAll(getPointList(path2));

        System.out.println("--- Day 3: Crossed Wires ---");
        System.out.println("The Manhattan distance from the central port to the closest intersection is " + getManhattanDistance(commonPoints));
        System.out.println("Part2: " + getFewestCombinedSteps(commonPoints, path1, path2));

    }

    private static int getFewestCombinedSteps(List<Point> pointList, String path1, String path2) {

        String[] items1 = path1.split(",");
        String[] items2 = path2.split(",");
        
        int lowestSum = 999999999;

        for (Point point : pointList) {

            int count1 = getCount(items1, point);
            int count2 = getCount(items2, point);

            int sum = count1 + count2;
            if (lowestSum > sum) {
                lowestSum = sum;
            }
        }

        return lowestSum;
    }

    private static int getCount(String[] items, Point point) {

        Point actualLocation = new Point(0, 0);
        int i = 0;
        int count = 0;

        do {
            char direction = items[i].charAt(0);
            int distance = Integer.parseInt(items[i].substring(1));

            for (int j = 0; j < distance; j++) {

                if (direction == 'U') {
                    actualLocation.y += 1;
                } else if (direction == 'R') {
                    actualLocation.x += 1;
                } else if (direction == 'D') {
                    actualLocation.y -= 1;
                } else if (direction == 'L') {
                    actualLocation.x -= 1;
                }

                if (actualLocation.equals(point)) {
                    j = distance;
                }

                count++;

            }

            i++;

        } while (!actualLocation.equals(point));

        return count;
    }


    private static List<Point> getPointList(String path) {

        String[] items = path.split(",");
        List<Point> pointList = new ArrayList<>();
        Point actualLocation = new Point(0, 0);

        for (String item : items) {

            char direction = item.charAt(0);
            int distance = Integer.parseInt(item.substring(1));

            for (int j = 0; j < distance; j++) {

                if (direction == 'U') {
                    actualLocation.y += 1;
                    pointList.add(new Point(actualLocation));
                } else if (direction == 'R') {
                    actualLocation.x += 1;
                    pointList.add(new Point(actualLocation));
                } else if (direction == 'D') {
                    actualLocation.y -= 1;
                    pointList.add(new Point(actualLocation));
                } else if (direction == 'L') {
                    actualLocation.x -= 1;
                    pointList.add(new Point(actualLocation));
                }

            }

        }

        return pointList;
    }

    private static int getManhattanDistance(List<Point> pointList) {

        int lowestDistance = 999999;

        for (Point point : pointList) {
            int distance = (Math.abs(point.x) + Math.abs(point.y));
            if (lowestDistance > distance) {
                lowestDistance = distance;
            }
        }
        return lowestDistance;
    }

}
