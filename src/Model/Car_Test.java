public class Car_Test {
    public static void main (String[] args){
        Cars bmw = new Cars();
        bmw.setBrand("BMW");
        bmw.model = "X6M";
        bmw.color = "Black Metallic";
        bmw.year = 2026;
        bmw.transmission = "8 Speed Automatic";
        bmw.engine_size = 4.4;
        bmw.fuel_type = "Gasoline";
        bmw.horse_power = 617;
        bmw.accelaration = 3.7;
        bmw.mileage = 15000;
        bmw.engine_on = false;
        bmw.Is_SUV = true;
        bmw.Is_Cabriolet = false;

        Cars porsche = new Cars();
        porsche.setBrand("Porsche");
        porsche.model = "911 Turbo S";
        porsche.color = "Burgundy";
        porsche.year = 2026;
        porsche.transmission = "8 Speed Automatic";
        porsche.engine_size = 3.6;
        porsche.fuel_type = "Gasoline";
        porsche.horse_power = 701;
        porsche.accelaration = 2.4;
        porsche.mileage = 1500;
        porsche.engine_on = true;
        porsche.Is_SUV =  false;
        porsche.Is_Cabriolet = true;

        Cars escalade = new Cars();

        escalade.setBrand("Cadillac");
        escalade.model = "Escalade V";
        escalade.year = 2026;
        escalade.color = "Black";
        escalade.transmission = "10-Speed Automatic";
        escalade.engine_size = 6.2;
        escalade.fuel_type = "Gasoline";
        escalade.horse_power = 682;
        escalade.accelaration = 4.4;
        escalade.mileage = 0;
        escalade.engine_on = false;
        escalade.Is_SUV = true;
        escalade.Is_Cabriolet = false;

        Cars rs7 = new Cars();

        rs7.setBrand("Audi");
        rs7.model = "RS7 Performance";
        rs7.year = 2026;
        rs7.color = "Nardo Gray";
        rs7.transmission = "8-Speed Automatic";
        rs7.engine_size = 4.0;
        rs7.fuel_type = "Gasoline";
        rs7.horse_power = 621;
        rs7.accelaration = 3.4;
        rs7.mileage = 0;
        rs7.engine_on = false;
        rs7.Is_SUV = false;
        rs7.Is_Cabriolet = false;

        Cars cullinan = new Cars();

        cullinan.setBrand("Rolls-Royce");
        cullinan.model = "Cullinan Series II";
        cullinan.year = 2026;
        cullinan.color = "White";
        cullinan.transmission = "8-Speed Automatic";
        cullinan.engine_size = 6.75;
        cullinan.fuel_type = "Gasoline";
        cullinan.horse_power = 592;
        cullinan.accelaration = 4.9;
        cullinan.mileage = 0;
        cullinan.engine_on = false;
        cullinan.Is_SUV = true;
        cullinan.Is_Cabriolet = false;

        Cars g63 = new Cars();

        g63.setBrand("Mercedes-Benz");
        g63.model = "AMG G63";
        g63.year = 2026;
        g63.color = "Obsidian Black";
        g63.transmission = "9-Speed Automatic";
        g63.engine_size = 4.0;
        g63.fuel_type = "Gasoline";
        g63.horse_power = 577;
        g63.accelaration = 4.2;
        g63.mileage = 0;
        g63.engine_on = false;
        g63.Is_SUV = true;
        g63.Is_Cabriolet = false;







        bmw.printInfo();
        System.out.println("------------------------------");
        porsche.printInfo();
        System.out.println("------------------------------");
        escalade.printInfo();
        System.out.println("------------------------------");
        rs7.printInfo();
        System.out.println("------------------------------");
        cullinan.printInfo();
        System.out.println("------------------------------");
        g63.printInfo();
        System.out.println("------------------------------");



    }


}
