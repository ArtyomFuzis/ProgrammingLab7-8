package com.fuzis.proglab.Server;

import com.fuzis.proglab.Enums.Opinion;
import com.fuzis.proglab.Enums.Popularity;
import com.fuzis.proglab.Enums.Sex;
import java.util.*;
import java.util.function.Consumer;

public class InteractiveInput {

    Scanner scan;
    Consumer<Object> println_supress;
    Consumer<Object> print_supress;
    Object writing_obj;
    Object reading_obj;
    public InteractiveInput(Scanner scan, Consumer<Object> println_supress, Consumer<Object> print_supress)
    {
        this.print_supress=print_supress;
        this.println_supress=println_supress;
        this.scan=scan;
    }
    public String type_interactive()
    {
        println_supress.accept("Введите какое поле вы желаете изменить, иначе End для выхода");
        println_supress.accept("Варианты ввода: Name, Sex, Quote, Opinions, AdditionalNames, Height, Weight, Age, Health, IsAnimeCharacter, Popularity, Description");
        return scan.nextLine().trim().toLowerCase();
    }
    public String name_interactive() {
        println_supress.accept("Введите имя персонажа");
        String name = null;
        boolean match = false;
        while (!match) {
            name = scan.nextLine();
            if (name.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            match = name.matches("\\s*[a-zA-Zа-яА-ЯёЁ_!#@$0-9]+\\s*");
            if (!match) {
                println_supress.accept("Введенное значение не может быть именем, попробуйте ещё раз");
            }
        }
        return name;
    }

    public Sex sex_interactive() {
        println_supress.accept("Введите пол персонажа");
        print_supress.accept("Возможные варианты ввода: ");
        for (int i = 0; i < Sex.values().length; i++) {
            if (i != Sex.values().length - 1) print_supress.accept(Sex.values()[i] + ", ");
            else println_supress.accept(Sex.values()[i]);
        }
        Sex sex = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            try {
                data = data.trim();
                sex = Sex.valueOf(data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase(Locale.ROOT));
                match = true;
            } catch (IllegalArgumentException ex) {
                println_supress.accept("Введенное значение не может быть полом, попробуйте ещё раз");
            }
        }
        return sex;
    }

    public String quote_interactive() {
        println_supress.accept("Введите цитату персонажа");
        String quote = null;
        boolean match = false;
        while (!match) {
            quote = scan.nextLine();
            if (quote.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            match = quote.matches("(?:\\s*[a-zA-Zа-яА-Яё,Ё_.?\"'`!#@$0-9]+\\s*)+");
            if (!match) {
                println_supress.accept("Введенное значение не может быть цитатой, попробуйте ещё раз");
            }
        }
        return quote;
    }

    public Double height_interactive() {
        println_supress.accept("Введите рост персонажа");
        Double height = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            try {
                data = data.trim();
                height = Double.valueOf(data);
                match = true;
            } catch (NumberFormatException ex) {
                println_supress.accept("Введенное значение не может быть ростом, попробуйте ещё раз");
            }
        }
        return height;
    }

