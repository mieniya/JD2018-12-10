package by.it.yarmolenka.project_bookmaker;

public class Runner {
    public static void main(String[] args) {
        DatabaseCreator creator = new DatabaseCreator();
        DatabaseFulfill fulfill = new DatabaseFulfill();
        creator.create();
        fulfill.fulfill();
    }
}
