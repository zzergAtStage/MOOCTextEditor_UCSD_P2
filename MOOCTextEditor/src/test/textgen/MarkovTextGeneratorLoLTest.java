package textgen;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MarkovTextGeneratorLoLTest {


    private Random generator;
    private MarkovTextGenerator gen;

    @Before
    public void doBeforeTest(){
        generator = new Random();
        gen = new MarkovTextGeneratorLoL(generator);

    }

    @Test
    public void testTrainMethod() {
        /*Some tests failed. Please check the tests marked FAILED:
         ** Test #1: Generating text before training...PASSED.
         ** Test #2: Generating text after training on an empty file...PASSED.
         ** Test #3: Training on input, then checking requested generator word count...FAILED. Your generator produced 501 words when it should have produced 500.
         ** Test #4: Testing specific word counts...PASSED.
         ** Test #5: Checking that every word is used at least once...FAILED. Your generator doesn't produce every possible word. Make sure you include punctuation and capitals.
         ** Test #6: Seeing if last word is always followed by first word...PASSED.
         ** Test #7: Requesting zero words...FAILED. The text generator shouldn't produce anything when zero words are requested.
         ** Test #8: Running train() on a generator that has already been trained...FAILED. Make sure that train() doesn't remove the original word lists. Note that if Test #4 failed, this one will fail too.
         ** Test #9: Testing retrain()...PASSED.
         */

        gen.train("hi there hi Leo");
        int wordsCount = gen.generateText(0).length();
        assertEquals("WordsCount: Nothing should be produced, when requested zero", 0, wordsCount);

    }

    @Test
    public void generateText() {
    }

    @Test
    public void retrain() {
    }
}