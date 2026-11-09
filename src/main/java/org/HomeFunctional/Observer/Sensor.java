package org.HomeFunctional.Observer;

import java.util.ArrayList;
import java.util.List;
public class Sensor{
 public List<Observer> observers = new ArrayList<>();
 public String name;

 public Sensor (String name){
 this.name= name;
 }
 public void addObserver (Observer obs){
     observers.add(obs);
 }
 public void detectMotion(){
     System.out.println("SENSOR" + name + "A movement has been detected");
     for (int i = 0; i < observers.size(); i++) {
         Observer obs = observers.get(i);
         obs.update("movement detected by" + name);
     }
 }
}
