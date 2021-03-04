import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Hotel v1 = new Hotel("Hotel1", "Descr hotel1");
        Museum v2 = new Museum("MuseumA", "Descr museumA");
        Museum v3 = new Museum("Museum B", "Descr museumB");
        Church v4 = new Church("CurchA", "Descr curchA");
        Church v5 = new Church("CurchB", "Descr curchB");
        Restaurant v6 = new Restaurant("Restaurant1", "Descr restaurant1");

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        v1.setRank(5);
        v2.setTicketPrice(2.55);
        v2.setOpeningTime(LocalTime.parse("08:15:00"));

        City myCity = new City();
        myCity.addLocation(v1);
        myCity.addLocation(v2);
        myCity.addLocation(v3);
        myCity.addLocation(v3);
        myCity.addLocation(v4);
        myCity.addLocation(v5);
        myCity.addLocation(v6);

        System.out.println(myCity);





    }
}
