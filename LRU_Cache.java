import java.util.*;
class Node{
    int key;
    int value;
    Node next;
    Node prev;
    
    public Node(int key,int value){
        this.key=key;
        this.value=value;
        next = null;
        prev = null;
    }
}
public class LRU_Cache {
    private int capacity;
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;

    public LRU_Cache(int capacity){
            this.capacity = capacity;
            map = new HashMap<>();

            head =new Node(0,0);
            tail = new Node(0,0);
            
            head.next = tail;
            tail.prev = head;
        }
        private void addNode(Node node){
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
        }
        private void removeNode(Node node){
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        
        private void moveToHead(Node node){
            removeNode(node);
            addNode(node);
        }
        
        private Node popTail(){
            Node popped = tail.prev;
            removeNode(popped);
            return popped;
        }

        public int get(int key){
            Node cache = map.get(key);
            if(cache!=null){
                moveToHead(cache);
                return cache.value;
            }
            return -1;
        }
        public void put(int key , int value){
            if(map.containsKey(key)){
                 Node cache = map.get(key);
                 cache.value = value;
                 moveToHead(cache);
            }
            else{
                Node newnode = new Node(key,value);
                addNode(newnode);
                map.put(key,newnode);
                if(map.size() > capacity){
                    Node lru = popTail();
                    map.remove(lru.key);
                }
            }
        }
}
