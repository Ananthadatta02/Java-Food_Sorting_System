package collection_treeset;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Food
{
	private String typeOfFood;
	private String nameOfFood;
	private String quality;
	private int price;
	private double rating;
	
	public String getTypeOfFood() {
		return typeOfFood;
	}

	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getNameOfFood() {
		return nameOfFood;
	}

	public int getPrice() {
		return price;
	}

	public Food(String typeOfFood, String nameOfFood, String quality, int price, double rating) 
	{
		this.typeOfFood = typeOfFood;
		this.nameOfFood = nameOfFood;
		this.quality = quality;
		this.price = price;
		this.rating = rating;
	}

	@Override
	public String toString() 
	{
		return "Food [typeOfFood=" + typeOfFood + ", nameOfFood=" + nameOfFood + ", quality=" + quality + ", price="
				+ price + ", rating=" + rating + "]\n";
	}
}

class FilterBasedOnQuality implements Comparator<Food>
{
	@Override
	public int compare(Food f1, Food f2) 
	{
		return f1.getQuality().compareTo(f2.getQuality());
	}
	
}
class FilterBasedOnPrice implements Comparator<Food>
{
	@Override
	public int compare(Food f1, Food f2) 
	{
		if(f1.getPrice() > f2.getPrice())
			return 1;
		else if(f1.getPrice() < f2.getPrice())
			return -1;
		else
			return 0;
	}
	
}
class FilterBasedOnRatings implements Comparator<Food>
{
	@Override
	public int compare(Food f1, Food f2) 
	{
		if(f1.getRating() > f2.getRating())
			return 1;
		else if(f1.getRating() < f2.getRating())
			return -1;
		else
			return 0;
	}
	
}

public class FoodMainClass
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		while(true)
		{
			TreeSet<Food> ts = null;
			System.out.println("Press 1 to Filter Based On Quality");
			System.out.println("Press 2 to Filter Based On Price");
			System.out.println("Press 3 to Filter Based On Rating");
			switch(s.nextInt())
			{
			case 1 : ts = new TreeSet<Food>(new FilterBasedOnQuality());
			break;			
			case 2 : ts = new TreeSet<Food>(new FilterBasedOnPrice());
			break;			
			case 3 : ts = new TreeSet<Food>(new FilterBasedOnRatings());
			break;
			default : System.out.println("Invalid Choice..");
			break;
			}
			
			ts.add(new Food("Veg", "Malai Koftha", "Super", 240, 4.5));
			ts.add(new Food("Veg", "Butter Naan", "Good..", 35, 4.0));
			ts.add(new Food("Non-Veg", "Chicken Biryani", "Excellent", 150, 4.3));
			ts.add(new Food("Non-Veg", "Chicken Fry", "Good", 120, 4.2));
			ts.add(new Food("Veg", "Potato Fry", "Good..Could be Better", 30, 4.1));
			
			System.out.println(ts);
			System.out.println("Do you want to Continue.. y/n ");
			char ch = s.next().charAt(0);
			if(ch=='n')
				break;
		}
	}
}