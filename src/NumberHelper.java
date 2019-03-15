import java.util.HashMap;
import java.util.Map;

public class NumberHelper {

    public static Map<String, Integer> numbersMap = createNumbersMap();

    public static HashMap<String, Integer> createNumbersMap() {
        HashMap<String, Integer> numbersMap = new HashMap<>();
        String romanNumbers[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        Integer arabNumbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < romanNumbers.length; i++) {
            numbersMap.put(romanNumbers[i], arabNumbers[i]);
        }
        return numbersMap;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    public static int parseIntRoman(String str) throws NotNumberException {
        int num = 0;
        boolean isRomanNumber = false;
        for (Map.Entry<String, Integer> entry : numbersMap.entrySet()) {
            if (str.equals(entry.getKey())) {
                num = entry.getValue();
                isRomanNumber = true;
            }
        }
        if(!isRomanNumber) {
            throw new NotNumberException();
        }
        return num;
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
