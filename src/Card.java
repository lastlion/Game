public interface Card {
    Hero action(Hero hr);
}

class Monster implements Card {
    private int level;

    Monster() {
        level = 0;
        level = (int)(Math.random()*100)%10+1;
    }

    public Hero action(Hero hr) {
        if(hr.getPower() < level){
            int cha = (int)(Math.random()*10)%2;
            if(cha == 0)
                hr.changeLevel(-1);
            else
                hr.changeLevel(1);
            }

        if(hr.getPower() >= level) {
            hr.changeLevel(1);
            int bonus = (int)(Math.random()*10)%2;
            switch (bonus) {
                case 0:
                    if(hr.getLevel()<9) {
                        Card prise = new Bonus();
                        hr = prise.action(hr);
                    }
                break;

                case 1:
                    if(hr.getLevel()<10) {
                        Card item = new Item();
                        hr =  item.action(hr);
                    }
                break;
            }
        }

        return hr;
    }
}

class Bane implements Card {
    int bane;

    Bane() {
        bane = (int)(Math.random()*10)%5;
    }

    public Hero action(Hero hr) {
        if(bane == 4)
            if(hr.getLevel() != 1)
                hr.changeLevel(-1);
        else
            hr.changeEquipment(bane, 0);

        return hr;
    }
}

class Bonus implements Card {
    public Hero action(Hero hr) {
        hr.changeLevel(1);
        return hr;
    }
}

class Item implements Card {
    private int type;
    private int value;

    Item() {
        type = 0;
        value = 0;
        type = (int)(Math.random()*10)%4;
        value = (int)(Math.random()*10)%3+1;
    }
     public Hero action(Hero hr) {
         if(hr.getEquipment(type)<value)
            hr.changeEquipment(type, value);
         return hr;
     }
}