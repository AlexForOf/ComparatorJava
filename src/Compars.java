import java.util.Arrays;
import java.util.Comparator;

class MyComp implements Comparator<Integer> {
    public static final int
                BY_VAL=0, BY_VAL_REV=1,
                BY_NUM_OF_DIVS=2, BY_SUM_OF_DIGS=3;
    int comparison;
    MyComp(int comparison){
        this.comparison = comparison;
    }

    int getDivsNum(int number){
        int counter = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0){
                counter++;
            }
        }
        return counter;
    }
    int getBySumOfDigs(String number){
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }
        return sum;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        int result = 0;
        switch (comparison){
            case BY_VAL:
                result = Integer.compare(o1, o2);
                break;
            case BY_VAL_REV:
                result = Integer.compare(o2, o1);
                break;
            case BY_NUM_OF_DIVS:
                result = Integer.compare(getDivsNum(o1), getDivsNum(o2));
                break;
            case BY_SUM_OF_DIGS:
                result = Integer.compare(getBySumOfDigs(Integer.toString(o1)), getBySumOfDigs(Integer.toString(o2)));
                break;
        }
        if (result == 0) result = Integer.compare(o1, o2);
        return result;
    }
}

public class Compars {
    public static void main(String[] args) {
        Integer[] a = {1,5,33,12,98,15};
        printTable("Original    ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_VAL));
        printTable("ByVal       ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_VAL_REV));
        printTable("ByValRev    ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_NUM_OF_DIVS));
        printTable("ByNumOfDivs ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_SUM_OF_DIGS));
        printTable("BySumOfDigs ", a);
    }

    static void printTable(String mess, Integer[] a) {
        System.out.print(mess + "[ ");
        for (int d : a) System.out.print(d + " ");
        System.out.print("]\n");
    }
}
