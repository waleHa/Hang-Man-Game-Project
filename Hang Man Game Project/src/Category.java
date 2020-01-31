import java.util.ArrayList;

public class Category {
    private ArrayList<String> list;

    public Category() {
    }

    public Category(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
