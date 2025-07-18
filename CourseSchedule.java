 
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

         for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

         for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            adjList.get(prereqCourse).add(course);
            inDegree[course]++;
        }

         Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int finishedCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            finishedCourses++;

            for (int neighbor : adjList.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

         return finishedCourses == numCourses;
    }
 
}
