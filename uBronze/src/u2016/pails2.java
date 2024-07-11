package u2016;

import java.util.*;
import java.io.*;
public class pails2 {

public static void main(String[] args) throws IOException {

BufferedReader in = new BufferedReader(new FileReader("pails.in"));
PrintWriter out = new PrintWriter("pails.out");
StringTokenizer st = new StringTokenizer(in.readLine());

int b1 = Integer.parseInt(st.nextToken());
int b2 = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());

int closest = 0;
for(int first = 0; first <= M; first++) {

if(b1 * first > M) {
break;
}

for(int second = 0; second <= M; second++) {

int temp = (b1*first) + (b2*second);
if(temp > M) {
break;
}
closest = Math.max(closest, temp);

}

}

out.println(closest);
in.close();
out.close();

}

}
