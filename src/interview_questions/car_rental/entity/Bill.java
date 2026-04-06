package interview_questions.car_rental.entity;
import interview_questions.parking_lot.enums.VehicleType;

import java.time.LocalDate;

public class Bill {
  private Integer id;
  private String totalCost;
  private String noOfReservedDays;
  private VehicleType vehicleType;
  private LocalDate billingDate;
  private String storeLocation;
}
