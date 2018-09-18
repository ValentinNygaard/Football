package football;

import java.util.*;
import java.util.Scanner;

class MemberPlayerHandler {

    private List<MemberPlayer> memberPlayerList = new LinkedList<MemberPlayer>();
    private List<MemberPlayer> currentList = new ArrayList<MemberPlayer>();

    void initMemberPlayerList() {
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

    void saveMemberPlayerList() {
        StringBuilder sb = new StringBuilder();
        for (MemberPlayer person : memberPlayerList) {
            sb.append(person.toFileString());
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        FileHandling.writeFile(sb.toString(),"src/football/playerList.txt");
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
        if (indexToDelete >= 0) {
            memberPlayerList.remove(indexToDelete);
            return true;
        }
        else return false;
    }

    void searchTeam(int teamNumber) {
        currentList.clear();
        for (MemberPlayer person : memberPlayerList) {
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
        //currentList.addAll(memberPlayerList);
        currentList.clear();
        for (MemberPlayer person : memberPlayerList) {
            currentList.add(person);
        }
    }

    int getCurrentListSize() {
        return currentList.size();
    }

    void sortListBy(int sortChoice) {
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

    String currentToString() {
        StringBuilder sb = new StringBuilder();
        for (MemberPlayer person : currentList) {
            sb.append(person.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
