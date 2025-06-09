 
public class Solution {
    public String simplifyPath(String path) {
         Deque<String> stack = new ArrayDeque<>();

         String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                 continue;
            } else if (component.equals("..")) {
                 if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                 stack.push(component);
            }
        }

         StringBuilder canonicalPath = new StringBuilder();
        for (String dir : stack) {
            canonicalPath.insert(0, "/" + dir);
        }

         return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }

     
}
