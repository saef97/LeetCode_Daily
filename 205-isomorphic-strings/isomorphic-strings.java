class Solution {
    public boolean isIsomorphic(String s, String t) {
        List<Character> sl = new ArrayList<>();
        List<Character> tl = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!sl.contains(s.charAt(i))) {
                res.add(i);
                sl.add(s.charAt(i));
            } else {
                res.add(sl.indexOf(s.charAt(i)));
            }
        }
        for (int i = 0; i < n; i++) {
            if (!tl.contains(t.charAt(i))) {
                rest.add(i);
                tl.add(t.charAt(i));
            } else {
                rest.add(tl.indexOf(t.charAt(i)));
            }
        }
        if (res.equals(rest)) {
            return true;
        }
        return false;

    }
}