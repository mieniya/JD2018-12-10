package by.it.zagurskaya.jd03_02.beans;

public class SprOperations {
    private long idOperation;
    private String nameOperation;
    private String printForm;
    private String skreanForm;
    private String specification;

    public SprOperations() {
    }

    public SprOperations(long idOperation, String nameOperation, String printForm, String skreanForm, String specification) {
        this.idOperation = idOperation;
        this.nameOperation = nameOperation;
        this.printForm = printForm;
        this.skreanForm = skreanForm;
        this.specification = specification;
    }

    public long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(long idOperation) {
        this.idOperation = idOperation;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public void setNameOperation(String nameOperation) {
        this.nameOperation = nameOperation;
    }

    public String getPrintForm() {
        return printForm;
    }

    public void setPrintForm(String printForm) {
        this.printForm = printForm;
    }

    public String getSkreanForm() {
        return skreanForm;
    }

    public void setSkreanForm(String skreanForm) {
        this.skreanForm = skreanForm;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "SprOperations{" +
                "idOperation=" + idOperation +
                ", nameOperation='" + nameOperation + '\'' +
                ", printForm='" + printForm + '\'' +
                ", skreanForm='" + skreanForm + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}
