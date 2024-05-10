
package Services;

/**
 *
 * @author HP 240 G8
 */
public class CoordsDTO {
    
    private int x,y;

    public CoordsDTO() {
    }

    public CoordsDTO(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }    

    @Override
    public String toString() {
        return "CoordsDTO{" + "x=" + x + ", y=" + y + '}';
    }
}
