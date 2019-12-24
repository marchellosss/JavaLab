import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class InputClass  {
    private static   String[] string =  new String[4];//кількість рядків повинна дорівнювати кількості рядків у файлі + 1!
    private static  int count = 0;

    private static void readLines() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C://Users//Василь//IdeaProjects//Lab5//src//Task1.txt"))){
            while ( (string[count]=bufferedReader.readLine())!=null){
                count++;
            }
        }
    }

    public static String findString() throws IOException{
        readLines();
        int wordCount = 0;
        int[] wordCounters = new int[count];
        int temp;
        int index = 0;

        for ( int i = 0; i <count; i++)
        {
            //Если ввели хотя бы одно слово, тогда считать, иначе конец программы
            if(string[i].length() != 0){
                wordCount++;
                //Проверяем каждый символ, не пробел ли это
                for (int j = 0; j < string[i].length(); j++) {
                    if(string[i].charAt(j) == ' '){
                        //Если пробел - увеличиваем количество слов на 1
                        wordCount++;
                    }
                }
            }
            wordCounters[i] = wordCount;
            wordCount = 0;
        }
        temp = wordCounters[0];
        for ( int i = 1; i < count; i++)
        {

            if(temp< wordCounters[i]){
                temp = wordCounters[i];
                index = i;
            }
        }
        return string[index];
    }

    public static void encryptString() throws IOException{
        char [] charIn = new char [] {'1','2','3'};
        char [] charOut = new char[] {'0','4','5'};
        try( InputStream in = new FileInputStream("C://Users//Василь//IdeaProjects//Lab5//src//Task3-1.txt"); OutputStream out = new FileOutputStream("C://Users//Василь//IdeaProjects//Lab5//src//Copy-Task3-1.txt")){
            replaceCharsIn(in,out, charIn, charOut);
        }
    }

    public static int replaceCharsIn(InputStream in, OutputStream out, char [] charIn, char[] charOut) throws IOException{
        byte[] buffer = new byte[10];
        int read = 0;
        int index = 0;
        while(true){
             read = in.read(buffer);
            if(read==-1){
                break;
            }
            else{
                for ( int i = 0 ; i <buffer.length;i++)
                {
                    for ( int j = 0; j < charIn.length; j++)
                    {
                        if( buffer[i]==((byte)charIn[j])){
                            buffer[i]= ((byte)charOut[j]);
                        }
                    }
                }
                out.write(buffer, 0, read);
            }
        }
        return  read;
    }

    public static void decryptString() throws IOException{
        char [] charIn = new char [] {'1','2','3'};
        char [] charOut = new char[] {'0','4','5'};
        try( InputStream in = new FileInputStream("C://Users//Василь//IdeaProjects//Lab5//src//Copy-Task3-1.txt"); OutputStream out = new FileOutputStream("C://Users//Василь//IdeaProjects//Lab5//src//Task3-1.txt")){
            replaceCharsOut(in,out, charIn, charOut);
        }
    }

    public static int replaceCharsOut( InputStream in, OutputStream out, char [] charIn, char[] charOut) throws IOException{
        byte[] buffer = new byte[10];
        int read = 0;
        int index = 0;
        while(true){
            read = in.read(buffer);
            if(read==-1){
                break;
            }
            else{
                for ( int i = 0 ; i <buffer.length;i++)
                {
                    for ( int j = 0; j < charIn.length; j++)
                    {
                        if( buffer[i]==((byte)charOut[j])){
                            buffer[i]= ((byte)charIn[j]);
                        }
                    }
                }
                out.write(buffer, 0, read);
            }
        }
        return  read;
    }
    public static void taskFour(){
        //String tmpURL = "http://stackoverflow.com/";
        String tmpURL = "https://www.google.com/";
        List<String> tags = new ArrayList<String>();
        try {
            Document document = Jsoup.connect(tmpURL).get();
            for (Element e : document.getAllElements()) {
                tags.add(e.tagName().toLowerCase());
            }
            // System.out.println("Page`s tags = " + tags);
            //System.out.println("The tags count = " + tags.size());
            //System.out.println("Distinct tags = " + new HashSet<String>(tags));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = null;
        URLConnection connection = null;
        try {
            connection = new URL(tmpURL).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // System.out.println(content); // page`s HTML content


        int count = 0;
        if (content.length() != 0) {  // if content len != null
            count++;
            //перевірка не пробел чи символ
            for (int i = 0; i < content.length(); i++) {
                if (content.charAt(i) == ' ') {
                    // пробел - words count++
                    count++;
                }
            }
        }

        //System.out.println("Вы ввели "+count+"слів");

        HashMap<String, Integer> tags_4 = new HashMap<String,Integer>();
        svg_init_1(tags_4);

        Collections.sort(tags);



        //region init 2
        //regio init 2
        int occurrences = Collections.frequency(tags, "a");
        tags_4.put("a",occurrences);
        occurrences = Collections.frequency(tags, "p");
        tags_4.put("p",occurrences);
        occurrences = Collections.frequency(tags, "label");
        tags_4.put("label",occurrences);
        occurrences = Collections.frequency(tags, "nav");
        tags_4.put("nav",occurrences);
        occurrences = Collections.frequency(tags, "script");
        tags_4.put("script",occurrences);
        occurrences = Collections.frequency(tags, "body");
        tags_4.put("body",occurrences);
        occurrences = Collections.frequency(tags, "footer");
        tags_4.put("footer",occurrences);
        occurrences = Collections.frequency(tags, "input");
        tags_4.put("input",occurrences);
        occurrences = Collections.frequency(tags, "style");
        tags_4.put("style",occurrences);
        occurrences = Collections.frequency(tags, "path");
        tags_4.put("path",occurrences);
        occurrences = Collections.frequency(tags, "strong");
        tags_4.put("strong",occurrences);
        occurrences = Collections.frequency(tags, "br");
        tags_4.put("br",occurrences);
        occurrences = Collections.frequency(tags, "div");
        tags_4.put("div",occurrences);
        occurrences = Collections.frequency(tags, "h1");
        tags_4.put("h1",occurrences);
        occurrences = Collections.frequency(tags, "h2");
        tags_4.put("h2",occurrences);
        occurrences = Collections.frequency(tags, "h3");
        tags_4.put("h3",occurrences);
        occurrences = Collections.frequency(tags, "title");
        tags_4.put("title",occurrences);
        occurrences = Collections.frequency(tags, "h4");
        tags_4.put("h4",occurrences);
        occurrences = Collections.frequency(tags, "h5");
        tags_4.put("h5",occurrences);
        occurrences = Collections.frequency(tags, "form");
        tags_4.put("form",occurrences);
        occurrences = Collections.frequency(tags, "li");
        tags_4.put("li",occurrences);
        occurrences = Collections.frequency(tags, "#root");
        tags_4.put("#root",occurrences);
        occurrences = Collections.frequency(tags, "noscript");
        tags_4.put("noscript",occurrences);
        occurrences = Collections.frequency(tags, "header");
        tags_4.put("header",occurrences);
        occurrences = Collections.frequency(tags, "ol");
        tags_4.put("ol",occurrences);
        occurrences = Collections.frequency(tags, "meta");
        tags_4.put("meta",occurrences);
        occurrences = Collections.frequency(tags, "svg");
        tags_4.put("svg",occurrences);
        occurrences = Collections.frequency(tags, "ul");
        tags_4.put("ul",occurrences);
        occurrences = Collections.frequency(tags, "span");
        tags_4.put("span",occurrences);
        occurrences = Collections.frequency(tags, "html");
        tags_4.put("html",occurrences);
        occurrences = Collections.frequency(tags, "img");
        tags_4.put("img",occurrences);
        occurrences = Collections.frequency(tags, "link");
        tags_4.put("link",occurrences);
        //endregion init 2



        SortedSet<Integer> values_1 = new TreeSet<Integer>(tags_4.values());

        System.out.println("\nAnswers for task 4 ");
        System.out.println("4.1");

        System.out.println(tags.size());// dont work ??
        System.out.println(tags.size()/count);  //4.1
        System.out.println("\n4.2");
        System.out.println("Відсортований масив тегів в порядку зростання для тегів в лексикографічному порядку");
        System.out.println(tags);
        System.out.println("\n4.3");
        System.out.println(tags_4);
        System.out.print(values_1);
    }
    public static HashMap<String, Integer> svg_init_1(HashMap<String, Integer>tags_4 ){
        tags_4.put("a",0);
        tags_4.put("p",0);
        tags_4.put("label",0);
        tags_4.put("nav",0);
        tags_4.put("script",0);
        tags_4.put("body",0);
        tags_4.put("footer",0);
        tags_4.put("input",0);
        tags_4.put("style",0);
        tags_4.put("path",0);
        tags_4.put("strong",0);
        tags_4.put("br",0);
        tags_4.put("div",0);
        tags_4.put("h1",0);
        tags_4.put("h2",0);
        tags_4.put("h3",0);
        tags_4.put("form",0);
        tags_4.put("li",0);
        tags_4.put("#root",0);
        tags_4.put("noscript",0);
        tags_4.put("header",0);
        tags_4.put("head",0);
        tags_4.put("ol",0);
        tags_4.put("meta",0);
        tags_4.put("svg",0);
        tags_4.put("ul",0);
        tags_4.put("span",0);
        tags_4.put("html",0);
        tags_4.put("img",0);
        tags_4.put("link",0);
        return tags_4;
    }

}
