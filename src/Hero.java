public class Hero {
    private int level;
    private int[] equipment;
    private int power;

    Hero() {
        level = 1;
        equipment = new int[4];
        for(int i=0; i<4; i++)
            equipment[i] = 0;
        Item first = new Item();
        equipment[first.getType()] = first.action();
        power = level;
        for(int i=0; i<4; i++)
            power += equipment[i];
    }

    public void changeLevel(int value) {
        level += value;
        power += value;
    }

    public void changeEquipment(int num, int value) {
        power -= equipment[num];
        equipment[num] = value;
        power += equipment[num];
    }

    public int getLevel() {
        return level;
    }

    public int getEquipment(int num) {
        return equipment[num];
    }

    public int getPower() {
        return power;
    }
}
