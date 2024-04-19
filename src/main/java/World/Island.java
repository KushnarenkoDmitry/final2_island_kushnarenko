package World;

import Random.RandomValues;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;

public class Island {

        public int x;
        public int y;
        @Getter
        public Location[][] locations;
        public Island(){
            this.x = RandomValues.intRandomEatCoordinateX;
            this.y = RandomValues.intRandomEatCoordinateY;
            this.locations = new Location[x][y];
        }
        public void fillIsland() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    Location location = new Location();
                    location.fillLocation();
                    locations[i][j] = location;
                }
            }
        }


    }

