package 网站题;

/**
 * @description: 题目： 哈夫曼编码大全
 * 描述：
 * 关于哈夫曼树的建立，编码，解码。
 * 输入
 * 第一行输入数字N，代表总共有多少个字符以及权值
 * 第二第三行分别是一行字符串，以及每个字符对应的权值
 * 接下来输入一个数M，表示接下来有M行字符串，要求你对每个字符串进行编码
 * 再输入一个数X，表示接下来有X行编码，要求你对每行编码进行解码

 * 输出
 * 第一行输出所有节点的权重
 * 接下来输出N行，每行以 “a:001”的格式输出每个字符对应的编码
 * 接着输出M行，对输入的字符串的编码结果
 * 最后，输出X行的解码结果
 *
 * 输入样例
 * 6
 * abcdef
 * 50 10 5 5 20 10
 * 2
 * abcdef
 * defabaabbc
 * 2
 * 011001100100110110101101100
 * 1100011000110101100101100
 *
 * 输出样例
 * 50 10 5 5 20 10 10 20 30 50 100
 * a:0
 * b:100
 * c:1100
 * d:1101
 * e:111
 * f:101
 * 010011001101111101
 * 11011111010100001001001100
 * accbdfadb
 * cacadacfb
 *
 * @author: HaHa
 * @time: 2022/5/6 16:24
 */
import java.util.*;

public class 哈夫曼编码 {
    static Map<Character,String> map=new HashMap<Character,String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.next();
        List<Node> nodes=new ArrayList<Node>();
        List<Integer> weight=new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int num=sc.nextInt();
            weight.add(num);
            Node temp=new Node(str.charAt(i),num);
            nodes.add(temp);
        }

//     root是最上面的点,相当于样例中的100
        Node root=creteHuffmanTree(nodes,weight);
        for (int i = 0; i < weight.size(); i++) {
            if (i!=weight.size()-1) {
                System.out.print(weight.get(i) + " ");
            }else {
                System.out.println(weight.get(i));
            }
        }

        //生成编码
        HuffmanCode(root,"","");

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i)+":"+map.get(str.charAt(i)));
        }

        //打印编码
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            String s=sc.next();
            for (int j = 0; j < s.length(); j++) {
                System.out.print(map.get(s.charAt(j)));
            }
            System.out.println();
        }


        //解码，下面把原来的key和val互换，因为他需要截取(0,1)找，然后一直加
        Map<String,Object> map2=new HashMap<>();
        map.forEach((k,v)->{
            map2.put(v,k);
        });

        int num=sc.nextInt();
        while (num-->0){
            String s= sc.next();
            int left=0,right=1;
            while (right<=s.length()) {
                String key=s.substring(left, right);
                if (map2.get(key) != null) {
                    System.out.print(map2.get(key));
                    left = right;
                } else {
                    right++;
                }
            }
            System.out.println();
        }
    }


    public static Node creteHuffmanTree(List<Node> nodes,List<Integer> weight){
        while (nodes.size()>1){
            Collections.sort(nodes,(o1,o2)->{
                return o1.weight- o2.weight;
            });
            Node left=nodes.get(0);
            Node right=nodes.get(1);
            Node parent=new Node(null,left.weight+ right.weight);
            weight.add(parent.weight);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

// strb是保存上一个的，如果不是叶子结点就一直递归，是就添加到map集合
    private static void HuffmanCode(Node node,String code,String strb){
        String str=strb;
        str+=code;
        if (node.sign==null){
            HuffmanCode(node.left,"0",str);
            HuffmanCode(node.right,"1",str);
        }else {
            map.put(node.sign,str);
        }
    }
}

//  weight是权值，sign是字符
class Node{
    int weight;
    Character sign;
    Node left;
    Node right;
    public Node(Character sign,int weight){
        this.sign=sign;
        this.weight=weight;
    }
}