import Random.RandomValues;
import World.Location;
import lombok.Getter;

public class Island {
    public int x;
    public int y;
    @Getter
    public Location[][] island;
    public Island(){
        this.x = RandomValues.intRandomEatCoordinateX;
        this.y = RandomValues.intRandomEatCoordinateY;
        this.island = new Location[x][y];
    }

}
