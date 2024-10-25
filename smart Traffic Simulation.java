public class TrafficSimulation {

    private static final int NUM_SIGNALS = 4;
    private static final int DEFAULT_GREEN_DURATIONS[] = { 10, 10, 10, 10 };
    private static final int DEFAULT_YELLOW_DURATION = 5;
    private static final int DEFAULT_RED_DURATION = 150;
    private static final Map<String, Double> VEHICLE_SPEEDS = new HashMap<>(); // key: vehicle type, value: speed

    private List<TrafficSignal> signals;
    private List<List<Vehicle>> vehicles; // 2D list to represent vehicles in different lanes for each direction
    private int currentGreenSignal;
    private int currentYellow;

    public static void main(String[] args) {
        TrafficSimulation sim = new TrafficSimulation();
        sim.initialize();
        sim.runSimulation();
    }

    private void initialize() {
        signals = new ArrayList<>();
        vehicles = new ArrayList<>();
        for (int i = 0; i < NUM_SIGNALS; i++) {
            signals.add(new TrafficSignal(DEFAULT_RED_DURATION, DEFAULT_YELLOW_DURATION, DEFAULT_GREEN_DURATIONS[i]));
            vehicles.add(new ArrayList<>()); // empty list for each direction
        }
        currentGreenSignal = 0;
        currentYellow = 0;
        // Add code to initialize vehicle speeds (VEHICLE_SPEEDS)
    }

    private void runSimulation() {
        while (true) {
            updateTrafficLights();
            // Add code to generate new vehicles with random types and lanes
            // Add code to move vehicles based on traffic light status and their positions
            // Print simulation state (traffic light statuses, vehicle positions)
        }
    }

    private void updateTrafficLights() {
        // Implement logic to handle green, yellow, and red phases for the current
        // signal
        // Update timers (currentGreenSignal, currentYellow)
    }

    // ... other methods for vehicle generation and movement logic
}

class TrafficSignal {
    int redDuration;
    int yellowDuration;
    int greenDuration;
    String currentText; // Text displayed on the signal

    // Constructor and methods for TrafficSignal
}

class Vehicle {
    int lane;
    String type;
    String direction;
    double speed;
    int x, y; // current position
    boolean crossedStopLine;

    // Constructor and methods for Vehicle
}