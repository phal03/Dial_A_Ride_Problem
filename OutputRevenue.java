package utilities;

public class OutputRevenue {

    public void writeOutput(Car[] car){
        int i=0,totalRevenue=0;
        for( ; i<car.length; i++){
            totalRevenue += car[i].getRevenue();
        }
        System.out.println("Total Revenue: Rs." + totalRevenue);

    }
}
