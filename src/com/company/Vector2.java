package com.company;

public class Vector2 {

    private float x;
    private float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2()
    {
        setX(0);
        setY(0);
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float Distance(Vector2 pValue)
    {
        return (float)Math.sqrt((Math.pow(pValue.x - this.x,2)+Math.pow(pValue.y -this.y,2)));
    }
}
