package session6_inheritance.homeworks.movable_point_pack;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {}

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.setXSpeed(xSpeed);
        this.setYSpeed(ySpeed);
    }

    public float[] getSpeed() {
        float[] sp = new float[2];
        sp[0] = getXSpeed();
        sp[1] = getYSpeed();
        return sp;
    }

    @Override
    public String toString() {
        return "Point (" + getX() + ", " + getY() + "), "
                + "Speed (" + getXSpeed() + ", " + getYSpeed() + ")";
    }

    public MovablePoint move(){
        float x = getX() + getXSpeed();
        float y = getY() + getYSpeed();
        this.setXY(x, y);
        return this;
    }
}
