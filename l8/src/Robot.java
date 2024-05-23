public class Robot {
    private final Object lock = new Object();
    private boolean isLeftTurn = true; // true если очередь левой ноги, иначе очередь правой ноги

    public static void main(String[] args) {
        Robot robot = new Robot();

        Thread leftLeg = new Thread(new Leg(robot, true));
        Thread rightLeg = new Thread(new Leg(robot, false));

        leftLeg.start();
        rightLeg.start();
    }

    public void step(boolean isLeft) {
        synchronized (lock) {
            while (isLeft != isLeftTurn) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println(isLeft ? "LEFT" : "RIGHT");
            isLeftTurn = !isLeftTurn;
            lock.notifyAll();
        }
    }

    static class Leg implements Runnable {
        private final Robot robot;
        private final boolean isLeft;

        Leg(Robot robot, boolean isLeft) {
            this.robot = robot;
            this.isLeft = isLeft;
        }

        @Override
        public void run() {
            while (true) {
                robot.step(isLeft);
                try {
                    Thread.sleep(500); // Задержка для имитации шага
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
