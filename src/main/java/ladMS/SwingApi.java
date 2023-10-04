package ladMS;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class SwingApi {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JTextField mx1;
    private static JTextField mx2;
    private static JTextField[] x1;
    private static JLabel []labelX1;
    private static JTextField[] x2;
    private static JLabel []labelX2;
    private static JTextField[] b;
    private static JComboBox[] equal;
    private static JButton calculate;
    private static int count = 0;
    private static JPanel calculatePanel;
    private static JTextField enterCountOfLimitation;

    private static List<Equation> limits;
    private static List<Point> pointsArr;

    private static void createFrame(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        frame = new JFrame("Лабораторна робота 1");
        frame.setBounds(dimension.width/2- 500,dimension.height/2 - 350,1000,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void createTopPanel(){
        JPanel top = new JPanel();
        top.setBackground(Color.getHSBColor(22,74,75));
        top.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(25,74,75),18));
        JLabel label = new JLabel("Лабораторна робота №1");
        label.setFont(new Font("font",Font.ITALIC,20));
        top.add(label,BorderLayout.CENTER);
        frame.add(top,BorderLayout.NORTH);
    }

    private static void createMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.yellow);

        Label counfOfLimitation = new Label("Вкажіть кількість обмежень:");
        counfOfLimitation.setFont(new Font("font",Font.BOLD,16));
        counfOfLimitation.setBounds(20,20,230,50);
        enterCountOfLimitation = new JTextField();
        enterCountOfLimitation.setBounds(260,33,30,22);
        enterCountOfLimitation.setFont(new Font("font",Font.BOLD,14));

        JLabel mainFunction = new JLabel("F(x):");
        mainFunction.setFont(new Font("font",Font.BOLD,16));
        mainFunction.setBounds(345,30,45,22);
        JLabel mainX1 = new JLabel("x1");
        mainX1.setFont(new Font("font",Font.BOLD,16));
        mainX1.setBounds(390,30,30,22);
        mx1 = new JTextField();
        mx1.setBounds(410,30,30,22);
        JLabel mainX2 = new JLabel("x2");
        mainX2.setFont(new Font("font",Font.BOLD,16));
        mainX2.setBounds(450,30,30,22);
        mx2 = new JTextField();
        mx2.setBounds(470,30,30,22);
        mainFunction.setFont(new Font("font",Font.BOLD,16));

        JButton createMenu = new JButton("Створити");
        createMenu.setBackground(Color.CYAN);
        createMenu.setBounds(520,26,100,30);

        JButton removeButton = new JButton("Очистити");
        removeButton.setBackground(Color.cyan);
        removeButton.setBounds(625,26,100,30);

        mainPanel.add(createMenu);
        mainPanel.add(mainFunction);
        mainPanel.add(mainX1);
        mainPanel.add(mx1);
        mainPanel.add(mainX2);
        mainPanel.add(mx2);

        calculatePanel = new JPanel();
        calculatePanel.setLayout(null);
        calculatePanel.setBackground(Color.white);
        mainPanel.add(removeButton);

        JScrollPane scroll = new JScrollPane(calculatePanel); // створєм скролл;
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20,70,710,430);
        mainPanel.add(scroll,BorderLayout.EAST);

        //----------------------------------------------

        createMenu.addActionListener(e -> {
           createInputArea();
        });

        removeButton.addActionListener(e->{
            removeInputArea();
        });

        mainPanel.add(enterCountOfLimitation);
        mainPanel.add(counfOfLimitation);
        frame.add(mainPanel);

        calculate = new JButton("Обчислити");
        calculate.setBackground(Color.white);
        calculate.setBounds(20,520,100,50);
        mainPanel.add(calculate);
    }

    private static void createInputArea(){

        try {
            count = Integer.parseInt(enterCountOfLimitation.getText());
        }catch (Exception ex){
            JFrame f= new JFrame();
            JOptionPane.showMessageDialog(f,"Помилка з вводом кількості обмежень","Результат",JOptionPane.ERROR_MESSAGE);
        }
        x1 = new JTextField[count];
        labelX1 = new JLabel[count];
        x2 = new JTextField[count];
        labelX2 = new JLabel[count];


        String[] lim = new String[]{"<=",">="};
        equal = new JComboBox[count];

        JLabel []labelB = new JLabel[count];
        b = new JTextField[count];
        int n=0;

        for (int i = 0; i < count; i++) {
            labelX1[i] = new JLabel("x1");
            labelX1[i].setBounds(20,20+n,30,22);
            labelX1[i].setFont(new Font("font",Font.BOLD,16));
            x1[i] = new JTextField();
            x1[i].setBounds(40, 20+n,30,22);
            n+=40;
        }

        n=0;
        for (int i = 0; i < count; i++) {
            labelX2[i] = new JLabel("x2");
            labelX2[i].setBounds(80,20+n,30,22);
            labelX2[i].setFont(new Font("font",Font.BOLD,16));
            x2[i] = new JTextField();
            x2[i].setBounds(100, 20+n,30,22);
            n+=40;
        }

        n=0;
        for (int i = 0; i < count; i++) {
            equal[i] = new JComboBox<>(lim);
            equal[i].setEditable(true);
            equal[i].setBounds(160,20+n,60,22);
            equal[i].setFont(new Font("font",Font.BOLD,14));
            n+=40;
        }

        n=0;
        for (int i = 0; i < count; i++) {
            labelB[i] = new JLabel("b");
            labelB[i].setBounds(250,20+n,30,22);
            labelB[i].setFont(new Font("font",Font.BOLD,16));
            b[i] = new JTextField();
            b[i].setBounds(270, 20+n,30,22);
            n+=40;
        }

        for (int i = 0; i < count; i++) {
            calculatePanel.add(x1[i]);
            calculatePanel.add(labelX1[i]);
            calculatePanel.add(x2[i]);
            calculatePanel.add(labelX2[i]);
            calculatePanel.add(equal[i]);
            calculatePanel.add(labelB[i]);
            calculatePanel.add(b[i]);
        }
        calculatePanel.updateUI();
    }

    private static void removeInputArea(){
        calculatePanel.removeAll();
        calculatePanel.updateUI();

        for (int i = 0; i < limits.size(); i++) {
            limits.remove(i);
        }
        for (int i = 0; i < pointsArr.size(); i++) {
            pointsArr.remove(i);
        }
    }

    private static void createMenu(){
        createFrame();
        createTopPanel();
        createMainPanel();
    }




    public static boolean checkValues(Point point, Equation equation) {
        double func = equation.getFunctionValue(point);
        double sign = equation.getSign();
        if (point.x < 0 || point.y < 0)
            return false;
        if (sign == 1)
            return (func >= 0);
        if (sign == 0)
            return (func <= 0);
        return false;
    }


    public static void calculate() {
        createMenu();
        limits = new ArrayList<>();

        calculate.addActionListener(e -> {
            int r;
            Equation targetFunction = null;
            try {
                targetFunction = new Equation(Double.parseDouble(mx1.getText()), Double.parseDouble(mx2.getText()), 0);
                for (int i = 0; i < count; i++) {
                    r = equal[i].getSelectedIndex();
                    limits.add(new Equation(Double.parseDouble(x1[i].getText()), Double.parseDouble(x2[i].getText()), Double.parseDouble(b[i].getText()), r));
                }
            }catch (Exception d){
                JFrame f= new JFrame();
                JOptionPane.showMessageDialog(f,"Помилка з вводом даних","Результат",JOptionPane.ERROR_MESSAGE);
            }
            pointsArr = new ArrayList<>();
            int i=0;
            int countOfEquation = count;
            while (i < countOfEquation * 2) {
                Point temp = new Point();
                temp.x = 0;
                temp.y = limits.get(i / 2).getC() / limits.get(i / 2).getB();
                pointsArr.add(temp);
                i++;
                temp.y = 0;
                temp.x = limits.get(i / 2).getC() / limits.get(i / 2).getA();
                pointsArr.add(temp);
                i++;
            }

            for (int lim1 = 0; lim1 < countOfEquation; lim1++)
                for (int lim2 = lim1 + 1; lim2 < countOfEquation; lim2++, i++)
                    pointsArr.add(limits.get(lim1).getIntersection(limits.get(lim2)));
            for (int j = 0; j < i; j++) {
                int flag = 0;
                for (int k = 0; k < countOfEquation; k++) {
                    if (!checkValues(pointsArr.get(j), limits.get(k))) {
                        flag++;
                        break;
                    }
                }
                if (flag!=0) {
                    pointsArr.remove(j);
                    j--;
                    i--;
                }
            }
            int minPoint = 0;
            int maxPoint = 0;
            double minN=0;
            double maxN=0;
            double func;
            System.out.println("Точки перетину:");
            for (Point point:pointsArr){
                System.out.println(point.x+" , "+point.y);
            }


            try {
                minN = maxN = targetFunction.getFunctionValue(pointsArr.get(0));
            }catch (Exception ex){
                JFrame f= new JFrame();
                JOptionPane.showMessageDialog(f,"Результату немає","Результат",JOptionPane.WARNING_MESSAGE);
            }
            i = pointsArr.size();
            for (int j = 1; j < i; j++) {
                func = targetFunction.getFunctionValue(pointsArr.get(j));
                if (func > maxN) {
                    maxN = func;
                    maxPoint = j;
                }
                if (func < minN) {
                    minN = func;
                    minPoint = j;
                }
            }
            JFrame resultPanel = new JFrame();
            JOptionPane.showMessageDialog(resultPanel,"Макс = "+maxN+" в точках ["+pointsArr.get(maxPoint).x+" , "
                    + pointsArr.get(maxPoint).y+"]"+"\n"+
                    "Мін="+minN+" в точках [" + pointsArr.get(minPoint).x+" , "
                    + pointsArr.get(minPoint).y+"]");
        });
    }

}
