package football;

import java.util.*;
import java.util.Scanner;

class MemberPlayerHandler {

    private List<MemberPlayer> memberPlayerList = new ArrayList<>();
    private List<MemberPlayer> currentList = new ArrayList<>();

    void initMemberPlayerList()
    {
        Scanner input = new Scanner(FileHandling.readFile("src/football/playerList.txt"));
        while (input.hasNextLine())
        {
            String fileLine = input.nextLine();
            String[] components = fileLine.split(",");
            int age = Integer.parseInt(components[2]);
            int team = Integer.parseInt(components[3]);
            memberPlayerList.add(new MemberPlayer(components[0],components[1],age,team));
        }
    }

    void saveMemberPlayerList()
    {
        String newDataString = memberPlayerList.get(0).getFirstName() + "," +  memberPlayerList.get(0).getLastName() + "," + memberPlayerList.get(0).getAge() + "," +  memberPlayerList.get(0).getTeam();
        for (int i=1; i<memberPlayerList.size(); i++)
        {
            newDataString += "\n" + memberPlayerList.get(i).getFirstName() + "," +  memberPlayerList.get(i).getLastName() + "," + memberPlayerList.get(i).getAge() + "," +  memberPlayerList.get(i).getTeam();
        }
        FileHandling.writeFile(newDataString,"src/football/playerList.txt");
    }

    void addMemberPlayer(String firstName,String lastName,int age,int team) {
        memberPlayerList.add(new MemberPlayer(firstName,lastName,age,team));
    }

    boolean deleteMemberPlayer(String firstName, String lastName) {
        int indexToDelete = -1;
        for (MemberPlayer person : memberPlayerList) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                indexToDelete = memberPlayerList.indexOf(person);
            }
        }
        if (indexToDelete > 0) {
            memberPlayerList.remove(indexToDelete);
            return true;
        }
        else return false;
    }

    void searchTeam(int teamNumber) {
        currentList.clear();
        for (MemberPlayer person : memberPlayerList) {
            System.out.print("-");
            if (person.getTeam() == teamNumber) {
                currentList.add(person);
            }
        }
    }

    void searchAge(int fromAge,int toAge) {
        currentList.clear();
        for (MemberPlayer person : memberPlayerList) {
            if (person.getAge() >= fromAge && person.getAge() <= toAge) {
                currentList.add(person);
            }
        }
    }

    void searchName(String firstName, String lastName) {
        currentList.clear();
        for (MemberPlayer person : memberPlayerList) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                currentList.add(person);
            }
        }
    }

    void selectAllMemberPlayers() {
        currentList = memberPlayerList;
    }

    int getCurrentListSize() {
        return currentList.size();
    }

    private void sortListBy(int sortChoice) {
        if (sortChoice == 1) {
            currentList.sort(Comparator.comparing(MemberPlayer::getFirstName));
        }
        else if (sortChoice == 2) {
            currentList.sort(Comparator.comparing(MemberPlayer::getLastName));
        }
        else if (sortChoice == 3) {
            currentList.sort(Comparator.comparing(MemberPlayer::getAge));
        }
        else if (sortChoice == 4) {
            currentList.sort(Comparator.comparing(MemberPlayer::getTeam));
        }
    }

    void printCurrentList(int sortChoice, String headline) {
        sortListBy(sortChoice);
        System.out.println(headline);
        System.out.println("--------------------------------------------------");
        System.out.println(String.format("%-20s%-20s%5s%5s","First Name","Last Name","Age","Team"));
        System.out.println("--------------------------------------------------");
        for (MemberPlayer person : currentList) {
            System.out.println(person.toString());
        }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }
}
