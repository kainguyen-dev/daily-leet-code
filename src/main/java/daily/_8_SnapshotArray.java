package daily;

import java.util.TreeMap;

public class _8_SnapshotArray {

    // 1 2 3 4 5 // init
    // 8 2 3 9 2 // change 1-> 8,
    // https://leetcode.com/problems/snapshot-array/editorial/

    static class SnapshotArray {

        int snapId = 0;
        TreeMap<Integer, Integer>[] historyRecords;
        // Format snap id, value

        public SnapshotArray(int length) {
            historyRecords = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                historyRecords[i] = new TreeMap<>();
                historyRecords[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            historyRecords[index].put(snapId, val);
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return historyRecords[index].floorEntry(snap_id).getValue();
            // Floor key here because we want to get the closet
        }
    }


}
