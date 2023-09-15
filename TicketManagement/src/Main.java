import SeatAvailability.Seats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Integer seatIn1010=50;
    static Integer seatIn2013=50;
    static Integer seatIn3045=50;


    //****************************************** ANSI Color ********************************************************
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static  final  String ANSI_WHITE = "\u001B[37m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String BLUE_BRIGHT = "\033[0;94m";
    public static final String WHITE_BRIGHT = "\033[0;97m";

    // BackGround Color
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    public static ArrayList<String> stations = new ArrayList<>(Arrays.asList("Delhi", "Jaipur", "Prayagraj", "Mumbai"));


    /*
    Customer Info
     */

    public static ArrayList<String> TravellerName= new ArrayList<String>(50);
    public static ArrayList<String> TravellerPhone= new ArrayList<String>(50);
    public static ArrayList<Integer> TrainFares= new ArrayList<Integer>(50);
    public static ArrayList<Integer> seatNum=new ArrayList<Integer>(50);
    public static ArrayList<String> trainDetails= new ArrayList<String>(50);

    void trainInfo(){
        TrainInfo.Info.displayInfo();
    }



    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);

        while(true){


            System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"*****************************************************************************"+ANSI_RESET);
            System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Available Train between Four Station :                                       "+ANSI_RESET);
            System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"*****************************************************************************"+ANSI_RESET);
            Main o = new Main();
            o.trainInfo();
            System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"*****************************************************************************"+ANSI_RESET);

            System.out.println(WHITE_BRIGHT+"1.Book Tickets              "+ANSI_RESET);
            System.out.println(WHITE_BRIGHT+"2.Display All Ticket information"+ANSI_RESET);
            System.out.println(WHITE_BRIGHT+"3.Search Your Ticket.       "+ANSI_RESET);
            System.out.println(WHITE_BRIGHT+"4.Cancel Your Ticket            "+ANSI_RESET);
            System.out.println(WHITE_BRIGHT+"5.Exit From The Code            "+ANSI_RESET);

            int choice = s.nextInt();
            try{
                switch (choice){
                    case 1 -> {
                        System.out.println(ANSI_BLUE+"Enter Train Number: "+ANSI_RESET);
                        int trainNo = s.nextInt();
                        if(Seats.seatAllocation(trainNo,seatIn1010,seatIn2013,seatIn3045)){
                            System.out.println("Enter Your Name :");
                            String name1 = s.nextLine();
                            TravellerName.add(name1);
                            System.out.println("Enter Your Phone Number: ");
                            String phone = s.nextLine();
                            TravellerPhone.add(phone);
                            Random rand = new Random();
                            Integer seatNo = rand.nextInt(1000 - 500 + 1) + 500;
                            seatNum.add(seatNo);
                            if (trainNo == 1010) {
                                System.out.println("Ticket Price: 1000");
                                TrainFares.add(1000);
                                trainDetails.add("Mumbai-Delhi   13:05   Mumbai Superfast");
                                seatIn1010--;
                            }
                            else if (trainNo == 2013) {
                                System.out.println("Ticket Price: 500");
                                TrainFares.add(500);
                                trainDetails.add("Delhi-Jaipur   7:00    Delhi Superfast");
                                seatIn2013--;
                            }
                            else {
                                System.out.println("Ticket Price: 800");
                                TrainFares.add(800);
                                trainDetails.add("Prayagraj-Delhi    10:00      Prayagraj EXP");
                                seatIn3045--;
                            }
                            System.out.println("Ticket Booking is sucessfully Done.......");
                        }
                    }
                    case 2 ->{
                        System.out.println();
                        System.out.println("***************************************************************************************************");
                        System.out.println(GREEN_BRIGHT+"Sno\t\t\t\t\tTicket Owner\t\t\t\t\tSeat Number\t\t\t\t\tTrain Ticket Price\t\t\t\t\t\t\t\tTrain Details"+ANSI_RESET);
                        if(!TravellerName.isEmpty()) {
                            for (int i=0;i<TravellerName.size();i++) {
                                System.out.println(GREEN_BRIGHT+(i + 1) + "\t\t\t\t\t" + TravellerName.get(i) + "\t\t\t\t\t" + seatNum.get(i) + "\t\t\t\t\t\t\t\t" + TrainFares.get(i) + "\t\t\t\t\t\t\t\t\t\t\t" + trainDetails.get(i)+ANSI_RESET);
                            }
                        }
                        else{
                            System.out.println("No Ticket Is Book So far......");
                        }
                        System.out.println("***************************************************************************************************");
                    }
                    case 3 ->{
                        if (TravellerName.size() > 0) {
                            System.out.println("Enter your Phone Number: ");
                            String phone = s.next();
                            for (int i = 0; i < TravellerName.size(); i++) {
                                if (phone.equals(TravellerPhone.get(i))) {
                                    for(int j=0;j<TravellerName.size();j++) {
                                        String p = TravellerPhone.get(j);
                                        if (phone.equals(p)) {
                                            System.out.println("***************************************************************************************************");
                                            System.out.println(GREEN_BRIGHT + "Sno\t\t\t\t\tTicket Owner\t\t\t\t\tSeat Number\t\t\t\t\tTrain Ticket Price\t\t\t\t\t\t\t\tTrain Details" + ANSI_RESET);
                                            System.out.println(GREEN_BRIGHT + (j + 1) + "\t\t\t\t\t" + TravellerName.get(j) + "\t\t\t\t\t" + seatNum.get(j) + "\t\t\t\t\t\t\t\t" + TrainFares.get(j) + "\t\t\t\t\t\t\t\t\t\t\t" + trainDetails.get(i) + ANSI_RESET);
                                            System.out.println("***************************************************************************************************");
                                        }
                                    }
                                    break;
                                }
                                else if (i == TravellerName.size() - 1) {
                                    System.out.println("Ticket is not Book Yet....");
                                    break;
                                }
                            }
                        }
                        else {
                            System.out.println("Today Ticket Booking not started.");
                        }

                    }

                    case 4 ->{
                        if(TravellerName.size() > 0) {
                            System.out.println("Enter your Phone Number: ");
                            String phoneNo = s.next();
                            for (int i = 0; i < TravellerPhone.size(); i++) {
                                if (phoneNo.equals(TravellerPhone.get(i))) {
                                    TravellerName.remove(i);
                                    seatNum.remove(i);
                                    TravellerPhone.remove(i);
                                    trainDetails.remove(i);
                                    TrainFares.remove(i);


                                }
                                else if (i == TravellerName.size() - 1) {
                                    System.out.println("Ticket is not Book Yet....");
                                    break;
                                }
                            }
                        }
                        else {
                            System.out.println("Today Ticket Booking not started.");
                            break;
                        }
                    }
                    case 5 ->  {
                        System.out.println("Have a Day!!!!!!");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid choice");
                    }
                }
            }
            catch (Exception e) {
                System.out.println(ANSI_RED + "An error has occured.\n Please try again.\nIf the error persists contact helpdesk" + ANSI_RESET);
                System.out.println();
                System.out.println("\nRestarting in 3 seconds");
                Thread.sleep(3000);
            }
        }
    }
}