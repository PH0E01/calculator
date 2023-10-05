import java.util.Arrays;
import java.util.Scanner;

public class Program {
    static String[] Array = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] arrayString = scanner.nextLine().split(" ");
        String firstValue = arrayString[0];
        char action = arrayString[1].charAt(0);  //разбиваем вводные символы
        String nextValue = arrayString[2];

        if (arrayString.length > 3) {
            throw new Exception();            // введено более 3 симв. => Exc
        }


        int value1 = 0;
        int value2 = 0;
        boolean convert = false;
        boolean Ar = false;

        try {
            value1 = Integer.parseInt(firstValue);  // удалось распарсить в ар. => все ок
            value2 = Integer.parseInt(nextValue);
            Ar = true;
        } catch (Exception e) {


        }


        if(Ar != true) {             // араб осталось false => пробуем найти схожесть с индексом рим. чисел
            try {
                convert = true;
                for (int i = 0; i < Array.length; i++) {
                    if (firstValue.equals(Array[i]))   //   в римские
                        value1 = i;


                    if (nextValue.equals(Array[i]))
                        value2 = i;
                }
            } catch (Exception e) {
                throw new Exception();
            }
        }

        int resultR;

        switch (action) {
            case '+':
                resultR = value1 + value2;
                break;
            case '-':
                resultR = value1 - value2;
                break;
            case '*':
                resultR = value1 * value2;
                break;
            case '/':
                if (value2 == 0)
                    throw new Exception();
                resultR = value1 / value2;
                break;
            default:
                throw new Exception();     // было прописано неразрешенное действие => Exc


        }

        if(convert){
            if(resultR < 0){
                throw new Exception();        // ответ меньше 0 Exc
            }
            System.out.println(Array[resultR]);
        }
        else {
            System.out.println(resultR);
        }


    }
}
