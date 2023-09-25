//package u2023;
import java.util.*;
import java.io.*;

public class mooLanguage2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int T1 = 0; T1 < T; T1++) {
            int N = sc.nextInt(),
                C = sc.nextInt(),
                P = sc.nextInt();
            
            Stack<String> nouns = new Stack<String>(),
                        tverbs = new Stack<String>(),
                        iverbs = new Stack<String>(),
                        conjs = new Stack<String>();
            
            for (int i = 0; i < N; i++) {
                String word = sc.next(),
                        type = sc.next();
                
                switch (type) {
                    case "noun": nouns.push(word); break;
                    case "transitive-verb": tverbs.push(word); break;
                    case "intransitive-verb": iverbs.push(word); break;
                    case "conjunction": conjs.push(word); break;
                }
            }

            int[] v = { 0, 0, 0, 0 };
            int[] v2 = { 0, 0, 0, 0 };
            for (int n_tverbs = 0; n_tverbs <= tverbs.size(); n_tverbs++) {
                int n_iverbs = Math.min(iverbs.size(), nouns.size() - 2 * n_tverbs);
                int n_conj = 0;

                while (n_iverbs >= 0) {
                    n_conj = Math.min(conjs.size(), (n_tverbs + n_iverbs) / 2);
                    if (n_tverbs + n_iverbs - n_conj <= P)
                        break;

                    n_iverbs--;
                }

                if (n_iverbs < 0)
                    continue;
                
                int extra_nouns = Math.min(C, nouns.size() - (n_iverbs + n_tverbs * 2));
                if (n_tverbs == 0)
                    extra_nouns = 0;
                
                int n_words = 3 * n_tverbs + 2 * n_iverbs + n_conj + extra_nouns;
                
                // Possible solution! 
                v2[0] = n_words;
                v2[1] = n_tverbs;
                v2[2] = n_iverbs;
                v2[3] = n_conj;

                // Check if the solution we came up with is better 
                boolean copy = false;
                for (int i = 0; i < 4; i++) {
                    if (v2[i] > v[i]) { copy = true; break; }
                }

                // If it is, we should copy it...
                if (copy) {
                    v[0] = v2[0];
                    v[1] = v2[1];
                    v[2] = v2[2];
                    v[3] = v2[3];
                }
            }

            int n_words = v[0];
            int n_tverbs = v[1];
            int n_iverbs = v[2];
            int n_conj = v[3];

            System.out.println(n_words);

            StringBuilder s = new StringBuilder();
            
            // Basic sentences first
            for (int i = 0; i < n_iverbs; i++) {
                // intransitive sentence = "noun verb."
                s.append(nouns.pop());
                s.append(" ");
                s.append(iverbs.pop());
                if (i != n_iverbs - 1 && i % 2 == 1 && conjs.size() != 0) {
                    s.append(" ");
                    s.append(conjs.pop());
                    s.append(" ");
                } else
                    s.append(". ");
            }
            for (int i = 0; i < n_tverbs; i++) {
                // transitive sentence = "noun verb noun."
                s.append(nouns.pop());
                s.append(" ");
                s.append(tverbs.pop());
                s.append(" ");
                s.append(nouns.pop());
                if (i == n_tverbs - 1) {
                    while (C > 0 && nouns.size() != 0) {
                        s.append(", ");
                        s.append(nouns.pop());
                        C--;
                    }
                }
                if (i != n_tverbs - 1 && i % 2 == 1 && conjs.size() != 0) {
                    s.append(" ");
                    s.append(conjs.pop());
                    s.append(" ");
                } else
                    s.append(". ");
            }

            System.out.println(s.toString());
        }
    }
}
