package PROJECT;



import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;


class BTView extends Pane {

    private BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    private double radius = 15;
    private double vGap = 40;

    BTView(){};

    BTView(BinarySearchTree<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        Text t=new Text(40, 40, msg);
        t.setFont(new Font("Verdana",15));
        t.setFill(Color.LIMEGREEN);
        t.setStyle("-fx-font-weight: bold;");
        getChildren().add(t);
    }

    public void displayTraversal(String s, ArrayList<Integer> list){

        getChildren().clear();
        StringBuilder traversal= new StringBuilder(s);

        for(Integer i:list){
            //traversal+=Integer.toString(i)+",";
            traversal.append(i).append(",");
        }
        Text t=new Text(40, 265, traversal.toString());
        t.setFont(new Font("Verdana",15));
        t.setFill(Color.LIMEGREEN);
        t.setStyle("-fx-font-weight: bold;");
        getChildren().add(t);

    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    /** Display a subtree rooted at position (x, y) */
    private void displayTree(TreeNode<Integer> root, double x, double y, double hGap) {
        if (root.left != null) {
            Line l=new Line(x - hGap, y + vGap, x, y);
            l.setStroke(Color.LIMEGREEN);
            getChildren().add(l);

            // Draw the left subtree recursively
            displayTree(root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null) {
            // Draw a line to the right node
            Line l=new Line(x + hGap, y + vGap, x, y);
            l.setStroke(Color.LIMEGREEN);
            getChildren().add(l);
            // Draw the right subtree recursively
            displayTree(root.right, x + hGap, y + vGap, hGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.LIMEGREEN);
        circle.setStroke(Color.BLACK);
        Text t=new Text(x - 4, y + 4, root.element + "");
        t.setStyle("-fx-font-weight: bold;");
        getChildren().addAll(circle,t );
    }
}
