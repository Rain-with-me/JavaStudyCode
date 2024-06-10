/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/10/18 9:35
 **/



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("all")
public class CalendarDiy extends JFrame implements ActionListener {

    JPanel head=new JPanel();//上部容器
    JPanel body=new JPanel();//中部容器
    JPanel foot=new JPanel();//下部容器

    Calendar calendar=Calendar.getInstance();
    int dayNow=calendar.get(Calendar.DATE);
    int monthNow=calendar.get(Calendar.MONTH)+1;
    int yearNow=calendar.get(Calendar.YEAR);

    private JTextField text;//查询年份
    int year = calendar.get(Calendar.YEAR);//获取当前查询年份，默认为当前年份

    private JTextField text1;//查询月份
    int month = calendar.get(Calendar.MONTH)+1;//获取当前查询月份，默认为当前月份

    private CalendarDiy(){//构造方法
        //主要参数设置
        setTitle("万年历");
        setSize(600,480);
        setLocationRelativeTo(null);//窗体居中
        setResizable(false);//关闭窗体大小可调
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //界面布局
        //上部容器
        head.setLayout(new FlowLayout());
        JButton searchJButton=new JButton("查询年份");
        searchJButton.setFont(new Font("SimHei",Font.BOLD,15));
        searchJButton.setPreferredSize(new Dimension(100,35));
        searchJButton.setBorder(null);
        JButton upJButton=new JButton("上月");
        upJButton.setFont(new Font("SimHei",Font.BOLD,15));
        upJButton.setBorder(null);
        upJButton.setPreferredSize(new Dimension(50,35));
        JButton downJButton=new JButton("下月");
        downJButton.setFont(new Font("SimHei",Font.BOLD,15));
        downJButton.setBorder(null);
        downJButton.setPreferredSize(new Dimension(50,35));
        JLabel jLabelShow=new JLabel("请输入日期 年份：");
        jLabelShow.setFont(new Font("SimHei",Font.BOLD,15));
        JLabel jLabelShow1=new JLabel("月份：");
        jLabelShow1.setFont(new Font("SimHei",Font.BOLD,15));

        text=new JTextField(4);
        text1=new JTextField(2);
        head.add(jLabelShow);
        head.add(text);
        head.add(jLabelShow1);
        head.add(text1);
        head.add(searchJButton);
        head.add(upJButton);
        head.add(downJButton);
        searchJButton.addActionListener(this);
        upJButton.addActionListener(this);
        downJButton.addActionListener(this);

        //中部容器
        body.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);//每行添加组件的顺序
        body.setLayout(new GridLayout(7,7,1,1));
        getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));

        //下部容器
        foot.setSize(new Dimension(500,200));
        foot.setLayout(new FlowLayout(FlowLayout.CENTER));


        Container integralContainer=this.getContentPane();//创建全局容器
        integralContainer.add(head,BorderLayout.NORTH);
        integralContainer.add(body,BorderLayout.CENTER);
        integralContainer.add(foot,BorderLayout.SOUTH);
    }



//    @Override
    public void actionPerformed(ActionEvent actionEvent) {//监听事件
        String label=actionEvent.getActionCommand();
        switch (label) {
            case "查询年份":
                System.out.println("进入查询");
                try {
                    year = Integer.parseInt(text.getText());
                    month=Integer.parseInt(text1.getText());
                    getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));
                }catch (NumberFormatException e){
                    System.out.println("非数字异常已被捕获，进程正常！");
                }
                break;
            case "上月":
                System.out.println("进入上月");
                if (month==1){
                    year--;
                    month=12;
                }else
                    month--;
                getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));
                break;
            case "下月":
                System.out.println("进入下月");
                if (month==12){
                    year++;
                    month=1;
                }else
                    month++;
                getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));
                break;
        }
    }

    private void getDateInfo(String date) {//获取日期信息
        try {
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM");// 日期格式化类 2023-9
            Date parse = dFormat.parse(date);// 把字符串类型的日期转换为date类型的
            Calendar calendar = new GregorianCalendar();// 创建一个公历类的实例
            calendar.setTime(parse);// 把格式化好的日期对象放进Calendar
            calendar.set(Calendar.DATE, 1);//重置日期为第一天
            // 获取这个月的第一天是周几
            int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println("week"+weekDay);

            // 获取每个月最大的天数
            int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            System.out.println("max"+maxDay);
            body.removeAll();
            body.repaint();

            String[] title = {"日", "一", "二", "三", "四", "五", "六"};
            for (String label : title) {
                JLabel jLabel = new JLabel(label);
                jLabel.setHorizontalAlignment(JLabel.CENTER);
                jLabel.setBorder(BorderFactory.createLineBorder(Color.black));
                jLabel.setFont(new Font("SimHei", Font.BOLD, 18));
                body.add(jLabel);
                body.revalidate();
            }

//            TODO 42是因为日历6*7=42格子  weekDay下界  maxDay + weekDay - 1上界
            for (int i = 1; i <= 42; i++) {
                if (i >= weekDay && i <= (maxDay + weekDay - 1)) {
                    JLabel jLabel = new JLabel(String.valueOf(i - weekDay + 1));
                    jLabel.setFont(new Font("SimHei", Font.BOLD, 15));
                    jLabel.setHorizontalAlignment(JLabel.CENTER);
                    if ((year==yearNow)&&(month==monthNow)&&(i - weekDay + 1==dayNow)){
                        jLabel.setBorder(BorderFactory.createLineBorder(Color.CYAN));
                    }
                    body.add(jLabel);
                    body.revalidate();
                } else {
                    JLabel jLabel = new JLabel("");
                    jLabel.setHorizontalAlignment(JLabel.CENTER);
                    jLabel.setFont(new Font("SimHei", Font.BOLD, 15));
                    body.add(jLabel);
                    body.revalidate();
                }
            }
//            TODO 年份的限制
            if (year >= 1900 && year <= 2100) {
                foot.removeAll();
                foot.repaint();
                JLabel show = new JLabel(year + "年" + month + "月");
                show.setFont(new Font("SimHei", Font.BOLD, 20));
                foot.add(show);//将标签添加到下部容器
                foot.revalidate();
            }
        }catch (ParseException e){
            System.out.println("日期异常亦已被捕获，进程正常！");
        }
    }

    public static void main(String[] args){//主方法
        JFrame jFrame=new CalendarDiy();
        jFrame.setVisible(true);
    }
}
