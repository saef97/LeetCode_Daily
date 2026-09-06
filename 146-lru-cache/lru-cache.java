class LRUCache {
    class Node{
        int key;int val;
        Node next;Node prev;

        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Map<Integer,Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    void addToTail(Node node)//MRU
    {
        node.prev = tail.prev;//tail-->A so node-->A also
        node.next = tail;//|A|node|tail|
        tail.prev.next = node;// A-->node
        tail.prev = node;//jo phle tail A ki tarf tha wo connection tod diya

    }
    void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        removeNode(node);
        addToTail(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node !=null ){
            node.val = value;
            removeNode(node);
            addToTail(node);
        }else{
        if(map.size() == capacity){
            Node lru = head.next;
            removeNode(lru);
            map.remove(lru.key);
        }
        
        Node newNode = new Node(key,value);
        addToTail(newNode);
        map.put(key,newNode);}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */