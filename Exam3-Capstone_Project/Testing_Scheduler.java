public class Testing_Scheduler {
    public static void main(String[] args) {
        SmartScheduler scheduler = new SmartScheduler();

        scheduler.addTask(new Task("Cleaning", 7, 100));
        scheduler.addTask(new Task("Sanitizing", 3, 200));

        //Testing to see if it does get the highest priority first (lowest priority number)
        Task t1 = scheduler.getNextTask();
        System.out.println("Test 1 (Highest priority first): "+(t1.getId().equals("Sanitizing")? "Pass":"Fail"));

        //Testing tie-breaker by comparing timestamps
        scheduler.addTask(new Task("Dusting", 6, 30));
        scheduler.addTask(new Task("Sweeping", 6, 100));
        Task t2 = scheduler.getNextTask();
        System.out.println("Test 2 (Earlier timestamp first): "+(t2.getId().equals("Dusting")? "Pass":"Fail"));

        //Testing to see what happens with an empty scheduler
        SmartScheduler empty = new SmartScheduler();
        Task t3 = empty.getNextTask();
        System.out.println("Test 3 (Polling empty queue returns null): "+ (t3==null ? "Pass":"Fail"));

    }
}
