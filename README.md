# Food Filter System - Java Application

## Overview

This is a Java-based Food Filter System that allows users to filter a list of food items based on **quality**, **price**, or **rating**. The system utilizes a `TreeSet` with custom comparators to sort and display food items in the desired order. It demonstrates basic object-oriented principles such as classes, getters and setters, and comparator-based sorting.

---

## Key Features

- **Filter Based on Quality**: Filters and sorts food items based on their quality (e.g., "Excellent", "Good", etc.).
- **Filter Based on Price**: Filters food items based on price (ascending order).
- **Filter Based on Ratings**: Filters food items based on user ratings (ascending order).
- **Interactive User Interface**: Allows users to select the filter criteria and displays the sorted food list accordingly.

---

## Code Structure

### 1. **Food Class**

The `Food` class represents a food item with the following attributes:

- `typeOfFood`: The type of food (e.g., Veg, Non-Veg).
- `nameOfFood`: The name of the food item.
- `quality`: The quality of the food item (e.g., Excellent, Good).
- `price`: The price of the food item.
- `rating`: The user rating of the food item.

#### Constructors and Methods

- **Constructor**: Initializes the attributes of the food item.
- **Getters and Setters**: Provides methods to get and set the values of the attributes.
  - `getTypeOfFood()`: Returns the type of food.
  - `setTypeOfFood(String typeOfFood)`: Sets the type of food.
  - `getNameOfFood()`: Returns the name of the food.
  - `getQuality()`: Returns the quality of the food.
  - `setQuality(String quality)`: Sets the quality of the food.
  - `getRating()`: Returns the rating of the food.
  - `setRating(int rating)`: Sets the rating of the food.
  - `getPrice()`: Returns the price of the food.

---

### 2. **Filter Classes**

The project utilizes three filter classes, each implementing `Comparator<Food>` to sort the food items based on different criteria.

#### **FilterBasedOnQuality Class**
- This comparator compares two `Food` objects based on their `quality` attribute. It uses the `compareTo()` method to perform string-based sorting of food items.

```java
public class FilterBasedOnQuality implements Comparator<Food> {
    @Override
    public int compare(Food f1, Food f2) {
        return f1.getQuality().compareTo(f2.getQuality());
    }
}
```
#### FilterBasedOnPrice Class
- This comparator compares two Food objects based on their price attribute. It sorts the food items in ascending order based on price.
```java
public class FilterBasedOnPrice implements Comparator<Food> {
    @Override
    public int compare(Food f1, Food f2) {
        return Integer.compare(f1.getPrice(), f2.getPrice());
    }
}
```
#### FilterBasedOnRatings Class
- This comparator compares two Food objects based on their rating attribute. It sorts the food items in ascending order based on the rating.
```java
public class FilterBasedOnRatings implements Comparator<Food> {
    @Override
    public int compare(Food f1, Food f2) {
        return Double.compare(f1.getRating(), f2.getRating());
    }
}
```
### 3. Main Class (FoodMainClass)
The FoodMainClass is the entry point for the program. It provides an interactive user interface that allows users to choose a filter criterion (quality, price, or rating) and displays the sorted food items accordingly.

```java
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
```
#### Key Components:
- A Scanner object is used to read user input.
- A TreeSet<Food> is created with the selected filter class to store and sort the food items.
- The system adds several Food objects to the TreeSet and sorts them based on the selected filter.
- After displaying the sorted food items, the user is asked if they want to continue filtering or exit the program.

## How to Use
- Clone or download the repository to your local machine.
- Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).
- Run the FoodMainClass class to start the application.
- Choose an option to filter the food items by quality, price, or rating.
- The program will display the sorted food list based on the selected filter.
- After each filter, you can decide if you want to continue or exit.

## Conclusion
This project demonstrates the use of Java's TreeSet to store and sort objects based on different criteria. By using custom comparators, the program allows for flexible sorting of food items based on user preferences.

## Clone
```java
git clone https://github.com/Ananthadatta02/Java-Food_Sorting_System.git
```
#### Instructions:
- Open your terminal or command prompt.
- Navigate to the directory where you want to clone the repository.
- Run one of the above command.
- Once the repository is cloned, you can navigate into the project folder with:
