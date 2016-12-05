import javafx.scene.Parent;

import javax.management.ObjectName;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by User on 24.11.2016.
 */
public class Main {

    static class NumComp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length())
                return o1.compareTo(o2);
            else return o2.compareTo(o1);
        }
    }

    public static void main(String[] args) {
//  Подпункт 1 задания: создание коллекции и ее сортирока
//  Создание компоратора специально сделал разными способами
        ArrayList<String> world = new ArrayList<String>();

        world.add("Германия");
        world.add("Новая Зеландия");
        world.add("Англия");
        world.add("Украина");
        world.add("Польша");
        world.add("США");
        world.add("Канада");
        world.add("Китай");
        world.add("Швеция");
        world.add("Франция");
        world.add("Шри-Ланка");
        world.add("Тайланд");
        world.add("Ямайка");

        System.out.println("Страны мира" + "\n" + world);

        world.sort(new Comp());
        System.out.println(world);

        class UComp implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }
        world.sort(new UComp());
        System.out.println(world);


        Comparator<String> NumComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return o1.compareTo(o2);
                else return o2.compareTo(o1);
            }
        };

        Collections.sort(world, NumComp);
        System.out.println(world);

//  Подпункт 2: Создание Мапы и ее сортировка.
//  тут сортировку выполнил при создании мап (поэтому чтоб не повторять создание
//        закомментироал два из трех вариантов

        Comp mc = new Comp();
        NumComp nc = new NumComp();

        TreeMap<String,Integer> erope = new TreeMap<String,Integer>(mc);
//        TreeMap<String,Integer> erope = new TreeMap<String,Integer>(mc.reversed());
//        TreeMap<String, Integer> erope = new TreeMap<String, Integer>(nc);
        erope.put("Австрия", 43);
        erope.put("Германия", 14);
        erope.put("Англия", 23);
        erope.put("Литва", 12);
        erope.put("Швеция", 24);
        erope.put("Франция", 65);
        erope.put("Монако", 43);
        erope.put("Украина", 45);
        erope.put("Польша", 98);
        erope.put("Словения", 43);
        erope.put("Латвия", 15);
        erope.put("Исландия", 11);
        erope.put("Эстония", 34);
        erope.put("Испания", 45);
        System.out.println("Страны европы" + "\n" + erope.keySet());

        System.out.println("-----------------СТРИМЫ-----------------------------");
        List<String> streamFromWorld1 = world.stream().sorted().
                collect(Collectors.toList());
        System.out.println(streamFromWorld1);

        List<String> streamFromWorld2 = world.stream().sorted
                ((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(streamFromWorld2);
    }
}

// Сортировка с помощью перезаписи в ArrayList
//        List list = new ArrayList(erope.entrySet());
//        Collections.sort(erope, new Comparator<Map.Entry<String,Integer>>(){
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getKey().compareTo(o1.getKey());
//            }
//        });