import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static ArrayList<Toys> game = new ArrayList<>();
    public static int probability= 15;//меньше 100,чтобы можно было быстрее проверить выпадаемость игрушек
    public static Random random= new Random();
    public static ArrayList<Toys> vinList= new ArrayList<>();
    public static int count = 1; //для расчета id
    public static int countToAddToys=3; //посколько игрушек добавляем
    public static int countOfTab=1;

    public static void main(String[] args) {
        generateGame(game).forEach(n-> System.out.println(n.toString())); //сформирован первоначальный набор игрушек
        System.out.println("-----");
        int countOfVinToys=random.nextInt(1, game.size()/2);
        System.out.println("Количество игрушек к выиграшу: "+countOfVinToys);

        int b=game.size()-countToAddToys;

        while (vinList.size()!=countOfVinToys){
            vinToy(game, vinList);
            if (game.size()==b){
                addToys(game);
                System.out.println("-----"); //чтобы видеть когда и какие игрушки добавлены
            }
        }
        vinListMethod();

        System.out.println("-----\n Оставшиеся игрушки");
        game.forEach(n-> System.out.println(n.toString()));

    }

    // создание первоначального набора игрушек
    static ArrayList<Toys> generateGame (ArrayList<Toys> game){

        for (int i = 0; i < 5; i++) {
            game.add(new Bear(count, random.nextInt(1,probability)));
            count++;
            game.add(new Cat(count, random.nextInt(1,probability)));
            count++;
            game.add(new Mouse(count, random.nextInt(1,probability)));
            count++;
        }

        return game;
    }


    // дозаполнение автомата с игрушками
    static ArrayList<Toys> addToys (ArrayList<Toys> game){
        for (int i = 1; i <= countToAddToys; i++) {
            int rand = random.nextInt(1, 3);
            switch (rand) {
                case 1:
                    game.add(new Mouse(count, probability));
                    count++;
                    break;
                case 2:
                    game.add(new Bear(count, probability));
                    count++;
                    break;
                case 3:
                    game.add(new Cat(count, probability));
                    count++;
                    break;
            }
        }
        return game;
    }


//     определение выигрышной игрушки по вероятности выпадения
    static Toys vinToy(ArrayList<Toys> game, ArrayList<Toys> vinList){
        Toys a = game.get(0);
        int minProbability=a.probabilty_toy;
        for (int i = 1; i < game.size(); i++) {
            if (game.get(i).probabilty_toy < a.probabilty_toy) {
                minProbability = game.get(i).probabilty_toy;
                a=game.get(i);
            }
        }
        System.out.println(a);
        vinList.add(a);
        game.remove(a);
        return a;
    }


    // запись призовых игрушек в файл
    public static void vinListMethod(){
        String filePathForWrite = "ListOfVinnedToy.txt";
        try {
            writeToFile(filePathForWrite, vinList);
        }
        catch (FileNotFoundException e){
            System.out.println("не удалось считать файл");

        }
        catch (IOException e){
            System.out.println("не удалось записать файл");
        }
    }

    public static void writeToFile(String filePath, ArrayList<Toys> vinList) throws IOException {
        try (FileWriter writer=new FileWriter(filePath)){
            for (Toys toys: vinList){
                writer.write(toys.toString());
                writer.write("\n");
            }
        }
        System.out.println("Cписок выигранных игрушек сформирован успешно");
    }



}
