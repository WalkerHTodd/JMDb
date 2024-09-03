import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ActorTest {

    @Test
    public void SearchMovieByIDTest() throws Exception {
        Actor testActor = new Actor("Walker Todd", "12345678", "Picture link",
                "Harry potter or something");

        assertEquals(testActor.getName(), "Walker Todd");
        assertEquals(testActor.getID(), "12345678");
        assertEquals(testActor.getImage(), "Picture link");
        assertEquals(testActor.getCharecter(), "Harry potter or something");

    }
}
