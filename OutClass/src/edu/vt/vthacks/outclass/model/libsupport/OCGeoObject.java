package edu.vt.vthacks.outclass.model.libsupport;

import java.util.List;

public class OCGeoObject
{
    List<GeoAddressComponent> address_components;
    String formatted_address;
    GeoGeometry geometry;
    List<String> types;

    @Override
    public String toString()
    {
        if (address_components == null)
        {
            return "Empty components";
        }

        String s = "Components: \n";
        for(GeoAddressComponent comp : address_components)
        {
            s += "\t"+comp;
        }

        return s;
    }
}
