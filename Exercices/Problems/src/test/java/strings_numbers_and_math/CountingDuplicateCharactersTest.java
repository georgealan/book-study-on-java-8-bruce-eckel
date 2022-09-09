package strings_numbers_and_math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountingDuplicateCharactersTest {

    private CountingDuplicateCharacters countDupChar;
    private String phrase1, phrase2, word1, word2;
    private String answerPhrase1, answerPhrase2, answerWord1, answerWord2;

    @BeforeEach
    void init() {
        countDupChar = new CountingDuplicateCharacters();
        phrase1 = "George Alan Rufo are a Java Programming";
        phrase2 = "Programming in Java is funny";
        word1 = "Programmer";
        word2 = "Assertions";
    }

    @Test
    @DisplayName("must actual phrase be equal to return of the class method")
    public void phraseHadToBeEqualToResulInput() {
        String actual = countDupChar.countDuplicateCharacters(phrase1);

        Assertions.assertEquals(
            "This phrase Here: \"George Alan Rufo are a Java Programming\", contain 7 characteres duplicated. And the duplicates are these: [A, R, E, G, M, N, O]",
            actual);
    }


}
