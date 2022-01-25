import java.util.*;
import java.util.stream.Collectors;

public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Set<String> suppl = Arrays.stream(supplies).collect(Collectors.toSet());
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            int notInSupplies = 0;
            for (String ingredient: ingredients.get(i)) {
                if (!suppl.contains(ingredient)) {
                    ingredientToRecipes.computeIfAbsent(ingredient, ingr -> new HashSet<>()).add(recipes[i]);
                    notInSupplies++;
                }
            }
            if (notInSupplies == 0) result.add(recipes[i]);
            else {
                inDegree.put(recipes[i], notInSupplies);
            }
        }
        for (int i = 0; i < result.size(); ++i) {
            if (!ingredientToRecipes.containsKey(result.get(i))) continue;
            for (String recipe: ingredientToRecipes.remove(result.get(i))) {
                if (inDegree.merge(recipe, -1, Integer::sum) == 0) {
                    result.add(recipe);
                }
            }
        }
        return result;
    }
}
