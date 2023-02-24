import org.junit.jupiter.api.Test;

public class Hometest6 {
    @Test
    public static void main(String[] args) {
        //Арифметические операторы
        int a = 10;
        int b = 20;
        int c = 6;
        //сложение
        System.out.println("a + b = " + (a + b));
        //вычитание
        System.out.println("a - b = " + (a - b));
        //умножение
        System.out.println("a * b = " + (a * b));
        //деление
        System.out.println("b + a = " + (b / a));
        //остаток от деления
        System.out.println("a % c = " + (a % c));
        //инкремент
        System.out.println("a++ = " + (a++));
        //декремент
        System.out.println("a-- = " + (a--));


        //Операторы сравнения
        System.out.println("a == b = " + (a == b) );//равно
        System.out.println("a != b = " + (a != b) );//не равно
        System.out.println("a > b = " + (a > b) );//больше
        System.out.println("a < b = " + (a < b) );//меньше
        System.out.println("b >= a = " + (b >= a) );//больше или равно
        System.out.println("b <= a = " + (b <= a) );//меньше или равно

        //Логические операторы
        boolean d = true;
        boolean e = false;

        System.out.println("d && e = " + (d&&e));//false

        System.out.println("d || e = " + (d||e) );//true

        System.out.println("!(d && b) = " + !(d && e));//true

        //Операторы присваивания
        c = a + b;
        System.out.println("c = a + b = " + c );

        c += a ;
        System.out.println("c += a  = " + c );

        c -= a ;
        System.out.println("c -= a = " + c );

        c *= a ;
        System.out.println("c *= a = " + c );

        a = 10;
        c = 15;
        c /= a ;
        System.out.println("c /= a = " + c );

        a = 10;
        c = 15;
        c %= a ;
        System.out.println("c %= a  = " + c );

        c <<= 2 ;
        System.out.println("c <<= 2 = " + c );

        c >>= 2 ;
        System.out.println("c >>= 2 = " + c );

        c >>= 2 ;
        System.out.println("c >>= a = " + c );

        c &= a ;
        System.out.println("c &= 2  = " + c );

        c ^= a ;
        System.out.println("c ^= a   = " + c );

        c |= a ;
        System.out.println("c |= a   = " + c );

        //Тернарный оператор
        b = (a == 1) ? 20 : 30;
        System.out.println( "Значение b: " +  b );

        b = (a == 10) ? 20 : 30;
        System.out.println( "Значение b: " + b );

        //Переполнение
        int g = Integer.MAX_VALUE;
        int h = 5000;
        int i = 123;
        int min = Math.min(g, Math.min(h,i));
        int max = Math.max(g, Math.max(h,i));
        int k = g + h + i - min - max;
        System.out.println("Результат переполнения " + k);

        //Комбинация int и double
        int w= 30;
        double v = 5.5;
        System.out.println(w + v);//тип double

    }
}
