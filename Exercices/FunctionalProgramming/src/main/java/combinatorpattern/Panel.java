package combinatorpattern;

import java.time.LocalDate;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Panel {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "George Alan Rufo",
                "georgealanrufo@gmail.com",
                "+0123456789",
                LocalDate.of(1987, 5, 3)
        );

        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
