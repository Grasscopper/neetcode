// LRU CACHE
class LinkedList9 {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.cache = new HashMap<>();
    }


    
    public int get(int key) {
        if (size == 0) return -1;
        if (this.cache.get(key) == null) return -1;

        if (size == 1) return this.cache.get(key).value;
        if (size == 2) {
            Node first = head;
            Node second = head.next;

            second.next = first;
            second.prev = null;

            first.next = null;
            first.prev = second;

            head = first;

            return this.cache.get(key).value;
        }

        Node node = this.cache.get(key);

        // step 1: "stitch" the next and prev node together
        Node left = node.prev;
        Node right = node.next;

        left.next = right;
        if (right != null) {
            right.prev = left;
        } else {
            this.tail = left;
        }

        node.next = this.head;
        this.head.prev = node;
        this.head = node;

        if (this.size == capacity) {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (cache.size() == 0) {
            node.next = null;
            node.prev = null;

            head = node;
            tail = node;
            
            cache.put(key, node);
        } else if (cache.size() < capacity) {
            node.next = head;
            node.prev = null;

            head.prev = node;
            head = node;

            cache.put(key, node);
        } else if (cache.size() == capacity) {
            node.next = head;
            node.prev = null;

            head.prev = node;
            head = node;

            cache.remove(tail.key);
            tail.prev.next = null;
            tail = tail.prev;

            cache.put(key, node);
        }
    }
}
