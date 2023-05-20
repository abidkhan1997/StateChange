import java.util.Random;
import java.lang.Math;
import java.util.*;
public class Assignment2 {
    static  int state=0;
    static boolean flag = true, flag1 = true, flag2 = true, flag3 = true, flag5 = true, flag6 = true;
    static HashMap<String, Integer> hm = new HashMap<String, Integer>(5);
    static {
        hm.put("program 1", 0);
        hm.put("program 2", 0);
        hm.put("program 3", 0);
        hm.put("program 4", 0);
        hm.put("program 5", 0);
    }
    public static double timeFunction(double u){
        double lambda = 1/10.0;
        double res = -Math.log(1-u)/lambda;
        return res*1000;
    }
    class first extends Thread{
        public void run(){
            double rand_dub1 = Math.random();
            try {
                Thread.sleep((long) timeFunction(rand_dub1));
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hm.get("program 1")>=4){
                hm.put("program 1", 1);
            }
            hm.put("program 1", hm.get("program 1")+1);
            flag = false;
            state++;
        }
    }
    class second extends Thread{
        public void run(){
            double rand_dub1 = Math.random();
            try {
                Thread.sleep((long) timeFunction(rand_dub1));
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hm.get("program 2")>=4){
                hm.put("program 2", 1);
            }
            hm.put("program 2", hm.get("program 2")+1);
            flag = false;
            state++;
        }
    }
    class third extends Thread{
        public void run(){
            double rand_dub1 = Math.random();
            try {
                Thread.sleep((long) timeFunction(rand_dub1));
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hm.get("program 3") >=4){
                hm.put("program 3", 1);
            }
            hm.put("program 3", hm.get("program 3")+1);
            flag = false;
            state++;
        }
    }
    class fourth extends Thread{
        public void run(){
            double rand_dub1 = Math.random();
            try {
                Thread.sleep((long) timeFunction(rand_dub1));

            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hm.get("program 4")>=4){
                hm.put("program 4", 1);
            }
            hm.put("program 4", hm.get("program 4")+1);
            flag = false;
            state++;
        }
    }
    class fifth extends Thread{
        public void run(){
            double rand_dub1 = Math.random();
            try {
                Thread.sleep((long) timeFunction(rand_dub1));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hm.get("program 5")>=4){
                hm.put("program 5", 1);
            }
            hm.put("program 5", hm.get("program 5")+1);
            flag = false;
            state++;
        }
    };
    public static void main(String[] args) throws InterruptedException {
        flag = true;

        System.out.println(hm);
        while (state<20) {
            Assignment2 tr1 = new Assignment2();
            Assignment2 tr2 = new Assignment2();
            Assignment2 tr3 = new Assignment2();
            Assignment2 tr4 = new Assignment2();
            Assignment2 tr5 = new Assignment2();

            Assignment2.first t1 = tr1.new  first();
            Assignment2.second t2 = tr2.new second();
            Assignment2.third t3 = tr3.new third();
            Assignment2.fourth t4 = tr4.new  fourth();
            Assignment2.fifth t5 = tr5.new fifth();
            
            while(flag) {

                if (!t1.isAlive()) {
                    t1.start();
                }
                if (!t2.isAlive()) {
                    t2.start();
                }
                if (!t3.isAlive()) {
                    t3.start();
                }
                if (!t4.isAlive()) {
                    t4.start();
                }
                if (!t5.isAlive()) {
                    t5.start();
                }
            }
            flag = true;
        if (state%5==0){
            System.out.println("state change number is: "+state);
            System.out.println(hm);
        }
        }
    }
}