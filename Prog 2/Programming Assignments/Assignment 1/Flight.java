import java.util.Date;
import java.text.*;

public class Flight {
    private String airline;
    private int flightNo;
    private String takeoff;
    private String landing;
    private double cost;

    public Flight(String airline, int flightNo, String takeoff, String landing, double cost) {
     this.airline = airline;
     this.flightNo = flightNo;
     this.takeoff = takeoff;
     this.landing = landing;
     this.cost = cost;
    }

    public String getAirline() {
        return this.airline;
    }

    public int getFlightNo() {
        return this.flightNo;
    }

    public String getTakeoff() {
        return this.takeoff;
    }

    public String getLanding() {
        return this.landing;
    }

    public double getCost() {
        return this.cost;
    }
    public boolean hasInt(int n) {
        return true;
    }
    public boolean hasDouble(double n) {
        return true;
    }


    @Override
    public String toString() {
        return airline + " Flight " + flightNo + " from " + takeoff + " to " + landing + " for " + formatted(cost);
    }
    //toString(): Should print out the information 
    //of the flight in the following format:
//{airline} Flight {flight number} from {takeoff country} to {landing country} for the price of ${cost of 
//the flight}
//Example: American Airlines Flight 677 from Argentina to Spain for the price of $260.44
    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}