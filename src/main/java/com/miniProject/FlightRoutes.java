package com.miniProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
import java.io.*;
public class FlightRoutes{
public static int countOfRoutes(String filename){
int routeCount=0;
try {
    BufferedReader reader=new BufferedReader(new FileReader(filename));
    while (reader.readLine()!=null)
        routeCount++;
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
return routeCount;
}
    public static RecordRoute[] readRecords(String fileName,int routeCount) throws ParseException {
        RecordRoute[] routes=new RecordRoute[routeCount];

        try (BufferedReader reader=new BufferedReader(new FileReader(fileName))){


            int i=0;

            while (i<routeCount||reader.readLine()!=null){


                String s1[]=reader.readLine().split(",");

                String from=s1[0];
                String to=s1[1];
                int distance=Integer.parseInt(s1[2]);
                String time=s1[3];
                String fare=s1[4];

                routes[i]=new RecordRoute(from,to,distance,time,fare);
                i++;

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }


        return routes;
    }
    public static void displayInfo(RecordRoute[] routes){
        System.out.println("From\tTo\tDistance\tTravel Time\tAirFare");
        for (int i=0;i<routes.length;i++){
            System.out.println(routes[i].getFrom()+"\t"+routes[i].getTo()+"\t"+routes[i].getDistance()+"\t"+routes[i].getTime()+"\t"+routes[i].getFare());

        }
    }
    public static void showDirectFlights(RecordRoute[] routes,String fromCity){
    boolean flag=false;
    for (int i=0;i<routes.length;i++){

        if(routes[i].getFrom().equals(fromCity)){
            System.out.println(routes[i].getFrom()+"\t"+routes[i].getTo()+"\t"+routes[i].getDistance()+"\t"+routes[i].getTime()+"\t"+routes[i].getFare());
             flag=true;
        }
    }
    if(flag!=true)
        System.out.println("We are sorry. At this point of time,we do not have any information on flights originating from "+fromCity);
    }
    public static void sortFlights(RecordRoute[] routes,String fromCity){
    ArrayList<RecordRoute> sortRoutes=new ArrayList<RecordRoute>();

        for (int i=0;i<routes.length;i++){

            if(routes[i].getFrom().equals(fromCity)){
                sortRoutes.add(routes[i]);
            }
        }
        Collections.sort(sortRoutes, new Comparator<RecordRoute>() {
            @Override
            public int compare(RecordRoute o1, RecordRoute o2) {
                return o1.getTo().charAt(0)-o2.getTo().charAt(0);
            }
        });
        for (RecordRoute r:sortRoutes){
            System.out.println(r.getFrom()+"\t"+r.getTo()+"\t"+r.getDistance()+"\t"+r.getTime()+"\t"+r.getFare());
        }
    }
    public static void printPathsUtil(String from, String to,RecordRoute[] routes,ArrayList<RecordRoute> s){
      if(from.equals(to))
          for (RecordRoute r:s){
              System.out.println(r.getFrom()+"\t"+r.getTo()+"\t"+r.getDistance()+"\t"+r.getTime()+"\t"+r.getFare());
          }

    for (int i=0;i<routes.length;i++){

        if((s.contains(routes[i])==false)&&(routes[i].getFrom().equals(from))){
            s.add(routes[i]);
            printPathsUtil(routes[i].getTo(),to,routes,s);
            s.remove(routes[i]);
        }
    }
    }

    public static void main(String[] args) throws ParseException {
   String filename="src/main/resources/flightRoutes.csv";
   int count=countOfRoutes(filename);
   RecordRoute[] routes=readRecords(filename,count);
   //displayInfo(routes);
   //showDirectFlights(routes,"Delhi");
   //sortFlights(routes,"Delhi");
   ArrayList<RecordRoute> s=new ArrayList<>();
   printPathsUtil("Delhi","London",routes,s);
    }



}
