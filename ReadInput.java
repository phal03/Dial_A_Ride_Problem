package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadInput {

    private int n,N,c,R;
    private int[][] location;
    private Car[] car;
    private Request[] req;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int[][] getLocation() {
        return location;
    }

    public void setLocation(int[][] location) {
        this.location = location;
    }

    public Car[] getCar() {
        return car;
    }

    public void setCar(Car[] car) {
        this.car = car;
    }

    public Request[] getReq() {
        return req;
    }

    public void setReq(Request[] req) {
        this.req = req;
    }


    public void readBasic()throws IOException {

        try{
            Scanner sc = new Scanner( new File("C:\\Users\\PHALGUNI\\Documents\\input.txt"));
            n=sc.nextInt();
            N=sc.nextInt();
            c=sc.nextInt();
            R=sc.nextInt();
            //System.out.println("n: "+n+"\nN: "+N+"\nc: "+c+"\nR: "+R);
            location = new int[n][n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++){
                    location[i][j]=sc.nextInt();
                    if(location[i][j] == -1)
                        location[i][j]=999;
                }
            }

            car = new Car[N];           //create reference of car
            for(int i=0; i<N; i++){
                car[i] = new Car(); //instantiate memory
            }
            for(int i=0 ; i<N ; i++){
                car[i].setLocation(sc.nextInt());
            }
            req = new Request[R];
            for(int i=0; i<R; i++){
                req[i] = new Request();
            }
            for(int i=0 ; i<R ; i++){
                req[i].setSrc(sc.nextInt());
                req[i].setDest(sc.nextInt());
                req[i].setSrtTime(sc.nextInt());
                req[i].setEndTime(sc.nextInt());
            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
