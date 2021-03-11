package Travel;

import Places.City;
import Places.Location;

import java.util.ArrayList;
import java.util.List;

public class TravelPlan {
    private City currentCity;
    private List<Preference> preferences = new ArrayList<>();
    private Location startPoint, endPoint;

    public TravelPlan(City currentCity) {
        this.currentCity = currentCity;
    }

    public City getCurrentCity() {

        return currentCity;

    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public List<Preference> getPreferences() {

        return preferences;

    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public Location getEndPoint() {

        return endPoint;

    }

    public Location getStartPoint() {

        return startPoint;

    }

    public void addPreference(Location l1, Location l2)
    {
        Preference p1 = new Preference(l1, l2);

        preferences.add(p1);
    }

    public void addExtremePoints(Location start, Location end)
    {
        Preference p1;
        this.startPoint = start;
        this.endPoint = end;

        for(Location loc : currentCity.getNodes())
        {
            if(!loc.equals(start))
            {
                p1 = new Preference(start, loc);
                preferences.add(p1);
            }

            if((!loc.equals(end) && (!loc.equals(start))))
            {
                p1 = new Preference(loc, end);
                preferences.add(p1);
            }
        }

    }


}
