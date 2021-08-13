package pattern;
 interface Hotel
{
    public String getMenus();
}
 class NonVegRestaurant implements Hotel
{
    public String getMenus()
    {
        return "Non Vegetable Menu";
    }
}

 class VegRestaurant implements Hotel
{
    public String getMenus()
    {
        return "Vegetable Menu";
    }
}

 class VegNonBothRestaurant implements Hotel
{
    public String getMenus()
    {
        return "Vegetable and NonVegetable Menu";
    }
}


 class HotelKeeper
{
    Hotel vegRestaurant,nonVegRestaurant,vegNonBothRestaurant;
    public HotelKeeper(){
         vegRestaurant = new VegRestaurant();
         nonVegRestaurant = new NonVegRestaurant();
         vegNonBothRestaurant = new VegNonBothRestaurant();
    }
    public String getVegMenu()
    {
       return vegRestaurant.getMenus();
    }

    public String getNonVegMenu()
    {
        return nonVegRestaurant.getMenus();
    }

    public String getVegNonMenu()
    {
        return vegNonBothRestaurant.getMenus();
    }
}
public class Facade {
    public static void main (String[] args)
    {
        HotelKeeper hotelKeeper = new HotelKeeper();
        System.out.println(hotelKeeper.getNonVegMenu());
        System.out.println(hotelKeeper.getVegMenu());
        System.out.println(hotelKeeper.getVegNonMenu());
    }
}
