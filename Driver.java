package controller;

import utilities.Dijkstras;
import utilities.ReadInput;
import utilities.Scheduling;
import utilities.SortRequest;
import utilities.OutputRevenue;


import java.io.IOException;

public class Driver {

    public static void main(String args[])throws IOException {

        ReadInput ri = new ReadInput();
        ri.readBasic();                                             //  Read input file
        SortRequest sr = new SortRequest();             
        sr.sort(ri.getReq());                                       //  Sort Request according to End Time of the Request
        Dijkstras dj = new Dijkstras();
        for(int i=0;i<ri.getN();i++) {
            Dijkstras.dij(ri.getLocation(), i, ri.getN());
        }
        Scheduling sd = new Scheduling();
        sd.schedule(ri.getCar(), ri.getReq(), ri.getLocation());    //  Scheduling Requests
        OutputRevenue o = new OutputRevenue();
        o.writeOutput(ri.getCar());                                 //  For output
    }
}
