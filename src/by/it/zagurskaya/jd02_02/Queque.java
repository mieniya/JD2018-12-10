package by.it.zagurskaya.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queque  {
    private Deque<Buyer> q = new LinkedList<>();
//    private Deque<Buyer> q = new ArrayDeque<>();

    void add(Buyer buyer) {
        q.add(buyer);
    }
//    static void pull() {
//        q.pollFirst(b);
//    }
}
