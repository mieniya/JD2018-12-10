package by.it.dziomin.jd01_08;

abstract class Var implements Operation{

   public abstract String toString();

   @Override
   public Var add(Var other) {
      System.out.println("Сложение "+ this+ " с " +other+" невозможно!");
      return null;
   }

   @Override
   public Var sub(Var other) {
      System.out.println("Вычитание "+ this+ " с " +other+" невозможно!");
      return null;
   }

   @Override
   public Var mul(Var other) {
      System.out.println("Умножение "+ this+ " с " +other+" невозможно!");
      return null;
   }

   @Override
   public Var div(Var other) {
      System.out.println("Деление "+ this+ " с " +other+" невозможно!");
      return null;
   }
}
