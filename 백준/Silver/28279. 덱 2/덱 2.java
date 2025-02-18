import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedDequeue dequeue = new LinkedDequeue();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());

            switch (option) {
                case 1:
                    dequeue.pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    dequeue.pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    bw.write(dequeue.pollFront() + "\n");
                    break;
                case 4:
                    bw.write(dequeue.pollBack() + "\n");
                    break;
                case 5:
                    bw.write(dequeue.getSize() + "\n");
                    break;
                case 6:
                    bw.write((dequeue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case 7:
                    bw.write(dequeue.getFront() + "\n");
                    break;
                case 8:
                    bw.write(dequeue.getBack() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {
    int data;
    Node nextNode;
    Node previousNode;

    public Node(int data) {
        this.data = data;
        this.previousNode = null;
        this.nextNode = null;
    }
}

class LinkedDequeue {
    private Node front;
    private Node back;
    private int size;

    public LinkedDequeue() {
        front = back = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = back = newNode;
        } else {
            newNode.nextNode = front;
            front.previousNode = newNode;
            front = newNode;
        }
        ++size;
    }

    public void pushBack(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = back = newNode;
        } else {
            back.nextNode = newNode;
            newNode.previousNode = back;
            back = newNode;
        }
        ++size;
    }

    public int pollFront() {
        if (isEmpty()) {
            return -1;
        }

        int value = front.data;
        front = front.nextNode;

        if (front != null) {
            front.previousNode = null;
        } else {
            back = null;
        }

        --size;
        return value;
    }

    public int pollBack() {
        if (isEmpty()) {
            return -1;
        }

        int value = back.data;
        back = back.previousNode;

        if (back != null) {
            back.nextNode = null;
        } else {
            front = null;
        }

        --size;
        return value;
    }

    public int getFront() {
        return isEmpty() ? -1 : front.data;
    }

    public int getBack() {
        return isEmpty() ? -1 : back.data;
    }

    public int getSize() {
        return size;
    }
}
