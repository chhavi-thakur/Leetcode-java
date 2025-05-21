import java.util.Arrays;

public class FindContentChildren {
    public static void main(String[] args) {
        FindContentChildren solution = new FindContentChildren();

        int[] g = {1, 2, 3};  // greed factors
        int[] s = {1, 1};     // cookie sizes

        int result = solution.findContentChildren(g, s);
        System.out.println("Number of content children: " + result);  // Output: 1
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }

        return child;
    }
}
