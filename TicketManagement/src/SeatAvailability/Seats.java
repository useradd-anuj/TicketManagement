package SeatAvailability;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Seats {


    public static boolean seatAllocation(int trainNo,Integer seatIn1010,Integer seatIn2013,Integer seatIn3045) {
        if(trainNo==1010){
            return seatIn1010 != 0;
        }
        else if (trainNo==2013) {
            return seatIn2013 != 0;
        }
        else if (trainNo==3045) {
            return seatIn3045 != 0;
        }
        else{
            System.out.println("Choose right Train Number....");
            return false;
        }
    }
}
