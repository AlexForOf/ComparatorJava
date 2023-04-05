import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum ColComponent{
    RED,GREEN,BLUE
}

class MyColorCompar implements Comparator<MyColor> {
    ColComponent enumerator;
    MyColorCompar(ColComponent enumerator){
        this.enumerator = enumerator;
    }

    @Override
    public int compare(MyColor o1, MyColor o2) {
        int result = 0;
        switch (enumerator){
            case RED:
                result = Integer.compare(o1.getRed(), o2.getRed());
                break;
            case GREEN:
                result = Integer.compare(o1.getGreen(), o2.getGreen());
                break;
            case BLUE:
                result = Integer.compare(o1.getBlue(), o2.getBlue());
                break;
        }
        if (result == 0) return 1;
        return result;
    }
}

class MyColor extends java.awt.Color implements Comparable<MyColor>{

    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public int compareTo(MyColor o) {
        int sumThisColor = super.getRed()+super.getGreen()+super.getBlue();
        int sumMyColor = o.getRed()+o.getGreen()+o.getBlue();
        return Integer.compare(sumThisColor, sumMyColor);
    }

    @Override
    public String toString() {
        return "(" + this.getRed() + "," + this.getGreen() + "," + this.getBlue() + ")";

    }
}

public class ColorComparing {
    public static void main(String[] args) {
        List<MyColor> list = Arrays.asList(
            new MyColor(  1,  2,  3),
            new MyColor(255,  0,  0),
            new MyColor( 55, 55,100),
            new MyColor( 10,255, 10)
        );
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.RED));
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.GREEN));
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.BLUE));
        System.out.println(list);
    }
}
