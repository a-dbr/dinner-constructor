package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DinnerConstructor {
    Map<String, List<String>> dishesList;

    DinnerConstructor() {
        dishesList = new HashMap<>();
    }

    void addDish(String dishType, String dishName) {
        if (dishType.isEmpty() || dishName.isEmpty()) {
            System.out.println("Тип или название блюда не может быть пустым!");
            return;
        }

        if (dishesList.containsKey(dishType)) {
            List<String> dishesNames = dishesList.get(dishType);
            dishesNames.add(dishName);
        } else {
            List<String> dishesNames = new ArrayList<>();
            dishesNames.add(dishName);
            dishesList.put(dishType, dishesNames);
        }
    }

    List<String> generateDish(List<String> requestedDishesTypes) {
        List<String> generatedDishesList = new ArrayList<>();

        for (String dishType : requestedDishesTypes) {
            if (checkType(dishType)) {
                List<String> dishList = dishesList.get(dishType);
                String randomDish = dishList.get(Main.random.nextInt(dishList.size()));

                generatedDishesList.add(randomDish);
            } else {
                System.out.printf("Блюд типа \"%s\" нет в списке!", dishType);
                System.exit(1); // Исключения еще не проходили, сделал выход таким
            }
        }
        return generatedDishesList;
    }

    private boolean checkType(String type) {
        return dishesList.containsKey(type);
    }

}
