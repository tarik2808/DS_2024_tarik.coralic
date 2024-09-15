package midterm.homework2;

public class Process implements Comparable<Process> {
    private String name;
    private int priority;
    private int burstTime;
    private int arrivalTime;
    private int remainingTime;
    private int finishTime;
    private int waitingTime;

    public Process(String name, int priority, int burstTime, int arrivalTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.remainingTime = burstTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public int compareTo(Process other) {
        if (this.priority == other.priority) {
            return this.arrivalTime - other.arrivalTime;
        }
        return this.priority - other.priority;
    }

    @Override
    public String toString() {
        return "Process{name='" + name + "', priority=" + priority + ", burstTime=" + burstTime + ", arrivalTime=" + arrivalTime + '}';
    }
}
