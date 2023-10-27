package baseball.domain;

public class Ball {
    private int count;

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }

    public void resetCount() {
        this.count = 0;
    }
}
