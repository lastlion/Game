public interface Card {
    int action();
}

class Monster implements Card {
    private int level;

    Monster() {
        level = 0;
        level = (int)(Math.random()*100)%10+1;
    }

    public int action() {
        return level;
    }
}

class Bane implements Card {
    private int bane;

    Bane() {
        bane = 0;
        bane = (int)(Math.random()*100)%3+1;
        if(bane > 0)
            bane *= (-1);
    }

    public int action() {
        return bane;
    }
}

class Bonus implements Card {
    private int bonus;

    Bonus() {
        bonus = 1;
    }

    public int action() {
        return bonus;
    }
}

class Item implements Card {
    private int type;
    private int value;

    Item() {
        type = 0;
        value = 0;
        type = (int)(Math.random()*100)%4;
        value = (int)(Math.random()*100)%3+1;
    }
     public int action() {
         return value;
     }

    public int getType() {
        return type;
    }
}