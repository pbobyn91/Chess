package Models;

public class Position {
    int x_pos;
    int y_pos;

    public Position(int x_pos, int y_pos) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    int get_x(){
        return this.x_pos;
    }

    int get_y(){
        return this.y_pos;
    }

    void set_x(int x_pos){
        this.x_pos = x_pos;
    }

    void set_y(int y_pos){
        this.y_pos = y_pos;
    }

    void move(int x_pos, int y_pos){
        this.set_x(x_pos);
        this.set_y(y_pos);
    }
}
