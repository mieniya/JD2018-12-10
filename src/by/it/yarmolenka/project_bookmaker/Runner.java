package by.it.yarmolenka.project_bookmaker;

public class Runner {
    public static void main(String[] args) {
        DatabaseCreator creator = new DatabaseCreator();
        DatabaseFulfill fullfiller = new DatabaseFulfill();
        creator.create();
        fullfiller.fulfill();
    }
}
