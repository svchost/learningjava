public class accountvalidator {
    boolean isValidAccountNumber(String number) {
        return number != null && number.length() == 10;
    }
}