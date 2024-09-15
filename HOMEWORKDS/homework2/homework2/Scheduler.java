package midterm.homework2;

import midterm.homework2.Process;
import java.util.ArrayList;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue queue = new ProcessQueue();
        int time = 0;
        int totalTime = 0;
        ArrayList<Process> completedProcesses = new ArrayList<>();

        while (!processes.isEmpty() || queue.peekNextProcess() != null) {
            for (int i = 0; i < processes.size(); i++) {
                Process process = processes.get(i);
                if (process.getArrivalTime() == time) {
                    queue.addProcess(process);
                    processes.remove(i);
                    i--;
                }
            }

            Process currentProcess = queue.runNextProcess();
            if (currentProcess != null) {
                System.out.println("t = " + time + " → " + currentProcess.getName() + " is running");
                currentProcess.setRemainingTime(currentProcess.getRemainingTime() - 1);
                if (currentProcess.getRemainingTime() > 0) {
                    queue.addProcess(currentProcess);
                } else {
                    currentProcess.setFinishTime(time + 1);
                    completedProcesses.add(currentProcess);
                }
            } else {
                System.out.println("t = " + time + " → No process is running");
            }
            time++;
        }
        System.out.println("Total time taken: " + time);

        // Calculate and print average waiting time
        double totalWaitingTime = 0;
        for (Process p : completedProcesses) {
            int waitingTime = p.getFinishTime() - p.getBurstTime() - p.getArrivalTime();
            p.setWaitingTime(waitingTime);
            totalWaitingTime += waitingTime;
        }
        double averageWaitingTime = totalWaitingTime / completedProcesses.size();
        System.out.println("Average waiting time: " + averageWaitingTime);
    }
}