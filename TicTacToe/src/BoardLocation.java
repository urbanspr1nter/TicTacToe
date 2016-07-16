import java.awt.*;

public class BoardLocation {
    public int x;
    public int y;
    public MarkerType markerType;
    public int row;
    public int col;

    public BoardLocation(int x, int y, Dimension d) {
        // Do location conversion here.
        int inX = x;
        int inY = y;

        if(inX < (int)(d.getWidth() / 3) && inX > 0 &&
            inY < (int)(d.getHeight() / 3) && inY > 0) {
            // 0, 0
            this.x = 0 + 10;
            this.y = 0 + 4;

            this.row = 0;
            this.col = 0;
        }
        else if(inX > (int)(d.getWidth() / 3) && inX < (int)(2 * d.getWidth() / 3)
                && inY < (int)(d.getHeight() / 3) && inY > 0) {
            // 0, 1
            this.x = (int)(d.getWidth() / 3) + 10;
            this.y = 0 + 4;

            this.row = 0;
            this.col = 1;
        }
        else if(inX > (int)(2 * d.getWidth() / 3) && inX < (int)(d.getWidth())
            && inY < (int)(d.getHeight() / 3) && inY > 0) {
            // 0, 2
            this.x = (int)(2 * d.getWidth() / 3) + 10;
            this.y = 0 + 4;

            this.row = 0;
            this.col = 2;
        }
        else if(inX < (int)(d.getWidth() / 3) && inX > 0 &&
                inY > (int)(d.getHeight() / 3) && inY < (int)(2 * d.getHeight() / 3)) {
            // 1, 0
            this.x = 0 + 10;
            this.y = (int)(d.getHeight() / 3) + 4;

            this.row = 1;
            this.col = 0;
        }
        else if(inX > (int)(d.getWidth() / 3) && inX < (int)(2 * d.getWidth() / 3) &&
                inY > (int)(d.getHeight() / 3) && inY < (int)(2 * d.getHeight() / 3)) {
            // 1, 1
            this.x = (int)(d.getWidth() / 3) + 10;
            this.y = (int)(d.getHeight() / 3) + 4;

            this.row = 1;
            this.col = 1;
        }
        else if(inX > (int)(2* d.getWidth() / 3) && inX < (int)(d.getWidth()) &&
                inY > (int)(d.getHeight() / 3) && inY < (int)(2* d.getHeight() / 3)) {
            // 1, 2
            this.x = (int)(2* d.getWidth() / 3) + 10;
            this.y = (int)(d.getHeight() / 3) + 4;

            this.row = 1;
            this.col = 2;
        }
        else if(inX < (int)(d.getWidth() / 3) && inX > 0 &&
                inY > (int)(2 * d.getHeight() / 3) && inY < (int)(d.getHeight())) {
            // 2, 0
            this.x = 0 + 10;
            this.y = (int)(2* d.getHeight() / 3) + 4;

            this.row = 2;
            this.col = 0;
        }
        else if(inX > (int)(d.getWidth() / 3) && inX < (int)(2 * d.getWidth() / 3) &&
                inY > (int)(2* d.getHeight() / 3) && inY < (int)(d.getHeight())) {
            // 2, 1
            this.x = (int)(d.getWidth() / 3) + 10;
            this.y = (int)(2* d.getHeight() / 3) + 4;

            this.row = 2;
            this.col = 1;
        }
        else if(inX > (int)(2 * d.getWidth() / 3) && inX < (int)(d.getWidth()) &&
                inY > (int)(2 * d.getHeight() / 3) && inY < (int)(d.getHeight())) {
            // 2, 2
            this.x = (int)(2* d.getWidth() / 3) + 10;
            this.y = (int)(2* d.getHeight() / 3) + 4;

            this.row = 2;
            this.col = 2;
        }
        else {
            this.x = 0;
            this.y = 0;

            this.row = 0;
            this.col = 0;
        }
    }



}
