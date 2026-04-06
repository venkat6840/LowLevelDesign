package creational_patterns.abstract_factory;

public interface CarFactory {
    // Factory methods
    CarInterior createInterior();

    CarExterior createExterior();

    default void produceCompleteVehicle() {
        System.out.println("Starting complete vehicle production...");
        CarInterior carInterior = createInterior();
        CarExterior carExterior = createExterior();

        //Assemble
        carInterior.addInteriorComponents();
        carExterior.addExteriorComponents();
        System.out.println("Vehicle production completed!");
    }

}
