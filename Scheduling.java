package utilities;

import constants.Constants;

public class Scheduling {

    public void schedule(Car[] car, Request[] r, int[][] loc){

        for(int i=0; i<r.length; i++){
            int carNumber=0;
            for(int k=0; k<car.length; k++){        //to find which car wil serve the request
                if(car[k].getCap() > 0){
                    carNumber = k;
                }
            }
            if(car[carNumber].getLocation() != r[i].getSrc()){                      //if block to send car to source of request
                int srtDist=loc[(car[carNumber].getLocation())-1][(r[i].getSrc())-1];
                car[carNumber].setLocation(r[i].getSrc());
                car[carNumber].setCarTime(2*srtDist);
            }

            if(car[carNumber].getCarTime() < r[i].getSrtTime()) {                    //car wait till request time starts
                car[carNumber].setCarTime(r[i].getSrtTime());
            }

            if(car[carNumber].getCap() > 0 && car[carNumber].getCarTime() >= r[i].getSrtTime() && car[carNumber].getCarTime() <= r[i].getEndTime()){//schedule request
                car[carNumber].setRevenue(car[carNumber].getRevenue() + loc[(car[carNumber].getLocation())-1][(r[i].getDest())-1] );     //update revenue
                car[carNumber].setCap(car[carNumber].getCap()-1);                                                       //decrement capacity
                int[] indices=car[carNumber].getPassengerLocation();
                System.out.println((i+1) + Constants.space + Constants.requestServed + Constants.space + r[i].getSrc() + Constants.space + r[i].getDest() + Constants.space + r[i].getSrtTime() + Constants.space + r[i].getEndTime());
                try {
                    for (int j = 0; j < 5; j++) {
                        if (indices[j] == 0) {
                            indices[j] = r[i].getDest();                                                //update passenger location array
                            break;
                        }
                    }
                } catch(NullPointerException e) {
                    System.out.println(Constants.notServedRequest + (i + 1));
                }
                car[carNumber].setPassengerLocation(indices);
            }

            if(car[carNumber].getCap() == 5){                   //drop passenger to destination
                int[] dropLocations = car[carNumber].getPassengerLocation();
                for(int j=0; j<dropLocations.length; j++){
                    if(car[carNumber].getLocation() != dropLocations[j]){                   //if the car is not at the location of the first
                        int srtDist=loc[(car[carNumber].getLocation())-1][(dropLocations[j])-1];    //passenger then we bring the car
                        car[carNumber].setLocation(dropLocations[j]);                       //to its source location
                        car[carNumber].setCarTime(car[carNumber].getCarTime() + srtDist);
                    }
                    car[carNumber].setCap(car[carNumber].getCap() + 1);
                }
                car[carNumber].passengerLocationReset();
            }
        }
    }
}
