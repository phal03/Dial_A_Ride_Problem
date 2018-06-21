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
        ri.readBasic();
      //  System.out.println("### READ FILE ###");
        SortRequest sr = new SortRequest();
        sr.sort(ri.getReq());
      //  System.out.println("### BEFORE DIJKSTRAS ###");
        Dijkstras dj = new Dijkstras();
       // int[][] loc= new int[ri.getN()];
        for(int i=0;i<ri.getN();i++) {
            Dijkstras.dij(ri.getLocation(),i,ri.getN());
        }
       // System.out.println("### BEFORE SCHEDULING ###");
        Scheduling sd = new Scheduling();
        sd.schedule(ri.getCar(), ri.getReq(), ri.getLocation());
        OutputRevenue o = new OutputRevenue();
        o.writeOutput(ri.getCar());
    }
}
