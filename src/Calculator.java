public class Calculator {
    private int num1;
    private int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double calculate(String operation) throws WrongOperationException, ArithmeticException {
        double result;
        switch (operation) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = sub(num1, num2);
                break;
            case "*":
                result = mult(num1, num2);
                break;
            case "/":
                result = div(num1, num2);
                break;
            default:
                throw new WrongOperationException();
        }
        return result;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public double div(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException();
        }
        return (double) a / b;
    }
}
