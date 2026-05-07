import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {
    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    // Map from food name → latest Food object (with current rating)
    private Map<String, Food> foodMap;

    private Map<String, PriorityQueue<Food>> cuisineMap;

    public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            String cuisine = cuisines[i];
            foodMap.put(foods[i], food);

            PriorityQueue<Food> pq = cuisineMap.computeIfAbsent(cuisine, k -> new PriorityQueue<>(
                    (a, b) ->
                    {
                        if(a.rating == b.rating)
                        {
                            return a.name.compareTo(b.name);
                        }
                        return b.rating-a.rating;
                    } ));
            pq.offer(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food oldFood = foodMap.get(foodName);
        Food newFood = new Food(foodName, oldFood.cuisine, newRating);

        foodMap.put(foodName, newFood);

        cuisineMap.get(oldFood.cuisine).add(newFood);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineMap.get(cuisine);

        // Lazy deletion pattern
        while (!pq.isEmpty()) {
            Food top = pq.peek();
            Food latest = foodMap.get(top.name);
            if (top.rating == latest.rating) {
                return top.name;
            } else {
                pq.poll();
            }
        }
        return "";
    }


}