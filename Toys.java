import java.util.Random;

abstract public class Toys {
    Random random = new Random(100);
    public int id_toy;
    public String name_toy;
    public int count_toy;
    public int probabilty_toy;

//    public Toys ()

    public Toys(int id_toy, String name_toy, int count_toy, int probabilty_toy){
        this.id_toy=id_toy;
        this.name_toy=name_toy;
        this.count_toy=count_toy;
        this.probabilty_toy=probabilty_toy;
    }

//    public int generateProbability (){
//        probabilty_toy=random.nextInt(1,101);
//        return probabilty_toy;
//    }

}
