import java.util.ArrayList;

public class Game {

    private int level;
    private int attempt;
    Category category;
    Player player;

    public Game( Category category, Player player) {
        this.level = 0;
        this.attempt = 10;
        this.category = category;
        this.player = player;
    }
    public Game(Player player) {
        this.level = 0;
        this.attempt = 10;
        this.player = player;
    }

    public Game() {
        this.level = 0;
        this.attempt = 10;
    }

    public int getLevel() {
        return level;
    }

    public int getAttempt() {
        return attempt;
    }

    public Category getCategory() {
        return category;
    }

    public Player getPlayer() {
        return player;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String dashesPrinter(String str){
        String str2="";
        for(int i=0;i<(str.length());i++){
            if(str.charAt(i)==' '){
                str2+=" ";
            }
            else
                str2+="-";
        }
        return str2;
    }

    public void arrayListPrinter(ArrayList<String> arrayList){
        for(int i=0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
    }

    public void arrayCharPrinter(char[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public ArrayList<String> arrayReducer(ArrayList<String> arr, char st){
        for(int i=0;i<arr.size();i++){
            if (arr.get(i).charAt(0)==st){
                arr.remove(i);
            }
        }
        return arr;
    }
    public boolean letterChecker(Game g,char [] playerWordArray,char playerLetter,char [] dashedWord){
        for(int j=0;j<playerWordArray.length;j++){
            if(playerLetter==playerWordArray[j]) {
                dashedWord[j]=playerLetter;
                //check the other letters
                for(int i=j;i<playerWordArray.length;i++){
                    if(playerLetter==playerWordArray[i]) {
                        dashedWord[i]=playerLetter;
                    }
                }
                return true;
            }
        }
        //g.setAttempt((g.getAttempt()-1));
        return false;
    }

    public boolean dashChecker(char [] playerWordArray){
        for(int i=0;i<playerWordArray.length;i++){
            if(playerWordArray[i]=='-'){
                return true;
            }

        }
        return false;
    }


    public void printHangMan(int attempt){
        System.out.println("");
        System.out.println("******** You have now ("+attempt+") lives ********");

        if(attempt==9){
            System.out.println
                    (       "\n|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }

        else if (attempt==8){
            System.out.println

                    (       "\n  |   \n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");


        }
        else if (attempt==7){
            System.out.println
                    (
                            "\n  | \n" +
                            "  | \n" +
                            "  | \n" +
                            "  | \n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }
        else if (attempt==6){
            System.out.println
                    ("\n  ________\n" +
                            "  |  \n" +
                            "  |  \n" +
                            "  |  \n" +
                            "  |  \n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }
        else if (attempt==5){
            System.out.println
                    ("\n  ________\n" +
                            "  |    || \n" +
                            "  | \n" +
                            "  | \n" +
                            "  | \n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }
        else if (attempt==4){
            System.out.println
                    ("\n  ________\n" +
                            "  |    || \n" +
                            "  |    () \n" +
                            "  | \n" +
                            "  | \n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }else if (attempt==3){
            System.out.println
                    ("\n  ________\n" +
                            "  |    || \n" +
                            "  |    () \n" +
                            "  |    || \n" +
                            "  | \n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }
        else if (attempt==2){
            System.out.println
                    ("\n  ________\n" +
                            "  |    || \n" +
                            "  |    () \n" +
                            "  |   /||\\ \n" +
                            "  |   \n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }
        else if (attempt==1){
            System.out.println
                    ("\n  ________\n" +
                            "  |    || \n" +
                            "  |    () \n" +
                            "  |   /||\\ \n" +
                            "  |    ||\n" +
                            "  | \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");

        }
        else if (attempt==0){
            System.out.println
                    ("****GAME OVER****" +
                            "\n  ________\n" +
                            "  |    || \n" +
                            "  |   (**)      \n" +
                            "  |   /||\\ \n" +
                            "  |    ||\n" +
                            "  |    /\\ \n" +
                            " _|_\n" +
                            "|   |______\n" +
                            "|          |\n" +
                            "|__________|");
        }
        System.out.println("");
    }


}
