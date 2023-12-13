//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков.
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//        отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//        Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        Далее нужно запросить минимальные значения для указанных критериев -
//        сохранить параметры фильтрации можно также в Map.
//        Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
//        Работу сдать как обычно ссылкой на гит репозиторий
//        Частые ошибки:
//        1. Заставляете пользователя вводить все существующие критерии фильтрации
//        2. Невозможно использовать более одного критерия фильтрации одновременно
//        3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру,
//        а не всем введенным пользователем
//        4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или
//        добавить еще ноутбук, то программа начинает работать некорректно

import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class HomeWork_6 {
    public static void main(String[] args) {
        Noutbook noutbook_1 = new Noutbook(
                "Apple", "Apple MacBook Air 13",
                13.3f, "Apple", "Apple M1",
                8, 256, false, "-", 85_999
        );
        Noutbook noutbook_2 = new Noutbook(
                "Apple", "Apple MacBook Pro",
                14.0f, "Apple", "Apple M1 Pro",
                16, 512, false, "-",179_999
        );
        Noutbook noutbook_3 = new Noutbook(
                "Lenovo", "Lenovo IdeaPad 3",
                15.6f, "Intel", "Intel Core i3",
                8, 512, false, "-",39_999
        );
        Noutbook noutbook_4 = new Noutbook(
                "Lenovo", "Lenovo IdeaPad Gaming 3",
                16.0f, "Intel", "Intel Core i5",
                16, 1024, true, "NVIDEA GeForce RTX 3060 (6 ГБ)",102_154
        );
        Noutbook noutbook_5 = new Noutbook(
                "Asus", "Asus ROG Strix G15",
                15.6f, "AMD", "AMD Ryzen 7",
                16, 512, true, "NVIDEA GeForce RTX 3060 (6 ГБ)",98_999
        );
        Noutbook noutbook_6 = new Noutbook(
                "MSI", "MSI Pulse MY15",
                15.6f, "Intel", "Intel Core i7",
                16, 1024, true, "NVIDEA GeForce RTX 4070 (8 ГБ)",105_999
        );

        HashSet<Noutbook> listNoutbooks = new HashSet<>();

        listNoutbooks.add(noutbook_1);
        listNoutbooks.add(noutbook_2);
        listNoutbooks.add(noutbook_3);
        listNoutbooks.add(noutbook_4);
        listNoutbooks.add(noutbook_5);
        listNoutbooks.add(noutbook_6);


        showFilteredList(listNoutbooks, filter());
    }
    static HashMap<String, Object> filter(){
        HashMap<String, Object> filter = new HashMap<>();
        Scanner input = new Scanner(System.in);
        boolean iteration = true;
        Integer command;

        System.out.println("Дававйте подберем для вас ноутбук!");
        while (iteration){
            System.out.println("Выберите номер фильтра который вы хотите установить.\n" +
                    "1. Бренд\n2. Диагональ экрана\n3. Бренд процессора\n" +
                    "4. Объем RAM\n5. Объем SSD\n6. Наличие видеокарты\n7. Цена\n" +
                    "8. Применить фильтры\n");
            boolean correctInput = input.hasNextInt();
            command = input.nextInt();
            input.nextLine();
            if (command == 1){
                System.out.println("1. Apple\n2. Lenovo\n3. Asus\n4. MSI\n");
                command = input.nextInt();
                input.nextLine();
                if (command == 1){
                    filter.put("Brand", "Apple");
                } else if (command == 2) {
                    filter.put("Brand", "Lenovo");
                } else if (command == 3) {
                    filter.put("Brand", "Asus");
                } else if (command == 4) {
                    filter.put("Brand", "MSI");
                }
            } else if (command == 2) {
                System.out.println("Введите наименьшее значение диагонали\n");
                Float diagonal = input.nextFloat();
                input.nextLine();
                filter.put("diagonal", diagonal);
            } else if (command == 3) {
                System.out.println("1. Intel\n2. AMD\n3. Apple\n");
                command = input.nextInt();
                if (command == 1) {
                    filter.put("CPUBrand", "Intel");
                } else if (command == 2) {
                    filter.put("CPUBrand", "AMD");
                } else if (command == 3) {
                    filter.put("CPUBrand", "Apple");
                }
            } else if (command == 4) {
                System.out.println("Введите наименьший объем RAM\n");
                Integer volum = input.nextInt();
                input.nextLine();
                filter.put("volumRAM", volum);
            } else if (command == 5) {
                System.out.println("Введите наименьший объем SSD\n");
                Integer volum = input.nextInt();
                filter.put("volumSSD", volum);
            } else if (command == 6) {
                System.out.println("Видеокарта:\n1. Есть\n2. Нет\n");
                command = input.nextInt();
                if (command == 1){
                    filter.put("isVideoCard", true);
                } else if (command == 2) {
                    filter.put("isVideoCard", false);
                }
            } else if (command == 7) {
                System.out.println("Введите максимальную стоимость\n");
                Integer price = input.nextInt();
                filter.put("maxPrice", price);
            } else if (command == 8){
                iteration = false;
                return filter;
            }
        }
        return filter;
    }
    static void showFilteredList(HashSet<Noutbook> list, HashMap<String, Object> filter){
        HashSet<Noutbook> result = new HashSet<>();
        boolean correspondence = true;
        if (filter.isEmpty()) {
            printFilteredList(list);
        } else {
            for (Noutbook noutbook : list) {
                if (filter.containsKey("Brand")){
                    if (!filter.get("Brand").equals(noutbook.getBrand())){
                        correspondence = false;
                    }
                }
                if (filter.containsKey("diagonal")){
                    if (noutbook.getScreenDiagonal() < (Float) filter.get("diagonal")){
                        correspondence = false;
                    }
                }
                if (filter.containsKey("CPUBrand")) {
                    if (!filter.get("CPUBrand").equals(noutbook.getCPUBrand())){
                        correspondence = false;
                    }
                }
                if (filter.containsKey("volumRAM")){
                    if (noutbook.getVolumRAM() < (Integer) filter.get("volumRAM")){
                        correspondence = false;
                    }
                }
                if (filter.containsKey("volumSSD")) {
                    if (noutbook.getVolumSSD() < (Integer) filter.get("volumSSD")){
                        correspondence = false;
                    }
                }
                if (filter.containsKey("isVideoCard")){
                    if(noutbook.isVedeoCard() != (Boolean) filter.get("isVideoCard")){
                        correspondence = false;
                    }
                }
                if (filter.containsKey("maxPrice")){
                    if (noutbook.getPrice() > (Integer) filter.get("maxPrice")){
                        correspondence = false;
                    }
                }
                if (correspondence){
                    result.add(noutbook);
                }
                correspondence = true;
            }
            printFilteredList(result);
        }
    }
    static void printFilteredList(HashSet<Noutbook> list) {
        System.out.println("Вот что я могу предложить:\n");
        for (Noutbook noutbook : list) {
            System.out.printf("\nНоутбук: %s\nДиагональ экрана: %.1f (в дюймах)\n" +
                    "Процессор: %s\nВидеокарта: %s\nОбъем RAM: %d\n" +
                    "Объем SSD: %d\nЦена: %d\n",
                    noutbook.getModel(), noutbook.getScreenDiagonal(),
                    noutbook.getCPUModel(), noutbook.getVideoCardModel(),
                    noutbook.getVolumRAM(), noutbook.getVolumSSD(),
                    noutbook.getPrice());
        }
    }
}




























