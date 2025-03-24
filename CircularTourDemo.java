import java.util.Queue;
import java.util.LinkedList;

class CircularTour {
    static class PetrolPump {
        int petrol, distance;
        
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0, deficit = 0, surplus = 0;
        
        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;
            
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }
        
        return (surplus + deficit >= 0) ? start : -1;
    }
}

public class CircularTourDemo {
    public static void main(String[] args) {
        CircularTour.PetrolPump[] pumps = {
            new CircularTour.PetrolPump(4, 6),
            new CircularTour.PetrolPump(6, 5),
            new CircularTour.PetrolPump(7, 3),
            new CircularTour.PetrolPump(4, 5)
        };
        
        int start = CircularTour.findStartingPoint(pumps);
        System.out.println((start == -1) ? "No valid starting point" : "Start at pump: " + start);
    }
}
