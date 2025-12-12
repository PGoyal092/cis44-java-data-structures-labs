import static org.junit.Assert.*;
import org.junit.Test;

public class SmartSchedulerTest {
    @Test
    public void testHighestPriorityRemovedFirst(){
        SmartScheduler scheduler = new SmartScheduler();
        scheduler.addTask(new Task("Low", 7, 100));
        scheduler.addTask(new Task("High", 13, 200));

        Task result = scheduler.getNextTask();
        assertEquals("Low", result.getId());
    }
    @Test
    public void testTieBrokenByTimeStamp(){
        SmartScheduler scheduler = new SmartScheduler();
        scheduler.addTask(new Task("First", 3, 16));
        scheduler.addTask(new Task("Second", 3, 19));

        Task result = scheduler.getNextTask();
        assertEquals("First", result.getId());
    }
    @Test
    public void testPollEmptyReturnsNull(){
        SmartScheduler scheduler = new SmartScheduler();
        assertNull(scheduler.getNextTask());
    }
}