    public Double weight_interactive() {
        println_supress.accept("Введите вес персонажа");
        Double weight = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            try {
                data = data.trim();
                weight = Double.valueOf(data);
                match = true;
            } catch (NumberFormatException ex) {
                println_supress.accept("Введенное значение не может быть весом, попробуйте ещё раз");
            }
        }
        return weight;
    }

    public Popularity popularity_interactive() {
        println_supress.accept("Введите популярность персонажа");
        print_supress.accept("Возможные варианты ввода: ");
        for (int i = 0; i < Popularity.values().length; i++) {
            if (i != Popularity.values().length - 1) print_supress.accept(Popularity.values()[i] + ", ");
            else println_supress.accept(Popularity.values()[i]);
        }
        Popularity popul = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            try {
                data = data.trim();
                popul = Popularity.valueOf(data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase(Locale.ROOT));
                match = true;
            } catch (IllegalArgumentException ex) {
                println_supress.accept("Введенное значение не может быть популярностью, попробуйте ещё раз");
            }
        }
        return popul;
    }

    public Double age_interactive() {
        println_supress.accept("Введите возраст персонажа");
        Double age = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            try {
                data = data.trim();
                age = Double.valueOf(data);
                match = true;
            } catch (NumberFormatException ex) {
                println_supress.accept("Введенное значение не может быть возрастом, попробуйте ещё раз");
            }
        }
        return age;
    }

    public String description_interactive() {
        println_supress.accept("Введите краткое описание персонажа (одна строка)");
        String description = null;
        boolean match = false;
        while (!match) {
            description = scan.nextLine();
            if (description.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            match = description.matches("(?:\\s*[\\-a-zA-Zа-яА-ЯёЁ_,.?\"'`!#@$0-9]+\\s*)+");
            if (!match) {
                println_supress.accept("Введенное значение не может быть описанием, попробуйте ещё раз");
            }
        }
        return description;
    }

    public Integer health_interactive() {
        println_supress.accept("Введите здоровье персонажа (целое число)");
        Integer health = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            try {
                data = data.trim();
                health = Integer.valueOf(data);
                match = true;
            } catch (NumberFormatException ex) {
                println_supress.accept("Введенное значение не может быть здоровьем, попробуйте ещё раз");
            }
        }
        return health;
    }

    public Boolean isAnimeCharacter_interactive() {
        println_supress.accept("Введите является ли данный персонажем аниме  (Да/Нет/Yes/No/はい/いいえ)");
        Boolean isAnimeCharacter = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            match = data.toLowerCase(Locale.ROOT).matches("\\s*(?:да|yes|はい)\\s*");
            if (match) {
                isAnimeCharacter = true;
                break;
            }
            match = data.toLowerCase(Locale.ROOT).matches("\\s*(?:нет|no|いいえ)\\s*");
            if (match) isAnimeCharacter = false;
            if (!match) {
                println_supress.accept("Введенное значение не входит в Да/Нет/Yes/No/はい/いいえ, попробуйте ещё раз");
            }
        }
        return isAnimeCharacter;
    }

    public List<String> additionalnames_interactive() {
        println_supress.accept("Введите дополнительные имена персонажа в строке через запятую");
        ArrayList<String> additionalNames = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            match = data.matches("(?:\\s*[a-zA-Zа-яА-ЯёЁ_!#@$0-9]+\\s*,\\s*)*[a-zA-Zа-яА-ЯёЁ_!#@$0-9]+\\s*");
            if (!match) {
                println_supress.accept("Введенное значение не не соответствует формату ввода, попробуйте ещё раз");
                continue;
            }
            additionalNames = new ArrayList<>(Arrays.stream(data.trim().split("\\s*,\\s*")).toList());
        }
        return additionalNames;
    }

    public HashMap<String, Opinion> opinions_interactive() {
        println_supress.accept("Введите мнения персонажа о других персонажах(не обязательно находящихся в коллекции), в формате: <имя>:<отношение>,<имя2>:<отношение2>...");
        print_supress.accept("Возможные варианты ввода <отношение>: ");
        for (int i = 0; i < Opinion.values().length; i++) {
            if (i != Opinion.values().length - 1) print_supress.accept(Opinion.values()[i] + ", ");
            else println_supress.accept(Opinion.values()[i]);
        }
        HashMap<String, Opinion> opinions = null;
        boolean match = false;
        while (!match) {
            String data = scan.nextLine();
            if (data.matches("\\s*")) {
                println_supress.accept("Воспринято как <null>");
                break;
            }
            match = data.matches("(?:\\s*[a-zA-Zа-яА-ЯёЁ_!#@$0-9]+\\s*:\\s*[a-zA-Z]+\\s*,\\s*)*[a-zA-Zа-яА-ЯёЁ_!#@$0-9]+\\s*:\\s*[a-zA-Z]+\\s*");
            if (!match) {
                println_supress.accept("Введенное значение не не соответствует формату ввода, попробуйте ещё раз");
                continue;
            }
            var pre_data = data.trim().split("\\s*,\\s*");
            opinions = new HashMap<>();
            try {
                for (var el : pre_data) {
                    var separated = el.split("\\s*:\\s*");
                    opinions.put(separated[0], Opinion.valueOf(separated[1].substring(0, 1).toUpperCase() + separated[1].substring(1).toLowerCase(Locale.ROOT)));
                }
            } catch (IllegalArgumentException ex) {
                println_supress.accept("Введенное значение не не соответствует формату ввода (неверное значение отношения), попробуйте ещё раз");
                match = false;
            }
        }
        return opinions;
    }
    public String id_interactive()
    {
        println_supress.accept("Введите id персонажа");
        String id;
        Boolean match = false;
        while (!match) {
            id = scan.nextLine();
            match = id.matches("\\s*[a-zA-Zа-яА-ЯёЁ_!#@$0-9]+\\s*");
            if (!match) {
                println_supress.accept("Введенное значение не может быть id, попробуйте ещё раз");
                continue;
            }
            return id.trim();
        }
        return null;
    }
}