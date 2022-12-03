package entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CellTest {
    /**
     * Tests setValue and getValue by comparing with String value of "A"
     */
    @Test
    public void setAndGetValue(){
        Cell cell = new Cell();
        cell.setValue("A");

        Assertions.assertEquals(cell.getValue(), "A");

    }
    /**
     * Tests getScore and setScore by comparing with integer value of "4"
     */
    @Test
    public void setAndGetScoreTest(){
        Cell cell = new Cell();
        cell.setScore(4);

        Assertions.assertEquals(cell.getScore(), 4);

    }
    /**
     * Tests getMultiplier and setMultiplier by comparing with integer value of "4"
     */
    @Test
    public void setAndGetMultiplierTest(){
        Cell cell = new Cell();
        cell.setMultiplier(4);

        Assertions.assertEquals(cell.getMultiplier(), 4);

    }

}
