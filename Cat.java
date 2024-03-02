public class Cat extends Toys{
    public Cat(int id_toy, int probabilty_toy) {
        super(id_toy, "Cat", 5, probabilty_toy);
    }

    @Override
    public String toString() {
        return "ID: "+ id_toy+"; Наименование: " +name_toy+"; Количество: "+count_toy+"; Вероятность выпадения 1/"+probabilty_toy;
    }
}
