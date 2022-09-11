package operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class YearOfBirthWithDateTest {

    private YearOfBirthWithDate yearOfBirthWithDate;
    private Date currentDate;
    private String actualYear;

    @BeforeEach
    void init() {
        yearOfBirthWithDate = new YearOfBirthWithDate();
        currentDate = new Date();
        actualYear = currentDate.toString().substring(24);
    }

    @Test
    @DisplayName("must get the age of birth")
    public void ageOfBirth() {
        int result = yearOfBirthWithDate.calculateHowOldAreYou(Integer.parseInt(actualYear), 1987);
        Assertions.assertEquals(35, result);
    }

}
