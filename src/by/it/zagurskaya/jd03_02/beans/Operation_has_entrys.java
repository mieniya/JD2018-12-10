package by.it.zagurskaya.jd03_02.beans;

public class Operation_has_entrys {
    private long operation_idOperation;
    private long entry_idEntry;

    public Operation_has_entrys(){
    }

    public Operation_has_entrys(long operation_idOperation, long entry_idEntry) {
        this.operation_idOperation = operation_idOperation;
        this.entry_idEntry = entry_idEntry;
    }

    public long getOperation_idOperation() {
        return operation_idOperation;
    }

    public void setOperation_idOperation(long operation_idOperation) {
        this.operation_idOperation = operation_idOperation;
    }

    public long getEntry_idEntry() {
        return entry_idEntry;
    }

    public void setEntry_idEntry(long entry_idEntry) {
        this.entry_idEntry = entry_idEntry;
    }

    @Override
    public String toString() {
        return "Operation_has_entrys{" +
                "operation_idOperation=" + operation_idOperation +
                ", entry_idEntry=" + entry_idEntry +
                '}';
    }
}
