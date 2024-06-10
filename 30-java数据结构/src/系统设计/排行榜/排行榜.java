package 系统设计.排行榜;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/9/28 9:46
 **/
public class 排行榜 {
//    1.实体类
//    2.根据分数和时间排序
//    3.进行筛选100
//    4.显示类
    private static void sortRanking(List<GameUser> list){
        list.sort((o1,o2)->{
            if (o1.leaderboard.getScore().equals(o2.leaderboard.getScore())){
                int i = o1.leaderboard.getNowDate().compareTo(o2.leaderboard.getNowDate());
                return i;
            }
            return (int) (o1.leaderboard.getScore()-o2.leaderboard.getScore());
        });
    }

    public static void main(String[] args) {
        GameUser user1 = new GameUser("1", new Leaderboard(99.0, new Date(2023, 9, 9)));
        GameUser user2 = new GameUser("2", new Leaderboard(99.0, new Date(2022, 9, 9)));
        LinkedList<GameUser> list = new LinkedList<>();
        list.add(user1);
        list.add(user2);
        list.forEach(k->{
            System.out.println(k.getId());
        });
        System.out.println("----------------");
        sortRanking(list);
        list.forEach(k->{
            System.out.println(k.getId());
        });
        Integer[] t=new Integer[]{999,22,987,1000};
        Arrays.sort(t,((o1, o2) -> {
            return o2-o1;
        }));
        System.out.println(Arrays.toString(t));
    }
}

class Leaderboard{
    private Double score;
    private Date nowDate;


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public Leaderboard(Double score, Date nowDate) {
        this.score = score;
        this.nowDate = nowDate;
    }
}

class GameUser{
    private String id;
//    private BigInteger ranking;
    Leaderboard leaderboard;

    public GameUser(String id, Leaderboard leaderboard) {
        this.id = id;
        this.leaderboard = leaderboard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }
}
