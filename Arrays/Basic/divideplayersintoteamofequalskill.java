import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {

        // approach one
        // Arrays.sort(skill);
        // long teams = skill.length/2;
        // long totalsum = Arrays.stream(skill).sum();
        // long reqsum = totalsum/teams;
        // int i = 0;
        // int j = skill.length -1;
        // long chem = 0;
        // while(i<=j)
        // {
        // if(skill[i]+skill[j]!=reqsum)
        // {
        // return -1;
        // }
        // else
        // {
        // chem+=skill[i]*skill[j];
        // }
        // i++;
        // j--;
        // }

        // return chem;
        // approach 2
        HashMap<Integer, Integer> hm = new HashMap<>();
        long teams = skill.length / 2;
        long totalsum = Arrays.stream(skill).sum();
        if (totalsum % teams != 0) {
            return -1;
        }
        long reqsum = totalsum / teams;
        for (int num : skill) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        long chem = 0;
        for (int i = 0; i < skill.length; i++) {
            int currentSkill = skill[i];
            if (hm.get(currentSkill) == 0) {
                continue;
            }
            int diff = (int) (reqsum - currentSkill);
            if (!hm.containsKey(diff) || hm.get(diff) == 0) {
                return -1; // Invalid pairing
            }
            hm.put(currentSkill, hm.get(currentSkill) - 1);
            hm.put(diff, hm.get(diff) - 1);

            // Add to the chemistry
            chem += (long) currentSkill * diff;
        }

        return chem;

    }
}

