class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        //Set<Integer> set = 
        //set.add(n);
        List<Integer> list = new ArrayList<>();
          if (n == 1)
                return true;
        while (n > 0) {
            // if(set.contains(n))return false;

          
            int rem = n % 10;
            list.add(rem);
            n = n / 10;
        }
        int sq = 0;
        for (int a : list) {
            sq += (a * a);

        }
        if (set.contains(sq))
            return false;
        set.add(sq);
        return isHappy(sq);

    }
}