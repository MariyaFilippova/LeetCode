public class DesignHashMap {
    Element[] hashMap;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    class Element {
        int key;
        int value;
        Element next;

        Element(int k, int v) {
            key = k;
            value = v;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj instanceof Element) {
                Element e = (Element)obj;
                return this.value == e.value && this.key == e.key;
            }
            return false;
        }
    }

    public DesignHashMap() {
        hashMap = new Element[DEFAULT_INITIAL_CAPACITY];
    }

    public int get(int key) {
        int hash = DesignHashMap.hash(key);
        if (hashMap[hash] == null) {
            return -1;
        }
        Element current = hashMap[hash];
        while (current != null) {
            int k = current.key;
            if (k == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = DesignHashMap.hash(key);
        if (hashMap[hash] == null) {
            return;
        }
        Element current = hashMap[hash];
        Element prev = null;
        while (current != null) {
            int k = current.key;
            if (k == key) {
                if (prev != null)
                    prev.next = current.next;
                else {
                    hashMap[hash] = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void put(int key, int value) {
        Element e = new Element(key, value);
        int hash = DesignHashMap.hash(key);
        if (hashMap[hash] == null) {
            hashMap[hash] = e;
        }
        else {
            Element current = hashMap[hash];
            Element prev = null;
            while (current != null) {
                int k = current.key;
                if (k == key) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            if (prev != null)
                prev.next = new Element(key, value);
        }
    }
}
