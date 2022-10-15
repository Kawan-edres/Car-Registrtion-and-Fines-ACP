import java.util.regex.Pattern;
public class Main {

    public static void main(String[] args) {

        System.out.println("Second weeks Works ");
    }
    
}



record AdminRecord(String username, String password) {
	public AdminRecord {
		if ((password.length() < 8) || (password.length() > 20)) {
			throw new IllegalArgumentException(
					"password must be at least 8 characters and not more than 20 characters");
		}
		if (password.contains(" ")) {
			throw new IllegalArgumentException("password must not contain space");
		}

		if (!(Pattern.compile(".*[0-9].*").matcher(password).matches()))
			throw new IllegalArgumentException("Password should contain at least one digit(0-9)");

		if (!(Pattern.compile(".*[A-Z].*").matcher(password).matches()))
			throw new IllegalArgumentException("Password should contain at least one uppercase letter(A-Z)");

	}
}

record VIN_Number(String serialNumber) {
	VIN_Number {
		if (!(serialNumber.length() == 17/* it must be 17 characters */))
			throw new IllegalArgumentException("serial number need to be 17 characters");
		else
			serialNumber.replaceAll("\\s", "").toUpperCase(); // to remove all space

	}
    @Override
    public String toString() {
        return this.serialNumber;
    }

}