public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[200];
        int[] map2 = new int[200];

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings checker = new IsomorphicStrings();

        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        System.out.println("Is 'egg' and 'add' isomorphic? " + checker.isIsomorphic(s1, t1));
        System.out.println("Is 'foo' and 'bar' isomorphic? " + checker.isIsomorphic(s2, t2));
    }
}
