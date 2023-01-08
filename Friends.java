import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 * Friends
 */
public class Friends {

    public static void main(String[] args) {
        System.out.println("Welcome! Please enter your friends' first name."
        + "Press \"d\" when you are done.");
        boolean entering = true;
        Scanner scan = new Scanner(System.in);
        ArrayList<Friend> list = new ArrayList<Friend>();
        while(entering){
            String line = scan.nextLine();
            if(line.equals("d")){
                entering = false;
            }else{
                Friend s = new Friend(line);
                list.add(s);
            }
        }
        System.out.println();
        System.out.println("You have entered " + list.size() + " friends.");
        System.out.println("Here is your list of friends:");
        for(int x = 0; x < list.size(); x++){
            System.out.println((x+1) + ". " + list.get(x).getName());
        }
        System.out.println();
        System.out.println("The two friends that have been randomly chosen"
        + " to go to the movies with you are ...");
        Random rand = new Random();
        int r1 = rand.nextInt(list.size());
        int r2 = rand.nextInt(list.size());
        while(r2 == r1){
            r2 = rand.nextInt(list.size());
        }
        System.out.println(list.get(r1).getName());
        System.out.println(list.get(r2).getName());

        System.out.println("Which friends would you like to take off your" 
        +" friend list and add to your best friend list? (Indicate with the" 
        +" number next to each name. Press \"0\" to end)");

        entering = true;

        while(entering){
            int ent = Integer.parseInt(scan.nextLine());
            if(ent == 0){
                entering = false;
            }else{
                list.get(ent-1).setBF(true);
            }
        }
        System.out.println();
        System.out.println("Here is your list of friends:");
        int z  = 1;
        for(int x = 0; x < list.size(); x++){
            if(!list.get(x).getBF()){
                System.out.println(z + ". " + list.get(x).getName());
                z++;
            }
        }
        System.out.println();

        System.out.println("Here is your list of best friends:");
        int p  = 1;
        for(int x = 0; x < list.size(); x++){
            if(list.get(x).getBF()){
                System.out.println(p + ". " + list.get(x).getName());
                p++;
            }
        }
        System.out.println();





    }
}

class Friend{
    private String name;
    private Boolean bestFriend;
    public Friend(){
        name = "Bob";
        bestFriend = false;
    }
    public Friend(String n){
        name = n;
        bestFriend = false;
    }
    public boolean getBF(){
        return bestFriend;
    }
    public void setBF(boolean bf){
        bestFriend = bf;
    }
    public String getName(){
        return name;
    }
}