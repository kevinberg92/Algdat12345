import java.util.*;

public class findAllPathsExample<V> extends UndirectedGraphs<V> {


    public List<List<V>> findAllPaths(V start, V end) {

        if (!graph.containsKey(start) && !graph.containsKey(end)) {
            return Collections.emptyList();
        }

        if (start.equals(end)) {
            //we do not consider cycles
            throw new IllegalArgumentException();
        }

        Deque<V> stack = new ArrayDeque<>();

        List<List<V>> paths = new ArrayList<>();

        dfs(paths, stack, start, end);

        return paths;
    }

    private void dfs(List<List<V>> paths, Deque<V> stack, V current, V end) {

        stack.push(current);

        if (isPathTo(stack, end)) {
            List<V> path = new ArrayList<>(stack);
            Collections.reverse(path);
            paths.add(path);
            return;
        }

        for (V connected : getAdjacents(current)) {
            if (stack.contains(connected)) {
                continue;
            }

            dfs(paths, stack, connected, end);
            //backtrack
            stack.pop();
        }
    }
}
