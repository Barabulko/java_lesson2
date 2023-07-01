// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(task1());
    }


    // Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
    // Если значение null, то параметр не должен попадать в запрос.
    // Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} select * from students where 'name=Ivanov' and 'country=Russia' and...

    static String task1(){
        String toSort = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"null\", \"age\":\"18\"}";
        String sqlQuerry = "select * from students where ";
        StringBuilder sb = new StringBuilder();
        sb.append(sqlQuerry);
        toSort = toSort.replace("{","");
        toSort = toSort.replace("}","");
        String[] parts = toSort.split(", ");
        for (int i=0; i<parts.length; i++){
            String word = parts[i];
            String key = word.split(":")[0].replace("\"", "");
            String value = word.split(":")[1].replace("\"", "");
            if (!value.equals("null")) {
                if (i>0) {
                    sb.append(" and ");
                }
                sb.append("'");
                sb.append(key);
                sb.append("=");
                sb.append(value);
                sb.append("'");
            }
        }
        return(sb.toString());
    }
}