import java.io.InputStream;
import java.util.Scanner;

public class Calc {

    public static String calc(String input) throws RuntimeException{
        String[] strings = input.split("[+\\-/*]+");
        if (strings.length != 2) {
            throw new RuntimeException("�� ����� ������� ����� ������");
        }
        String operation = input.replaceAll("[\\d\\p{Alpha}]+", " ").trim();
        String result = null;
        boolean isRomanOneOperand = Roman.isRoman(strings[0]);
        boolean isRomanTwoOperand = Roman.isRoman(strings[1]);
        if (isRomanOneOperand && isRomanTwoOperand) {
            int a = Roman.convertToArabian(strings[0]);
            int b = Roman.convertToArabian(strings[1]);
            if (a > 10 || b > 10) {
                throw new RuntimeException("����� �� ����� ���� ������ 10");
            } else if (a < 1 || b < 1) {
                throw new RuntimeException("����� �� ������ ���� ������ 1 ");
            }
            int calculate = calculate(a, b, operation);

           if (calculate<0){
               throw new RuntimeException("������� ����� �� ����� ���� ��������������");
           }
           result = Roman.convertToRoman(calculate);
        } else if (!isRomanOneOperand && !isRomanTwoOperand) {
            int a = Integer.parseInt(strings[0].trim());
            int b = Integer.parseInt(strings[1].trim());
            if (a > 10 || b > 10) {
                throw new RuntimeException("����� �� ����� ���� ������ 10");
            } else if (a < 1 || b < 1) {
                throw new RuntimeException("����� �� ������ ���� ������ 1 ");
            }
            int calculate = calculate(a, b, operation);
            result = String.valueOf(calculate);
        } else {
            throw new RuntimeException("����� ������ ���� ������ �������� ��� ������ ��������� ");
        }
        return result;
    }

    private static int calculate(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new RuntimeException("�������� ��������");
        };
    }

    public static void main(String[] args) {
        System.out.println("������� ���� ��������� :");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        try {
            String result = calc(str);
            System.out.println(str + "=" + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}







