
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ComputerFrame extends JFrame{
    JMenuBar menubar;
    JMenu choiceGrade;
    JMenuItem grade1,grade2;
    JTextField textOne,textTwo,textResult;
    JButton getProblem,giveAnswer;
    JLabel operatorLabel,message;
    Teacher teacherZhang;
    ComputerFrame(){
        teacherZhang=new Teacher();
        teacherZhang.setMaxInteger(20);
        setLayout(new FlowLayout());
        menubar=new JMenuBar();
        choiceGrade=new JMenu("选择级别");
        grade1=new JMenuItem("幼儿级别");
        grade2=new JMenuItem("儿童级别");
        grade1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                teacherZhang.setMaxInteger(10);
            }
        });
        grade2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                teacherZhang.setMaxInteger(50);
            }
        });
        choiceGrade.add(grade1);
        choiceGrade.add(grade2);
        menubar.add(choiceGrade);
        setJMenuBar(menubar);
        textOne=new JTextField(5);//【代码1】     //创建textOne,其可见字符长是5
        textTwo=new JTextField(5);
        textResult=new JTextField(5);
        operatorLabel=new JLabel("+");
        operatorLabel.setFont(new Font("Arial",Font.BOLD,20));
        message=new JLabel("你还没有回答呢");
        getProblem=new JButton("获取题目");
        giveAnswer=new JButton("确认答案");
        add(getProblem);
        add(textOne);
        add(operatorLabel);
        add(textTwo);
        add(new Label("="));
        add(textResult);
        add(giveAnswer);
        add(message);
        textResult.requestFocus();
        textOne.setEditable(false);
        textTwo.setEditable(false);
        getProblem.setActionCommand("getProblem");
        textResult.setActionCommand("answer");
        giveAnswer.setActionCommand("answer");
        teacherZhang.setJTextField(textOne,textTwo,textResult);
        teacherZhang.setJLabel(operatorLabel,message);
        getProblem.addActionListener(teacherZhang);//【代码2】//将teacherZhang注册为getProblem的ActionEvent事件监视器
        giveAnswer.addActionListener(teacherZhang);//【代码3】//将teacherZhang注册为giveAnswer的ActionEvent事件监视器
        textResult.addActionListener(teacherZhang);//【代码4】//将teacherZhang注册为textResult的ActionEvent事件监视器
        setVisible(true);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}