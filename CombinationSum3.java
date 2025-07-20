 
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int start) {
         if (k == 0 && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

         if (k == 0 || n < 0) {
            return;
        }

         for (int i = start; i <= 9; i++) {
            combination.add(i); 
            backtrack(result, combination, k - 1, n - i, i + 1); 
            combination.remove(combination.size() - 1); 
        }
    }

     
}
