package ladMS;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SwingApi.calculate();
        Equation targetFunction =  new Equation(28,13,0);
        int countOfEquation = 6;
        List<Equation> limits = new ArrayList<>();
        int s;
        limits.add(new Equation(1,0,0,1));
        limits.add(new Equation(2,1,10,1));
        limits.add(new Equation(0,2,0,1));
        limits.add(new Equation(-4,-3,48,1));
        limits.add(new Equation(1,0,17,0));
        limits.add(new Equation(2,1,58,0));
        List<Point> pointsArr = new ArrayList<>();
        int i=0;
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
                if (!SwingApi.checkValues(pointsArr.get(j), limits.get(k))) {
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
        double minN;
        double maxN;
        double func;

        minN = maxN = targetFunction.getFunctionValue(pointsArr.get(0));
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
        System.out.println("Макс значення "+maxN+" в точці " + pointsArr.get(maxPoint).x+" , "
                + pointsArr.get(maxPoint).y);

        System.out.println("Мін значення "+minN+" в точці " + pointsArr.get(minPoint).x+" , "
                + pointsArr.get(minPoint).y);

    }


}
