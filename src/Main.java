import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        Hero hr = new Hero();
        Card item = new Item();
        item.action(hr);
        while(true) {
            System.out.println("Hero level: " +  hr.getLevel());
            System.out.println("Hero equipment:");
            System.out.println("\tSword:" + hr.getEquipment(0));
            System.out.println("\tHead:" + hr.getEquipment(1));
            System.out.println("\tBody:" + hr.getEquipment(2));
            System.out.println("\tFeet:" + hr.getEquipment(3));
            System.out.println("Hero power: " +  hr.getPower());
            System.out.println();

            System.out.println("(1) Open door.");
            System.out.println("(0) Exit game.");
            ch = sc.nextInt();
            if(ch == 0)
                break;

            int door =(int) (Math.random()*100)%2;

            switch (door) {
                case 0:
                    Card monster = new Monster();
                    monster.action(hr);
                break;

                case 1:
                    Card bane = new Bane();
                    bane.action(hr);
                break;
            }

            if(hr.getLevel() == 10) {
                System.out.println("You win!");
                break;
            }
        }
    }
}
