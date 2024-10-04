import org.example.main.StringProcess;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    @Test
     void isStrong(){
        StringProcess string = new StringProcess();
        assertEquals(true, string.isStrong("A122kjfit@"));
    }
    @Test
    void calculateDigits(){
        StringProcess string= new StringProcess();
        assertEquals(1,string.calculateDigits(" i have 1 aplle"));
    }
    @Test
    void countWords(){
        StringProcess string = new StringProcess();
        assertEquals(4,string.countWords("All people are crazy"));
    }
    @Test
    void calculateExpression(){
        StringProcess string = new StringProcess();
        assertEquals(3,string.calculateExpression("2+2-1"));
    }


    }
