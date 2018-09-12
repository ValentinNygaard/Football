package football;

import java.util.*;
import java.util.Scanner;

public class MemberPlayerHandler {

    ArrayList memberPlayerList = new ArrayList<>();

    void initMemberPlayerList()
    {
        FileHandling file = new FileHandling();
        Scanner input = new Scanner(file.readFile("src/football/playerList.txt"));
        while (input.hasNextLine())
        {
            String fileLine = input.nextLine();
            String[] components = fileLine.split(",");
            int age = Integer.parseInt(components[2]);
            int team = Integer.parseInt(components[3]);
            memberPlayerList.add(new MemberPlayer(components[0],components[1],age,team));
        }
    }

    void printMemberPlayerList() {
        for (int j=0; j < 20; j++) {
            System.out.println(memberPlayerList.get(j).toString());
        }
    }


}
