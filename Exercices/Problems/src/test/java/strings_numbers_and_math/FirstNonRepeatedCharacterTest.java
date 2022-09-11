package strings_numbers_and_math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstNonRepeatedCharacterTest {

    private FirstNonRepeatedCharacter firstNonRepeatedCharacter;
    private String word1, word2, word3, word4, word5;

    @BeforeEach
    void init() {
        firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();
        word1 = "preeg";
        word2 = "uufgtt";
        word3 = "uugguutteuqw";
        word4 = "fgtt!!@@&hi";
        word5 = "biii!fgtt@@&hi";
    }

    @Test
    @DisplayName("first test")
    public void fistTest() {

    }
}
