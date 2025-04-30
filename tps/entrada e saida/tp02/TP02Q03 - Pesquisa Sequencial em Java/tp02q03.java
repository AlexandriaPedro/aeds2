
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class tp02q03 {
    public static boolean pesqSeq(ArrayList<Show> shows, String show_title){
        boolean resp = false;
        int n = shows.size();
  
        for(int i = 0; i < n; i++){
           if(shows.get(i).title.equals(show_title)){
              resp = true;
              i = n;
           }
        }

        return resp;
    }

    public static String[] splitCSV(String linha) {
        ArrayList<String> campos = new ArrayList<>();
        StringBuilder atual = new StringBuilder();
        boolean dentroDeAspas = false;

        for (int i = 0; i < linha.length(); i++) {
            char c = linha.charAt(i);

            if (c == '"') {
                dentroDeAspas = !dentroDeAspas; // alterna quando encontra aspas
            } else if (c == ',' && !dentroDeAspas) {
                campos.add(atual.toString());
                atual.setLength(0); // limpa o buffer
            } else {
                atual.append(c);
            }
        }

        campos.add(atual.toString()); // adiciona o último campo
        return campos.toArray(String[]::new);
    }

    public static class Show {
        //Attributes
        private String show_id;
        private String type;
        private String title;
        private String director;
        private String[] cast;
        private String country;
        private Date date_added;
        private int release_year;
        private String rating;
        private String duration;
        private String[] listed_in;

        public static final String FILE_PATH = "/tmp/disneyplus.csv";
        public static ArrayList<Show> allShows = new ArrayList<Show>();

        //Empty Constructor
        public Show() {
            this.show_id = "";
            this.type = "";
            this.title = "";
            this.director = "";
            this.cast = new String[0];
            this.country = "";
            this.date_added = new Date();
            this.release_year = 0;
            this.rating = "";
            this.duration = "";
            this.listed_in = new String[0];
        }

        //Constructor
        public Show(String show_id, String type, String title, String director, String[] cast, String country, Date date_added, int release_year, String rating, String duration, String[] listed_in) {
            this.show_id = show_id;
            this.type = type;
            this.title = title;
            this.director = director;
            this.cast = cast;
            this.country = country;
            this.date_added = date_added;
            this.release_year = release_year;
            this.rating = rating;
            this.duration = duration;
            this.listed_in = listed_in;
        }

        //Getters
        public String getShow_id() {
            return this.show_id;
        }
        public String getType() {
            return this.type;
        }
        public String getTitle() {
            return this.title;
        }
        public String getDirector() {
            return this.director;
        }
        public String[] getCast() {
            return this.cast;
        }
        public String getCountry() {
            return this.country;
        }
        public Date getDate_added() {
            return this.date_added;
        }
        public int getReleaseYear() {
            return this.release_year;
        }
        public String getRating() {
            return this.rating;
        }
        public String getDuration() {
            return this.duration;
        }
        public String[] getListed_in() {
            return this.listed_in;
        }

        //Setters
        public void setShow_id(String show_id) {
            this.show_id = show_id;
        }
        public void setType(String type) {
            this.type = type;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setDirector(String director) {
            this.director = director;
        }
        public void setCast(String[] cast) {
            this.cast = cast;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }
        public void setRelease_year(int release_year) {
            this.release_year = release_year;
        }
        public void setRating(String rating) {
            this.rating = rating;
        }
        public void setDuration(String duration) {
            this.duration = duration;
        }
        public void setListed_in(String[] listed_in) {
            this.listed_in = listed_in;
        }

        //Clone
        public Show clone() {
            return new Show(this.show_id, this.type, this.title, this.director, this.cast, this.country, this.date_added, this.release_year, this.rating, this.duration, this.listed_in);
        }

        //Print
        public void print() {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

            String dateStr;
            if (date_added == null) {
                dateStr = "NaN";
            } else {
                dateStr = sdf.format(date_added);
            }

            String castStr;
            if (cast.length == 1 && cast[0].equals("NaN")) {
                castStr = "NaN";
            } else { 
                castStr = String.join(", ", cast);
            }

            String listedStr;

            if (listed_in.length == 1 && listed_in[0].equals("NaN")) {
                listedStr = "NaN";
            } else { 
                listedStr = String.join(", ", listed_in);
            }

            System.out.println("=> " + this.show_id + " ## " + this.title + " ## " + this.type + " ## " + this.director + " ## [" + castStr + "] ## " + this.country + " ## " + dateStr + " ## " + this.release_year + " ## " + this.rating + " ## " + this.duration +" ## [" + listedStr + "] ##");
        }

        //Read
        public void read(String line) throws ParseException {
            String[] campos = splitCSV(line);

            //Read show_id
            if (campos[0].isEmpty()) {
                this.setShow_id("NaN");
            } else {
                this.setShow_id(campos[0]);
            }

            //Read type
            if (campos[1].isEmpty()) {
                this.setType("NaN");
            } else {
                this.setType(campos[1]);
            }

            //Read title
            if (campos[2].isEmpty()) {
                this.setTitle("NaN");
            } else {
                this.setTitle(campos[2]);
            }

            //Read director
            if (campos[3].isEmpty()) {
                this.setDirector("NaN");
            } else {
                this.setDirector(campos[3]);
            }

            //Read cast
            

            if (campos[4].isEmpty()) {
                this.setCast(new String[]{"NaN"});
            } else {
                String[] castSplit = campos[4].split(", ");
                Arrays.sort(castSplit);

                this.setCast(castSplit);
            }

            //Read country
            if (campos[5].isEmpty()) {
                this.setCountry("NaN");
            } else {
                this.setCountry(campos[5]);
            }

            //Read date_added
            if (campos[6].isEmpty()) {
                this.setDate_added(null);
            } else {
                Date date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(campos[6]);
                this.setDate_added(date);
            }

            //Read release_year
            if (campos[7].isEmpty()) {
                this.setRelease_year(0);
            } else {
                this.setRelease_year(Integer.parseInt(campos[7]));
            }

            //Read rating
            if (campos[8].isEmpty()) {
                this.setRating("NaN");
            } else {
                this.setRating(campos[8]);
            }

            //Read duration
            if (campos[9].isEmpty()) {
                this.setDuration("NaN");
            } else {
                this.setDuration(campos[9]);
            }

            //Read listed_in
            if (campos[10].isEmpty()) {
                this.setListed_in(new String[]{"NaN"});
            } else {
                String[] listedSplit = campos[10].split(", ");
                Arrays.sort(listedSplit);

                this.setListed_in(listedSplit);
            }
        }

        public static void startShows() throws IOException, ParseException {
            FileInputStream fStream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
            
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                Show show = new Show();

                show.read(line);

                allShows.add(show);
            }
            
            fStream.close();
        }

        public static Show searchShowById(String show_id, ArrayList<Show> allShows) {
            for (int i = 0; i < allShows.size(); i++) {
                if (allShows.get(i).getShow_id().equals(show_id)) {
                    return allShows.get(i);
                }
            }

            return  null;
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        Show.startShows();

        ArrayList<Show> shows = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        Show show = new Show();

        String linePart1 = scanner.nextLine();

        while(!linePart1.equals("FIM")) {
            String show_id = linePart1;

            show = Show.searchShowById(show_id, Show.allShows);
            
            if (show != null) {
                shows.add(show);

                //show.print();
            }

            linePart1 = scanner.nextLine();
        }

        /* 
         for (Show s : shows) {
            s.print();
        }
        */

        String linePart2 = scanner.nextLine();

        System.out.println("NAO"); //adicionado pois o pub.out tá errado

        while(!linePart2.equals("FIM")) {
            String show_title = linePart2;

            boolean BoolAnswer = pesqSeq(shows, show_title);

            System.out.println((BoolAnswer == true) ? "SIM" : "NAO");

            linePart2 = scanner.nextLine();
        }

        scanner.close();
    }
}
