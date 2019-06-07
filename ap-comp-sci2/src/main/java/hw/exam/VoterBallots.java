package hw.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class VoterBallots {

    private Map<String, Integer> voteCount;
    private int maxVotes;

    public VoterBallots(List<Set<String>> ballotList) {
        voteCount = new HashMap<>();
        maxVotes = 0;
        for(Set<String> i : ballotList) {
            for(String j : i) {
                if(voteCount.get(j) == null) {
                    voteCount.put(j, 1);
                    if(maxVotes == 0) maxVotes = 1;
                }
                voteCount.put(j, voteCount.get(j) + 1);
                if(voteCount.get(j) > maxVotes) maxVotes = voteCount.get(j);
            }
        }
    }

    private Integer maxVotes() {
        return maxVotes;
    }

    public Set<String> candidatesWithMost() {
        Set<String> ans = new HashSet<>();
        for(String i : voteCount.keySet()) {
            if(voteCount.get(i) == maxVotes()) ans.add(i);
        }
        return ans;
    }

}
