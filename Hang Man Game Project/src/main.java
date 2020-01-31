import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner read = new Scanner(System.in);
        String playerWord,playerCategory;
        char playerLetter, dashedWord[];
        int level,attempts=10,r;
        ArrayList<String> passedWorld = new ArrayList<String>();
        ArrayList<String> Alphabets = new ArrayList<String>();

        ArrayList<String> sportsList = new ArrayList<String>();
        ArrayList<String> healthList = new ArrayList<String>();
        ArrayList<String> technologyList = new ArrayList<String>();

        //Assigning ArrayLists values
        sportsList.add("arena");sportsList.add("arrow"); sportsList.add("baseball"); sportsList.add("basketball"); sportsList.add("gear"); sportsList.add("handball"); sportsList.add("halftime"); sportsList.add("hockey"); sportsList.add("horse racing"); sportsList.add("jogging"); sportsList.add("motorcycle"); sportsList.add("racing"); sportsList.add("tennis"); sportsList.add("world cup"); sportsList.add("championship");sportsList.add("martial arts");
        healthList.add("lungs");healthList.add("dental");healthList.add("skeleton");healthList.add("heart");healthList.add("digestive system");healthList.add("eye");healthList.add("anatomy");healthList.add("nervous");healthList.add("skin");healthList.add("Organ");healthList.add("urinary");healthList.add("breathe");healthList.add("brain");healthList.add("aorta");healthList.add("septum");healthList.add("physical therapy");
        technologyList.add("software");technologyList.add("bandwidth");technologyList.add("bit");technologyList.add("cache");technologyList.add("browser");technologyList.add("cloud computing");technologyList.add("cyber crime");technologyList.add("cyber security");technologyList.add("domain");technologyList.add("ethernet");technologyList.add("firewall");technologyList.add("html");technologyList.add("internet");technologyList.add("java");technologyList.add("modem");technologyList.add("operating system");

        //Creating 3 Categories
        Category sportsCategory=new Category(sportsList);
        Category healthCategory=new Category(healthList);
        Category technologyCategory=new Category(technologyList);
        Player player = new Player();

        //First User Choice
        System.out.println("Do you want to start? (y/n)");
        String userChoice= read.nextLine();

        while (userChoice.contentEquals("y")==true){
            //Second User Choice
            System.out.println("Type (1) to view the rules of the game.");
            System.out.println("Type (2) to start a new Game.");
            System.out.println("Type (3) to load a saved game.");
            System.out.println("Type (4) to exit");
            int user2ndChoice= read.nextInt();

            if (user2ndChoice==1){
                //The rules of the game
                System.out.println("First of all, you are only supposed to use SMALL LETTERS in here. You should start by choosing a category. Each category contains a bank of words. For each category\n" +
                        "you will be required to answer 5 questions. Each question represents a level. Secondly, the key to winning the game\n" +
                        "is to reach (Level 5 or Question 5); and answering all levels correctly. Finally, Once you get “hung” at any level\n" +
                        "and that means 10 false attempts during the game, you will automatically lose the game.\n");
            }
            else if (user2ndChoice==2) {
                //Here is the code of new game
                //Setting Player Values
                System.out.println("Enter your User Name");
                player.setUserName(read.next());
                System.out.println("Enter your password (Only Numbers)");
                player.setPassword(read.nextInt());
                System.out.println("Choose a category: (1) Sports.\t(2) Health.\t(3) Technology.");
                playerCategory=read.next();

                if (playerCategory.contentEquals("1") == true) {
                    Game game=new Game(sportsCategory,player);
                    //game.category.setList(sportsCategory.getList());
                    //Starting with level 1
                    for(level=0;level<5;level++){
                        Alphabets.clear();
                        Alphabets.add("a"); Alphabets.add("b"); Alphabets.add("c");Alphabets.add("d");Alphabets.add("e");Alphabets.add("f");Alphabets.add("g");Alphabets.add("h");Alphabets.add("i");Alphabets.add("j");Alphabets.add("k");Alphabets.add("l");Alphabets.add("m");Alphabets.add("n");Alphabets.add("o");Alphabets.add("p");Alphabets.add("q");Alphabets.add("r");Alphabets.add("s");Alphabets.add("t");Alphabets.add("u");Alphabets.add("v");Alphabets.add("w");Alphabets.add("x");Alphabets.add("y");Alphabets.add("z");

                        r = random.nextInt((sportsCategory.getList().size()-1));
                        playerWord=game.getCategory().getList().get((r+1));
                        System.out.println("This is level ("+(level+1)+"):");

                        //Preventing Duplication of a word in the list
                        for (int i=0;i<passedWorld.size();i++){
                            if(passedWorld.get(i)==playerWord){
                                r = random.nextInt((sportsCategory.getList().size()-1));
                                playerWord=game.getCategory().getList().get((r+1));
                                i=0;
                            }
                        }
                        passedWorld.add(playerWord);

                        //printing the world with dashes
                        dashedWord=game.dashesPrinter(playerWord).toCharArray();
                        System.out.println("playerWord: "+playerWord);
                        char[] playerWordArray=playerWord.toCharArray();
                        System.out.println();

                            //Starting with attempts 10
                            for(;game.getAttempt()>0;){
                            //Asking the player to enter a letter
                            System.out.println("Choose one of these letters:");
                            game.arrayListPrinter(Alphabets);
                            game.arrayCharPrinter(dashedWord);

                            playerLetter=read.next().charAt(0);

                            //Check if the player entered a correct letter or not(boolean)
                            boolean attemptsTemp=game.letterChecker(game,playerWordArray,playerLetter,dashedWord);

                            //if not correct then print hangman and reduce the chances
                            if(attemptsTemp !=true){
                                game.setAttempt(game.getAttempt()-1);
                                game.printHangMan(game.getAttempt());
                            }

                            //check if there is no dashes then stop and go to the upper level
                            if(game.dashChecker(dashedWord)==false){
                                break;
                            }

                            //remove the letter entered by the user
                            game.arrayReducer(Alphabets, playerLetter);

                        }
                        System.out.println("********");
                            //to stop if the player lost
                            if(game.getAttempt()==0){
                                break;
                            }
                    }
                    System.out.println("********You Won! Congrats ("+game.player.getUserName()+")********");

                }

                else if (playerCategory.contentEquals("2") == true) {

                    Game game=new Game(healthCategory,player);
                    //game.category.setList(healthCategory.getList());
                    //Starting with level 1
                    for(level=0;level<5;level++){
                        r = random.nextInt((healthCategory.getList().size()-1));
                        playerWord=game.getCategory().getList().get((r+1));
                        System.out.println("This is level ("+(level+1)+"):");

                        //Preventing Duplication of a word in the list
                        for (int i=0;i<passedWorld.size();i++){
                            if(passedWorld.get(i)==playerWord){
                                r = random.nextInt((healthCategory.getList().size()-1));
                                playerWord=game.getCategory().getList().get((r+1));
                                i=0;
                            }
                        }
                        passedWorld.add(playerWord);

                        //printing the world with dashes
                        dashedWord=game.dashesPrinter(playerWord).toCharArray();
                        System.out.println("playerWord: "+playerWord);
                        char[] playerWordArray=playerWord.toCharArray();
                        System.out.println();

                        //Starting with attempts 10
                        for(;game.getAttempt()>0;){
                            //Asking the player to enter a letter
                            System.out.println("Choose one of these letters:");
                            game.arrayListPrinter(Alphabets);
                            game.arrayCharPrinter(dashedWord);

                            playerLetter=read.next().charAt(0);

                            //Check if the player entered a correct letter or not(boolean)
                            boolean attemptsTemp=game.letterChecker(game,playerWordArray,playerLetter,dashedWord);

                            //if not correct then print hangman and reduce the chances
                            if(attemptsTemp !=true){
                                game.setAttempt(game.getAttempt()-1);
                                game.printHangMan(game.getAttempt());
                            }

                            //check if there is no dashes then stop and go to the upper level
                            if(game.dashChecker(dashedWord)==false){
                                break;
                            }

                            //remove the letter entered by the user
                            game.arrayReducer(Alphabets, playerLetter);

                        }
                        System.out.println("********");
                        //to stop if the player lost
                        if(game.getAttempt()==0){
                            break;
                        }
                    }

                    System.out.println("********You Won! Congrats ("+game.player.getUserName()+")********");

                }

                else if (playerCategory.contentEquals("3") == true) {
                    Game game=new Game(technologyCategory,player);
                    //game.category.setList(technologyCategory.getList());
                    //Starting with level 1
                    for(level=0;level<5;level++){
                        r = random.nextInt((technologyCategory.getList().size()-1));
                        playerWord=game.getCategory().getList().get((r+1));
                        System.out.println("This is level ("+(level+1)+"):");

                        //Preventing Duplication of a word in the list
                        for (int i=0;i<passedWorld.size();i++){
                            if(passedWorld.get(i)==playerWord){
                                r = random.nextInt((technologyCategory.getList().size()-1));
                                playerWord=game.getCategory().getList().get((r+1));
                                i=0;
                            }
                        }
                        passedWorld.add(playerWord);

                        //printing the world with dashes
                        dashedWord=game.dashesPrinter(playerWord).toCharArray();
                        //System.out.println("playerWord: "+playerWord);
                        char[] playerWordArray=playerWord.toCharArray();

                        System.out.println();

                        //Starting with attempts 10
                        for(;game.getAttempt()>0;){
                            //Asking the player to enter a letter
                            System.out.println("Choose one of these letters:");
                            game.arrayListPrinter(Alphabets);
                            game.arrayCharPrinter(dashedWord);

                            playerLetter=read.next().charAt(0);

                            //Check if the player entered a correct letter or not(boolean)
                            boolean attemptsTemp=game.letterChecker(game,playerWordArray,playerLetter,dashedWord);

                            //if not correct then print hangman and reduce the chances
                            if(attemptsTemp !=true){
                                game.setAttempt(game.getAttempt()-1);
                                game.printHangMan(game.getAttempt());
                            }

                            //check if there is no dashes then stop and go to the upper level
                            if(game.dashChecker(dashedWord)==false){
                                break;
                            }

                            //remove the letter entered by the user
                            game.arrayReducer(Alphabets, playerLetter);
                        }
                        System.out.println("********");
                        //to stop if the player lost
                        if(game.getAttempt()==0){
                            break;
                        }
                    }
                    System.out.println("********You Won! Congrats ("+game.player.getUserName()+")********");

                }

            }

            else if (user2ndChoice==3) {
                //Here is the code of loading a game
                //Not Done
            }

            else if(user2ndChoice==4) {
                System.out.println("You are out!");
                break;
            }
            else
            {
                System.out.println("You entered a wrong value!");
                break;
            }
        }
    }
}