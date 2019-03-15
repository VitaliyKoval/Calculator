import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите первое число: ");
        String a = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите второе число: ");
        String b = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите операцию: ");
        String operation = ConsoleHelper.readString();

        int num1 = 0;
        int num2 = 0;

        if(NumberHelper.isNumber(a) && NumberHelper.isNumber(b)) {
            num1 = NumberHelper.parseInt(a);
            num2 = NumberHelper.parseInt(b);
        } else {
            try {
                num1 = NumberHelper.parseIntRoman(a);
                num2 = NumberHelper.parseIntRoman(b);
            } catch (NotNumberException e) {
                ConsoleHelper.writeMessage(a + " " + operation + " " + b + " - не валидный пример!");
                return;
            }
        }

        Calculator calc = new Calculator(num1, num2);
        double result = 0;
        try {
            result = calc.calculate(operation);
        } catch (WrongOperationException e) {
            ConsoleHelper.writeMessage(operation + " - не правильная операция!");
            return;
        } catch (ArithmeticException e) {
            ConsoleHelper.writeMessage("На ноль делить нельзя!");
            return;
        }

        ConsoleHelper.writeMessage(num1 + " " + operation + " " + num2 + " = " + result);
    }
}
