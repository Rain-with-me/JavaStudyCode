import java.util.*;

class Player {
    String name;
    int score;
    long timestamp; // 记录达到分数的时间戳

    public Player(String name, int score, long timestamp) {
        this.name = name;
        this.score = score;
        this.timestamp = timestamp;
    }
}

class Leaderboard {
    private PriorityQueue<Player> leaderboard;
    private Map<String, Player> playerMap;

    public Leaderboard() {
        leaderboard = new PriorityQueue<>(
                (a, b) -> a.score == b.score
                        ? Long.compare(a.timestamp, b.timestamp)
                        : Integer.compare(b.score, a.score)
        );
        playerMap = new HashMap<>();
    }

    public void addPlayer(String name, int score, long timestamp) {
        Player player = new Player(name, score, timestamp);
        leaderboard.add(player);
        playerMap.put(name, player);
    }

    public void updatePlayerScore(String name, int newScore, long newTimestamp) {
        if (playerMap.containsKey(name)) {
            Player player = playerMap.get(name);
            leaderboard.remove(player);
            player.score = newScore;
            player.timestamp = newTimestamp;
            leaderboard.add(player);
        }
    }

    public int getRank(String name) {
        if (playerMap.containsKey(name)) {
            Player player = playerMap.get(name);
//            return leaderboard.size() - leaderboard.headSet(player).size() + 1;
        }
        return -1; // 玩家不在排行榜中
    }

    public List<Player> getTop100() {
        List<Player> top100 = new ArrayList<>();
        int count = 0;
        for (Player player : leaderboard) {
            if (count >= 100) {
                break;
            }
            top100.add(player);
            count++;
        }
        return top100;
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();

        // 添加玩家
        leaderboard.addPlayer("Alice", 100, System.currentTimeMillis());
        leaderboard.addPlayer("Bob", 150, System.currentTimeMillis());
        leaderboard.addPlayer("Charlie", 120, System.currentTimeMillis());
        leaderboard.addPlayer("David", 120, System.currentTimeMillis());

        // 更新玩家分数
        leaderboard.updatePlayerScore("Bob", 200, System.currentTimeMillis());

        // 获取排名
        int rank = leaderboard.getRank("Bob");
        System.out.println("Bob's rank: " + rank);

        // 获取前100名
        List<Player> top100 = leaderboard.getTop100();
        System.out.println("Top 100 players:");
        for (Player player : top100) {
            System.out.println(player.name + " - Score: " + player.score);
        }
    }
}
