import java.util.ArrayList;
import java.util.List;

public class Fengqi {
    private String name;
    private int radius;
    private double surface;

    public Fengqi(String name, int radius, double surface) {
        this.name = name;
        this.radius = radius;
        this.surface = surface;
    }

    @Override
    public String toString() {
        return name + ", " + radius +", " + surface;
    }

    public static void main(String[] args) {
        List<Fengqi> fengqiList = new ArrayList<>();
        fengqiList.add(new Fengqi("Mercury", 2439, 3.70));
        fengqiList.add(new Fengqi("Venus", 6051, 8.87));
        fengqiList.add(new Fengqi("Earth", 6371, 9.81));
        fengqiList.add(new Fengqi("Mars", 3389, 3.71));
        fengqiList.add(new Fengqi("Jupiter", 69911, 24.79));
        fengqiList.add(new Fengqi("Saturn", 58232, 10.40));
        fengqiList.add(new Fengqi("Uranus", 25362, 8.87));
        fengqiList.add(new Fengqi("Neptune", 24622, 11.15));

        fengqiList.stream().filter(item ->  item.radius >= 5000 && item.surface >= 9.0)
                .forEach(System.out::println);
    }
}
