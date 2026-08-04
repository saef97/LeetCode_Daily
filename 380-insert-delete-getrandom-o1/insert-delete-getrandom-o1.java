class RandomizedSet {
    Set<Integer> map;
    public RandomizedSet() {
        map = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!map.contains(val)){
            map.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(!map.contains(val))
        return false;
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        List<Integer> res = new ArrayList<>(map);
        return res.get(new Random().nextInt(map.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */