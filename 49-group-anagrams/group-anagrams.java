class Solution {
    String sort(String s) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        return new String(ss);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // 
        List<List<String>> list = new ArrayList<>();
        // list.add(strs[0]);
        Map<String,List<String>> map = new HashMap<>();
        int n = strs.length;

        for (int i = 0; i < n; i++) {

            String cur = strs[i];
            String Scur = sort(cur);
            if (!map.containsKey(Scur)) {
                List<String> l = new ArrayList<>();
                l.add(cur);
                map.put(Scur, l);

            } else {
                //map.put(scur);
                List<String> l = map.get(Scur);
                l.add(cur);
                map.put(Scur, l);
            }

        }
        for (List<String> res : map.values()) {
            list.add(res);
        }
        return list;
    }
}