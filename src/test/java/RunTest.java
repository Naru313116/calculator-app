
import org.junit.jupiter.api.Test;
import pl.naru.workers.DataWorker;
import pl.naru.workers.FileWorker;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RunTest {

    @Test
    public void shouldThrowUnsupportedOperationWithMessage() throws FileNotFoundException {
        FileWorker fileWorker = new FileWorker();
        List<String> lines = fileWorker.retrieveFileData("src/main/resources/unsupportedOperationTest.txt");
        DataWorker dataWorker = new DataWorker(lines);
        UnsupportedOperationException e = assertThrows(UnsupportedOperationException.class, dataWorker::executeStatement);
        assertEquals("Statement contains unsupported operation called: sqrt", e.getMessage());
    }

    @Test
    public void shouldBeStatementValid() throws FileNotFoundException {
        FileWorker fileWorker = new FileWorker();
        List<String> lines = fileWorker.retrieveFileData("src/main/resources/test.txt");
        DataWorker dataWorker = new DataWorker(lines);
        assertTrue(dataWorker.isStatementValid());
    }

    @Test
    public void shouldBeStatementInvalid() throws FileNotFoundException {
        FileWorker fileWorker = new FileWorker();
        List<String> lines = fileWorker.retrieveFileData("src/main/resources/invalidPatternTest.txt");
        DataWorker dataWorker = new DataWorker(lines);
        assertFalse(dataWorker.isStatementValid());
    }

    @Test
    public void shouldThrowFileNotFoundException() {
        FileWorker fileWorker = new FileWorker();
        assertThrows(FileNotFoundException.class, () -> fileWorker.retrieveFileData("src/main/resources/testNoSuchFile.txt"));
    }

    @Test
    public void shouldBeProperValue() throws FileNotFoundException {
        FileWorker fileWorker = new FileWorker();
        List<String> lines = fileWorker.retrieveFileData("src/main/resources/test.txt");
        DataWorker dataWorker = new DataWorker(lines);
        int expectedValue = 1024;
        assertEquals(expectedValue, dataWorker.executeStatement());

    }
}
