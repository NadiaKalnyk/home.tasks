package ua.hillel.homeTask_10;

/*Створити програму - список покупок. В список заносяться назва товару та кількість.
Список заповнити випадковими товарами. В кінці потрібно підрахувати загальну кількість всіх доданих товарів*/


import java.util.HashMap;
import java.util.Map;

public class Purchase {
    public static void main(String[] args) {

        Map <String, Integer> map = new HashMap<>();
        map.put ("apples", 10);
        map.put ("bananas", 5);
        map.put ("grapes", 3);
        map.put ("oranges", 4);
        map.put ("mango", 1);
        System.out.println("List of the products - " + map);

        for (int i = 0; i < 1; i++) {
            int countsOfProducts = 0;
            countsOfProducts = map.get("apples") + map.get("bananas") + map.get("grapes") + map.get("oranges") + map.get("mango");
            System.out.println("Your count of product is " + countsOfProducts);
        }
    }
}

