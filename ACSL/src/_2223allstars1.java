import java.util.*;

public class _2223allstars1 {
	public static int changedPositions(String customers) {
        int changes = 0;
        String[] s = customers.split(" ");
        int [] list = new int [s.length];
        for (int i =0; i<s.length; i++) {
            list[i] = Integer.parseInt(s[i]);
        }
        int n = list.length;
        
        for (int i = 1; i<=n; i++) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            int place = -1;
            for (int r = 0; r<list.length; r++){
                if (list[r] == i) {
                    place = r;
                }
            }
            
            for (int t =0; t<=place; t++) {
                l.add( list[place-t]);
            }
            for (int t = place+1; t<list.length; t++) {
                l.add(list[t]);
            }
            
            for (int t = 0; t<list.length; t++) {
                if (l.get(t) != list[t]) {
                    changes ++;
                }
            }
            list = new int [l.size()-1];
            for (int r = 1; r<l.size(); r++) {
                list[r-1] = l.get(r);
            }
            
            
        }
        
        return changes;
    }
}
