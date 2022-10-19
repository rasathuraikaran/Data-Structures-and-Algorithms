//import require classes and packages  
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.HashMap;
import java.util.HashMap;

//Extends JPanel class  
public class PlotExample extends JPanel{
    //initialize coordinates  

    double marg = 0.000000000001;
    static HashMap<Integer,Long> selectionSortForWorstCase = Sort.get_execution_time_with_lenght('s','w');


    protected void paintComponent(Graphics grf){
        //create instance of the Graphics to use its methods  
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D)grf;
        //Sets the value of a single preference for the rendering algorithms.
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // get width and height
        int width = getWidth();
        int height = getHeight();

        // draw graph
        graph.draw(new Line2D.Double(marg, marg, marg, height-marg));
        graph.draw(new Line2D.Double(marg, height-marg, width-marg, height-marg));

        //find value of x and scale to plot points
        double x = (double)(width-2*marg)/(selectionSortForWorstCase.size()-1);
        double scale = (double)(height-2*marg)/getMax();

        //set color for points
        graph.setPaint(Color.RED);

        // set points to the graph
        for(int i:selectionSortForWorstCase.keySet()){
            double x1 = marg+i*x;
            double y1 = height-marg-scale*selectionSortForWorstCase.get(i);
            graph.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));
        }
    }
    //create getMax() method to find maximum value
    private int getMax(){
        int max = -Integer.MAX_VALUE;
        for(int i:selectionSortForWorstCase.keySet()){
            if(selectionSortForWorstCase.get(i)>max)
                max = Math.toIntExact(selectionSortForWorstCase.get(i));

        }
        return max;
    }

    //main() method start
    public static void main(String args[]){
        //create an instance of JFrame class
        for(int j : selectionSortForWorstCase.keySet()) {
            System.out.println("key: " + j + " value: " + selectionSortForWorstCase.get(j));
        }
        JFrame frame = new JFrame();
        // set size, layout and location for frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PlotExample());
        frame.setSize(400, 400);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }
}