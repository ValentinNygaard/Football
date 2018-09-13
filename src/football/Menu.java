package football;

class Menu {

    static void userMenu() {
        MemberPlayerHandler mph = new MemberPlayerHandler();
        mph.initMemberPlayerList();

        int menuChoice;
        int minAge;
        int maxAge;
        int age;
        int team;
        String firstName;
        String lastName;

        System.out.println();
        System.out.println("WELCOME TO THE FOOTBALL CLUB SYSTEM");
        System.out.println("--------------------------------------------------");
        System.out.println();
        boolean exitSystem = false;
        do {
            System.out.println("MENU");
            System.out.println("--------------------------------------------------");
            System.out.println(" 0 - Exit system");
            System.out.println(" 1 - Show all members/players sorted by first name");
            System.out.println(" 2 - Show all members/players sorted by last name");
            System.out.println(" 3 - Show all members/players sorted by age");
            System.out.println(" 4 - Show all members/players sorted by team");
            System.out.println(" 5 - Show all members/players from team 1");
            System.out.println(" 6 - Show all members/players from team 2");
            System.out.println(" 7 - Search for members/players within a timerange");
            System.out.println(" 8 - Search for a member/player name");
            System.out.println(" 9 - Add a member/player");
            System.out.println("10 - Delete a member/player");
            System.out.println();
            System.out.print("Please select action (0-10): ");
            menuChoice = InputHandler.getInt(0,10,"Only numbers allowed - Try again: ","Out of range - Try again: ");
            System.out.println();

            if (menuChoice == 0) {
                exitSystem = true;
            }
            else if (menuChoice > 0 && menuChoice < 5) {
                mph.getAllMemberPlayers();
                String[] heading = {"NO SORTING","ALL MEMBERS/PLAYERS SORTED BY FIRST NAME","ALL MEMBERS/PLAYERS SORTED BY LAST NAME","ALL MEMBERS/PLAYERS SORTED BY AGE","ALL MEMBERS/PLAYERS SORTED BY TEAM"};
                mph.printCurrentList(menuChoice,heading[menuChoice]);
            }
            else if (menuChoice == 5) {
                mph.searchTeam(1);
                mph.printCurrentList(0,"MEMBERS/PLAYERS ON TEAM 1");
            }
            else if (menuChoice == 6) {
                mph.searchTeam(2);
                mph.printCurrentList(0,"MEMBERS/PLAYERS ON TEAM 2");
            }
            else if (menuChoice == 7) {
                System.out.print("Please specify minimum age for range (10-35): ");
                minAge = InputHandler.getInt(10,35,"Only numbers allowed - Try again: ","Out of range - Try again: ");
                System.out.print("Please specify maximum age for range (" + minAge + "-35): ");
                maxAge = InputHandler.getInt(minAge,35,"Only numbers allowed - Try again: ","Out of range - Try again: ");
                System.out.println();
                mph.searchAge(minAge,maxAge);
                mph.printCurrentList(3,"MEMBERS/PLAYERS WITHIN AGE RANGE");
            }
            else if (menuChoice == 8) {
                System.out.print("Please specify first name: ");
                firstName = InputHandler.getString();
                System.out.print("Please specify last name: ");
                lastName = InputHandler.getString();
                System.out.println();
                mph.searchName(firstName,lastName);
                mph.printCurrentList(0,"MEMBER/PLAYER WITH SPECIFIED NAME");
            }
            else if (menuChoice == 9) {
                System.out.print("Please specify first name: ");
                firstName = InputHandler.getString();
                System.out.print("Please specify last name: ");
                lastName = InputHandler.getString();
                System.out.print("Please specify age (10-35): ");
                age = InputHandler.getInt(10,35,"Only numbers allowed - Try again: ","Out of range - Try again: ");
                System.out.print("Please specify team (1 or 2): ");
                team = InputHandler.getInt(1,2,"Only numbers allowed - Try again: ","Out of range - Try again: ");
                System.out.println();
                mph.addMemberPlayer(firstName,lastName,age,team);
                System.out.println("A new player have been added to the system");
                System.out.println();
            }
            else if (menuChoice == 10) {
                System.out.print("Please specify first name: ");
                firstName = InputHandler.getString();
                System.out.print("Please specify last name: ");
                lastName = InputHandler.getString();
                System.out.println();
                boolean isDeleted = mph.deleteMemberPlayer(firstName,lastName);
                if (isDeleted) {
                    System.out.println("A player have been deleted from the system");
                    System.out.println();
                }
                else {
                    System.out.println("No player with that name found - none was deleted from the system");
                    System.out.println();
                }
            }
        }
        while (!exitSystem);

        mph.saveMemberPlayerList();
        System.out.println();
        System.out.println("SAVING CHANGES TO MEMBERS/PLAYERS AND EXITING SYSTEM");
        System.out.println();
    }
}
