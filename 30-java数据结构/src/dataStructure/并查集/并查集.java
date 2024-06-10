package dataStructure.并查集;


public class 并查集 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int times = scanner.nextInt();

        for (int i = 0; i < times; i++) {
            int size = scanner.nextInt();
            Union union = new Union(size);
            int input = scanner.nextInt();
            for (int j = 0; j < input; j++) {
                //因为测试数据是从1开始，而我们的并查集是从数组的第0位开始
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                union.unionElements(first, second);
            }
            System.out.println(Union.group);
        }
    }
}
class Union{
    int size;
    static int group;
    int[] a;
    int[] weight;

    public Union(int size) {
        this.size=size;
        group=size;
        a=new int[size+1];
        weight=new int[size+1];
        for (int i=1;i<=size;i++){
            a[i]=i;
            weight[i]=1;
        }
    }

    /*
     * 里面是查询值，因为每次合并都会影响里面的值，但是 a[n]=a[a[n]];，这样是去找他的父亲，这样结点高度就减少了，
     *
     * */

    public int find(int n){
//        while (n!=a[n]){
//            a[n]=a[a[n]];
//            n=a[n];
//        }
        return a[n];
    }
    public void unionElements(int first,int second){
        int x=find(first);
        int y=find(second);
        if (weight[first]>weight[second]){
            a[second]=x;
            weight[first]+=weight[second];
        }else {
            a[first]=y;
            weight[second]+=weight[first];
        }
        group--;
    }
}