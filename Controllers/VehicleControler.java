package Controllers;

import java.io.Serializable;

import Models.VehicleModule;
import Views.VehicleView;

public class VehicleControler implements Serializable {
    VehicleModule module;
    VehicleView view;

    public VehicleControler(VehicleModule module, VehicleView view) {
       
        this.module = module;
        this.view = view;
    }




    public void addVhicle() {
                                
        this.module.addVhicle(   this.view.addVhicle()   );

    }




    public void displayVehicle(String Type) {

        

        if (Type.equals("truck")){


           this.module.readTrukFromFile();

             this.view.displayTruck(module.getT());

        }
           
        else if (Type.equals("transport")){
            this.module.readTransportFromFile();
             this.view.displayTransport(module.getTrans());
        }
           

        else {
            this.module.readPrivateCarFromFile();
             this.view.displayPrivateCar(module.getCar());
        }
       
           

    }

    public void displayAll(){
        // truck 
        this.module.readTrukFromFile();

             this.view.displayTruck(module.getT());
        // transport
        this.module.readTransportFromFile();
             this.view.displayTransport(module.getTrans());
        // private
        this.module.readPrivateCarFromFile();
             this.view.displayPrivateCar(module.getCar());
        
    }

    public void serchForCar(String annual, String Type ){

        
        if (Type.equals("truck")){


            this.module.readTrukFromFile();
            this.module.getT().stream().filter(p->p.getAnnualNumber().equals(annual)).forEach(System.out::println);
           
         }
            
         else if (Type.equals("transport")){
             this.module.readTransportFromFile();
              this.module.getTrans().stream().filter(p->p.getAnnualNumber().equals(annual)).forEach(System.out::println);
         }
            
 
         else if(Type.equals("private")) {
             this.module.readPrivateCarFromFile();
              this.module.getCar().stream().filter(p->p.getAnnualNumber().equals(annual)).forEach(System.out::println);
         }
        
        


    }

    public void DeleteVehicle(int plateNumber, String Type){

        if (Type.equals("truck")){
    
    
            this.module.readTrukFromFile();
            this.module.getT().stream().filter(p->p.getPlateNumber()==plateNumber).forEach(System.out::println);
           this.module.addnewTruckToFile();
         }
            
         else if (Type.equals("transport")){
             this.module.readTransportFromFile();
              this.module.getTrans().stream().filter(p->p.getPlateNumber()==plateNumber).forEach(System.out::println);
              this.module.aaddnewTransportCarToFile();
         }
            
    
         else if(Type.equals("private")) {
             this.module.readPrivateCarFromFile();
              this.module.getCar().stream().filter(p->p.getPlateNumber()==plateNumber).forEach(System.out::println);
              this.module.addnewPrivateCarToFile();
         }
    
    
       }

     

   





}

