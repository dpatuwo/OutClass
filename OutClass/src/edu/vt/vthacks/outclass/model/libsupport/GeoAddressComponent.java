package edu.vt.vthacks.outclass.model.libsupport;

import java.util.List;

public class GeoAddressComponent
{
    String long_name;
    String short_name;
    List<String> types;

    @Override
    public String toString()
    {
        return "[Long = "+long_name+", Short = "+short_name+", Types = "+types+"]";
    }
}
