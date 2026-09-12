class Solution {
    class Pair {
        String v;
        double p;

        Pair(String v, double p) {
            this.p = p;
            this.v = v;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];
            map.putIfAbsent(u, new HashMap<>());
            map.putIfAbsent(v, new HashMap<>());

            map.get(u).put(v, w);
            map.get(v).put(u, 1.0 / w);
        }
        List<Double> res = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            ArrayDeque<Pair> q = new ArrayDeque<>();
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            int product = 1;
            if (!map.containsKey(src) || !map.containsKey(dest)) {
                res.add(-1.0);
                continue;
            }
            if (src.equals(dest)) {
                res.add(1.0);
                continue;
            }

            q.offer(new Pair(src, product));
            visited.add(src);
            boolean found = false;

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                String u = curr.v;
                double p = curr.p;

                for (Map.Entry<String, Double> e : map.get(u).entrySet()) {
                    String v = e.getKey();
                    double w = e.getValue();

                    if (visited.contains(v))
                        continue;
                    // if (visited.size() == map.size()) {
                    //     res.add(-1.0);
                    // }

                    if (v.equals(dest)) {
                        // p *= w;
                        res.add(p * w);
                        found = true;
                        break;

                    } else {
                        //p *= w;
                        q.offer(new Pair(v, p * w));
                        visited.add(v);
                    }

                }
                if (found) {
                    break;
                }

            }
            if(!found)res.add(-1.0);
        }
        return res.stream().mapToDouble(Double::doubleValue).toArray();
    }

}