package main.java.balancebots;

public class Bot {
	public String lowType;
    public int lowId;

    public String highType;
    public int highId;

    public Integer a;
    public Integer b;

    public Bot(String lowType, int lowId, String highType, int highId) {
        this.lowType = lowType;
        this.lowId = lowId;

        this.highType = highType;
        this.highId = highId;
    }

    public void Add(int value) {
        if (a == null) {
            a = value;
        } else if (b == null) {
            b = value;
        }
    }

    public boolean Ready() {
        return a != null && b != null;
    }

    public Integer Low() {
        if (a <= b) {
            return a;
        }
        return b;
    }

    public Integer High() {
        if (a > b) {
            return a;
        }
        return b;
    }
}
