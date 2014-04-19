package edu.vt.vthacks.outclass.model.libsupport;

import java.util.List;

public class GoogleMapAPIResult
{
    List<OCGeoObject> results;

    @Override
    public String toString()
    {
        if (results == null)
        {
            return "Empty result";
        }

        return ""+results.get(0);
    }
}
