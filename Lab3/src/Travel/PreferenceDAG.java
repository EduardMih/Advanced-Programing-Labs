package Travel;

import java.util.List;

public class PreferenceDAG {
    int[] [] adj;

    public PreferenceDAG(List<Preference> preferences, int nrOfVertices) {
        adj = new int[nrOfVertices][nrOfVertices];

        for(Preference pref : preferences)
        {

        }
    }
}
