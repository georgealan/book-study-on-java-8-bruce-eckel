package strings_numbers_and_math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicateCharactersTest {

    private CountingDuplicateCharacters countDupChar;
    private String phrase, word, wordOrPhrase, wordWithSpaceInTheEnd;
    private int numberOfDuplicate;
    private Map<String, Long> map;

    @BeforeEach
    void init() {
        countDupChar = new CountingDuplicateCharacters();
        phrase = "George Alan Rufo are a Java Programming";
        word = "Programmer";
        wordWithSpaceInTheEnd = "Programmer ";
        map = new HashMap<>();
        numberOfDuplicate = 0;
        wordOrPhrase = "";
    }

    @Test
    @DisplayName("must actual phrase be equal to return of the class method")
    public void phraseHadToBeEqualToResultOutput() {
        String actual = countDupChar.countDuplicateCharacters(phrase);

        Assertions.assertEquals(
            "This phrase Here: \"George Alan Rufo are a Java Programming\", contain 7 characteres duplicated. And the duplicates are these: [A, R, E, G, M, N, O]",
            actual);
    }

    @Test
    @DisplayName("must get phrase if the input have sentence with spaces")
    public void outPutMustBePhraseWhenInputHasSpaces() {
        String result = countDupChar.getIfIsWordOrPhrase(phrase);
        Assertions.assertEquals("phrase", result);
    }

    @Test
    @DisplayName("must get word if the input are only a word without spaces")
    public void outPutMustBeWordWhenInputDontHaveSpaces() {
        String result = countDupChar.getIfIsWordOrPhrase(word);
        Assertions.assertEquals("word", result);
    }

    @Test
    @DisplayName("must be a word if an space aren't followed by a letter aside")
    public void outputMustBeWordWhenHaveAWordWithEmptySpacesInTheEnd() {
        String result = countDupChar.getIfIsWordOrPhrase(wordWithSpaceInTheEnd);
        Assertions.assertEquals("word", result);
    }

    @Test
    @DisplayName("must be only letters that are duplicated")
    public void lettersDuplicated() {
        map = countDupChar.fillAndSplitSentence(word.toUpperCase());
        String result = countDupChar.getDuplicateCharacters(map);
        Assertions.assertEquals("[R, M]", result);
    }

    @Test
    @DisplayName("must be characters mapped with values counting number of duplicates")
    public void mapOnlyWithDuplicatedCharactersAndValuesCountingDuplicates() {
        map = countDupChar.fillAndSplitSentence(word.toUpperCase());
        Assertions.assertEquals("{P=1, A=1, R=3, E=1, G=1, M=2, O=1}", map.toString());
    }

    @Test
    @DisplayName("must be characters mapped with values counting duplicates, with 6 spaces")
    public void mapOnlyWithDuplicatedCharactersAndValuesCountingDuplicatesWith6Space() {
        map = countDupChar.fillAndSplitSentence(phrase.toUpperCase());
        Assertions.assertEquals("{ =6, A=7, E=3, F=1, G=4, I=1, J=1, L=1, M=2, N=2, O=3, P=1, R=5, U=1, V=1}",
                map.toString());
    }

    @Test
    @DisplayName("must display the number of letters duplicates in a word correctly")
    public void displayNumberOfDuplicatesInAWordCorrectly() {
        wordOrPhrase = countDupChar.getIfIsWordOrPhrase(word);
        map = countDupChar.fillAndSplitSentence(word.toUpperCase());
        int result = countDupChar.getNumberOfDuplicate(numberOfDuplicate, map, wordOrPhrase);
        Assertions.assertEquals(2, result);
    }

    @Test
    @DisplayName("must display the number of letters duplicates in a phrase correctly, without counting space duplicates")
    public void displayNumberOfDuplicatesInAPhraseCorrectly() {
        wordOrPhrase = countDupChar.getIfIsWordOrPhrase(phrase);
        map = countDupChar.fillAndSplitSentence(phrase);
        int result = countDupChar.getNumberOfDuplicate(numberOfDuplicate, map, wordOrPhrase);
        Assertions.assertNotEquals(8, result);
    }

}
