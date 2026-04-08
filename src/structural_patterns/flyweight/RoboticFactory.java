package structural_patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {

  private static final Map<String, IRobot> cacheMemory = new HashMap<>();

  public static IRobot createRobot(String type) {
    if (cacheMemory.containsKey(type)) {
      return cacheMemory.get(type);
    } else {
      if (type.equalsIgnoreCase("Humanoid")) {
        Sprites humanoidSprite = new Sprites();
        IRobot humanoidRobo = new HumanoidRobot(type, humanoidSprite);
        cacheMemory.put(type, humanoidRobo);
        return cacheMemory.get(type);
      } else if (type.equalsIgnoreCase("RoboticDog")) {
        Sprites roboticDogSprite = new Sprites();
        IRobot roboticDog = new RoboticDog(type, roboticDogSprite);
        cacheMemory.put(type, roboticDog);
        return cacheMemory.get(type);
      }
    }
    throw new IllegalArgumentException("Invalid robot type: " + type);
  }

  public static int getTotalRobots() {
    return cacheMemory.size();
  }
}
