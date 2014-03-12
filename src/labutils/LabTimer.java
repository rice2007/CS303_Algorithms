package labutils;

public class LabTimer {

    private static long timeInitial;
    private static long timeFinal;
    private static long timeElapsed;

    public LabTimer() {
        this.timeInitial = 0;
        this.timeFinal = 0;
        this.timeElapsed = 0;
    }

    /**
     * Gets an arbitrary point in time expressed in nanoseconds.
     */
    public void startTimer() {
        timeInitial = System.nanoTime();
    }

    /**
     * Gets an arbitrary point in time expressed in nanoseconds then calculates the time elapsed since
     * {@link #startTimer()} was last called.
     */
    public long stopTimer() {
        timeFinal = System.nanoTime();
        System.out.println("timeInitial: " + timeFinal);
        System.out.println("timeFinal: " + timeFinal);
        System.out.println("timeElapsed: " + timeElapsed + "\n");
        return timeElapsed = (timeFinal - timeInitial);
    }

    public long currentTimeElapsed() {
        timeFinal = System.nanoTime();
        return timeElapsed = timeFinal - timeInitial;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }
}
