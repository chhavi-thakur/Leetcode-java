 
public class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
         TreeSet<Integer> coords = new TreeSet<>();
        for (int[] pos : positions) {
            coords.add(pos[0]);
            coords.add(pos[0] + pos[1]);
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        int idx = 0;
        for (int x : coords) {
            indexMap.put(x, idx++);
        }

        int[] height = new int[idx];
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0;

         for (int[] pos : positions) {
            int left = indexMap.get(pos[0]);
            int right = indexMap.get(pos[0] + pos[1]);
            int baseHeight = 0;
             for (int i = left; i < right; i++) {
                baseHeight = Math.max(baseHeight, height[i]);
            }

             int newHeight = baseHeight + pos[1];
            for (int i = left; i < right; i++) {
                height[i] = newHeight;
            }

            maxHeight = Math.max(maxHeight, newHeight);
            result.add(maxHeight);
        }

        return result;
    }

     }
