Option B: 

A SmartScheduler that uses Priority Queues and Heaps to manage a stream of incoming requests where some are more urgent than others. 

If priority is determined by a low number, we are going to use a min-heap, and if priority is determined by a high number, we're going to use a max-heap.
For this project, I plan on using a min-heap because it reflects the real world priority rules. 
Many times, in the the real world, a lower number means a higher urgency to complete the task and a min-heap places the smallest number at the root, allowing for efficient extraction. By assigning a lower number to higher priority tasks, we ensure that that the higher-priority tasks are processed before earlier, low-priority ones.  

UML:
+-------------------+
|       Task        |
+-------------------+
| - id: String      |
| - priority: int   |
| - timestamp: long |
+-------------------+
| + getId()         |
| + getPriority()   |
| + getTimestamp()  |
+-------------------+

+--------------------------+
|       SmartScheduler     +
+--------------------------+
|  - queue: PriorityQueue  |
|    (min-heap)            |
+--------------------------+
|  + addTask(Task): void   |
|  + getNextTask(): Task   |
|  + peekNextTask(): Task  |
|  + isEmpty(): boolean    |
+--------------------------+

Big-O Expectations:
To add a task and retrieve the next task, I expect a O(log n) time complexity because this is the time complexity of insertion + upheap in a heap. 
To check if the queue is empty and to peek at the next task, I expect a time complexity of O(1) because, for a min-heap, the minimum element is always at the root and we just need to check the size of the heap to see if it's empty which a constant time function. 
