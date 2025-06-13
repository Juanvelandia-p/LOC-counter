package edu.escuelaing.arsw.ASE.app;
import edu.escuelaing.arsw.ASE.app.LineCounter;

import org.junit.Test;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class LineCounterTest {

    @Test
    public void testPhysicalLines() throws Exception {
        int lines = LineCounter.countPhysicalLines(Paths.get("src/test/resources/Test1.java"));
        assertEquals(8, lines);
    }

    @Test
    public void testLogicalLines() throws Exception {
        int lines = LineCounter.countLogicalLines(Paths.get("src/test/resources/Test1.java"));
        assertEquals(3, lines);
    }
    @Test
    public void testPhysicalLines2() throws Exception {
        int lines = LineCounter.countPhysicalLines(Paths.get("src/test/resources/Test2.java"));
        assertEquals(76, lines);
    }
    @Test
    public void testLogicalLines2() throws Exception {
        int lines = LineCounter.countLogicalLines(Paths.get("src/test/resources/Test2.java"));
        assertEquals(55, lines);
    }

}
