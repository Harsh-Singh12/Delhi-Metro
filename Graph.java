import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.Source;

class Graph {
    static int i = 0;
    Map<Integer, String> mp1 = new HashMap<>();
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    static Map<String, Integer> mp = new HashMap<>();

    void addVertex(String s) {
        mp.put(s, i);
        mp1.put(i, s);
        adj.add(new ArrayList<>());
        i++;
    }

    void addEdge(String s1, String s2, int t) {
        int u = mp.get(s1);
        int v = mp.get(s2);
        adj.get(u).add(new Pair(v, t));
        adj.get(v).add(new Pair(u, t));
    }

    void display_Stations() {
        for (Map.Entry<Integer, String> aa : mp1.entrySet()) {
            System.out.println(aa.getKey() + ". " + aa.getValue());
        }
    }

    public void AutoStopage_Map() {
        System.out.println("\t DELHI AUTO STOPAGE MAP ");
        System.out.println("\t--------------------------------------");
        System.out.println("\t---------------------------------------------------------------------");

        int j = 0;
        for (ArrayList<Pair> a : adj) {
            System.out.println(mp1.get(j) + "  to =>");
            for (Pair p : a) {
                System.out.println("           " + mp1.get(p.v) + " , " + p.cost + " km.");
            }
            System.out.println();
            j++;

        }
        System.out.println("\t------------------------------------");
        System.out.println("\t------------------------------------------------------------------------");
    }

    static void createMap(Graph g) {

        g.addVertex("Noida Sector 62~B");
        g.addVertex("Botanical Garden~B");
        g.addVertex("Yamuna Bank~B");
        g.addVertex("Rajiv Chowk~BY");
        g.addVertex("Vaishali~B");
        g.addVertex("Moti Nagar~B");
        g.addVertex("Janak Puri West~BO");
        g.addVertex("Dwarka Sector 21~B");
        g.addVertex("Huda City Center~Y");
        g.addVertex("Saket~Y");
        g.addVertex("Vishwavidyalaya~Y");
        g.addVertex("Chandni Chowk~Y");
        g.addVertex("New Delhi~YO");
        g.addVertex("AIIMS~Y");
        g.addVertex("Shivaji Stadium~O");
        g.addVertex("DDS Campus~O");
        g.addVertex("IGI Airport~O");
        g.addVertex("Rajouri Garden~BP");
        g.addVertex("Netaji Subhash Place~PR");
        g.addVertex("Punjabi Bagh West~P");

        g.addEdge("Noida Sector 62~B", "Botanical Garden~B", 8);
        g.addEdge("Botanical Garden~B", "Yamuna Bank~B", 10);
        g.addEdge("Yamuna Bank~B", "Vaishali~B", 8);
        g.addEdge("Yamuna Bank~B", "Rajiv Chowk~BY", 6);
        g.addEdge("Rajiv Chowk~BY", "Moti Nagar~B", 9);
        g.addEdge("Moti Nagar~B", "Janak Puri West~BO", 7);
        g.addEdge("Janak Puri West~BO", "Dwarka Sector 21~B", 6);
        g.addEdge("Huda City Center~Y", "Saket~Y", 15);
        g.addEdge("Saket~Y", "AIIMS~Y", 6);
        g.addEdge("AIIMS~Y", "Rajiv Chowk~BY", 7);
        g.addEdge("Rajiv Chowk~BY", "New Delhi~YO", 1);
        g.addEdge("New Delhi~YO", "Chandni Chowk~Y", 2);
        g.addEdge("Chandni Chowk~Y", "Vishwavidyalaya~Y", 5);
        g.addEdge("New Delhi~YO", "Shivaji Stadium~O", 2);
        g.addEdge("Shivaji Stadium~O", "DDS Campus~O", 7);
        g.addEdge("DDS Campus~O", "IGI Airport~O", 8);
        g.addEdge("Moti Nagar~B", "Rajouri Garden~BP", 2);
        g.addEdge("Punjabi Bagh West~P", "Rajouri Garden~BP", 2);
        g.addEdge("Punjabi Bagh West~P", "Netaji Subhash Place~PR", 3);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        createMap(g);

        System.out.println("\n\t\t\t****WELCOME TO THE METRO APP*****");
        // System.out.println("\t\t\t\t~~LIST OF ACTIONS~~\n\n");
        // System.out.println("1. LIST ALL THE STATIONS IN THE MAP");
        // System.out.println("2. SHOW THE METRO MAP");
        // System.out.println("3. GET SHORTEST DISTANCE FROM A 'SOURCE' STATION TO
        // 'DESTINATION' STATION");
        // System.out.println("4. GET SHORTEST TIME TO REACH FROM A 'SOURCE' STATION TO
        // 'DESTINATION' STATION");
        // System.out.println("5. GET SHORTEST PATH (DISTANCE WISE) TO REACH FROM A
        // 'SOURCE' STATION TO 'DESTINATION' STATION");
        // System.out.println("6. GET SHORTEST PATH (TIME WISE) TO REACH FROM A 'SOURCE'
        // STATION TO 'DESTINATION' STATION");
        // System.out.print("\nENTER YOUR CHOICE FROM THE ABOVE LIST : ");
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        // int choice = Integer.parseInt(inp.readLine());
        // STARTING SWITCH CASE
        while (true) {
            System.out.println("\t\t\t\t~~LIST OF ACTIONS~~\n\n");
            System.out.println("1. LIST ALL THE STATIONS IN THE MAP");
            System.out.println("2. SHOW THE METRO MAP");
            System.out.println("3. GET SHORTEST DISTANCE FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
            System.out.println("4. EXIT THE MENU");
            System.out.print("\nENTER YOUR CHOICE FROM THE ABOVE LIST (1 to 4) : ");
            int choice = -1;
            try {
                choice = Integer.parseInt(inp.readLine());
            } catch (Exception e) {
                // default will handle
            }
            System.out.print("\n***********************************************************\n");
            if (choice == 4) {
                System.exit(0);
            }
            switch (choice) {
                case 1:
                    g.display_Stations();
                    break;

                case 2:
                    g.AutoStopage_Map();
                    break;

                case 3:
                      System.out.println("Enter the Source Station ");
                      String st1=" ",st2="";
                      try{
                       st1=inp.readLine();
                      }
                      catch(Exception e){

                      }
                      System.out.println("Enter the Destination Station");
                      try{
                        st2=inp.readLine();
                       }
                       catch(Exception e){
                         
                       }
                       System.out.println("you Entered : "+st1+" "+st2);
                       if(!mp.containsKey(st1) || !mp.containsKey(st2)){
                        System.out.println("Invalid Source or Destination station");
                       }
                       int v1=mp.get(st1);
                       int v2=mp.get(st2);
                       if(!hasPath(adj,v1,v2)){
                        System.out.println("No Path from "+st1+" to "+st2);
                       }
                       System.out.println("SHORTEST DISTANCE FROM "+st1+" TO "+st2+" IS "+g.dijkstra(st1, st2)+"KM\n");
                    break;

                case 4:

                    break;
                default:
                    System.out.println("Please enter a valid option! ");
                    System.out.println("The options you can choose are from 1 to 6. ");

            }
        }

    }

    static class Pair {
        int v;
        int cost;

        Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}