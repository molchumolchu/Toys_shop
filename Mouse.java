public class Mouse extends Toys{
    public Mouse(int id_toy, int probabilty_toy) {
        super(id_toy, "Mouse", 5, probabilty_toy);
    }

    @Override
    public String toString() {
        return "ID: "+ id_toy+"; Наименование: " +name_toy+"; Количество: "+count_toy+"; Вероятность выпадения 1/"+probabilty_toy;
    }
}
