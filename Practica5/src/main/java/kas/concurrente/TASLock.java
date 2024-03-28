package kas.concurrente;

import java.util.concurrent.atomic.AtomicBoolean;

public class TASLock implements Lock {
    private AtomicBoolean state = new AtomicBoolean(false);

    @Override
    public void lock() {
        while(state.getAndSet(true));
    }

    @Override
    public void unlock() {
        state.set(false);
    }
    
}
