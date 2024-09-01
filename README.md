A thread in Java can be in one of several states, which are defined in the `java.lang.Thread.State` enum. The primary thread states are:

1. **NEW**: A thread that has been created but not yet started. At this point, the thread object is created, but `start()` has not been called.

2. **RUNNABLE**: A thread that is ready to run and is waiting for the CPU to allocate time for execution. This state can be further subdivided into:
   - **Ready**: The thread is ready to run and waiting for the CPU.
   - **Running**: The thread is currently being executed by the CPU.

3. **BLOCKED**: A thread that is waiting to acquire a monitor lock to enter a synchronized block or method. This occurs when a thread tries to access synchronized code that another thread is already executing.

4. **WAITING**: A thread that is waiting indefinitely for another thread to perform a particular action. This can happen when:
   - The thread calls `Object.wait()` and waits for another thread to call `Object.notify()` or `Object.notifyAll()`.
   - The thread is waiting for another thread to complete its execution using `Thread.join()` without a timeout.

5. **TIMED_WAITING**: A thread that is waiting for a specific period. This occurs when:
   - The thread calls `Thread.sleep(long millis)`.
   - The thread calls `Object.wait(long timeout)`.
   - The thread calls `Thread.join(long millis)`.
   - The thread calls `LockSupport.parkNanos(long nanos)` or `LockSupport.parkUntil(long deadline)`.

6. **TERMINATED**: A thread that has completed its execution. This can happen either because the run method exits normally or because of an uncaught exception that causes the run method to terminate.

### Thread State Transitions

Here is a basic overview of how a thread transitions between different states:

- **NEW → RUNNABLE**: When the `start()` method is called on a `Thread` object, the thread transitions from the `NEW` state to the `RUNNABLE` state.
- **RUNNABLE → BLOCKED**: If a thread is in the `RUNNABLE` state and attempts to enter a synchronized block or method but cannot acquire the monitor lock, it transitions to the `BLOCKED` state.
- **BLOCKED → RUNNABLE**: Once the monitor lock is released by another thread, the blocked thread can acquire the lock and transition back to the `RUNNABLE` state.
- **RUNNABLE → WAITING**: If a thread in the `RUNNABLE` state calls `Object.wait()` or `Thread.join()` without a timeout, it transitions to the `WAITING` state.
- **RUNNABLE → TIMED_WAITING**: If a thread calls `Thread.sleep(long millis)` or `Object.wait(long timeout)`, it transitions to the `TIMED_WAITING` state for the specified duration.
- **WAITING → RUNNABLE**: When a thread is in the `WAITING` state and is notified (via `Object.notify()` or `Object.notifyAll()`) or the thread it is waiting for completes, it transitions back to the `RUNNABLE` state.
- **TIMED_WAITING → RUNNABLE**: When the specified wait time elapses, or the thread is interrupted while in the `TIMED_WAITING` state, it transitions back to the `RUNNABLE` state.
- **RUNNABLE → TERMINATED**: When the `run()` method of the thread completes, either normally or due to an uncaught exception, the thread transitions to the `TERMINATED` state.
