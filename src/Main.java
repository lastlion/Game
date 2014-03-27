import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        Hero hr = new Hero();
        while(true) {
            System.out.println("Hero level: " +  hr.getLevel());
            System.out.println("Hero equipment:");
            System.out.println("\tSword:" + hr.getEquipment(0));
            System.out.println("\tHead:" + hr.getEquipment(1));
            System.out.println("\tBody:" + hr.getEquipment(2));
            System.out.println("\tFeet:" + hr.getEquipment(3));
            System.out.println("Hero power: " +  hr.getPower());

            System.out.println("(1) Open door.");
            System.out.println("(0) Exit game.");
            ch = sc.nextInt();
            if(ch == 0)
                break;

            int door =(int) (Math.random()*100)%2;

            switch (door) {
                case 0:
                    Card monster = new Monster();
                    System.out.println("Monster! Level: " + monster.action());
                    System.out.println("Fight(1) or escape(2): ");
                    int ch1 = sc.nextInt();
                    switch (ch1) {
                        case 1:
                            if(hr.getPower() < monster.action())
                                if(hr.getLevel() != 1) {
                                    hr.changeLevel(-1);
                                    System.out.println("Level down!");
                                }

                            if(hr.getPower() >= monster.action()) {
                                System.out.println("Level up!");
                                hr.changeLevel(1);
                                int bonus = (int)(Math.random()*100)%2;
                                switch (bonus) {
                                    case 0:
                                        System.out.println("Bonus level up!");
                                        Card prise = new Bonus();
                                        hr.changeLevel(prise.action());
                                    break;

                                    case 1:
                                        Item item = new Item();
                                        switch (item.getType()) {
                                            case 0:
                                                System.out.println("Sword: " + item.action());
                                            break;

                                            case 1:
                                                System.out.println("Head: " + item.action());
                                            break;

                                            case 2:
                                                System.out.println("Body: " + item.action());
                                            break;

                                            case 3:
                                                System.out.println("Feet: " + item.action());
                                            break;
                                        }

                                        int ch2;
                                        System.out.println("Do you want to equip it? (1)Yes (0)No");
                                        ch2 = sc.nextInt();
                                        if(ch2>0)
                                            hr.changeEquipment(item.getType(), item.action());
                                    break;
                                }
                            }

                        break;

                        case 2:
                            if(hr.getLevel() == 1)
                                System.out.println("You're lucky!");
                            else
                                hr.changeLevel(-1);

                        break;

                        default:
                            System.out.println("Error!");
                    }
                break;

                case 1:
                    Card bane = new Bane();
                    System.out.println("Bane!");
                    if(hr.getLevel() + bane.action() <= 0)
                        System.out.println("You're lucky!");
                    else
                        hr.changeLevel(bane.action());
                break;
            }

            if(hr.getLevel() >= 10) {
                System.out.println("You win!");
                break;
            }
        }
    }
}
